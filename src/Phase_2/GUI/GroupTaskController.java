package Phase_2.GUI;

import Phase_2.GUImain;
import Phase_2.UseCaseClass.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

/**
 * This GroupTaskController class is made for the user to choose between 2 features
 * of the task center for a group (to display all the tasks for the chosen member, finish
 * a given task or add a task for this member).
 */

public class GroupTaskController {
    /**
     * The userId is given beforehand from the previous controller
     */
    String userId;
    /**
     * The groupId is given beforehand from the previous controller
     */
    String groupId;
    /**
     * The categoryName is given beforehand from the previous controller
     */
    String categoryName;
    /**
     * Use case for all operations we perform on Users
     */
    UserManager um;
    /**
     * Use case for all operations we perform on Tasks
     */
    TaskManager tm;
    /**
     * Use case for all operations on Groups
     */
    GroupManager gm;
    /**
     * Used to start alarm for task with a due date, and send notification to
     * user's notification center
     */
    NotificationManager nm;

    /**
     * Setter for userId
     * @param userId the name of the user who is accessing this controller
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Setter for groupId
     * @param groupId the name of the group this user is in
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * Setter for categoryName
     * @param categoryName the name of the folder which the user is accessing
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Setter for um
     * @param um use case for all operations on Users
     */
    public void setUm(UserManager um) {
        this.um = um;
    }

    /**
     * Setter for tm
     * @param tm use case for all operations on Tasks
     */
    public void setTm(TaskManager tm) {
        this.tm = tm;
    }

    /**
     * Setter for gm
     * @param gm use case for all operations on Groups
     */
    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    /**
     * Setter for nm
     * @param nm used to start alarms for task with a due date, and send notification
     *           to user's notification center
     */
    public void setNm(NotificationManager nm) {
        this.nm = nm;
    }

    @FXML
    Button backPushed;

    @FXML
    Button addTask;

    @FXML
    Button displayTask;

    @FXML
    Label checkLeader;

    CategoryManager cm = new CategoryManager();

    /**
     * This method allows the user to go back to the previous controller (GroupContentController)
     * @throws IOException any exception that could occur when running this method
     */
    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/GroupContentController.fxml"));
        Parent root = loader.load();
        GroupContentController gcc = loader.getController();
        TaskManager tm = new TaskManager();
        gcc.setAll(um, gm, tm, userId, groupId, nm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);

    }

    /**
     * This method allows user to add a task for the member whose folder is being accessed.
     * However, this action can only be performed by the leader of the group
     * @throws IOException any exception that could occur when running this method
     */
    public void add() throws IOException  {
        if (gm.checkIfLeader(gm.getGroupById(groupId).getgroupName(), um.getUserById(userId))) {
            checkLeader.setText("");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/GroupAddTaskPresenter.fxml"));
            Parent root = loader.load();
            GroupAddTaskController gatc = loader.getController();
            gatc.setGroupId(groupId);
            gatc.setUserId(userId);
            gatc.setCategoryName(categoryName);
            gatc.setGm(gm);
            gatc.setTm(tm);
            gatc.setUm(um);
            gatc.setNm(nm);
            Scene scene = new Scene(root);
            GUImain guiMain = new GUImain();
            guiMain.addScene(scene);
        } else {
            checkLeader.setText("Only leader of the group can assign a task to members");
        }
    }

    /**
     * This method allows the user to display all the assigned tasks for the member whose folder\
     * is being accessed. This is performed by calling the next controller (GroupDisplayTaskController)
     * @throws IOException any exception could occur when running this method
     */
    public void display() throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/GroupDisplayTaskPresenter.fxml"));
        loader.setControllerFactory((controller -> new
                GroupDisplayTaskController(categoryName, cm, gm, userId, groupId)));
        Parent root = loader.load();
        GroupDisplayTaskController gdtc = loader.getController();
        gdtc.setUm(um);
        gdtc.setTm(tm);
        gdtc.setNm(nm);
        gdtc.owner.setText("");
        gdtc.setPreviousScene(backPushed.getScene());
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }
}
