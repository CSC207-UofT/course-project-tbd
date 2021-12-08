package Phase_2.GUI;
import Phase_2.GUImain;
import Phase_2.UseCaseClass.GroupManager;
import Phase_2.UseCaseClass.NotificationManager;
import Phase_2.UseCaseClass.UserGroupManager;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class GroupPageController implements Initializable{
    @FXML
    Button createButton;
    @FXML
    Button joinButton;
    @FXML
    Button leaveButton;
    @FXML
    Button viewButton;
    @FXML
    Button exitButton;
    @FXML
    Label remindLabel;
    @FXML
    TextArea tut;
    GroupManager gm;
    UserManager um;
    String userId;
    UserGroupManager ugm;
    NotificationManager nm;


    /**
     * Setter methods
     */
    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    public void setUm(UserManager um) {
        this.um = um;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setNm(NotificationManager nm) {
        this.nm = nm;
    }

    /**
     * Go to the create group page
     */
    public void createPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/CreateGroup.fxml"));
        Parent root = loader.load();
        CreateGroupController mpc1 = loader.getController();
        mpc1.setUm(um);
        mpc1.setGm(gm);
        mpc1.setUserName(userId);
        Scene scene = new Scene(root);
        Stage stg = new Stage();
        stg.setScene(scene);
        stg.show();
    }

    /**
     * Go to the join group page
     */
    public void joinPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/JoinGroup.fxml"));
        Parent root = loader.load();
        JoinGroupController mpc1 = loader.getController();
        mpc1.setUm(um);
        mpc1.setGm(gm);
        mpc1.setUserName(userId);
        Scene scene = new Scene(root);
        Stage stg = new Stage();
        stg.setScene(scene);
        stg.show();
    }

    /**
     * Go to the leave group page
     */
    public void leavePushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/LeaveGroupGUI.fxml"));
        Parent root = loader.load();
        LeaveGroupController mpc1 = loader.getController();
        mpc1.setUm(um);
        mpc1.setGm(gm);
        mpc1.setUserId(userId);
        Scene scene = new Scene(root);
        Stage stg = new Stage();
        stg.setScene(scene);
        stg.show();

    }

    /**
     * Go to the view group page
     */
    public void viewPushed() throws IOException {
        UserGroupManager umg = new UserGroupManager();
        if (umg.getMyGroups(um.getUserById(userId)).isEmpty()){
            remindLabel.setText("reminder: You haven't joined any group yet");
        }
        else {
            remindLabel.setText("you currently joined " + umg.getMyGroups(um.getUserById(userId)).size() + " group(s)");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/ViewGroupController.fxml"));
            Parent root = loader.load();
            ViewGroupController vgc = loader.getController();
            vgc.setAll(um, gm, userId, nm);
            vgc.createGroupButton();
            Scene scene = new Scene(root);
            GUImain guiMain = new GUImain();
            guiMain.addScene(scene);

        }
    }

    /**
     * Leaves this page
     */
    public void exitPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/UserPageController.fxml"));
        Parent root = loader.load();
        UserPageController mpc = loader.getController();
        mpc.setUm(um);
        mpc.setGm(gm);
        mpc.setUserName(userId);
        mpc.setNotificationManager(nm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        remindLabel.setText("");
        ugm = new UserGroupManager();
        tut.setEditable(false);
    }
}
