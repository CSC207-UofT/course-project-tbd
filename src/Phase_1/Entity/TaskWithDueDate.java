package Phase_1.Entity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * TaskWithDueDate is a child class of Task. It adds addition fields for due date information.
 * It implements comparable interface with other TaskWithDueDate objects
 *
 * @author  Owen Huang
 * @author  placeholder
 */
public class TaskWithDueDate extends Task implements Comparable<TaskWithDueDate>{

    /**
     * A LocalDateTime object storing the actual date information about the alarm time
     */
    public LocalDateTime dueDate;

    /**
     * Constructs the TaskWithDueDate using the super class constructor and additional due date information
     *
     * @param  title the name/title of the task
     * @param information the content/detail of the task
     * @param year the year of the due date
     * @param month the month of the due date
     * @param day the day of the due date
     * @param hour the hour of the due date
     * @param minute the minute of the due date
     */
    public TaskWithDueDate(String title, String information, int year, int month, int day, int hour, int minute) {
        super(title, information);
        this.dueDate = LocalDateTime.of(year, month, day, hour, minute);
        // due date is in the following format
        // 2021/12/07/24/40
        // YYYY/MM/DD/hh/mm
    }

    /**
     * Getter method for getting the due date of the task
     *
     * @return the due date of the task
     */
    public LocalDateTime getDueDate(){
        return this.dueDate;
    }

    /**
     * overrides the compareTo method that compares the task according to their due date.
     * Tasks are compared with their due date. Sooner the due date, higher the priority
     *
     * @return an integer of the difference between two due dates in milliseconds
     */
    @Override
    public int compareTo(TaskWithDueDate o) {
        if (this.dueDate.isBefore(o.getDueDate())){     // if due date is before the other, higher priority
            // returns a positive number of the difference between this.dueDate and o.dueDate in milliseconds
            return (int) Duration.between(this.dueDate, o.getDueDate()).toMillis();
        }else if(this.dueDate.isAfter(o.dueDate)){      // if due date is after the other, lower priority
            return (int) Duration.between(this.dueDate, o.getDueDate()).toMillis();
            // returns a negative number of the difference between this.dueDate and o.dueDate in milliseconds
        }else{
            return 0;
        }
    }

    /**
     * Inherits the toString method from parent, and add an extra line for displaying due date information
     *
     * @return a string representation of TaskWithDueDate
     */
    @Override
    public String toString() {
        // formats the due date in: day/month/year hour/minute. for example
        // 'July 28, 2021, 7:45 pm' would be formatted to '28-07-2021 19:45'
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatDateTime = this.dueDate.format(format);
        return super.toString() + "\nDue Date: " +formatDateTime;
    }
}
