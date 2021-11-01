package Phase_0;

public class CategoryManager {

    public boolean checkCategory(NormalUser user, Category c) {
        return user.getMyCategories().contains(c);
    }

    public Category getCategoryByName(NormalUser user, String categoryName) {
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
