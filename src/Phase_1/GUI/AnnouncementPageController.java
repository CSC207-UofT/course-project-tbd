package Phase_1.GUI;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.UserGroupManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class AnnouncementPageController {
    GroupManager gm;
    UserManager um;
    UserGroupManager ugm;
    String groupId;
    String userId;

    public AnnouncementPageController(GroupManager gm, UserManager um,
                                      UserGroupManager ugm, String userId, String groupId){
        this.gm = gm;
        this.um = um;
        this.ugm = ugm;
        this.userId = userId;
        this.groupId = groupId;
    }

    @FXML
    Button Refresh;

    @FXML
    ScrollPane AnnouncementContainer;

    @FXML
    Label Announcements;

    @FXML
    VBox enterAnnouncement;


    public void refreshAnnouncements(){
        Announcements.setText("");
        String announcements = gm.getGroupById(groupId).getAnnouncementPage().toString();
        Announcements.setText(announcements);
    }

}
