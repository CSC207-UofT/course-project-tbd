package Phase_0;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CategoryPageController {
    private NormalUser user;
    private TaskPagePresenter tpp;
    private TaskManager itm;
    private UserManager um;
    private CategoryPagePresenter cpp;
    private CategoryManager cm;
    private TaskPageController tpc;
    private NotificationPageController npc;


    public CategoryPageController(NormalUser user, UserManager um){
        this.user = user;
        this.tpp = new TaskPagePresenter();
        this.um = um;
        this.itm = new TaskManager();
        this.cpp = new CategoryPagePresenter();
        this.cm = new CategoryManager();
        this.tpc = new TaskPageController(user, um, npc);
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
                System.out.println(um.displayCategories(user));
                // chose category by name
                choseCategory(reader);
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
    }

    private void taskToCategory(BufferedReader reader) throws IOException{
        cpp.enterCategoryToAdd();
        String categoryToAdd = reader.readLine();
        Category category = cm.getCategoryByName(user, categoryToAdd);
        if (cm.checkCategory(user, category)){
            // If category is present in user, run task
            tpc.run();
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



} }
