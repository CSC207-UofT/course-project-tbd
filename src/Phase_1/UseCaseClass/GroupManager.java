package Phase_1.UseCaseClass;

import Phase_1.Entity.Group;
import Phase_1.Entity.User;

import java.util.ArrayList;

import java.util.HashMap;

public class GroupManager{
    public HashMap<String, Group> maps;
    UserGroupManager ugm = new UserGroupManager();

    /**
     * Construct a TBD.GroupManager, giving them the given maps
     * attribute with User as keys and ArrayList contains Group as
     * values
     * @param maps the HasMap that contains all the groups in the system
     *             and their names
     */
    public GroupManager(HashMap<String, Group> maps) {
        this.maps = maps;
    }

    /**
     * This is the method to create a new group given a user
     * and the name of the group
     * @param user the leader of the group
     * @param name name of the group
     */
    public void createGroup(User user, String name) {
        int count = 0;
        for (Group g: maps.values()) {
           String a = g.getgroupName().substring(g.getgroupName().indexOf('#')+1);
            if (count <= Integer.parseInt(a)){
                count = Integer.parseInt(a) + 1;
            }}
        String groupId =  "#" + count;
        Group group = new Group(user, name + groupId);
        this.maps.put(name+groupId, group);
        ugm.addGroup(user, group.getgroupName());
    }

    /**
     * This is the method to delete a group given
     * the wanted group object
     * @param groupName name of the wanted to delete group
     * @param leader leader of the group
     */
    public void deleteGroup(String groupName, User leader) {
        ugm.removeGroup(leader, groupName);
        for (User user: this.maps.get(groupName).getUsers()){
            ugm.removeGroup(user, groupName);
        }
        this.maps.remove(groupName);
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
            if (i.equals(user)) {
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
        User leader = group.getgroupLeader();
        return user.equals(leader);
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
        ugm.addGroup(user, groupname);
        group.addCategory(user.getUsername());
    }

    /**
     * This method removes a user from the given group
     * @param groupname the given group
     * @param user the member that is removed from group
     */
    public void removeMember(String groupname, User user) {
        Group group = this.maps.get(groupname);
        group.removeUser(user);
        ugm.removeGroup(user, groupname);
    }

    /**
     * This method returns an instance of Group that matches the
     * given groupId
     * @param groupId the given Id of the wanted group
     * @return the wanted Group of the given Id
     */
    public Group getGroupById(String groupId){
        return maps.get(groupId);
    }
}
