package drawshapeswithdialog;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DrawShapes extends Application {

    public static String inputDialog(String titleBar, String headerMessage, String infoMessage) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(titleBar);
        dialog.setHeaderText(headerMessage);
        dialog.setContentText(infoMessage);

        return dialog.showAndWait().get();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        String input = inputDialog("User choice", "Select shape",
                "Enter 1 to draw rectangles" + "\nEnter 2 to draw ovals");
        int choice = Integer.parseInt(input);

        Rectangle rectangle = new Rectangle();  //shape
        Circle circle = new Circle();   //shape

        Group group = new Group();  //create layout panel
        Scene scene = new Scene(group, 400, 400);   //create scene

        //create shape nodes
        for (int i = 0; i < 10; ++i) {
            switch(choice) {
                case 1: //draw rectangles
                    rectangle = new Rectangle(10 + i*20, 10 + i*20, 40 + i*10, 40 + i*10);
                    rectangle.setStroke(Color.BLACK);
                    rectangle.setFill(null);
                    group.getChildren().add(rectangle);
                    break;
                case 2: //draw ovals
                    circle = new Circle(50 + i*20, 50 + i*20, 40 + i*10);
                    circle.setStroke(Color.BLACK);
                    circle.setFill(null);
                    group.getChildren().add(circle);
                    break;
            }
        }

        primaryStage.setTitle("Drawing shapes in a loop");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
