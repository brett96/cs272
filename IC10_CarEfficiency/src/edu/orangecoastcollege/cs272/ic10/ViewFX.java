package edu.orangecoastcollege.cs272.ic10;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Creates GUI App to represent database
 * @author Brett
 *
 */
public class ViewFX extends Application {

	Controller controller = Controller.getInstance();

	ComboBox<String> makesCB;
	ComboBox<String> fuelTypesCB;
	Slider minCityMPGSlider = new Slider(0.0, 80.0, 0.0);
	Slider minHighWayMPGSlider = new Slider(0.0, 80.0, 80.0);

	ObservableList<Car> carsList;
	ListView<Car> carsLV = new ListView<>();

	@Override
	public void start(Stage primaryStage) throws Exception 
	{

		// Associate the employeesLV with the observable list
		carsList = controller.getAllCars();
		carsLV.setItems(carsList);
		carsLV.setPrefWidth(800);

		makesCB = new ComboBox<>(controller.getDistinctMakes());		
		makesCB.setOnAction(e -> filter());
		fuelTypesCB = new ComboBox<>(controller.getDistinctFuelTypes());
		fuelTypesCB.setOnAction(e -> filter());

		minCityMPGSlider.setShowTickMarks(true);
		minCityMPGSlider.setShowTickLabels(true);
		minCityMPGSlider.setMajorTickUnit(5.0f);
		minCityMPGSlider.setBlockIncrement(1.0f);
		// Associate slider w/ filter()
		minCityMPGSlider.setOnMouseDragged(e -> filter());

		minHighWayMPGSlider.setShowTickMarks(true);
		minHighWayMPGSlider.setShowTickLabels(true);
		minHighWayMPGSlider.setMajorTickUnit(5.0f);
		minHighWayMPGSlider.setBlockIncrement(1.0f);
		minHighWayMPGSlider.setOnMouseDragged(e -> filter());

		GridPane pane = new GridPane();
		pane.setHgap(10.0);
		pane.add(new Label("Filters:"), 0, 0);
		pane.add(new Label("Make:"), 0, 1);
		pane.add(makesCB, 1, 1);

		pane.add(new Label("Fuel Type:"), 0, 2);
		pane.add(fuelTypesCB, 1, 2);

		pane.add(new Label("Min City MPG:"), 0, 3);
		pane.add(minCityMPGSlider, 1, 3);

		pane.add(new Label("Min Highway MPG:"), 0, 4);
		pane.add(minHighWayMPGSlider, 1, 4);
		
		pane.add(carsLV, 0, 5, 2, 1);		

		Scene scene = new Scene(pane, 800, 400);
		primaryStage.setTitle("The World's Cars");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void filter() 
	{
		carsList = controller.filter(makesCB.getSelectionModel().getSelectedItem()
				, fuelTypesCB.getSelectionModel().getSelectedItem(), 
				minCityMPGSlider.getValue(), minHighWayMPGSlider.getValue());
		carsLV.setItems(carsList);
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}

