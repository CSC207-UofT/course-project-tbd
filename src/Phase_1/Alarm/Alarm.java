package Phase_1.Alarm;

import java.time.LocalDateTime;
import java.util.Objects;


public class Alarm {

    private LocalDateTime time;

    public LocalDateTime getTime(){
        return time;
    }

    public Alarm(LocalDateTime time){
        this.time = time;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        Alarm other = (Alarm) obj;
        if (!Objects.equals(this.time, other.time)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(time);
    }
}
