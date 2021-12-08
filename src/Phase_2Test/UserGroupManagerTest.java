package Phase_2Test;
import Phase_2.Entity.*;
import Phase_2.UseCaseClass.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserGroupManagerTest {

    User user;
    User user2;
    Task task;
    Group group;
    UserGroupManager UG_manager;

    @Before
    public void setup(){
        user = new NormalUser("test_user", "10086");
        user2 = new NormalUser("test_user2", "10086");
        task = new Task("Homework", "O no");
        group = new Group(user, "Disaster");
        UG_manager = new UserGroupManager();
    }

    @Test
    public void Test_removeGroup_oneUser() {
        UG_manager.addGroup(user, group.getgroupName());
        UG_manager.removeGroup(user, group.getgroupName());
        assertEquals("Dear test_user: \n" +
                "\n" +
                " You currently joined 0 group(s) \n" +
                "Here is the ID(s) of your joined group(s):\n", UG_manager.getGroupInfo(user));
    }

    @Test
    public void Test_removeGroup_multiUser() {
        UG_manager.addGroup(user, group.getgroupName());
        UG_manager.addGroup(user2, group.getgroupName());
        UG_manager.removeGroup(user, group.getgroupName());
        assertEquals("Dear test_user: \n" +
                "\n" +
                " You currently joined 0 group(s) \n" +
                "Here is the ID(s) of your joined group(s):\n", UG_manager.getGroupInfo(user));

        assertEquals("Dear test_user2: \n" +
                "\n" +
                " You currently joined 1 group(s) \n" +
                "Here is the ID(s) of your joined group(s):\n" +
                "Disaster\n", UG_manager.getGroupInfo(user2));
    }

    @Test
    public void Test_addGroup() {
        UG_manager.addGroup(user, group.getgroupName());
        assertEquals("Dear test_user: \n" +
                "\n" +
                " You currently joined 1 group(s) \n" +
                "Here is the ID(s) of your joined group(s):\n" +
                "Disaster\n", UG_manager.getGroupInfo(user));
    }

    @Test
    public void Test_getGroupIds() {
        UG_manager.addGroup(user, group.getgroupName());
        ArrayList<String> arlist = new ArrayList<>();
        arlist.add("Disaster");
        assertEquals(arlist, UG_manager.getGroupIds(user));
    }

    @Test
    public void Test_getMyGroups() {
        UG_manager.addGroup(user, group.getgroupName());
        ArrayList<String> arlist = new ArrayList<>();
        arlist.add("Disaster");
        assertEquals(arlist, UG_manager.getMyGroups(user));
    }

    @Test
    public void Test_getGroupInfo() {
        UG_manager.addGroup(user, group.getgroupName());
        assertEquals("Dear test_user: \n" +
                "\n" +
                " You currently joined 1 group(s) \n" +
                "Here is the ID(s) of your joined group(s):\n" +
                "Disaster\n", UG_manager.getGroupInfo(user));
    }
}
