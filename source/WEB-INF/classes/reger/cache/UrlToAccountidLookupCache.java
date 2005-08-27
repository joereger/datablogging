package reger.cache;

import reger.UrlSplitter;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;

/**
 * Caches Account objects using OSCache
 */
public class UrlToAccountidLookupCache {

    public static GeneralCacheAdministrator admin;


    public static int get(UrlSplitter urlSplitter){
        reger.core.Util.debug(3, "UrlToAccountidLookupCache.get("+urlSplitter.getRawIncomingServername()+") called.");
        if (admin==null){
            admin = new GeneralCacheAdministrator();
        }

        try {
            reger.core.Util.debug(3, "UrlToAccountidLookupCache.get("+urlSplitter.getRawIncomingServername()+") trying to return from cache with urlSplitter.getUrlSplitterAsString()=" + urlSplitter.getUrlSplitterAsString());
            return ((Integer)admin.getFromCache(urlSplitter.getUrlSplitterAsString())).intValue();
        } catch (NeedsRefreshException nre) {
            try {
                reger.core.Util.debug(3, "UrlToAccountidLookupCache.get("+urlSplitter.getRawIncomingServername()+") refreshing from database with urlSplitter.getUrlSplitterAsString()=" + urlSplitter.getUrlSplitterAsString());
                int accountid = reger.Account.findAccountid(urlSplitter);
                reger.core.Util.debug(3, "UrlToAccountidLookupCache.get("+urlSplitter.getRawIncomingServername()+") refreshing from database with urlSplitter.getUrlSplitterAsString()=" + urlSplitter.getUrlSplitterAsString()+"<br>putting accountid="+accountid+" into cache.");
                admin.putInCache(urlSplitter.getUrlSplitterAsString(), new Integer(accountid));
                return accountid;
            } catch (Exception ex) {
                admin.cancelUpdate(urlSplitter.getUrlSplitterAsString());
                reger.core.Util.errorsave(ex);
                return 0;
            }
        }
    }

    public static void put(UrlSplitter urlSplitter, int accountid){
        if (admin==null){
            admin = new GeneralCacheAdministrator();
        }

        try{
            admin.putInCache(urlSplitter.getUrlSplitterAsString(), new Integer(accountid));
        } catch (Exception ex){
            reger.core.Util.errorsave(ex);
        }
    }


}
