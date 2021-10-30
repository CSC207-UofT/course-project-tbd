package Phase_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class ViewGroupController {
    /**
     * This is a controller for viewing all the groups an user is inside and seeing contents inside a group
     */

    private UserManager um;
    private GroupManager gm;
    private User currentUser;
    private final ViewGroupPresenter vgp= new ViewGroupPresenter;

    public ViewGroupController(UserManager um, GroupManager gm){
        this.gm = gm;
        this.um = um;
    }

    public void run(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(){
            
        }
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
                    option = "2";
                }
            }
            jgp.lines();
        } catch (IOException e){
            System.out.println("Please type a valid number");
        }
    }
}
