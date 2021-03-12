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
        Scene scene = new Scene(group, 400, 400);

        //saving scene's width and height into variables
        double width = scene.getWidth();
        double height = scene.getHeight();

        //draw line up left corner to down right corner
        drawLine(group, 0, 0, width, height);

        //draw line down left corner to up right corner
        drawLine(group, 0, height, width, 0);

        // D ___________ C          O is the crossing point of AC and DB
        //  |           |
        //  |     .     |
        //  |     O     |
        //  |___________|
        // A             B

        //draw lines on both sides of OA
        drawLinesOA(group, width / 20, width / 2, height / 2, height, width);

        //draw lines on both sides of OB
        drawLinesOB(group, width / 20, width / 2, height / 2, height, width);

        //draw lines on both sides of OC
        drawLinesOC(group, width / 20, width / 2, height / 2, height, width);

        //draw lines on both sides of OD
        drawLinesOD(group, width / 20, width / 2, height / 2, height, width);


        primaryStage.setTitle("Line art");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void drawLine(Group group,  double v, double v1, double v2, double v3) {
        Line line = new Line(v, v1, v2, v3);
        line.setStroke(Color.DARKORANGE);
        line.setStrokeWidth(1);
        group.getChildren().add(line);
    }

    public static void drawLinesOA(Group group, double space, double currentHeight,
                                   double currentWidth, double height, double width) {
        while(currentHeight < height && currentWidth > 0) {
            drawLine(group, width, height, currentWidth - space, currentHeight + space); //from point B
            drawLine(group, 0, 0, currentWidth - space, currentHeight + space); //from point D

            currentWidth -= space;
            currentHeight += space;
        }
    }

    public static void drawLinesOB(Group group, double space, double currentHeight,
                                   double currentWidth, double height, double width) {
        while(currentHeight < height && currentWidth < width) {
            drawLine(group, 0, height, currentWidth + space, currentHeight + space); //from point A
            drawLine(group, width, 0, currentWidth + space, currentHeight + space); //from point C

            currentWidth += space;
            currentHeight += space;
        }
    }

    public static void drawLinesOC(Group group, double space, double currentHeight,
                                   double currentWidth, double height, double width) {
        while(currentHeight > 0 && currentWidth < width) {
            drawLine(group, width, height, currentWidth + space, currentHeight - space); //from point B
            drawLine(group, 0, 0, currentWidth + space, currentHeight - space); //from point A

            currentWidth += space;
            currentHeight -= space;
        }
    }

    public static void drawLinesOD(Group group, double space, double currentHeight,
                                   double currentWidth, double height, double width) {
        while(currentHeight > 0 && currentWidth > 0) {
            drawLine(group, width, 0, currentWidth - space, currentHeight - space); //from point C
            drawLine(group, 0, height, currentWidth - space, currentHeight - space); //from point A

            currentWidth -= space;
            currentHeight -= space;
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
