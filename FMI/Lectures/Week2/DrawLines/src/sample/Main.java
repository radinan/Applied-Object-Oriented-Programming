package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group();
        Scene scene = new Scene(group, 300, 250);

        //save total width and height of the scene in variables
        double width = scene.getWidth();
        double height = scene.getHeight();

        //draw line from up left to down right
        Line line = new Line (0, 0, width, height);
        line.setStroke(Color.BLUE);
        line.setStrokeWidth(2);
        group.getChildren().add(line);

        //draw line from down left to up right
        line = new Line (0, height, width, 0);
        line.setStroke(Color.BLUE);
        line.setStrokeWidth(2);
        group.getChildren().add(line);

        //setting title of the app window
        primaryStage.setTitle("Draw lines");
        //adding scene to the stage
        primaryStage.setScene(scene);

        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
