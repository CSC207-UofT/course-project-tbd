package Phase_0;

import java.sql.Array;
import java.util.ArrayList;

public class Category extends Features{
    private String categoryName;    // This is the name of the category/folder
    private ArrayList<Task> tasks;  // These are all the tasks contained in that category

    public Category (String name) {
        this.categoryName = name;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task t){
        // This method adds the task to the current category
        this.tasks.add(t);
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.categoryName).append("\n");
        for (Task t: this.tasks){
            s.append(t.getTaskName()).append("\n");
        }
        s.delete(s.length()-1,s.length());
        return s.toString();
    }
}
