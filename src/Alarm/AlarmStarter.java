package Alarm;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class AlarmStarter implements AlarmMenu{

    private Timer timer = new Timer();
    private Map<Alarm, TimerTask> unfinishedScheduledTasks = Collections.synchronizedMap(new HashMap());

    @Override
    public Alarm createAlarm(LocalDateTime time) {
        return new Alarm(time);
    }

    @Override
    public TimerTask startAlarm(Alarm alarm, Runnable whenFired) throws Exception {
        if (unfinishedScheduledTasks.containsKey(alarm)){
            throw new UnsupportedOperationException("There is already a task at this time");
        }

        //get number of millisecond into the future of the scheduled time
        Duration duration = Duration.between(LocalDateTime.now(), alarm.getTime());
        long ms = duration.toMillis();
        if (ms < 0){
            throw new UnsupportedOperationException("Cannot schedule " + ms + "milliseconds from now");
        }

        //creating TimerTask to be executed by the timer
        TimerTask alert = new TimerTask() {
            @Override
            public void run() {
                whenFired.run();
                unfinishedScheduledTasks.remove(alarm);
            }

            @Override
            public boolean cancel() {

                boolean alert = super.cancel();
                unfinishedScheduledTasks.remove(alarm);
                return alert;
            }
        };
        unfinishedScheduledTasks.put(alarm, alert);
        timer.schedule(alert, ms);
        return alert;
    }

    @Override
    public boolean cancelAlarm(Alarm alarm) {
        TimerTask alert = unfinishedScheduledTasks.get(alarm);
        if (alert == null){
            return false;
        }

        boolean cancelled = alert.cancel();

        if (cancelled){
            unfinishedScheduledTasks.remove(alarm);
        }

        return cancelled;
    }

}
