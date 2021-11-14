package Phase_1.UseCaseClass;

import Phase_1.Entity.Category;
import Phase_1.Entity.Task;
import Phase_1.Entity.TaskWithDueDate;

/**
 * This TaskManager is the use case that is responsible for accessing and manipulating attributes and methods
 * in Task and its child classes.
 *
 * @author  Owen Huang
 * @author  placeholder
 */
public class TaskManager {

    /**
     * set the status of the task to complete
     *
     * @param task is the task to be finished
     */
    public void completeTask(Task task){
        task.setStatus(true);
    }

    /**
     * Check whether a string taskName is equal the task's title
     *
     * @param task is the task we want to check
     * @param taskName is a string of a task name that we want to check
     */
    public boolean checkTaskByName(Task task, String taskName){
        return task.getTaskName().equals(taskName);
    }

    /**
     * Adds a task to a category
     *
     * @param task is a Task object we want to add
     * @param category is the Category object we want to add task to
     */
    public void addTaskToCategory(Category category, Task task){
        category.addTask(task);
    }

    /**
     * Display all the tasks in a category to the screen
     *
     * @param category is the category we want to view the tasks of
     * @return a string representation of all tasks in category
     */
    public String displayTask(Category category){
        StringBuilder s = new StringBuilder();
        for(Task t: category.getTasks()){
            s.append("--------------------\n").append(t.toString()).append("\n");
        }
        return s.toString();
    }

    /**
     * Create a default Task object and then returns it
     *
     * @param title is the tile of the task
     * @param information is the detail or content of the task
     * @return a Task object constructed with the given parameters
     */
    public Task createTask(String title, String information){
        return new Task(title, information);
    }

    /**
     * Create a TaskWithDueDate object and then returns it
     *
     * @param title the name/title of the task
     * @param information the content/detail of the task
     * @param year the year of the due date
     * @param month the month of the due date
     * @param day the day of the due date
     * @param hour the hour of the due date
     * @param minute the minute of the due date
     * @return a TaskWithDueDate object constructed with the given parameters
     */
    public TaskWithDueDate createTask(String title, String information
            , int year, int month, int day, int hour, int minute){
        return new TaskWithDueDate(title, information, year, month, day, hour, minute);
    }

    /**
     * check whether a task is in the category
     *
     * @param t is the task we want to check
     * @param category is the category we want to check
     * @return a true of task is in category, false otherwise
     */
    public boolean checkTask(Category category, Task t) {
        return category.tasks.contains(t);
    }

    /**
     * Get a specific task in category by the given task name
     *
     * @param taskName is the task name of the task we want to search for in category
     * @param category is the category we want to search task name in
     * @return the task if it has the same name as taskName, null otherwise
     */
    public Task getTaskByName(Category category, String taskName) {
        for (Task t: category.tasks){
            if (this.checkTaskByName(t, taskName)){
                return t;
            }

        }
        return null;
    }
}


