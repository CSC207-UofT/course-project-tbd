package Phase_0;

public class TaskPagePresenter {

    public TaskPagePresenter(){
    }


    public void availableOptions(){
        System.out.println("--------------------");
        System.out.print("Your options:\n" +
                "1. Back\n" +
                "2. Add Tasks:\n" +
                "3. finish Task\n" +
                "4. View Tasks \n" +
                "Your answer here: ");
    }

    public void giveNewTaskName(){
        System.out.println("--------------------");
        System.out.print("Enter Task Title:\n");
    }

    public void giveTaskDetail(){
        System.out.println("--------------------");
        System.out.println("Enter Task Detail:");
    }


     public void giveNewTaskDate(){
        System.out.println("--------------------");
        System.out.println("Enter Task Due Date(example October 29, 2020) :");
     }


    public void taskAdd(){
        System.out.println("Your task has been created and added");
    }

    public void enterTaskToComplete(){
        System.out.println("Enter name of task to complete");
    }

    public void taskNotPresent(){
        System.out.println("Sorry, the task is not there in our database");
    }

    public void displayTasks(){
        System.out.println("The tasks are :");
    }


}