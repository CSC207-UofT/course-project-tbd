package Phase_0;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CategoryPageController {
    private NormalUser user;
    private TaskPagePresenter tpp;
    private TaskManager itm;
    private UserManager um;
    private CategoryPagePresenter cpp;
    private CategoryManager cm;
    private TaskPageController tpc;


    public CategoryPageController(NormalUser user, UserManager um){
        this.user = user;
        this.tpp = new TaskPagePresenter();
        this.um = um;
        this.itm = new TaskManager();
        this.cpp = new CategoryPagePresenter();
        this.cm = new CategoryManager();

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
                // Add to existing Category
                cpp.availableOptions();
            }
            else if(input.equals("4")){
                // display categories
                cpp.displayCategory();
                System.out.println(um.displayCategories(user));
            }
        }
    }

    private void addCategory(BufferedReader reader) throws IOException {
        cpp.giveNewCategoryName();
        String CategoryTitle = reader.readLine();

        // Add category
        Category category = new Category(CategoryTitle);
        um.addCategory(user, category);
        // Add task to category
        // category.addTask();
        // Confirmation that category & task has been added
        cpp.CategoryAdd();
        tpp.taskAdd();
    }

    private void taskToCategory(BufferedReader reader) throws IOException{
        cpp.enterCategoryToAdd();
        String categoryToAdd = reader.readLine();
        Category category = cm.getCategoryByName(user, categoryToAdd);
        if (cm.checkCategory(user, category)){
            // Add task to category
            tpp.taskAdd();
        }
    }



}
