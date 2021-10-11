package TBD;

import TBD.Group;
import java.util.ArrayList;

import java.util.HashMap;

public class GroupManager extends TaskManager{
    public HashMap<User, ArrayList<Group>> maps;

    /**
     * Construct a TBD.Group, giving them the given category,
     * users, groups and maps
     *
     * @param maps All the users inside the program and their groups
     */
    public GroupManager(HashMap<User, ArrayList<Group>> maps) {
        this.maps = maps;
    }

    public void createGroup(User user, String name) {
        Group group = new Group(user, name);
        ArrayList<Group> groups = new ArrayList<>();
        groups.add(group);
        this.maps.put(user, groups);
    }

    public void deleteGroup(Group group) {
        for (User i: group.getUsers) {
            ArrayList<Group> groups = this.maps.get(i);
            groups.remove(group);
        }
    }
}
