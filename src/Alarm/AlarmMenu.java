package Alarm;

import java.time.LocalDateTime;
import java.util.TimerTask;

public interface AlarmMenu {

    public Alarm createAlarm(LocalDateTime time);

    public TimerTask startAlarm(Alarm alarm, Runnable whenFired) throws Exception;

    public boolean cancelAlarm(Alarm alarm);
}
