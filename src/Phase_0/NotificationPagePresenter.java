package Phase_0;

import java.util.ArrayList;

public class NotificationPagePresenter {

    public void availableOptions(){
        System.out.println("--------------------");
        System.out.print("Your options:\n" +
                "1. Back\n" +
                "2. Delete notification:\n");
    }

//    public void decisionAsk(){
//        System.out.println("I choose: ");
//    }

    public void displayNotifications(ArrayList<String> mailbox){
        System.out.println("My Notifications");
        System.out.println("The notifications are :");
        System.out.println(mailbox);
    }



}
