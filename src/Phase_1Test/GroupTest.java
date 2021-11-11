package Phase_1Test;

import Phase_1.Entity.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;


public class GroupTest {

    Group g;
    User leader;
    Category cy;
    Task a;
    Task b;
    Task c;
    Task d;
    User x;
    User y;
    User z;
//    AnnouncementPage pg;
//    GroupChat gc;
    ArrayList<Category> Categories;
    ArrayList<Features> features;
    ArrayList<User> users;
//    ArrayList<String> announcements;


    @Before
    public void setUp() {
        leader = new NormalUser("leader", "123"); // This is the leader of the group
//        g.addCategory(leader.getUsername());
//        pg = announcements;
//        gc = new GroupChat("CSC project");
        g = new Group(leader, "CSC project");   // Group has been created
//        g.addCategory(leader.getUsername());
        x = new NormalUser("Jack", "234");
        y = new NormalUser("Peter", "345");
        z = new NormalUser("Milly", "456");
        users = new ArrayList<>();
        users.add(x);
        users.add(y);
        users.add(z);
        g.addUsers(users);


    }
    @Test
    public void TestgroupInformation(){
        assertEquals("CSC project", g.getgroupName());
        assertEquals(leader, g.getgroupLeader());
        assertEquals(4, g.getUsers().size());
        assertEquals(1, g.getCategories().size());
    }
    @Test
    public void Testaddcatergory(){
        cy = new Category("Phase 1");
        a = new Task("Pitch in Idea");
        b = new Task("Create team");
        c = new Task("Prepare Presentation");
        d = new Task("Give Prcesentation");
        cy.addTask(a);
        cy.addTask(b);
        cy.addTask(c);
        g.addCategory(cy.toString());
        g.addTasktoCategory(d, cy);
        assertEquals(2, g.getCategories().size());
    }
    @Test
    public void TestgetUsers(){
        assertEquals(4, g.getUsers().size());
    }
    @Test
    public void TestremoveUser(){
        g.removeUser(z);
        assertEquals(3, g.getUsers().size());
    }
    @Test
    public void TestGroupchat(){
        assertEquals("", g.getGroupChat().toString());
    }
    @Test
    public void TestAnnoucementpage(){
        assertEquals("", g.getAnnouncementPage().toString());
    }

//    @Test(timeout = 50)
//    public void TestaddNewFeature(){
//        // This tests whether adding a new feature works to our group
//        Features category1 = new Features("testCategory") {
//            @Override
//            public int hashCode() {
//                return super.hashCode();
//            }
//        };
//        g.addNewFeature(category1);
//        ArrayList<Features> expected = g.getFeatures();
//        ArrayList<Features> actual = new ArrayList<>();
//        actual.add(category1);
//        assertEquals(expected, actual);
//
//    }
//
//    @Test(timeout = 50)
//    public void TestdeleteFeature(){
//        //This checks whether we can delete a feature
//        Category category1 = new Category("testCategory");
//        Category category2 = new Category("testCategory2");
//        g.addNewFeature(category1);
//        g.addNewFeature(category2);
//        g.deleteFeature(category1);
//        ArrayList<Features> expected = g.getFeatures();
//        ArrayList<Features> actual = new ArrayList<>();
//        actual.add(category2);
//        assertEquals(expected, actual);
//    }
//
//    @Test(timeout = 50)
//    public void TestaddTaskToCategory(){
//        // Checks whether a task can be added to a category feature
//        Features category1 = new Category("testCategory");
//        g.addNewFeature(category1);
//        Task t = new Task("Complete homework");
//        g.addTasktoCategory(t, (Category) category1);
//        ArrayList<Task> expected = ((Category) category1).getTasks();
//        ArrayList<Task> actual = new ArrayList<>();
//        actual.add(t);
//        assertEquals(expected, actual);
//    }
//
//    @Test(timeout = 50)
//    public void TestaddUsers(){
//        // Tests whether the group can store info about users in the group
//        ArrayList<User> usersList = new ArrayList<>();
//        usersList.add(new NormalUser("kevin", "123"));
//        usersList.add(new NormalUser("errin", "456"));
//        g.addUsers(usersList);
//        ArrayList<User> expected = g.getUsers();
//        ArrayList<User> actual = usersList;
//        assertEquals(expected, actual);
//    }
}
