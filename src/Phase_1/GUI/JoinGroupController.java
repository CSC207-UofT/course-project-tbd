package Phase_1.GUI;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class JoinGroupController {

    GroupManager gm;
    UserManager um;

    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    public void setUm(UserManager um) {
        this.um = um;
    }

    @FXML
    private Button join_group;

    @FXML
    private TextField group_name;

    @FXML
    private Label message;

    @FXML
    void join_group(ActionEvent event) {
        String name = group_name.getText();
        if(!gm.checkGroupExists(name)){
           message.setText("Group doesn't exist!");
        } else if (gm.checkIfIn(name, um.getUserById("i have no idea"))) {Alert alert = new Alert((Alert.AlertType.WARNING));
            message.setText("You're already in this group!");
        } else {
            gm.addUserToGroup(name, um.getUserById("still have no idea"));
            // TODO: switch scene
        }
    }

    public void group_name(ActionEvent actionEvent) {
    }
}
