package Phase_0;

import java.util.ArrayList;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class GroupManager extends TaskManager{
    public HashMap<User, ArrayList<Group>> maps;

    /**
     * Construct a TBD.GroupManager, giving them the given maps
     * attribute with User as keys and ArrayList contains Group as
     * values
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

    /**
     * This method returns a List of User in a given group name
     * @param group the wanted group
     * @return List of User in the wanted group
     */
    public ArrayList memberList(Group group) {
        return group.getUsers();
    }

    /**
     * This method checks whether the given name
     * has been taken
     * @param group the wanted group
     * @return true if there exists a group with
     * the same name and false otherwise
     */
    public boolean checkGroupName(Group group) {
        for (User i: this.maps.keySet()) {
            for (Group j: this.maps.get(i)) {
                if (group.getgroupName().equals(j.getgroupName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method checks add a given group to the user's
     * group list
     * @param group the group that we want to add
     * @param user given user
     * @return true if the group is added and false
     * otherwise
     */
    public boolean addGroup(Group group, User user) {
        return this.maps.get(user).add(group);
    }

    /**
     * This method removes a user from the given group
     * @param group the given group
     * @param user the member that is removed from group
     * @return true if successfully remove the member and
     * false otherwise
     */
    public boolean removeMember(Group group, User user) {
        return this.maps.get(user).remove(group);
    }
}
