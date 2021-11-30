package Phase_1.GUI;

import Phase_1.UseCaseClass.GroupManager;
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

    @FXML
    Button Back;

    @FXML
    VBox Pane;

    public void setAll(GroupManager gm, UserManager um){
        // Sets all the attributes
        this.um = um;
        this.gm = gm;
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

    // TODO: I have not completed this method cuz there is no method to get access to all the users other
    //  than directly accessing entity and idk how database works.
//    public void loadUsers(){
//        // Loads the users into the vertical box so that admin can click and go to them
//
//        for(){ // I dont think there is a method to get all the users in the form of their id. I dont wanna directly
//            // Access user here hence I did not fill the for loop in.
//            Button button = new Button();
//            button.setText(username); // User name shud be here
//            button.setOnAction(actionEvent -> {
//                try {
//                    FXMLLoader loader = new FXMLLoader(getClass().getResource("UserPageController.fxml"));
//                    Parent root = loader.load();
//                    UserPageController upc = loader.getController();
//                    upc.setUm(um);
//                    upc.setGm(gm);
//                    upc.setUserName(username); // This is the string containing username
//                    Scene scene = new Scene(root);
//                    GUImain guiMain = new GUImain();
//                    guiMain.addScene(scene);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//
//    }
}
