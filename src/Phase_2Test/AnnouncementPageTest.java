package Phase_2Test;
import Phase_2.Entity.AnnouncementPage;

import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;
public class AnnouncementPageTest {
    AnnouncementPage ap;

    @Before
    public void setup(){
        ap =  new AnnouncementPage();
    }

    @Test
    public void Testaddannouncement(){
        ap.addAnnouncement("Start Project");
        ap.addAnnouncement("Review notes");
        assertEquals(2, ap.getAnnouncements().size());
    }
    @Test
    public void TesttoString(){
        assertEquals("", ap.toString());
        ap.addAnnouncement("Start Project");
        ap.addAnnouncement("Review notes");
        assertEquals("Start Project" + "\n"+
                "Review notes", ap.toString());
    }

}
