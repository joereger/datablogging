package reger.cache;

import reger.Account;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;

/**
 * Caches Account objects using OSCache
 */
public class CacheTestCache {

    public static GeneralCacheAdministrator admin;


    public static CacheTest get(String key){
        if (admin==null){
            admin = new GeneralCacheAdministrator();
        }

        try {
            return (CacheTest) admin.getFromCache(key);
        } catch (NeedsRefreshException nre) {
            try {
                CacheTest ct = new CacheTest();
                ct.createdate = reger.core.TimeUtils.nowInUserTimezone("EST");
                ct.stuff = reger.core.RandomString.randomAlphanumeric(6);
                admin.putInCache(key, ct);
                return ct;
            } catch (Exception ex) {
                admin.cancelUpdate(key);
                reger.core.Util.errorsave(ex);
                return new CacheTest();
            }
        }
    }

    public static void put(String key, CacheTest stuff){
        if (admin==null){
            admin = new GeneralCacheAdministrator();
        }

        try{
            admin.putInCache(key, stuff);
        } catch (Exception ex){
            reger.core.Util.errorsave(ex);
        }
    }


}
