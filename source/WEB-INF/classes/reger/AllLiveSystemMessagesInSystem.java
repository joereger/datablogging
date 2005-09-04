package reger;

import reger.core.db.Db;
import reger.core.Debug;

import java.util.*;

/**
 * Static hold of all live system messages in the system.
 */
public class AllLiveSystemMessagesInSystem {

    private static Map allLiveSystemMessagesInSystem;

    public AllLiveSystemMessagesInSystem(){
        if (allLiveSystemMessagesInSystem==null){
            refresh();
        }
    }

    /**
     * Empties and then refreshes all logs in the system.
     */
    public static void refresh(){
        Debug.debug(5, "", "AllLiveSystemMessagesInSystem.refresh().");
        allLiveSystemMessagesInSystem=Collections.synchronizedMap(new HashMap());
        synchronized(allLiveSystemMessagesInSystem){
            //-----------------------------------
            //-----------------------------------
            String[][] rstPl= Db.RunSQL("SELECT systemmessageid FROM systemmessage WHERE islive='1'");
            //-----------------------------------
            //-----------------------------------
            if (rstPl!=null && rstPl.length>0){
                for(int i=0; i<rstPl.length; i++){
                    SystemMessage sm = new SystemMessage(Integer.parseInt(rstPl[i][0]));
                    allLiveSystemMessagesInSystem.put(new Integer(Integer.parseInt(rstPl[i][0])), sm);
                }
            }
        }
    }

    public static Map getAllLiveSystemMessagesAsMap(){
        if (allLiveSystemMessagesInSystem==null){
            refresh();
        }
        return allLiveSystemMessagesInSystem;
    }

    public static SystemMessage[] getAllLiveSystemMessagesInSystem(){
        if (allLiveSystemMessagesInSystem==null){
            refresh();
        }
        SystemMessage[] pls = new SystemMessage[0];
        for (Iterator i=allLiveSystemMessagesInSystem.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry e = (Map.Entry) i.next();
            //e.getKey()
            //e.getValue()
            pls = AddToArray.addToSystemMessageArray(pls, (SystemMessage)e.getValue() );
        }
        return pls;
    }



    public static SystemMessage getSystemMessage(int systemmessageid){
        //If it's null, refresh.  Generally won't happen.
        if (allLiveSystemMessagesInSystem==null){
            refresh();
        }

        //See if it contains the logid. Most should get caught here.
        if (allLiveSystemMessagesInSystem.containsKey(new Integer(systemmessageid))){
            return (SystemMessage)allLiveSystemMessagesInSystem.get(new Integer(systemmessageid));
        }

        //Then refresh.
        refresh();

        //And check again.
        if (allLiveSystemMessagesInSystem.containsKey(new Integer(systemmessageid))){
            return (SystemMessage)allLiveSystemMessagesInSystem.get(new Integer(systemmessageid));
        }

        //If we still don't have it, return the default pl.
        return new SystemMessage(0);
    }



}
