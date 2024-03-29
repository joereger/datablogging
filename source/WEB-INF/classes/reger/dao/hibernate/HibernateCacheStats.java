package reger.dao.hibernate;

import java.util.Map;
import java.util.Iterator;

/**
 * Dumps data on the hibernate cache
 */
public class HibernateCacheStats {

    public static String getCacheDump(){
        StringBuffer mb = new StringBuffer();
        String[] regionNames = HibernateUtil.getSession().getSessionFactory().getStatistics().getSecondLevelCacheRegionNames();
        for (int i = 0; i < regionNames.length; i++) {
            String regionName = regionNames[i];
            mb.append(getEntriesForARegion(regionName));
        }
        return mb.toString();
    }

    public static String getEntriesForARegion(String regionname){
        StringBuffer mb = new StringBuffer();
        long elementCountInMemory = HibernateUtil.getSession().getSessionFactory().getStatistics().getSecondLevelCacheStatistics(regionname).getElementCountInMemory();
        long sizeInMemory = HibernateUtil.getSession().getSessionFactory().getStatistics().getSecondLevelCacheStatistics(regionname).getSizeInMemory();
        Map cacheEntries = HibernateUtil.getSession().getSessionFactory().getStatistics().getSecondLevelCacheStatistics(regionname).getEntries();

        mb.append("<br><br>");
        mb.append("<font face=arial size=+1>");
        mb.append(regionname);
        mb.append(" ( "+elementCountInMemory+" items, "+sizeInMemory+" bytes)");
        mb.append("</font>");

        Iterator keyValuePairs = cacheEntries.entrySet().iterator();
        for (int i = 0; i < cacheEntries.size(); i++){
            Map.Entry mapentry = (Map.Entry) keyValuePairs.next();
            Object key = mapentry.getKey();
            Object value = mapentry.getValue();
            mb.append("<br>");
            mb.append("<font face=arial size=-2>");
            mb.append("Key:"+key.toString());
            mb.append(" Value:"+value.toString());
            mb.append("</font>");
        }

        return mb.toString();
    }



}
