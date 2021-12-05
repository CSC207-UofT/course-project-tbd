package Phase_1.GUI;

import Phase_1.Entity.Task;
import Phase_1.UseCaseClass.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

    CategoryManager cm = new CategoryManager();

    GroupDisplayTaskController(CategoryManager cm, GroupManager gm, String userId,
                                String groupId) {
        this.cm = cm;
        this.gm = gm;
        this.userId = userId;
        this.groupId = groupId;
    }

    public void finishTask() {

        String title = name.getText();
        Status.setText("");
        if (tm.checkTask(cm.getCategoryByGroup(userId, gm.getGroupById(groupId)),
                tm.getTaskByName(cm.getCategoryByGroup(userId, gm.getGroupById(groupId)), title))) {
            tm.completeTask(tm.getTaskByName(cm.getCategoryByGroup(userId, gm.getGroupById(groupId)), title));
            Status.setText("Task has been finished");
        } else {
            Status.setText("Invalid Task");
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

        for (Task t : cm.getCategoryByGroup(userId, gm.getGroupById(groupId)).getTasks()) {
            taskNames.add(t.getTaskName());
            tasks.put(t.getTaskName(), t.toString());
        }
        taskListView.getItems().addAll(taskNames);
        taskListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                ObservableList<String> current = taskListView.getSelectionModel().getSelectedItems();
                String currentString = current.toString().substring(1, current.toString().length() - 1);

                taskDetail.setText(tasks.get(currentString));
            }
        });
    }
}
