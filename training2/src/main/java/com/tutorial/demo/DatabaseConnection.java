package com.tutorial.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static Connection getDBConnection( ) throws Exception
	{
		Connection conn =null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		// database connection string
		// constants
	    conn = DriverManager.getConnection
	    		("jdbc:mysql://localhost:3306/online_shopping","root","root"); 
		  return conn;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
}
