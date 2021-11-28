package Phase_1.Entity;

import java.io.Serializable;
import java.util.ArrayList;

public abstract  class User implements Serializable {


        public abstract void addGroup(String groupId);


        public abstract void removeGroup(String groupId);
        public abstract String getUsername();
        public abstract void addTasktoCategory(Task task, Category c);
        public abstract void addNewCategory(Category category);
        public abstract String getPassword();
        public abstract ArrayList<String> getMyGroups();



    public abstract ArrayList<Task> getMyTasks();


    public abstract ArrayList<Category> getMyCategories();

    public abstract boolean equals(NormalUser nu);
}
