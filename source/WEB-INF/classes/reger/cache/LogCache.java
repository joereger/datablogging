package reger.cache;

import reger.Log;
import reger.LogNameComparator;
import reger.Account;
import reger.cache.AccountCache;
import reger.cache.providers.CacheFactory;
import reger.core.db.Db;
import reger.core.Debug;
import reger.mega.FieldType;

import java.util.*;

/**
 * Caches Account objects using OSCache
 */
public class LogCache {


    private static String GROUP = "log";
    private static ArrayList<LogCacheKeyMegafieldidRelationship> logCacheKeyMegafieldidRelationship = new ArrayList<LogCacheKeyMegafieldidRelationship>();
    private static ArrayList<LogCacheKeyEventtypeidRelationship> logCacheKeyEventtypeidRelationship = new ArrayList<LogCacheKeyEventtypeidRelationship>();

    public static Log get(int logid){
        if (logid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(logid), GROUP);
            if (obj!=null && (obj instanceof Log)){
                return (Log)obj;
            } else {
                Log log = new Log(logid);
                CacheFactory.getCacheProvider().put(String.valueOf(logid), GROUP, log);
                handleLogAdd(log);
                return log;
            }
        }
        return new Log(0);
    }

    public static void flush(){
        CacheFactory.getCacheProvider().flush(GROUP);
    }

    public static void flush(int logid){
        CacheFactory.getCacheProvider().flush(String.valueOf(logid), GROUP);
    }

    public static void flushByLogid(int logid){
        flush(logid);
        try{
            synchronized(logCacheKeyEventtypeidRelationship){
                for (Iterator it = logCacheKeyEventtypeidRelationship.iterator(); it.hasNext(); ) {
                    LogCacheKeyEventtypeidRelationship rel = (LogCacheKeyEventtypeidRelationship)it.next();
                    if (rel!=null && rel.logid==logid){
                        it.remove();
                    }
                }
            }
            synchronized(logCacheKeyMegafieldidRelationship){
                for (Iterator it = logCacheKeyMegafieldidRelationship.iterator(); it.hasNext(); ) {
                    LogCacheKeyMegafieldidRelationship rel = (LogCacheKeyMegafieldidRelationship)it.next();
                    if (rel!=null && rel.logid==logid){
                        it.remove();
                    }
                }
            }
        } catch (Exception ex){
            Debug.debug(5, "LogCache.java", ex);
        }
    }

    public static void flushByMegafieldid(int megafieldid){
        try{
            synchronized(logCacheKeyMegafieldidRelationship){
                for (Iterator it = logCacheKeyMegafieldidRelationship.iterator(); it.hasNext(); ) {
                    LogCacheKeyMegafieldidRelationship rel = (LogCacheKeyMegafieldidRelationship)it.next();
                    if (rel.megafieldid==megafieldid){
                        CacheFactory.getCacheProvider().flush(String.valueOf(rel.logid), GROUP);
                        it.remove();
                    }
                }
            }
        } catch (Exception ex){
            Debug.debug(5, "LogCache.java", ex);
        }
    }

    public static void flushByEventtypeid(int eventtypeid){
        try{
            synchronized(logCacheKeyEventtypeidRelationship){
                for (Iterator it = logCacheKeyEventtypeidRelationship.iterator(); it.hasNext(); ) {
                    LogCacheKeyEventtypeidRelationship rel = (LogCacheKeyEventtypeidRelationship)it.next();
                    if (rel.eventtypeid==eventtypeid){
                        CacheFactory.getCacheProvider().flush(String.valueOf(rel.logid), GROUP);
                        it.remove();
                    }
                }
            }
        } catch (Exception ex){
            Debug.debug(5, "LogCache.java", ex);
        }
    }

    public static Vector allLogsForAccount(int accountid){
        Vector out = new Vector();
        Account acct = AccountCache.get(accountid);
        if (acct!=null){
            ArrayList<Integer> alllogsforaccountid = acct.getAlllogsforaccountid();
            for (Iterator it = alllogsforaccountid.iterator(); it.hasNext(); ) {
                Integer logid = (Integer)it.next();
                Log log = get(logid);
                if (log!=null){
                    out.add(log);
                }
            }
        }
        return out;
    }

    public static boolean doLogsOfThisTypeExist(int eventtypeid){
        if (howManyOfThisTypeExist(eventtypeid)>0){
            return true;
        }
        return false;
    }

    public static int howManyOfThisTypeExist(int eventtypeid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstCount= Db.RunSQL("SELECT count(*) FROM megalog WHERE eventtypeid='"+eventtypeid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstCount!=null && rstCount.length>0){
            return Integer.parseInt(rstCount[0][0]);
        }
        return 0;
    }

    public static Log[] allLogsForAccountAlphabetized(int accountid){
        Log[] out = new Log[0];

        Account acct = AccountCache.get(accountid);
        if (acct!=null){
            //Get a list of logs
            List logList = new ArrayList();
            ArrayList<Integer> alllogsforaccountid = acct.getAlllogsforaccountid();
            for (Iterator it = alllogsforaccountid.iterator(); it.hasNext(); ) {
                Integer logid = (Integer)it.next();
                Log log = get(logid);
                if (log!=null){
                  logList.add(log);
                }
            }

            //Alphabetize them
            Collections.sort(logList, new LogNameComparator());
            out = (Log[]) logList.toArray(new Log[logList.size()]);
        }
        return out;
    }





    private static void handleLogAdd(Log log){
        //Associate with eventtypeid
        logCacheKeyEventtypeidRelationship.add(new LogCacheKeyEventtypeidRelationship(log.getLogid(),log.getEventtypeid()));
        //Associate with megafieldid
        ArrayList<FieldType> fields = log.getFields();
        if (fields!=null){
            for (Iterator it = fields.iterator(); it.hasNext(); ) {
                FieldType fld = (FieldType)it.next();
                logCacheKeyMegafieldidRelationship.add(new LogCacheKeyMegafieldidRelationship(log.getLogid(),fld.getMegafieldid()));
            }
        }
    }















}
