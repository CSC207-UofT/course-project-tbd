package Phase_1.Gateways;

import Phase_1.Entity.User;

import java.io.*;
import java.util.ArrayList;

public class UserDataGateway {
    String filePath;
    /**
     * create a gateways that loads a ArrayList of User .
     * @param filePath the directory where the .ser file is stored
     */
    public UserDataGateway(String filePath){
        this.filePath = filePath;
    }
    /**
     * Serialize the HashMap of admin into .ser file
     * @param users the HashMap we want to use to store User information
     * @throws IOException when an error occur when serializing
     */
    public void saveToFile(ArrayList<User> users) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(users);
        output.close();
    }
    /**
     * Deserializes the ArrayList of User into the program.
     * will assign adminMap to the hashmap which stores Admin with UserName as key
     * @throws IOException If the file cannot be read
     * @throws ClassNotFoundException If the class cannot be found
     */

    public ArrayList<User> readFromFile() throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        ArrayList<User> users = (ArrayList<User>) input.readObject();
        input.close();
        return users;
    }
}
