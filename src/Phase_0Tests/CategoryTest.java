package Phase_0Tests;

import Phase_0.Category;
import Phase_0.Task;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;


public class CategoryTest {
    Category cy;

    @Before
    public void setUp() {
        cy = new Category("Category 1");
    }

    @Test(timeout = 50)
    public void TestgetCategoryName(){
        assertEquals("Category 1", cy.getCategoryName());
    }
}
