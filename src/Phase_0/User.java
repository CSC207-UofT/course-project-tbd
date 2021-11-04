package Phase_0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public abstract  class User implements Serializable {
    public String username;
    public String password;

    HashMap<String, Group> myGroups = new HashMap<String, Group>();

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


    }
