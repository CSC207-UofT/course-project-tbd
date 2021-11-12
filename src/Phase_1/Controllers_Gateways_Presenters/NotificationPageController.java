package Phase_1.Controllers_Gateways_Presenters;
import Phase_1.UseCaseClass.NotificationManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * This NotificationPageController class is made for controlling the notification
 * page according to the user input.
 *
 * @author  Owen Huang
 * @author  Sanjana Girish
 */
public class NotificationPageController {

    /**
     * Used to start alarm for task with a due date, and send notification to user mailbox
     */
    private final NotificationManager notificationManager;

    /**
     * Notification Page presenter contains all the print statements associated with the task page
     */
    private final NotificationPagePresenter npp = new NotificationPagePresenter();

    /**
     * Constructs the Notification Page for display
     *
     * @param  notificationManager is a NotificationManager object responsible for managing notifications
     */
    NotificationPageController(NotificationManager notificationManager){
        this.notificationManager = notificationManager;
    }

    /**
     * Starts the notification page for a user, display to the terminal for interaction with the user
     *
     * @throws IOException {@inheritDoc}
     */
    public void run() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (!input.equals("1")){     // 1 means go back
            npp.displayNotifications(notificationManager.getMailbox());     // show current notifications
            npp.availableOptions();
            input = reader.readLine();
            if (input.equals("2")) {        // 2 means delete notification
                deleteNotification(reader);
            }
        }
    }

    /**
     * Deletes a notification in mailbox
     * @param  reader is a BufferedReader prompting for user for the notification they want to delete
     */
    public void deleteNotification(BufferedReader reader) {
        System.out.println("Please enter which notification you want to delete by its number:");
        try{
            String input = reader.readLine();
            notificationManager.getMailbox().remove(Integer.parseInt(input) - 1);
            System.out.println("Notification deleted");
        } catch (Exception e) {
            System.out.println("Your input is invalid");
        }
    }
}

