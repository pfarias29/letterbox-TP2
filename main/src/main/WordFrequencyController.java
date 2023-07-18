package main;
import java.util.ArrayList;
public class WordFrequencyController {
    
    DataStorageManager storageManager = new DataStorageManager();
    StopWordsManager stopWordManager = new StopWordsManager();
    WordFrequencyManager wordFrequencyManager = new WordFrequencyManager();

    public void init(String path) {
        String[] mensagemStorage = {"init", path};
        String[] mensagemStopWord = {"init"};
        storageManager.dispatch(mensagemStorage);
        stopWordManager.dispatch(mensagemStopWord);
    }
    
    public void run(){
        String[] mensagemWords = {"words"};
        String[] mensagemSorted = {"sorted"};
        
        for(String word : storageManager.dispatch(mensagemWords)){
            
            String[] mensagemIsStopWord = {"is_stop_word", word};
            String[] mensagemIncrementCount = {"increment_count", word};
            
            if(stopWordManager.dispatch(mensagemIsStopWord)){
                
                wordFrequencyManager.dispatch(mensagemIncrementCount);
            }
        }
        ArrayList<Pair> word_freqs = wordFrequencyManager.dispatch(mensagemSorted);
        for(int i = 0; i <= 24 && i < word_freqs.size(); i++){
            Pair p = word_freqs.get(i);
            
            System.out.println(p.word + " - " + p.freq.toString());
        }
    }
    
    public void dispatch (String[] message) {
        if (message[0].equals("init")) {
            this.init(message[1]);
        }
        else if (message[0].equals("run")) {
            this.run();
        }
        else {
            throw new RuntimeException("Message not understood" + message[0]);
        }
    }
}