package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	private static Connection con;
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String username = "douzone";		
	private static String password = "oracle";
	
	
	public ConnectionDB() {
	}
	
	public static Connection openConnection() {
		if(con == null) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				con = DriverManager.getConnection(url, username, password);
			} catch (Exception e) {
				e.printStackTrace();
				}		
		}
		return con;
		
	}
	
	public void closeConnection() {
		try {
			if(con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
