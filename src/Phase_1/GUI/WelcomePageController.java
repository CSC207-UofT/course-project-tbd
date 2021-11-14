package Phase_1.GUI;

import Phase_1.Controllers_Gateways_Presenters.GroupDataGateWay;
import Phase_1.Controllers_Gateways_Presenters.UserDataGateway;
import Phase_1.Entity.Group;
import Phase_1.Entity.User;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import Phase_1.Entity.Group;
import Phase_1.Entity.User;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class WelcomePageController implements Initializable {
    GroupManager gm;
    UserManager um;
    UserDataGateway udg;
    GroupDataGateWay gdw;
    ArrayList<User> users;
    HashMap<String, Group> groups;


    @FXML
    public Button welcomeButton;

    @FXML
    public Label tbd;

    public void setUm(UserManager um) {
        this.um = um;
    }

    public void setGm(GroupManager gm) {
        this.gm = gm;
    }

    public void buttonPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainPage.fxml"));
        Parent root = loader.load();
        MainPageController mpc1 = loader.getController();
        mpc1.setUm(um);
        mpc1.setGm(gm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
        welcomeButton.setText("Hope you enjoy our app :)");
        System.out.println(um.getuser());

        try{udg.saveToFile(users);}
        catch (IOException ioException){
            System.out.println("No user data is stored in database");
        }
        try{gdw.saveToFile(groups);}
        catch (IOException ioException){
            System.out.println("No group data is stored in database");
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeButton.setText("Click here to begin!");
        users = new ArrayList<User>();
        groups = new HashMap<String, Group>();
        udg = new UserDataGateway("userData.ser");
        gdw = new GroupDataGateWay("groupData.ser");
        try{users = udg.readFromFile();}
        catch (IOException | ClassNotFoundException ioException){
            System.out.println("No User stored in the file");
        }
        try {
            groups = gdw.readFromFile();
        }catch (IOException | ClassNotFoundException ioException){
            System.out.println("No Group stored in the file");
        }
        um = new UserManager(users);
        gm = new GroupManager(groups);





    }
}