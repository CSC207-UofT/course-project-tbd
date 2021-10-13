package Phase_0Tests;

import Phase_0.GroupManager;
import Phase_0.User;
import Phase_0.NormalUser;
import Phase_0.Group;
import java.util.HashMap;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GroupManagerTest {
    NormalUser user = new NormalUser("user", "1");
    Group group = new Group(user, "Group 1");
    ArrayList<Group> groups = new ArrayList<>();
    HashMap<User, ArrayList<Group>> gm = new HashMap<>();

    @Before
    public void setUpCreateManager() {
        groups.add(group);
        gm.put(user, groups);
    }

    @Test(timeout=50)
    public void testCreateGroup() {
        HashMap<User, ArrayList<Group>> manager = new HashMap<>();
        GroupManager expected = new GroupManager(manager);
        expected.createGroup(user, "Group 1");
        String result = expected.maps.get(user).get(0).getgroupName();
        assertEquals("Group 1", result);
    }

    @Test
    public void testDeleteManager() {
        HashMap<User, ArrayList<Group>> empty = new HashMap<>();
        GroupManager expected = new GroupManager(empty);
        expected.createGroup(user, "Group 1");
        expected.deleteGroup(group);
        assertEquals(empty, expected.maps);
    }
}
