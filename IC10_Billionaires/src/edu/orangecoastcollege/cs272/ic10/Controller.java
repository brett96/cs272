package edu.orangecoastcollege.cs272.ic10;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// If add "final" to class definition, it cannot have any derived classes (can't be subclassed)
/**
 * Accepts input from the view and converts it into commands for the model
 * @author Brett
 *
 */
public final class Controller {

	private static final String DB_NAME = "cs272.db";
	
	// Define a static reference to the one controller object
	// Static means only one copy for the entire class
	private static Controller theOne = null;
	
	// mAllBillionaires stores Billionaire objects created from database
	// Much faster access because in RAM instead of on hard disk
	private ObservableList<Billionaire> mAllBillionaires;
	
	
	// Define private constructor so no other classes can instantiate objects
	private Controller() {}
	
	public static Controller getInstance()
	{
		// Check to see if theOne is null
		// If it is, instantiate it
		if (theOne == null)
		{
			theOne = new Controller();
			// Instantiate the all billionares list
			theOne.mAllBillionaires = FXCollections.observableArrayList();
			// Fill list w/ data from database
			// Connect to database
			try {
				// Connect to database
				Connection connection = DBModel.connectToDB(DB_NAME);
				// Get all billionaires back from database
				ResultSet rs = DBModel.getAllBillionaires(connection);
				// Loop through result set
				while(rs.next())
				{
					// Add each billionaire to observable list
					int id = rs.getInt(1);
					String name = rs.getString(2);
					int age = rs.getInt(3);
					String gender = rs.getString(4);
					double worth = rs.getDouble(5);
					String citizenship = rs.getString(6);
					String sector = rs.getString(7);
					boolean political = rs.getBoolean(8);
					
					// Make a new billionaire and add to list
					Billionaire b = new Billionaire(id, name, age, gender, worth, citizenship, sector, political);
					theOne.mAllBillionaires.add(b);
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
	
	public ObservableList<String> getDistinctCitizenships()
	{
		ObservableList<String> citizenships = FXCollections.observableArrayList();
		citizenships.add("");
		// Loop through all billionaires 
		// If citizenship isn't in citizenships list, add it
		for(Billionaire b : theOne.mAllBillionaires)
		{
			if(!citizenships.contains(b.getCitizenship()))
				citizenships.add(b.getCitizenship());
		}
		// Sort citizenships list
		FXCollections.sort(citizenships);
		return citizenships;
	}
	
	public ObservableList<String> getDistinctSectors()
	{
		ObservableList<String> sectors = FXCollections.observableArrayList();
		sectors.add("");
		// Loop through all billionaires 
		// If citizenship isn't in citizenships list, add it
		for(Billionaire b : theOne.mAllBillionaires)
		{
			if(!sectors.contains(b.getSector()))
				sectors.add(b.getSector());
		}
		FXCollections.sort(sectors);
		return sectors;
	}
	
	public ObservableList<Billionaire> filter(String citizenship, String sector, 
			double minWorth, double maxWorth)
	{
		ObservableList<Billionaire> filteredList = FXCollections.observableArrayList();
		
		// Loop through all billionaires
		for(Billionaire b : theOne.mAllBillionaires)
		{
			if((citizenship == null || b.getCitizenship().equals(citizenship))
					&& (sector == null || b.getSector().equals(sector))
					&& (b.getWorth() >= minWorth && b.getWorth() <= maxWorth))
				filteredList.add(b);
				
				
		}
		
		return filteredList;
	}

	public ObservableList<Billionaire> getAllBillionaires()
	{
		// Make a defensive copy of the observable list
		return FXCollections.observableArrayList(theOne.mAllBillionaires);
	}
}
