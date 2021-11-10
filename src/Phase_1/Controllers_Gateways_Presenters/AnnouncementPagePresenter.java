package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;

public class AnnouncementPagePresenter {
    private String userId;
    private String groupId;
    private UserManager um;
    private GroupManager gm;

    public AnnouncementPagePresenter(String userId, UserManager um, GroupManager gm, String groupId){
        this.userId = userId;
        this.um = um;
        this.gm = gm;
        this.groupId = groupId;
    }

    public void instructions(){
        StringBuilder s = new StringBuilder();
        s.append("Type 1 to display all the messages in the Announcements.\n");
        if(gm.checkIfLeader(gm.getGroupById(groupId).getgroupName(), um.getUserById(userId))){
            s.append("Type 2 for adding an announcement leader!\n");
        }
        s.append("Type any other numbers to go back");
        System.out.println(s);
    }

    public void askAnnouncement(){
        System.out.println("Please enter an announcement");
    }

}
