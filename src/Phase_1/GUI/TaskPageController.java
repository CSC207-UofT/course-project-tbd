package Phase_1.GUI;

import Phase_1.Entity.Task;
import Phase_1.UseCaseClass.TaskManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class TaskPageController implements Initializable {
    Task t;
    TaskManager tm;

    @FXML
    Button addtask;
    @FXML
    Button finishtask;
    @FXML
    Button viewtask;
    @FXML
    Hyperlink back;
    public TaskPageController(){
    }


    public void setTm(TaskManager tm) {this.tm = tm;}

    public void setT(Task t) {
        this.t = t;
    }

    public void addtask() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddTaskController.fxml"));
        Parent root = loader.load();
        AddTaskController apc1 = loader.getController();
        apc1.setTm(tm);
//        apc1.setGm(gm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }


    public void finishtask() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FinishTask.fxml"));
        Parent root = loader.load();
        AddTaskController apc1 = loader.getController();
        apc1.setTm(tm);
//        apc1.setGm(gm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }


    public void viewtask() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewTask.fxml"));
        Parent root = loader.load();
        AddTaskController apc1 = loader.getController();
        apc1.setTm(tm);
//        apc1.setGm(gm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}