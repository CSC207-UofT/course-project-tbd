package Phase_1.GUI;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.util.Objects;

public class GUImain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent layout = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NewUser.fxml")));

        Scene scene = new Scene(layout, 400, 600); // Layout of the window
        stage.setTitle("TBD's Productivity App"); // title of the window

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}

