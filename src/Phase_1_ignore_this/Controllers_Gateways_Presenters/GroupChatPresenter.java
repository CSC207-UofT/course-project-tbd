package Phase_1_ignore_this.Controllers_Gateways_Presenters;

/**
 * Presenter class for class GroupChat
 */

public class GroupChatPresenter {

    /**
     * Instructions for group chat page
     */
    public void instructions() {
        System.out.println("Type 1 to display all the messages in the group chat \n" +
                "Type 2 to enter a message \n" +
                "Type 0 to exit");
    }

    /**
     * Message to let user know that they can input message
     */
    public void askMessage() {
        System.out.println("Please enter a message");
    }
}
