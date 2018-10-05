package edu.orangecoastcollege.cs272.btomita.ic07;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * GUI app that shows a circle who's size can be increased or decreased
 * @author Brett Tomita
 *
 */
public class ControlCircle extends Application
{
	Button enlargeButton = new Button("Enlarge");
	Button shrinkButton = new Button("Shrink");
	Circle circle = new Circle();
	
	/**
	 * Creates the application and sets the layout
	 */
	@Override
	public void start(Stage arg0) throws Exception 
	{
		enlargeButton.setOnAction(new EnlargeHandler());
		shrinkButton.setOnAction(new ShrinkHandler());	
		
		GridPane pane = new GridPane();
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(20));
		pane.setAlignment(Pos.BASELINE_CENTER);
		
		circle.setCenterX(100);
		circle.setCenterY(100);
		circle.setRadius(50);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		
		StackPane stack = new StackPane();
		stack.getChildren().add(circle);
		pane.add(stack, 0, 0);
		
		HBox box = new HBox();
		box.setSpacing(20);
		box.getChildren().add(enlargeButton);
		box.getChildren().add(shrinkButton);
		box.setAlignment(Pos.BASELINE_CENTER);
		
		pane.add(box, 0, 1);
		
		Scene scene = new Scene(pane, 250, 200);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Control Circle");
		primaryStage.show();
	}
	
	class EnlargeHandler implements EventHandler<ActionEvent>
	{

		/**
		 * Handles the event of the Enlarge button being pressed
		 */
		@Override
		public void handle(ActionEvent event) 
		{
			// TODO Auto-generated method stub
			circle.setRadius(circle.getRadius() + 2);
		}
	}
	
	class ShrinkHandler implements EventHandler<ActionEvent>
	{

		/**
		 * Handles the event of the Shrink button being pressed
		 */
		@Override
		public void handle(ActionEvent event) 
		{
			// TODO Auto-generated method stub
			circle.setRadius(circle.getRadius() - 2);
		}
	}
	
	/**
	 * Launches the app
	 * @param args
	 */
	public static void main(String[] args)
	{
		Application.launch(args);
	}

}
