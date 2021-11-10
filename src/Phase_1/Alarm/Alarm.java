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
    private LocalDateTime time;

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
        if (!Objects.equals(this.time, other.time)){    // if the alarm times are not the same
            return false;
        }
        return true;            // the two Alarms are equal
    }

    /**
     * hashCode for overriding equals method
     */
    @Override
    public int hashCode() {
        return Objects.hash(time);
    }
}
