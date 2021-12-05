package Phase_2.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AnnouncementPage implements Serializable {
    // This class represents the homepage for a group

    private final ArrayList<String> announcements;

    /**
     * Constructs a new HomePage object by initializing empty
     */
    public AnnouncementPage(){
        this.announcements = new ArrayList<>();
    }

    /**
     * Adds an announcement.
     * @param announcement The announcement made by leader
     */
    public void addAnnouncement(String announcement){
        this.announcements.add(announcement);
    }

    /**
     *
     * @return Returns the string form of the announcements
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (String announcement : this.announcements){
            s.append(announcement).append("\n");
        }

        if (this.announcements.size() != 0) {
            s.delete(s.length()-1,s.length());
        }
        return s.toString();
    }

    /**
     * Returns the announcements as a list of strings
     * @return A list of strings corresponding to the announcements.
     */
    public List<String> getAnnouncements() {
        return this.announcements;
    }
}
