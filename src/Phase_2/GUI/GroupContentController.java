package Phase_2.GUI;

import Phase_1.Controllers_Gateways_Presenters.GroupContentPresenter;
import Phase_2.GUImain;
import Phase_2.UseCaseClass.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GroupContentController implements Initializable{
    /**
     * This class is the controller that gives access to all the content for a particular group.
     * UserManager um: The  usecase class for managing users.
     * GroupManager gm: The usecase class for managing groups.
     * TaskManager tm: The usecase class for managing tasks
     * String userId: The userId of the current user logged in.
     * String groupId: Represents the id of the current group.
     * GroupContentPresenter gcp: The presenter class for displaying information.
     */
    private UserManager um;
    private GroupManager gm;
    private TaskManager tm;
    private String userId;
    private String groupId;
    NotificationManager nm;
    GroupContentPresenter gcp = new GroupContentPresenter();
    UserGroupManager ugm = new UserGroupManager();

    @FXML
    Button HomePage;
    @FXML
    Button GroupTaskPage;
    @FXML
    Button GroupChat;
    @FXML
    Label GroupName;

    /**
     * This is a constructor method for the class that initializes
     * UserManager um: The  usecase class for managing users.
     * GroupManager gm: The usecase class for managing groups.
     * TaskManager tm: The usecase class for managing tasks
     * String userId: The userId of the current user logged in.
     * String groupId: Represents the id of the current group.
     */

    public void setAll(UserManager um, GroupManager gm, TaskManager tm, String userId, String groupId,
                       NotificationManager nm){
        this.um = um;
        this.gm = gm;
        this.tm = tm;
        this.userId = userId;
        this.groupId = groupId;
        this.nm = nm;
        GroupName.setText(groupId);
    }

    /**
     * Goes to the home page from page group contents
     */
    public void HomePagePushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/AnnouncementPagePresenter.fxml"));
        Parent root = loader.load();
        AnnouncementPageController apc = loader.getController();
        apc.setAll(um, gm, groupId, userId, nm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
        apc.refreshAnnouncements();
    }

    /**
     * Go to the group tasks when pressed
     */
    public void GroupTaskPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/ViewFolderPresenter.fxml"));
        Parent root = loader.load();
        ViewFolderController vfc = loader.getController();
        vfc.setUserId(userId);
        vfc.setGroupId(groupId);
        vfc.setGm(gm);
        vfc.setUm(um);
        vfc.setTm(tm);
        vfc.setNm(nm);
        vfc.createFolderButton();
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    /**
     * Go to the page group chat when pressed
     */
    public void GroupChatPushed() throws IOException {
        GUImain guiMain = new GUImain();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/GroupChatPresenter.fxml"));
        Parent root = loader.load();
        GroupChatController gcc = loader.getController();
        gcc.setGroupId(groupId);
        gcc.setUserId(userId);
        gcc.setGm(gm);
        gcc.setUm(um);
        gcc.setUserId(userId);
        gcc.setNm(nm);
        gcc.display();
        Scene scene = new Scene(root);
        guiMain.addScene(scene);

    }

    /**
     * Go to the previous page when presssed
     */
    public void backPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/ViewGroupController.fxml"));
        Parent root = loader.load();
        ViewGroupController vgc = loader.getController();
        vgc.setAll(um, gm, userId, nm);
        vgc.createGroupButton();
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
