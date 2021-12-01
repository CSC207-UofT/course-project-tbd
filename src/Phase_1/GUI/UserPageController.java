package Phase_1.GUI;

import Phase_1.UseCaseClass.CategoryManager;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.NotificationManager;
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
import javafx.stage.Stage;

import java.io.IOException;

public class UserPageController {

    UserManager um;
    GroupManager gm;
    String userName;
    NotificationManager notificationManager = new NotificationManager();

    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    public void setUm(UserManager um) {
        this.um = um;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @FXML
    public Button groupPage;
    @FXML
    public Button categoryPage;
    @FXML
    public Button notificationsPage;
    @FXML
    public Button log_out_button;


    public void categoryButtonPushed() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CategoryPage.fxml"));
        Parent root = loader.load();
        CategoryPageController cpc1 = loader.getController();
        cpc1.setUm(um);
        cpc1.setUserId(userName);
        cpc1.setCm(new CategoryManager());
        cpc1.loadCategoryPane();
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);

    }

    public void groupButtonPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupPageGUI.fxml"));
        Parent root = loader.load();
        GroupPageController mpc1 = loader.getController();
        mpc1.setUm(um);
        mpc1.setGm(gm);
        mpc1.setUserId(userName);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);

    }

    public void NotificationButtonPushed() throws IOException {


        FXMLLoader loader = new FXMLLoader(getClass().getResource("NotificationPage.fxml"));
        Parent root = loader.load();
        NotificationPageController notificationPageController = loader.getController();

        notificationPageController.setNotificationManager(notificationManager);
        notificationPageController.setPreviousScene(notificationsPage.getScene());

        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    public void LogoutButtonPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserLogin.fxml"));
        Parent root = loader.load();
        UserLoginController mpc = loader.getController();
        mpc.setUm(um);
        mpc.setGm(gm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

}