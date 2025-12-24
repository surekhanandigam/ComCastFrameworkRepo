package com.comcast.crm.generic.databaseutility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
    Connection connection;
	public void getDBConnection(String url,String username,String password) throws SQLException
	{
		try {
		Driver driver=new Driver() ;
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection(url,username,password);
		}
		catch (Exception e)
		{		
		}
	}
	
	public void getDBConnection() throws SQLException
	{
		try {
		Driver driver=new Driver() ;
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/m16_advance_java","root","root");
		}
		catch (Exception e)
		{		
		}
	}
	
	public void closeDBConnection() throws SQLException
	{
		try {
		connection.close();
		}
		catch(Exception e)
		{
		}
	}
	
	public ResultSet executeSelectQuery(String query) throws SQLException
	{
		ResultSet resultset=null;
		try {
		Statement statement=connection.createStatement();
	    resultset=statement.executeQuery(query);
		}
		catch(Exception e)
		{		
		}
		return resultset;
	}
	
	public int executeNonSelectQuery(String query) throws SQLException
	{
		int result=0;
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate(query);
		}
		catch(Exception e)
		{
		}
		return result;
	}
}
