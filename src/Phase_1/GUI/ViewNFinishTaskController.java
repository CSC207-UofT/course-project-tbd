package Phase_1.GUI;

import Phase_1.Entity.Category;
import Phase_1.Entity.Task;
import Phase_1.Entity.TaskWithDueDate;
import Phase_1.UseCaseClass.TaskManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.time.DateTimeException;
import java.util.*;

public class ViewNFinishTaskController implements Initializable {
    TaskManager tm;
    @FXML
    Hyperlink back;
    @FXML
    ListView<String> list;
    @FXML
    TextField name;
    @FXML
    Label Status;


    public void setTm(TaskManager tm) {this.tm = tm;}

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

    public void finishtask(Category category) throws IOException {
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






    public void backPushed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TaskPage.fxml"));
        Parent root = loader.load();
        TaskPageController tpc1 = loader.getController();
        tpc1.setTm(tm);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
