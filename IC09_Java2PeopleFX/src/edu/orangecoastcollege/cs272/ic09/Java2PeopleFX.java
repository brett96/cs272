package edu.orangecoastcollege.cs272.ic09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * GUI App that implements a database to store people's names
 * @author Brett
 *
 */
public class Java2PeopleFX extends Application 
{
	// Make variable to store next id
	int nextID;

	TextField nameTF = new TextField();
	Button addBtn = new Button("Add Person");
	ListView<String> namesLV = new ListView<>();
	ObservableList<String> allNamesList = FXCollections.observableArrayList();

	/**
	 * Overrides the start method
	 */
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		// Populate from database first
		populateFromDB();
		
		// Associate namesLV w/ observable list
		namesLV.setItems(allNamesList);
		
		GridPane pane = new GridPane();
		pane.add(new Label("Names:"), 0, 0);
		
		pane.add(namesLV, 0, 1);
		
		HBox box = new HBox();
		box.getChildren().add(nameTF);
		box.getChildren().add(addBtn);
		box.setSpacing(25.0);
		pane.add(box, 0, 2);		
		
		Scene scene = new Scene(pane);			
		primaryStage.setTitle("Java 2 People");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		addBtn.setOnAction(e -> handleAddButton());
	}
	
	private void populateFromDB()
	{
		// Class.forName loads an external package (.jar file)
		try 
		{
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Establish a connection to the database:
		Connection connection = null;
		
		try 
		{
			// Only have to make one connection to database
			connection = DriverManager.getConnection("jdbc:sqlite:cs272.db");
			// Reuse stmt variable to execute every statement (many times)
			Statement stmt = connection.createStatement();
			// Define timeout (if query takes too long, kill it (after 30 sec)) so db won't hang
			stmt.setQueryTimeout(30);
			
			// Issue a create statement to create people table w/ fields id (INTEGER) and name (TEXT)
			// Clause: IF NOT EXISTS - prevents duplication
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS people (id INTEGER PRIMARY KEY, name TEXT)");
			
			// Query table to see if it has pre-existing data
			// Queries return ResultSet (set of results)
			ResultSet rs = stmt.executeQuery("SELECT * FROM people ORDER BY name");
			
			// Loop through result set, add each name to ObservableList
			while(rs.next())
			{
				// Extract just name from result set
				int id = rs.getInt("id");
				if(id + 1 > nextID)
					nextID = id + 1;
				String name = rs.getString("name");
				// Add name to allNamesList
				allNamesList.add(name);
			}
			// All done w/ database connection; close it
			connection.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds an item to the database
	 * @param id
	 * @param name
	 */
	public void addToDB(int id, String name)
	{
		// Class.forName loads an external package (.jar file)
		try 
		{
			Class.forName("org.sqlite.JDBC");
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Establish a connection to the database:
		Connection connection = null;
		
		try 
		{
			// Only have to make one connection to database
			connection = DriverManager.getConnection("jdbc:sqlite:CS272.db");
			// Reuse stmt variable to execute every statement (many times)
			Statement stmt = connection.createStatement();
			// Define timeout (if query takes too long, kill it (after 30 sec)) so db won't hang
			stmt.setQueryTimeout(30);
			
			stmt.executeUpdate("INSERT INTO people VALUES (" + id + ", '" + name + "')");
			// All done w/ database connection; close it
			connection.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void handleAddButton()
	{
		String name = nameTF.getText();
		// Add name to database
		addToDB(nextID, name);
		// Add name to observable list
		allNamesList.add(name);
		nameTF.clear();
		// Put mouse cursor back in text field;
		nameTF.requestFocus();
		
		// Increment nextID
		nextID++;
	}

	/**
	 * Starts the app
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}
	
}
