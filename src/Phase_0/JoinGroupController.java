package Phase_0;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class JoinGroupController {
    // Controller for adding user to a group

    private UserManager um;
    private GroupManager gm;
    private User currentUser;
    private final JoinGroupPresenter jgp = new JoinGroupPresenter();

    public JoinGroupController(UserManager um, GroupManager gm, User currentUser){
        this.um = um;
        this.gm = gm;
        this.currentUser = currentUser;
    }

    public void run(){
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
                else if(gm.checkIfIn(groupName, currentUser)){
                    // If group name exists and user in group already
                    jgp.alreadyInGroup(groupName);
                    option = reader.readLine();
                }
                else{
                    // Else if group name exists and user is not in the group. Add to group.
                    gm.addUserToGroup(groupName, currentUser);
                   // um.addGroupToUser(currentUser, gm.getGroupByName(groupName));
                    jgp.joinSuccess(groupName);
                }
            }
        } catch (IOException e){
            System.out.println("Please type a valid number");
        }


    }
}
