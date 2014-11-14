package reger;

import reger.core.db.Db;

/**
 *
 */
public class PlEventtypeOrder {

    public static void moveEventtypeidUp(int plid, int pleventtypeid){

        //First of all, clean your house
        cleanFieldorderForEventtype(plid);

        //Get the current fieldorder
        int currentorder = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstCurrentFieldorder= Db.RunSQL("SELECT priority FROM pleventtypeid WHERE pleventtypeid='"+pleventtypeid+"' AND plid='"+plid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstCurrentFieldorder!=null && rstCurrentFieldorder.length>0){
        	currentorder=Integer.parseInt(rstCurrentFieldorder[0][0]);
        }

        //Find the megafield with the order just below this one
        int pleventtypeidJustBelow = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstLower= Db.RunSQL("SELECT pleventtypeid FROM pleventtypeid WHERE priority<'"+currentorder+"' AND plid='"+plid+"' ORDER BY priority DESC LIMIT 0,1");
        //-----------------------------------
        //-----------------------------------
        if (rstLower!=null && rstLower.length>0){
            pleventtypeidJustBelow = Integer.parseInt(rstLower[0][0]);
        }

        //If there is one below and the current fieldorder isn't at the top, swap these two
        if (currentorder>0 && pleventtypeidJustBelow>0){
            swapFieldOrder(pleventtypeid, pleventtypeidJustBelow);
        }

    }

    public static void moveEventtypeidDown(int plid, int pleventtypeid){

        //First of all, clean your house
        cleanFieldorderForEventtype(plid);

        //Get the current fieldorder
        int currentorder = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstCurrentFieldorder= Db.RunSQL("SELECT priority FROM pleventtypeid WHERE pleventtypeid='"+pleventtypeid+"' AND plid='"+plid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstCurrentFieldorder!=null && rstCurrentFieldorder.length>0){
        	currentorder=Integer.parseInt(rstCurrentFieldorder[0][0]);
        }

        //Find the megafield with the order just below this one
        int pleventtypeidJustAbove = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstLower= Db.RunSQL("SELECT pleventtypeid FROM pleventtypeid WHERE priority>'"+currentorder+"' AND plid='"+plid+"' ORDER BY priority ASC LIMIT 0,1");
        //-----------------------------------
        //-----------------------------------
        if (rstLower!=null && rstLower.length>0){
            pleventtypeidJustAbove = Integer.parseInt(rstLower[0][0]);
        }


        //If there is one below and the current fieldorder isn't at the top, swap these two
        if (currentorder>0 && pleventtypeidJustAbove>0){
            swapFieldOrder(pleventtypeid, pleventtypeidJustAbove);
        }

    }



    public static void swapFieldOrder(int pleventtypeidA, int pleventtypeidB){
        //Get the fieldorder of A
        int orderA = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstFieldA= Db.RunSQL("SELECT priority FROM pleventtypeid WHERE pleventtypeid='"+pleventtypeidA+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstFieldA!=null && rstFieldA.length>0){
        	orderA = Integer.parseInt(rstFieldA[0][0]);
        }

        //Get the fieldorder of B
        int orderB = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstFieldB= Db.RunSQL("SELECT priority FROM pleventtypeid WHERE pleventtypeid='"+pleventtypeidB+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstFieldB!=null && rstFieldB.length>0){
        	orderB = Integer.parseInt(rstFieldB[0][0]);
        }

        //If they're both the same then we need to increment B
        if (pleventtypeidA == pleventtypeidB){
            pleventtypeidB=pleventtypeidB + 1;
        }

        //Update A
        //-----------------------------------
        //-----------------------------------
        int countA = Db.RunSQLUpdate("UPDATE pleventtypeid SET priority='"+orderB+"' WHERE pleventtypeid='"+pleventtypeidA+"'");
        //-----------------------------------
        //-----------------------------------

        //Update B
        //-----------------------------------
        //-----------------------------------
        int countB = Db.RunSQLUpdate("UPDATE pleventtypeid SET priority='"+orderA+"' WHERE pleventtypeid='"+pleventtypeidB+"'");
        //-----------------------------------
        //-----------------------------------
    }

    /**
     * Use this method when creating a new megafield and you want to know what fieldorder to assign to it.
     * @param plid
     * @return
     */
    public static int getPriorityForNewField(int plid){
        //Get the max order in there now
        int max = 1;
        //-----------------------------------
        //-----------------------------------
        String[][] rstMax= Db.RunSQL("SELECT MAX(priority) FROM pleventtypeid WHERE plid='"+plid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstMax!=null && rstMax.length>0 && reger.core.Util.isinteger(rstMax[0][0])){
            max = Integer.parseInt(rstMax[0][0]) + 1;
        }
        return max;
    }

    /**
     * Clean out any empty spaces and duplicate fieldorders for a given eventtype
     */
    public static void cleanFieldorderForEventtype(int plid){
        //Select all fields
        int count = 1;
        //-----------------------------------
        //-----------------------------------
        String[][] rstFields= Db.RunSQL("SELECT pleventtypeid, priority FROM pleventtypeid WHERE plid='"+plid+"' ORDER BY priority ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstFields!=null && rstFields.length>0){
        	for(int i=0; i<rstFields.length; i++){
                //Now update each megafield with a contiguous order scheme
                //-----------------------------------
                //-----------------------------------
                int bloo = Db.RunSQLUpdate("UPDATE pleventtypeid SET priority='"+count+"' WHERE pleventtypeid='"+rstFields[i][0]+"'");
                //-----------------------------------
                //-----------------------------------

        	    //Increment the counter
                count=count+1;
        	}
        }
    }

}
