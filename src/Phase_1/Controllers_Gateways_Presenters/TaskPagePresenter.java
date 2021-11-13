package Phase_1.Controllers_Gateways_Presenters;

/**
 * This TaskPagePresenter is a class that manages all the system out print
 * statements, to make out code concise and neat to read.
 *
 * @author  Owen Huang
 */
public class TaskPagePresenter {

    /**
     * Shows all the available options users can choose in the program
     */
    public void availableOptions(){
        System.out.println("--------------------");
        String s = "Your options:\n";
        s += "1. Back\n";
        s += "2. Add Tasks:\n";
        s += "3. finish Task\n";
        s += "4. View Tasks \n";
        s += "Your answer here: ";
        System.out.println(s);
    }

    /**
     * Prompts the user to enter the name of the task they are creating
     */
    public void giveNewTaskName(){
        System.out.println("--------------------");
        System.out.print("Enter Task Title:\n");
    }

    /**
     * Prompts the user to enter the detail content of the task
     */
    public void giveTaskDetail(){
        System.out.println("--------------------");
        System.out.println("Enter Task Detail:");
    }

    /**
     * Tells the user the task as been successfully created
     * this method will be called iff task is successfully added
     */
    public void taskAdded(){
        System.out.println("Your task has been created and added");
    }

    /**
     * Prompts the user to enter the name of the task they want to complete.
     * note* the program does not allow two tasks to have the same name
     */
    public void enterTaskToComplete(){
        System.out.println("Enter name of task to complete");
    }

    /**
     * Tells the user that the task name they have entered does not exist in our database
     */
    public void taskNotPresent(){
        System.out.println("Sorry, the task is not there in our database");
    }

    /**
     * The prompting message before showing all tasks to the user
     */
    public void displayTasks(){
        System.out.println("The tasks are :");
    }

    /**
     * Tells the user the task name they entered already exists in the database
     */
    public void TaskNotUnique(){
        System.out.println("A task with this name already exist, please try again:");
    }


}