package Phase_2Test;

import Phase_2.Entity.Task;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaskTest {
    String title;
    String information;
    Task t;
    String s;

    @Before
    public void setup(){
        title = "Homework";
        information = "DO IT NOW";
        t = new Task(title, information);

    }
    @Test
    public void TestsetStatus(){
        t.setStatus(true);
        assertTrue(t.getStatus());
    }
    @Test
    public void TestTaskName(){
        assertEquals("Homework", t.getTaskName());
    }
    @Test
    public void Testtostring(){
        s = "Title: "+ "Homework" + "\n";
        s += "TODO: " + "DO IT NOW" + "\n";
        s += "Status: " + "In Progress";
        assertEquals(s, t.toString());
    }


}
