package Phase_1.GUI;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.TaskManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;

public class GroupChatController {
    String groupId;
    String userId;
    GroupManager gm;
    UserManager um;

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setGm(GroupManager gm) {
        this.gm = gm;
    }
    public void setUm(UserManager um) {
        this.um = um;
    }

    @FXML
    Button backButton;

    @FXML
    Button sendButton;

    @FXML
    Button refreshButton;

    @FXML
    TextArea displayMessage;

    @FXML
    TextField enterMessage;

    /**
     * This is a method to go back to the previous page
     */
    public void backPush() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupContentPresenter.fxml"));
        Parent root = loader.load();
        GroupContentController gcc = loader.getController();
        TaskManager tm = new TaskManager();
        gcc.setAll(um, gm, tm, userId,groupId);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }
    /**
     * This is the method using for display all the messages in the GroupChat
     * This is associated with the Refresh button on the scene and should be pushed
     * first after entering the GroupChat
     */
    public void display() {
        displayMessage.setText("");
        displayMessage.setText(gm.getGroupById(groupId).getGroupChat().toString());
    }
    /**
     * This is the method to add a message into the current GroupChat
     */
    public void enter() {
        String message = enterMessage.getText();
        gm.getGroupById(groupId).getGroupChat().insertMessage(um.getUserById(userId), message);
        displayMessage.setText(gm.getGroupById(groupId).getGroupChat().toString());
    }
}
