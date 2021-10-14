package Phase_0;

import java.util.ArrayList;

import java.util.HashMap;

public class GroupManager extends TaskManager{
    public HashMap<User, ArrayList<Group>> maps;

//    /**
//     * Construct a TBD.Group, giving them the given category,
//     * users, groups and maps
//     *
//     * @param maps All the users inside the program and their groups
//     */
//    public GroupManager(HashMap<User, ArrayList<Group>> maps) {
//        this.maps = maps;
//    }

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
     * This is the method to delete a group given a name of
     * the wanted group
     */
    public void deleteGroup(Group group) {
        for (User i: group.getUsers()) {
            ArrayList<Group> groups = this.maps.get(i);
            groups.remove(group);
        }
    }
}
