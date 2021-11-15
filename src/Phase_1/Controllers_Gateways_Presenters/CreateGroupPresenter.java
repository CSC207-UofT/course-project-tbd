package Phase_1.Controllers_Gateways_Presenters;

/**
 * The presenter class for class CreateGroup
 */

public class CreateGroupPresenter {

    /**
     * Prompting the user to let them know they are in the create group page
     */
    public void Intro(){
        System.out.println("What would you like your group name to be?");
    }

    /**
     * Prompting the user to let them know that this group name is not valid
     */
    public void InvalidGroupName(String groupName){
        System.out.println("Sorry! The group name " + groupName + " is taken. Please try another group name!");
    }

    /**
     * Notifying the user to let them know that the group has been created
     */
    public void CreateSuccess(String groupName){
        System.out.println("Congrats, group " + groupName + " is now created!");
    }

    /**
     * Line break
     */
    public void lines(){
        System.out.println("---------------------");
    }
}
