package Phase_2.UseCaseClass;

import Phase_2.Entity.User;

import java.util.ArrayList;

public class UserGroupManager {
    public UserGroupManager(){
    }

    /**
     * This method removes the given user from the group.
     * @param user the user object
     * @param groupId the string representation of the groupID.
     */
    public void removeGroup(User user, String groupId)
    {
        user.removeGroup(groupId);
    }

    /**
     * This method add the given user to the group.
     * @param user the user object
     * @param groupId the string representation of the groupID.
     */

    public void addGroup(User user, String groupId){user.addGroup(groupId);
    }

    /**
     * This method returns all the groupsID for the given user.
     * @param user the user object
     */

    public ArrayList<String> getGroupIds(User user){
        return user.getMyGroups();
    }

    /**
     * This method returns all the groups name for the given user.
     * @param user the user object
     */

    public ArrayList<String> getMyGroups(User user){
        return user.getMyGroups();
    }


    /**
     * This method returns info of the groups name for the given user.
     * @param user the user object
     * @return user's group info
     */
    public String getGroupInfo(User user){
        StringBuilder te = new StringBuilder();
        te.append("Dear ").append(user.getUsername()).append(": \n");
        te.append("\n You currently joined ").append(this.getMyGroups(user).size()).append(" group(s) \n");
        te.append("Here is the ID(s) of your joined group(s):\n");
        for (String g: this.getMyGroups(user)){
            te.append(g).append("\n");
        }
        return te.toString();
    }
}
