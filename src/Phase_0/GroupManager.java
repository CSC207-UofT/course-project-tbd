package Phase_0;

import java.util.ArrayList;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GroupManager extends TaskManager{
    public HashMap<User, ArrayList<Group>> maps;

    /**
     * Construct a TBD.Group, giving them the given category,
     * users, groups and maps
     */
    public GroupManager() {
        this.maps = new HashMap<>();
    }

    /**
     * This is the method to create a new group given a user
     * and the name of the group
     */
    public void createGroup(User user, String name) {
        Group group = new Group(user, name);
        ArrayList<Group> groups = new ArrayList<>();
        groups.add(group);
        this.maps.put(user, groups);
    }

    /**
     * This is the method to delete a group given
     * the wanted group object
     */
    public void deleteGroup(Group group) {
        ArrayList<User> users = group.getUsers();
        users.add(group.getgroupLeader());
        for (User i: users) {
            this.maps.get(i).remove(group);
        }
    }
}
