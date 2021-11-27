package Phase_1.GUI;

import Phase_1.Controllers_Gateways_Presenters.GroupContentPresenter;
import Phase_1.UseCaseClass.*;
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
    private final UserManager um;
    private final GroupManager gm;
    private final TaskManager tm;
    private final String userId;
    private final String groupId;
    NotificationManager nm;
    GroupContentPresenter gcp = new GroupContentPresenter();
    UserGroupManager ugm = new UserGroupManager();

    @FXML
    Button HomePage;
    @FXML
    Button GroupTaskPage;
    @FXML
    Button GroupChat;

    /**
     * This is a constructor method for the class that initializes
     * UserManager um: The  usecase class for managing users.
     * GroupManager gm: The usecase class for managing groups.
     * TaskManager tm: The usecase class for managing tasks
     * String userId: The userId of the current user logged in.
     * String groupId: Represents the id of the current group.
     */
    public GroupContentController(UserManager um, GroupManager gm, TaskManager tm, String groupId, String userId,
                                  NotificationManager nm) {
        this.um = um;
        this.gm = gm;
        this.tm = tm;
        this.userId = userId;
        this.groupId = groupId;
        this.nm = nm;
    }
    public void HomePagePushed() throws IOException {
        GUImain guiMain = new GUImain();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("AnnouncementPage.fxml"));
            Parent root = loader.load();
        //    AnnouncementPageController apc = loader.getController(um, gm, userId);
        //    apc.setUm(um);
        //    apc.setGm(gm);
        //   apc.setUserId(userId);
            Scene scene = new Scene(root);
            guiMain.addScene(scene);
    }
    public void GroupTaskPushed() throws IOException {
        GUImain guiMain = new GUImain();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupTaskPage.fxml"));
        Parent root = loader.load();
//        GroupTaskPageController gtpc = loader.getController(um, gm, userId);
//        gtpc.setUm(um);
//        gtpc.setGm(gm);
//        gtpc.setUserId(userId);
        Scene scene = new Scene(root);
        guiMain.addScene(scene);
    }

    public void GroupChatPushed() throws IOException {
        GUImain guiMain = new GUImain();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupChatPage.fxml"));
        Parent root = loader.load();
//        GroupChatController gcc = loader.getController(um, gm, userId);
//        gcc.setUm(um);
//        gcc.setGm(gm);
//        gcc.setUserId(userId);
        Scene scene = new Scene(root);
        guiMain.addScene(scene);

    }
    public void backPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewGroupController.fxml"));
        Parent root = loader.load();
//        ViewGroupController vgc = loader.getController(gm, um, ugm, userId);
//        vgc.setUm(um);
//        vgc.setGm(gm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);

    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
