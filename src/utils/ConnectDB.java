package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	//vars
	private static final String UserName="system";
	private static final String Password="oracle";
	private static final String ConnectionString=""
			+ "jdbc:oracle:thin:@//192.168.56.101:1521/orcl";

	//Method that returns connection
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(
				ConnectionString, UserName, Password);
	}
	
}
