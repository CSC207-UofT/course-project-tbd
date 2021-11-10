//import Phase_1.UseCaseClass.GroupManager;
//import Phase_1.Entity.User;
//import Phase_1.Entity.NormalUser;
//import Phase_1.Entity.Group;
//import java.util.HashMap;
//import java.util.ArrayList;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class GroupManagerTest {
//    NormalUser user = new NormalUser("user", "1");
//    Group group = new Group(user, "Group 1");
//    ArrayList<Group> groups = new ArrayList<>();
//    HashMap<User, ArrayList<Group>> gm = new HashMap<>();
//
//    @Before
//    public void setUpCreateManager() {
//        groups.add(group);
//        gm.put(user, groups);
//    }
//
//    @Test(timeout=50)
//    public void testCreateGroup() {
//        GroupManager expected = new GroupManager();
//        expected.createGroup(user, "Group 1");
//        String result = expected.maps.get(user).get(0).getgroupName();
//        assertEquals("Group 1", result);
//    }
//
//    @Test(timeout=50)
//    public void testDeleteManager() {
//        ArrayList<Group> empty = new ArrayList<>();
//        GroupManager expected = new GroupManager();
//        expected.createGroup(user, "Group 1");
//        Group wanted = expected.maps.get(user).get(0);
//        expected.deleteGroup(wanted);
//        assertEquals(empty, expected.maps.get(user));
//    }
//}
