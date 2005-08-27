package reger;

import reger.core.db.Db;
import reger.core.Util;

import java.util.*;

/**
 * Static hold of all logs in system.
 */
public class AllPrivateLabelsInSystem {

    private static Map allPrivateLabels;

    public AllPrivateLabelsInSystem(){
        if (allPrivateLabels==null){
            refresh();
        }
    }

    /**
     * Empties and then refreshes all logs in the system.
     */
    public static void refresh(){
        Util.debug(5, "AllPrivateLabelsInSystem.refresh().");
        allPrivateLabels=Collections.synchronizedMap(new HashMap());
        synchronized(allPrivateLabels){
            //-----------------------------------
            //-----------------------------------
            String[][] rstPl= Db.RunSQL("SELECT plid FROM pl");
            //-----------------------------------
            //-----------------------------------
            if (rstPl!=null && rstPl.length>0){
                for(int i=0; i<rstPl.length; i++){
                    PrivateLabel pl = new PrivateLabel(Integer.parseInt(rstPl[i][0]));
                    allPrivateLabels.put(new Integer(Integer.parseInt(rstPl[i][0])), pl);
                }
            }
        }
    }

    public static PrivateLabel[] getAllPrivateLabels(){
        PrivateLabel[] pls = new PrivateLabel[0];
        for (Iterator i=allPrivateLabels.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry e = (Map.Entry) i.next();
            //e.getKey()
            //e.getValue()
            pls = AddToArray.addToPrivateLabelArray(pls, (PrivateLabel)e.getValue() );
        }
        return pls;
    }



    public static PrivateLabel getPrivateLabel(int plid){
        //If it's null, refresh.  Generally won't happen.
        if (allPrivateLabels==null){
            refresh();
        }

        //See if it contains the logid. Most should get caught here.
        if (allPrivateLabels.containsKey(new Integer(plid))){
            return (PrivateLabel)allPrivateLabels.get(new Integer(plid));
        }

        //Then refresh.
        refresh();

        //And check again.
        if (allPrivateLabels.containsKey(new Integer(plid))){
            return (PrivateLabel)allPrivateLabels.get(new Integer(plid));
        }

        //If we still don't have it, return the default pl.
        return new PrivateLabel(reger.Vars.PLIDDEFAULT);
    }



}
