package reger.cache;

import reger.Account;
import reger.core.Debug;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;

/**
 * Caches Account objects using OSCache
 */
public class AccountCache {

    private static GeneralCacheAdministrator admin;

    public static Account get(int accountid){
        Debug.debug(5, "", "AccountCache.get("+accountid+") called.");
        if (admin==null){
            admin = new GeneralCacheAdministrator();
        }

        if (accountid>0){
            try {
                Debug.debug(5, "", "AccountCache.get("+accountid+") trying to return from cache.");
                return (Account) admin.getFromCache(String.valueOf(accountid));
            } catch (NeedsRefreshException nre) {
                try {
                    Debug.debug(5, "", "AccountCache.get("+accountid+") refreshing object from database.");
                    Account acct = new Account(accountid);
                    //if (accountid>0 && acct!=null){
                        admin.putInCache(String.valueOf(accountid), acct);
                        return acct;
    //                } else {
    //                    admin.cancelUpdate(String.valueOf(accountid));
    //                    return new Account(0);
    //                }
                } catch (Exception ex) {
                    admin.cancelUpdate(String.valueOf(accountid));
                    Debug.errorsave(ex, "");
                    return new Account(0);
                }
            }
        }
        return new Account(0);
    }

    public static void put(String key, Account acct){
        if (admin==null){
            admin = new GeneralCacheAdministrator();
        }

        try{
            admin.putInCache(key, acct);
        } catch (Exception ex){
            Debug.errorsave(ex, "");
        }
    }

    public static void flush(){
        if (admin!=null){
            try{
                admin.flushAll();
            } catch (Exception e){
                Debug.errorsave(e, "");
            }
        }
    }

    public static void flush(int accountid){
        if (admin!=null){
            try{
                admin.flushEntry(String.valueOf(accountid));
            } catch (Exception e){
                Debug.errorsave(e, "");
            }
        }
    }


}
