package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.NormalUser;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CreateGroupController {
    String userId;
    UserManager userManager;
    GroupManager groupManager;
    public CreateGroupController(String userId, UserManager userManager, GroupManager groupManager){
        this.userId = userId;
        this.userManager = userManager;
        this.groupManager = groupManager;
    }

    public void run(){
        CreateGroupPresenter cgp = new CreateGroupPresenter();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        cgp.Intro();

        try{
            String groupName = reader.readLine();
            while (groupManager.checkGroupExists(groupName)) {

                cgp.InvalidGroupName(groupName);
                groupName = reader.readLine();
            }
            groupManager.createGroup(userManager.getUserById(userId), groupName);
            cgp.CreateSuccess(groupName);
            cgp.lines();
        } catch (IOException e){
            System.out.println("Please type a valid number");
        }

        }
}
