package reger;

import reger.core.db.Db;
import reger.core.Util;

/**
 *
 */
public class ImageOrder {

    public static void moveImageidUp(int imageid, int eventid){

        //First of all, clean your house
        cleanOrderForEventid(eventid);

        //Get the current fieldorder
        int currentorder = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstCurrentFieldorder= Db.RunSQL("SELECT image.order FROM image WHERE imageid='"+imageid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstCurrentFieldorder!=null && rstCurrentFieldorder.length>0){
            if (reger.core.Util.isinteger(rstCurrentFieldorder[0][0])){
        	    currentorder=Integer.parseInt(rstCurrentFieldorder[0][0]);
            }
        }

        //Find the megafield with the order just below this one
        int imageidJustBelow = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstLower= Db.RunSQL("SELECT imageid FROM image WHERE image.order<'"+currentorder+"' ORDER BY image.order DESC LIMIT 0,1");
        //-----------------------------------
        //-----------------------------------
        if (rstLower!=null && rstLower.length>0){
            if (reger.core.Util.isinteger(rstLower[0][0])){
                imageidJustBelow = Integer.parseInt(rstLower[0][0]);
            }
        }

        //Util.logtodb("Ready to swap.<br>currentorder=" + currentorder + "<br>pleventtypeid=" + pleventtypeid + "<br>pleventtypeidJustBelow=" + pleventtypeidJustBelow );

        //If there is one below and the current fieldorder isn't at the top, swap these two
        if (currentorder>0 && imageidJustBelow>0){
            swapOrder(imageid, imageidJustBelow);
        }

    }

    public static void moveImageidDown(int imageid, int eventid){

        //First of all, clean your house
        cleanOrderForEventid(eventid);

        //Get the current fieldorder
        int currentorder = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstCurrentFieldorder= Db.RunSQL("SELECT image.order FROM image WHERE imageid='"+imageid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstCurrentFieldorder!=null && rstCurrentFieldorder.length>0){
            if (reger.core.Util.isinteger(rstCurrentFieldorder[0][0])){
        	    currentorder=Integer.parseInt(rstCurrentFieldorder[0][0]);
            }
        }

        //Find the megafield with the order just below this one
        int imageidJustAbove = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstLower= Db.RunSQL("SELECT imageid FROM image WHERE image.order>'"+currentorder+"' ORDER BY image.order ASC LIMIT 0,1");
        //-----------------------------------
        //-----------------------------------
        if (rstLower!=null && rstLower.length>0){
            if (reger.core.Util.isinteger(rstLower[0][0])){
                imageidJustAbove = Integer.parseInt(rstLower[0][0]);
            }
        }

        //Util.logtodb("Ready to swap.<br>currentorder=" + currentorder + "<br>pleventtypeid=" + pleventtypeid + "<br>pleventtypeidJustAbove=" + pleventtypeidJustAbove );

        //If there is one below and the current fieldorder isn't at the top, swap these two
        if (currentorder>0 && imageidJustAbove>0){
            swapOrder(imageid, imageidJustAbove);
        }

    }



    public static void swapOrder(int imageidA, int imageidB){
        //Util.logtodb("Into swap.<br>pleventtypeidA=" + pleventtypeidA + "<br>pleventtypeidB=" + pleventtypeidB);

        //Get the fieldorder of A
        int orderA = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstFieldA= Db.RunSQL("SELECT image.order FROM image WHERE imageid='"+imageidA+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstFieldA!=null && rstFieldA.length>0){
            if (reger.core.Util.isinteger(rstFieldA[0][0])){
        	    orderA = Integer.parseInt(rstFieldA[0][0]);
            }
        }

        //Get the fieldorder of B
        int orderB = 0;
        //-----------------------------------
        //-----------------------------------
        String[][] rstFieldB= Db.RunSQL("SELECT image.order FROM image WHERE imageid='"+imageidB+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstFieldB!=null && rstFieldB.length>0){
            if (reger.core.Util.isinteger(rstFieldB[0][0])){
        	    orderB = Integer.parseInt(rstFieldB[0][0]);
            }
        }

        //Util.logtodb("Just before == compare.<br>pleventtypeidA=" + pleventtypeidA + "<br>pleventtypeidB=" + pleventtypeidB);

        //If they're both the same then we need to increment B
        if (imageidA == imageidB){
            imageidB=imageidB + 1;
        }

        //Update A
        //-----------------------------------
        //-----------------------------------
        int countA = Db.RunSQLUpdate("UPDATE image SET image.order='"+orderB+"' WHERE imageid='"+imageidA+"'");
        //-----------------------------------
        //-----------------------------------

        //Update B
        //-----------------------------------
        //-----------------------------------
        int countB = Db.RunSQLUpdate("UPDATE image SET image.order='"+orderA+"' WHERE imageid='"+imageidB+"'");
        //-----------------------------------
        //-----------------------------------
    }

    /**
     * Use this method when creating a new megafield and you want to know what fieldorder to assign to it.
     * @param eventid
     * @return
     */
    public static int getOrderForNewImage(int eventid){
        //Get the max order in there now
        int max = 1;
        //-----------------------------------
        //-----------------------------------
        String[][] rstMax= Db.RunSQL("SELECT MAX(image.order) FROM image, event WHERE image.eventid=event.eventid AND event.eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstMax!=null && rstMax.length>0 && Util.isinteger(rstMax[0][0])){
            if (reger.core.Util.isinteger(rstMax[0][0])){
                max = Integer.parseInt(rstMax[0][0]) + 1;
            }
        }
        return max;
    }

    /**
     * Clean out any empty spaces and duplicate fieldorders for a given eventtype
     */
    public static void cleanOrderForEventid(int eventid){
        //Select all fields
        int count = 1;
        //-----------------------------------
        //-----------------------------------
        String[][] rstFields= Db.RunSQL("SELECT imageid, image.order FROM image WHERE eventid='"+eventid+"' ORDER BY image.order ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstFields!=null && rstFields.length>0){
        	for(int i=0; i<rstFields.length; i++){
                //Now update each megafield with a contiguous order scheme
                //-----------------------------------
                //-----------------------------------
                int bloo = Db.RunSQLUpdate("UPDATE image SET image.order='"+count+"' WHERE imageid='"+rstFields[i][0]+"'");
                //-----------------------------------
                //-----------------------------------

        	    //Increment the counter
                count=count+1;
        	}
        }
    }

}
