package lineArt;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group();

        //creating rectangular scene, but works also as a square
        //Scene scene = new Scene(group, 450, 600);
        //Scene scene = new Scene(group, 500, 500);
        Scene scene = new Scene(group, 600, 500);

        //storing scene's width and height into variables
        double width = scene.getWidth();
        double height = scene.getHeight();

        //saving the difference in lengths of the width and height
        //(very important when the scene is not a square)
        double difference = width / height;

        //space between the start coordinates of the lines
        double space = 20; //by default is 20


        //      a) NORMAL VIEW:
        //   D                   C
        // (0,0) _____________ (w,0)          w = weight
        //      |             |               h = height
        //      |             |
        //      |             |
        //      |_____________|
        // (0,h)               (w,h)
        //   A                   B


        //     b) REVERSED VIEW:
        //   B                   A
        // (w,h) _____________ (0,h)          w = weight
        //      |             |               h = height
        //      |             |
        //      |             |
        //      |_____________|
        // (w,0)               (0,0)
        //   C                   D


        //1. UP LEFT to DOWN RIGHT
        for (int i = 0; i <= height; i += space) {
            //every line starts from (0,i), where i = [0,height]
            //and ends at (difference*i,height), because if scene's width != height
            //then the spaces on AD and AB are different ( check a) )
            drawLine(group, 0, i, difference * i, height);
        }

        //2. UP RIGHT to DOWN LEFT
        for (double i = 0; i <= height; i += space) {
            //every line starts from (width,i), where i = [0,height]
            //and ends at (width - difference*i,height), analogically to the prev.
            //but here width is decreasing (from "width" to 0)
            drawLine(group, width, i, width - difference * i, height);
        }

        //3. DOWN RIGHT to UP LEFT
        for (double i = height; i >= 0; i -= space) {
            //analogical to 2. but with changed values - check b)
            drawLine(group, 0, i, width - difference * i, 0);
        }

        //4. DOWN LEFT to UP RIGHT
        for (double i = height; i >= 0; i -= space) {
            //analogical to 1. but with changed values - check b)
            drawLine(group, width, i, difference * i, 0);
        }


        primaryStage.setTitle("Line art"); //set the title of the stage
        primaryStage.setScene(scene); //add the scene to the stage
        primaryStage.show(); //show the application window
    }

    //automatically draws AQUA lines wide 0.9, by given start and end (x,y)
    public static void drawLine(Group group, double xStart, double yStart, double xEnd, double yEnd) {
        Line line = new Line(xStart, yStart, xEnd, yEnd);
        line.setStroke(Color.AQUA);
        line.setStrokeWidth(0.8);
        group.getChildren().add(line);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
