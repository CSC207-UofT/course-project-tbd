package Phase_1.GUI;

import Phase_1.UseCaseClass.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class ViewGroupController {
    GroupManager gm;
    UserManager um;
    UserGroupManager ugm;
    TaskManager tm;
    String userId;
    NotificationManager nm;

    /**
     * This is a setter used to set all of the parameters. Note that we are injecting these into our controller.
     * @param um : The user manager
     * @param gm : The group manager
     * @param userId : The user id of current logged in user
     * @param nm : The notification manager.
     */
    public void setAll(UserManager um, GroupManager gm, String userId, NotificationManager nm){
        this.um = um;
        this.gm = gm;
        this.ugm = new UserGroupManager();
        this.userId = userId;
        this.tm = new TaskManager();
        this.nm = nm;
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
            button.setPrefSize(371.0, 25.0);
            GroupsPane.getChildren().add(button);
        }
    }

    /**
     * This method is used in the code above. I extracted this code into a new method to make my methods
     * shorter
     * @param groupId : Group id of the group of whom you want to view contents.
     */
    private void goToGroup(String groupId) throws IOException{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupContentController.fxml"));
            Parent root = loader.load();
            GroupContentController gcc = loader.getController();
            gcc.setAll(um, gm, tm, userId, groupId, nm);
            Scene scene = new Scene(root);
            GUImain guiMain = new GUImain();
            guiMain.addScene(scene);
    }

    /**
     * Goes back to the previous page when the back button is pressed on our gui.
     */
    public void goBack() throws IOException {
        // Go back to previous page: GroupPageController
        GroupsPane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupPageGUI.fxml"));
        Parent root = loader.load();
        GroupPageController gpc = loader.getController();
        gpc.setGm(gm);
        gpc.setUm(um);
        gpc.setUserId(userId);
        gpc.setNm(nm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }
}
