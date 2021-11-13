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
        String s = "Your options:\n";
        s += "1. Back\n";
        s += "2. Delete notification:\n";
        System.out.print(s);
    }

    /**
     * Display all the current notifications in the mailbox to the screen
     */
    public void displayNotifications(ArrayList<String> mailbox){
        System.out.println("My Notifications");
        System.out.println("The notifications are :");
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < mailbox.size(); i++){
            s.append("--------------------\n");
            s.append(i + 1).append(". ").append(mailbox.get(i)).append("\n");
        }
        System.out.println(s);
    }



}
