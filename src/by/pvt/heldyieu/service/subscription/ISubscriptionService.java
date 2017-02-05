package by.pvt.heldyieu.service.subscription;

import java.sql.SQLException;
import java.util.List;
import by.pvt.heldyieu.entity.Subscription;

public interface ISubscriptionService {
	 Subscription addSubscription(Subscription subscription) throws SQLException;
	
	 Subscription getSubscription(Integer id) throws SQLException;
	
	 void updateSubscription(Subscription subscription) throws SQLException;
	
	 void deleteSubscription(Subscription subscription) throws SQLException;
	
	 List<Subscription> getAllSubscriptions() throws SQLException;
	
	 Subscription findSubscriptionByEmail(String email) throws SQLException;
}
