package Phase_1.GUI;

import Phase_1.Entity.Group;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class MainPageController {
    UserManager um;
    GroupManager gm;
    String h;

    public MainPageController(){
    }

    public void setGm(GroupManager gm) {
        this.gm = gm;
    }
    public void setUm(UserManager um) {
        this.um = um;
    }

    public void display() throws IOException {
        Stage window = new Stage();
        window.setTitle("Welcome to main page" );
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainPage.fxml"))), 400, 600);
        window.setScene(scene);
        window.show();
    }
}
