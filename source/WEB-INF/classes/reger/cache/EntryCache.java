package reger.cache;

import reger.Entry;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;

/**
 * Caches Entry objects using OSCache
 */
public class EntryCache {

    private static GeneralCacheAdministrator admin;


    public static Entry get(int eventid){
        reger.core.Util.debug(4, "EntryCache.get("+eventid+") called.");
        if (admin==null){
            admin = new GeneralCacheAdministrator();
        }

        try {
            reger.core.Util.debug(4, "EntryCache.get("+eventid+") trying to return from cache.");
            return (Entry) admin.getFromCache(String.valueOf(eventid));
        } catch (NeedsRefreshException nre) {
            try {
                reger.core.Util.debug(4, "EntryCache.get("+eventid+") refreshing object from database.");
                Entry ent = new Entry(eventid);
                admin.putInCache(String.valueOf(eventid), ent);
                return ent;
            } catch (Exception ex) {
                admin.cancelUpdate(String.valueOf(eventid));
                reger.core.Util.errorsave(ex);
                return new Entry(0);
            }
        }
    }

    public static void flush(int eventid){
        if (admin!=null){
            try{
                admin.flushEntry(String.valueOf(eventid));
            } catch (Exception e){
                reger.core.Util.errorsave(e);
            }
        }
    }


    public static void flush(){
        if (admin!=null){
            try{
                admin.flushAll();
            } catch (Exception e){
                reger.core.Util.errorsave(e);
            }
        }
    }


}
