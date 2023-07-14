package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataStoreManager {
    private String data;

    public void init(String path) {
        File arq = new File(path);
        
        try (Scanner scanner = new Scanner(arq)){
            data = scanner.useDelimiter("\\Z").next().replaceAll("[^a-zA-Z]+", " ").toLowerCase();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
    public String[] words() {
        String data_str = "".concat(this.data);
        return data_str.split(" ");
    }
    
    public void dispatch(String[] message) {
        if (message[0].equals("init")) {
            this.init(message[1]);
        } else if (message[0].equals("words")) {
            this.words();
        } else {
            throw new RuntimeException("Message not understood " + message[0]);
        }
    }
    
    
}
