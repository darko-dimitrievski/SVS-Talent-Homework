package com.seavus.aliexpress.JDBCTemplate;

import java.sql.Connection;
import java.sql.SQLException;

public interface JDBCWriter {
	void insertQuery(Connection connection) throws SQLException;
}
