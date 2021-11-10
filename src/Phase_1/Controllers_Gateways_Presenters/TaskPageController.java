package Phase_1.Controllers_Gateways_Presenters;


import Phase_1.Entity.Category;
import Phase_1.Entity.Task;
import Phase_1.Entity.TaskWithDueDate;
import Phase_1.UseCaseClass.CategoryManager;
import Phase_1.UseCaseClass.NotificationManager;
import Phase_1.UseCaseClass.TaskManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.*;

/**
 * This TaskPageController class is made for controlling the task
 * page according to the user input. This TaskPageController is
 * specialized to one category only, and the category is determined upon
 * specification of the user.
 *
 * @author  Owen Huang, Sanjana Girish
 * @author  placeholder
 */
public class TaskPageController {

    /**
     * A Category Name which is unique to a user
     */
    private String catName;


    /**
     * Task Page presenter contains all the print statements associated with the task page
     */
    private TaskPagePresenter tpp;

    /**
     * Use case for all operations we are performing on Tasks (e.g. add task, delete task)
     */
    private TaskManager itm;

    /**
     * Used to start alarm for task with a due date, and send notification to user mailbox
     */
    NotificationManager nm;

    /**
     * Used to access and modify category information
     */
    CategoryManager cm;



    /**
     * Constructs the personalized Task Page for the specified category
     *
     * @param  catName a unique category associated with the tasks
     * @param cm the category manager class responsible for operating on user information
     * @param nm the notification manager class responsible for operations on tasks with due date
     */
    public TaskPageController(String catName, CategoryManager cm, NotificationManager nm){
        this.cm = cm;
        this.nm = nm;
        this.catName = catName;
        this.itm = new TaskManager();
        this.tpp = new TaskPagePresenter();
    }

    /**
     * Starts the task page for a particular category, display to the terminal for interaction with the user
     *
     * @param  category a category which all tasks are related to
     * @throws IOException {@inheritDoc}
     */
    public void run(Category category) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        tpp.displayTasks();
        String input = "";
        while (!input.equals("1")){     // equals to 1 means to go back to previous page
            tpp.availableOptions();
            input = reader.readLine();
            if ("2".equals(input)) {    // equals to 2 means to create and add a new task to current category
                addTask(reader, category);
            } else if ("3".equals(input)) {     // equals to 3 means user wants to finish an existing task in category
                finishTask(reader, category);
            } else if ("4".equals(input)) {     // equals to 4 means user wants to view all current tasks in category
                tpp.displayTasks();
                System.out.println(itm.displayTask(category));
            }
        }
    }

    /**
     * When user chooses 3, this helper method finishes the task by the task name entered by the user
     * for a particular category
     * @param  reader a BufferedReader for input
     * @param  category a category which all tasks are related to
     * @throws IOException {@inheritDoc}
     */
    private void finishTask(BufferedReader reader, Category category) throws IOException {
        tpp.enterTaskToComplete();
        String taskToComplete = reader.readLine();      //prompts the user for a task name
        Task task = itm.getTaskByName(category, taskToComplete);// get the specified task in user's tasks
        if(itm.checkTask(category, task)){  // If task is present in user, mark it finished
            itm.completeTask(task);
            System.out.println("Task finished");
        }
        else{   //the task with the given name does not exist in user's current tasks
            tpp.taskNotPresent();
        }
    }

    /**
     * When user chooses 2, this helper method prompt the user for details like task name, the content of the task, and
     * whether the user would like to set a due date for the task. If so, the notification system will set up an
     * alarm for the task and notify the user when it is due
     *
     * @param  reader a BufferedReader for input
     * @param  category a category which all tasks are related to
     * @throws IOException {@inheritDoc}
     */
    private void addTask(BufferedReader reader, Category category) throws IOException {
        tpp.giveNewTaskName();
        String taskTitle = reader.readLine();   // prompts for a name for the new task
        while(itm.getTaskByName(category, taskTitle) != null){
            // while a task can be found in category with the same name as the above, prompt the user to try a new name
            tpp.TaskNotUnique();
            taskTitle = reader.readLine();
        }

        tpp.giveTaskDetail();
        String taskDetail = reader.readLine();      //user enters the content of the task

        System.out.println("Do you want to set an alarm to notify you of this task? (y/n)");
        String yesOrNo = reader.readLine();     //"y" for yes, and anything else mean no

        if (yesOrNo.equals("y")){
            System.out.println("When do you want to be notified (24-hour clock)? " +
                    "YYYY/MM/DD/hh/mm (ex. 2021/11/02/05/21)");     //dates must be entered in the specified format
            try {
                String date = reader.readLine();        //user enters the due date info
                List<String> formattedDate = List.of(date.strip().split("/")); //split the date into a string list
                // transform string input into integers
                // Index out of bound exception may be thrown if user doesn't follow the format
                int year = Integer.parseInt(formattedDate.get(0));
                int month = Integer.parseInt(formattedDate.get(1));
                int day = Integer.parseInt(formattedDate.get(2));
                int hour = Integer.parseInt(formattedDate.get(3));
                int minute = Integer.parseInt(formattedDate.get(4));

                // create the task as a TaskWithDueDate object
                // error dateTime exception may be thrown of date information is invalid (e.g. -200 minutes)
                TaskWithDueDate task = new TaskWithDueDate(taskTitle, taskDetail, year, month, day, hour, minute);
                nm.addTaskWithDueDate(task);    // add to notification manager for creating alarm for task
                itm.addTask(category, task);  // add task to user's task collection
                tpp.taskAdded();
            } catch (UnsupportedOperationException e) {     // exception thrown when user schedules a date in the past
                System.out.println(e.getMessage());
            } catch (IndexOutOfBoundsException e2){     // when the user's date input does not follow the format
                System.out.println("Please enter according to the format: Year/Month/Date/Hour/Minute");
            } catch (DateTimeException e3){     // when the date user entered is an invalid date
                System.out.println("You have entered an invalid date");
            }
        }else{      // user does not want to create a task with due date
            Task task = new Task(taskTitle, taskDetail, category); // create a simple task without due date
            itm.addTask(category, task);  // add task to category's task collection
            tpp.taskAdded();
        }
    }
}