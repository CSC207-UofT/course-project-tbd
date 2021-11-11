package Phase_1.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUImain extends Application {
    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("GroupPageGUI.fxml"));
        Scene scene = new Scene(root, 400, 600);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}

