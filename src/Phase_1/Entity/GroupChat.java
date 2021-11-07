package Phase_1.Entity;

import java.util.ArrayList;

public class GroupChat {
    private String name;
    public ArrayList<String> messages;

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
     * This method returns an ArrayList contains all the messages
     * and their sender of a GroupChat object
     * @return an ArrayList of "message/user.name"
     */
    public ArrayList<String> getMessages() {
        return this.messages;
    }

    /**
     * This method returns an ArrayList contains all the messages
     * from the wanted user
     * @param user the wanted user
     * @return an ArrayList contains "message/user.name"
     */
    public ArrayList<String> getMessagesByUser(User user) {
        ArrayList<String> results = new ArrayList<>();
        String userName = user.username;

        for (String str : this.messages) {
            String[] compare = str.split("/");
            if (compare[1].equals(userName)) {
                results.add(str);
            }
        }

        return results;
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
