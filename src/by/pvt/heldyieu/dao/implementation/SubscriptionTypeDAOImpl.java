package by.pvt.heldyieu.dao.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.dao.AbstractDAO;
import by.pvt.heldyieu.entity.SubscriptionType;

public class SubscriptionTypeDAOImpl extends AbstractDAO<SubscriptionType, Integer> {
	
	private static final Logger LOGGER = Logger.getLogger(SubscriptionTypeDAOImpl.class);
	
	public SubscriptionTypeDAOImpl() {
		super("sqlSubscriptionType");
		LOGGER.info("Initialize resource for SubscriptionTypeDAOImpl and connection to database");
	}

	@Override
	public String getSelectQuery() {
		return resmanager.getProperty("selectSubscriptionType");
	}

	@Override
	public String getCreateQuery() {
		return resmanager.getProperty("createSubscriptionType");
	}

	@Override
	public String getUpdateQuery() {
		return resmanager.getProperty("updateSubscriptionTypeById");
	}

	@Override
	public String getDeleteQuery() {
		return resmanager.getProperty("deleteSubscriptionTypeById");
	}
	
	public String getFindNameQuery() {
		return resmanager.getProperty("findSubscriptionTypeByName");
	}

	@Override
	protected SubscriptionType parseResultSet(ResultSet rs) throws SQLException {
		SubscriptionType subscriptionType = null;
		try {
			if(rs.next()) {
                subscriptionType = new SubscriptionType();
                subscriptionType.setId(rs.getInt("id"));
                subscriptionType.setName(rs.getString("name"));
                subscriptionType.setMonthValue(rs.getInt("month_value"));
            }
		} catch (SQLException e) {
			LOGGER.info(e.getMessage());
			System.out.println(ERROR_SQL_EXECUTE);
		}
		return subscriptionType;
	}

	@Override
	protected List<SubscriptionType> parseResultSetList(ResultSet rs)
			throws SQLException {
		List<SubscriptionType> list = new ArrayList<SubscriptionType>();
		while (rs.next()) {
			SubscriptionType subscriptionType = new SubscriptionType();
            subscriptionType.setId(rs.getInt("id"));
            subscriptionType.setName(rs.getString("name"));
            subscriptionType.setMonthValue(rs.getInt("month_value"));
            list.add(subscriptionType);
		}
		return list;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			SubscriptionType object) throws SQLException {
		statement.setString(1, object.getName());
		statement.setInt(2, object.getMonthValue());

	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			SubscriptionType object) throws SQLException {
		statement.setString(1, object.getName());
		statement.setInt(2, object.getMonthValue());
		statement.setInt(3, object.getId());
	}

	public SubscriptionType findSubscriptionTypeByName(String name) {
		LOGGER.info("Try to find SubscriptionType by name " + name);
		SubscriptionType subscriptionType = null;
		ResultSet result = null;
		try(PreparedStatement statement = connect.prepareStatement(getFindNameQuery())) {
			statement.setString(1, name);
			result = statement.executeQuery();
			subscriptionType = parseResultSet(result);
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
		return subscriptionType;
	}
	
}
