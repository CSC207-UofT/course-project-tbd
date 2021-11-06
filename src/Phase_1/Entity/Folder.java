package Phase_1.Entity;

import java.util.ArrayList;

public class Folder {
    /*This class represents a folder inside a group. This holds all the tasks for a particular
    * user. The folderName refers to the user*/
    private String folderName;    // This is the name of the folder
    private ArrayList<Task> tasks;  // These are all the tasks contained in that folder

    public Folder (String name) {
        // Constructor: takes in name of folder(username) and assigns it to the folder.
        this.folderName = name;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task t){
        // This method adds the task the folder
        this.tasks.add(t);
    }

    public String getFolderName() {
        return this.folderName;
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    @Override
    public String toString() {
        // Prints out the contents of this folder
        StringBuilder s = new StringBuilder();
        s.append(this.folderName).append("\n");
        for (Task t: this.tasks){
            s.append(t.getTaskName()).append("\n");
        }
        s.delete(s.length()-1,s.length());
        return s.toString();
    }
}
