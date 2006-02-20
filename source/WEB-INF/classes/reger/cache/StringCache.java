package reger.cache;

import reger.core.Debug;
import reger.Account;
import reger.cache.providers.CacheFactory;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;

/**
 * Caches Account objects using OSCache
 */
public class StringCache {

    private static String GROUP = "string";

    public static String get(String key){
        Object obj = CacheFactory.getCacheProvider().get(key, GROUP);
        if (obj!=null && (obj instanceof String)){
            return (String)obj;
        } else {
            return "";
        }
    }

    public static void put(String key, String stuff){
        CacheFactory.getCacheProvider().put(key, GROUP, stuff);
    }

    public static void flush(){
        CacheFactory.getCacheProvider().flush(GROUP);
    }

    public static void flush(String key){
        CacheFactory.getCacheProvider().flush(key, GROUP);
    }











}
