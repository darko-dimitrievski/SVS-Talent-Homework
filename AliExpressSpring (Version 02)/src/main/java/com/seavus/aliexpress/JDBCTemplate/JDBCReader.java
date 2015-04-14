package com.seavus.aliexpress.JDBCTemplate;

import java.sql.Connection;
import java.sql.SQLException;


public interface JDBCReader {
	<E> E returnQuery(Connection connection) throws SQLException;
}
