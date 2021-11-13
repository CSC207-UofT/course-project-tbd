package Phase_1.GUI.src;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class NewUserController implements Initializable {
    GroupManager gm;
    UserManager um;
    @FXML
    Button signUpButton;
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    TextField sQ;
    @FXML
    TextField sA;
    @FXML
    Hyperlink back;
    Label takenUserName;
    Label success;


    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    public void setUm(UserManager um) {
        this.um = um;
    }

    public void signUpButtonPushed(javafx.event.ActionEvent event){
        String userId = username.getText();
        if (!um.checkIfValid(userId)){
            takenUserName.setText("Username " + userId + " has been taken");
        }
        else {
            um.createNormalUser(userId, password.getText(), sQ.getText(), sA.getText());
        }
    }

    public void backPushed(javafx.event.ActionEvent event) throws IOException {
        GUImain guiMain = new GUImain();
        guiMain.changeScene("MainPageGUI.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MainPageController mpc = new MainPageController();
        mpc.setUm(um);
        mpc.setGm(gm);
    }
}
