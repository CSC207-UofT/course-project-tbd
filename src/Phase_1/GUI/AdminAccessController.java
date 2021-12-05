package Phase_1.GUI;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.NotificationManager;
import Phase_1.UseCaseClass.TaskManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class AdminAccessController {
    GroupManager gm;
    UserManager um;
    NotificationManager nm;

    @FXML
    Button Back;

    @FXML
    VBox Pane;

    public void setAll(GroupManager gm, UserManager um, NotificationManager nm){
        // Sets all the attributes
        this.um = um;
        this.gm = gm;
        this.nm = nm;
    }

    public void goBack() throws IOException {
        // Goes back to login page when back is pressed
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserLogin.fxml"));
        Parent root = loader.load();
        UserLoginController ucc = loader.getController();
        ucc.setGm(gm);
        ucc.setUm(um);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

        public void loadUsers(){
//        // Loads the users into the vertical box so that admin can click and go to them
            Pane.getChildren().clear(); // Removes all the elements of the pane
            for(String UserId : um.getAllNormalUserIds()){
                // Creates and adds button for each group to the pane
                Button button = new Button();
                button.setText(UserId);
                button.setOnAction(actionEvent -> {
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserPageController.fxml"));
                        Parent root = loader.load();
                        UserPageController upc = loader.getController();
                        upc.setUm(um);
                        upc.setGm(gm);
                        upc.setUserName(UserId); // This is the string containing username
                        Scene scene = new Scene(root);
                        GUImain guiMain = new GUImain();
                        guiMain.addScene(scene);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                button.setPrefSize(371.0, 25.0);
                Pane.getChildren().add(button);
            }
    }
}
