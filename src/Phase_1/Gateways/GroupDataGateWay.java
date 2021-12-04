package Phase_1.Gateways;

import Phase_1.Entity.Group;

import java.io.*;

import java.util.HashMap;

public class GroupDataGateWay {
    String filePath;
    /**
     * create a gateways that loads a HashMap of Group with GroupId as key.
     * @param filepath the directory where the .ser file is stored
     */
    public GroupDataGateWay(String filepath){
        this.filePath = filepath;
    }

    /**
     * Serialize the HashMap of admin into .ser file
     * @param groups the HashMap we want to use to store Group information
     * @throws IOException when an error occur when serializing
     */
    public void saveToFile(HashMap<String, Group> groups) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(groups);
        output.close();
    }

    /**
     * Deserializes the hashmap of Group into the program.
     * will assign adminMap to the hashmap which stores Admin with UserName as key
     * @throws IOException If the file cannot be read
     * @throws ClassNotFoundException If the class cannot be found
     */
    public HashMap<String, Group> readFromFile() throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        HashMap<String, Group> groups = (HashMap<String, Group>) input.readObject();
        input.close();
        return groups;
    }

}
