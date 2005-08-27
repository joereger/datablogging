package reger;

import java.util.Comparator;

/**
 * Compares names of logs.
 */
public class LogNameComparator implements Comparator{

    public int compare( Object log1, Object log2 )    {
        Log log1in = ( Log ) log1;
        Log log2in = ( Log ) log2;
        return log1in.getName().compareTo(log2in.getName());
    }

}
