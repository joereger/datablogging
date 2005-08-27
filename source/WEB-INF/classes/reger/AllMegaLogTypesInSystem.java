package reger;

import reger.core.db.Db;
import reger.core.Util;

import java.util.*;

/**
 * Static hold of all logs in system.
 */
public class AllMegaLogTypesInSystem {

    private static Map allMegaLogTypes;

    public AllMegaLogTypesInSystem(){
        if (allMegaLogTypes==null){
            reger.core.Util.debug(5, "AllMegaLogTypesInSystem.java - Refreshing Point1.");
            refresh();
        }
    }

    /**
     * Empties and then refreshes all logs in the system.
     */
    public static void refresh(){
        Util.debug(5, "allMegaLogTypes.refresh().");
        allMegaLogTypes=Collections.synchronizedMap(new HashMap());
        synchronized(allMegaLogTypes){            
            //-----------------------------------
            //-----------------------------------
            String[][] rstLogs= Db.RunSQL("SELECT eventtypeid FROM megalogtype");
            //-----------------------------------
            //-----------------------------------
            if (rstLogs!=null && rstLogs.length>0){
                for(int i=0; i<rstLogs.length; i++){
                    MegaLogType logType = new MegaLogType(Integer.parseInt(rstLogs[i][0]));

                        allMegaLogTypes.put(new Integer(Integer.parseInt(rstLogs[i][0])), logType);

                }
            }
        }
    }

    /**
     * Empties and then refreshes one logtype in the system.
     */
    public static void refresh(int eventtypeid){
        //If it's null, refresh.  Generally won't happen.
        if (allMegaLogTypes==null){
            reger.core.Util.debug(5, "AllMegaLogTypesInSystem.java - Refreshing Point2rfsh.");
            refresh();
        }
        if (eventtypeid>0){
            MegaLogType logType = new MegaLogType(eventtypeid);
            synchronized(allMegaLogTypes){
                allMegaLogTypes.put(new Integer(eventtypeid), logType);
            }
        }

    }

    public static void addLog(MegaLogType megaLogType){
        if (megaLogType.getEventtypeid()>0){
            synchronized(allMegaLogTypes){
                allMegaLogTypes.put(new Integer(megaLogType.getEventtypeid()), megaLogType);
            }
        }
    }

    public static void removeLog(int eventtypeid){
        synchronized(allMegaLogTypes){
            allMegaLogTypes.remove(new Integer(eventtypeid));
        }
    }

    public static MegaLogType getMegaLogTypeByEventtypeid(int eventtypeid){
        //If it's null, refresh.  Generally won't happen.
        if (allMegaLogTypes==null){
            reger.core.Util.debug(5, "AllMegaLogTypesInSystem.java - Refreshing Point2.");
            refresh();
        }

        //See if it contains the logid. Most should get caught here.
        if (allMegaLogTypes.containsKey(new Integer(eventtypeid))){
            return (MegaLogType)allMegaLogTypes.get(new Integer(eventtypeid));
        }

        //Then refresh.
        reger.core.Util.debug(5, "AllMegaLogTypesInSystem.java - Refreshing Point3.");
        refresh();

        //And check again.
        if (allMegaLogTypes.containsKey(new Integer(eventtypeid))){
            return (MegaLogType)allMegaLogTypes.get(new Integer(eventtypeid));
        }

        //If we still don't have it, return null.
        return null;
    }

    public static MegaLogType[] allMegaLogTypesForAccountUser(int accountuserid){
        MegaLogType[] out = new MegaLogType[0];
        if (allMegaLogTypes==null){
            reger.core.Util.debug(5, "AllMegaLogTypesInSystem.java - Refreshing Point4a.");
            refresh();
        }
        
        if (allMegaLogTypes!=null){
            synchronized(allMegaLogTypes){
                for (Iterator i=allMegaLogTypes.entrySet().iterator(); i.hasNext(); ) {
                    Map.Entry e = (Map.Entry) i.next();
                    // retrieve the object_key
                    Integer eventypeid = (Integer) e.getKey();
                    // retrieve the object associated with the key
                    MegaLogType mlt = (MegaLogType) e.getValue();

                    if (mlt.getAccountuserid()==accountuserid){
                        //Add it to the Vector
                        out = AddToArray.addToMegaLogTypeArray(out, mlt);
                    }
                }
            }
        }
        return out;
    }

    public static Vector allMegaLogTypesForPlid(int plid){
        Vector out = new Vector();
        if (allMegaLogTypes==null){
            reger.core.Util.debug(5, "AllMegaLogTypesInSystem.java - Refreshing Point5a.");
            refresh();
        }

        //Retrieve the object associated with the pl
        if (allMegaLogTypes!=null){
            reger.PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(plid);
            for (int i = 0; i < pl.getMegaLogTypes().length; i++) {
                MegaLogType log = (MegaLogType) allMegaLogTypes.get(new Integer(pl.getMegaLogTypes()[i]));
                out.add(log);
            }
        }

        return out;
    }

    public static MegaLogType[] allLogTypesInSystem(){
        MegaLogType[] out = new MegaLogType[0];
        if (allMegaLogTypes==null){
            reger.core.Util.debug(5, "AllMegaLogTypesInSystem.java - Refreshing Point4addd.");
            refresh();
        }

        if (allMegaLogTypes!=null){
            synchronized(allMegaLogTypes){
                for (Iterator i=allMegaLogTypes.entrySet().iterator(); i.hasNext(); ) {
                    Map.Entry e = (Map.Entry) i.next();
                    // retrieve the object_key
                    Integer eventypeid = (Integer) e.getKey();
                    // retrieve the object associated with the key
                    MegaLogType mlt = (MegaLogType) e.getValue();


                    //Add it to the Vector
                    out = AddToArray.addToMegaLogTypeArray(out, mlt);

                }
            }
        }
        return out;
    }



}
