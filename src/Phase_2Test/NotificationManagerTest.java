package Phase_2Test;

import Phase_2.Entity.Alarm;
import Phase_2.UseCaseClass.AlarmStarter;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class NotificationManagerTest {
    @Before
    public void setUp() {

    }

    @Test(timeout = 100)
    public void TestNotificationManagerScheduleAlarmIntoThePastException(){
        LocalDateTime newTime1 = LocalDateTime.of(1999, 9, 1, 1, 1);
        Alarm alarm = new Alarm(newTime1);

        Duration duration = Duration.between(LocalDateTime.now(), alarm.getTime());
        long ms = duration.toMillis();

        class TestRunnableClass implements Runnable{

            @Override
            public void run() {
                System.out.println("Alarm started");
            }
        }

        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            AlarmStarter alarmStarter = new AlarmStarter();
            alarmStarter.startAlarm(alarm, new TestRunnableClass());
        });

        String expectedMessage1 = "WARNING!\nPrevious task is scheduling";
        String expectedMessage2 = "milliseconds into the past\n" +
                "Task is added without alarm notification";

        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage1));
        assertTrue(actualMessage.contains(expectedMessage2));
        assertTrue(ms < 0);

    }

}
