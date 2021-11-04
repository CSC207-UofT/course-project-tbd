package Phase_1.UseCaseClass;

import Phase_1.Entity.Category;
import Phase_1.Entity.User;

public class CategoryManager {

    public boolean checkCategory(User user, Category c) {
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
}
