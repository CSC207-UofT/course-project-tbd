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

/**
 * This CategoryPageController class is made for controlling the category
 * page according to the user input. This CategoryPageController is
 * specialized to one user only
 *
 * @author  Sanjana Girish
 * @author  placeholder
 */
public class CategoryPageController {

    /**
     * A user Id which is unique to a user
     */
    private String userId;

    /**
     * Use case for all operations we are performing on Tasks (e.g. add task, delete task)
     */
    private TaskManager itm;

    /**
     * Used to access and modify user information
     */
    private UserManager um;

    /**
     * Used to start alarm for task with a due date, and send notification to user mailbox
     */
    private NotificationManager nm;

    /**
     * Used to access and modify category information
     */
    private CategoryManager cm;

    /**
     * Category Page presenter contains all the print statements associated with the category page
     */
    private CategoryPagePresenter cpp;

    /**
     * Task Page presenter contains all the print statements associated with the task page
     */
    private TaskPagePresenter tpp;

    /**
     * Task Page controller made for controlling the task page according to the user input
     */
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

    /**
     * Starts the category page for a particular user, display to the terminal for interaction with the user
     * @throws IOException {@inheritDoc}
     */
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

    /**
     * When user chooses 2, this helper method prompt the user for category name. Names of categories are unique.
     * @param  reader a BufferedReader for input
     * @throws IOException {@inheritDoc}
     */
    private void addCategory(BufferedReader reader) throws IOException {
        cpp.giveNewCategoryName();
        String CategoryTitle = reader.readLine();
        while(cm.getCategoryByName(um.getUserById(userId), CategoryTitle) != null){
            // while a category can be found in user with the same name as the above, prompt the user to try a new name
            cpp.CategoryNotUnique();
            CategoryTitle = reader.readLine();
        }
        // Add category with the input CategoryTitle
        um.addCategory(um.getUserById(userId), cm.createCategory(CategoryTitle));
        // Confirmation that category & task has been added
        cpp.CategoryAdd();
    }

    /**
     * When user chooses 2 from choseCategory, this helper method prompt the user for entering a category page.
     * @param  reader a BufferedReader for input
     * @throws IOException {@inheritDoc}
     */
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

    /**
     * When user chooses 3, this helper method prompt the user for entering a category page.
     * @param  reader a BufferedReader for input
     * @throws IOException {@inheritDoc}
     */
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