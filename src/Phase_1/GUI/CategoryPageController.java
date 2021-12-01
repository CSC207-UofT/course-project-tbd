package Phase_1.GUI;

import Phase_1.UseCaseClass.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.io.IOException;


public class CategoryPageController {
    CategoryManager cm;
    UserManager um;
    String userId;
    NotificationManager nm;

    @FXML
    VBox CategoryPane;
    @FXML
    Button AddCategory;
    @FXML
    Button BackButton;
    @FXML
    TextField NewCategoryName;
    @FXML
    Label WrongNewCategory;



    public void setUm(UserManager um) {
        this.um = um;
    }
    public void setUserId(String userId){this.userId = userId;}
    public void setCm(CategoryManager cm){this.cm = cm;}
    public void setNm(NotificationManager nm){
        this.nm = nm;
    }

    public void goBack() throws IOException {
        // Go back to previous page: UserPageController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserPageController.fxml"));
        Parent root = loader.load();
        UserPageController upc = loader.getController();
        upc.setUm(um);
        upc.setUserName(userId);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }

    public void createCategoryButton(){
        if (NewCategoryName.getText().isEmpty()){
            WrongNewCategory.setText("Please Enter valid Category Name");
        } else if (cm.getCategoryByName(um.getUserById(userId), NewCategoryName.getText()) != null){
            // if a category can be found in user with the same name as the above, prompt the user to try a new name
            WrongNewCategory.setText("The category already exists, chose another category name");
        } else {
            // Add category with the input CategoryTitle
            um.addCategory(um.getUserById(userId), cm.createCategory(NewCategoryName.getText()));
            loadCategoryPane();
        }
    }

    public void loadCategoryPane(){
        WrongNewCategory.setText("");
        CategoryPane.getChildren().clear(); // Removes all the elements of the pane
        for (String CategoryId : um.displayCategories(um.getUserById(userId)).split("\n")) {
            // Creates and adds button for each group to the pane
            Button button = new Button();
            button.setText(CategoryId);
            button.setOnAction(actionEvent -> {
                try {
                    goToTask(CategoryId);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            button.setPrefSize(370.0, 26.0);
            CategoryPane.getChildren().add(button);
        }
    }

    public void goToTask(String CategoryId) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TaskPage.fxml"));
        Parent root = loader.load();
        TaskPageController tpc = loader.getController();
        tpc.setNm(nm);
        tpc.setUm(um);
        tpc.setTm(new TaskManager());
        tpc.setC(cm.getCategoryByName(um.getUserById(userId), CategoryId));
        tpc.setUserId(userId);
        Scene scene = new Scene(root);
        GUImain guiMain = new GUImain();
        guiMain.addScene(scene);
    }



}
