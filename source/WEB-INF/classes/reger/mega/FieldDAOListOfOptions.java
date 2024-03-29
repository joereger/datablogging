package reger.mega;

import reger.core.db.Db;
import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;
import java.util.TreeMap;
import java.util.ArrayList;

/**
 * Simple storage method puts data into DB in simple megavalue table
 */
public class FieldDAOListOfOptions implements FieldDAO{

    //This is the format of the data
    String value = "";
    ArrayList<String> possibleValues = new ArrayList<String>();


    public void saveData(int megafieldid, int eventid, int logid) {
        if (!value.equals("")){
            int myidentity = -1;
            //See if this option already exists
            //-----------------------------------
            //-----------------------------------
            String[][] rstOpts= reger.core.db.Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE (logid='"+ logid +"' || logid='0') AND megafieldid='"+ megafieldid +"' AND optiontext='"+ reger.core.Util.cleanForSQL(value) +"'");
            //-----------------------------------
            //-----------------------------------
            if(rstOpts!=null && rstOpts.length>0){
                myidentity = Integer.parseInt(rstOpts[0][0]);
            } else {
                //-----------------------------------
                //-----------------------------------
                myidentity = reger.core.db.Db.RunSQLInsert("INSERT INTO megaoption(logid, megafieldid, optiontext, isdefault, isactive) VALUES('"+ logid +"', '"+ megafieldid +"', '"+ reger.core.Util.cleanForSQL(value) +"', '0', '1')");
                //-----------------------------------
                //-----------------------------------
            }

            //First, delete any existing value
            //-----------------------------------
            //-----------------------------------
            int identityDel = Db.RunSQLInsert("DELETE FROM megavalue WHERE eventid='"+eventid+"' AND megafieldid='"+megafieldid+"'");
            //-----------------------------------
            //-----------------------------------

            //Now, write to the megavalue table
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO megavalue(megafieldid, eventid, megavalue) VALUES('"+megafieldid+"', '"+eventid+"', '"+myidentity+"')");
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
            int myidentity = -1;
            //See if this option already exists
            //-----------------------------------
            //-----------------------------------
            String[][] rstOpts= reger.core.db.Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE (logid='"+ logid +"' || logid='0') AND megafieldid='"+ megafieldid +"' AND optiontext='"+ reger.core.Util.cleanForSQL(value) +"'");
            //-----------------------------------
            //-----------------------------------
            if(rstOpts!=null && rstOpts.length>0){
                myidentity = Integer.parseInt(rstOpts[0][0]);
            } else {
                //-----------------------------------
                //-----------------------------------
                myidentity = reger.core.db.Db.RunSQLInsert("INSERT INTO megaoption(logid, megafieldid, optiontext, isdefault, isactive) VALUES('"+ logid +"', '"+ megafieldid +"', '"+ reger.core.Util.cleanForSQL(value) +"', '0', '1')");
                //-----------------------------------
                //-----------------------------------
            }

            //First, delete any existing value
            //-----------------------------------
            //-----------------------------------
            int identityDel = Db.RunSQLInsert("DELETE FROM megadefault WHERE logid='"+logid+"' AND megafieldid='"+megafieldid+"'");
            //-----------------------------------
            //-----------------------------------

            //Now, write to the megavalue table
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO megadefault(megafieldid, logid, megadefault) VALUES('"+megafieldid+"', '"+logid+"', '"+myidentity+"')");
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
        //Get possible values
        loadPossibleValues(megafieldid, logid);
        //Get the value for this eventid
        //-----------------------------------
        //-----------------------------------
        String[][] rstVal= Db.RunSQL("SELECT megaoption.megaoptionid, optiontext FROM megavalue, megaoption WHERE megavalue.megavalue=megaoption.megaoptionid AND megavalue.eventid='"+eventid+"' AND megavalue.megafieldid='"+megafieldid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstVal!=null && rstVal.length>0){
            for(int i=0; i<rstVal.length; i++){
                Debug.debug(5, "", "Value is set for<br>megafieldid=" + megafieldid +"<br>value=" + rstVal[i][1]);
                value = rstVal[i][1];
            }
        }

    }

    public void loadDefaultData(int megafieldid, int logid) {
        //Get possible values
        loadPossibleValues(megafieldid, logid);
        //Get the default value for this logid
        //-----------------------------------
        //-----------------------------------
        String[][] rstVal= Db.RunSQL("SELECT megaoption.megaoptionid, optiontext FROM megadefault, megaoption WHERE megadefault.megadefault=megaoption.megaoptionid AND megadefault.logid='"+logid+"' AND megadefault.megafieldid='"+megafieldid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstVal!=null && rstVal.length>0){
            for(int i=0; i<rstVal.length; i++){
                value = rstVal[i][1];
            }
        }
    }

    public void loadPossibleValues(int megafieldid, int logid){
        Debug.debug(5, "", "FieldDAOListOfOptions.loadPossibleValues() - megafieldid=" + megafieldid);
        //Get possible values, only those that are active
        //-----------------------------------
        //-----------------------------------
        String[][] rstOpts= Db.RunSQL("SELECT optiontext FROM megaoption WHERE (logid='"+ logid +"' || logid<=0) AND megafieldid='"+ megafieldid +"' AND isactive<>'0' ORDER BY optiontext ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstOpts!=null && rstOpts.length>0){
            for(int i=0; i<rstOpts.length; i++){
                Debug.debug(5, "", "FieldDAOListOfOptions.loadPossibleValues() - adding possiblevalue=" + rstOpts[i][0]);
                possibleValues.add(rstOpts[i][0]);
            }
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayList<String> getPossibleValues() {
        return possibleValues;
    }

    public TreeMap loadDataForMultipleEvents(int[] eventids, Field field) {
        //Only go to DB if we have a list of eventids
       if (eventids.length>0){
            //Build Where Clause
            StringBuffer whereClause = new StringBuffer();
            whereClause.append("eventid IN(");
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
            String[][] rstVal= Db.RunSQL("SELECT megavalue.eventid, megaoption.optiontext FROM megavalue, megaoption WHERE megavalue.megavalue=megaoption.megaoptionid AND megavalue.megafieldid='"+field.megafieldid+"' AND megavalue." + whereClause);
            //-----------------------------------
            //-----------------------------------
            if (rstVal!=null && rstVal.length>0){
                for(int i=0; i<rstVal.length; i++){
                    //Make sure that the data is added to the TreeMap in the correct type.
                    Object val = null;
                    if (reger.core.Util.isinteger(rstVal[i][1])){
                        val = new Integer(rstVal[i][1]);
                    } else if (reger.core.Util.isnumeric(rstVal[i][1])){
                        val = new Double(rstVal[i][1]);
                    } else {
                        val = rstVal[i][1];
                    }
                    data.put(rstVal[i][0], val);
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
        //@todo I don't check to see if the old log, after moving this data, is without an eventid for this option.  I should delete such orphans.
        //-----------------------------------
        //-----------------------------------
        String[][] rstVal= Db.RunSQL("SELECT megaoption.megaoptionid, optiontext FROM megavalue, megaoption WHERE megavalue.megavalue=megaoption.megaoptionid AND megavalue.eventid='"+eventid+"' AND megavalue.megafieldid='"+megafieldid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstVal!=null && rstVal.length>0){
            for(int i=0; i<rstVal.length; i++){
                //The value we're looking for
                String val = rstVal[i][1];

                //This will be the new identity
                int myidentity = -1;

                //Add this option to the new logid
                //See if this option already exists in the new log
                //-----------------------------------
                //-----------------------------------
                String[][] rstOpts= reger.core.db.Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE logid='"+ newlogid +"' AND megafieldid='"+ megafieldid +"' AND optiontext='"+ reger.core.Util.cleanForSQL(val) +"'");
                //-----------------------------------
                //-----------------------------------
                if(rstOpts!=null && rstOpts.length>0){
                    //This option already exists, so we can use this new identity
                    myidentity = Integer.parseInt(rstOpts[0][0]);
                } else {
                    //Need to create a new option in the new logid
                    //-----------------------------------
                    //-----------------------------------
                    myidentity = reger.core.db.Db.RunSQLInsert("INSERT INTO megaoption(logid, megafieldid, optiontext, isdefault, isactive) VALUES('"+ newlogid +"', '"+ megafieldid +"', '"+ reger.core.Util.cleanForSQL(val) +"', '0', '1')");
                    //-----------------------------------
                    //-----------------------------------
                }

                //Update with the new myidentity, which effectively moves the data to the new logid
                //-----------------------------------
                //-----------------------------------
                int count = Db.RunSQLUpdate("UPDATE megavalue SET megavalue='"+myidentity+"' WHERE megafieldid='"+megafieldid+"' AND eventid='"+eventid+"'");
                //-----------------------------------
                //-----------------------------------
            }
        }
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
        //-----------------------------------
        //-----------------------------------
        int count2 = Db.RunSQLUpdate("DELETE FROM megaoption WHERE megafieldid='"+megafieldid+"'");
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
        StringBuffer mb = new StringBuffer();

        //Start processing by looking for edits/deletes to existing options
        //-----------------------------------
        //-----------------------------------
        String[][] rstOptsProcess= Db.RunSQL("SELECT megaoptionid, optiontext FROM megaoption WHERE logid='0' AND megafieldid='"+ megafieldid +"' AND isactive<>'0' ORDER BY optiontext ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstOptsProcess!=null && rstOptsProcess.length>0){
            for(int i=0; i<rstOptsProcess.length; i++){
                //If we have an incoming value for this field
                if (request.getParameter("systemconfig-optiontext-megaoptionid-" + rstOptsProcess[i][0])!=null && !request.getParameter("systemconfig-optiontext-megaoptionid-" + rstOptsProcess[i][0]).equals("")){
                    //If it's different than the one in the Db
                    if (!request.getParameter("systemconfig-optiontext-megaoptionid-" + rstOptsProcess[i][0]).equals(rstOptsProcess[i][1])){
                        //Do an update
                        //-----------------------------------
                        //-----------------------------------
                        int count = Db.RunSQLUpdate("UPDATE megaoption SET optiontext='"+reger.core.Util.cleanForSQL(request.getParameter("systemconfig-optiontext-megaoptionid-" + rstOptsProcess[i][0]))+"' WHERE megaoptionid='"+rstOptsProcess[i][0]+"'");
                        //-----------------------------------
                        //-----------------------------------
                    }
                }

                //If we have an incoming value for this delete checkbox
                if (request.getParameter("systemconfig-delete-megaoptionid-" + rstOptsProcess[i][0])!=null && !request.getParameter("systemconfig-delete-megaoptionid-" + rstOptsProcess[i][0]).equals("")){
                    //If the checkbox is checked
                    if (request.getParameter("systemconfig-delete-megaoptionid-" + rstOptsProcess[i][0]).equals("1")){
                        //First, count those where users have data with this option (megaoptionid as megavalue)
                        //-----------------------------------
                        //-----------------------------------
                        String[][] rstCount= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE megafieldid='"+megafieldid+"' AND megavalue='"+rstOptsProcess[i][0]+"'");
                        //-----------------------------------
                        //-----------------------------------
                        if (rstCount!=null && rstCount.length>0){
                            //Just mark inactive because some peeps are using it
                            Debug.debug(5, "", "marking inactive.  megaoptionid=" + rstOptsProcess[i][0]);
                            //-----------------------------------
                            //-----------------------------------
                            int count = Db.RunSQLUpdate("UPDATE megaoption SET isactive='0' WHERE megaoptionid='"+rstOptsProcess[i][0]+"'");
                            //-----------------------------------
                            //-----------------------------------
                        } else {
                            //Do a delete because nobody's using this option
                            Debug.debug(5, "", "deleting.  megaoptionid=" + rstOptsProcess[i][0]);
                            //-----------------------------------
                            //-----------------------------------
                            int count = Db.RunSQLUpdate("DELETE FROM megaoption WHERE megaoptionid='"+rstOptsProcess[i][0]+"'");
                            //-----------------------------------
                            //-----------------------------------
                        }
                    }
                }
            }
        }

        //Continue processing by creating new options if necessary
        if (request.getParameter("systemconfig-optiontext-megaoptionid-new")!=null && !request.getParameter("systemconfig-optiontext-megaoptionid-new").equals("")){
            //See if this option already exists
            //-----------------------------------
            //-----------------------------------
            String[][] rstOpts= reger.core.db.Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE logid='0' AND megafieldid='"+ megafieldid +"' AND optiontext='"+ reger.core.Util.cleanForSQL(request.getParameter("systemconfig-optiontext-megaoptionid-new")) +"'");
            //-----------------------------------
            //-----------------------------------
            if(rstOpts!=null && rstOpts.length>0){
                //Do nothing... the option already exists
            } else {
                //-----------------------------------
                //-----------------------------------
                int myidentity = reger.core.db.Db.RunSQLInsert("INSERT INTO megaoption(logid, megafieldid, optiontext, isdefault, isactive) VALUES('0', '"+megafieldid+"', '"+ reger.core.Util.cleanForSQL(request.getParameter("systemconfig-optiontext-megaoptionid-new")) +"', '0', '1')");
                //-----------------------------------
                //-----------------------------------
            }
        }



        //Start display
        mb.append("<table width=100% cellpadding=3 cellspacing=3 border=0>");

        //Title row
        mb.append("<tr>");
        mb.append("<td valign=top align=right bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-1>");
        mb.append("Delete?");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-1>");
        mb.append("System Default Options");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        //Now, pull up the list of all system options
        //-----------------------------------
        //-----------------------------------
        String[][] rstOpts= Db.RunSQL("SELECT megaoptionid, optiontext FROM megaoption WHERE (logid=0) AND megafieldid='"+ megafieldid +"' AND isactive<>'0' ORDER BY optiontext ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstOpts!=null && rstOpts.length>0){
            for(int i=0; i<rstOpts.length; i++){
                mb.append("<tr>");
                mb.append("<td valign=top align=right bgcolor=#ffffff>");
                mb.append("<font face=arial size=-1>");
                mb.append("<input type=checkbox name=systemconfig-delete-megaoptionid-" + rstOpts[i][0] + " value=1>");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("<td valign=top bgcolor=#ffffff>");
                mb.append("<font face=arial size=-1>");
                mb.append("<input type=text name=systemconfig-optiontext-megaoptionid-" + rstOpts[i][0] + " value=\""+reger.core.Util.cleanForHtml(rstOpts[i][1])+"\" size=25 maxlength=255>");
                mb.append("</font>");
                mb.append("</td>");
                mb.append("</tr>");
            }
        } else {
            mb.append("<tr>");
            mb.append("<td valign=top align=right bgcolor=#ffffff>");
            mb.append("<font face=arial size=-1>");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("<td valign=top bgcolor=#ffffff>");
            mb.append("<font face=arial size=-1>");
            mb.append("No System Options Found.");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
        }

        //Add new row
        mb.append("<tr>");
        mb.append("<td valign=top align=right bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-1>");
        mb.append("Add New Option:");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-1>");
        mb.append("<input type=text name=systemconfig-optiontext-megaoptionid-new value=\"\" size=25 maxlength=255>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");


        mb.append("</table>");

        return mb.toString();
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
