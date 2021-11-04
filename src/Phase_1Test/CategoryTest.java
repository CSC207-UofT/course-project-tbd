package Phase_1Test;
import Phase_1.Entity.Category;
import Phase_1.Entity.Task;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {
    Category cy;
    Task a;
    Task b;
    Task c;
    Task d;

    @Before
    public void setUp() {
        a = new Task("homework");
        b = new Task("study");
        c = new Task("read");
        d = new Task("Sleep");

        cy = new Category("University");
        cy.addTask(a);
        cy.addTask(b);
        cy.addTask(c);
        cy.addTask(d);
        for(Task t: cy){
            System.out.println(t);
        }
    }

    @Test(timeout = 100)
    public void TestgetCategoryName(){
        assertEquals("University", cy.getCategoryName());
    }

    @Test(timeout = 100)
    public void TestgetTask(){
        assertEquals(4, cy.getTasks().size());
    }


}
