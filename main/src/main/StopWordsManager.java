package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class StopWordsManager {
    ArrayList<String> stop_words = new ArrayList<>();
    
    public void init() {
        File f = new File("stop_words.txt");
        
        try (Scanner scanner = new Scanner(f)) {
            String content = scanner.useDelimiter("\\Z").next().toLowerCase();
            for (String w: content.split(",")) {
                stop_words.add(w);
            }
            for (char ch = 'a'; ch <= 'z'; ch++) {
                stop_words.add(String.valueOf(ch));
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
    public boolean isStopWord(String word) {
        return stop_words.contains(word);
    }
    
    public boolean dispatch(String[] message) {
        if (message[0].equals("init")) {
            this.init();
        }
        else if(message[0].equals("is_stop_word")) {
            return this.isStopWord(message[1]);
        }
        else {
            throw new RuntimeException("Message not understood " + message[0]);
        }
        
        return false;
    }
}