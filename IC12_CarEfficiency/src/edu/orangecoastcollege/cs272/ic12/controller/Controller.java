package edu.orangecoastcollege.cs272.ic12.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import edu.orangecoastcollege.cs272.ic12.model.Car;
import edu.orangecoastcollege.cs272.ic12.model.DBModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This <code>Controller</code> connects the DB to the JavaFX user interface.  The Controller is a singleton
 * which serves as the one intermediary between the back-end and front-end of the application.
 * 
 * @author
 * @version 1.0
 */
public final class Controller {
	
	private static Controller theOne;
	
	private static final String DB_NAME = "cs272.db";
	private static final String TABLE_NAME = "cars";
	private static final String[] FIELD_NAMES = { "id", "make", "description", "horsepower", "fuelType", "cityMPG", "hwyMPG", "hybrid" };
	private static final String[] FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "INTEGER", "TEXT", "INTEGER", "INTEGER", "INTEGER" };
	private static final String DATA_FILE = "cars.csv";
	
	private ObservableList<Car> mAllCarsList;
	private DBModel mDB;
	
	private Controller() {}
	
	/**
	 * Creates Database instance
	 * @return
	 */
	public static Controller getInstance() {
		if (theOne == null) {
			theOne = new Controller();
			theOne.mAllCarsList = FXCollections.observableArrayList();
			
			try{
				theOne.mDB = new DBModel(DB_NAME, TABLE_NAME, FIELD_NAMES, FIELD_TYPES);
				theOne.initializeDBFromFile();
				
				ResultSet rs = theOne.mDB.getAllRecords();
				if(rs != null) {
					while(rs.next())
					{
						int id = rs.getInt(FIELD_NAMES[0]);
						String make = rs.getString(FIELD_NAMES[1]);
						String description = rs.getString(FIELD_NAMES[2]);
						int horsepower = rs.getInt(FIELD_NAMES[3]);
						String fuelType = rs.getString(FIELD_NAMES[4]);
						int cityMPG = rs.getInt(FIELD_NAMES[5]);
						int hwyMPG = rs.getInt(FIELD_NAMES[6]);
						boolean hybrid = rs.getInt(FIELD_NAMES[7]) == 1;
						
						theOne.mAllCarsList.add(new Car(id, make, description, horsepower, fuelType, cityMPG, hwyMPG, hybrid));
					}
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return theOne;
	}
	
	/**
	 * Returns an ObservableList of all cars
	 * @return
	 */
	public ObservableList<Car> getAllCars()
	{
		return theOne.mAllCarsList;
	}
	
	/**
	 * Returns distinct car makes
	 * @return
	 */
	public ObservableList<String> getDistinctMakes()
	{
		ObservableList<String> makes = FXCollections.observableArrayList();
		makes.add(" ");
		for(Car c : theOne.mAllCarsList)
			if (!makes.contains(c.getMake())) makes.add(c.getMake());
		FXCollections.sort(makes);
		return makes;
	}
	
	/**
	 * Returns distinct fuel types
	 * @return
	 */
	public ObservableList<String> getDistinctFuelTypes()
	{
		ObservableList<String> fuelTypes = FXCollections.observableArrayList();
		
		for(Car c : theOne.mAllCarsList)
			if(!fuelTypes.contains(c.getFuelType())) fuelTypes.add(c.getFuelType());
		FXCollections.sort(fuelTypes);
		return fuelTypes;
	}
	
	/**
	 * Creates a filter
	 * @param make
	 * @param fuelType
	 * @param cityMPG
	 * @param hwyMPG
	 * @return
	 */
	public ObservableList<Car> filter(String make, String fuelType, double cityMPG, double hwyMPG)
	{
		ObservableList<Car> filteredCarsList = FXCollections.observableArrayList();
		for(Car c : theOne.mAllCarsList)
		{
			
			if ((make == null || c.getMake().equals(make)) && (fuelType == null || c.getFuelType().equals(fuelType)) && c.getCityMPG() >= cityMPG && c.getHighwayMPG() >= hwyMPG)
				filteredCarsList.add(c);
		}
		return filteredCarsList;
	}
	
	/**
	 * Creates database from csv
	 * @return
	 * @throws SQLException
	 */
	private int initializeDBFromFile() throws SQLException
	{
		int recordsCreated = 0;
		
		if(theOne.mDB.getRecordCount() > 0)
			return recordsCreated;
		
		try {
			Scanner fileScanner = new Scanner(new File(DATA_FILE));
			fileScanner.nextLine();
			
			while(fileScanner.hasNextLine())
			{				
				String[] data = fileScanner.nextLine().split(",");
				String[] values = new String[FIELD_NAMES.length - 1];
				values[0] = data[11].replaceAll("'", "''");
				values[1] = data[9];
				values[2] = data[7];
				values[3] = data[4];
				values[4] = data[0];
				values[5] = data[6];
				values[6] = (data[8].equalsIgnoreCase("true") ? "1" : "0");
				
				theOne.mDB.createRecord(Arrays.copyOfRange(FIELD_NAMES,  1,  FIELD_NAMES.length), values);
				recordsCreated++;
			}
			
			fileScanner.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return recordsCreated;
	}
	
	/**
	 * Adds car to database
	 * @param make
	 * @param description
	 * @param horsepower
	 * @param fuelType
	 * @param cityMPG
	 * @param hwyMPG
	 * @param hybrid
	 * @return
	 */
	public boolean addCar(String make, String description, int horsepower, String fuelType, 
			int cityMPG, int hwyMPG, boolean hybrid)
	{
		// Add the car to the database first:
		// Create a new record w/ the values in an array (of String)
		String[] values = {make, description, String.valueOf(horsepower), fuelType, 
				String.valueOf(cityMPG), String.valueOf(hwyMPG), hybrid ? "1" : "0"};
		// Use database to create new record.
		// Capture key (id) that's returned
		try 
		{
			int id = theOne.mDB.createRecord(Arrays.copyOfRange(FIELD_NAMES, 1, FIELD_NAMES.length), values);
			// Make a new Car object and add it to observable list
			theOne.mAllCarsList.add(new Car(id, make, description, horsepower, fuelType, cityMPG, hwyMPG, hybrid));
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			return false;
		}
		return true;
	}
	
	/**
	 * Removes car from database
	 * @param c
	 * @return
	 */
	public boolean deleteCar(Car c)
	{
		if(c == null)
			return false;
		
		theOne.mAllCarsList.remove(c);
		
		try {
			theOne.mDB.deleteRecord(String.valueOf(c.getID()));
		}
		catch (SQLException e)
		{
			return false;
		}
		return true;
	}
}