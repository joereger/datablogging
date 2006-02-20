package reger.cache;

import reger.UrlSplitter;
import reger.Account;
import reger.cache.providers.CacheFactory;
import reger.core.Debug;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;


public class UrlToAccountidLookupCache {


    private static String GROUP = "urltoaccountid";

    public static int get(UrlSplitter urlSplitter){

        Object obj = CacheFactory.getCacheProvider().get(urlSplitter.getUrlSplitterAsString(), GROUP);
        if (obj!=null){
            try{
                int accountid = (Integer)obj;
                return accountid;
            } catch (Exception e){
               reger.core.Debug.errorsave(e, "UrlToAccountidLookupCache.java");
               return 0;
            }
        } else {
            int accountid = reger.Account.findAccountid(urlSplitter);
            if (accountid>0){
                CacheFactory.getCacheProvider().put(urlSplitter.getUrlSplitterAsString(), GROUP, new Integer(accountid));
            }
            return accountid;
        }
    }

    public static void put(UrlSplitter urlSplitter, int accountid){
        CacheFactory.getCacheProvider().put(urlSplitter.getUrlSplitterAsString(), GROUP, new Integer(accountid));
    }

    public static void flush(){
        CacheFactory.getCacheProvider().flush(GROUP);
    }

    public static void flush(int accountid){
        CacheFactory.getCacheProvider().flush(String.valueOf(accountid), GROUP);
    }

}
