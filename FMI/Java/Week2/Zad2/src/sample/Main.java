package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group(); // Create a layout Panel
        Scene scene = new Scene(group, 300, 250);// Create the Scene

        // add content to the Layout panel
        double width = scene.getWidth(); // total width of the scene
        double height = scene.getHeight(); // total width of the scene


        double x = width / 2.0,
               y = height / 2.0,
               radius = 10;

        for(int i = 0; i < 12; ++i) {
            Circle circle = new Circle(x, y, radius);
            circle.setFill(null);
            circle.setStroke(Color.BLACK);
            group.getChildren().add(circle);

            radius += 10;
        }
        double diameter = (radius - 10) * 2.0,
                startHeight = (height - diameter) / 2.0,
                endHeight = startHeight + diameter,
                startWidth = (width - diameter) / 2.0,
                endWidth = startWidth + diameter;

        // draw a line from the upper-mid to the lower-mid
        Line line = new Line(x, startHeight, x, endHeight);
        line.setStroke(Color.RED);
        line.setStrokeWidth(2);
        group.getChildren().add(line);
        // draw a line from the lower-left to the upper-right
        line = new Line(startWidth, height / 2, endWidth, height / 2);
        line.setStroke(Color.RED);
        line.setStrokeWidth(2);
        group.getChildren().add(line);


        // Set the title of the Stage(the application window)
        primaryStage.setTitle("Drawing shapes");
        // Add the Scene to the Stage
        primaryStage.setScene(scene);
        // Show the Stage (the application window)
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
