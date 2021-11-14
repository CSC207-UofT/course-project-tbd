package Phase_1.GUI;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    @FXML
    Label takenUserName;
    @FXML
    Label success;



    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    public void setUm(UserManager um) {
        this.um = um;
    }

    public void signUpButtonPushed(){
        takenUserName.setText("");
        success.setText("");

        String userId = username.getText();
        if (!um.checkIfValid(userId)){
            takenUserName.setText("Username " + userId + " already taken");

        }
        else {

            um.createNormalUser(userId, password.getText(), sQ.getText(), sA.getText());
            success.setText("User " + userId +" created");
        }
    }

    public void backPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
        Parent root = loader.load();
        MainPageController mpc = loader.getController();
        mpc.setUm(um);
        mpc.setGm(gm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}