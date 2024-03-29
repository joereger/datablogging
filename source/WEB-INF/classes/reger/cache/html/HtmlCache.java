package reger.cache.html;

import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * A very simple html cache.  Should only be applied to html sections that do not
 * require any logon.
 *
 * Only works on GET requests.
 *
 * Sample usage:
 * String cachekey = "communitypage"; //Anything unique for the page
 * int refreshintervalinseconds = 30;
 * if (!HtmlCache.isStale(cachekey, request, refreshintervalinseconds)){
 *     mb.append(HtmlCache.getFromCache(cachekey, request));
 * } else {
 *     //Build the html as normal
 *     //
 *     //Then add to the cache
 *     HtmlCache.updateCache(cachekey, request, refreshintervalinseconds, html);
 * }
 */
public class HtmlCache {

    private static Map htmlCache;
    private static Map lastUpdated;
    private static Map refreshInterval;
    private static long totalcacherequests = 0;
    private static long totalcachehits = 0;


    public static boolean isStale(String keyGeneratedFromRequest, int refreshintervalinseconds){
        totalcacherequests = totalcacherequests + 1;
        if (htmlCache==null){
            return true;
        } else {
            if (htmlCache.containsKey(keyGeneratedFromRequest)){
                Calendar lastUpdatedAt = (Calendar)lastUpdated.get(keyGeneratedFromRequest);
                Debug.debug(5, "", "HtmlCache.java<br>keyGeneratedFromRequest="+keyGeneratedFromRequest+"<br>DateDiff=" + reger.core.DateDiff.dateDiff("second", reger.core.TimeUtils.nowInGmtCalendar(), lastUpdatedAt));
                if (reger.core.DateDiff.dateDiff("second", reger.core.TimeUtils.nowInGmtCalendar(), lastUpdatedAt)>refreshintervalinseconds){
                    return true;
                }
            } else {
                return true;
            }
        }
        totalcachehits = totalcachehits + 1;
        return false;
    }

    public static String getKeyFromRequest(HttpServletRequest request, boolean includedomain){
        String out = "";
        if (includedomain){
            out = request.getRequestURL().toString();
        } else {
            out = reger.core.Util.getJspName(request.getRequestURI());
        }
        if (request.getQueryString()!=null && !request.getQueryString().equals("")){
            out = out + "?" + request.getQueryString();
        }
        return out;
    }

    public static String getKeyFromRequest(HttpServletRequest request){
        return getKeyFromRequest(request, true);
    }

    public static void updateCache(String cachekey, int refreshintervalinseconds , String html){
        if (htmlCache==null){
            htmlCache = Collections.synchronizedMap(new HashMap());
        }
        synchronized(htmlCache){
            htmlCache.put(cachekey, html);
        }


        if (lastUpdated==null){
            lastUpdated = Collections.synchronizedMap(new HashMap());
        }
        //Store in GMT
        Calendar calTmp = Calendar.getInstance();
        calTmp = reger.core.TimeUtils.convertFromOneTimeZoneToAnother(calTmp, calTmp.getTimeZone().getID(), "GMT");
        synchronized(lastUpdated){
            lastUpdated.put(cachekey, calTmp);
        }

        if (refreshInterval==null){
            refreshInterval = Collections.synchronizedMap(new HashMap());
        }
        synchronized(refreshInterval){
            refreshInterval.put(cachekey, new Integer(refreshintervalinseconds));
        }
    }

    public static String getFromCache(String cachekey){
        if (htmlCache!=null){
            return (String)htmlCache.get(cachekey);
        } else {
            return null;
        }
    }

    public static void purgeStaleItems(){
        if (htmlCache!=null){
            synchronized(htmlCache){
                for (Iterator i=htmlCache.entrySet().iterator(); i.hasNext(); ) {
                    Map.Entry e = (Map.Entry) i.next();
                    String key = (String)e.getKey();
                    //e.getValue()
                    //Make sure a key exists for all maps, otherwise delete
                    if (lastUpdated!=null && refreshInterval!=null && lastUpdated.containsKey(key) && refreshInterval.containsKey(key)){
                        int refreshintervalinseconds = ((Integer)refreshInterval.get(key)).intValue();
                        if (isStale(key, refreshintervalinseconds)){
                            //Remove the key
                            i.remove();
                            synchronized(lastUpdated){
                                lastUpdated.remove(key);
                            }
                            synchronized(refreshInterval){
                                refreshInterval.remove(key);
                            }
                        }
                    } else {
                        //Remove the key
                        i.remove();
                        synchronized(lastUpdated){
                            lastUpdated.remove(key);
                        }
                        synchronized(refreshInterval){
                            refreshInterval.remove(key);
                        }
                    }

                }
            }
        }
    }

    public static void flush(String key){
        try{
            synchronized(htmlCache){
                htmlCache.remove(key);
            }
            synchronized(lastUpdated){
                lastUpdated.remove(key);
            }
            synchronized(refreshInterval){
                refreshInterval.remove(key);
            }
        } catch (Exception e){
            reger.core.Debug.debug(5, "HtmlCache.java", e);
        }
    }

    public static void clearCache(){
        synchronized(htmlCache){
            htmlCache=null;
        }
        synchronized(lastUpdated){
            lastUpdated=null;
        }
        synchronized(refreshInterval){
            refreshInterval=null;
        }
    }

    public static Map getHtmlCache(){
        return htmlCache;
    }

    public static Map getLastUpdated(){
        return lastUpdated;
    }

    public static Map getRefreshInterval(){
        return refreshInterval;
    }

    public static long getTotalcacherequests() {
        return totalcacherequests;
    }

    public static long getTotalcachehits() {
        return totalcachehits;
    }
}
