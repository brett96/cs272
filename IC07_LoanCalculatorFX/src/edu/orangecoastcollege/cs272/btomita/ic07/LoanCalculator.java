package edu.orangecoastcollege.cs272.btomita.ic07;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * GUI app to calculate loans
 * @author Brett Tomita
 *
 */
public class LoanCalculator extends Application 
{
	private TextField annualInterestTF = new TextField();
	private TextField numberYearsTF = new TextField();
	private TextField loanAmountTF = new TextField();
	private TextField monthlyPaymentTF = new TextField();
	private TextField totalPaymentTF = new TextField();
	
	Button calculateButton = new Button("Calculate");
	Button clearButton = new Button("Clear");

	/**
	 * Creates the app; sets layout
	 */
	@Override
	public void start(Stage arg0) throws Exception 
	{
		// Associate Buttons with their EventHandler
		clearButton.setOnAction(new ClearHandler());
		calculateButton.setOnAction(new CalculateHandler());
		
		// Make last 2 text fields un-editable
		monthlyPaymentTF.setEditable(false);
		totalPaymentTF.setEditable(false);
		
		// Define a GridPane (layout)
		GridPane pane = new GridPane();
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setPadding(new Insets(20));
		pane.setAlignment(Pos.BASELINE_CENTER);
		pane.add(new Label("Annual Interest Rate:"), 0, 0);
		pane.add(annualInterestTF, 1, 0);
		pane.add(new Label("Number of Years: "), 0, 1);
		pane.add(numberYearsTF, 1, 1);
		pane.add(new Label("Loan Amount: "), 0, 2);
		pane.add(loanAmountTF, 1, 2);
		pane.add(new Label("Monthly Payment: "), 0, 3);
		pane.add(monthlyPaymentTF, 1, 3);
		pane.add(new Label("Total Payment"), 0, 4);
		pane.add(totalPaymentTF, 1, 4);
		annualInterestTF.setAlignment(Pos.BASELINE_RIGHT);
		numberYearsTF.setAlignment(Pos.BASELINE_RIGHT);
		loanAmountTF.setAlignment(Pos.BASELINE_RIGHT);
		monthlyPaymentTF.setAlignment(Pos.BASELINE_RIGHT);
		totalPaymentTF.setAlignment(Pos.BASELINE_RIGHT);
		
		// Add buttons into HBox (horizontal box)
		HBox box = new HBox();
		box.setSpacing(20);
		box.getChildren().add(clearButton);
		box.getChildren().add(calculateButton);
		
		pane.add(box, 1, 5);
		
		
		// Make a scene
		Scene scene = new Scene(pane, 400, 250);
		
		Stage primaryStage = new Stage();
		// Set Scene on Stage
		primaryStage.setScene(scene);
		primaryStage.setTitle("Loan Calculator");
		
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
	
	// Inner class = class w/in class
	class ClearHandler implements EventHandler<ActionEvent>
	{

		/**
		 * Handles the event of the clear button being pressed
		 */
		@Override
		public void handle(ActionEvent event) 
		{
			annualInterestTF.setText("");
			numberYearsTF.setText("");
			loanAmountTF.setText("");
			monthlyPaymentTF.setText("");
			totalPaymentTF.setText("");
			
		}
	}
	
	class CalculateHandler implements EventHandler<ActionEvent>
	{

		/**
		 * Handles the event of the calculate button being pressed
		 */
		@Override
		public void handle(ActionEvent arg0) 
		{
			// Define variables for each input:
			double annualInterest = Double.parseDouble(annualInterestTF.getText());
			annualInterest /= 100;
			annualInterest /= 12;
			double numOfYears = Double.parseDouble(numberYearsTF.getText());
			double loanAmount = Double.parseDouble(loanAmountTF.getText());
			
			double payment = loanAmount*(annualInterest/(1 - Math.pow(1 + annualInterest, -numOfYears*12)));
			String monthlyPayment = String.format("%.2f", payment);
			String totalPayment = String.format("%.2f", payment * (12*numOfYears));
			
			monthlyPaymentTF.setText("$" + monthlyPayment);
			totalPaymentTF.setText("$" + totalPayment);
		}
	}
}
