package Phase_1.Controllers_Gateways_Presenters;


import Phase_1.Entity.Category;
import Phase_1.Entity.NormalUser;
import Phase_1.UseCaseClass.CategoryManager;
import Phase_1.UseCaseClass.NotificationManager;
import Phase_1.UseCaseClass.TaskManager;
import Phase_1.UseCaseClass.UserManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CategoryPageController {
    private String userId;
    private TaskManager itm;
    private UserManager um;
    private NotificationManager nm;
    private CategoryManager cm;
    private CategoryPagePresenter cpp;
    private TaskPagePresenter tpp;
    private TaskPageController tpc;


    public CategoryPageController(String userId, UserManager um){
        this.userId = userId;
        this.tpp = new TaskPagePresenter();
        this.um = um;
        this.itm = new TaskManager();
        this.cpp = new CategoryPagePresenter();
        this.cm = new CategoryManager();
        this.tpc = new TaskPageController(userId, cm, nm);
    }

    public void run() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        cpp.displayCategory();
        String input = "";
        while (!input.equals("1")){
            // Go back to Options
            cpp.availableOptions();
            input = reader.readLine();
            if (input.equals("2")){
                // add new category
                addCategory(reader);
            }
            else if(input.equals("3")){
                // display categories
                cpp.displayCategory();
                System.out.println(um.displayCategories(um.getUserById(userId)));
                // chose category by name
                choseCategory(reader);
            }
        }
    }

    private void addCategory(BufferedReader reader) throws IOException {
        cpp.giveNewCategoryName();
        String CategoryTitle = reader.readLine();
        while(cm.getCategoryByName(um.getUserById(userId), CategoryTitle) != null){
            // while a category can be found in user with the same name as the above, prompt the user to try a new name
            cpp.CategoryNotUnique();
            CategoryTitle = reader.readLine();
        }
        // Add category with the input CategoryTitle
        um.addCategory(um.getUserById(userId), new Category(CategoryTitle));
        // Confirmation that category & task has been added
        cpp.CategoryAdd();
    }

    private void taskToCategory(BufferedReader reader) throws IOException{
        cpp.enterCategoryToAdd();
        String categoryToAdd = reader.readLine();
        Category category = cm.getCategoryByName(um.getUserById(userId), categoryToAdd);
        if (cm.checkCategory(um.getUserById(userId), category)){
            // If category is present in user, run task
            tpc.run(category);
        } else {
            cpp.CategoryNotPresent();
        }
    }

    private void choseCategory(BufferedReader reader) throws IOException{
        String input = "";
        while (!input.equals("1")){
            // Go back to Options
            cpp.availableCategoryOptions();
            input = reader.readLine();
            if (input.equals("2")){
                // chose Category by name
                taskToCategory(reader);
            }
        }
    }


}