package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.Group;
import Phase_1.Entity.NormalUser;
import Phase_1.Entity.User;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        ArrayList<User> users = new ArrayList<>();
        HashMap<String, Group> groups = new HashMap<>();
        UserDataGateway udg = new UserDataGateway("userData.ser");
        GroupDataGateWay gdw = new GroupDataGateWay("groupData.ser");
        System.out.println(groups);
        try{users = udg.readFromFile();}
        catch (IOException ioException){
            System.out.println("No User stored in the file");
        }
        try {
            groups = gdw.readFromFile();
        }catch (IOException ioException){
            System.out.println("No Group stored in the file");
        }
        UserManager um = new UserManager(users);
        GroupManager gm = new GroupManager(groups);
        um.createNormalUser("1","1","1","1");
        users.add(new NormalUser("2", "2", "@", "2"));
        MainPageController mp = new MainPageController(um, gm);
        mp.run();
        System.out.println(users);
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