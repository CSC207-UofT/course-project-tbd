package Phase_2.GUI;

import Phase_2.Entity.Task;
import Phase_2.Entity.TaskWithDueDate;
import Phase_2.UseCaseClass.*;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class GroupDisplayTaskController implements Initializable {
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
     * Setter method for userId
     * @param userId the name of the user who is accessing this controller
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Setter method for groupId
     * @param groupId the name of the group that the current user is accessing
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * Setter method for um
     * @param um use case for all operations on Users
     */
    public void setUm(UserManager um) {
        this.um = um;
    }

    /**
     * Setter method for tm
     * @param tm use case for all operations on Tasks
     */
    public void setTm(TaskManager tm) {
        this.tm = tm;
    }

    /**
     * Setter method for gm
     * @param gm use case for all operations on Groups
     */
    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    /**
     * Setter method for nm
     * @param nm used to start alarm for task with a due date, and send notification to
     *           the user's notification center
     */
    public void setNm(NotificationManager nm) {
        this.nm = nm;
    }

    /**
     * Setter for Scene
     * @param scene Initiate the previous scene for the user to go back to the previous controller
     */
    public void setPreviousScene(Scene scene){
        this.previousScene = scene;
    }

    @FXML
    Scene previousScene;

    @FXML
    public TextArea taskDetail;

    @FXML
    Button back;

    @FXML
    ListView<String> taskListView;

    @FXML
    TextField name;

    @FXML
    Label Status;

    @FXML
    Button finishTask;

    @FXML
    Label owner;

    CategoryManager cm;

    /**
     * This method is to initiate all the required parameters for the GroupDisplayTaskController
     * and for the use of "Initializable"
     */
    GroupDisplayTaskController(String categoryName, CategoryManager cm, GroupManager gm, String userId,
                                String groupId) {
        this.categoryName = categoryName;
        this.cm = cm;
        this.gm = gm;
        this.userId = userId;
        this.groupId = groupId;
    }


    /**
     * This method allows the user to finish the task and remove it from the group page
     * display when requested.
     */
    public void finishTask() {
        if (userId.equals(categoryName)) {
            String title = name.getText();
            Status.setText("");
            if (tm.checkTask(cm.getCategoryByGroup(userId, gm.getGroupById(groupId)),
                    tm.getTaskByName(cm.getCategoryByGroup(userId, gm.getGroupById(groupId)), title))) {
                tm.completeTask(tm.getTaskByName(cm.getCategoryByGroup(userId, gm.getGroupById(groupId)), title));
                if (tm.getTaskByName(cm.getCategoryByGroup(userId, gm.getGroupById(groupId)), title)
                        instanceof TaskWithDueDate) {
                    nm.addTaskWithDueDate((TaskWithDueDate)
                            tm.getTaskByName(cm.getCategoryByGroup(userId, gm.getGroupById(groupId)), title));
                    Status.setText("<" + tm.getTaskByName(
                            cm.getCategoryByGroup(userId, gm.getGroupById(groupId)), title)
                            .getTaskName() + "> finished, \n alarm turned off");
                } else {
                    Status.setText("Task finished");
                }
                Status.setText("Task has been finished");
            } else {
                Status.setText("Invalid Task");
            }
        } else {
            owner.setText("Only the owner of this folder can finish a task");
        }
    }

    /**
     * This method allows the user to go back to the previous controller (GroupTaskController)
     * @throws IOException any exception that could occur when running this method
     */
    public void backPushed() throws IOException {
        Stage stage = (Stage) finishTask.getScene().getWindow();
        stage.setScene(previousScene);
    }

    /**
     * This initializes the page when user enters the page, it should display all the tasks
     * if there is any
     * @param url inherited from the interface
     * @param resourceBundle inherited from the interface
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> taskNames = new ArrayList<>();
        HashMap<String, String> tasks = new HashMap<>();

        for (Task t : cm.getCategoryByGroup(categoryName, gm.getGroupById(groupId)).getTasks()) {
            taskNames.add(t.getTaskName());
            tasks.put(t.getTaskName(), t.toString());
        }
        taskListView.getItems().addAll(taskNames);
        taskListView.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            ObservableList<String> current = taskListView.getSelectionModel().getSelectedItems();
            String currentString = current.toString().substring(1, current.toString().length() - 1);

            taskDetail.setText(tasks.get(currentString));
        });
    }
}
