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
    NotificationManager nm;

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
    Button Refresh;

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

    public void isLeader(){
        if(gm.checkIfLeader(gm.getGroupById(groupId).getgroupName(), um.getUserById(userId))){
            leaderControls.setVisible(true);

        }
    }

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
    }
}
