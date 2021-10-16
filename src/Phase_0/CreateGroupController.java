package Phase_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CreateGroupController {
    NormalUser normalUser;
    UserManager userManager;
    GroupManager groupManager;
    public CreateGroupController(NormalUser normalUser, UserManager userManager, GroupManager groupManager){
        this.normalUser = normalUser;
        this.userManager = userManager;
        this.groupManager = groupManager;
    }

    public void run(){
        CreateGroupPresenter cgp = new CreateGroupPresenter();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        cgp.Intro();

        try{
            String GroupName = reader.readLine();
            while (!groupManager.checkGroupExists(GroupName)) {
                cgp.InvalidGroupName(GroupName);
                GroupName = reader.readLine();
            }
            groupManager.createGroup(normalUser, GroupName);
            normalUser.myGroups.add(new Group(normalUser, GroupName));
        } catch (IOException e){
            System.out.println("Please type a valid number");
        }

        }
}
