package Phase_1.GUI;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.Optional;

public class CreateGroupController {
    GroupManager gm;
    UserManager um;
    String userName;

    @FXML
    public Button create_group;

    @FXML
    public Button go_back_button;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupPageGUI.fxml"));
        Parent root = loader.load();
        GroupPageController mpc1 = loader.getController();
        mpc1.setUm(um);
        mpc1.setGm(gm);
        mpc1.setUserId(userName);
        String name = group_name.getText();

        if(gm.checkGroupExists(name)){
            message.setText("Group already exists!");
        } else {
            gm.createGroup(um.getUserById(userName), group_name.getText());
            Scene scene = new Scene(root);
            GUImain guiMain = new GUImain();
            guiMain.addScene(scene);
        }
    }

    public void Go_back_button(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupPageGUI.fxml"));
        Parent root = loader.load();
        GroupPageController mpc1 = loader.getController();
        mpc1.setUm(um);
        mpc1.setGm(gm);
        mpc1.setUserId(userName);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }


}
