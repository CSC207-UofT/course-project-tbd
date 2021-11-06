package Phase_1.UseCaseClass;

import Phase_1.Entity.Group;
import Phase_1.Entity.User;

import java.util.ArrayList;
import java.util.Set;

public class UserGroupManager {
    public UserGroupManager(){

    }
    public void removeGroup(User user, String groupId)
    {
        user.removeGroup(groupId);
    }

    public void addGroup(User user, String groupId){
        user.getMyGroups().add(groupId);
    }

    public ArrayList<String> getGroupIds(User user){
        return user.getMyGroups();
    }

    public ArrayList<String> getMyGroups(User user){
        return user.getMyGroups();
    }
}
