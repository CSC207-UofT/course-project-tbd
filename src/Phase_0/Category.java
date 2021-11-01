package Phase_0;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Category implements Iterable<Task>{
    private String categoryName;    // This is the name of the category/folder
    private ArrayList<Task> tasks;  // These are all the tasks contained in that category

    public Category (String name) {
        this.categoryName = name;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task t){
        // This method adds the task to the current category
        this.tasks.add(t);
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.categoryName).append("\n");
        for (Task t: tasks){
            s.append(t).append("\n");
        }
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
