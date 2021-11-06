package Phase_1.Controllers_Gateways_Presenters;

public class GroupChatPresenter {
    public void instructions() {
        System.out.println("Type 1 to display all the messages in the group chat \n" +
                "Type 2 to enter a message \n" +
                "Type 0 to exit");
    }
    public void askMessage() {
        System.out.println("Please enter a message");
    }
}
