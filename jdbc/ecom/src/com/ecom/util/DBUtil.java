package com.ecom.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String URL = "jdbc:postgresql://localhost:5432/batch13db";
	private static final String USERNAME = "batch13";
	private static final String PASSWORD = "batch13";
	
	public static Connection getDBConnection() {
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("Connected");			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
