package Phase_2.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * The group entity class refers to a single group in our system. The attributes are
 * User groupLeader: The leader/creator of the group
 * String groupName: Name of our group
 * ArrayList<User> users: The users inside our group
 * ArrayList<Category> categories: Whenever a user joins our group, a category is created with the users name
 * GroupChat groupChat: A group chat for our group.
 * AnnouncementPage announcementPage: An announcement page where leader can create announcements.
 */
public class Group implements Serializable {
    private final User groupLeader;
    private final String groupName;
    private final ArrayList<User> users = new ArrayList<>();
    private final ArrayList<Category> categories = new ArrayList<>();
    private final GroupChat groupChat;
    private final AnnouncementPage announcementPage;



    public Group(User groupLead, String groupname) {
        this.groupLeader = groupLead;
        this.groupName = groupname;
        this.users.add(groupLead);
        this.categories.add(new Category(groupLead.getUsername()));
        this.groupChat = new GroupChat(groupname);
        this.announcementPage = new AnnouncementPage();
    }

    /**
     * Adds a category to our group
     * @param name: The name of the category (Usually the username of user in our group)
     */
    public void addCategory(String name) {
        this.categories.add(new Category(name));
    }

    /**
     * Adds a task to a category
     * @param t: Task to be added
     * @param c: The category
     */
    public void addTasktoCategory(Task t, Category c) {
        c.addTask(t);
    }

    /**
     * Adds a list of users to a group.
     * @param users: The list of users to be added.
     */
    public void addUsers(List<User> users) {
        this.users.addAll(users);
    }

    /**
     * Removes user from our group
     * @param u1: The user to be removed
     */
    public void removeUser(User u1) {
        users.remove(u1);
    }

    /**
     * Returns the arraylist containing all users in our group
     * @return Arraylist containing users in our group
     */
    public ArrayList<User> getUsers() {
        return this.users;
    }

    /**
     * Returns the group leader of our group
     * @return String representing leader of group
     */
    public User getgroupLeader() {
        return this.groupLeader;
    }

    /**
     * Returns name of group
     * @return String containing name of group
     */
    public String getgroupName() {
        return this.groupName;
    }

    /**
     * Returns the GroupChat object
     * @return The GroupChat object
     */
    public GroupChat getGroupChat() {return this.groupChat;}

    /**
     * Returns all the categories in our group
     * @return Arraylist containing the categories in our group
     */
    public ArrayList<Category> getCategories() {
        return this.categories;
    }

    /**
     * Returns all the members' folder names in this group
     * @return ArrayList containing all the name of the folders
     */
    public ArrayList<String> getCategoryNames() {
        ArrayList<String> result = new ArrayList<>();
        for (Category c : this.categories) {
            result.add(c.toString());
        }
        return result;
    }

    /**
     * Returns the AnnouncementPage object in our group
     * @return The announcement object in our group.
     */
    public AnnouncementPage getAnnouncementPage() {
        return this.announcementPage;
    }
}
