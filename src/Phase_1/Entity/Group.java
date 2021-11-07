package Phase_1.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {
    private User groupLeader;
    private String groupName;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Features> features = new ArrayList<>();
    private ArrayList<Category> categories = new ArrayList<>();
    private GroupChat groupChat;


    public Group(User groupLead, String groupname) {
        this.groupLeader = groupLead;
        this.groupName = groupname;
        this.users.add(groupLead);
        this.categories.add(new Category(groupLead.getUsername()));
        this.groupChat = new GroupChat(groupname);
    }

    /**
     * A method that takes the parameter (newCategory) and adds it to the ArrayList
     */

    public void addNewFeature(Features target) {
        this.features.add(target);
    }


    /**
     * A method that takes the parameter (target) and removes it from the ArrayList
     */

    public void deleteFeature(Features target) {
        this.features.remove(target);
    }

    public void addCategory(String name) {
        this.categories.add(new Category(name));
    }

    public void addTasktoCategory(Task t, Category c) {
        c.addTask(t);
    }

    public void addUsers(List<User> users) {
        this.users.addAll(users);
    }

    public boolean removeUser(User u1) {
        return users.remove(u1);
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public User getgroupLeader() {
        return this.groupLeader;
    }

    public String getgroupName() {
        return this.groupName;
    }

    public GroupChat getGroupChat() {
        return this.groupChat;
    }

    public ArrayList<Features> getFeatures() {
        return this.features;
    }

    public ArrayList<Category> getCategories() {
        return this.categories;
    }

}
