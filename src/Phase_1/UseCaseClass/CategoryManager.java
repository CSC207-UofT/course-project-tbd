package Phase_1.UseCaseClass;

import Phase_1.Entity.*;

public class CategoryManager {

    public Category createCategory(String description){
        return new Category(description);
    }

    public boolean checkCategory(User user, Category c) throws NullPointerException {
        return user.getMyCategories().contains(c);
    }

    public Category getCategoryByName(User user, String categoryName) {
        for (Category c: user.getMyCategories()){
            if (this.checkCategoryByName(c, categoryName)){
                return c;
            }

        }
        return null;
    }

    public boolean checkCategoryByName(Category category, String categoryName) {
        return category.getCategoryName().equals(categoryName);
    }

    public Category getCategoryByGroup(String categoryName, Group groupById) {
        for (Category c: groupById.getCategories()){
            if (this.checkCategoryByName(c, categoryName)){
                return c;
            }

        }
        return null;
    }
}
