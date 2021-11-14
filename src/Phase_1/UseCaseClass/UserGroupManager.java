package Phase_1.UseCaseClass;

import Phase_1.Entity.User;

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
}
