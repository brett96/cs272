package edu.orangecoastcollege.cs272.ic08;

import java.text.NumberFormat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * GUI app to calculate tip
 * @author Brett Tomita
 *
 */
public class TipCalculatorFX extends Application {

	// TODO: Create slider for tipPercent
	private Slider tipPercentSlider = new Slider(0, 30, 15);
	/*
	 * slider constructor takes in min, max, and default
	 */
	
	private Label tipPercentLabel = new Label("15%");
	private TextField billAmountTF = new TextField();
	private TextField tipAmountTF = new TextField();
	private TextField totalAmountTF = new TextField();

	private Button calculateButton = new Button("Calculate");
	private Button clearButton = new Button("Clear");

	/**
	 * Overrides start method
	 */
	@Override 
	public void start(Stage primaryStage) 
	{
		// Create UI
		
		// Configure slider properties
		tipPercentSlider.setBlockIncrement(1);	// How much to change each increment (1%)
		tipPercentSlider.setMajorTickUnit(5);	// How often to see ticks
		tipPercentSlider.setShowTickLabels(true);
		tipPercentSlider.setShowTickMarks(true);
		
		// Configure text field properties (not editable, not focusable)
		tipAmountTF.setEditable(false);
		totalAmountTF.setEditable(false);
		tipAmountTF.setFocusTraversable(false);
		totalAmountTF.setFocusTraversable(false);
		
		
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(new Label("Bill Amount:"), 0, 0);
		gridPane.add(billAmountTF, 1, 0);
		gridPane.add(tipPercentLabel, 0, 1);
		gridPane.add(tipPercentSlider, 1, 1);
		gridPane.add(new Label("Tip Amount:"), 0, 2);
		gridPane.add(tipAmountTF, 1, 2);
		gridPane.add(new Label("Total Amount:"), 0, 3);
		gridPane.add(totalAmountTF, 1, 3);


		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER_RIGHT);
		hBox.getChildren().add(clearButton);
		hBox.getChildren().add(calculateButton);
		gridPane.add(hBox, 1, 5);

		// Set properties for UI
		gridPane.setAlignment(Pos.CENTER);
		billAmountTF.setAlignment(Pos.BOTTOM_RIGHT);
		tipAmountTF.setAlignment(Pos.BOTTOM_RIGHT);
		// TODO: make the tipAmountTF not editable and not focusable
		totalAmountTF.setAlignment(Pos.BOTTOM_RIGHT);
		// TODO: make the totalAmountTF not editable and not focusable		
		GridPane.setHalignment(calculateButton, HPos.RIGHT);
		GridPane.setHalignment(clearButton, HPos.RIGHT);

		// TODO: Handle events
		//clearButton.setOnAction(new clearHandler());
		// event = ActionEvent; lambda is saying whenever ActionEvent occurrs, call clear()
		// event can be called anything
		// By default, calls handle() method which in turn calls clear()
		clearButton.setOnAction(event -> clear());
		calculateButton.setOnAction(event -> calculate());
		tipPercentSlider.valueProperty().addListener((obs, oldVal, newVal) -> updateTipPercent(newVal));

		// Create a scene and place it in the stage
		Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setTitle("Tip Calculator"); // Set title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	/**
	 * Calculates new tip
	 * @param newValue
	 */
	public void updateTipPercent(Number newValue)
	{
		// Change text of label
		NumberFormat percent = NumberFormat.getPercentInstance();
		tipPercentLabel.setText(percent.format(newValue.doubleValue()/100));
		calculate();
	}
	
	/**
	 * Clears all values and sets tip slider to 15
	 */
	public void clear()
	{
		billAmountTF.clear();
		tipPercentSlider.setValue(15);
		tipAmountTF.clear();
		totalAmountTF.clear();
	}
	
	/**
	 * Calculates tip from given data
	 */
	public void calculate()
	{
		// Read bill amount as double
		double billAmount = Double.parseDouble(billAmountTF.getText());
		//Read slider as double
		double tipPercent = tipPercentSlider.getValue() / 100;
		// Calculate tip amount
		double tipAmount = billAmount*tipPercent;
		// Calculate total
		double total = billAmount + tipAmount;
		
		// Define currency format (NumberFormat)
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		//Display value in text fields
		tipAmountTF.setText(currency.format(tipAmount));
		totalAmountTF.setText(currency.format(total));
		
	}
	// OLD WAY:
	class clearHandler implements EventHandler<ActionEvent>
	{

		@Override
		public void handle(ActionEvent arg0) 
		{
			// TODO Auto-generated method stub
			clear();
		}
		
	}

	/**
	 * Launches the application
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

}
