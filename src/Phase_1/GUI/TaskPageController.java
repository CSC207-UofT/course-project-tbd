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

public class TaskPageController {
    Category c;
    TaskManager itm;
    NotificationManager nm;
    CategoryManager cm;
    Task t;
    TaskManager tm;
    UserManager um;
    String userId;

    @FXML
    Button addtask;
    @FXML
    Button finishtask;
    @FXML
    Button viewTaskButton;
    @FXML
    Hyperlink back;


    public void setTm(TaskManager tm) {this.tm = tm;}
    public void setUm(UserManager um) {this.um = um;}
    public void setCm(CategoryManager um) {this.cm = um;}
    public void setNm(NotificationManager nm) {this.nm = nm;}
    public void setUserId(String userId){this.userId = userId;}
    public void setC(Category c){this.c = c;}
    public void setT(Task t) {
        this.t = t;
    }

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


    public void finishtask() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewNFinishTask.fxml"));
        // set controller using constructor so that category can be accessed in the initialize method
        loader.setControllerFactory((controller -> {
            return new ViewNFinishTaskController(c);
        }));

        Parent root = loader.load();
        ViewNFinishTaskController apc1 = loader.getController();
        apc1.setTm(tm);
        apc1.setUm(um);
        apc1.setPreviousScene(viewTaskButton.getScene());
//        apc1.setCategory(c);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }


    public void viewTask() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("viewNFinishTask.fxml"));

        // set controller using constructor so that category can be accessed in the initialize method
        loader.setControllerFactory((controller -> {
            return new ViewNFinishTaskController(c);
        }));

        Parent root = loader.load();
        ViewNFinishTaskController apc1 = loader.getController();
        apc1.setTm(tm);
        apc1.setUm(um);
        apc1.setPreviousScene(viewTaskButton.getScene());
//        apc1.setCategory(c);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    public void backPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CategoryPage.fxml"));
        Parent root = loader.load();
        CategoryPageController cpc = loader.getController();
        cpc.setUm(um);
        cpc.setCm(new CategoryManager());
        cpc.setUserId(userId);
        cpc.loadCategoryPane();
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

}