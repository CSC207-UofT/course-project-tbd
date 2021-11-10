package Phase_1.Alarm;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

/**
 * This AlarmStarter class implements the alarmMenu interface
 * This class is responsible for creating alarm, starting the alarm,
 * and cancelling the alarm, through utilizing the Timer package in java.
 *
 * @author  Owen Huang
 */
public class AlarmStarter implements AlarmMenu{

    /**
     * A Timer object responsible for scheduling alarms in a background Timer Thread
     */
    private Timer timer = new Timer();

    /**
     * A map object take has Alarm as its keys and its corresponding TimerTask as its value.
     * Map should be synchronized so that no two threads can change its content at the same time,
     * it should be a thread safe operation
     */
    private Map<Alarm, TimerTask> unfinishedScheduledTasks = Collections.synchronizedMap(new HashMap());

    /**
     * Creates an Alarm object according to the time
     *
     * @param time LocalDateTime object representing the time alarm should go off
     * @return Alarm object with time set to the given time
     */
    @Override
    public Alarm createAlarm(LocalDateTime time) {
        return new Alarm(time);
    }

    /**
     * Starts the alarm. When the alarm goes off, the Runnable object will be executed
     *
     * @param alarm the Alarm that will be scheduled by Timer
     * @param whenFired is the Runnable object that will be executed when the scheduled alarm goes off
     * @return a TimerTask object containing the task that will be executed when alarm goes off
     * @throws UnsupportedOperationException {@inheritDoc} when it tries to schedule alarm into the past
     */
    @Override
    public TimerTask startAlarm(Alarm alarm, Runnable whenFired) throws UnsupportedOperationException {
        //get number of millisecond into the future of the scheduled time
        Duration duration = Duration.between(LocalDateTime.now(), alarm.getTime());
        long ms = duration.toMillis();  // save the difference from now to the alarm time in milliseconds
        if (ms < 0){        // if the alarm time is in the past compared to now
            // throw UnsupportedOperationException and tell the user scheduling into the past is not allowed
            throw new UnsupportedOperationException("WARNING!\nPrevious task is scheduling " +
                    ms +
                    " milliseconds into the past\n" +
                    "Task is added without alarm  notification");
        }

        //creating TimerTask to be executed by the timer
        TimerTask alert = new TimerTask() {
            /**
             * Overrides run in Runnable
             */
            @Override
            public void run() {
                whenFired.run();        // run the desired Runnable when alarm goes off
                unfinishedScheduledTasks.remove(alarm);     // remove from unfinished task
            }

            /**
             * Overrides cancel in Runnable
             */
            @Override
            public boolean cancel() {
                boolean alert = super.cancel();         // cancel the Runnable task
                unfinishedScheduledTasks.remove(alarm); // remove from unfinished task
                return alert;                           // return whether it is cancelled successfully
            }
        };
        unfinishedScheduledTasks.put(alarm, alert);     // add <Alarm, TimerTask> pair to unfinished task after creation
        timer.schedule(alert, ms);      // schedule/start the TimerTask on a countdown specified at the beginning
        return alert;
    }

    /**
     * Cancel an existing alarm, that is currently in count down.
     *
     * @param   alarm is an Alarm object that user wants to get cancelled
     * @return  true if the alarm is cancelled successfully, false if the alarm does not exist or failed to cancel
     * because it wasn't scheduled
     */
    @Override
    public boolean cancelAlarm(Alarm alarm) {
        TimerTask alert = unfinishedScheduledTasks.get(alarm);
        if (alert == null){     // if the alarm does not have a TimerTask scheduled
            return false;       // fail to cancel
        }

        boolean cancelled = alert.cancel();     // try to cancel the TimerTask

        if (cancelled){                         // if successfully cancelled
            unfinishedScheduledTasks.remove(alarm);     // remove from unfinished task
        }

        return cancelled;       // fail to cancel
    }

}
