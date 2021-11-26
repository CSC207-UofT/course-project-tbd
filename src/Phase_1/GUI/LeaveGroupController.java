package Phase_1.GUI;
import Phase_1.Entity.User;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserGroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.fxml.FXML;

import java.io.IOException;
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
    public void leaveButtonPushed(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
