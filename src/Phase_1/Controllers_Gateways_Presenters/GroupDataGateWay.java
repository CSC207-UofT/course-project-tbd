package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.Group;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GroupDataGateWay {
    String filePath;
    private ArrayList<Group> HashMap;

    public GroupDataGateWay(String filepath){
        this.filePath = filepath;
    }
    public void saveToFile(HashMap<String, Group> groups) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(groups);
        output.close();
    }
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
