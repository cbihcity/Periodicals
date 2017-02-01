package by.pvt.heldyieu.service;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.dao.implementation.UserDAOImpl;
import by.pvt.heldyieu.entity.User;

public class UserService {
	private static final Logger LOGGER = Logger.getLogger(UserService.class);
	
	private UserDAOImpl userDao;
	private static UserService INSTANCE = null;
	

	private UserService() {
		LOGGER.info("Create new UserDAOImpl entity");
		userDao = UserDAOImpl.getInstance();
	}
	
	public static UserService getInstance(){
		LOGGER.info("Getting userservice entity");
		if (INSTANCE == null) {
			INSTANCE = new UserService();
		} 
		return INSTANCE;
	}
	
	public User addUser(User user) throws SQLException {
		LOGGER.info("Try to add new user to database");
		return userDao.create(user);
    }
	
	public User getUser(Integer id) throws SQLException {
		LOGGER.info("Try to get user by Id");
		return userDao.readById(id);
    }
	
	public void updateUser(User user) throws SQLException {
		LOGGER.info("Try to update user");
		userDao.update(user);
    }
	
	public void deleteUser(User user) throws SQLException {
		LOGGER.info("Try to delete user");
		userDao.delete(user);
    }
	
	public List<User> getAllUsers() throws SQLException {
		LOGGER.info("Try to get all users");
		return userDao.getAll();
    }
	
	public User findUserByEmail(String email) throws SQLException {
		LOGGER.info("Try to find user by email");
		return userDao.findUserByEmail(email);
    }
}
