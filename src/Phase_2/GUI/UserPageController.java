package Phase_2.GUI;

import Phase_2.GUImain;
import Phase_2.UseCaseClass.*;
import javafx.fxml.FXML;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class UserPageController {

    UserManager um;
    GroupManager gm;
    String userName;
    NotificationManager notificationManager;

    /**
     * Setter methods
     */
    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    public void setUm(UserManager um) {
        this.um = um;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNotificationManager(NotificationManager notificationManager){
        this.notificationManager = notificationManager;
    }

    @FXML
    public Button groupPage;
    @FXML
    public Button categoryPage;
    @FXML
    public Button notificationsPage;
    @FXML
    public Button log_out_button;

    /**
     * Go to the category page when button is pushed
     */
    public void categoryButtonPushed() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/CategoryPage.fxml"));
        Parent root = loader.load();
        CategoryPageController cpc1 = loader.getController();
        cpc1.setUm(um);
        cpc1.setUserId(userName);
        cpc1.setCm(new CategoryManager());
        cpc1.setNm(notificationManager);
        cpc1.setPreviousScene(categoryPage.getScene());
        cpc1.loadCategoryPane();
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);

    }

    /**
     * Go to the group page when button is pushed
     */
    public void groupButtonPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/GroupPageGUI.fxml"));
        Parent root = loader.load();
        GroupPageController mpc1 = loader.getController();
        mpc1.setUm(um);
        mpc1.setGm(gm);
        mpc1.setUserId(userName);
        mpc1.setNm(notificationManager);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);

    }

    /**
     * Go to the notifications page when button is pushed
     */
    public void NotificationButtonPushed() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/NotificationPage.fxml"));
        loader.setControllerFactory((controller -> {
            return new NotificationPageController(notificationManager);
        }));

        Parent root = loader.load();
        NotificationPageController notificationPageController = loader.getController();

        notificationPageController.setPreviousScene(notificationsPage.getScene());

        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    /**
     * Logs out the user when the button is pushed
     */
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