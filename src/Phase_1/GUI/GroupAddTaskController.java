package Phase_1.GUI;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.NotificationManager;
import Phase_1.UseCaseClass.TaskManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class GroupAddTaskController {
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
    Button cancel;

    @FXML
    Button done;

    @FXML
    TextField title;

    @FXML
    TextField detail;

    @FXML
    TextField time;

    @FXML
    Button notification;

    public void backPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupTaskPresenter.fxml"));
        Parent root = loader.load();
        GroupTaskController gtc = loader.getController();
        gtc.setUserId(userId);
        gtc.setGroupId(groupId);
        gtc.setCategoryName(categoryName);
        gtc.setUm(um);
        gtc.setGm(gm);
        gtc.setTm(tm);
        gtc.setNm(nm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }
}
