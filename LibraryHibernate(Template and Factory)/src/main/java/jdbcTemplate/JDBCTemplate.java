package jdbcTemplate;

import java.sql.Connection;

import connections.JDBCConnection;

public class JDBCTemplate {
	public <E> E returnQuery(JDBCReader jdbcReader) {
		E object = null;
		try {
			Connection connection = JDBCConnection.connectToDatabase();
			object = jdbcReader.returnQuery(connection);
			JDBCConnection.closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return object;

	}

	public void executeQuery(JDBCWriter jdbcWriter) {
		try {
			Connection connection = JDBCConnection.connectToDatabase();
			jdbcWriter.insertQuery(connection);
			JDBCConnection.closeConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
