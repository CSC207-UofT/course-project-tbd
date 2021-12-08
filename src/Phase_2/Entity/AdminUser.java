package Phase_2.Entity;

import java.util.ArrayList;
import java.util.Objects;

public class AdminUser extends User{

    private final String username;
    private final String password;
    private final ArrayList<String> myGroups = new ArrayList<>();
    private final ArrayList<Category> myCategories = new ArrayList<>();
    /**
     * Constructs a simplified version of task with only a task name, this constructor is for testing purposes
     * only, and should not be called inside the main program
     *
     * @param username the name of the user
     * @param password the password of the user
     */

    public AdminUser(String username, String password){
        this.username = username;
        this.password = password;
        Category all = new Category("All Tasks");
        this.addNewCategory(all);
    }
    /**
     * Add group to this normal user
     */
    @Override
    public void addGroup(String groupId) {
        this.myGroups.add(groupId);
    }
    /**
     * remove group to this normal user
     */
    @Override
    public void removeGroup(String groupId) {
        this.myGroups.remove(groupId);
    }
    /**
     * get username of  normal user
     */
    @Override
    public String getUsername() {
        return this.username;
    }
    /**
     * Add task to category
     */
    @Override
    public void addTasktoCategory(Task task, Category c) {
        c.getTasks().add(task);
    }
    /**
     * Add new category
     */
    @Override
    public void addNewCategory(Category newCategory) {
        this.myCategories.add(newCategory);
    }
    /**
     * get password
     */
    @Override
    public String getPassword() {
        return this.password;
    }
    /**
     * get groups
     */
    @Override
    public ArrayList<String> getMyGroups() {
        return myGroups;
    }
    /**
     * get tasks
     */
    @Override
    public ArrayList<Task> getMyTasks() {
        return null;
    }
    /**
     * get categories
     */
    @Override
    public ArrayList<Category> getMyCategories() {
        return myCategories;
    }
    /**
     *
     * @param nu the other user
     * @return true if two user is the same
     */
    @Override
    public boolean equals(User nu) {
        return Objects.equals(nu.getUsername(), this.getUsername());
    }
}
