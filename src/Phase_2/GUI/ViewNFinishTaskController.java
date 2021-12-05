package Phase_2.GUI;

import Phase_2.Entity.Category;
import Phase_2.Entity.Task;
import Phase_2.Entity.TaskWithDueDate;
import Phase_2.UseCaseClass.NotificationManager;
import Phase_2.UseCaseClass.TaskManager;
import Phase_2.UseCaseClass.UserManager;
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
import java.util.ResourceBundle;
import java.util.*;

public class ViewNFinishTaskController implements Initializable {
    TaskManager tm;
    UserManager um;
    Category category;
    NotificationManager notificationManager;

    Scene previousScene;

    @FXML
    public TextArea taskDetailField;

    @FXML
    Hyperlink back;

    @FXML
    ListView<String> taskListView;

    @FXML
    TextField name;

    @FXML
    Label Status;

    @FXML
    Button finishTask;

    /**
     * This is a setter method for the task manager.
     * @param tm: Task Manager
     */
    public void setTm(TaskManager tm) {this.tm = tm;}

    /**
     * This is a setter method for the user manager.
     * @param um: User Manager
     */
    public void setUm(UserManager um) {this.um = um;}

    /**
     * This is a setter method for Category.
     * @param category: Category
     */
    public void setCategory(Category category){
        this.category = category;
    }

    /**
     * This is a setter method for Scene
     * @param scene: Scene
     */
    public void setPreviousScene(Scene scene){
        this.previousScene = scene;
    }

    /**
     * This is a setter method for Notification manager.
     * @param notificationManager: Notification manager.
     */
    public void setNotificationManager(NotificationManager notificationManager){
        this.notificationManager = notificationManager;
    }


    ViewNFinishTaskController(Category category){
        this.category = category;
    }

    /**
     *This method finishes the task which is provided by the user. The user provides the string
     * representation of the task.
     */
    public void finishTask() throws IOException {
        String title = name.getText();
        Task task = tm.getTaskByName(category, title);
        Status.setText("");
        if (tm.checkTask(category, task)) {  // If task is present in user, mark it finished
            tm.completeTask(task);
            if (task instanceof TaskWithDueDate) {
                notificationManager.addTaskWithDueDate((TaskWithDueDate) task);
                Status.setText("<" + task.getTaskName() + "> finished, \n alarm turned off");
            } else {
                Status.setText("Task finished");
            }
        } else {
            Status.setText("Task not Present");
        }

    }


    /**
     * Go back to previous page
     */
    public void backPushed() throws IOException {
        Stage stage = (Stage) finishTask.getScene().getWindow();
        stage.setScene(previousScene);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> taskNames = new ArrayList<>();
        HashMap<String, String> taskDetail = new HashMap<>();


        for (Task t : category.getTasks()) {
            taskNames.add(t.getTaskName());
            taskDetail.put(t.getTaskName(), t.toString());
        }




        taskListView.getItems().addAll(taskNames);


        taskListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                ObservableList<String> current = taskListView.getSelectionModel().getSelectedItems();
                String currentString = current.toString().substring(1, current.toString().length() - 1);

                taskDetailField.setText(taskDetail.get(currentString));
            }
        });
    }
}