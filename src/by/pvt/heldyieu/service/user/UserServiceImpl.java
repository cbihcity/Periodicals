package by.pvt.heldyieu.service.user;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.dao.implementation.UserDAOImpl;
import by.pvt.heldyieu.entity.User;

public class UserServiceImpl implements IUserService{
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	
	private UserDAOImpl userDao;
	private static UserServiceImpl INSTANCE = null;
	

	private UserServiceImpl() {
		LOGGER.info("Create new UserDAOImpl entity");
		userDao = (UserDAOImpl) UserDAOImpl.getInstance();
	}
	
	public static UserServiceImpl getInstance(){
		LOGGER.info("Getting userservice entity");
		if (INSTANCE == null) {
			INSTANCE = new UserServiceImpl();
		} 
		return INSTANCE;
	}
	@Override
	public User addUser(User user) throws SQLException {
		LOGGER.info("Try to add new user to database");
		return userDao.create(user);
    }
	@Override
	public User getUser(Integer id) throws SQLException {
		LOGGER.info("Try to get user by Id");
		return userDao.readById(id);
    }
	@Override
	public void updateUser(User user) throws SQLException {
		LOGGER.info("Try to update user");
		userDao.update(user);
    }
	@Override
	public void deleteUser(User user) throws SQLException {
		LOGGER.info("Try to delete user");
		userDao.delete(user);
    }
	@Override
	public List<User> getAllUsers() throws SQLException {
		LOGGER.info("Try to get all users");
		return userDao.getAll();
    }
	@Override
	public User findUserByEmail(String email) throws SQLException {
		LOGGER.info("Try to find user by email");
		return userDao.findUserByEmail(email);
    }
}
