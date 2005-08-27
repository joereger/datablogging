package reger;

import reger.mega.FieldType;
import reger.core.db.Db;
import reger.core.Util;

import java.util.*;

/**
 * Static hold of all logs in system.
 */
public class AllLogsInSystem {

    private static Map allLogs;

    public AllLogsInSystem(){
        if (allLogs==null){
            reger.core.Util.debug(5, "AllLogsInSystem.java - Refreshing Point4.");
            refresh();
        }
    }

    /**
     * Empties and then refreshes all logs in the system.
     */
    public static void refresh(){
        reger.core.Util.debug(5, "AllLogsInSystem.refresh().");
        allLogs = Collections.synchronizedMap(new HashMap());
        synchronized(allLogs){

            //First, figure out how many there are in the system
            int numberInSystem = 0;
            //-----------------------------------
            //-----------------------------------
            String[][] rstCount= Db.RunSQL("SELECT count(*) FROM megalog");
            //-----------------------------------
            //-----------------------------------
            if (rstCount!=null && rstCount.length>0){
                numberInSystem = Integer.parseInt(rstCount[0][0]);
            }


            //-----------------------------------
            //-----------------------------------
            String[][] rstLogs= Db.RunSQL("SELECT logid FROM megalog", numberInSystem+1);
            //-----------------------------------
            //-----------------------------------
            int count = 0;
            if (rstLogs!=null && rstLogs.length>0){
                for(int i=0; i<rstLogs.length; i++){
                    reger.Log log = new reger.Log(Integer.parseInt(rstLogs[i][0]));

                        allLogs.put(new Integer(Integer.parseInt(rstLogs[i][0])), log);

                    count = count + 1;
                }

            }

        }

        reger.core.Util.debug(5, "Added Logs to AllLogsInSystem.<br>allLogs.size()="+allLogs.size());
    }

    /**
     * Empties and then refreshes all logs in the system.
     */
    public static void refresh(int logid){
        reger.core.Util.debug(5, "AllLogsInSystem.refresh(logid="+logid+").");
        //If it's null, refresh.  Generally won't happen.
        if (allLogs==null){
            reger.core.Util.debug(5, "AllLogsInSystem.java - Refreshing Point1reflogid.");
            refresh();
        }



        if (allLogs!=null){
            //Remove any existing value
            synchronized(allLogs){
                allLogs.remove(new Integer(logid));
            }

            //-----------------------------------
            //-----------------------------------
            String[][] rstLogs= Db.RunSQL("SELECT logid FROM megalog WHERE logid='"+logid+"'");
            //-----------------------------------
            //-----------------------------------
            int count = 0;
            if (rstLogs!=null && rstLogs.length>0){
                for(int i=0; i<rstLogs.length; i++){
                    reger.Log log = new reger.Log(Integer.parseInt(rstLogs[i][0]));
                    synchronized(allLogs){
                        allLogs.put(new Integer(Integer.parseInt(rstLogs[i][0])), log);
                    }
                    reger.core.Util.debug(5, "Updated Logid="+logid+" to AllLogsInSystem.<br>allLogs.size()="+allLogs.size());
                }

            }
        }


    }


    public static void addLog(reger.Log log){
        if (log.getLogid()>0){
            synchronized(allLogs){
                allLogs.put(new Integer(log.getLogid()), log);
            }
        }

    }

    public static void removeLog(int logid){
        synchronized(allLogs){
            allLogs.remove(new Integer(logid));
        }
    }

    public static Log getLogByLogid(int logid){
        //If it's null, refresh.  Generally won't happen.
        if (allLogs==null){
            reger.core.Util.debug(5, "AllLogsInSystem.java - Refreshing Point1.");
            refresh();
        }

        //See if it contains the logid. Most should get caught here.
        if (allLogs.containsKey(new Integer(logid))){
            return (Log)allLogs.get(new Integer(logid));
        }

        //Then refresh.
        reger.core.Util.debug(5, "AllLogsInSystem.java - Refreshing Point2.");
        refresh();

        //And check again.
        if (allLogs.containsKey(new Integer(logid))){
            return (Log)allLogs.get(new Integer(logid));
        }

        //If we still don't have it, return null.
        return null;
    }

    public static void refreshLogsThatUseGivenMegafieldid(int megafieldid){
        Util.debug(5, "AllLogsInSystem.refreshLogsThatUseGivenMegafieldid(megafieldid="+megafieldid+").");
        //If it's null, refresh.  Generally won't happen.
        if (allLogs==null){
            reger.core.Util.debug(5, "AllLogsInSystem.java - Refreshing Point1asd.");
            refresh();
        }

        //See if it contains the logid. Most should get caught here.
        if (allLogs!=null){
            synchronized(allLogs){
                for (Iterator i=allLogs.entrySet().iterator(); i.hasNext(); ) {
                    Map.Entry e = (Map.Entry) i.next();
                    //out.println(e.getKey() + ": " + e.getValue());
                    //Get each log
                    Log log = (Log)e.getValue();
                    //reger.core.Util.debug(5, "AllLogsInSystem.java - refreshing by megafieldid.  <br>log=" + log.getName() + "<br>logid="+log.getLogid());
                    if (log!=null){
                        //Get the fields from the log
                        FieldType[] fields = log.getFields();
                        if (fields!=null){
                            for (int j = 0; j < fields.length; j++) {
                                //reger.core.Util.debug(5, "AllLogsInSystem.java - analyzing field.  <br>log=" + log.getName() + "<br>logid="+log.getLogid()+"<br>megafieldid=" + fields[j].getMegafieldid() + "<br>looking for megafieldid=" + megafieldid);
                                //If one of the fields has this megafieldid, refresh it
                                if(fields[j].getMegafieldid()==megafieldid){
                                    //Do the refresh
                                    log.load(log.getLogid());
                                    //Put it back into the Hashmap
                                    allLogs.put(new Integer(log.getLogid()), log);
                                }
                            }
                        }
                    }
                }
            }
        }


    }

    public static void refreshLogsThatUseGivenEventtypeid(int eventtypeid){
        Util.debug(5, "AllLogsInSystem.refreshLogsThatUseGivenEventtypeid(eventtypeid="+eventtypeid+").");
        //If it's null, refresh.  Generally won't happen.
        if (allLogs==null){
            reger.core.Util.debug(5, "AllLogsInSystem.java - Refreshing Point1asd.");
            refresh();
        }

        if (allLogs!=null){
            synchronized(allLogs){
                for (Iterator i=allLogs.entrySet().iterator(); i.hasNext(); ) {
                    Map.Entry e = (Map.Entry) i.next();
                    //out.println(e.getKey() + ": " + e.getValue());
                    //Get each log
                    Log log = (Log)e.getValue();
                    //reger.core.Util.debug(5, "AllLogsInSystem.java - refreshing by megafieldid.  <br>log=" + log.getName() + "<br>logid="+log.getLogid());
                    if (log!=null){
                        if(log.getEventtypeid()==eventtypeid){
                            //Do the refresh
                            log.load(log.getLogid());
                            //Put it back into the Hashmap
                            allLogs.put(new Integer(log.getLogid()), log);
                        }

                    }

                }
            }
        }


    }

    public static Vector allLogsForAccount(int accountid){
        Vector out = new Vector();
        if (allLogs==null){
            reger.core.Util.debug(5, "AllLogsInSystem.java - Refreshing Point3.");
            refresh();
        }

        if (allLogs!=null){
            synchronized(allLogs){
                for (Iterator i=allLogs.entrySet().iterator(); i.hasNext(); ) {
                    Map.Entry e = (Map.Entry) i.next();
                    Log log = (Log) e.getValue();
                    if (log.getAccountid()==accountid){
                        out.add(log);
                    }
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
        if (allLogs==null){
            reger.core.Util.debug(5, "AllLogsInSystem.java - Refreshing Point8.");
            refresh();
        }

        int count = 0;

        if (allLogs!=null){
            synchronized(allLogs){
                for (Iterator i=allLogs.entrySet().iterator(); i.hasNext(); ) {
                    Map.Entry e = (Map.Entry) i.next();
                    Log log = (Log) e.getValue();
                    if (log.getEventtypeid()==eventtypeid){
                        count = count + 1;
                    }
                }
            }
        }

        return count;
    }

    public static Log[] allLogsForAccountAlphabetized(int accountid){
        if (allLogs==null){
            reger.core.Util.debug(5, "AllLogsInSystem.java - Refreshing Point3gggd.");
            refresh();
        }

        Log[] out = new Log[0];

        if (allLogs!=null){
            //Create a HashMap
            //HashMap hmap = new HashMap();
            List logList = new ArrayList();

            if (allLogs!=null){
                synchronized(allLogs){
                    for (Iterator i=allLogs.entrySet().iterator(); i.hasNext(); ) {
                        Map.Entry e = (Map.Entry) i.next();
                        Log log = (Log) e.getValue();
                        if (log.getAccountid()==accountid){
                            logList.add(log);
                        }
                    }
                }
            }


            //Alphabetize
            Collections.sort(logList, new LogNameComparator());
            out = (Log[]) logList.toArray(new Log[logList.size()]);
        }


        return out;
    }

}
