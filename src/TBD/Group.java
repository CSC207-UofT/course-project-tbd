package TBD;

import TBD.Category;

import java.util.ArrayList;

public class Group {

    public ArrayList<Category> categories = new ArrayList<Category>();

    /**
     * A method that takes the parameter (newCategory) and adds it to the ArrayList
     */
    public void addNewCategory(Category newCategory) {
        this.categories.add(newCategory);
    };

    /**
     * A method that takes the parameter (target) and removes it from the ArrayList
     */
    public void deleteCategory(Category target) {
        this.categories.remove(target);
    };
}
