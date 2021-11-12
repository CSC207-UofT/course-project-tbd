package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserManager;

/**
 * The presenter for printing information to the user about the announcement page.
 * Only leader is able to create announcements whereas the users can only see them.
 */
public class AnnouncementPagePresenter {
    private final String userId;
    private final String groupId;
    private final UserManager um;
    private final GroupManager gm;

    public AnnouncementPagePresenter(String userId, UserManager um, GroupManager gm, String groupId){
        this.userId = userId;
        this.um = um;
        this.gm = gm;
        this.groupId = groupId;
    }

    /**
     * The instructions for the user to input into the terminal.
     */
    public void instructions(){
        StringBuilder s = new StringBuilder();
        s.append("Type 1 to display all the messages in the Announcements.\n");
        if(gm.checkIfLeader(gm.getGroupById(groupId).getgroupName(), um.getUserById(userId))){
            s.append("Type 2 for adding an announcement leader!\n");
        }
        s.append("Type any other numbers to go back");
        System.out.println(s);
    }

    /**
     * Prompts leader to create an announcement
     */
    public void askAnnouncement(){
        System.out.println("Please enter an announcement");
    }

}
