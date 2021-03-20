package drawsquareshapedspiral;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawSpiral extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group group = new Group();
        Scene scene = new Scene(group, 450, 450);

        double height = scene.getHeight();
        double width = scene.getWidth();

        double centerX = width/2;
        double centerY = height/2;

        double x = width / 10 - 10; //length of the first line (from center)
        //                               _____
        //5 times printing:             |
        //(but every time gets)         |__|
        //(bigger with x)
        for(double i = 0; i < 5*x ; i = i + x) {
            drawLine(group, centerX + i, centerY - i, centerX + i, centerY + x + i);
            drawLine(group, centerX + i, centerY + x + i, centerX - x - i, centerY + x + i);
            drawLine(group, centerX - x - i, centerY + x + i, centerX - x - i, centerY - x - i);
            drawLine(group, centerX - x - i, centerY - x - i, centerX + x + i, centerY - x - i);
        }



        primaryStage.setTitle("Square shaped spiral");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static void drawLine(Group group,  double v, double v1, double v2, double v3) {
        Line line = new Line(v, v1, v2, v3);
        line.setStroke(Color.DEEPPINK);
        line.setStrokeWidth(2);
        group.getChildren().add(line);
    }
}
