package Phase_1_ignore_this.Controllers_Gateways_Presenters;

/**
 * The presenter for printing information to the user about the category page.
 */
public class CategoryPagePresenter {

    /**
     * Options for available options
     */
    public void availableOptions(){
        System.out.println("--------------------");
        System.out.print("Your options:\n" +
                "1. Back\n" +
                "2. Add Category:\n" +
                "3. View Categories \n" +
                "Your answer here: ");
    }

    /**
     * Options for available categories
     */
    public void availableCategoryOptions(){
        System.out.println("--------------------");
        System.out.print("Your options:\n" +
                "1. Back\n" +
                "2. Choose Category by Name:\n" +
                "Your answer here: ");
    }

    /**
     * Prompts user to give new category name
     */
    public void giveNewCategoryName(){
        System.out.println("--------------------");
        System.out.print("Enter Category Title:\n");
    }

    /**
     * Informing user when prompted
     */
    public void CategoryAdd(){
        System.out.println("Your Category has been created and added");
    }

    public void enterCategoryToAdd(){
        System.out.println("Enter name of category to add task to:");
    }

    public void CategoryNotPresent(){
        System.out.println("Sorry, the Category is not there in our database");
    }

    public void displayCategory(){
        System.out.println("The Categories are :");
    }

    public void CategoryNotUnique(){
        System.out.println("The category already exists, chose another name");
    }

}