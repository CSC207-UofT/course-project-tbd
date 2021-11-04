package Phase_1.Controllers_Gateways_Presenters;

import Phase_1.Entity.User;

import java.io.*;
import java.util.ArrayList;

public class UserDataGateway {
    String filePath;
    UserDataGateway(String filePath){
        this.filePath = filePath;
    }
    public void saveToFile(ArrayList<User> users) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(users);
        output.close();
    }
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
