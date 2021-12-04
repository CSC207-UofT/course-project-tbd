package Phase_1.GUI;

import Phase_1.Entity.Category;
import Phase_1.Entity.Task;
import Phase_1.Entity.TaskWithDueDate;
import Phase_1.UseCaseClass.NotificationManager;
import Phase_1.UseCaseClass.TaskManager;
import Phase_1.UseCaseClass.UserManager;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.time.DateTimeException;
import java.util.*;

public class ViewNFinishTaskController implements Initializable {
    TaskManager tm;
    UserManager um;
    Category category;

    Scene previousScene;

    @FXML
    public TextArea taskDetailField;

    @FXML
    Hyperlink back;

    @FXML
    ListView<String> taskListView;

    @FXML
    TextField name;

    @FXML
    Label Status;

    @FXML
    Button finishTask;


    public void setTm(TaskManager tm) {this.tm = tm;}
    public void setUm(UserManager um) {this.um = um;}
    public void setCategory(Category category){
        this.category = category;
    }
    public void setPreviousScene(Scene scene){
        this.previousScene = scene;
    }

    //    public ListView<String> getList() {
//        List<String> newlist = new ArrayList<>();
//        for(Task t: tm.displayTask()){
//            newlist.add(t.toString());
//        }
//        ArrayAdapter<String> itemsAdapter =
//                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
//        return newlist;
//
//    }

    ViewNFinishTaskController(Category category){
        this.category = category;
    }


    public void finishtaskhelper(Category category) throws IOException {
        GUImain guiMain = new GUImain();
        String title = name.getText();
        Task task = tm.getTaskByName(category, title);
        Status.setText("");
        if(tm.checkTask(category, task)){  // If task is present in user, mark it finished
            tm.completeTask(task);
            Status.setText("Task finished");
        }
        else{Status.setText("Task not Present");
        }

    }

    public void finishTask() throws IOException {
        String title = name.getText();
        Task task = tm.getTaskByName(category, title);
        Status.setText("");
        if(tm.checkTask(category, task)){  // If task is present in user, mark it finished
            tm.completeTask(task);
            Status.setText("Task finished");
        }
        else{Status.setText("Task not Present");
        }

    }


    public void backPushed() throws IOException {
        Stage stage = (Stage) finishTask.getScene().getWindow();
        stage.setScene(previousScene);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> taskNames = new ArrayList<>();
        HashMap<String, String> taskDetail = new HashMap<>();


        for (Task t : category.getTasks()) {
            taskNames.add(t.getTaskName());
            taskDetail.put(t.getTaskName(), t.toString());
        }


            /*// for testing
            taskNames.add("1");
            taskNames.add("2");
            taskNames.add("3");
            taskDetail.put("1", "hello");
            taskDetail.put("2", "world");
            taskDetail.put("3", "I'm coming");
            //*/

        taskListView.getItems().addAll(taskNames);


        taskListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                ObservableList<String> current = taskListView.getSelectionModel().getSelectedItems();
                String currentString = current.toString().substring(1, current.toString().length() - 1);

                taskDetailField.setText(taskDetail.get(currentString));
            }
        });
    }
}