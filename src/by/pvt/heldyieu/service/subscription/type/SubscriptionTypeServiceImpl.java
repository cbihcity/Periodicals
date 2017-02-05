package by.pvt.heldyieu.service.subscription.type;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.dao.implementation.SubscriptionTypeDAOImpl;
import by.pvt.heldyieu.entity.SubscriptionType;

public class SubscriptionTypeServiceImpl implements ISubscriptionTypeService{
	
	private static final Logger LOGGER = Logger.getLogger(SubscriptionTypeServiceImpl.class);
	private SubscriptionTypeDAOImpl subscriptionTypeDao;
	private static SubscriptionTypeServiceImpl INSTANCE = null;
	
	
	private SubscriptionTypeServiceImpl() {
		LOGGER.info("Create new SubscriptionTypeDAOImpl entity");
		subscriptionTypeDao = SubscriptionTypeDAOImpl.getInstance();
	}
	
	public static SubscriptionTypeServiceImpl getInstance(){
		LOGGER.info("Getting SubscriptionTypeService entity");
		if (INSTANCE == null) {
			INSTANCE = new SubscriptionTypeServiceImpl();
		} 
		return INSTANCE;
	}
	@Override
	public SubscriptionType addSubscriptionType(SubscriptionType subscriptionType) throws SQLException {
		LOGGER.info("Try to add new SubscriptionType to database");
		return subscriptionTypeDao.create(subscriptionType);
    }
	@Override
	public SubscriptionType getSubscriptionType(Integer id) throws SQLException {
		LOGGER.info("Try to get SubscriptionType by Id");
		return subscriptionTypeDao.readById(id);
    }
	@Override
	public void updateSubscriptionType(SubscriptionType subscriptionType) throws SQLException {
		LOGGER.info("Try to update SubscriptionType");
		subscriptionTypeDao.update(subscriptionType);
    }
	@Override
	public void deleteSubscriptionType(SubscriptionType subscriptionType) throws SQLException {
		LOGGER.info("Try to delete SubscriptionType");
		subscriptionTypeDao.delete(subscriptionType);
    }
	@Override
	public List<SubscriptionType> getAllSubscriptionTypes() throws SQLException {
		LOGGER.info("Try to get all SubscriptionTypes");
		return subscriptionTypeDao.getAll();
    }
	@Override
	public SubscriptionType findSubscriptionTypeByName(String name) throws SQLException {
		LOGGER.info("Try to find SubscriptionType by name");
		return subscriptionTypeDao.findSubscriptionTypeByName(name);
    }
	
}
