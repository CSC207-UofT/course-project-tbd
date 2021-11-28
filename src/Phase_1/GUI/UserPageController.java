package Phase_1.GUI;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class UserPageController {

    UserManager um;
    GroupManager gm;
    String userName;

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
    private Button goto_grouppage;
    @FXML
    private Button goto_categorypage;
    @FXML
    private Button goto_notificationspage;


    public void goto_categorypage() {

    }

   public void goto_grouppage() throws IOException {
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

    public void goto_notificationspage() {

    }

}
