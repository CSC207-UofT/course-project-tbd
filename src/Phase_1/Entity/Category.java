package Phase_1.Entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class creates a category, with its title, list of tasks in the category
 */

public class Category implements Iterable<Task>{
    private String categoryName;    // This is the name of the category/folder
    public ArrayList<Task> tasks;  // These are all the tasks contained in that category

    public Category (String name) {
        this.categoryName = name;
        this.tasks = new ArrayList<>();
    }


    /**
     * This method adds the task to the current category
     * @param t, a task, to add to this category
     */
    public void addTask(Task t){
        this.tasks.add(t);
    }


    /**
     * @return This method returns the category name.
     */
    public String getCategoryName() {
        return this.categoryName;
    }


    /**
     * @return This method returns the tasks in this category.
     */
    public List<Task> getTasks() {
        return this.tasks;
    }


    /**
     * @return This method represents the title of the category in the form of string.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.categoryName).append("\n");
        s.delete(s.length()-1,s.length());
        return s.toString();
    }


    @Override
    public Iterator<Task> iterator() {
        return new CategoryIterator();
    }

    private class CategoryIterator implements Iterator<Task> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < tasks.size();
        }

        @Override
        public Task next() {
            Task s;
            try {
                s = tasks.get(current);
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
            current += 1;
            return s;
        }

        @Override
        public void remove() {

            tasks.remove(current - 1);

            // In case we do not want to implement remove we write the following body.
            //throw new UnsupportedOperationException("Not supported.");
        }
    }
}
