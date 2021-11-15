package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;


/**
 * Presenter for the class GroupAddTask
 */
public class GroupAddTaskPresenter {
    private final String groupId;
    private final UserManager um;
    private final GroupManager gm;
    private final String userId;
    private final String categoryName;

    /**
     * Constructs the personalized Task Page for the specified category
     * @param userId an id of the User given from the previous controller
     * @param groupId an id of the Group given from the previous controller
     * @param categoryName the category's name given from the previous controller
     * @param um an instance of UserManager
     * @param gm an instance of GroupManager
     */
    public GroupAddTaskPresenter(String userId, UserManager um, GroupManager gm, String groupId, String categoryName) {
        this.userId = userId;
        this.um = um;
        this.gm = gm;
        this.groupId = groupId;
        this.categoryName = categoryName;
    }

    /**
     * Instructions for adding task to the group
     */
    public void instructions() {
        if (gm.checkIfLeader(gm.getGroupById(groupId).getgroupName(), um.getUserById(userId))) {
            String s = "Type 1 to display all the assigned tasks for this member\n";
            s = s + "Type 2 to add a task for this member\n";
            s = s + "Type 0 to get back to the previous page";
            System.out.println(s);
        } else if (userId.equals(categoryName)) {
            String s = "Type 1 to display all the assigned tasks for you in this group\n";
            s = s + "Type 2 to finish a task\n";
            s = s + "Type 0 to get back to the previous page";
            System.out.println(s);
        } else {
            System.out.println("Type 1 to display all the assigned tasks for this member\n" +
                    "Type 0 to get back to the previous page");
        }
    }

    /**
     * Prompt the user to give name to task
     */
    public void giveTaskName() {
        System.out.println("--------------------");
        System.out.println("Enter Task Title:\n");
    }

    /**
     * Prompt the user to give purpose to task
     */
    public void giveTaskDetail() {
        System.out.println("--------------------");
        System.out.println("Enter Task Detail:");
    }

    /**
     * Message to let user know that task have been added
     */
    public void taskAdded(){
        System.out.println("The task you entered has been successfully added");
    }

    /**
     * Message to let user know that the task has been created
     */
    public void toComplete() {
        System.out.println("Please enter the name of a task you have completed ");
    }

    /**
     * Message to let user know that task entered is not valid
     */
    public void notValid() {
        System.out.println("The Task you entered is not valid");
    }
}