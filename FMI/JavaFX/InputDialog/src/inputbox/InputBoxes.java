package inputbox;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class InputBoxes extends Application {

    public static void messageDialog(String titleBar, String headerMessage, String infoMessage) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);

        alert.showAndWait();
    }

    public static String inputDialog(String titleBar, String headerMessage, String infoMessage) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(titleBar);
        dialog.setHeaderText(headerMessage);
        dialog.setContentText(infoMessage);
        //traditional way to get the response value
        return dialog.showAndWait().get();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        //set inputDialog and get user input
        String name = inputDialog("User Input", null, "What's your name?");
        //create the message
        String message = String.format("Welcome, %s, to javafx programming!", name);
        //display the welcome message to welcome the user by name
        messageDialog("Name dialog", "Reply", message);
        //exit app
        Platform.exit();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
