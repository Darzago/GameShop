package model;
import java.sql.Connection;

import java.sql.SQLException;

public class Configuration {
	
private static Connection connection;

public static Connection getConnection() throws SQLException {
    return connection;
}

public static void setConnection(Connection connection) {
	Configuration.connection = connection;
}
}
