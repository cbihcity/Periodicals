package by.pvt.heldyieu.service;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.dao.implementation.SubscriptionTypeDAOImpl;
import by.pvt.heldyieu.entity.SubscriptionType;

public class SubscriptionTypeService {
	
	private static final Logger LOGGER = Logger.getLogger(SubscriptionTypeService.class);
	private SubscriptionTypeDAOImpl subscriptionTypeDao;
	private static SubscriptionTypeService INSTANCE = null;
	
	
	private SubscriptionTypeService() {
		LOGGER.info("Create new SubscriptionTypeDAOImpl entity");
		subscriptionTypeDao = SubscriptionTypeDAOImpl.getInstance();
	}
	
	public static SubscriptionTypeService getInstance(){
		LOGGER.info("Getting SubscriptionTypeService entity");
		if (INSTANCE == null) {
			INSTANCE = new SubscriptionTypeService();
		} 
		return INSTANCE;
	}
	
	public SubscriptionType addSubscriptionType(SubscriptionType subscriptionType) throws SQLException {
		LOGGER.info("Try to add new SubscriptionType to database");
		return subscriptionTypeDao.create(subscriptionType);
    }
	
	public SubscriptionType getSubscriptionType(Integer id) throws SQLException {
		LOGGER.info("Try to get SubscriptionType by Id");
		return subscriptionTypeDao.readById(id);
    }
	
	public void updateSubscriptionType(SubscriptionType subscriptionType) throws SQLException {
		LOGGER.info("Try to update SubscriptionType");
		subscriptionTypeDao.update(subscriptionType);
    }
	
	public void deleteSubscriptionType(SubscriptionType subscriptionType) throws SQLException {
		LOGGER.info("Try to delete SubscriptionType");
		subscriptionTypeDao.delete(subscriptionType);
    }
	
	public List<SubscriptionType> getAllSubscriptionTypes() throws SQLException {
		LOGGER.info("Try to get all SubscriptionTypes");
		return subscriptionTypeDao.getAll();
    }
	
	public SubscriptionType findSubscriptionTypeByName(String name) throws SQLException {
		LOGGER.info("Try to find SubscriptionType by name");
		return subscriptionTypeDao.findSubscriptionTypeByName(name);
    }
	
}
