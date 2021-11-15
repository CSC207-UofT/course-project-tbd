package Phase_1.GUI;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;


import java.io.IOException;

public class HomePageController {
    GroupManager gm;
    UserManager um;
    String UserId;
    @FXML
    Button backButton;

    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    public void setUm(UserManager um) {
        this.um = um;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }


    public void backButtonPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserLogin.fxml"));
        Parent root = loader.load();
        UserLoginController mpc1 = loader.getController();
        mpc1.setUm(um);
        mpc1.setGm(gm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }
}
