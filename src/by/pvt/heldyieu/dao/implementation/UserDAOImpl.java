package by.pvt.heldyieu.dao.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.dao.generic.AbstractDAO;
import by.pvt.heldyieu.entity.User;

public class UserDAOImpl extends AbstractDAO<User, Integer> {
	private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

	public UserDAOImpl() {
		super("sqlUser");
		LOGGER.info("Initialize resource for UserDAOImpl and connection to database");
	}

	@Override
	public String getSelectQuery() {
		return resmanager.getProperty("selectUser");
	}

	@Override
	public String getCreateQuery() {
		return resmanager.getProperty("createUser");
	}

	@Override
	public String getUpdateQuery() {
		return resmanager.getProperty("updateUserById");
	}

	@Override
	public String getDeleteQuery() {
		return resmanager.getProperty("deleteUserById");
	}

	@Override
	protected User parseResultSet(ResultSet rs, User user) throws SQLException {
		if (rs.next()) {
			user.setId(rs.getInt(1));
		}
		else {
			LOGGER.error("Failed to create user, no ID obtained.");
		}
		return user;
	}
	
	@Override
	protected List<User> parseResultSetList(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			User object) throws SQLException {
		statement.setInt(1, object.getUserType().ordinal()+1);
		statement.setString(2, object.getFirstName());
		statement.setString(3, object.getLastName());
		statement.setString(4, object.getEmail());
		statement.setString(5, object.getPassword());
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			User object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
