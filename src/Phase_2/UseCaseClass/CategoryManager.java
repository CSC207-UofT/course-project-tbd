package Phase_2.UseCaseClass;

import Phase_2.Entity.*;

public class CategoryManager {
    /**
     * This CategoryManager is the use case that is responsible for accessing  attributes and methods
     * in Category.
     */

    public Category createCategory(String description){
        return new Category(description);
    }

    /**
     * This method checks the user had this category object.
     * @param user the object user.
     * @param c the object category.
     * @return whether the user has category object.
     */

    public boolean checkCategory(User user, Category c) throws NullPointerException {
        return user.getMyCategories().contains(c);
    }
    /**
     * This method checks  with the name of the category with the given user.
     * @param user the object user
     * @param categoryName the string representation of the object category.
     * @return object category if the user has that category.
     */

    public Category getCategoryByName(User user, String categoryName) {
        for (Category c: user.getMyCategories()){
            if (this.checkCategoryByName(c, categoryName)){
                return c;
            }

        }
        return null;
    }

    /**
     * This method checks the name of the category object, with the name of the category.
     * @param category the object category
     * @param categoryName the string representation of the object category.
     * @return whether the name of the category matches the string category.
     */


    public boolean checkCategoryByName(Category category, String categoryName) {
        return category.getCategoryName().equals(categoryName);
    }

    /**
     * This method checks whether the category is in the given group.
     * @param categoryName the string representation of the object category.
     * @param groupById the object group.
     * @return true if the category is in the group.
     */
    public Category getCategoryByGroup(String categoryName, Group groupById) {
        for (Category c: groupById.getCategories()){
            if (this.checkCategoryByName(c, categoryName)){
                return c;
            }
        }
        return null;
    }
}
