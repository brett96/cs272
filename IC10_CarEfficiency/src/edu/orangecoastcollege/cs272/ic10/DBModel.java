package edu.orangecoastcollege.cs272.ic10;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.*;

/**
 * Model for application
 * @author Brett
 *
 */
public class DBModel 
{
	private static final String DATA_FILE = "cars.csv";
	
	public static Connection connectToDB(String dbName) throws ClassNotFoundException, SQLException 
	{
		// Load SQLite database classes
		Class.forName("org.sqlite.JDBC");
		// Establish a connection to the database and return that connection
		Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
		// Populate DB with data from CSV file (if needed)
		populateDBFromFile(connection, DATA_FILE);
		return connection;
	}
	
	private static int populateDBFromFile(Connection connection, String fileName)
	{
		int recordsCreated = 0;
		
		String createSQL = "CREATE TABLE IF NOT EXISTS car ("
				+ "id INTEGER PRIMARY KEY,"
				+ "make TEXT,"
				+ "description TEXT,"
				+ "horsepower INTEGER,"
				+ "fuel_type TEXT,"
				+ "city_mpg INTEGER,"
				+ "hwy_mpg INTEGER,"
				+ "hybrid INTEGER"
				+ ")";
		
		try 
		{
			Statement stmt = connection.createStatement();
			stmt.setQueryTimeout(30);
			stmt.executeUpdate(createSQL);
			String selectSQL = "SELECT * FROM car";
			ResultSet rs = stmt.executeQuery(selectSQL);
			
			if(rs.next())
			{
				return 0;
			}
			
			Scanner fileScanner = new Scanner(new File(DATA_FILE));
			fileScanner.nextLine();
			while(fileScanner.hasNextLine())
			{
				String[] data = fileScanner.nextLine().split(",");
				String make = data[11];
				System.out.println(make);
				String description = data[9].replaceAll("\\.", "");
				System.out.println(description);
				String hp = data[7];
				System.out.println(hp);
				String fuelType = data[4];
				System.out.println(fuelType);
				String cityMPG = data[0];
				System.out.println(cityMPG);
				String hwyMPG = data[6];
				System.out.println(hwyMPG);
				String hybrid = data[8].equalsIgnoreCase("TRUE") ? "1" : "0";
				System.out.println(hybrid);
				
				String insertSQL = "INSERT INTO car (make, description, horse_power, fuel_type, city_mpg, highway_mpg, hybrid)"
						+ "VALUES('"
						+ make + "',"
						+ description + ",'"
						+ hp + "',"
						+ fuelType + ",'"
						+ cityMPG + "','"
						+ hwyMPG + "',"
						+ hybrid + ")";
				stmt.executeUpdate(insertSQL);
				recordsCreated++;
			}
			fileScanner.close();
		} 
		catch (SQLException | FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return recordsCreated;
	}
	
	public static ResultSet getAllCars(Connection connection)
	{
		ResultSet rs = null;
		
		Statement stmt;
		try 
		{
			stmt = connection.createStatement();
			stmt.setQueryTimeout(30);
			
			String selectSQL = "SELECT * FROM car";
			rs = stmt.executeQuery(selectSQL); 	
			return rs;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
}
