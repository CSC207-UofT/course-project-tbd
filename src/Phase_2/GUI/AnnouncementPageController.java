package Phase_2.GUI;

import Phase_2.UseCaseClass.*;
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
    NotificationManager nm;

    /**
     * A setter to set all the required parameters.
     * @param um : Usermanager
     * @param gm : Group Manager
     * @param groupId : GroupId of the current logged in group
     * @param userId : UserId of the user currently logged in
     * @param nm : Notification manager
     */
    public void setAll(UserManager um, GroupManager gm, String groupId, String userId, NotificationManager nm){
        this.um = um;
        this.gm = gm;
        this.groupId = groupId;
        this.userId = userId;
        this.nm = nm;
    }

    @FXML
    VBox leaderControls;

    @FXML
    Label Announcements;

    @FXML
    Button Back;

    @FXML
    Button SendAnnouncement;

    @FXML
    TextField announcementInput;

    @FXML
    VBox GroupsPane;

    /**
     * This method checks whether the current logged in user is a leader and if so, enables the leaderControls.
     */
    public void isLeader(){
        if(gm.checkIfLeader(gm.getGroupById(groupId).getgroupName(), um.getUserById(userId))){
            leaderControls.setVisible(true);

        }
    }

    /**
     * Clicking this refreshes the announcement page. Refresh each time a new announcement is added.
     */
    public void refreshAnnouncements(){
        isLeader();
        GroupsPane.getChildren().clear();
        Label lbl = new Label();
        lbl.setText("");
        String announcements = gm.getGroupById(groupId).getAnnouncementPage().toString();
        lbl.setText(announcements);
        GroupsPane.setPrefSize(lbl.getPrefWidth(), lbl.getPrefHeight());
        GroupsPane.getChildren().add(lbl);
    }

    /**
     * Goes back to the previous page when button is pressed
     */
    public void goBack() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupContentController.fxml"));
        Parent root = loader.load();
        GroupContentController gcc = loader.getController();
        TaskManager tm = new TaskManager();
        gcc.setAll(um, gm, tm, userId, groupId, nm);
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
        refreshAnnouncements();
    }
}
