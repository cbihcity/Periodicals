package by.pvt.heldyieu.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import by.pvt.heldyieu.resources.ResourceManager;

public class ConnectionFactory {
	
	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class);
	private static ConnectionFactory connectionFactory;
	private ResourceManager resmanager;
	private Connection connect;

    private ConnectionFactory() {
        LOGGER.info("Initializing connectionFactory class");

        try {
        	resmanager = ResourceManager.getInstance("connection");
        	Class.forName(resmanager.getProperty("jdbc"));
        	connect = DriverManager.getConnection(resmanager.getProperty("database"), resmanager.getProperty("user"), resmanager.getProperty("password"));
        	
        } catch (ClassNotFoundException | SQLException e) {
            LOGGER.error(e.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        LOGGER.info("Getting connection");
        return connect;
    }

    public static synchronized ConnectionFactory getInstance() {
        if(connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}
