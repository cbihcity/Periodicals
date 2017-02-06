package by.pvt.heldyieu.dao.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.dao.AbstractDAO;
import by.pvt.heldyieu.dao.factory.DaoFactory;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.enums.UserType;
import by.pvt.heldyieu.exception.InvalidValueException;

public class UserDAOImpl extends AbstractDAO<User, Integer> {
	private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
	private static UserDAOImpl INSTANCE;
	
	public UserDAOImpl() {
		super("sqlUser");
		LOGGER.info("Initialize resource for UserDAOImpl and connection to database");
	}
	
	public static UserDAOImpl getInstance(){
		if (INSTANCE == null) {
			try {
				INSTANCE = (UserDAOImpl) new DaoFactory().createDao("userDao");
			} catch (InvalidValueException e) {
				LOGGER.error(e.getMessage());
			}
		}
		return INSTANCE;
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
	
	public String getFindEmailQuery() {
		return resmanager.getProperty("findUserByEmail");
	}
	
	@Override
	public String getSelectAllQuery() {
		return resmanager.getProperty("selectAll");
	}
	
	@Override
	protected User parseResultSet(ResultSet rs) throws SQLException {
		User user = null;
		try {
			if(rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setUserType(UserType.values()[rs.getInt("user_type_id") - 1]);
            }
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
			System.out.println(ERROR_SQL_EXECUTE);
		}
		return user;
	}
	
	@Override
	protected List<User> parseResultSetList(ResultSet rs) throws SQLException {
		List<User> listUsers = new ArrayList<User>();
		while (rs.next()) {
			User user = new User();
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setUserType(UserType.values()[rs.getInt("user_type_id") - 1]);
            listUsers.add(user);
		}
		return listUsers;
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
		statement.setInt(1, object.getUserType().ordinal()+1);
		statement.setString(2, object.getFirstName());
		statement.setString(3, object.getLastName());
		statement.setString(4, object.getEmail());
		statement.setString(5, object.getPassword());
		statement.setInt(6, object.getId());
		
	}
	
	public User findUserByEmail(String email) {
		LOGGER.info("Try to find user by email " + email);
		User user = null;
		ResultSet result = null;
		try(PreparedStatement statement = connect.prepareStatement(getFindEmailQuery())) {
			statement.setString(1, email);
			result = statement.executeQuery();
			user = parseResultSet(result);
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
		return user;
	}
}
