package edu.orangecoastcollege.cs272.ic06;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * GUI project with fields for names and a button to add a name
 * @author Brett Tomita
 *
 */
public class UserFlowFX extends Application {

	/**
	 * Constructs the GUI
	 */
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		// TODO Auto-generated method stub
		
		//primaryStage = primary window
		
		// Define layout (GridPane to use:
		GridPane pane = new GridPane();
		
		// Define Horizontal Gap
		pane.setHgap(10);
		
		// Define Vertical Gap 
		pane.setVgap(10);
		
		// Define padding
		pane.setPadding(new Insets(20));
		
		// Add a new label to GridPane at (0,0)
		pane.add(new Label("First Name:"), 0, 0);
		TextField firstNameTF = new TextField();
		pane.add(new TextField(), 1, 0);
		
		pane.add(new Label("MI:"), 0, 1);
		TextField miTF = new TextField();
		pane.add(new TextField(), 1, 1);
		
		pane.add(new Label("Last Name"), 0, 2);
		TextField lastNameTF = new TextField();
		pane.add(lastNameTF,  1, 2);
		
		Button addNameButton = new Button("Add Name");
		pane.add(addNameButton, 1, 3);
		GridPane.setHalignment(addNameButton, HPos.RIGHT);
		
		// Make new scene
		Scene scene = new Scene(pane);
		
		// Use primary stage to set scene
		primaryStage.setScene(scene);
		
		// Use primaryStage to set title
		primaryStage.setTitle("User Info");
		
		// Show stage
		primaryStage.show();

	}

	/**
	 * Launches the application
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Application.launch(args);
	}

}
