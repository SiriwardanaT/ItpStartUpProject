package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	
	public static Connection getConnections() throws SQLException {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/users";
		String user = "root";
		String password = "1998";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		    con = DriverManager.getConnection(url, user, password);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return con;
	}
	
	
	
	public static Connection getConnections1() throws SQLException {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/project123";
		String user = "root";
		String password = "1998";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		    con = DriverManager.getConnection(url, user, password);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return con;
	}

}
