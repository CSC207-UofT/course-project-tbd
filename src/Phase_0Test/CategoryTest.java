package Phase_0Test;
import Phase_0.Category;
import Phase_0.Task;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class CategoryTest {
    Category cy;
    Task a;
    Task b;
    Task c;

    @Before
    public void setUp() {
        a = new Task("homework");
        b = new Task("study");
        c = new Task("read");

        cy = new Category("University");
        cy.addTask(a);
        cy.addTask(b);
        cy.addTask(c);
    }

    @Test(timeout = 100)
    public void TestgetCategoryName(){
        assertEquals("University", cy.getCategoryName());
    }

    @Test(timeout = 100)
    public void TestaddTask(){
        assertEquals(3, cy.getTasks().size());
    }

}
