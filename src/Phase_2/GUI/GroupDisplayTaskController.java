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
    String userId;
    String groupId;
    String categoryName;
    UserManager um;
    TaskManager tm;
    GroupManager gm;
    NotificationManager nm;


    /**
     * Setter methods
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setUm(UserManager um) {
        this.um = um;
    }

    public void setTm(TaskManager tm) {
        this.tm = tm;
    }

    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    public void setNm(NotificationManager nm) {
        this.nm = nm;
    }

    public void setPreviousScene(Scene scene){
        this.previousScene = scene;
    }

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
     *
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
     * Finishes the task and remove it from the group page display when requested.
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

    public void backPushed() throws IOException {
        Stage stage = (Stage) finishTask.getScene().getWindow();
        stage.setScene(previousScene);
    }

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
