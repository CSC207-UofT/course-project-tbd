package Phase_1.Entity;


import java.io.Serializable;
import java.util.ArrayList;

public class NormalUser extends User implements Serializable {

    private final String username;
    private String password;
    private String sq;
    private String sq_ans;

    private final ArrayList<String> myGroups = new ArrayList<>();

    private final ArrayList<Category> myCategories = new ArrayList<>();
    private final ArrayList<Task> myTasks = new ArrayList<>();

    public NormalUser(String username, String password, String sq, String sq_ans) {
        this.username = username;
        this.password = password;
        this.sq = sq;
        this.sq_ans = sq_ans;
        Category all = new Category("All Tasks");
        this.addNewCategory(all);

    }

    public NormalUser(String username, String password) {
        this.username = username;
        this.password = password;
        Category all = new Category("All Tasks");
        this.addNewCategory(all);
    }

    /**
     * A method that returns username and password. PS someone please change the format to make it look better
     */
    public String displayUserDetail() {
        return ("Username: " + this.username + "\n"
                + "Password: " + this.password);
    }

    /**
     * Add group to this normal user
     */
    public void addGroup(String groupId) {
        this.myGroups.add(groupId);


    }

    /**
     * Remove group from this normal user
     */
    @Override
    public void removeGroup(String group) {
        this.myGroups.remove(group);
    }

    /**
     * Add task to category c
     */
    public void addTasktoCategory(Task task, Category c) {
        c.getTasks().add(task);
    }

    /**
     * Create a new category to this normal user
     */
    public void addNewCategory(Category newCategory) {
        this.myCategories.add(newCategory);
    }

    /**
     * Returns all tasks from this user
     */
    public ArrayList<Task> getMyTasks() {
        return myTasks;
    }

    /**
     * Returns username of this normal user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns password of this normal user
     */
    public String getPassword() {
        return password;
    }

    /**
     * returns security question of this normal user
     */
    public String getSQ() {
        return sq;
    }

    /**
     * returns security questions answer of this normal user
     */
    public String getSQ_Ans() {
        return sq_ans;
    }

    /**
     * resets the password of this normal user
     */
    public void setPassword(String pass) {
        this.password = pass;
    }

    /**
     * Returns all groups of this normal user
     */
    @Override
    public ArrayList<String> getMyGroups() {
        return myGroups;
    }

    /**
     * returns all categories of this normal user
     */
    public ArrayList<Category> getMyCategories() {
        return myCategories;
    }
}