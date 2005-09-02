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

        int accountid = reger.Account.findAccountid(urlSplitter);

        if (accountid>0){
            try {
                reger.core.Util.debug(3, "UrlToAccountidLookupCache.get("+urlSplitter.getRawIncomingServername()+") trying to return from cache with urlSplitter.getUrlSplitterAsString()=" + urlSplitter.getUrlSplitterAsString());
                return ((Integer)admin.getFromCache(urlSplitter.getUrlSplitterAsString())).intValue();
            } catch (NeedsRefreshException nre) {
                try {
                    reger.core.Util.debug(3, "UrlToAccountidLookupCache.get("+urlSplitter.getRawIncomingServername()+") refreshing from database with urlSplitter.getUrlSplitterAsString()=" + urlSplitter.getUrlSplitterAsString());

                    //if (accountid>0){
                        reger.core.Util.debug(3, "UrlToAccountidLookupCache.get("+urlSplitter.getRawIncomingServername()+") refreshing from database with urlSplitter.getUrlSplitterAsString()=" + urlSplitter.getUrlSplitterAsString()+"<br>putting accountid="+accountid+" into cache.");
                        admin.putInCache(urlSplitter.getUrlSplitterAsString(), new Integer(accountid));
                        return accountid;
    //                } else {
    //                    reger.core.Util.debug(3, "UrlToAccountidLookupCache.get("+urlSplitter.getRawIncomingServername()+") No accountid>0 was found so not putting into cache and returning 0.");
    //                    admin.cancelUpdate(String.valueOf(accountid));
    //                    return 0;
    //                }
                } catch (Exception ex) {
                    reger.core.Util.debug(3, "UrlToAccountidLookupCache.get("+urlSplitter.getRawIncomingServername()+") Exception so returning 0.");
                    admin.cancelUpdate(urlSplitter.getUrlSplitterAsString());
                    reger.core.Util.errorsave(ex);
                    return 0;
                }
            }
        }
        return 0;
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
