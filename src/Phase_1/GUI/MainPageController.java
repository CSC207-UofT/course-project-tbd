package Phase_1.GUI;

import Phase_1.GUI.src.GUImain;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.fxml.FXML;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;


public class MainPageController implements Initializable {
    UserManager um;
    GroupManager gm;
    @FXML
    Button signInButton;
    @FXML
    Button newUserButton;


    public MainPageController(){
    }

    public void setGm(GroupManager gm) {
        this.gm = gm;
    }
    public void setUm(UserManager um) {
        this.um = um;
    }





    public void display() throws IOException {
        GUImain m = new GUImain();
        System.out.println(um);
        m.changeScene("Main.fxml");
    }

    public void newUserButtonPushed(javafx.event.ActionEvent event) throws IOException {
        GUImain guiMain = new GUImain();
        guiMain.changeScene("NewUser.fxml");
    }

    public void signInButtonPushed(javafx.event.ActionEvent event) throws IOException {
        GUImain guiMain = new GUImain();
        guiMain.changeScene("UserLogin.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
