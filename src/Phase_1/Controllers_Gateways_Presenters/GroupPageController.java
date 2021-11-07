package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.Group;
import Phase_1.Entity.NormalUser;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.TaskManager;
import Phase_1.UseCaseClass.UserGroupManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class GroupPageController {
    UserManager um;
    String userId;
    GroupManager gm;
    UserGroupManager ugm;
    private TaskPagePresenter tpp;
    private TaskManager itm;
    private final JoinGroupPresenter jgp = new JoinGroupPresenter();

    public GroupPageController(String userId, UserManager um, GroupManager gm){
        this.um = um;
        this.userId = userId;
        this.gm = gm;
        this.tpp = new TaskPagePresenter();
        this.itm = new TaskManager();
        this.ugm = new UserGroupManager();
    }
    public void run(){
        GroupPagePresenter gpp = new GroupPagePresenter();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            gpp.welcomeLine();
            String input = reader.readLine();
            while (!input.equals( "3")){
                if (input.equals("0")){
                        CreateGroupController();
                        gpp.welcomeLine();
                        input = reader.readLine();
                    }
                else if (input.equals("1")){
                        JoinGroupController();
                        gpp.welcomeLine();
                        input = reader.readLine();
                    }
                else if (input.equals("2")){
                        LeaveGroupController();
                        gpp.welcomeLine();
                        input = reader.readLine();
                    }
                else if (input.equals("4")){
                    ViewGroupController vgc = new ViewGroupController(um, gm, userId);
                        vgc.run();
                        gpp.welcomeLine();
                        input = reader.readLine();
                    }
                else {

//                        gpp.welcomeLine();
//                        input = reader.readLine();
                    }

                }
            gpp.lines();
            }
        catch (IOException e){System.out.println("Please type a valid number");
        }
    }
    private void CreateGroupController() {
        CreateGroupPresenter cgp = new CreateGroupPresenter();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        cgp.Intro();

        try {
            String groupName = reader.readLine();
            while (gm.checkGroupExists(groupName)) {

                cgp.InvalidGroupName(groupName);
                groupName = reader.readLine();
            }
            gm.createGroup(um.getUserById(userId), groupName);
            cgp.CreateSuccess(groupName);
            cgp.lines();
        } catch (IOException e) {
            System.out.println("Please type a valid number");
        }
    }
    private void LeaveGroupController() {
        LeaveGroupPresenter lgp = new LeaveGroupPresenter();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        lgp.askForName();
        try{
            String input = reader.readLine();
            if(!gm.checkGroupExists(input)){
                lgp.noGroupFound();
                lgp.goBack();
                lgp.lines();
            }
            else if (gm.checkIfIn(input, this.um.getUserById(userId))){
                if (gm.checkIfLeader(input, this.um.getUserById(userId))){
                    gm.deleteGroup(input, this.um.getUserById(userId));
                    lgp.leaveSuccess(input);
                    lgp.lines();
                }
                else {
                    gm.removeMember(input, this.um.getUserById(userId));
//                    um.leaveGroup(this.user, input);
                    lgp.leaveSuccess(input);
                    lgp.lines();
                }


            }
            else {
                lgp.noGroupFound();
                lgp.lines();
            }

        }
        catch (IOException e) {
            System.out.println("Something went wrong");
        }

    }
    private void JoinGroupController() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            String option = "1";
            while(Objects.equals(option, "1")){
                jgp.askGroupName();
                String groupName = reader.readLine();
                if(!gm.checkGroupExists(groupName)){ // Check whether group name exists if not:-
                    jgp.groupNameNotInMap();
                    option = reader.readLine();
                }
                else if(gm.checkIfIn(groupName, um.getUserById(userId))){
                    // If group name exists and user in group already
                    jgp.alreadyInGroup(groupName);
                    option = reader.readLine();
                }
                else{
                    // Else if group name exists and user is not in the group. Add to group.
                    gm.addUserToGroup(groupName, um.getUserById(userId));
                    // um.addGroupToUser(currentUser, gm.getGroupByName(groupName));
                    jgp.joinSuccess(groupName);
                    option = "2";
                }
            }
            jgp.lines();
        } catch (IOException e){
            System.out.println("Please type a valid number");
        }


    }
}
