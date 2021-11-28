package Phase_1.GUI;

import Phase_1.Controllers_Gateways_Presenters.GroupDataGateWay;
import Phase_1.Controllers_Gateways_Presenters.UserDataGateway;
import Phase_1.UseCaseClass.GroupManager;
import Phase_1.UseCaseClass.NotificationManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class NotificationPageController implements Initializable{

    NotificationManager notificationManager;

    @FXML
    public ListView<String> notificationListView;

    @FXML
    public Text notificationDetail;

    @FXML
    public Button deleteNotificationButton;

    @FXML
    public Button refreshButton;

    // for testing
    ArrayList<String> currentNotification = new ArrayList<>();
    HashMap<String, String> temp = new HashMap<>();
    //

    public void setNotificationManager(NotificationManager notificationManager){
        this.notificationManager = notificationManager;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // uncomment this
        /*ArrayList<String> currentNotification = notificationManager.getMailbox();*/

        // comment out this
        currentNotification.add("hello world");
        currentNotification.add("shit bro");
        // comment out this

        notificationListView.getItems().addAll(currentNotification);

        notificationListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                ObservableList<String> current = notificationListView.getSelectionModel().getSelectedItems();
                String currentString = current.toString().substring(1, current.toString().length() - 1);

                // for testing, comment out this
                temp.put("hello world", "yolo");
                temp.put("shit bro", "yeah bro");
                notificationDetail.setText(temp.get(currentString));
                notificationManager = new NotificationManager();

                // uncomment this
                /*notificationDetail.setText(notificationManager.getMailDetail().get(currentString));*/
            }
        });


    }

    public void addToMailbox(String message){
        notificationListView.getItems().add(0, message);
    }

    public void refreshNotification(){
        notificationListView.getItems().removeAll(currentNotification);
        notificationListView.getItems().addAll(currentNotification);
    }

    public void deleteNotification(MouseEvent mouseEvent) {
        ObservableList<String> current = notificationListView.getSelectionModel().getSelectedItems();
        String currentString = current.toString().substring(1, current.toString().length() - 1);

        // uncomment this
        /*notificationManager.getMailboxTaskName().remove(currentString);
        notificationManager.getMailDetail().remove(currentString);*/

        // comment out this
        currentNotification.remove(currentString);
        temp.remove(currentString);
        //

        notificationListView.getItems().remove(currentString);
    }
}
