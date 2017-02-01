package by.pvt.heldyieu.service;

import java.sql.SQLException;
import java.util.List;
import by.pvt.heldyieu.dao.implementation.UserDAOImpl;
import by.pvt.heldyieu.entity.User;

public class UserService {
	private UserDAOImpl userDao;

	public UserService() {
		userDao = new UserDAOImpl();
	}
	
	public User addUser(User user) throws SQLException {
		return userDao.create(user);
    }
	
	public User getUser(Integer id) throws SQLException {
		return userDao.readById(id);
    }
	
	public void updateUser(User user) throws SQLException {
		userDao.update(user);
    }
	
	public void deleteUser(User user) throws SQLException {
		userDao.delete(user);
    }
	
	public List<User> getAllUsers() throws SQLException {
		return userDao.getAll();
    }
	
	public User findUserByEmail(String email) throws SQLException {
		return userDao.findUserByEmail(email);
    }
}
