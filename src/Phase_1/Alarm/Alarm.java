/*
 * The design of this class was based on AlarmClock
 * on GitHub repository by gburgett
 * (https://github.com/gburgett/AlarmClock)
 */

package Phase_1.Alarm;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Alarm class that store the information about the time the alarm should go off.
 *
 * @author  Owen Huang
 */
public class Alarm {

    /**
     * A LocalDateTime object storing the actual date information about the alarm time
     */
    private final LocalDateTime time;

    /**
     * Getter method for accessing the alarm time
     */
    public LocalDateTime getTime(){
        return time;
    }

    /**
     * Construct the alarm with given time
     *
     * @param time LocalDateTime object representing the alarm time
     */
    public Alarm(LocalDateTime time){
        this.time = time;
    }

    /**
     * We want to be able to know whether two Alarm objects are equal
     *
     * @param obj is another Alarm object
     */
    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {     // if they don't belong to the same class
            return false;
        }
        Alarm other = (Alarm) obj;          //cast obj to Alarm
        // if the alarm times are not the same
        return Objects.equals(this.time, other.time);// the two Alarms are equal
    }

    /**
     * hashCode for overriding equals method
     */
    @Override
    public int hashCode() {
        return time.hashCode();
    }
}
