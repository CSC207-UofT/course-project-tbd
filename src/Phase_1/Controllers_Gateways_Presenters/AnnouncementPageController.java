package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.AnnouncementPage;
import Phase_1.Entity.Group;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is the controller for our announcement page.
 */
public class AnnouncementPageController {
    private String groupId;
    private GroupManager gm;
    private String userId;
    private UserManager um;
    private AnnouncementPagePresenter app;

    public AnnouncementPageController(String groupId, String userId, UserManager um, GroupManager gm){
        this.groupId = groupId;
        this.userId = userId;
        this.um = um;
        this.gm = gm;
        app = new AnnouncementPagePresenter(userId, um, gm, groupId);
    }

    public void run(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            boolean flag = true;
            String input;
            while(flag){
                app.instructions();
                input = reader.readLine();
                if (input.equals("1")) {
                    System.out.println(gm.getGroupById(groupId).getAnnouncementPage().toString());
                }
                else if (input.equals("2")) {
                    if(gm.checkIfLeader(gm.getGroupById(groupId).getgroupName(), um.getUserById(userId))){
                        // If the user is a leader and enters option 2 we ask for announcement
                        app.askAnnouncement();
                        String announcement = reader.readLine();
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
