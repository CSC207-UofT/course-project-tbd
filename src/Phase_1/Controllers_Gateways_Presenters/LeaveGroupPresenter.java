package Phase_1.Controllers_Gateways_Presenters;

/**
 * LeaveGroup presenter for class LeaveGroup
 */
public class LeaveGroupPresenter {

    /**
     * Message prompting user to give group name to leave
     */
    public void askForName(){
        System.out.println("Please type in the name of the group you want to leave");
    }

    /**
     * Message telling the user that no group of this name exist
     */
    public void noGroupFound(){
        System.out.println("Sorry, the group name you type in is not found");
    }

    /**
     * Message telling user that they have successfully left the group they want to leave
     */
    public void leaveSuccess(String name){
        System.out.println("You left group " + name + " successfully");
    }

    /**
     * Telling user that they will be redirected to group page
     */
    public void goBack() {
        System.out.println("you will be redirected to Group Page");
    }

    /**
     * Line break
     */
    public void lines(){
        System.out.println("---------------------");
    }
}
