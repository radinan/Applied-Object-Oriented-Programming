package alertbox;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DialogBoxes extends Application {

    public static void messageDialog(String titleBar, String headerMessage, String infoMessage){
        //defining and setting up the dialog box
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);

        alert.showAndWait();
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        //display alert dialog
        messageDialog("Information alert box", null, "Welcome\nto\njavafx!");
        //quit the app
        Platform.exit();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
