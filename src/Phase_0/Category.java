package Phase_0;

import java.util.ArrayList;

public class Category extends Features{
    private String categoryName;    // This is the name of the category/folder
    private ArrayList<Task> tasks;  // These are all the tasks contained in that category

    public Category (String name) {this.categoryName = name; this.tasks = new ArrayList<>();}

    public void addTask(Task t){
        // This method adds the task to the current category
        this.tasks.add(t);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }


}
