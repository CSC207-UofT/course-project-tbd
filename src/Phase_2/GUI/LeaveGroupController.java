package Phase_2.GUI;
import Phase_2.UseCaseClass.GroupManager;
import Phase_2.UseCaseClass.UserGroupManager;
import Phase_2.UseCaseClass.UserManager;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class LeaveGroupController implements Initializable{
    GroupManager gm;
    UserManager um;
    String userId;
    UserGroupManager ugm;

    @FXML Label remindLabel;
    @FXML Button leaveButton;
    @FXML
    TextField userInput;
    @FXML
    TextArea info;
    @FXML Button viewInfo;

    /**
     * Setter method
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUm(UserManager um) {
        this.um = um;
    }

    public void setGm(GroupManager gm) {
        this.gm = gm;
    }



    /**
     * Shows information of the status of the groups
     */
    public void viewInfoPushed(){
        info.setText(ugm.getGroupInfo(um.getUserById(userId)));
        info.setEditable(false);


    }

    /**
     * Go back to the previous page
     */
    public void leaveButtonPushed(){
        String groupName = userInput.getText();


            if(!gm.checkGroupExists(groupName)){
                remindLabel.setText("Group " + groupName + " doesn't exist");
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
                info.setText(ugm.getGroupInfo(um.getUserById(userId)));
                info.setEditable(false);
            }
            else {
                remindLabel.setText("You are not in Group " + groupName);}

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        info.setText(
                "For hints: click \"view my info \" button \n" +
                        "to see your joined groups");
        info.setEditable(false);

        remindLabel.setText("");
        ugm = new UserGroupManager();


    }
}
