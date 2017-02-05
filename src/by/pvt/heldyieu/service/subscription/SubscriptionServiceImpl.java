package by.pvt.heldyieu.service.subscription;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.dao.implementation.SubscriptionDAOImpl;
import by.pvt.heldyieu.entity.Subscription;

public class SubscriptionServiceImpl implements ISubscriptionService {
private static final Logger LOGGER = Logger.getLogger(SubscriptionServiceImpl.class);
	
	private SubscriptionDAOImpl subscriptionDao;
	private static SubscriptionServiceImpl INSTANCE = null;
	

	private SubscriptionServiceImpl() {
		LOGGER.info("Create new UserDAOImpl entity");
		subscriptionDao = SubscriptionDAOImpl.getInstance();
	}
	
	public static SubscriptionServiceImpl getInstance(){
		LOGGER.info("Getting userservice entity");
		if (INSTANCE == null) {
			INSTANCE = new SubscriptionServiceImpl();
		} 
		return INSTANCE;
	}
	@Override
	public Subscription addSubscription(Subscription subscription) throws SQLException {
		LOGGER.info("Try to add new subscription to database");
		return subscriptionDao.create(subscription);
    }
	@Override
	public Subscription getSubscription(Integer id) throws SQLException {
		LOGGER.info("Try to get subscription by Id");
		return subscriptionDao.readById(id);
    }
	@Override
	public void updateSubscription(Subscription subscription) throws SQLException {
		LOGGER.info("Try to update subscription");
		subscriptionDao.update(subscription);
    }
	@Override
	public void deleteSubscription(Subscription subscription) throws SQLException {
		LOGGER.info("Try to delete subscription");
		subscriptionDao.delete(subscription);
    }
	@Override
	public List<Subscription> getAllSubscriptions() throws SQLException {
		LOGGER.info("Try to get all subscriptions");
		return subscriptionDao.getAll();
    }
	@Override
	public Subscription findSubscriptionByEmail(String email) throws SQLException {
		LOGGER.info("Try to find subscription by email");
		return subscriptionDao.findSubscriptionByUser(email);
    }
}
