package Phase_1.GUI;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.TaskManager;
import Phase_1.UseCaseClass.UserGroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.io.IOException;

public class ViewGroupController {
    GroupManager gm;
    UserManager um;
    UserGroupManager ugm;
    TaskManager tm;
    String userId;

    public void setAll(UserManager um, GroupManager gm, String userId){
        this.um = um;
        this.gm = gm;
        this.ugm = new UserGroupManager();
        this.userId = userId;
    }

    @FXML
    VBox GroupsPane;

    @FXML
    Button refreshButton;

    @FXML
    Button BackButton;

    /**
     * This method creates buttons which when clicked take you to the different pages.
     */
    public void createGroupButton(){
        GroupsPane.getChildren().clear(); // Removes all the elements of the pane
        for(String groupId : ugm.getGroupIds(um.getUserById(userId))){
            // Creates and adds button for each group to the pane
            Button button = new Button();
            button.setText(groupId);
            button.setOnAction(actionEvent -> {
                try {
                    goToGroup(groupId);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            GroupsPane.getChildren().add(button);
        }
    }

    private void goToGroup(String groupId) throws IOException{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupContentController.fxml"));
            Parent root = loader.load();
            GroupContentController gcc = loader.getController();
            gcc.setAll(um, gm, tm, userId, groupId);
            Scene scene = new Scene(root);
            GUImain guiMain = new GUImain();
            guiMain.addScene(scene);
    }

    public void goBack() throws IOException {
        // Go back to previous page: GroupPageController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupPageGUI.fxml"));
        Parent root = loader.load();
        GroupPageController gpc = loader.getController();
        gpc.setGm(gm);
        gpc.setUm(um);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }
}
