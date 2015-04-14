package com.seavus.aliexpress.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
	static Connection connection;
	public static Connection connectToDatabase() {
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/library", "postgres",
					"postgres");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection() throws SQLException {
		connectToDatabase().close();
	}
}
