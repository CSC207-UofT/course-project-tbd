package Phase_1.GUI;

import Phase_1.UseCaseClass.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class GroupTaskController {
    String userId;
    String groupId;
    String categoryName;
    UserManager um;
    TaskManager tm;
    GroupManager gm;
    NotificationManager nm;

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    @FXML
    Button backPushed;

    @FXML
    Button addTask;

    @FXML
    Button displayTask;

    CategoryManager cm = new CategoryManager();

    public void back() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupContentController.fxml"));
        Parent root = loader.load();
        GroupContentController gcc = loader.getController();
        TaskManager tm = new TaskManager();
        gcc.setAll(um, gm, tm, userId, groupId, nm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }
    public void add() throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupAddTaskPresenter.fxml"));
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
    }
    public void display() throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupDisplayTaskPresenter.fxml"));
        loader.setControllerFactory((controller -> {
            return new GroupDisplayTaskController(cm, gm, userId, groupId);
        }));
        Parent root = loader.load();
        GroupDisplayTaskController gdtc = loader.getController();
        gdtc.setUm(um);
        gdtc.setTm(tm);
        gdtc.setPreviousScene(backPushed.getScene());
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

}
