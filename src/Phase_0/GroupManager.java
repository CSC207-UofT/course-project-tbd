package Phase_0;

import java.util.ArrayList;

import java.util.HashMap;

//import static org.junit.Assert.assertEquals;

public class GroupManager extends TaskManager{
    public HashMap<String, Group> maps;

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
     * @param user the leader of the group
     * @param name name of the group
     */
    public void createGroup(User user, String name) {
        Group group = new Group(user, name);
        this.maps.put(name, group);
        UserManager manager = new UserManager();
        manager.addGroup(user, group);
    }

    /**
     * This is the method to delete a group given
     * the wanted group object
     * @param groupname name of the wanted to delete group
     * @param leader leader of the group
     */
    public void deleteGroup(String groupname, User leader) {
        UserManager manager = new UserManager();
        manager.removeGroup(leader, this.maps.get(groupname));
        this.maps.remove(groupname);
    }

    /**
     * This method returns a List of User in a given group name
     * @param name name of the wanted group
     * @return List of User in the wanted group
     */
    public ArrayList<User> memberList(String name) {
        Group group = this.maps.get(name);
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
        Group group = this.maps.get(groupname);
        for (User i: group.getUsers()) {
            if (i.Username.equals(user.Username)) {
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
        for (String name: this.maps.keySet()) {
            if (groupname.equals(name)) {
                return true;
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
        Group group = this.maps.get(groupname);
        String leader = group.getgroupLeader().Username;
        return user.Username.equals(leader);
    }

    /**
     * This method adds a given group to the user's
     * group list
     * @param groupname the group that we want to add
     * @param user given user
     */
    public void addUserToGroup(String groupname, User user) {
        Group group = this.maps.get(groupname);
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        group.addUsers(users);
    }

    /**
     * This method removes a user from the given group
     * @param groupname the given group
     * @param user the member that is removed from group
     */
    public void removeMember(String groupname, User user) {
        Group group = this.maps.get(groupname);
        group.removeUser(user);
    }
}
