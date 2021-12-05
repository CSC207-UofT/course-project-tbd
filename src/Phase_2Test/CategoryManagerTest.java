package Phase_2Test;

import Phase_2.Entity.*;
import Phase_2.UseCaseClass.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryManagerTest {
    User a;
    Task t;
    Category cy;
    CategoryManager cm;
    Group g;
    User b;
    Category temp;


    @Before
    public void setup(){
        a = new NormalUser("abc", "123");
        b = new NormalUser("Leader", "12");
        cm = new CategoryManager();
        t = new Task("Test", "Do it");
        cy = new Category("Study");
        a.addNewCategory(cy);
        a.addTasktoCategory(t, cy);
        g = new Group(b, "CSC");
    }

    @Test
    public void TestcheckCategory(){
        assertTrue(cm.checkCategory(a, cy));
    }

    @Test
    public void TestgetCategoryByName(){assertEquals(cy, cm.getCategoryByName(a, "Study"));}

    @Test
    public void TestcheckCategoryByName(){
        assertTrue(cm.checkCategoryByName(cy, "Study"));
    }
    @Test
    public void TestgetCategoryByGroup(){
        g.addCategory("Work");
        assertEquals(g.getCategories().get(1), cm.getCategoryByGroup("Work", g));
    }
}
