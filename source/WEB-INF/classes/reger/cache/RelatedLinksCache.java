package reger.cache;

import reger.RelatedLinks;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;

import java.util.Properties;

/**
 * Caches Account objects using OSCache
 */
public class RelatedLinksCache {

    private static GeneralCacheAdministrator admin;


    public static RelatedLinks get(int eventid, String searchterms, reger.UserSession userSession){
        reger.core.Util.debug(4, "RelatedLinksCache.get("+eventid+") called.");
        if (admin==null){
            Properties props = new Properties();
            props.setProperty("cache.capacity", "5000");
            admin = new GeneralCacheAdministrator(props);
        }

        String key = "eventid" + eventid + "-accountuserid" + userSession.getAccountuser().getAccountuserid();

        try {
            reger.core.Util.debug(4, "RelatedLinksCache.get("+key+") trying to return from cache.");
            int hrstokeep = 12;
            int secstokeep = 60 * 60 * hrstokeep;
            return (RelatedLinks) admin.getFromCache(key, secstokeep);
        } catch (NeedsRefreshException nre) {
            try {
                reger.core.Util.debug(4, "RelatedLinksCache.get("+key+") refreshing object from database.");
                RelatedLinks relLink = new RelatedLinks(eventid, searchterms, userSession);
                String[] groups = new String[1];
                groups[0]="eventid"+eventid;
                admin.putInCache(key, relLink, groups);
                return relLink;
            } catch (Exception ex) {
                admin.cancelUpdate(key);
                reger.core.Util.errorsave(ex);
                return new RelatedLinks(0);
            }
        }
    }



    public static void flush(){
        if (admin!=null){
            admin.flushAll();
        }
    }

    public static void flush(int eventid){
        if (admin!=null){
            admin.flushGroup(String.valueOf("eventid"+eventid));
        }
    }


}
