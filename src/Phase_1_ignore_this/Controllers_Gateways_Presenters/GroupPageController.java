package Phase_1_ignore_this.Controllers_Gateways_Presenters;


import Phase_2.UseCaseClass.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * The controller for managing our group page. This is responsible for the initial pages seen when the user goes
 * to the group management part of our software.
 */
public class GroupPageController {
    UserManager um;
    String userId;
    GroupManager gm;
    UserGroupManager ugm;
    private final TaskManager itm;
    NotificationManager nm;
    private final JoinGroupPresenter jgp = new JoinGroupPresenter();

    public GroupPageController(String userId, UserManager um, GroupManager gm, NotificationManager nm){
        this.um = um;
        this.userId = userId;
        this.gm = gm;
        this.itm = new TaskManager();
        this.ugm = new UserGroupManager();
        this.nm = nm;
    }

    /**
     * Runs our method. This run method is responsible for allowing the user to join a group
     * create a group, view all group, go back etc. Check presenter for more info on each of the options
     */
    public void run(){
        GroupPagePresenter gpp = new GroupPagePresenter();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            boolean flag = true;
            while (flag){
                gpp.welcomeLine();
                String input = reader.readLine();

                // This warning won't go away as replacing with enhanced switch doesn't work with correto-11
                switch (input) {
                    case "0": CreateGroupController();
                    break;
                    case "1": JoinGroupController();
                    break;
                    case "2": LeaveGroupController();
                    break;
                    case "3": ViewGroupController vgc = new ViewGroupController(um, gm, itm, userId, nm);
                    vgc.run();
                    break;
                    default: flag = false;
                    break;
                }

                }
            gpp.lines();
            }
        catch (IOException e){System.out.println("Please type a valid number");
        }
    }

    /**
     * This sub-method controller manages tasks related to creating a new group for the user.
     */
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

    /**
     * This sub-method controller manages tasks related to leaving a group.
     */
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
                }
                else {
                    gm.removeMember(input, this.um.getUserById(userId));
                }
                lgp.leaveSuccess(input);
                lgp.lines();


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

    /**
     * This sub-method controller is responsible for joining a new group.
     */
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
