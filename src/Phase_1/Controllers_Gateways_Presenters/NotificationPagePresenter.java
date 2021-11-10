package Phase_1.Controllers_Gateways_Presenters;

import java.util.ArrayList;

/**
 * This NotificationPagePresenter is a class that manages all the system out print
 * statements, to make out code concise and neat to read.
 *
 * @author  Owen Huang
 */
public class NotificationPagePresenter {

    /**
     * Shows all the available options users can choose in the program
     */
    public void availableOptions(){
        System.out.println("--------------------");
        System.out.print("Your options:\n" +
                "1. Back\n" +
                "2. Delete notification:\n");
    }

    /**
     * Display all the current notifications in the mailbox to the screen
     */
    public void displayNotifications(ArrayList<String> mailbox){
        System.out.println("My Notifications");
        System.out.println("The notifications are :");
        System.out.println(mailbox);
    }



}
