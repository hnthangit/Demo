package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	
	public static Connection connect;
	
	public void connect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/Demo";
			connect = DriverManager.getConnection(dburl,"root","1234");
			System.out.println("Da ket noi");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
