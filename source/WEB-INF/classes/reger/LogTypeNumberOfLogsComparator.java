package reger;

import reger.cache.LogCache;

import java.util.Comparator;

/**
 * Compares names of logs.
 */
public class LogTypeNumberOfLogsComparator implements Comparator{

    public int compare( Object log1, Object log2 )    {
        MegaLogType log1in = ( MegaLogType ) log1;
        MegaLogType log2in = ( MegaLogType ) log2;

        int log1NumOfLogs = LogCache.howManyOfThisTypeExist(log1in.getEventtypeid());
        int log2NumOfLogs = LogCache.howManyOfThisTypeExist(log2in.getEventtypeid());

        if (log1NumOfLogs<log2NumOfLogs){
            return -1;
        }
        if (log1NumOfLogs>log2NumOfLogs){
            return 1;
        }
        if (log1NumOfLogs==log2NumOfLogs){
            return 0;
        }

        return 0;
    }

}
