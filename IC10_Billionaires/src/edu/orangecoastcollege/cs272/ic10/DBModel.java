package edu.orangecoastcollege.cs272.ic10;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


/**
 * Model for Application
 * @author Brett
 *
 */
public class DBModel 
{

	private static final String DATA_FILE = "billionaires.csv";
	
	public static Connection connectToDB(String dbName) throws ClassNotFoundException, SQLException {
		// Load SQLite database classes
		Class.forName("org.sqlite.JDBC");
		// Establish a connection to the database and return that connection
		Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
		// Populate DB with data from CSV file (if needed)
		populateDBFromFile(connection, DATA_FILE);
		return connection;
	}
	
	private static int populateDBFromFile(Connection connection, String fileName) {
		int recordsCreated = 0;

		// Write an SQL statement that creates a database table called billionaire
		String createSQL = "CREATE TABLE IF NOT EXISTS billionaire ("
				+ "id INTEGER PRIMARY KEY,"
				+ "name TEXT,"
				+ "age INTEGER,"
				+ "gender TEXT,"
				+ "worth REAL,"
				+ "citizenship TEXT,"
				+ "sector TEXT,"
				+ "political INTEGER"
				+ ")";
		
		// Define a statement w/ a timeout of 30 sec
		// After 30 seconds of inactivity, statement will be terminated
		try 
		{
			Statement stmt = connection.createStatement();
			
			stmt.setQueryTimeout(30);
			
			//stmt.executeUpdate("DROP TABLE IF EXISTS billionaire");
			stmt.executeUpdate(createSQL);
			// Lets determine if anything is in billionaire table:
			String selectSQL = "SELECT * FROM billionaire";
			ResultSet rs = stmt.executeQuery(selectSQL);
			
			// Check to see if results
			// If results, don't do anything, return 0 records updated
			if (rs.next())
				return 0;
			// If no results, read billionares.csv line by line and insert each billionaire into database
			Scanner fileScanner = new Scanner(new File(DATA_FILE));
			// Get rid of first line in .csv file (only contains headers; no data
			fileScanner.nextLine();
			// Now loop through each line
			while(fileScanner.hasNextLine())
			{
				String[] data = fileScanner.nextLine().split(",");
				String name = data[12].replaceAll("'", "''");
				String age = data[0];
				String gender = data[9];
				String worth = data[20];
				String citizenship = data[2];
				String sector = data[16];
				String political = data[18].equalsIgnoreCase("TRUE") ? "1" : "0";
				
				// This INSERT statement automatically generates an id if you leave it out
				String insertSQL = "INSERT INTO billionaire (name, age, gender, worth, citizenship, sector, political)"
						+ "VALUES('"
						+ name + "',"
						+ age + ",'"
						+ gender + "',"
						+ worth + ",'"
						+ citizenship + "','"
						+ sector + "',"
						+ political + ")";
				
				stmt.executeUpdate(insertSQL);
				recordsCreated++;
				
			}
			// Done w/ file, close scanner
			fileScanner.close();
			
			
			
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return recordsCreated;
	}
	
	public static ResultSet getAllBillionaires(Connection connection)
	{
		ResultSet rs = null;
		try 
		{
			Statement stmt = connection.createStatement();
			stmt.setQueryTimeout(30);
			
			String selectSQL = "SELECT * FROM billionaire";
			rs = stmt.executeQuery(selectSQL);
			
			return rs;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
//	public static void main(String[] args)
//	{
//		try {
//			connectToDB("cs272.db");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
