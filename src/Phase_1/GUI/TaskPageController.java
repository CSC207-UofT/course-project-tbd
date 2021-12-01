package Phase_1.GUI;

import Phase_1.Entity.Category;
import Phase_1.Entity.Task;
import Phase_1.UseCaseClass.CategoryManager;
import Phase_1.UseCaseClass.NotificationManager;
import Phase_1.UseCaseClass.TaskManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TaskPageController {
    Category c;
    TaskManager itm;
    NotificationManager nm;
    CategoryManager cm;
    Task t;
    TaskManager tm;
    UserManager um;

    @FXML
    Button addtask;
    @FXML
    Button finishtask;
    @FXML
    Button viewtask;
    @FXML
    Hyperlink back;


    public void setTm(TaskManager tm) {this.tm = tm;}
    public void setUm(UserManager um) {this.um = um;}
    public void setCm(CategoryManager um) {this.cm = um;}
    public void setNm(NotificationManager nm) {this.nm = nm;}
    public void setC(Category c){this.c = c;}
    public void setT(Task t) {
        this.t = t;
    }

    public void addtask() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddTaskController.fxml"));
        Parent root = loader.load();
        AddTaskController apc1 = loader.getController();
        apc1.setTm(tm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }


    public void finishtask() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewNFinishTask.fxml"));
        Parent root = loader.load();
        AddTaskController apc1 = loader.getController();
        apc1.setTm(tm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }


    public void viewtask() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewNFinishTask.fxml"));
        Parent root = loader.load();
        AddTaskController apc1 = loader.getController();
        apc1.setTm(tm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }
    public void backPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CategoryPageController.fxml"));
        Parent root = loader.load();
        CategoryPageController cpc = loader.getController();
        cpc.setUm(um);
        cpc.setCm(new CategoryManager());
        cpc.loadCategoryPane();
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

}