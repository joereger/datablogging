package reger.cache;

import reger.Account;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;

/**
 * Caches Account objects using OSCache
 */
public class AccountCache {

    private static GeneralCacheAdministrator admin;


    public static Account get(int accountid){
        reger.core.Util.debug(4, "AccountCache.get("+accountid+") called.");
        if (admin==null){
            admin = new GeneralCacheAdministrator();
        }

        try {
            reger.core.Util.debug(4, "AccountCache.get("+accountid+") trying to return from cache.");
            return (Account) admin.getFromCache(String.valueOf(accountid));
        } catch (NeedsRefreshException nre) {
            try {
                reger.core.Util.debug(4, "AccountCache.get("+accountid+") refreshing object from database.");
                Account acct = new Account(accountid);
                admin.putInCache(String.valueOf(accountid), acct);
                return acct;
            } catch (Exception ex) {
                admin.cancelUpdate(String.valueOf(accountid));
                reger.core.Util.errorsave(ex);
                return new Account(0);
            }
        }
    }

    public static void put(String key, Account acct){
        if (admin==null){
            admin = new GeneralCacheAdministrator();
        }

        try{
            admin.putInCache(key, acct);
        } catch (Exception ex){
            reger.core.Util.errorsave(ex);
        }
    }

    public static void flush(){
        if (admin!=null){
            admin.flushAll();    
        }
    }


}
