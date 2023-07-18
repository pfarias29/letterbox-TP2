package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


class Pair {
    public String word;
    public Integer freq;
    
    public Pair(String word, Integer freq){
        this.word = word;
        this.freq = freq;
    }
}

//class CustomComparator implements Comparator<Pair>{
//    @Override
//    public int compare(Pair p1, Pair p2) {
//        return p1.freq.compareTo(p2.freq);
//    }
//}


public class WordFrequencyManager {
    HashMap <String, Integer> wordFreq = new HashMap();
    
    
    public void incrementCount(String word) {
        if (wordFreq.containsKey(word)) {
            wordFreq.put(word, wordFreq.get(word) + 1);
        } else {
            wordFreq.put(word, 1);
        }
    }
    
    public ArrayList<Pair> sorted() {
        ArrayList<Pair> temp = new ArrayList<>();
        
        for (String word : wordFreq.keySet()) {
            temp.add(new Pair(word, wordFreq.get(word)));
        }
        
        Collections.sort(temp, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.freq.compareTo(p2.freq) * -1;
            }
        });
        
        return temp;
    }
    
    public ArrayList<Pair> dispatch(String[] message) {
        if (message[0].equals("increment_count")) {
            this.incrementCount(message[1]);
        } else if (message[0].equals("sorted")) {
            return this.sorted();
        } else {
            throw new RuntimeException("Message not understood " + message[0]);
        }
        
        return new ArrayList<>();
    }
}
