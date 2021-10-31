package Phase_0;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class NotificationPageController {
    private NormalUser user;

    private final NotificationPagePresenter npp = new NotificationPagePresenter();

    public void run() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        npp.displayNotifications();
        String input = "";
        while (!input.equals("1")){
            npp.availableOptions();
            input = reader.readLine();
            if (input.equals("2")) {
                deleteNotification(reader);
            }
        }
    }


    public void deleteNotification(BufferedReader reader) throws IOException {}
}

