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

public class CreateGroupController {
    GroupManager gm;
    UserManager um;
    String userName;

    @FXML
    public Button create_group;

    @FXML
    public TextField group_name;

    @FXML
    public Label message;


    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    public void setUm(UserManager um) {
        this.um = um;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void create_group_button(ActionEvent actionEvent) throws IOException {

        String name = group_name.getText();

        if(gm.checkGroupExists(name)){
            message.setText("Group already exists!");
        } else {
            gm.createGroup(um.getUserById(userName), group_name.getText());
            message.setText("Group created!");
        }
    }



}