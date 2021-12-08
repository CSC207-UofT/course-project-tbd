package Phase_2Test;
import Phase_2.Entity.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminUserTest {
    AdminUser au;

    @Before
    public void setUp() {
        au = new AdminUser("Apple", "1234");
    }

    @Test
    public void TestUserInfo() {
        assertEquals("Apple", au.getUsername());
        assertEquals("1234", au.getPassword());
    }
    // Admin User gains access of any NormalUser account in AdminAccessController.
    // No other attribute except for the username or password of Admin is used.

}
