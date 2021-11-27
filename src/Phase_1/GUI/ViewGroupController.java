package Phase_1.GUI;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserGroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.awt.*;

public class ViewGroupController {
    GroupManager gm;
    UserManager um;
    UserGroupManager ugm;
    String userId;

    public ViewGroupController(GroupManager gm, UserManager um, UserGroupManager ugm, String userId){
        this.gm = gm;
        this.um = um;
        this.ugm = ugm;
        this.userId = userId;
    }
    @FXML
    VBox GroupsPane;

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
                //TODO: I have to somehow call Aryans controller here.
            });
            GroupsPane.getChildren().add(button);
        }
    }
}
