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

    @Test
    public void testDeleteManager() {
        HashMap<String, Group> empty = new HashMap<>();
        GroupManager expected = new GroupManager(gm);
        expected.createGroup(user, "tbd");
        String wanted = expected.maps.get("tbd#0").getgroupName();
        expected.deleteGroup(wanted, user);
        assertEquals(empty, expected.maps);
    }

    @Test(timeout=50)
    public void testMemberList() {
        NormalUser user = new NormalUser("user", "1");
        Group group = new Group(user, "tbd#0");
        ArrayList<User> expected = new ArrayList<>();
        expected.add(user);
        HashMap<String, Group> groups = new HashMap<>();
        groups.put("tbd#0", group);
        GroupManager manager = new GroupManager(groups);
        ArrayList<User> result = manager.memberList("tbd#0");
        assertEquals(result, expected);
    }

    @Test(timeout=50)
    public void testCheckIfIn() {
        NormalUser user = new NormalUser("user", "1");
        NormalUser harry = new NormalUser("harry", "1");
        Group group = new Group(user, "tbd#0");
        HashMap<String, Group> groups = new HashMap<>();
        groups.put("tbd#0", group);
        GroupManager manager = new GroupManager(groups);
        boolean result1 = manager.checkIfIn("tbd#0", user);
        boolean result2 = manager.checkIfIn("tbd#0", harry);
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test(timeout=50)
    public void testCheckGroupExists() {
        NormalUser user = new NormalUser("user", "1");
        Group group = new Group(user, "tbd#0");
        HashMap<String, Group> groups = new HashMap<>();
        groups.put("tbd#0", group);
        GroupManager manager = new GroupManager(groups);
        boolean result1 = manager.checkGroupExists("tbd#0");
        boolean result2 = manager.checkGroupExists("harry");
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test(timeout=50)
    public void testCheckIfLeader() {
        NormalUser user = new NormalUser("user", "1");
        NormalUser harry = new NormalUser("harry", "1");
        Group group = new Group(user, "tbd#0");
        HashMap<String, Group> groups = new HashMap<>();
        groups.put("tbd#0", group);
        GroupManager manager = new GroupManager(groups);
        manager.addUserToGroup("tbd#0", harry);
        boolean result1 = manager.checkIfLeader("tbd#0", user);
        boolean result2 = manager.checkIfLeader("tbd#0", harry);
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test(timeout=50)
    public void testAddUserToGroup() {
        NormalUser user = new NormalUser("user", "1");
        NormalUser harry = new NormalUser("harry", "1");
        NormalUser kevin = new NormalUser("kevin", "1");
        Group group = new Group(user, "tbd#0");
        HashMap<String, Group> groups = new HashMap<>();
        groups.put("tbd#0", group);
        GroupManager manager = new GroupManager(groups);
        manager.addUserToGroup("tbd#0", kevin);
        boolean result1 = manager.checkIfIn("tbd#0", kevin);
        boolean result2 = manager.checkIfIn("tbd#0", harry);
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test(timeout=50)
    public void testRemoveMember() {
        NormalUser user = new NormalUser("user", "1");
        NormalUser kevin = new NormalUser("kevin", "1");
        Group group = new Group(user, "tbd#0");
        HashMap<String, Group> groups = new HashMap<>();
        groups.put("tbd#0", group);
        GroupManager manager = new GroupManager(groups);
        manager.addUserToGroup("tbd#0", kevin);
        manager.removeMember("tbd#0", kevin);
        assertEquals(group, manager.maps.get("tbd#0"));
    }

    @Test(timeout=50)
    public void testGetGroupById() {
        NormalUser user = new NormalUser("user", "1");
        Group group = new Group(user, "tbd#0");
        HashMap<String, Group> groups = new HashMap<>();
        groups.put("tbd#0", group);
        GroupManager manager = new GroupManager(groups);
        Group result = manager.getGroupById("tbd#0");
        assertEquals(group, result);
    }
}
