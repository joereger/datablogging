package reger.cache;

import reger.AccountCounts;
import reger.Account;
import reger.Accountuser;
import reger.cache.providers.CacheFactory;
import reger.core.Debug;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;

/**
 * Caches Account objects using OSCache.
 * Key is accountid:accountuserid
 * Group is accountid and accountuserid, used to remove entries for a particular account when they change
 */
public class AccountCountCache {

    private static String GROUP = "accountcounts";


    public static AccountCounts get(Account account, Accountuser accountuser){
        String key = "accountid"+account.getAccountid()+":"+"accountuserid"+accountuser.getAccountuserid();
        Object obj = CacheFactory.getCacheProvider().get(key, GROUP);
        if (obj!=null && (obj instanceof AccountCounts)){
            return (AccountCounts)obj;
        } else {
            AccountCounts acctCounts = new AccountCounts(account, accountuser);
            CacheFactory.getCacheProvider().put(key, GROUP, acctCounts);
            return acctCounts;
        }
    }

    public static void flush(){
        CacheFactory.getCacheProvider().flush(GROUP);
    }

    public static void flush(int accountid, int accountuserid){
        String key = "accountid"+accountid+":"+"accountuserid"+accountuserid;
        CacheFactory.getCacheProvider().flush(key, GROUP);
    }


    public static void flushByAccountid(int accountid){
        String[] keys = CacheFactory.getCacheProvider().getKeys(GROUP);
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            if (key.indexOf("accountid"+accountid)>0){
                CacheFactory.getCacheProvider().flush(key, GROUP);
            }
        }
    }




}
