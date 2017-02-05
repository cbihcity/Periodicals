package by.pvt.heldyieu.service.subscription.type;

import java.sql.SQLException;
import java.util.List;
import by.pvt.heldyieu.entity.SubscriptionType;

public interface ISubscriptionTypeService {
	 SubscriptionType addSubscriptionType(SubscriptionType subscriptionType) throws SQLException;
	
	 SubscriptionType getSubscriptionType(Integer id) throws SQLException;
	
	 void updateSubscriptionType(SubscriptionType subscriptionType) throws SQLException;
	
	 void deleteSubscriptionType(SubscriptionType subscriptionType) throws SQLException;
	
	 List<SubscriptionType> getAllSubscriptionTypes() throws SQLException;
	
	 SubscriptionType findSubscriptionTypeByName(String name) throws SQLException;
}
