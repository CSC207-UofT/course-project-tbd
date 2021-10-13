package Phase_0;

import java.util.ArrayList;


public class IndividualTask {
    public ArrayList<Category> categories = new ArrayList<>();


    /**
     * A method that takes the parameter (newCategory) and adds it to the ArrayList
     */
    public void addNewCategory(Category newCategory) {
        this.categories.add(newCategory);
    }

    ;

    /**
     * A method that takes the parameter (target) and removes it from the ArrayList
     */
    public void deleteCategory(Category target) {
        this.categories.remove(target);
    }

    ;

    /* @Overloaded method where tasks are added to an ALLTASKS page
     * and then create Categories. complete Tasks
     */
//    public void addTaskToCategory(Category cat, Task newtask) {
//        cat.add(newtask);
//
//    }
}