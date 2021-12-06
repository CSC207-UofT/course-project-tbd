package Phase_2.GUI;

import Phase_2.Entity.Category;
import Phase_2.Entity.Task;
import Phase_2.Entity.TaskWithDueDate;
import Phase_2.UseCaseClass.NotificationManager;
import Phase_2.UseCaseClass.TaskManager;
import Phase_2.UseCaseClass.UserManager;

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
    /**
     * Use case for all operations we are performing on Tasks (e.g. add task, delete task)
     */
    TaskManager tm;

    /**
     * Responsible for managing, changing and accessing user information
     */
    UserManager um;

    /**
     * Category is responsible for storing all the tasks
     */
    Category category;

    /**
     * Used to start alarm for task with a due date, and send notification to user mailbox
     */
    NotificationManager notificationManager;

    /**
     * This remembers the previous scene before ViewNFinishTask Page FXML, which should be the task page
     */
    Scene previousScene;

    /**
     * A text area that will display the task's detail information
     */
    @FXML
    public TextArea taskDetailField;

    /**
     * This will set the scene to the previous page when being clicked
     */
    @FXML
    Hyperlink back;

    /**
     * ListView is used to display all tasks in a list fashion in scene builder
     */
    @FXML
    ListView<String> taskListView;

    /**
     * Name of the task that user wants to finish
     */
    @FXML
    TextField name;

    /**
     * The complete/in progress status of the task
     */
    @FXML
    Label Status;

    /**
     * The button to finish task by name
     */
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

    /**
     * This is a setter method for Category
     *
     * @param category: the category which include its tasks
     */
    ViewNFinishTaskController(Category category){
        this.category = category;
    }

    /**
     *This method finishes the task which is provided by the user. The user provides the string
     * representation of the task.
     */
    public void finishTask(){
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

    /**
     * This initializes the page when user enters the page, it should display all the tasks if there is any
     *
     * @param url inherited from the interface
     * @param resourceBundle inherited from the interface
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> taskNames = new ArrayList<>();
        HashMap<String, String> taskDetail = new HashMap<>();

        for (Task t : category.getTasks()) {
            taskNames.add(t.getTaskName());
            taskDetail.put(t.getTaskName(), t.toString());
        }

        taskListView.getItems().addAll(taskNames);

        taskListView.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            ObservableList<String> current = taskListView.getSelectionModel().getSelectedItems();
            String currentString = current.toString().substring(1, current.toString().length() - 1);

            taskDetailField.setText(taskDetail.get(currentString));
        });
    }
}