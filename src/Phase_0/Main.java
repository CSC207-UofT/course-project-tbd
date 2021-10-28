package Phase_0;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Group> groups = new ArrayList<Group>();
        UserDataGateway udg = new UserDataGateway("userData.ser");
        GroupDataGateWay gdw = new GroupDataGateWay("groupData.ser");
        try{users = udg.readFromFile();}
        catch (IOException ioException){
            System.out.println("Nothing was stored in the file");
        }
        try {
            groups = gdw.readFromFile();
        }catch (IOException ioException){
            System.out.println("Nothing was stored in the file");
        }
        UserManager um = new UserManager();
        GroupManager gm = new GroupManager();
        MainPageController mp = new MainPageController(um, gm);
        mp.run();
        try{udg.saveToFile(users);}
        catch (IOException ioException){
            System.out.println("Nothing was stored in the file");
        }
        try{gdw.saveToFile(groups);}
        catch (IOException ioException){
            System.out.println("Nothing was stored in the file");
        }
    }

}