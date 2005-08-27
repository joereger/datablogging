package reger.cache;

import reger.Entry;

import java.util.*;

/**
 * Caches entry objects
 */
public class EntryCache {

    private static Map entries;
    private static int maxNumberOfObjectsInCache = 10;

    //This is a stack.  Most recently used is removed from the stack(if it existed in there) and puts it at the top.
    //This creates a way to remove the least recently used objects from the cache
    private static List usageList;

    public static Entry get(int eventid){
        if (entries==null){
            entries = Collections.synchronizedMap(new HashMap());
        }
        if (usageList==null){
            usageList = Collections.synchronizedList(new LinkedList());
        }

        reger.core.Util.debug(5, "EntryCache.java: Getting eventid=" + eventid);

        if (!entries.containsKey(new Integer(eventid))){
            refresh(eventid);
        }

        //Record usage.
        usageList.remove(new Integer(eventid));
        usageList.add(new Integer(eventid));

        //@todo It should return a copy because I never know what's going to happen to the one in the cache.
        return (Entry)entries.get(new Integer(eventid));
    }

    public static void refresh(int eventid){
        if (entries==null){
            entries = Collections.synchronizedMap(new HashMap());
        }
        if (usageList==null){
            usageList = Collections.synchronizedList(new LinkedList());
        }

        reger.core.Util.debug(5, "EntryCache.java: Refreshing eventid=" + eventid);

        Entry tmpEntry = new Entry(eventid);
        if (tmpEntry.eventid>0){
            if (entries.size()>maxNumberOfObjectsInCache){
                int leastRecentlyUsed = ((Integer)usageList.get(0)).intValue();
                usageList.remove(0);
                entries.remove(new Integer(leastRecentlyUsed));
            }
            entries.put(new Integer(eventid), tmpEntry);
        } else {
            entries.remove(new Integer(eventid));
        }

    }

    public static void dumpCurrentStatusToDb(){
        StringBuffer mb = new StringBuffer();

        mb.append("<table cellpadding=0 cellspacing=15 border=0>");
        mb.append("<tr>");
        mb.append("<td valign=top>");
        mb.append("Entries in cache:");
        for (Iterator i=entries.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry e = (Map.Entry) i.next();
            //e.getKey()
            //e.getValue()
            mb.append("<br>eventid=" + e.getKey());
        }
        mb.append("</td>");
        mb.append("<td valign=top>");
        mb.append("Order in usageList:");
        for (Iterator iterator = usageList.iterator(); iterator.hasNext();) {
            Integer eventid = (Integer) iterator.next();
            mb.append("<br>eventid=" + eventid);
        }
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");


        reger.core.Util.logtodb(mb.toString());
    }


}
