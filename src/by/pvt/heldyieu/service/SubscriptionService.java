package by.pvt.heldyieu.service;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.dao.implementation.SubscriptionDAOImpl;
import by.pvt.heldyieu.entity.Subscription;

public class SubscriptionService {
private static final Logger LOGGER = Logger.getLogger(SubscriptionService.class);
	
	private SubscriptionDAOImpl subscriptionDao;
	private static SubscriptionService INSTANCE = null;
	

	private SubscriptionService() {
		LOGGER.info("Create new UserDAOImpl entity");
		subscriptionDao = SubscriptionDAOImpl.getInstance();
	}
	
	public static SubscriptionService getInstance(){
		LOGGER.info("Getting userservice entity");
		if (INSTANCE == null) {
			INSTANCE = new SubscriptionService();
		} 
		return INSTANCE;
	}
	
	public Subscription addSubscription(Subscription subscription) throws SQLException {
		LOGGER.info("Try to add new subscription to database");
		return subscriptionDao.create(subscription);
    }
	
	public Subscription getSubscription(Integer id) throws SQLException {
		LOGGER.info("Try to get subscription by Id");
		return subscriptionDao.readById(id);
    }
	
	public void updateSubscription(Subscription subscription) throws SQLException {
		LOGGER.info("Try to update subscription");
		subscriptionDao.update(subscription);
    }
	
	public void deleteSubscription(Subscription subscription) throws SQLException {
		LOGGER.info("Try to delete subscription");
		subscriptionDao.delete(subscription);
    }
	
	public List<Subscription> getAllSubscriptions() throws SQLException {
		LOGGER.info("Try to get all subscriptions");
		return subscriptionDao.getAll();
    }
	
	public Subscription findSubscriptionByEmail(String email) throws SQLException {
		LOGGER.info("Try to find subscription by email");
		return subscriptionDao.findSubscriptionByUser(email);
    }
}
