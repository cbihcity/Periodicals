package by.pvt.heldyieu.dao.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.dao.AbstractDAO;
import by.pvt.heldyieu.entity.Subscription;

public class SubscriptionDAOImpl extends AbstractDAO<Subscription, Integer>{
	
	public SubscriptionDAOImpl() {
		super("sqlSubscription");
		// TODO Auto-generated constructor stub
	}

	private static final Logger LOGGER = Logger.getLogger(SubscriptionDAOImpl.class);

	@Override
	public String getSelectQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCreateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Subscription parseResultSet(ResultSet rs)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
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
}
