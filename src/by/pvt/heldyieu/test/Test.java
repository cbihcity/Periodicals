package by.pvt.heldyieu.test;

import java.sql.SQLException;

import by.pvt.heldyieu.entity.Magazine;
import by.pvt.heldyieu.entity.SubscriptionType;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.enums.CategoryType;
import by.pvt.heldyieu.enums.UserType;
import by.pvt.heldyieu.service.MagazineService;
import by.pvt.heldyieu.service.SubscriptionTypeService;
import by.pvt.heldyieu.service.UserService;

public class Test {
	public static void main(String[] args) {
		
		//TEST UserDAOImplementation
		User user = new User(1, "Andre", "Vasin", "cbihcity@gmail.com", "asdf", UserType.USER);
		UserService service = UserService.getInstance();
		try {
			user = service.addUser(user);
			System.out.println(user);
			System.out.println(service.getUser(user.getId()));
			user.setEmail("new@mail.ru");
			user.setFirstName("Valera");
			service.updateUser(user);
			service.getAllUsers().forEach(item->System.out.println(item.toString()));
//			service.deleteUser(user);
			System.out.println(service.findUserByEmail("xanderakk@mail.ru").toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TEST SubscriptionTypeDAOImplementation
		SubscriptionType type1 = new SubscriptionType(1, "quarter", 3);
		SubscriptionType type2 = new SubscriptionType(2, "semi-annual", 6);
		SubscriptionType type3 = new SubscriptionType(3, "annual", 12);
		SubscriptionTypeService subscriptionTypeService = SubscriptionTypeService.getInstance();
		try {
			type1 = subscriptionTypeService.addSubscriptionType(type1);
			type2 = subscriptionTypeService.addSubscriptionType(type2);
			type3 = subscriptionTypeService.addSubscriptionType(type3);
			System.out.println(subscriptionTypeService.getSubscriptionType(2).toString());
			System.out.println(subscriptionTypeService.getSubscriptionType(3).toString());
			type2.setMonthValue(15);
			subscriptionTypeService.updateSubscriptionType(type2);
			subscriptionTypeService.deleteSubscriptionType(type2);
			subscriptionTypeService.getAllSubscriptionTypes().forEach(item->System.out.println(item.toString()));
			System.out.println(subscriptionTypeService.findSubscriptionTypeByName(type3.getName()).toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TEST MagazineDAOImpl
		Magazine mag1 = new Magazine(1, "Nature", CategoryType.SCIENTIFIC, 6.5);
		Magazine mag2 = new Magazine(2, "Club", CategoryType.ENTERTAINMENT, 8.5);
		Magazine mag3 = new Magazine(3, "Times", CategoryType.NEWSPAPER, 2.5);
		MagazineService magazineService = MagazineService.getInstance();
		try {
			mag1 = magazineService.addMagazine(mag1);
			mag2 = magazineService.addMagazine(mag2);
			mag3 = magazineService.addMagazine(mag3);
			System.out.println(magazineService.getMagazine(mag2.getId()));
			mag1.setName("WildNature");
			mag1.setPrice(7.5);
			magazineService.updateMagazine(mag1);
			magazineService.getAllMagazines().forEach(item->System.out.println(item.toString()));
			magazineService.deleteMagazine(mag2);
			System.out.println(magazineService.findMagazineByName("Times").toString());
			magazineService.getAllMagazines().forEach(item->System.out.println(item.toString()));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}