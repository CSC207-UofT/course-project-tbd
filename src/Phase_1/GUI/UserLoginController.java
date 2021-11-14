package Phase_1.GUI;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserLoginController implements Initializable{

    GroupManager gm;
    UserManager um;

    @FXML
    Button LoginButton;
    @FXML
    Label WrongLogin;
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Label SuccessLogin;


    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    public void setUm(UserManager um) {
        this.um = um;
    }

    public void LoginButtonPushed() throws IOException {
        GUImain guiMain = new GUImain();

        WrongLogin.setText("");
        SuccessLogin.setText("");

        String userId = username.getText();
        String passwordId = password.getText();

        if (username.getText().isEmpty() && password.getText().isEmpty()) {
            WrongLogin.setText("Please enter your data.");
        }
        else if (um.login(userId, passwordId)){
            SuccessLogin.setText("Success!");
            guiMain.changeScene("HomePage.fxml");
        }
        else {
            WrongLogin.setText("Wrong username or Password. Try Again!");
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
