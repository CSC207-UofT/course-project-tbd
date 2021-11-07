package Phase_1.Controllers_Gateways_Presenters;

public class CategoryPagePresenter {

    public CategoryPagePresenter(){
    }


    public void availableOptions(){
        System.out.println("--------------------");
        System.out.print("Your options:\n" +
                "1. Back\n" +
                "2. Add Category:\n" +
                "3. View Categories \n" +
                "Your answer here: ");
    }

    public void availableCategoryOptions(){
        System.out.println("--------------------");
        System.out.print("Your options:\n" +
                "1. Back\n" +
                "2. Choose Category by Name:\n" +
                "Your answer here: ");
    }

    public void giveNewCategoryName(){
        System.out.println("--------------------");
        System.out.print("Enter Category Title:\n");
    }

    public void giveCategoryDetail(){
        System.out.println("--------------------");
        System.out.println("Enter Category Detail:");
    }

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