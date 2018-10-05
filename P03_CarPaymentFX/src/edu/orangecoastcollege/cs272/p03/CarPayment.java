package edu.orangecoastcollege.cs272.p03;

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
 * GUI App that calculates monthly car payment
 * @author Brett
 *
 */
public class CarPayment extends Application 
{
	private Slider yearsSlider = new Slider(2, 5, 2);
	
	private Label yearsLabel = new Label("Years");
	private TextField carPriceTF = new TextField();
	private TextField downPaymentTF = new TextField();
	private TextField interestRateTF = new TextField();
	private TextField monthlyPaymentTF = new TextField();

	private Button calculateButton = new Button("Calculate");
	private Button clearButton = new Button("Clear");

	/**
	 * Overrides start method
	 */
	@Override 
	public void start(Stage primaryStage) 
	{
		yearsSlider.setBlockIncrement(5);	
		yearsSlider.setSnapToTicks(true);
		yearsSlider.setMajorTickUnit(1);
		//yearsSlider.setMinorTickCount(0);
		yearsSlider.setShowTickLabels(true);
		yearsSlider.setShowTickMarks(true);
		
		monthlyPaymentTF.setEditable(false);
		monthlyPaymentTF.setFocusTraversable(false);
		
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(new Label("Car Price $"), 0, 0);
		gridPane.add(carPriceTF, 1, 0);
		gridPane.add(yearsLabel, 0, 1);
		gridPane.add(yearsSlider, 1, 1);
		gridPane.add(new Label("Down Payment $ "), 0, 2);
		gridPane.add(downPaymentTF, 1, 2);
		gridPane.add(new Label("Interest Rate % "), 0, 3);
		gridPane.add(interestRateTF, 1, 3);
		gridPane.add(new Label("Monthly Payment $ "), 0, 4);
		gridPane.add(monthlyPaymentTF, 1, 4);


		HBox hBox = new HBox();
		hBox.setSpacing(10);
		hBox.setAlignment(Pos.CENTER_RIGHT);
		hBox.getChildren().add(clearButton);
		hBox.getChildren().add(calculateButton);
		gridPane.add(hBox, 1, 5);

		gridPane.setAlignment(Pos.CENTER);
		carPriceTF.setAlignment(Pos.BOTTOM_RIGHT);
		downPaymentTF.setAlignment(Pos.BOTTOM_RIGHT);
		interestRateTF.setAlignment(Pos.BOTTOM_RIGHT);	
		monthlyPaymentTF.setAlignment(Pos.BOTTOM_RIGHT);
		GridPane.setHalignment(calculateButton, HPos.RIGHT);
		GridPane.setHalignment(clearButton, HPos.RIGHT);

		clearButton.setOnAction(event -> clear());
		calculateButton.setOnAction(event -> calculate());
		//yearsSlider.valueProperty().addListener((obs, oldVal, newVal) -> updateYears(newVal));

		Scene scene = new Scene(gridPane, 400, 250);
		primaryStage.setTitle("Car Payment"); 
		primaryStage.setScene(scene); 
		primaryStage.show();
	}
	
	/**
	 * Clears all values and sets slider to 2
	 */
	public void clear()
	{
		carPriceTF.clear();
		yearsSlider.setValue(2);
		downPaymentTF.clear();
		interestRateTF.clear();
	}
	
	/**
	 * Calculates monthly payment from given data
	 */
	public void calculate()
	{
		double principal = Double.parseDouble(carPriceTF.getText()) - Double.parseDouble(downPaymentTF.getText());

		int numMonths = (int) (yearsSlider.getValue() * 12);

		double interestRate = (Double.parseDouble(interestRateTF.getText()) / 100) / 12;
		
		double monthlyPayment = principal * (interestRate*Math.pow(1 + interestRate, numMonths))
				/ (Math.pow(1 + interestRate, numMonths) - 1);
		

		NumberFormat currency = NumberFormat.getCurrencyInstance();

		monthlyPaymentTF.setText(currency.format(monthlyPayment));
		
	}

	/**
	 * Launches the application
	 * @param args
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

}

