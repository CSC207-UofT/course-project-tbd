package Phase_2.GUI;

import Phase_2.UseCaseClass.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * This ViewFolderController class is made for accessing all the folders in a group. Each folder contains
 * the assigned task for a member (Folder's name is the same as the member's name)
 */

public class ViewFolderController {
    /**
     * The userId is given beforehand from the previous controller
     */
    String userId;
    /**
     * The groupId is given beforehand from the previous controller
     */
    String groupId;
    /**
     * Use case for all operations we perform on Users
     */
    UserManager um;
    /**
     * Use case for all operations we perform on Tasks
     */
    TaskManager tm;
    /**
     * Use case for all operations we perform on Groups
     */
    GroupManager gm;
    /**
     * Used to start alarm for task with a due date, and send notification
     * to user's notification center
     */
    NotificationManager nm;

    /**
     * Setter for userId
     * @param userId the name of the user who is accessing this controller
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Setter for groupId
     * @param groupId name of the user's group who is accessing this controller
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * Setter for um
     * @param um Use case for all operations on Users
     */
    public void setUm(UserManager um) {
        this.um = um;
    }

    /**
     * Setter for tm
     * @param tm Use case for all operations on Tasks
     */
    public void setTm(TaskManager tm) {
        this.tm = tm;
    }

    /**
     * Setter for gm
     * @param gm Use case for all operations on Groups
     */
    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    /**
     * Setter for nm
     * @param nm used to start alarm for task with a due date, and send notification to
     *           user's notification center
     */
    public void setNm(NotificationManager nm) {
        this.nm = nm;
    }

    @FXML
    VBox GroupsPane;

    @FXML
    Button BackButton;

    /**
     * This method dynamically creates buttons for each folder of the group
     */
    public void createFolderButton(){
        GroupsPane.getChildren().clear(); // Removes all the elements of the pane
        for(String categoryName : gm.getGroupById(groupId).getCategoryNames()){
            // Creates and adds button for each group to the pane
            Button button = new Button();
            button.setText(categoryName);
            button.setOnAction(actionEvent -> {
                try {
                    goToCategory(categoryName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            button.setPrefSize(371.0, 25.0);
            GroupsPane.getChildren().add(button);
        }
    }

    /**
     * This method helps the user to pick a wanted folder and access that folder by
     * direct them to the next controller (GroupTaskController)
     * @param categoryName the name of the folder
     * @throws IOException any exceptions that could occur when running this method
     */
    private void goToCategory(String categoryName) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupTaskPresenter.fxml"));
        Parent root = loader.load();
        GroupTaskController gtc  = loader.getController();
        gtc.checkLeader.setText("");
        gtc.setGroupId(groupId);
        gtc.setUserId(userId);
        gtc.setCategoryName(categoryName);
        gtc.setGm(gm);
        gtc.setUm(um);
        gtc.setTm(tm);
        gtc.setNm(nm);
        gtc.checkLeader.setText("");
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    /**
     * This method allows user to go back to the previous controller (GroupContentController)
     * @throws IOException any exceptions that could occur when running this method
     */
    public void goBack() throws IOException {
        // Go back to previous page: GroupPageController
        GroupsPane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupContentController.fxml"));
        Parent root = loader.load();
        GroupContentController gcc = loader.getController();
        TaskManager tm = new TaskManager();
        gcc.setAll(um, gm, tm, userId, groupId, nm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }
}
