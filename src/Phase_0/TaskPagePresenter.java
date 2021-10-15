package Phase_0;

public class TaskPagePresenter {
    private NormalUser user;

    public TaskPagePresenter(NormalUser user){
        this.user = user;
    }

    public void displayCategory(){
        System.out.println("--------------------");
        System.out.println("Categories:");
        System.out.println(this.user.displayMyCategories());
    }

    public void availableOptions(){
        System.out.println("--------------------");
        System.out.print("Your options:\n" +
                "1, Back\n" +
                "2. Add Tasks:\n" +       // Can Create a Task which can either take in a String for Title, or with an optional Category parameter
                "3. View Task\n" +
                "4. View Category\n" +
                "Your answer here: ");
    }
    public void giveNewTaskName(){
        System.out.println("--------------------");
        System.out.print("Enter Task Name:\n");
    }
}
