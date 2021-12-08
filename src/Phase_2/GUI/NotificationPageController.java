package Phase_2.GUI;

import Phase_2.UseCaseClass.NotificationManager;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This is the controller for the Notification Page fxml. This is where user can view their notifications. Notifications
 * such as the alarm clock message is sent and displayed here. User can choose to view the notifications, or delete a
 * notification if they wish to do so.
 *
 * @author  Owen Huang
 */
public class NotificationPageController implements Initializable{

    /**
     * Used to start alarm for task with a due date, and send notification to user mailbox
     */
    NotificationManager notificationManager;

    /**
     * This remembers the previous scene before ViewNFinishTask Page FXML, which should be the task page
     */
    Scene previousScene;

    /**
     * ListView is used to display all notification in a list fashion in scene builder
     */
    @FXML
    public ListView<String> notificationListView;

    /**
     * used to display the notification detail
     */
    @FXML
    public TextArea notificationDetail;

    /**
     * used to delete a notification
     */
    @FXML
    public Button deleteNotificationButton;

    /**
     * click button to refresh for new notifications
     */
    @FXML
    public Button refreshButton;

    /**
     * goes back to the previous page
     */
    @FXML
    public Button backButton;

    /**
     * constructor is used to load in data used in initialized method
     *
     * @param notificationManager manages the notifications
     */
    NotificationPageController(NotificationManager notificationManager){
        this.notificationManager = notificationManager;
    }

    /**
     * Setter methods to set the previous page
     */
    public void setPreviousScene(Scene previousScene){
        this.previousScene = previousScene;
    }

    /**
     * This initializes the page when user enters the page, it should display all the notifications if there is any
     *
     * @param url inherited from the interface
     * @param resourceBundle inherited from the interface
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> currentNotification = notificationManager.getMailboxTaskName();

        // updates the list view with all current notifications
        notificationListView.getItems().addAll(currentNotification);

        // if user clicks on an item in list view, update the TextArea field to display the notification detail
        notificationListView.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            ObservableList<String> current = notificationListView.getSelectionModel().getSelectedItems();
            String currentString = current.toString().substring(1, current.toString().length() - 1);

            notificationDetail.setText(notificationManager.getMailDetail().get(currentString));
        });


    }

    /**
     * Refreshes the notifications page
     */
    public void refreshNotification(){
        notificationListView.getItems().removeAll(notificationManager.getMailboxTaskName());
        notificationListView.getItems().addAll(notificationManager.getMailboxTaskName());
    }

    /**
     * Deletes the give notification
     */
    public void deleteNotification() throws Exception{

        // a new window for warning, before the user can delete a notification
        Stage warningWindow = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxmlFiles/WarningWindow.fxml"));
        Parent root = loader.load();
        warningWindow.setResizable(false);
        warningWindow.setTitle("WARNING");
        warningWindow.setScene(new Scene(root, 250, 150));

        WarningWindowController warningWindowController = loader.getController();

        warningWindow.initModality(Modality.APPLICATION_MODAL);
        warningWindow.showAndWait();

        // if the button clicked was the yes button, proceed to delete
        if(warningWindowController.getYesButtonClicked()){
            ObservableList<String> current = notificationListView.getSelectionModel().getSelectedItems();
            String currentString = current.toString().substring(1, current.toString().length() - 1);

            notificationManager.getMailboxTaskName().remove(currentString);
            notificationManager.getMailDetail().remove(currentString);

            notificationListView.getItems().remove(currentString);
        }

    }

    /**
     * Go back to previous page
     */
    public void backPushed() throws IOException {
        Stage stage = (Stage) refreshButton.getScene().getWindow();
        stage.setScene(previousScene);
    }
}
