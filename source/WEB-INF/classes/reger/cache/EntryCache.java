package reger.cache;

import reger.Entry;
import reger.Account;
import reger.cache.providers.CacheFactory;
import reger.core.Debug;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;

/**
 * Caches Entry objects
 */
public class EntryCache {

    private static String GROUP = "entry";

    public static Entry get(int eventid){
        if (eventid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(eventid), GROUP);
            if (obj!=null && (obj instanceof Entry)){
                reger.core.Debug.debug(3, "EntryCache.java", "Returning cached version of eventid="+eventid);
                return (Entry)obj;
            } else {
                Entry entry = new Entry(eventid);
                CacheFactory.getCacheProvider().put(String.valueOf(eventid), GROUP, entry);
                reger.core.Debug.debug(3, "EntryCache.java", "Refreshed cache version of eventid="+eventid);
                return entry;
            }
        }
        reger.core.Debug.debug(3, "EntryCache.java", "Returning new Event(0) for eventid="+eventid);
        return new Entry(0);
    }

    public static void flush(){
        CacheFactory.getCacheProvider().flush(GROUP);
    }

    public static void flush(int eventid){
        CacheFactory.getCacheProvider().flush(String.valueOf(eventid), GROUP);
    }











}
