/*
 * The design of this class was based on AlarmClock
 * on GitHub repository by 'gburgett'
 * (https://github.com/gburgett/AlarmClock)
 */

package Phase_2.UseCaseClass;

import Phase_2.Entity.Alarm;

import java.time.LocalDateTime;

/**
 * This interface is created to help manage the AlarmStarter class
 *
 * @author  Owen Huang
 */
public interface AlarmMenu{

    /**
     * Create an Alarm object based on the date and time passed in
     *
     * @param   time the date and time the alarm will go off
     * @return  an Alarm object
     */
    Alarm createAlarm(LocalDateTime time);

    /**
     * Starts the alarm object being passed in and when the time is up,
     * run the Runnable object whenFired
     *
     * @param   alarm an Alarm object that contains the time alarm should go off
     * @param   whenFired when the time is up, or when the alarm goes off, execute this runnable object
     * @throws Exception {@inheritDoc}
     *  @throws UnsupportedOperationException {@inheritDoc} when user tries to get an alarm into the past
     */
    void startAlarm(Alarm alarm, Runnable whenFired) throws Exception;

    /**
     * Cancels the alarm passing in
     *
     * @param   alarm is an Alarm object that user wants to get cancelled
     */
    void cancelAlarm(Alarm alarm);
}
