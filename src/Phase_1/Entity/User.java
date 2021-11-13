package Phase_1.Entity;

import java.io.Serializable;
import java.util.ArrayList;

public abstract  class User implements Serializable {
    public String username;
    public String password;

    ArrayList<String> myGroups = new ArrayList<>();

    public ArrayList<Category> myCategories = new ArrayList<>();
    public ArrayList<Task> myTasks = new ArrayList<>();
        public abstract void addGroup(String groupId);


        public abstract void removeGroup(String groupId);
        public abstract String getUsername();
        public abstract void addTasktoCategory(Task task, Category c);
        public abstract void addNewCategory(Category category);
        public abstract String getPassword();
        public abstract ArrayList<String> getMyGroups();



    public abstract ArrayList<Task> getMyTasks();


    public abstract ArrayList<Category> getMyCategories();
}
