package Phase_1Test;

import Phase_1.UseCaseClass.GroupManager;
import Phase_1.Entity.User;
import Phase_1.Entity.NormalUser;
import Phase_1.Entity.Group;
import java.util.HashMap;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GroupManagerTest {
    NormalUser user = new NormalUser("user", "1");
    Group group = new Group(user, "tbd#0");
    HashMap<String, Group> gm = new HashMap<>();

    @Before
    public void setUpCreateManager() {
        gm.put("tbd#0", group);
    }

    @Test(timeout=50)
    public void testCreateGroup() {
        HashMap<String, Group> maps = new HashMap<>();
        GroupManager expected = new GroupManager(maps);
        expected.createGroup(user, "tbd");
        String result = expected.maps.get("tbd#0").getgroupName();
        assertEquals("tbd#0", result);
    }

    @Test(timeout=50)
    public void testDeleteManager() {
        HashMap<String, Group> empty = new HashMap<>();
        GroupManager expected = new GroupManager(gm);
        expected.createGroup(user, "tbd");
        String wanted = expected.maps.get("tbd#0").getgroupName();
        expected.deleteGroup(wanted, user);
        assertEquals(empty, expected.maps);
    }

    public void testMemberList() {

    }
}
