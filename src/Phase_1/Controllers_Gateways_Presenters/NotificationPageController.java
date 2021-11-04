package Phase_1.Controllers_Gateways_Presenters;
import Phase_1.Entity.NormalUser;
import Phase_1.UseCaseClass.NotificationManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class NotificationPageController {
    private NormalUser user;
    NotificationManager notificationManager;

    private final NotificationPagePresenter npp = new NotificationPagePresenter();
    NotificationPageController(NotificationManager notificationManager){
        this.notificationManager = notificationManager;
    }

    public void run() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while (!input.equals("1")){
            showMailbox();
            npp.availableOptions();
            input = reader.readLine();
            if (input.equals("2")) {
                deleteNotification(reader);
            }
        }
    }

    public void showMailbox(){
        System.out.println(notificationManager.getMailbox());
    }


    public void deleteNotification(BufferedReader reader) throws IOException {}
}

