package Phase_1.GUI.src;

import Phase_1.Controllers_Gateways_Presenters.GroupDataGateWay;
import Phase_1.Controllers_Gateways_Presenters.UserDataGateway;
import Phase_1.Entity.Group;
import Phase_1.Entity.User;
import Phase_1.GUI.src.MainPageController;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class WelcomePageController implements Initializable {
    GroupManager gm;
    UserManager um;
    MainPageController mpc;
    UserDataGateway udg;
    GroupDataGateWay gdw;
    ArrayList<User> users;
    HashMap<String, Group> groups;


    @FXML
    public Button welcomeButton;

    @FXML
    public Label tbd;

    public void buttonPushed(ActionEvent event) throws IOException {
        mpc.display();
        welcomeButton.setText("Hope you enjoy our app :)");
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

        mpc = new MainPageController();
        mpc.setGm(gm);
        mpc.setUm(um);




    }
}