package by.pvt.heldyieu.dao.implementation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import by.pvt.heldyieu.dao.generic.AbstractDAO;
import by.pvt.heldyieu.entity.SubscriptionType;

public class SubscriptionTypeDAOImpl extends AbstractDAO<SubscriptionType, Integer> {
	
	
	public SubscriptionTypeDAOImpl(String resource) {
		super("sqlSubscriptionType");
		// TODO Auto-generated constructor stub
	}

	private static final Logger LOGGER = Logger.getLogger(SubscriptionTypeDAOImpl.class);

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
	protected SubscriptionType parseResultSet(ResultSet rs,
			SubscriptionType Object) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<SubscriptionType> parseResultSetList(ResultSet rs)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void prepareStatementForInsert(PreparedStatement statement,
			SubscriptionType object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void prepareStatementForUpdate(PreparedStatement statement,
			SubscriptionType object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	
}
