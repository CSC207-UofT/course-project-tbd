package Phase_1.Entity;

/**
 * This class creates task, with its title, information, category, deadline to finish each task and a sets it
 * default status to false, until the task is finished.
 *
 * @author  Owen Huang
 * @author  placeholder
 */
public class Task {

    /**
     * The title of the task, where no two task can have the same title
     */
    private String title;

    /**
     * The detail description of the task
     */
    private String information;

    /**
     * Whether task is completed, true means completed, false means incomplete
     */
    private boolean status;

    /**
     * The Category this task belongs to, all tasks belong to the 'All Tasks' category
     */
    private Category category;

    /**
     * Construct a task with only a title and status.
     * This is for testing purposes only, and nowhere in the main program
     * should this instance of Task be created
     *
     * @param title is the title of the task
     */
    public Task(String title){
        this.title = title;
        this.status = false;
    }

    /**
     * Construct a basic Task with title and information (its description)
     * and assign it to a category
     *
     * @param title is the title of the task
     * @param information is the description of the task
     * @param category is the category this task belongs to
     */
    public Task(String title, String information, Category category){
        this.title = title;
        this.information = information;
        this.status = false;
        this.category = category;
    }

    /**
     * Construct a basic Task with title and information (its description) only.
     * The purpose of this constructor is for its child classes to inherit from without
     * specifying the Category it belongs to. Making it easier to extend.
     *
     * @param title is the title of the task
     * @param information is the description of the task
     */
    public Task(String title, String information){
        this.title = title;
        this.information = information;
        this.status = false;
    }

    /**
     * Setter method for the status of the task
     *
     * @param status is what we want to set status to, true means complete, false means incomplete
     */
    public void setStatus(Boolean status){this.status = status;}

    /**
     * Getter method for the current status of the task
     *
     * @return the status of the task
     */
    public boolean getStatus(){
        return this.status;
    }

    /**
     * Getter method for the task title
     *
     * @return this method returns the task title
     */
    public String getTaskName(){
        return this.title;
    }

    /**
     * Override the toString method to print task details to window
     *
     * @return a string s representing the task and its details
     */
    @Override
    public String toString() {
        String s = "Title: " + this.title + "\n";
        s += "TODO: " + this.information + "\n";
        if(this.status){
            s += "Status: " + "Completed";
        }else{
            s += "Status: " + "In Progress";
        }
        return s;
    }
}