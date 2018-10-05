package edu.orangecoastcollege.cs272.ic14.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.ic14.controller.Controller;
import edu.orangecoastcollege.cs272.ic14.model.VideoGame;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class VideoGamesListScene implements Initializable {

	private static Controller controller = Controller.getInstance();

	@FXML
	private ListView<VideoGame> allVideoGamesLV;
	@FXML
	private ComboBox<String> publishersCB;
	@FXML
	private ComboBox<String> platformsCB;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Populate combo box
		platformsCB.setItems(controller.getDistinctPlatforms());
		publishersCB.setItems(controller.getDistinctPublishers());
		
		// Populate list view
		allVideoGamesLV.setItems(controller.getAllVideoGames());
		
	}
	
	@FXML
	public Object addGameToInventory()
	{
		//TODO: Complete this method
		// Find out the selected video game to add
		VideoGame selectedGame = allVideoGamesLV.getSelectionModel().getSelectedItem();
		controller.addGameToUsersInventory(selectedGame);
		return this;
	}
	
	@FXML
	public Object viewInventory()
	{
		//TODO: Complete this method
		ViewNavigator.loadScene("Inventory", ViewNavigator.VIEW_INVENTORY_SCENE);
		return this;
	}

}
