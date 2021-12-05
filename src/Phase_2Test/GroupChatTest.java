package Phase_2Test;


import Phase_2.Entity.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class GroupChatTest {
    Group g;
    User leader;
    ArrayList<User> users;
    User a;
    User b;

    @Before
    public void setup(){
        leader = new NormalUser("leader", "123"); // This is the leader of the group
        g = new Group(leader, "CSC project");
        a = new NormalUser("Jack", "234");
        b = new NormalUser("Peter", "345");
        users = new ArrayList<>();
        users.add(a);
        users.add(b);
        g.addUsers(users);

    }

    @Test
    public void TestgetGroupChatName(){
        assertEquals("CSC project", g.getGroupChat().getGroupChatName());
    }
    @Test
    public void TestinsertMessage(){
        g.getGroupChat().insertMessage(a, "Done with my Task");
        assertEquals("Done with my Task/Jack", g.getGroupChat().toString());

    }



}
