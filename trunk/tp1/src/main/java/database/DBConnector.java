package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Connection getConnection() throws SQLException {
		//TODO
		return DriverManager.getConnection("jdbc:mysql://localhost/AterrizarDB","root","root");
	}
	
}
