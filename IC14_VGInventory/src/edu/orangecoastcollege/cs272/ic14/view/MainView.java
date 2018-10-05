package edu.orangecoastcollege.cs272.ic14.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {		
		// Set stage only needs to be called once for the view navigator
		ViewNavigator.setStage(primaryStage);
		ViewNavigator.loadScene("Welcome to VG in.vent.ory", ViewNavigator.SIGN_IN_SCENE);
	}
	
	/**
	 * Launches application
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);

	}

}
