package Phase_2.Entity;

import java.io.Serializable;
import java.util.ArrayList;

public abstract  class User implements Serializable {

    /**
     * Add group to this normal user
     */
    public abstract void addGroup(String groupId);

    /**
     * remove group to this normal user
     */
    public abstract void removeGroup(String groupId);
    /**
     * get username of  normal user
     */
    public abstract String getUsername();
    /**
     * Add task to category
     */
    public abstract void addTasktoCategory(Task task, Category c);
    /**
     * Add new category
     */
    public abstract void addNewCategory(Category category);
    /**
     * get password
     */
    public abstract String getPassword();
    /**
     * get groups
     */
    public abstract ArrayList<String> getMyGroups();
    /**
     * get tasks
     */
    public abstract ArrayList<Task> getMyTasks();
    /**
     * get categories
     */

    public abstract ArrayList<Category> getMyCategories();
    /**
     *
     * @param nu the other user
     */

    public abstract boolean equals(User nu);
}
