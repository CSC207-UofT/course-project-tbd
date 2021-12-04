package Phase_1.Entity;

import java.util.ArrayList;
import java.util.Objects;

public class AdminUser extends User{

    private final String username;
    private final String password;
    private final ArrayList<String> myGroups = new ArrayList<>();
    private final ArrayList<Category> myCategories = new ArrayList<>();
    private final ArrayList<Task> myTasks = new ArrayList<>();

    public AdminUser(String username, String password){
        this.username = username;
        this.password = password;
        Category all = new Category("All Tasks");
        this.addNewCategory(all);
    }

    @Override
    public void addGroup(String groupId) {
        this.myGroups.add(groupId);
    }

    @Override
    public void removeGroup(String groupId) {
        this.myGroups.remove(groupId);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void addTasktoCategory(Task task, Category c) {
        c.getTasks().add(task);
    }

    @Override
    public void addNewCategory(Category newCategory) {
        this.myCategories.add(newCategory);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public ArrayList<String> getMyGroups() {
        return myGroups;
    }

    @Override
    public ArrayList<Task> getMyTasks() {
        return null;
    }

    @Override
    public ArrayList<Category> getMyCategories() {
        return myCategories;
    }

    @Override
    public boolean equals(User nu) {
        return Objects.equals(nu.getUsername(), this.getUsername());
    }
}
