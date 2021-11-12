package Phase_1.Entity;

import java.util.ArrayList;
import java.util.HashMap;

public class AnnouncementPage {
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
     * @return Returns the arraylist containing announcements
     */
    public ArrayList<String> getAnnouncements() {
        return announcements;
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

}
