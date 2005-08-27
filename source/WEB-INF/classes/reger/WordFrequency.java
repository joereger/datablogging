package reger;

import java.util.Map;
import java.util.HashMap;

/**
 * Counts the frequency of words in the
 */
public class WordFrequency {
    private static final Integer ONE = new Integer(1);

    public static Map countFrequency(String args[]) {
        Map m = new HashMap();

        // Initialize frequency table from command line
        for (int i=0; i<args.length; i++) {
            Integer freq = (Integer) m.get(args[i]);
            m.put(args[i], (freq==null ? ONE : new Integer(freq.intValue() + 1)));
        }

        //m.size()+" distinct words detected:"
        //m
        return m;
    }

    public static Map countFrequency(String input){
        //Need to tokenize into words.
        //For now just a simple split.
        return countFrequency(input.split(" "));
    }
}
