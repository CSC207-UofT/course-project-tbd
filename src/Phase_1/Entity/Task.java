package Phase_1.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * This class creates task, with its title, information, category, deadline to finish each task
 * and  sets it default status to false, until the task is finished.
 */

public class Task implements Serializable {

    /**
     * Title is a string storing the tile of the task
     */
    private final String title;

    /**
     * Information is a string storing the content or detail of the task
     */
    private String information;

    /**
     * A LocalDateTime object storing the actual date information about the alarm time
     */
    private LocalDateTime dueDate = null;

    /**
     * Status indicate the current state of the task, true means completed, false means in progess
     */
    private boolean status;

    /**
     * Constructs a simplified version of task with only a task name, this constructor is for testing purposes
     * only, and should not be called inside the main program
     *
     * @param title is the name of the Task
     */
    public Task(String title){
        this.title = title;
        this.status = false;
    }

    /**
     * Constructs a default task with only a title and an information. Status of the task is set
     * to false (in progress) by default.
     *
     * @param title is the title of the task
     * @param information is the detail or content of the task
     */
    public Task(String title, String information){
        this.title = title;
        this.information = information;
        this.status = false;
    }

    /**
     * Constructs a Task with a due date. This constructor is called by its child class TaskWithDueDate
     * for inheritance purposes only
     *
     * @param  title the name/title of the task
     * @param information the content/detail of the task
     * @param year the year of the due date
     * @param month the month of the due date
     * @param day the day of the due date
     * @param hour the hour of the due date
     * @param minute the minute of the due date
     */
    public Task(String title, String information, int year, int month, int day, int hour, int minute){
        this.title = title;
        this.information = information;
        this.status = false;
        this.dueDate = LocalDateTime.of(year, month, day, hour, minute);
        // 2021/12/07/24/40
        // YYYY/MM/DD/hh/mm
    }

    /**
     * Changes the status
     *
     * @param status is the current status of a task.
     */
    public void setStatus(Boolean status){this.status = status;}

    /**
     * Getter method for the current status of the task
     */
    public boolean getStatus(){
        return this.status;
    }

    /**
     * getter method for the task's title
     *
     * @return This method returns the task name.
     */
    public String getTaskName(){
        return this.title;
    }

    /**
     * This method sets task status from incomplete to complete.
     *
     * @return the due date in LocalDateTime object
     */
    public LocalDateTime getDueDate(){
        return this.dueDate;
    }

    /**
     * override how the task is printed to the console
     *
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