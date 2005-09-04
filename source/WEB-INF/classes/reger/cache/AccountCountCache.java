package reger.cache;

import reger.AccountCounts;
import reger.Account;
import reger.Accountuser;
import reger.core.Debug;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;

/**
 * Caches Account objects using OSCache.
 * Key is accountid:accountuserid
 * Group is accountid and accountuserid, used to remove entries for a particular account when they change
 */
public class AccountCountCache {

    public static GeneralCacheAdministrator admin;

    public static AccountCounts get(Account account, Accountuser accountuser){
        String key = account.getAccountid()+":"+accountuser.getAccountuserid();
        String[] group = new String[2];
        group[0] = String.valueOf(account.getAccountid());
        group[1] = String.valueOf(accountuser.getAccountuserid());
        Debug.debug(5, "", "AccountCountsCache.get("+account.getAccountid()+", "+accountuser.getAccountuserid()+") called.");

        if (admin==null){
            admin = new GeneralCacheAdministrator();
        }

        try {
            Debug.debug(5, "", "AccountCountsCache.get("+account.getAccountid()+", "+accountuser.getAccountuserid()+") trying to return from cache.");
            return (AccountCounts) admin.getFromCache(key);
        } catch (NeedsRefreshException nre) {
            try {
                Debug.debug(5, "", "AccountCountsCache.get("+account.getAccountid()+", "+accountuser.getAccountuserid()+") refreshing object from database.");
                AccountCounts acctCounts = new AccountCounts(account, accountuser);
                admin.putInCache(key, acctCounts, group);
                return acctCounts;
            } catch (Exception ex) {
                admin.cancelUpdate(key);
                Debug.errorsave(ex, "");
                return new AccountCounts();
            }
        }
    }

    public static void flushByAccountid(int accountid){
        if (admin==null){
            admin = new GeneralCacheAdministrator();
        }
        try{
            admin.flushGroup(String.valueOf(accountid));
        } catch (Exception e){
            Debug.errorsave(e, "");
        }
    }

    public static void flushByAccountuserid(int accountuserid){
        if (admin==null){
            admin = new GeneralCacheAdministrator();
        }
        try{
            admin.flushGroup(String.valueOf(accountuserid));
        } catch (Exception e){
            Debug.errorsave(e, "");
        }
    }

    public static void put(String key, AccountCounts acctCounts, String[] group){
        if (admin==null){
            admin = new GeneralCacheAdministrator();
        }

        try{
            admin.putInCache(key, acctCounts, group);
        } catch (Exception ex){
            Debug.errorsave(ex, "");
        }
    }


}
