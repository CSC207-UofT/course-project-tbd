package Phase_1Test;

import Phase_1.Entity.Folder;
import Phase_1.Entity.Task;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class FolderTest {
    Folder fr;
    Task a;
    Task b;
    Task c;
    Task d;
    Task e;

    @Before
    public void setUp() {
        a = new Task("Pitch in Idea");
        b = new Task("Create team");
        c = new Task("Prepare Presentation");
        d = new Task("Give Presentation");
        e = new Task("Polish the Presentation");
        fr = new Folder("CSC Project");
        fr.addTask(a);
        fr.addTask(b);
        fr.addTask(c);
        fr.addTask(d);
        fr.addTask(e);

    }


    @Test
    public void TestaddTask() {

        assertEquals(5, fr.getTasks().size());

    }

    @Test
    public void TestgetFolderName() {
        assertEquals("CSC Project", fr.getFolderName());

    }



    @Test
    public void testToString() {
        assertEquals("CSC Project\n" +
                "Pitch in Idea\n" +
                "Create team\n" +
                "Prepare Presentation\n" +
                "Give Presentation\n" +
                "Polish the Presentation", fr.toString());
    }
}