package Phase_2.Entity;

import java.io.Serializable;
import java.util.ArrayList;

public class GroupChat implements Serializable {
    private final String name;
    private final ArrayList<String> messages;

    /**
     * Construct a GroupChat object which stores user's messages
     * in an ArrayList
     * @param name the name of the group chat
     *             (it should be the name of the group itself)
     */
    public GroupChat(String name) {
        this.name = name;
        this.messages = new ArrayList<>();
    }

    /**
     * This methods returns the name of the GroupChat
     * @return the name of the group chat
     */
    public String getGroupChatName() {
        return this.name;
    }




    /**
     * This method inserts a message that is input by a given User
     * @param user the user who inputs the message
     * @param message the message that is sent
     */
    public void insertMessage(User user, String message) {
        String input = message + "/" + user.getUsername();
        this.messages.add(input);
    }

    /**
     * This method prints out all the messages in this GroupChat
     * alongside the name of the user who sent them
     * @return a String that has the above format
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (String text : this.messages){
            s.append(text).append("\n");
        }
        if (this.messages.size() != 0) {
            s.delete(s.length()-1,s.length());
        }
        return s.toString();
    }
}
