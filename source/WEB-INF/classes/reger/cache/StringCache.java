package reger.cache;

import reger.Account;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;

/**
 * Caches Account objects using OSCache
 */
public class StringCache {

    public static GeneralCacheAdministrator admin;


    public static String get(String key){
        if (admin==null){
            admin = new GeneralCacheAdministrator();
        }

        try {
            return (String) admin.getFromCache(key);
        } catch (NeedsRefreshException nre) {
            try {
                String stuff = reger.core.RandomString.randomAlphanumeric(6);
                admin.putInCache(key, stuff);
                return stuff;
            } catch (Exception ex) {
                admin.cancelUpdate(key);
                reger.core.Util.errorsave(ex);
                return "";
            }
        }
    }

    public static void put(String key, String stuff){
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
