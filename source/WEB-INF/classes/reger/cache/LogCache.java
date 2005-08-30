package reger.cache;

import reger.Log;
import reger.LogNameComparator;
import reger.Account;
import reger.core.Util;
import reger.core.db.Db;
import reger.mega.FieldType;
import com.opensymphony.oscache.general.GeneralCacheAdministrator;
import com.opensymphony.oscache.base.NeedsRefreshException;

import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Caches Account objects using OSCache
 */
public class LogCache {

    private static GeneralCacheAdministrator admin;


    public static Log get(int logid){
        reger.core.Util.debug(4, "LogCache.get("+logid+") called.");
        if (admin==null){
            admin = new GeneralCacheAdministrator();
        }

        try {
            reger.core.Util.debug(4, "LogCache.get("+logid+") trying to return from cache.");
            return (Log) admin.getFromCache(String.valueOf(logid));
        } catch (NeedsRefreshException nre) {
            try {
                reger.core.Util.debug(4, "LogCache.get("+logid+") refreshing object from database.");
                Log log = new Log(logid);
                //Create groups for megafieldid and eventtypeid usage
                String[] groups = new String[0];
                groups = reger.AddToArray.addToStringArray(groups, "eventtypeid"+log.getEventtypeid());
                FieldType[] fields = log.getFields();
                if (fields!=null){
                    for (int i = 0; i < fields.length; i++) {
                        groups = reger.AddToArray.addToStringArray(groups, "megafieldid"+fields[i].getMegafieldid());
                    }
                }
                //Put it in the cache and group
                admin.putInCache(String.valueOf(logid), log, groups);
                return log;
            } catch (Exception ex) {
                admin.cancelUpdate(String.valueOf(logid));
                reger.core.Util.errorsave(ex);
                return new Log(0);
            }
        }
    }

    public static void flushAll(){
        if (admin!=null){
            admin.flushAll();
        }
    }

    public static void flushByLogid(int logid){
        if (admin!=null){
            admin.flushEntry(String.valueOf(logid));
        }
    }

    public static void flushByMegafieldid(int megafieldid){
        if (admin!=null){
            admin.flushGroup("megafieldid"+megafieldid);
        }
    }

    public static void flushByEventtypeid(int eventtypeid){
        if (admin!=null){
            admin.flushGroup("eventtypeid"+eventtypeid);
        }
    }

    public static Vector allLogsForAccount(int accountid){
        Vector out = new Vector();
        Account acct = AccountCache.get(accountid);
        if (acct!=null){
            int[] alllogsforaccountid = acct.getAllLogids();
            for (int i = 0; i < alllogsforaccountid.length; i++) {
              Log log = get(alllogsforaccountid[i]);
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
            int[] alllogsforaccountid = acct.getAllLogids();
            for (int i = 0; i < alllogsforaccountid.length; i++) {
                Log log = get(alllogsforaccountid[i]);
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



}
