package Phase_1.UseCaseClass;

import Phase_1.Entity.Group;
import Phase_1.Entity.User;

import java.util.Set;

public class UserGroupManager {
    public UserGroupManager(){

    }
    public void removeGroup(User user, Group group)
    {
        user.removeGroup(group);
    }

    public void addGroup(User user, Group group){
        user.getMyGroups().put(group.getgroupName(), group);
    }

    public Group getGroup(User user, String groupID){
        return user.getMyGroups().get(groupID);
    }
    public Set<String> getGroupIds(User user){
        return user.getMyGroups().keySet();
    }
}
