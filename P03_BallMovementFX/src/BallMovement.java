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

public class BallMovement extends Application
{
    Circle circle = new Circle();
    Button leftButton = new Button("Left");
    Button rightButton = new Button("Right");
    Button upButton = new Button("Up");
    Button downButton = new Button("Down");

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
        box.setAlignment(Pos.BASELINE_CENTER);

        pane.add(box, 0, 1);

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Control Circle");
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Application.launch(args);
    }

}
