package edu.orangecoastcollege.cs272.btomita.ic11.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.orangecoastcollege.cs272.btomita.ic11.model.Car;
import edu.orangecoastcollege.cs272.btomita.ic11.model.DBModel;
import javafx.collections.*;

/**
 * Accepts input from the view and converts it into commands for the model
 * @author Brett
 *
 */
public final class Controller 
{
	//private static final String DB_NAME = "cs272.db";
	private static Controller theOne;
	
	private ObservableList<Car> mAllCars;
	
	private Controller() {}
	
	public static Controller getInstance()
	{
		if (theOne == null)
		{
			theOne = new Controller();
			// Instantiate the all billionares list
			theOne.mAllCars = FXCollections.observableArrayList();
			// Fill list w/ data from database
			// Connect to database
			try {
				// Connect to database
				Connection connection = DBModel.connectToDB();
				// Get all billionaires back from database
				ResultSet rs = DBModel.getAllCars();
				// Loop through result set
				while(rs.next())
				{
					// Add each billionaire to observable list
					int id = rs.getInt(1);
					String make = rs.getString(2);
					String description = rs.getString(3);
					int horsepower = rs.getInt(4);
					String fuelType = rs.getString(5);
					int cityMPG = rs.getInt(6);
					int highwayMPG = rs.getInt(7);
					boolean hybrid = rs.getBoolean(8);
					
					// Make a new billionaire and add to list
					Car c = new Car(id, make, description, horsepower, fuelType, cityMPG, highwayMPG, hybrid);
					theOne.mAllCars.add(c);
				}
			} 
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return theOne;
	}
	
	public ObservableList <String> getDistinctMakes()
	{
		ObservableList<String> makes = FXCollections.observableArrayList();
		makes.add("");
		
		for(Car c : theOne.mAllCars)
		{
			if(!makes.contains(c.getMake()))
				makes.add(c.getMake());
		}
		// Sort citizenships list
		FXCollections.sort(makes);
		
		return makes;
	}
	
	public ObservableList <String> getDistinctFuelTypes()
	{
		ObservableList<String> fuelTypes = FXCollections.observableArrayList();
		fuelTypes.add("");
		// Loop through all billionaires 
		// If citizenship isn't in citizenships list, add it
		for(Car c: theOne.mAllCars)
		{
			if(!fuelTypes.contains(c.getFuelType()))
				fuelTypes.add(c.getFuelType());
		}
		FXCollections.sort(fuelTypes);
		return fuelTypes;
	}
	
	 public ObservableList<Car> filter(String make, String fuelType,
			 double minCityMPG, double minHighwayMPG)
	 {
		 ObservableList<Car> filteredList = FXCollections.observableArrayList();
			
			// Loop through all billionaires
			for(Car c : theOne.mAllCars)
			{
				if((make == null || c.getMake().equals(make))
						&& (fuelType == null || c.getFuelType().equals(fuelType))
						&& (c.getCityMPG() >= minCityMPG && c.getCityMPG() >= minHighwayMPG))
					filteredList.add(c);
			}
			return filteredList;
	 }
	 
	 public ObservableList<Car> getAllCars()
		{
			// Make a defensive copy of the observable list
			return FXCollections.observableArrayList(theOne.mAllCars);
		}

}
