package Phase_1.GUI;

import Phase_1.UseCaseClass.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ViewFolderController {
    String userId;
    String groupId;
    UserManager um;
    TaskManager tm;
    GroupManager gm;
    NotificationManager nm;

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    public void setUm(UserManager um) {
        this.um = um;
    }
    public void setTm(TaskManager tm) {
        this.tm = tm;
    }
    public void setGm(GroupManager gm) {
        this.gm = gm;
    }
    public void setNm(NotificationManager nm) {
        this.nm = nm;
    }

    @FXML
    VBox GroupsPane;

    @FXML
    Button BackButton;

    /**
     * This method creates buttons which when clicked take you to the different pages.
     */
    public void createFolderButton(){
        GroupsPane.getChildren().clear(); // Removes all the elements of the pane
        for(String categoryName : gm.getGroupById(groupId).getCategoryNames()){
            // Creates and adds button for each group to the pane
            Button button = new Button();
            button.setText(categoryName);
            button.setOnAction(actionEvent -> {
                try {
                    goToCategory(categoryName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            button.setPrefSize(371.0, 25.0);
            GroupsPane.getChildren().add(button);
        }
    }

    private void goToCategory(String categoryName) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupTaskPresenter.fxml"));
        Parent root = loader.load();
        GroupTaskController gtc  = loader.getController();
        gtc.setGroupId(groupId);
        gtc.setUserId(userId);
        gtc.setCategoryName(categoryName);
        gtc.setGm(gm);
        gtc.setUm(um);
        gtc.setTm(tm);
        gtc.setNm(nm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    public void goBack() throws IOException {
        // Go back to previous page: GroupPageController
        GroupsPane.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GroupContentController.fxml"));
        Parent root = loader.load();
        GroupContentController gcc = loader.getController();
        TaskManager tm = new TaskManager();
        gcc.setAll(um, gm, tm, userId, groupId, nm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }
}
