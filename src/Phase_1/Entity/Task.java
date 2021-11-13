package Phase_1.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class creates task, with its title, information, category, deadline to finish each task and a sets it
 * default status to false, until the task is finished.
 */

public class Task implements Serializable {
    private final String title;
    private String information;
    public LocalDateTime dueDate = null;
    public boolean status;

    public Task(String title){
        this.title = title;
        this.status = false;
    }

    public Task(String title, String information){
        this.title = title;
        this.information = information;
        this.status = false;
    }

    public Task(String title, String information, int year, int month, int day, int hour, int minute){
        this.title = title;
        this.information = information;
        this.status = false;
        this.dueDate = LocalDateTime.of(year, month, day, hour, minute);
        // 2021/12/07/24/40
        // YYYY/MM/DD/hh/mm
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

    public LocalDateTime getDueDate(){
        return this.dueDate;
    }

    public void completeTask(){
        this.status = true;
    }

    /**
     * This method adds task to the category.
     * @param c the category in which I want to add my task.
     */

    public void addTasktoCategory(Category c){
        c.addTask(this);
    }


    /**
     * @return This method represents the information and status of the task in the form of string.
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