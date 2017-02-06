package by.pvt.heldyieu.dao.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.dao.AbstractDAO;
import by.pvt.heldyieu.dao.factory.DaoFactory;
import by.pvt.heldyieu.entity.Subscription;
import by.pvt.heldyieu.exception.InvalidValueException;

public class SubscriptionDAOImpl extends AbstractDAO<Subscription, Integer>{
	
	private static final Logger LOGGER = Logger.getLogger(SubscriptionDAOImpl.class);
	private static SubscriptionDAOImpl INSTANCE;
	private UserDAOImpl userDao;
	private MagazineDAOImpl magazineDao;
	private SubscriptionTypeDAOImpl subscriptionTypeDao;
	
	public SubscriptionDAOImpl() {
		super("sqlSubscription");
		LOGGER.info("Initialize resource for SubscriptionDAOImpl and connection to database");
		userDao = UserDAOImpl.getInstance();
		magazineDao = MagazineDAOImpl.getInstance();
		subscriptionTypeDao = SubscriptionTypeDAOImpl.getInstance();
	}

	public static SubscriptionDAOImpl getInstance(){
		if (INSTANCE == null) {
			try {
				INSTANCE = (SubscriptionDAOImpl) new DaoFactory().createDao("subscriptionDao");
			} catch (InvalidValueException e) {
				LOGGER.error(e.getMessage());
			}
		}
		return INSTANCE;
	}
	
	@Override
	public String getSelectQuery() {
		return resmanager.getProperty("selectSubscription");
	}

	@Override
	public String getCreateQuery() {
		return resmanager.getProperty("createSubscription");
	}

	@Override
	public String getUpdateQuery() {
		return resmanager.getProperty("updateSubscriptionById");
	}

	@Override
	public String getDeleteQuery() {
		return resmanager.getProperty("deleteSubscriptionById");
	}

	public String getFindQuery() {
		return resmanager.getProperty("findSubscriptionByEmail");
	}
	
	@Override
	public String getSelectAllQuery() {
		return resmanager.getProperty("selectAll");
	}
	
	@Override
	protected Subscription parseResultSet(ResultSet rs)
			throws SQLException {
		Subscription subscription = new Subscription();
		if (rs.next()) {
			subscription.setId(rs.getInt("subscription_id"));
			subscription.setUser(userDao.readById(rs.getInt("person_id")));
			subscription.setMagazine(magazineDao.readById(rs.getInt("magazine_id")));
			subscription.setType(subscriptionTypeDao.readById(rs.getInt("subscription_type")));
			subscription.setStartDate(rs.getDate("start_date"));
			subscription.setEndDate(rs.getDate("end_date"));
			subscription.setPrice(rs.getDouble("price"));
			
		}
		return subscription;
	}

	@Override
	protected List<Subscription> parseResultSetList(ResultSet rs)
			throws SQLException {
		List<Subscription> list = new ArrayList<Subscription>();
		while (rs.next()) {
			Subscription subscription = new Subscription();
			subscription.setId(rs.getInt("subscription_id"));
			subscription.setUser(userDao.readById(rs.getInt("person_id")));
			subscription.setMagazine(magazineDao.readById(rs.getInt("magazine_id")));
			subscription.setType(subscriptionTypeDao.readById(rs.getInt("subscription_type")));
			subscription.setStartDate(rs.getDate("start_date"));
			subscription.setEndDate(rs.getDate("end_date"));
			subscription.setPrice(rs.getDouble("price"));
			list.add(subscription);
		}
		return list;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			Subscription object) throws SQLException {
			statement.setInt(1, object.getUser().getId());
			statement.setInt(2, object.getMagazine().getId());
			statement.setInt(3, object.getType().getId());
			statement.setDate(4, convert(object.getStartDate()));
			statement.setDate(5, convert(object.getEndDate()));
			statement.setDouble(6, object.getPrice());
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			Subscription object) throws SQLException {
		statement.setInt(1, object.getUser().getId());
		statement.setInt(2, object.getMagazine().getId());
		statement.setInt(3, object.getType().getId());
		statement.setDate(4, convert(object.getStartDate()));
		statement.setDate(5, convert(object.getEndDate()));
		statement.setDouble(6, object.getPrice());
		statement.setInt(7, object.getId());
		
	}
	
	public Subscription findSubscriptionByUser(String email) {
		LOGGER.info("Try to find Subscription by user email " + email);
		ResultSet result = null;
		Subscription subscription = new Subscription();
		try(PreparedStatement statement = connect.prepareStatement(getFindQuery())) {
			statement.setInt(1, userDao.findUserByEmail(email).getId());
			result = statement.executeQuery();
			subscription = parseResultSet(result);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
			System.out.println(ERROR_SQL_EXECUTE);
		}
		 finally {
				try {
					result.close();
				} catch (SQLException e) {
					LOGGER.info(e.getMessage());
					System.out.println(ERROR_CLOSING_RESULTSET);
				}
			}
		return subscription;
	}
	
	private java.sql.Date convert(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }
}
