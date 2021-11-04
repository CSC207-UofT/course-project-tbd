package Phase_1.Entity;

import java.io.Serializable;
import java.util.ArrayList;

public abstract  class User implements Serializable {
    public String username;
    public String password;

    public ArrayList<Group> myGroups = new ArrayList<>();

    public ArrayList<Category> myCategories = new ArrayList<>();
    public ArrayList<Task> myTasks = new ArrayList<>();


    //    public String displayMyCategories() {
    //        StringBuilder s = new StringBuilder();
    //        int size = this.myCategories.size();
    //        for (Category c : this.myCategories) {
    //            s.append(c.getCategoryName());
    //            size -= 1;
    //            if (size != 0) {
    //                s.append("\n");
    //            }
    //        }
    //        return s.toString();
    //    }
    //
    //    /**
    //     * A method that takes the parameter (newCategory) and adds it to the ArrayList
    //     */
    //    public void addNewCategory(Category newCategory) {
    //        this.myCategories.add(newCategory);
    //    }
    //
    //    /**
    //     * A method that takes the parameter (target) and removes it from the ArrayList
    //     */
    //    public void deleteCategory(Category target) {
    //        this.myCategories.remove(target);
    //    }
    //
    //    public ArrayList<Category> getMyCategories(){
    //        return this.myCategories;
    //    }

        public abstract void addGroup(Group group);
        public abstract void removeGroup(Group group);
        public abstract String getUsername();
        public abstract void addTask(Task task);
        public abstract void addNewCategory(Category category);
        public abstract String getPassword();
        public abstract ArrayList<Group> getMyGroups();



    public abstract ArrayList<Task> getMyTasks();


    public abstract ArrayList<Category> getMyCategories();
}