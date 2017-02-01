package by.pvt.heldyieu.dao.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.dao.AbstractDAO;
import by.pvt.heldyieu.entity.Subscription;

public class SubscriptionDAOImpl extends AbstractDAO<Subscription, Integer>{
	
	private static final Logger LOGGER = Logger.getLogger(SubscriptionDAOImpl.class);
	private static SubscriptionDAOImpl INSTANCE;
	private UserDAOImpl userDao;
	private MagazineDAOImpl magazineDao;
	private SubscriptionTypeDAOImpl subscriptionTypeDao;
	
	private SubscriptionDAOImpl() {
		super("sqlSubscription");
		LOGGER.info("Initialize resource for SubscriptionDAOImpl and connection to database");
		userDao = UserDAOImpl.getInstance();
		magazineDao = MagazineDAOImpl.getInstance();
		subscriptionTypeDao = SubscriptionTypeDAOImpl.getInstance();
	}

	public static SubscriptionDAOImpl getInstance(){
		if (INSTANCE == null) {
			INSTANCE = new SubscriptionDAOImpl();
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
		return resmanager.getProperty("findSubscriptionByUser");
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			Subscription object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			Subscription object) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	private java.sql.Date convert(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }
}
