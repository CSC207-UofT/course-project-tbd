package Phase_1Test;

import Phase_1.Entity.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

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
    ArrayList<Category> Categories;
    ArrayList<Features> features;
    ArrayList<User> users;



    @Before
    public void setUp() {
        leader = new NormalUser("leader", "123"); // This is the leader of the group
        g = new Group(leader, "CSC project");   // Group has been created
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
    public void TestgroupInformation() {
        assertEquals("CSC project", g.getgroupName());
        assertEquals(leader, g.getgroupLeader());
        assertEquals(4, g.getUsers().size());
        assertEquals(1, g.getCategories().size());
    }

    @Test
    public void Testaddcatergory() {
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
    public void TestgetUsers() {
        assertEquals(4, g.getUsers().size());
    }

    @Test
    public void TestremoveUser() {
        g.removeUser(z);
        assertEquals(3, g.getUsers().size());
    }

    @Test
    public void TestGroupchat() {
        assertEquals("", g.getGroupChat().toString());
    }

    @Test
    public void TestAnnouncementPage() {
        assertEquals("", g.getAnnouncementPage().toString());
    }


}