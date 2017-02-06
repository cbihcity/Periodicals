package by.pvt.heldyieu.dao.factory;

import by.pvt.heldyieu.dao.AbstractDAO;
import by.pvt.heldyieu.dao.implementation.MagazineDAOImpl;
import by.pvt.heldyieu.dao.implementation.SubscriptionDAOImpl;
import by.pvt.heldyieu.dao.implementation.SubscriptionTypeDAOImpl;
import by.pvt.heldyieu.dao.implementation.UserDAOImpl;
import by.pvt.heldyieu.exception.InvalidValueException;
import by.pvt.heldyieu.interfaces.Constants;

public class DaoFactory implements Constants {
	
	@SuppressWarnings("rawtypes")
	public AbstractDAO createDao(String daoImpl) throws InvalidValueException {
		switch (daoImpl){
		case USER_DAO:
			return new UserDAOImpl();
		case MAGAZINE_DAO:
			return new MagazineDAOImpl();
		case SUBSCRIPTION_DAO:
			return new SubscriptionDAOImpl();
		case SUBSCRIPTION_TYPE_DAO:
			return new SubscriptionTypeDAOImpl();
			default: 
				throw new InvalidValueException(INVALID_PARSER_PARAMETER, daoImpl); 
		}
	}
}
