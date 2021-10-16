package Phase_0;

import java.util.ArrayList;

import java.util.HashMap;

//import static org.junit.Assert.assertEquals;

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
     * @param groupname the
     * @param user
     */
        public void deleteGroup(String groupname, User user) {
            for (Group g: this.maps.get(user)) {
                if (g.getgroupName().equals(groupname)) {
                    ArrayList<User> users = g.getUsers();
                    for (User i: users) {
                        this.maps.get(i).remove(g);
                    }
                }
            }
    }

    /**
     * This method returns a List of User in a given group name
     * @param group the wanted group
     * @return List of User in the wanted group
     */
    public ArrayList<User> memberList(Group group) {
        return group.getUsers();
    }

    /**
     * This method checks whether a given user is in a
     * group
     * @param groupname the name of a group
     * @param user the given user
     * @return true if the given user is in the group with the
     * given name and false otherwise
     */
    public boolean checkIfIn(String groupname, User user) {
            for (Group j: this.maps.get(user)) {
                if (groupname.equals(j.getgroupName())) {
                    return true;
                }
            }
        return false;
    }

    /**
     * This method checks whether the given group name
     * has been taken
     * @param groupname the wanted group name
     * @return true if there exists a group with
     * the same name and false otherwise
     */
    public boolean checkGroupExists(String groupname) {
        for (User user: this.maps.keySet()) {
            for (Group j : this.maps.get(user)) {
                if (groupname.equals(j.getgroupName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method checks whether a given user is the leader
     * of a given group
     * @param groupname the name of a group
     * @param user the given user
     * @return true if the given user is the leader of
     *  the group with the given name and false otherwise
     */
    public boolean checkIfLeader(String groupname, User user) {
        for (Group j: this.maps.get(user)) {
            if (groupname.equals(j.getgroupName())) {
                return j.getgroupLeader().equals(user);
            }
        }
        return false;
    }

    /**
     * This method checks add a given group to the user's
     * group list
     * @param groupname the group that we want to add
     * @param user given user
     * otherwise
     */
    public void addUserToGroup(String groupname, User user) {
        for (User u : this.maps.keySet()) {
            for (Group j : this.maps.get(u)) {
                if (groupname.equals(j.getgroupName())) {
                    this.maps.get(user).add(j);
                }
            }
        }
    }

    /**
     * This method removes a user from the given group
     * @param groupname the given group
     * @param user the member that is removed from group
     */
    public void removeMember(String groupname, User user) {
        for (Group j: this.maps.get(user)) {
            if (groupname.equals(j.getgroupName())) {
                this.maps.get(user).remove(j);
                return;
            }
        }
    }
}
