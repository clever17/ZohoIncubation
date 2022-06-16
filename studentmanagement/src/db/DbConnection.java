package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection 
{
	
	
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/students";
	
	private static Connection conn= null;
	
	public static Connection getConnection()
	{
		
		try
		{
			conn=DriverManager.getConnection(DB_URL,"root","rootroot");
			System.out.println("::Connected::");
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
	
	
	   
	   
}
