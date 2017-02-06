package by.pvt.heldyieu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.apache.log4j.Logger;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import by.pvt.heldyieu.dao.connection.ConnectionFactory;
import by.pvt.heldyieu.interfaces.Constants;
import by.pvt.heldyieu.interfaces.GenericDAO;
import by.pvt.heldyieu.interfaces.Identified;
import by.pvt.heldyieu.resources.ResourceManager;


public abstract class AbstractDAO<T extends Identified, PK extends Number> implements GenericDAO<T, PK>, Constants{
	private static final Logger LOGGER = Logger.getLogger(AbstractDAO.class);
	protected Connection connect;
	protected ResourceManager resmanager;
	
	public AbstractDAO(String resource) {
        try {
			connect = ConnectionFactory.getInstance().getConnection();
			resmanager = new ResourceManager(resource);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
    }
	
    public abstract String getSelectQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();
    
    public abstract String getSelectAllQuery();

    protected abstract T parseResultSet(ResultSet rs) throws SQLException;
    
    protected abstract List<T> parseResultSetList(ResultSet rs) throws SQLException;

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws SQLException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws SQLException;

    @Override
    public T create(T object) throws SQLException {
        LOGGER.info("Try to create new user in USER database");
        try (PreparedStatement statement = connect.prepareStatement(getCreateQuery(), Statement.RETURN_GENERATED_KEYS)) {
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
            	LOGGER.info("On persist modify more then 1 record: " + count);
                System.out.println(ERROR_CREATE_RESULTSET);
            } else {
				LOGGER.info("User creation successful");
				try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						object.setId(generatedKeys.getInt(1));
					}
					else {
						LOGGER.error("Failed to create user, no ID obtained.");
						System.out.println(ERROR_GET_ID);
					}
				}					
				}
			} catch (MySQLIntegrityConstraintViolationException e) {
				LOGGER.info(e.getMessage(), e);
				System.out.println(ERROR_INTEGRITY_CONSTRAINT_VIOLATION);
			}
        
        return object;
    }

    @Override
    public T readById(Number key) throws SQLException {
    	LOGGER.info("Find object by id and return it");
    	
        T tempEntity = null;
        ResultSet rs = null;
        try (PreparedStatement statement = connect.prepareStatement(getSelectQuery())) {
            statement.setInt(1, (Integer)key);
            rs = statement.executeQuery();
            tempEntity = parseResultSet(rs);
        } catch (Exception e) {
        	LOGGER.info(e.getMessage(), e);
            System.out.println(ERROR_SQL_EXECUTE);
        }
        finally {
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.info(e.getMessage(), e);
				System.out.println(ERROR_CLOSING_RESULTSET);
			}
		}
        return tempEntity;
    }

    @Override
    public void update(T object) throws SQLException {
        try (PreparedStatement statement = connect.prepareStatement(getUpdateQuery());) {
            prepareStatementForUpdate(statement, object); 
            int count = statement.executeUpdate();
            if (count != 1) {
            	LOGGER.info("On update modify more then 1 record: " + count);
            }
        } catch (Exception e) {
        	LOGGER.info(e.getMessage(), e);
            System.out.println(ERROR_SQL_EXECUTE);
        }
    }

    @Override
    public void delete(T object) throws SQLException {
        try (PreparedStatement statement = connect.prepareStatement(getDeleteQuery())) {
            statement.setInt(1, object.getId());
            int count = statement.executeUpdate();
            if (count != 1) {
            	LOGGER.info("On delete modify more then 1 record: " + count + object.toString());
                System.out.println(ERROR_DELETE_RESULTSET);
            }
            statement.close();
        } catch (Exception e) {
        	LOGGER.info(e.getMessage(), e);
            System.out.println(ERROR_SQL_EXECUTE);
        }
    }

    @Override
    public List<T> getAll() {
        List<T> list = null;
        ResultSet rs = null;
        try (PreparedStatement statement = connect.prepareStatement(getSelectAllQuery())) {
            rs = statement.executeQuery();
            list = parseResultSetList(rs);
        } catch (Exception e) {
            LOGGER.info(e.getMessage(), e);
            System.out.println(ERROR_SQL_EXECUTE);
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.info(e.getMessage(), e);
				System.out.println(ERROR_CLOSING_RESULTSET);
			}
		}
		return list;
    }
}
