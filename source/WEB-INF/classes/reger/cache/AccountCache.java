package reger.cache;

import reger.Account;
import reger.cache.providers.CacheFactory;

/**
 * Caches Account objects using OSCache
 */
public class AccountCache {

    private static String GROUP = "account";

    public static Account get(int accountid){
        if (accountid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(accountid), GROUP);
            if (obj!=null && (obj instanceof Account)){
                return (Account)obj;
            } else {
                Account acct = new Account(accountid);
                CacheFactory.getCacheProvider().put(String.valueOf(accountid), GROUP, acct);
                return acct;
            }
        }
        return new Account(0);
    }

    public static void put(String key, Account acct){
        CacheFactory.getCacheProvider().put(key, GROUP, acct);
    }

    public static void flush(){
        CacheFactory.getCacheProvider().flush(GROUP);
    }

    public static void flush(int accountid){
        CacheFactory.getCacheProvider().flush(String.valueOf(accountid), GROUP);
    }


}
