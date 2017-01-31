package by.pvt.heldyieu.test;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.entity.User;
import by.pvt.heldyieu.enums.UserType;
import by.pvt.heldyieu.service.UserService;

public class Test {
	public static void main(String[] args) {
		final Logger LOGGER = Logger.getLogger(Test.class);
		LOGGER.info("Create new user entity");
		User user = new User(1, "Andre", "Vasin", "cbihcity@gmail.com", "asdf", UserType.USER);
		LOGGER.info("Create new userservice entity");
		UserService service = new UserService();
		try {
			LOGGER.info("Try to register new user to database");
			user = service.addClient(user);
			LOGGER.info("Try to print new user to database");
			System.out.println(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}