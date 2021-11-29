package Phase_1.GUI;

import Phase_1.UseCaseClass.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AnnouncementPageController {
    GroupManager gm;
    UserManager um;
    String groupId;
    String userId;

    public void setAll(UserManager um, GroupManager gm, String groupId, String userId){
        this.um = um;
        this.gm = gm;
        this.groupId = groupId;
        this.userId = userId;
    }

    @FXML
    VBox leaderControls;

    @FXML
    Button Refresh;

    @FXML
    ScrollPane AnnouncementContainer;

    @FXML
    Label Announcements;

    @FXML
    Button Back;

    @FXML
    Button SendAnnouncement;

    @FXML
    TextField announcementInput;

    public void isLeader(){
        if(gm.checkIfLeader(gm.getGroupById(groupId).getgroupName(), um.getUserById(userId))){
            leaderControls.setVisible(true);

        }
    }

    public void refreshAnnouncements(){
        isLeader();
        Announcements.setText("");
        String announcements = gm.getGroupById(groupId).getAnnouncementPage().toString();
        Announcements.setText(announcements);
    }

    public void goBack() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupContentController.fxml"));
        Parent root = loader.load();
        GroupContentController gcc = loader.getController();
        TaskManager tm = new TaskManager();
        gcc.setAll(um, gm, tm, userId, groupId);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    public void addAnnouncement(){
        String input = announcementInput.getText();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime current = LocalDateTime.now();
        input = input + " - " + dtf.format(current);
        gm.getGroupById(groupId).getAnnouncementPage().addAnnouncement(input);
        announcementInput.clear();
    }
}
