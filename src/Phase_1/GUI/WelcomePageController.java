package Phase_1.GUI;

import Phase_1.Controllers_Gateways_Presenters.GroupDataGateWay;
import Phase_1.Controllers_Gateways_Presenters.UserDataGateway;
import Phase_1.Entity.Group;
import Phase_1.Entity.User;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
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
    MainPageController mpc;
    Stage stg;

    @FXML
    public Button welcomeButton;

    @FXML
    public Label tbd;

    public void buttonPushed(ActionEvent event) throws IOException {
        mpc.display();
        welcomeButton.setText("Hope you enjoy our app :)");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<User> users = new ArrayList<User>();
        HashMap<String, Group> groups = new HashMap<String, Group>();
        UserDataGateway udg = new UserDataGateway("userData.ser");
        GroupDataGateWay gdw = new GroupDataGateWay("groupData.ser");
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

        mpc = new MainPageController();
        mpc.setGm(gm);
        mpc.setUm(um);



        try{udg.saveToFile(users);}
        catch (IOException ioException){
            System.out.println("No user data is stored in database");
        }
        try{gdw.saveToFile(groups);}
        catch (IOException ioException){
            System.out.println("No group data is stored in database");
        }
    }
}
