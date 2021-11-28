package Phase_1.GUI;
import Phase_1.Controllers_Gateways_Presenters.LeaveGroupPresenter;
import Phase_1.Entity.User;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserGroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.fxml.FXML;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

public class LeaveGroupController implements Initializable{
    GroupManager gm;
    UserManager um;
    String userId;
    @FXML Label remindLabel;
    @FXML Button leaveButton;
    @FXML
    TextField userInput;
    @FXML
    TextArea info;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUm(UserManager um) {
        this.um = um;
    }

    public void setGm(GroupManager gm) {
        this.gm = gm;
    }
    public void leaveButtonPushed(){
        String groupName = userInput.getText();


            if(!gm.checkGroupExists(groupName)){
                info.setText("Group " + groupName + " doesn't exist");
            }
            else if (gm.checkIfIn(groupName, um.getUserById(userId))){
                if (gm.checkIfLeader(groupName, um.getUserById(userId))){
                    gm.deleteGroup(groupName, um.getUserById(userId));
                    remindLabel.setText("You successfully deleted Group " + groupName);
                }
                else {
                    gm.removeMember(groupName, this.um.getUserById(userId));
                    remindLabel.setText("You successfully left Group " + groupName);
                }
            }
            else {
                remindLabel.setText("You are not in Group " + groupName);}

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        info.setText(new UserGroupManager().getGroupInfo(um.getUserById(userId)));
        remindLabel.setText("");

    }
}
