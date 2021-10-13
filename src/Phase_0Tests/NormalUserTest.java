package Phase_0Tests;
import Phase_0.Category;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import Phase_0.NormalUser;
import Phase_0.Category;
import static org.junit.Assert.*;

public class NormalUserTest {
    NormalUser nm;
    Category a;
    Category b;
    Category c;

    @Before
    public void setUp() {
        String abcd = "abcd";
        a = new Category("music");
        b = new Category("sport");
        c = new Category("study");

        nm = new NormalUser("cat", "abcd");
        nm.addNewCategory(a);
        nm.addNewCategory(b);
        nm.addNewCategory(c);
        nm.deleteCategory(b);
    }
    @Test(timeout = 50)
    public void TestdisplayMyCategories(){
//        assertEquals("music" + "\n" + "study", nm.displayMyCategories());
        assertEquals("Username: " + "cat" + "\n"
                + "Password: " + "abcd", nm.displayUserDetail());
        assertEquals(2, nm.myCategories.size());
    }


}
