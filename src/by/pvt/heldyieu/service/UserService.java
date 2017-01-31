package by.pvt.heldyieu.service;

import java.sql.SQLException;

import by.pvt.heldyieu.dao.implementation.UserDAOImpl;
import by.pvt.heldyieu.entity.User;

public class UserService {
	private UserDAOImpl userDao;

	/**
	 * 
	 */
	public UserService() {
		userDao = new UserDAOImpl();
	}
	
	public User addUser(User user) throws SQLException {
		return userDao.create(user);
    }
	
	public User findUserByEmail(String email) throws SQLException {
		return userDao.findUserByEmail(email);
    }
	
	public void deleteUser(User user) throws SQLException {
		userDao.delete(user);
    }
	
}
