package Phase_1.GUI;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Objects;

public class GUImain extends Application {
    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WelcomePage.fxml")));
        primaryStage.setTitle("Group TBD");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();

    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stage.getScene().setRoot(pane);
    }

    public static void main(String[] args){
        launch(args);
    }

    public void addScene(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }
}