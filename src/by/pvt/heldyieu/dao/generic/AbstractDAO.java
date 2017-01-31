package by.pvt.heldyieu.dao.generic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.dao.connection.ConnectionFactory;
import by.pvt.heldyieu.interfaces.GenericDAO;
import by.pvt.heldyieu.interfaces.Identified;
import by.pvt.heldyieu.resources.ResourceManager;


public abstract class AbstractDAO <T extends Identified, PK extends Integer> implements GenericDAO<T, PK>{
	private static final Logger LOGGER = Logger.getLogger(AbstractDAO.class);
	protected Connection connect;
	protected ResourceManager resmanager;
	
	public AbstractDAO(String resource) {
        try {
			connect = ConnectionFactory.getInstance().getConnection();
			new ResourceManager();
			resmanager = ResourceManager.getInstance(resource);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
    public abstract String getSelectQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    protected abstract T parseResultSet(ResultSet rs, T Object) throws SQLException;
    
    protected abstract List<T> parseResultSetList(ResultSet rs) throws SQLException;

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws SQLException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws SQLException;

    @Override
    public T create(T object) throws SQLException {
        LOGGER.info("Try to create new user in USER database");
        String sql = getCreateQuery();
        try (PreparedStatement statement = connect.prepareStatement(sql)) {
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
            	LOGGER.info("On persist modify more then 1 record: " + count);
                throw new SQLException("On persist modify more then 1 record: " + count);
            } else {
				LOGGER.info("User creation successful");

				try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						object.setId(generatedKeys.getInt(1));
					}
					object = parseResultSet(generatedKeys, object);					
				}
			}
        } catch (Exception e) {
        	LOGGER.info(e.getMessage());
            throw new SQLException(e);
        }
        return object;
    }

    @Override
    public T getByPK(Integer key) throws SQLException {
    	LOGGER.info("Find object by id and return it");
        T tempEntity = null;
        String sql = getSelectQuery();
        sql += " WHERE id = ?";
        try (PreparedStatement statement = connect.prepareStatement(sql)) {
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            tempEntity = parseResultSet(rs, tempEntity);
        } catch (Exception e) {
            throw new SQLException(e);
        }
        if (tempEntity == null) {
            throw new SQLException("Record with PK = " + key + " not found.");
        }
        
        return tempEntity;
    }

    @Override
    public void update(T object) throws SQLException {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connect.prepareStatement(sql);) {
            prepareStatementForUpdate(statement, object); // заполнение аргументов запроса оставим на совесть потомков
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new SQLException("On update modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public void delete(T object) throws SQLException {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connect.prepareStatement(sql)) {
            try {
                statement.setInt(1, object.getId());
            } catch (Exception e) {
                throw new SQLException(e);
            }
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new SQLException("On delete modify more then 1 record: " + count);
            }
            statement.close();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    @Override
    public List<T> getAll() {
        List<T> list = null;
        String sql = getSelectQuery();
        try (PreparedStatement statement = connect.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSetList(rs);
        } catch (Exception e) {
            try {
				throw new SQLException(e);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        return list;
    }
	
}
