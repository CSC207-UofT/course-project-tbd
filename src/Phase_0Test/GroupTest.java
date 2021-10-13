package Phase_0Test;

import Phase_0.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class GroupTest {

    Group g;
    User leader;

    @Before
    public void setUp() {
        leader = new NormalUser("leader", "123"); // This is the leader of the group
        g = new Group(leader, "Mygroup");   // Group has been created
    }

    @Test(timeout = 50)
    public void TestaddNewFeature(){
        // This tests whether adding a new feature works to our group
        Features category1 = new Category("testCategory");
        g.addNewFeature(category1);
        ArrayList<Features> expected = g.getFeatures();
        ArrayList<Features> actual = new ArrayList<>();
        actual.add(category1);
        assertEquals(expected, actual);

    }

    @Test(timeout = 50)
    public void TestdeleteFeature(){
        //This checks whether we can delete a feature
        Features category1 = new Category("testCategory");
        Features category2 = new Category("testCategory2");
        g.addNewFeature(category1);
        g.addNewFeature(category2);
        g.deleteFeature(category1);
        ArrayList<Features> expected = g.getFeatures();
        ArrayList<Features> actual = new ArrayList<>();
        actual.add(category2);
        assertEquals(expected, actual);
    }

    @Test(timeout = 50)
    public void TestaddTaskToCategory(){
        // Checks whether a task can be added to a category feature
        Features category1 = new Category("testCategory");
        g.addNewFeature(category1);
        Task t = new Task("Complete homework");
        g.addTasktoCategory(t, (Category) category1);
        ArrayList<Task> expected = ((Category) category1).getTasks();
        ArrayList<Task> actual = new ArrayList<>();
        actual.add(t);
        assertEquals(expected, actual);
    }

    @Test(timeout = 50)
    public void TestaddUsers(){
        // Tests whether the group can store info about users in the group
        ArrayList<User> usersList = new ArrayList<>();
        usersList.add(new NormalUser("kevin", "123"));
        usersList.add(new NormalUser("errin", "456"));
        g.addUsers(usersList);
        ArrayList<User> expected = g.getUsers();
        ArrayList<User> actual = usersList;
        assertEquals(expected, actual);
    }
}
