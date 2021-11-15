package Phase_1Test;

import Phase_1.Entity.*;
import Phase_1.UseCaseClass.TaskManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskManagerTest {
    Task t;
    TaskManager tm;

    @Before
    public void setup(){
        t = new Task("Test", "Do it");
        tm = new TaskManager();
    }
    @Test
    public void TestcompleteTask(){
        tm.completeTask(t);
        assertTrue(t.getStatus());
    }
    @Test
    public void TestaddTaskToCategory(){
        Category cy = new Category("Work");
        tm.addTaskToCategory(cy, t);
        assertTrue(cy.getTasks().contains(t));
    }
    @Test
    public void TestcreateTask(){
        Task temp = new Task("Apple", "Do it");
        Category cy = new Category("Work");
        tm.addTaskToCategory(cy, t);
        tm.addTaskToCategory(cy, temp);
        assertEquals("--------------------\n"+
                "Title: " + "Test\n"+
                "TODO: " + "Do it\n" +
                "Status: "+ "In Progress\n"+
                "--------------------\n"+
                "Title: " + "Apple\n"+
                "TODO: " + "Do it\n" +
                "Status: "+ "In Progress\n", tm.displayTask(cy));
    }
    @Test
    public void TestgetTaskbyName(){
        Task temp = new Task("Apple", "Do it");
        Category cy = new Category("Work");
        tm.addTaskToCategory(cy, t);
        tm.addTaskToCategory(cy, temp);
        assertEquals(temp, tm.getTaskByName(cy, "Apple"));
    }

    @Test
    public void TestcheckTask(){
        Category cy = new Category("Work");
        tm.addTaskToCategory(cy, t);
        assertTrue(tm.checkTask(cy, t));
    }

}
