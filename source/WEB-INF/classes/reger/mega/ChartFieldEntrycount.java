package reger.mega;

import reger.core.db.Db;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;
import java.util.Calendar;
import java.util.TreeMap;

/**
 * A dropdown field
 */
public class ChartFieldEntrycount extends Field implements ChartField{


    //Field data - These properties define the data type for this field
    String value = "";
    String timezoneid = "GMT";




    /**
     * Friendly name
     */
    public String getFieldname() {
        return "Number of Entries";
    }

    /**
     * Description of this field type
     */
    public String getFielddescription() {
        return "The number of entries that have the value on the xAxis.";
    }

    /**
     * Get the megadatatypeid
     */
    public int getMegadatatypeid() {
        return reger.mega.DataTypeInteger.DATATYPEID;
    }


    /**
     * Accepts an array of eventid's and returns a set of values for this field
     * corresponding to those eventid's.
     */
    public TreeMap getChartDataForField(int[] eventids) {
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
            String[][] rstEvents= Db.RunSQL("SELECT event.eventid, event.date FROM event WHERE " + whereClause + "ORDER BY event.date ASC");
            //-----------------------------------
            //-----------------------------------
            if (rstEvents!=null && rstEvents.length>0){
                for(int i=0; i<rstEvents.length; i++){
                    data.put(rstEvents[i][0], "1");
                }
            }
            //Return the treemap with the data
            return data;
       } else {
           return new TreeMap();
       }
    }





    /**
     * Set timezoneid of display
     */
    public void setTimezoneid(String timezoneid) {
        this.timezoneid = timezoneid;
    }

    /**
     * Get timezoneid of display
     */
    public String getTimezoneid() {
        return this.timezoneid;
    }

    /**
     * Returns the Field object that this field is based on.
     * The Field object is the core requirement of a fieldtype.
     * Generally FieldType implementations extend Field.
     */
//    public Field getField() {
//        return this;
//    }

    /**
     * Add empty xAxis values to fill out set.
     * In the case of something like DaysOfTheWeek, often
     * the data will only have data on Mon, Fri.  But
     * the final data set should represent explicitly that
     * Sun, Tue, Wed, Thu and Sat have a value of 0.
     * Incoming is a treemap with
     * (xAxis, yAxis)
     * (xAxis, yAxis)
     * (xAxis, yAxis)
     * If FieldType doesn't need to do this, simply return data unchanged.
     */
    public TreeMap fillEmptyXAxis(TreeMap data) {
        //Return the data
        return data;
    }




}
