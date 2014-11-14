package reger.mega;

import reger.core.db.Db;

import javax.servlet.http.HttpServletRequest;
import java.util.TreeMap;

/**
 * Simple storage method puts data into DB in simple megavalue table
 */
public class FieldDAOSimple implements FieldDAO{

    //This is the format of the data
    String value = "";


    public void saveData(int megafieldid, int eventid, int logid) {
        if (!value.equals("")){

            //First, delete any existing value
            //-----------------------------------
            //-----------------------------------
            int identityDel = Db.RunSQLInsert("DELETE FROM megavalue WHERE eventid='"+eventid+"' AND megafieldid='"+megafieldid+"'");
            //-----------------------------------
            //-----------------------------------

            //Now, write to the megavalue table
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO megavalue(megafieldid, eventid, megavalue) VALUES('"+megafieldid+"', '"+eventid+"', '"+reger.core.Util.cleanForSQL(value)+"')");
            //-----------------------------------
            //-----------------------------------

        } else {
            //Delete any existing value because the one we want to store is blank
            //-----------------------------------
            //-----------------------------------
            int identityDel = Db.RunSQLInsert("DELETE FROM megavalue WHERE eventid='"+eventid+"' AND megafieldid='"+megafieldid+"'");
            //-----------------------------------
            //-----------------------------------
        }
    }

    public void saveDefaultData(int megafieldid, int logid) {
        if (!value.equals("")){

            //First, delete any existing value
            //-----------------------------------
            //-----------------------------------
            int identityDel = Db.RunSQLInsert("DELETE FROM megadefault WHERE logid='"+logid+"' AND megafieldid='"+megafieldid+"'");
            //-----------------------------------
            //-----------------------------------

            //Now, write to the megavalue table
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO megadefault(megafieldid, logid, megadefault) VALUES('"+megafieldid+"', '"+logid+"', '"+reger.core.Util.cleanForSQL(this.value)+"')");
            //-----------------------------------
            //-----------------------------------

        } else {
            //First, delete any existing value
            //-----------------------------------
            //-----------------------------------
            int identityDel = Db.RunSQLInsert("DELETE FROM megadefault WHERE logid='"+logid+"' AND megafieldid='"+megafieldid+"'");
            //-----------------------------------
            //-----------------------------------
        }
    }

    public void loadData(int megafieldid, int eventid, int logid) {

        //Get the value for this eventid
        //-----------------------------------
        //-----------------------------------
        String[][] rstVal= Db.RunSQL("SELECT megavalue FROM megavalue WHERE megavalue.eventid='"+eventid+"' AND megavalue.megafieldid='"+megafieldid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstVal!=null && rstVal.length>0){
        	for(int i=0; i<rstVal.length; i++){
        	    reger.core.Debug.debug(5, "FieldDAOSinple.java", "Value is set from DB for<br>megafieldid=" + megafieldid +"<br>value=" + rstVal[i][0]);
                value = rstVal[i][0];
        	}
        }  else {
            reger.core.Debug.debug(5, "FieldDAOSinple.java", "No value found in DB for<br>megafieldid=" + megafieldid);
        }

    }

    public void loadDefaultData(int megafieldid, int logid) {
        //Get the default value for this logid
        //-----------------------------------
        //-----------------------------------
        String[][] rstVal= Db.RunSQL("SELECT megadefault FROM megadefault WHERE megadefault.logid='"+logid+"' AND megadefault.megafieldid='"+megafieldid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstVal!=null && rstVal.length>0){
        	for(int i=0; i<rstVal.length; i++){
                value = rstVal[i][0];
        	}
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TreeMap loadDataForMultipleEvents(int[] eventids, Field field) {
       //Only go to DB if we have a list of eventids
       if (eventids.length>0){
            //Build Where Clause
            StringBuffer whereClause = new StringBuffer();
            whereClause.append("event.eventid IN(");
            for (int i = 0; i < eventids.length; i++) {
                whereClause.append(eventids[i]);
                if (i<eventids.length-1){
                    whereClause.append(",");
                }
            }
            whereClause.append(")");

            //TreeMap to hold data
            TreeMap data = new TreeMap();

            //-----------------------------------
            //-----------------------------------
            String[][] rstEvents= Db.RunSQL("SELECT event.eventid, megavalue.megavalue FROM event, megavalue WHERE event.eventid=megavalue.eventid AND megafieldid='"+field.megafieldid+"' AND " + whereClause);
            //-----------------------------------
            //-----------------------------------
            if (rstEvents!=null && rstEvents.length>0){
                for(int i=0; i<rstEvents.length; i++){
                    //Make sure that the data is added to the TreeMap in the correct type.
                    Object val = null;
                    if (reger.core.Util.isinteger(rstEvents[i][1])){
                        val = new Integer(rstEvents[i][1]);
                    } else if (reger.core.Util.isnumeric(rstEvents[i][1])){
                        val = new Double(rstEvents[i][1]);
                    } else {
                        val = rstEvents[i][1];
                    }
                    data.put(rstEvents[i][0], val);
                }
            }
            //Return the treemap with the data
            return data;
       } else {
           return new TreeMap();
       }

    }

    /**
     * Deletes data for a particular eventid.
     */
    public void deleteData(int megafieldid, int eventid) {
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM megavalue WHERE megafieldid='"+megafieldid+"' AND eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
    }

    /**
     * Move to new logid.  Some data storage methods, like
     * megaoption have a logid dependency.  Some don't.
     */
    public void moveDataToNewLogid(int megafieldid, int eventid, int oldlogid, int newlogid) {
        //Nothing to do here.
    }

    /**
     * Move to new eventid.  All data will be moved.
     * Note that all data in the destination that currently exists will be deleted and then overwritten.
     */
    public void moveDataToNewEventid(int megafieldid, int sourceeventid, int desteventid) {
        //First, delete data for the destination eventid
        deleteData(megafieldid, desteventid);
        //Next, move the data from source to the dest
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE megavalue SET eventid='"+desteventid+"' WHERE eventid='"+sourceeventid+"' AND megafieldid='"+megafieldid+"'");
        //-----------------------------------
        //-----------------------------------
    }

    /**
     * Copy to new eventid.  All data will be copied.  The sourceeventid will still have the data.
     */
    public void copyDataToNewEventid(int megafieldid, int sourceeventid, int desteventid) {
        //Select data
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megavalue FROM megavalue WHERE eventid='"+sourceeventid+"' AND megafieldid='"+megafieldid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
        	for(int i=0; i<rstData.length; i++){
        	    //Create new entries for the data and attach it to the new eventid
        	    //-----------------------------------
        	    //-----------------------------------
        	    int identity = Db.RunSQLInsert("INSERT INTO megavalue(megafieldid, eventid, megavalue) VALUES('"+megafieldid+"', '"+desteventid+"', '"+reger.core.Util.cleanForSQL(rstData[i][0])+"')");
        	    //-----------------------------------
        	    //-----------------------------------
        	}
        }
    }

    /**
     * Deletes data for a. entire megafieldid.  Very dangerous!
     */
    public void deleteAllDataForAFieldAcrossAllLogsAndEntries(int megafieldid) {
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM megavalue WHERE megafieldid='"+megafieldid+"'");
        //-----------------------------------
        //-----------------------------------
    }

    /**
     * Fields can have default system values and options (data) that stay with
     * them for all users.  This data is setup with the logtype (not log) on
     * logs-field.log.  The type of data that can be stored is dependent
     * on the FieldDAO that is used for the FieldType.
     * So, this method in FieldType is little more than a way to pass the request to FieldDAO
     * which will send back a string of HTML to pass to the screen.  All
     * configurations must be done with a simple request form back and forth.
     * Form elements will ne named "systemconfig-*" to avoid collission. Only
     * one FieldType's similar method will be called and displayed on a form at
     * any given time.
     */
    public String processSystemDefaultDataConfig(HttpServletRequest request, int megafieldid) {
        return "";
    }

    /**
     * Whether or not any data exists in the database for this megafieldid.
     * This is a precursor to either deletion or hiding
     */
    public boolean isThereDataForFieldInDB(int megafieldid) {
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT count(*) FROM megavalue WHERE megafieldid='"+megafieldid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
        	if (Integer.parseInt(rstData[0][0])>0){
                return true;
            }
        }
        return false;
    }


}
