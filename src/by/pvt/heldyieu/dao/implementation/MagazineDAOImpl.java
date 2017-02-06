package by.pvt.heldyieu.dao.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.dao.AbstractDAO;
import by.pvt.heldyieu.dao.factory.DaoFactory;
import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.enums.CategoryType;
import by.pvt.heldyieu.exception.InvalidValueException;

public class MagazineDAOImpl extends AbstractDAO<Magazine, Integer> {
	
	private static final Logger LOGGER = Logger.getLogger(MagazineDAOImpl.class);
	private static MagazineDAOImpl INSTANCE;
	
	public MagazineDAOImpl() {
		super("sqlMagazine");
		LOGGER.info("Initialize resource for MagazineDAOImpl and connection to database");
	}
	
	public static MagazineDAOImpl getInstance(){
		if (INSTANCE == null) {
			try {
				INSTANCE = (MagazineDAOImpl) new DaoFactory().createDao("magazineDao");
			} catch (InvalidValueException e) {
				LOGGER.error(e.getMessage());
			}
		}
		return INSTANCE;
	}

	@Override
	public String getSelectQuery() {
		return resmanager.getProperty("selectMagazine");
	}

	@Override
	public String getCreateQuery() {
		return resmanager.getProperty("createMagazine");
	}

	@Override
	public String getUpdateQuery() {
		return resmanager.getProperty("updateMagazineById");
	}

	@Override
	public String getDeleteQuery() {
		return resmanager.getProperty("deleteMagazineById");
	}
	
	public String getFindNameQuery() {
		return resmanager.getProperty("findMagazineByName");
	}
	
	@Override
	public String getSelectAllQuery() {
		return resmanager.getProperty("selectAll");
	}

	@Override
	protected Magazine parseResultSet(ResultSet rs)
			throws SQLException {
		Magazine magazine = new Magazine();
		try {
			if(rs.next()) {
				magazine.setId(rs.getInt("id"));
				magazine.setName(rs.getString("name"));
				magazine.setType(CategoryType.values()[rs.getInt("category_type")-1]);
				magazine.setPrice(rs.getDouble("price"));
            }
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
			System.out.println(ERROR_SQL_EXECUTE);
		}
		return magazine;
	}
	
	@Override
	protected List<Magazine> parseResultSetList(ResultSet rs)
			throws SQLException {
		List<Magazine> list = new ArrayList<Magazine>();
		while (rs.next()) {
			Magazine magazine = new Magazine();
			magazine.setId(rs.getInt("id"));
			magazine.setName(rs.getString("name"));
			magazine.setType(CategoryType.values()[rs.getInt("category_type")-1]);
			magazine.setPrice(rs.getDouble("price"));
			list.add(magazine);
		}
		return list;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			Magazine object) throws SQLException {
		statement.setString(1, object.getName());
		statement.setInt(2, object.getType().ordinal()+1);
		statement.setDouble(3, object.getPrice());
		
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			Magazine object) throws SQLException {
		statement.setString(1, object.getName());
		statement.setInt(2, object.getType().ordinal()+1);
		statement.setDouble(3, object.getPrice());
		statement.setInt(4, object.getId());
	}
	
	public Magazine findMagazineByName(String name){
		Magazine magazine = null;
		ResultSet result = null;
		try(PreparedStatement statement = connect.prepareStatement(getFindNameQuery())) {
			statement.setString(1, name);
			result = statement.executeQuery();
			magazine = parseResultSet(result);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			System.out.println(ERROR_SQL_EXECUTE);
		}
		 finally {
				try {
					result.close();
				} catch (SQLException e) {
					LOGGER.info(e.getMessage());
					System.out.println(ERROR_CLOSING_RESULTSET);
				}
			}
		return magazine;
	}
}
