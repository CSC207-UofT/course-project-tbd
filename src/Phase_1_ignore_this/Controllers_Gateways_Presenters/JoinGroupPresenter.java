package Phase_1_ignore_this.Controllers_Gateways_Presenters;

/**
 * JoinGroup presenter for class JoinGroup
 */
public class JoinGroupPresenter {

    /**
     * Prompts user to give group name
     */
    public void askGroupName(){
        System.out.println("Please enter the group name");
    }

    /**
     * Message to let user know that the group being asked for does not exist
     */
    public void groupNameNotInMap(){
        String s = "Sorry, the name is not available in our database \n";
        s += "Enter 1 search for the group again \n";
        s += "Enter any other number to go back";
        System.out.println(s);
    }

    /**
     * Message to let user know that the user is already in the group
     */
    public void alreadyInGroup(String groupName){
        System.out.println("Sorry you are already in the group - " + groupName + "\n " +
                "Enter 1 to enter a new group name \n " +
                "Enter any other number to go back");
    }

    /**
     * Message to let user know that they have successfully joined the group
     */
    public void joinSuccess(String groupName){
        System.out.println("Congrats, you joined group " + groupName);
    }

    /**
     * Line break
     */
    public void lines(){
        System.out.println("---------------------");
    }
}
