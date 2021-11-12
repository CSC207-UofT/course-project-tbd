package Phase_1Test;

import Phase_1.Entity.*;
import Phase_1.UseCaseClass.UserManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Objects;

public class UserManagerTest {
    ArrayList<User> allUsers;
    User a;
    User b;
    User c;
    User d;
    User x;
    UserManager um;
    Category cy;
    Task temp;


    @Before
    public void setUp() {
        a = new NormalUser("Cat", "123");
        b = new NormalUser("Pat", "234");
        c = new NormalUser("Dog", "345");
        d = new NormalUser("Duck", "567");
        allUsers = new ArrayList<User>();
        allUsers.add(a);
        allUsers.add(b);
        allUsers.add(c);
        allUsers.add(d);
        um = new UserManager(allUsers);

    }
    @Test
    public void TestdisplayUserDetail(){
        assertEquals("Username: " + "Cat" + "\n"
                + "Password: " + "123", um.displayUserDetail(a));

    }

    @Test
    public void TestcreateNormalUser(){
        um.createNormalUser("Mark", "234", "My name", "Mark");
        assertEquals(5, um.allUsers.size());
    }

    @Test
    public void TestcheckIfValid(){
        assertEquals(false, um.checkIfValid("Cat"));
        assertEquals(true, um.checkIfValid("Cam"));
    }
    @Test
    public void Testlogin(){
        assertEquals(true, um.login("Cat", "123"));
        assertEquals(false, um.login("Cat", "133"));
    }
    @Test
    public void TestgetUserById(){
        assertEquals(null, um.getUserById("Cam"));
        assertEquals(a, um.getUserById("Cat"));
    }
    @Test
    public void TestaddCategory(){
        cy = new Category("Study");
        um.addCategory(a, cy);
        assertEquals("All Tasks"+
                "\n" + "Study" + "\n", um.displayCategories(a));
    }
    @Test
    public void TestaddTask(){
        cy = new Category("Study");
        temp = new Task("Homework");
        um.addCategory(a, cy);
        um.addTask(a, temp, cy);
        assertEquals(2, um.getUserById("Cat").getMyCategories().size());
        assertEquals(1, um.getUserById("Cat").getMyCategories().get(1).getTasks().size());
    }
    @Test
    public void TestdisplayCategories(){
        assertEquals("All Tasks" + "\n", um.displayCategories(a));
    }

}
