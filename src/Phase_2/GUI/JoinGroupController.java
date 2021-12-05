package Phase_2.GUI;

import Phase_2.UseCaseClass.GroupManager;
import Phase_2.UseCaseClass.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class JoinGroupController {

    GroupManager gm;
    UserManager um;
    String userName;

    /**
     * Setter methods
     */
    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    public void setUm(UserManager um) {
        this.um = um;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @FXML
    public Button join_group;

    @FXML
    public TextField group_name;

    @FXML
    public Label message;

    /**
     * Join the group presented by the user
     */
    @FXML
    public void join_group(ActionEvent event) throws IOException {
        String name = group_name.getText();
        if(!gm.checkGroupExists(name)){
            message.setText("Group doesn't exist!");
        } else if (gm.checkIfIn(name, um.getUserById(userName))) {Alert alert = new Alert((Alert.AlertType.WARNING));
            message.setText("You're already in this group!");
        } else {
            gm.addUserToGroup(name, um.getUserById(userName));

        }
    }

    public void group_name(ActionEvent actionEvent) {
    }
}