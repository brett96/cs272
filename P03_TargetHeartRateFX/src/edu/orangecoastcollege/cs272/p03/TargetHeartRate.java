package edu.orangecoastcollege.cs272.p03;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TargetHeartRate extends Application
{
    private TextField ageTF = new TextField();
    private TextField maxHeartRateTF = new TextField();
    private TextField targetHeartRateTF = new TextField();

    private Button calculateButton = new Button("Calculate");
    private Button clearButton = new Button("Clear");

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        // TODO Auto-generated method stub
        maxHeartRateTF.setEditable(false);
        targetHeartRateTF.setEditable(false);
        maxHeartRateTF.setFocusTraversable(false);
        targetHeartRateTF.setFocusTraversable(false);

        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.add(new Label("Your Age:"), 0, 0);
        pane.add(ageTF, 1, 0);
        pane.add(new Label("Maximum Heart Rate:"), 0, 1);
        pane.add(maxHeartRateTF, 1, 1);
        pane.add(new Label("Target Heart Rate:"), 0, 2);
        pane.add(targetHeartRateTF, 1, 2);

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.getChildren().add(clearButton);
        hBox.getChildren().add(calculateButton);
        pane.add(hBox, 1, 4);

        pane.setAlignment(Pos.CENTER);
        ageTF.setAlignment(Pos.BOTTOM_RIGHT);
        maxHeartRateTF.setAlignment(Pos.BOTTOM_RIGHT);
        targetHeartRateTF.setAlignment(Pos.BOTTOM_RIGHT);

        pane.setHalignment(calculateButton, HPos.RIGHT);
        pane.setHalignment(clearButton, HPos.RIGHT);

        clearButton.setOnAction(event -> clear());
        calculateButton.setOnAction(event -> calculate());

        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Target Heart Rate"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

    }

    public void calculate()
    {
        int maxHR = 220 - Integer.parseInt(ageTF.getText());
        maxHeartRateTF.setText(Integer.toString(maxHR) + " BPM");

        int lowTarget = (int) (maxHR * .5);
        int highTarget = (int) (maxHR * .85);
        String targetHR = lowTarget + " - " + highTarget + " BPM";
        targetHeartRateTF.setText(targetHR);
    }

    public void clear()
    {
        ageTF.clear();
        maxHeartRateTF.clear();
        targetHeartRateTF.clear();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}
