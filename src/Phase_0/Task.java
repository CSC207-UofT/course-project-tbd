package Phase_0;
import java.time.LocalDate;


/**
 * This class creates task, with its title, information, deadline to finish each task and a sets it
 * default status to false, until the task is finished.
 */

public class Task {
    public String title;
    public String information;
    public LocalDate date;
    public boolean status;

    public Task(String title){
        this.title = title;
        this.status = false;
    }

    public Task(String title, String information, LocalDate date){
        this.title = title;
        this.information = information;
        this.date = date;
        this.status = false;
    }

    /**
     *
     * @param status is the current status of a task.
     */
    public void setStatus(Boolean status){this.status = status;}

    public boolean getStatus(){
        return this.status;
    }

    /**
     * @return This method returns the task name.
     */


    public String getTaskName(){
        return this.title;
    }

    /**
     * This method sets task status from incomplete to complete.
     */

    public void completeTask(){
        this.status = true;
    }


    /**
     * @return This method represents the information and status of the task in the form of string.
     */

    @Override
    public String toString() {
        String s = "Title: " + this.title + "\n";
        s += "TODO: " + this.information + "\n";
        s += "DUE DATE: " + this.date + "\n";
        if(this.status){
            s += "Status: " + "Completed";
        }else{
            s += "Status: " + "In Progress";
        }
        return s;
    }
}
