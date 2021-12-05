package Phase_2.GUI;

import Phase_2.UseCaseClass.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

    @FXML
    Label checkLeader;

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
        if (gm.checkIfLeader(gm.getGroupById(groupId).getgroupName(), um.getUserById(userId))) {
            checkLeader.setText("");
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
        } else {
            checkLeader.setText("Only leader of the group can assign a task to members");
        }

    }
    public void display() throws IOException  {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupDisplayTaskPresenter.fxml"));
        loader.setControllerFactory((controller -> {
            return new GroupDisplayTaskController(categoryName, cm, gm, userId, groupId);
        }));
        Parent root = loader.load();
        GroupDisplayTaskController gdtc = loader.getController();
        gdtc.setUm(um);
        gdtc.setTm(tm);
        gdtc.setNm(nm);
        gdtc.owner.setText("");
        gdtc.setPreviousScene(backPushed.getScene());
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }
}
