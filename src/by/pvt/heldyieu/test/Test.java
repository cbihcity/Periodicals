package by.pvt.heldyieu.test;

import java.sql.SQLException;
import java.util.Date;

import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.entity.Subscription;
import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.enums.CategoryType;
import by.pvt.heldyieu.enums.UserType;
import by.pvt.heldyieu.service.magazine.MagazineServiceImpl;
import by.pvt.heldyieu.service.subscription.SubscriptionServiceImpl;
import by.pvt.heldyieu.service.subscription.type.SubscriptionTypeServiceImpl;
import by.pvt.heldyieu.service.user.UserServiceImpl;

public class Test {
	public static void main(String[] args) {
		
		//TEST UserDAOImplementation
		
		User user1 = new User(1, "Igor", "Geldiev", "xanderakk@mail.ru", "123", UserType.USER);
		User user2 = new User(2, "Andre", "Vasin", "cbihcity@gmail.com", "asdf", UserType.USER);
		UserServiceImpl service = UserServiceImpl.getInstance();
		try {
			user1 = service.addUser(user1);
			user2 = service.addUser(user2);
			System.out.println(user1);
			System.out.println(service.getUser(user1.getId()));
			user1.setEmail("new@mail.ru");
			user1.setFirstName("Valera");
			service.updateUser(user1);
			service.getAllUsers().forEach(item->System.out.println(item));
			//service.deleteUser(user1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//TEST SubscriptionTypeDAOImplementation
		SubscriptionType type1 = new SubscriptionType(1, "quarter", 3);
		SubscriptionType type2 = new SubscriptionType(2, "semi-annual", 6);
		SubscriptionType type3 = new SubscriptionType(3, "annual", 12);
		SubscriptionTypeServiceImpl subscriptionTypeService = SubscriptionTypeServiceImpl.getInstance();
		try {
			type1 = subscriptionTypeService.addSubscriptionType(type1);
			type2 = subscriptionTypeService.addSubscriptionType(type2);
			type3 = subscriptionTypeService.addSubscriptionType(type3);
			System.out.println(subscriptionTypeService.getSubscriptionType(2));
			System.out.println(subscriptionTypeService.getSubscriptionType(3));
			type2.setMonthValue(15);
			subscriptionTypeService.updateSubscriptionType(type2);
		//	subscriptionTypeService.deleteSubscriptionType(type2);
			subscriptionTypeService.getAllSubscriptionTypes().forEach(item->System.out.println(item));
			System.out.println(subscriptionTypeService.findSubscriptionTypeByName(type3.getName()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//TEST MagazineDAOImpl
		Magazine mag1 = new Magazine(1, "Nature", CategoryType.SCIENTIFIC, 6.5);
		Magazine mag2 = new Magazine(2, "Club", CategoryType.ENTERTAINMENT, 8.5);
		Magazine mag3 = new Magazine(3, "Times", CategoryType.NEWSPAPER, 2.5);
		MagazineServiceImpl magazineService = MagazineServiceImpl.getInstance();
		try {
			mag1 = magazineService.addMagazine(mag1);
			mag2 = magazineService.addMagazine(mag2);
			mag3 = magazineService.addMagazine(mag3);
			System.out.println(magazineService.getMagazine(mag2.getId()));
			mag1.setName("WildNature");
			mag1.setPrice(7.5);
			magazineService.updateMagazine(mag1);
			magazineService.getAllMagazines().forEach(item->System.out.println(item));
		//	magazineService.deleteMagazine(mag2);
			System.out.println(magazineService.findMagazineByName("Times"));
			magazineService.getAllMagazines().forEach(item->System.out.println(item));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		//TEST SubscriptionDAOImpl
		Date start = new Date();
		Subscription subscription1 = new Subscription(1, user1, mag1, type1, start);
		Subscription subscription2 = new Subscription(2, user2, mag3, type2, start);
		SubscriptionServiceImpl subscriptionService = SubscriptionServiceImpl.getInstance();
		
		try {
			subscription1 = subscriptionService.addSubscription(subscription1);
			subscription2 = subscriptionService.addSubscription(subscription2);
			
			//System.out.println(subscriptionService.getSubscription(2));
			subscription1.setUser(user2);
			subscription1.setMagazine(mag2);
			subscriptionService.updateSubscription(subscription1);
			subscriptionService.getAllSubscriptions().forEach(item->System.out.println(item));
		//	System.out.println(subscriptionService.findSubscriptionByEmail(user1.getEmail()));
		//	subscriptionService.deleteSubscription(subscription1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}