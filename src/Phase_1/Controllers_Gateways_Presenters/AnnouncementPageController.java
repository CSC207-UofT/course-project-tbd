package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class is the controller for our announcement page.
 * String groupId: Represents the the id of the current group.
 * GroupManager gm: The usecase class for managing groups.
 * String userId: The userId of the current user logged in.
 * UserManager um: The  usecase class for managing users.
 * AnnouncementPagePresenter: The presenter class for displaying information. (Will be changed once gui is implemented)
 */
public class AnnouncementPageController {
    private final String groupId;
    private final GroupManager gm;
    private final String userId;
    private final UserManager um;
    private final AnnouncementPagePresenter app;

    public AnnouncementPageController(String groupId, String userId, UserManager um, GroupManager gm){
        this.groupId = groupId;
        this.userId = userId;
        this.um = um;
        this.gm = gm;
        app = new AnnouncementPagePresenter(userId, um, gm, groupId);
    }

    /**
     * Runs the method. Asks user to either display the announcements or add an announcement (Option appears only
     * for the leader). Pressing any other button that 0 or 1 returns to the previous page.
     */
    public void run(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            boolean flag = true;
            String input;
            while(flag){
                app.instructions();
                input = reader.readLine();
                if (input.equals("1")) {
                    String s = "------------------------------- \n" + userId + ":";
//                    System.out.println(gm.getGroupById(groupId).getAnnouncementPage().toString());
                    System.out.println(s);
                    System.out.println(gm.getGroupById(groupId).getAnnouncementPage().toString());
                    System.out.println("-------------------------------");
                }
                else if (input.equals("2")) {
                    if(gm.checkIfLeader(gm.getGroupById(groupId).getgroupName(), um.getUserById(userId))){
                        // If the user is a leader and enters option 2 we ask for announcement
                        app.askAnnouncement();
                        String announcement = reader.readLine();
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        LocalDateTime current = LocalDateTime.now();
                        announcement = announcement + " - " + dtf.format(current);
                        gm.getGroupById(groupId).getAnnouncementPage().addAnnouncement(announcement);
                    }
                    else {
                        // If the user is not leader and enters option 2 we go back
                        flag = false;
                    }
                }
                else {
                    flag = false;
                }
            }
        } catch (IOException e){
            System.out.println("Please type a valid number");
        }

    }
}
