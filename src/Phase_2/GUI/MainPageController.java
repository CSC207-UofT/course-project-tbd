package Phase_2.GUI;

import Phase_2.UseCaseClass.GroupManager;
import Phase_2.UseCaseClass.UserManager;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;


public class MainPageController implements Initializable {
    UserManager um;
    GroupManager gm;

    @FXML
    Button signInButton;
    @FXML
    Button newUserButton;
    @FXML
    Hyperlink back;


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
        m.changeScene("Main.fxml");
    }

    public void newUserButtonPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewUser.fxml"));
        Parent root = loader.load();
        NewUserController mpc1 = loader.getController();
        mpc1.setUm(um);
        mpc1.setGm(gm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    public void backPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WelcomePage.fxml"));
        Parent root = loader.load();
        WelcomePageController mpc1 = loader.getController();
        mpc1.setUm(um);
        mpc1.setGm(gm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    public void signInButtonPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserLogin.fxml"));
        Parent root = loader.load();
        UserLoginController mpc1 = loader.getController();
        mpc1.setUm(um);
        mpc1.setGm(gm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}