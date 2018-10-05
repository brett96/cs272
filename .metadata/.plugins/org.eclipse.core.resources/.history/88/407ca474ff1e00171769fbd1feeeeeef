package edu.orangecoastcollege.cs272.p03;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * GUI App to move a ball up, down, left, or right on the screen
 * @author Brett
 *
 */
public class BallMovement extends Application
{
    Circle circle = new Circle();
    Button leftButton = new Button("Left");
    Button rightButton = new Button("Right");
    Button upButton = new Button("Up");
    Button downButton = new Button("Down");

    /**
     * Override start method
     */
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // TODO Auto-generated method stub
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
        box.getChildren().add(leftButton);
        box.getChildren().add(rightButton);
        box.getChildren().add(upButton);
        box.getChildren().add(downButton);
        box.setAlignment(Pos.BOTTOM_CENTER);

        pane.add(box, 0, 10);
        
        leftButton.setOnAction(event -> moveLeft());
        rightButton.setOnAction(event -> moveRight());
        upButton.setOnAction(event -> moveUp());
        downButton.setOnAction(event -> moveDown());

        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ball Movement");
        primaryStage.show();
    }
    
    /**
     * Moves the circle 5 units to the left
     */
    public void moveLeft()
    {
    	circle.setTranslateX(circle.getTranslateX() - 5);
    }
    
    /**
     * Moves the circle 5 units to the right
     */
    public void moveRight()
    {
    	circle.setTranslateX(circle.getTranslateX() + 5);
    }
    
    /**
     * Moves circle 5 units up
     */
    public void moveUp()
    {
    	circle.setTranslateY(circle.getTranslateY() - 5);
    }
    
    /**
     * Moves circle 5 units down
     */
    public void moveDown()
    {
    	circle.setTranslateY(circle.getTranslateY() + 5);
    }

    /**
     * Starts the application
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Application.launch(args);
    }

}
