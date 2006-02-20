package reger.cache;

import reger.RelatedLinks;
import reger.Account;
import reger.cache.providers.CacheFactory;
import reger.core.Debug;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;

import java.util.Properties;

/**
 * Caches Account objects using OSCache
 */
public class RelatedLinksCache {

    private static String GROUP = "relatedlinks";

    public static RelatedLinks get(int eventid, String searchterms, reger.UserSession userSession){
        String key = "eventid" + eventid + "-accountuserid" + userSession.getAccountuser().getAccountuserid();

        Object obj = CacheFactory.getCacheProvider().get(key, GROUP);
        if (obj!=null && (obj instanceof RelatedLinks)){
            return (RelatedLinks)obj;
        } else {
            RelatedLinks relLink = new RelatedLinks(eventid, searchterms, userSession);
            CacheFactory.getCacheProvider().put(key, GROUP, relLink);
            return relLink;
        }
    }

    public static void put(String key, Account acct){
        CacheFactory.getCacheProvider().put(key, GROUP, acct);
    }

    public static void flush(){
        CacheFactory.getCacheProvider().flush(GROUP);
    }


    public static void flush(int eventid){
        String[] keys = CacheFactory.getCacheProvider().getKeys(GROUP);
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            if (key.indexOf("eventid"+eventid)>0){
                CacheFactory.getCacheProvider().flush(key, GROUP);
            }
        }
    }







}
