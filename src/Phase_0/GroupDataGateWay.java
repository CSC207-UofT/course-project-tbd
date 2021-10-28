package Phase_0;

import java.io.*;
import java.util.ArrayList;

public class GroupDataGateWay {
    String filePath;
    GroupDataGateWay(String filepath){
        this.filePath = filepath;
    }
    public void saveToFile(ArrayList<Group> groups) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(groups);
        output.close();
    }
    public ArrayList<Group> readFromFile() throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        ArrayList<Group> groups = (ArrayList<Group>) input.readObject();
        input.close();
        return groups;
    }

}
