package Phase_2Test;

import Phase_2.Entity.Alarm;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class AlarmTest {
    @Before
    public void setUp() {

    }

    @Test(timeout = 100)
    public void TestAlarmEquals(){
        LocalDateTime time1 = LocalDateTime.now();
        LocalDateTime time2 = LocalDateTime.now();
        LocalDateTime newTime1 = LocalDateTime.of(2021, 10, 2, 8, 0);
        LocalDateTime newTime2 = LocalDateTime.of(2021, 10, 2, 8, 0);
        Alarm a = new Alarm(newTime1);
        Alarm b = new Alarm(newTime2);
        assertEquals(a, b);

        Alarm c = new Alarm(time1);
        Alarm d = new Alarm(time2);
        assertNotEquals(c, d);
    }

    @Test(timeout = 100)
    public void TestAlarmGetTime(){
        LocalDateTime newTime1 = LocalDateTime.of(2021, 10, 2, 8, 0);
        LocalDateTime newTime2 = LocalDateTime.of(1999, 1, 22, 16, 5);
        Alarm a = new Alarm(newTime1);
        Alarm b = new Alarm(newTime2);
        assertEquals(a.getTime(), newTime1);
        assertEquals(b.getTime(), newTime2);

    }
}
