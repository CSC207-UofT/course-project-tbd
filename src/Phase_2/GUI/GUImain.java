package Phase_2.GUI;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Objects;

public class GUImain extends Application {
    private static Stage stage;

    /**
     *
     * @param primaryStage the main window
     * @throws Exception when error occurs
     */

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("WelcomePage.fxml")));
        primaryStage.setTitle("Group TBD");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();

    }

    /**
     *
     * @param fxml fxml file
     * @throws IOException if errors occur
     */

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stage.getScene().setRoot(pane);
    }

    /**
     * running method
     * @param args args
     */

    public static void main(String[] args){
        launch(args);
    }

    /**
     * add scene to the window
     * @param scene the new scene needed to be added
     */

    public void addScene(Scene scene) {
        stage.setScene(scene);
        stage.show();
    }
}