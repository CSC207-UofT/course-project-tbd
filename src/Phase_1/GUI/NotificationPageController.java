package Phase_1.GUI;

import Phase_1.UseCaseClass.NotificationManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class NotificationPageController implements Initializable{

    NotificationManager notificationManager;

    Scene previousScene;

    @FXML
    public ListView<String> notificationListView;

    @FXML
    public TextArea notificationDetail;

    @FXML
    public Button deleteNotificationButton;

    @FXML
    public Button refreshButton;

    @FXML
    public Button backButton;


    // for testing
    ArrayList<String> currentNotification = new ArrayList<>();
    HashMap<String, String> temp = new HashMap<>();
    //

    NotificationPageController(NotificationManager notificationManager){
        this.notificationManager = notificationManager;
    }

    public void setPreviousScene(Scene previousScene){
        this.previousScene = previousScene;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // uncomment this
        ArrayList<String> currentNotification = notificationManager.getMailboxTaskName();

        // comment out this
        /*currentNotification.add("hello world");
        currentNotification.add("shit bro");*/
        // comment out this

        notificationListView.getItems().addAll(currentNotification);

        notificationListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                ObservableList<String> current = notificationListView.getSelectionModel().getSelectedItems();
                String currentString = current.toString().substring(1, current.toString().length() - 1);

                // for testing, comment out this
                /*temp.put("hello world", "yolo");
                temp.put("shit bro", "yeah bro");
                notificationDetail.setText(temp.get(currentString));
                notificationManager = new NotificationManager();*/
                //

                // uncomment this
                notificationDetail.setText(notificationManager.getMailDetail().get(currentString));
            }
        });


    }

    public void addToMailbox(String message){
        notificationListView.getItems().add(0, message);
    }

    public void refreshNotification(){
        notificationListView.getItems().removeAll(notificationManager.getMailboxTaskName());
        notificationListView.getItems().addAll(notificationManager.getMailboxTaskName());
    }

    public void deleteNotification(MouseEvent mouseEvent) throws Exception{

        // a new window for warning, before the user can delete a notification
        Stage warningWindow = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WarningWindow.fxml"));
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

            // uncomment this
            notificationManager.getMailboxTaskName().remove(currentString);
            notificationManager.getMailDetail().remove(currentString);

            // comment out this
            /*currentNotification.remove(currentString);
            temp.remove(currentString);*/
            //

            notificationListView.getItems().remove(currentString);
        }

    }

    public void backPushed() throws IOException {
        Stage stage = (Stage) refreshButton.getScene().getWindow();
        stage.setScene(previousScene);
    }
}
