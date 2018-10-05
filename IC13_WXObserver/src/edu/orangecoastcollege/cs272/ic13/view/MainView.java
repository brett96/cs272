package edu.orangecoastcollege.cs272.ic13.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.ic13.controller.WeatherController;
import edu.orangecoastcollege.model.WeatherObservation;
import edu.orangecoastcollege.model.WeatherStation;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class MainView extends Application implements Initializable 
{
	// Whenever you need to share a name between Java code and an XML design, use
	// @FXML annotation
	@FXML
	private ComboBox<WeatherStation> stationCB;
	@FXML
	private TextArea weatherTA;
	
	private WeatherController controller = new WeatherController();
	// Initialize method comes from Initializable interface
	// Executes, once, fill combo box from Controller
	// Put starting message in the weatherTA
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		weatherTA.setText("Please select station from combo box above.");
		// Never ever ever make new Node objects (FXML instantiates them for us)
		stationCB.setItems(controller.getCAWeatherStations());
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		primaryStage.setTitle("Current California Weather Observations");
		Scene scene = new Scene(FXMLLoader.load(getClass().getResource("WeatherObserverScene.fxml")));
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Gets weather observation
	 * @return
	 */
	@FXML
	public Object getWeatherObservation()
	{
		// Get selected WeatherStation from combobox
		WeatherStation selectedStation = stationCB.getSelectionModel().getSelectedItem();
		// Use the controller to get a WeatherObservation
		WeatherObservation currentObservation = controller.getCurrentWeather(selectedStation.getXMLURL());
		weatherTA.setText(currentObservation.toString());
		return currentObservation;
	}

	/**
	 * Launches app
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Application.launch(args);

	}

}
