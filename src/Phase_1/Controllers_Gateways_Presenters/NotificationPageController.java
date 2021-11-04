package Phase_1.Controllers_Gateways_Presenters;
import Phase_1.Entity.NormalUser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class NotificationPageController {
    private NormalUser user;
    public ArrayList<String> mailbox = new ArrayList<>();

    private final NotificationPagePresenter npp = new NotificationPagePresenter();

    public void run() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (!input.equals("1")){
            npp.displayNotifications(mailbox);
            npp.availableOptions();
            input = reader.readLine();
            if (input.equals("2")) {
                deleteNotification(reader);
            }
        }
    }

    public void addNotification(String notification){
        mailbox.add(notification);
    }


    public void deleteNotification(BufferedReader reader) throws IOException {}
}

