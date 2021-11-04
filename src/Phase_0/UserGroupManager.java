package Phase_0;

public class UserGroupManager {
    UserGroupManager(){

    }
    public void removeGroup(User user, Group group)
    {
        user.removeGroup(group);
    }

    public void addGroup(User user, Group group){
        user.addGroup(group);
    }

    public Group getGroup(User user, String groupID){
        return user.myGroups.get(groupID);
    }
}
