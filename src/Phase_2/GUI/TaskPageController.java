package Phase_2.GUI;

import Phase_2.Entity.Category;
import Phase_2.Entity.Task;
import Phase_2.UseCaseClass.NotificationManager;
import Phase_2.UseCaseClass.TaskManager;
import Phase_2.UseCaseClass.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class TaskPageController {
    Category c;
    NotificationManager nm;
    Task t;
    TaskManager tm;
    UserManager um;
    String userId;
    Scene previousScene;

    @FXML
    Button addtask;
    @FXML
    Button finishtask;
    @FXML
    Button viewTaskButton;
    @FXML
    Hyperlink back;

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
     * This is a setter method for Notification manager.
     * @param nm: Notification manager.
     */
    public void setNm(NotificationManager nm) {this.nm = nm;}

    /**
     * This is a setter method for string userid of the user
     * @param userId: The string representation of the user ID
     */
    public void setUserId(String userId){this.userId = userId;}

    /**
     * This is a setter method for Category.
     * @param c: Category
     */
    public void setC(Category c){this.c = c;}

    /**
     * This is a setter method for Task.
     * @param t: Task
     */
    public void setT(Task t) {
        this.t = t;
    }

    /**
     * This is a setter method for Scene
     * @param scene: Scene
     */
    public void setPreviousScene(Scene scene){
        this.previousScene = scene;
    }

    /**
     * This method takes the user to add task page.
     */
    public void addTask() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddTask.fxml"));
        Parent root = loader.load();
        AddTaskController apc1 = loader.getController();
        apc1.setTm(tm);
        apc1.setUm(um);
        apc1.setC(c);
        apc1.setNm(nm);
        apc1.setPreviousScene(addtask.getScene());
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    /**
     * This method takes the user to Finish task page.
     */
    public void finishtask() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewNFinishTask.fxml"));
        // set controller using constructor so that category can be accessed in the initialize method
        loader.setControllerFactory((controller -> new ViewNFinishTaskController(c)));

        Parent root = loader.load();
        ViewNFinishTaskController apc1 = loader.getController();
        apc1.setTm(tm);
        apc1.setUm(um);
        apc1.setPreviousScene(viewTaskButton.getScene());
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    /**
     * This method takes the user to view task page.
     */
    public void viewTask() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewNFinishTask.fxml"));

        // set controller using constructor so that category can be accessed in the initialize method
        loader.setControllerFactory((controller -> new ViewNFinishTaskController(c)));

        Parent root = loader.load();
        ViewNFinishTaskController apc1 = loader.getController();
        apc1.setTm(tm);
        apc1.setUm(um);
        apc1.setPreviousScene(viewTaskButton.getScene());
        apc1.setNotificationManager(nm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    /**
     * Goes back to the previous page when the back button is pressed on our gui.
     */
    public void backPushed() throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.setScene(previousScene);
    }

}