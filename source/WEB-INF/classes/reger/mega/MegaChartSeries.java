package reger.mega;

import reger.core.db.Db;
import reger.core.Debug;

import java.util.*;

/**
 * Retrieves, formats and prepares data from the megavalue table for charting operations.
 */
public class MegaChartSeries {

    //public int[] intListOfEventids;
    public MegaChartEntryChooser entryChooser;
    public String[][] rawChartData;
    public String[][] cleanData;
    public TreeMap avgCount = new TreeMap();
    //public String dateSql = "";
    //public reger.UserSession userSession;

    //xAxis
    public int xMegafieldid=-1;
    public int xLogid=0;
    public String xAxisTitle="";
    public int xFieldtype=-1;
    public int xMegadatatype=-1;

    //yAxis
    public int yMegafieldid=-1;
    public int yLogid=0;
    public String yAxisTitle="";
    public int yFieldtype=-1;
    public int yMegadatatype=-1;

    public int yaxiswhattodo = -1;
    //public int daterange = -1;





    /**
     * Constructor
     * Go grab data from the database and put it into the built-in raw data property.
     */
    public MegaChartSeries(){

    }





    public MegaChartSeries(int yMegafieldid, int yLogid, MegaChart megaChart, MegaChartEntryChooser entryChooser){

        //Store the incoming data in the correct place
        this.xMegafieldid=megaChart.getxMegafieldid();
        this.yMegafieldid=yMegafieldid;
        this.xLogid=megaChart.getxLogid();
        this.yLogid=yLogid;
        this.yaxiswhattodo=megaChart.getYaxiswhattodo();

        //Break out the fieldtype from the megafieldid.
        //If the MegaFieldid < 0 then it's actually a fieldtype
        //xField
        if (xMegafieldid < 0){
            xFieldtype = xMegafieldid;
            //Gotta create a field handler to get name
            reger.mega.ChartField f = reger.mega.ChartFieldFactory.getHandlerByFieldtype(xFieldtype);
            f.populateFromMegafieldid(xMegafieldid);
            xAxisTitle = f.getFieldname();
            xMegadatatype = f.getMegadatatypeid();
        } else {
            //Gotta go to the DB
            reger.mega.Field xField = new reger.mega.Field(xMegafieldid);
            xFieldtype = xField.fieldtype;
            xAxisTitle = xField.fieldname;
            xMegadatatype = xField.megadatatypeid;
        }

        //yField
        if (yMegafieldid < 0){
            yFieldtype = yMegafieldid;
            //Gotta create a field handler to get name
            reger.mega.ChartField f = reger.mega.ChartFieldFactory.getHandlerByFieldtype(yFieldtype);
            if(f!=null){
                f.populateFromMegafieldid(yMegafieldid);
                yAxisTitle = f.getFieldname();
                yMegadatatype = f.getMegadatatypeid();
            }
        } else {
            //Gotta go to the DB
            reger.mega.Field yField = new reger.mega.Field(yMegafieldid);
            yFieldtype = yField.fieldtype;
            yAxisTitle = yField.fieldname;
            yMegadatatype = yField.megadatatypeid;
        }

        //Get the data for x Axis
        TreeMap xAxisData = getFieldData(xMegafieldid, xFieldtype, entryChooser.getIntListOfEventids());

        //Get the data for y Axis
        TreeMap yAxisData = getFieldData(yMegafieldid, yFieldtype, entryChooser.getIntListOfEventids());

        //Now, combine xAxisData and yAxisData into String[][]
        this.rawChartData = combineTwoTreeMapsIntoDataArray(xAxisData, yAxisData, entryChooser.getIntListOfEventids());

        //reger.core.Util.logDoubleStringArrayToDb("Combined Data", this.rawChartData);

        //Sort, order, cleanup and otherwise massage the data
        massageData();

    }

    /**
     * Get data for a particular megafieldid.
     * What's happening here is this:
     * We're looking at a single field and we want to create an
     * array with array[eventid][megafieldid.value].
     * The first step is to find the correct field handler that implements
     * the interface FieldType
     */
     public TreeMap getFieldData(int megafieldid, int fieldtype, int[] intListOfEventids){
        Debug.debug(5, "", "MegaChartNew.java: getFieldData()<br>megafieldid=" + megafieldid + "<br>fieldtype=" + fieldtype);
        //Use FieldTypeFactory
        //Now we pass this to the fieldtype handler
        //Figure out which type of field this is
        reger.mega.ChartField f = reger.mega.ChartFieldFactory.getHandlerByFieldtype(fieldtype);
        //Populate the field with title, description and all that good stuff in the database
        f.populateFromMegafieldid(megafieldid);
        //Call the function that gets a set of chart data
        //Result[eventid][value]
        TreeMap AxisRawData = f.getChartDataForField(intListOfEventids);
        //reger.core.Util.logTreeMapToDb("AxisRawData megafieldid=" + megafieldid + " fieldtype=" + fieldtype, AxisRawData);
        return AxisRawData;
     }

     public String[][] combineTwoTreeMapsIntoDataArray(TreeMap xAxis, TreeMap yAxis, int[] eventids){
        //The final format is an array of [eventid][xAxisData][yAxisData]
        String[][] outData = new String[eventids.length][3];
        //Iterate the list of eventids
        Object xData;
        Object yData;

        for (int i = 0; i < eventids.length; i++) {
            //Get xData
            xData = xAxis.get(String.valueOf(eventids[i]));
            if (xData==null){
                xData = " ";
            }

            //Get yData
            yData = yAxis.get(String.valueOf(eventids[i]));
            if (yData==null){
                yData = " ";
            }

            //Only add if
                //Create triple array
                String[] tmpArr = new String[3];
                tmpArr[0] = String.valueOf(eventids[i]);
                tmpArr[1] = xData.toString();
                tmpArr[2] = yData.toString();
                //Add this tmpArray to the main data array
                outData[i] = tmpArr;
        }
        //Return the data
        return outData;
     }

    /**
     * Clean up the data and get it ready to be thrown at a chart object.
     */
    public void massageData(){

        //Sort
        //Create TreeMap
        TreeMap tmap = new TreeMap();

        //Create a working array
        String [][] tmpChartData = rawChartData;


        //Remove Dupes AND Add to TreeMap in correct object type (double or String)
        //Iterate rawChartData
        Object tmpobj;
        //Create treemaps to detect dupes
        TreeMap xDupes = new TreeMap();
        TreeMap yDupes = new TreeMap();
        boolean xdupeFlag=false;
        boolean ydupeFlag=false;
        if (tmpChartData!=null && tmpChartData.length>0){
        	for(int i=0; i<tmpChartData.length; i++){

        	    //Create a properly typed eventid
        	    Object eventid = new Integer(tmpChartData[i][0]);

        	    //Create a properly typed xAxisValue
        	    Object xAxisValue = null;
                if (xMegadatatype==reger.mega.DataTypeInteger.DATATYPEID){
                    if (reger.core.Util.isinteger(tmpChartData[i][1])){
                        xAxisValue = new Integer(tmpChartData[i][1]);
                    } else {
                        xAxisValue = new Integer(0);
                    }
                } else if (xMegadatatype==reger.mega.DataTypeDecimal.DATATYPEID) {
                    if (reger.core.Util.isnumeric(tmpChartData[i][1])){
                        xAxisValue = new Double(tmpChartData[i][1]);
                    } else {
                        xAxisValue = new Double(0);
                    }
                } else {
                    xAxisValue = tmpChartData[i][1];
                }

                //Create a properly typed yAxisValue
                Object yAxisValue = null;
                if (reger.core.Util.isnumeric(tmpChartData[i][2])){
                    yAxisValue = new Double(tmpChartData[i][2]);
                } else {
                    yAxisValue = new Double(0);
                }

                //Reset the dupe finder flag
                xdupeFlag=false;
                ydupeFlag=false;

                //I create two treemaps, each keyed off of the eventid (rawChartData[i][0]).
                //I then check for x dupes and y dupes.  You have to have both duped to find an actual row dupe.
        	    //Detect x dupes
        	    if (xDupes.containsKey(eventid) && xDupes.get(eventid).equals(xAxisValue)) {
                    xdupeFlag=true;
                } else {
                    //Add it to the dupe cache
                    xDupes.put(eventid, xAxisValue);
                }
                //Detect y dupes
        	    if (yDupes.containsKey(eventid) && yDupes.get(eventid).equals(yAxisValue)) {
                    ydupeFlag=true;
                } else {
                    //Add it to the dupe cache
                    yDupes.put(eventid, yAxisValue);
                }

                //If no dupes have yet been found for this x,y combination
                //In other words, each x,y combo will pass through here at least once
                if (!xdupeFlag && !ydupeFlag) {
                    //If key already exists, sum/avg the values...
                    if (tmap.containsKey(xAxisValue)) {

                        //Get the current value
                        tmpobj=tmap.get(xAxisValue);
                        //Clear the current treemap entry
                        tmap.remove(xAxisValue);

                        //Add the entry back with the new avg/sum value

                        //This handles Sum and Average cases because it's doing the Sum
                        //portion.  Later, after all have been processed, the divide
                        //part of the average operation is done.
                        //Note that we're adding to the TreeMap as a typed object so
                        //that sorting works properly.
                        tmap.put(xAxisValue, new Double(Double.parseDouble(yAxisValue.toString()) + Double.parseDouble(tmpobj.toString())));
                        //Be sure to update the avgCount treemap
                        incrementAvgCount(xAxisValue);

                    //The key doesn't yet exist so we have to add it... simple.
                    } else {
                        //Add the new entry to the treemap
                        tmap.put(xAxisValue, yAxisValue);

                        //Be sure to update the avgCount treemap
                        incrementAvgCount(xAxisValue);
                    }
                }
        	}
        }


        //Now, fill in some empty xAxis values
        reger.mega.ChartField f = reger.mega.ChartFieldFactory.getHandlerByFieldtype(xFieldtype);
        tmap = f.fillEmptyXAxis(tmap);


        //If the user wants to average, do it. Jeeze.  What are you standing around for?
        //Can only do at this level because only now do we see both x and y axes.
        if (yaxiswhattodo==reger.Vars.YAXISWHATTODOAVG) {
            //@todo Why does doAverage() have any effect when dealing with XAXISENTRYORDER?  Shouldn't we have one value for each entry and that's it?  I need to print out and compare rawData with cleanData.
            tmap = doAverage(tmap);
        }


        //Dump from treemap to cleanData
        //reger.core.Util.logTreeMapToDb("TreeMap just before being converted to cleanData", tmap);
        cleanData=null;
        cleanData= new String[tmap.size()][3];
        int j=0;
        for (Iterator i=tmap.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry e = (Map.Entry) i.next();
            //Move from treemap to cleandata
            if (xMegafieldid!=FieldType.XAXISDATETIME){
                //As long as it's not a date this will be used
                cleanData[j][1] = String.valueOf(e.getKey());
            } else {
                //Do the milli conversion
                Calendar tmp = reger.core.TimeUtils.dbstringtocalendar(String.valueOf(e.getKey()));
                cleanData[j][1]=String.valueOf(tmp.getTimeInMillis());
            }

            cleanData[j][2] = String.valueOf(e.getValue());


            //Increment the counter
            j=j+1;
        }
        //reger.core.Util.logDoubleStringArrayToDb("Final cleanData from MegaChartNew", cleanData);

    }



    /**
     * This method adds 1 to the key value in the avgCount treemap.  The goal here
     * is to be able to tell how many entries have been consolidated in cleanData
     * so that an average can be computed.
     * @param key - The key to add a count to
     */
    public void incrementAvgCount(Object key){
        String tmpobj="";
        if (avgCount.containsKey(key)) {
            //Get the current value
            tmpobj=String.valueOf(avgCount.get(key));
            //Clear the current treemap entry
            avgCount.remove(key);
            //Increment and add
            avgCount.put(key, String.valueOf(Integer.parseInt(tmpobj)+1));
        } else {
            //Just add a new key
            avgCount.put(key, String.valueOf(1));
        }
    }

    /**
     * Compute the average for y axis.  Here's where we're at: the TreeMap holds summed values.
     * This.avgCount holds the key-by-key count of how many entries are in each.
     * So all we have to do is the division.
     */
    public TreeMap doAverage(TreeMap tmap){
        TreeMap newTmap = new TreeMap();
        String oldValue="";
        String newValue="";
        //Iterate the incoming treemap
        for (Iterator i=tmap.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry e = (Map.Entry) i.next();
            //out.println(e.getKey() + ": " + e.getValue());
            if (avgCount.containsKey(e.getKey())) {
                //Store the temp tmap value
                oldValue=String.valueOf(e.getValue());
                //Do the math
                if (reger.core.Util.isnumeric(oldValue)){
                    //Calculate the average
                    newValue=String.valueOf(Double.parseDouble(oldValue)/Double.parseDouble(String.valueOf(avgCount.get(e.getKey()))));
                } else {
                    newValue=oldValue;
                }
                //Dump the new value into the newTmap
                newTmap.put(e.getKey(), newValue);
            }
        }
        return newTmap;
    }









//    /**
//     * Create the count of events that an element of the x-axis appears in.
//     */
//    public TreeMap doCountEntriesValues(TreeMap tmap){
//        TreeMap newTmap = new TreeMap();
//
//        //This for loop actually calculates the counts.  Ugly database calls.  Can optimize later.
//        String sql="";
//        for (Iterator i=tmap.entrySet().iterator(); i.hasNext(); ) {
//            Map.Entry e = (Map.Entry) i.next();
//
//            //Query the database for a count of the xAxis value based on the megavalue
//            //Problem: Need to limit the view again to a particular sql query.
//            //Solution: Use dateSql, defined above when the constructor is called.
//            //Problem: The xAxis values have already been converted to megaoption (if applicable) so I need to convert back?
//            //Solution: Two potential sql queries... one using megaoption, one not.  Hmmm... isn't that special?
//            if (xFieldtype==FieldType.FIELDTYPEDROPDOWN || xFieldtype==FieldType.FIELDTYPEHORIZONTALRADIOS || xFieldtype==FieldType.FIELDTYPEVERTICALRADIOS) {
//                sql = "SELECT count(*) FROM megavalue, megaoption, event e WHERE e.eventid=megavalue.eventid AND megavalue.megavalue=megaoption.megaoptionid AND megavalue.megafieldid='"+xMegafieldid+"' AND megaoption.optiontext='"+e.getKey()+"' AND e.logid='"+xLogid+"'" + dateSql;
//            } else {
//                sql = "SELECT count(*) FROM megavalue, event e WHERE e.eventid=megavalue.eventid AND megavalue.megafieldid='"+xMegafieldid+"' AND megavalue.megavalue='"+e.getKey()+"' AND e.logid='"+xLogid+"'" + dateSql;
//            }
//            //-----------------------------------
//            //-----------------------------------
//            String[][] getCount= Db.RunSQL(sql);
//            //-----------------------------------
//            //-----------------------------------
//
//            //Add the results to newTmap. Results held in getCount[0][0]
//            newTmap.put(e.getKey(), getCount[0][0]);
//        }
//
//        return newTmap;
//    }

    /**
     * Goes to the database and gets the fieldtype
     */
    public int getFieldType(int megafieldid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstFieldtype= Db.RunSQL("SELECT fieldtype FROM megafield WHERE megafieldid='"+megafieldid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstFieldtype!=null && rstFieldtype.length>0){
        	for(int i=0; i<rstFieldtype.length; i++){
        	    if (reger.core.Util.isinteger(rstFieldtype[0][0])){
                    return Integer.parseInt(rstFieldtype[0][0]);
                }
        	}
        }
        //Otherwise return blah
        return -1;
    }

    /**
     * Sets the x title and some other properties
     */
    public void setXTitleBasedOnFieldId(){
        //Get details of the x axis
        if (xMegafieldid>0) {
            //It's a real field
            //-----------------------------------
            //-----------------------------------
            String[][] getXfield= Db.RunSQL("SELECT fieldname, megadatatypeid, fieldtype FROM megafield WHERE megafieldid='"+xMegafieldid+"'");
            //-----------------------------------
            //-----------------------------------
            if (getXfield!=null && getXfield.length>0){
                for(int i=0; i<getXfield.length; i++){
                    xAxisTitle=getXfield[i][0];
                    xMegadatatype=Integer.parseInt(getXfield[i][1]);
                    xFieldtype=Integer.parseInt(getXfield[i][2]);
                }
            }
        } else {
            //It's a derived type
            //See Vars class for these values.
            if (xMegafieldid==FieldType.XAXISENTRYORDER){
                xAxisTitle="Entry Order";
                xMegadatatype=reger.mega.DataTypeInteger.DATATYPEID;
                xFieldtype=reger.mega.FieldType.XAXISENTRYORDER;
            } else if (xMegafieldid==FieldType.XAXISTIMEOFDAY) {
                xAxisTitle="Hour of the Day";
                xMegadatatype=reger.mega.DataTypeInteger.DATATYPEID;
                xFieldtype=reger.mega.FieldType.XAXISTIMEOFDAY;
            } else if (xMegafieldid==FieldType.XAXISDAYOFWEEK) {
                xAxisTitle="Day of the Week";
                xMegadatatype=reger.mega.DataTypeString.DATATYPEID;
                xFieldtype=reger.mega.FieldType.XAXISDAYOFWEEK;
            } else if (xMegafieldid==FieldType.XAXISDAYOFMONTH) {
                xAxisTitle="Day of the Month";
                xMegadatatype=reger.mega.DataTypeInteger.DATATYPEID;
                xFieldtype=reger.mega.FieldType.XAXISDAYOFMONTH;
            } else if (xMegafieldid==FieldType.XAXISCALENDARDAYS) {
                xAxisTitle="Days Ago";
                xMegadatatype=reger.mega.DataTypeInteger.DATATYPEID;
                xFieldtype=reger.mega.FieldType.XAXISCALENDARDAYS;
            } else if (xMegafieldid==FieldType.XAXISCALENDARWEEKS) {
                xAxisTitle="Weeks Ago";
                xMegadatatype=reger.mega.DataTypeInteger.DATATYPEID;
                xFieldtype=reger.mega.FieldType.XAXISCALENDARWEEKS;
            } else if (xMegafieldid==FieldType.XAXISCALENDARMONTHS) {
                xAxisTitle="Months Ago";
                xMegadatatype=reger.mega.DataTypeInteger.DATATYPEID;
                xFieldtype=reger.mega.FieldType.XAXISCALENDARMONTHS;
            } else {
                xAxisTitle="Date";
                xMegadatatype=reger.mega.DataTypeDatetime.DATATYPEID;
                xFieldtype=reger.mega.FieldType.XAXISDATETIME;
            }
        }
    }



    /**
     * Set y axis properties based on
     *
     */
     public void setYTitleBasedOnFieldId(){
        //-----------------------------------
        //-----------------------------------
        String[][] getYfield= Db.RunSQL("SELECT fieldname, megadatatypeid, fieldtype FROM megafield WHERE megafieldid='"+yMegafieldid+"'");
        //-----------------------------------
        //-----------------------------------
        if (getYfield!=null && getYfield.length>0){
            for(int i=0; i<getYfield.length; i++){
                yAxisTitle=getYfield[i][0];
                yMegadatatype=Integer.parseInt(getYfield[i][1]);
                yFieldtype=Integer.parseInt(getYfield[i][2]);
                Debug.debug(5, "", "Megachart.java. Successfully found yMegafieldid. yMegafieldid=" + yMegafieldid);
            }
        }
        if (yMegafieldid==FieldType.YAXISCOUNT) {
            yAxisTitle="Number of Entries";
            yMegadatatype=reger.mega.DataTypeInteger.DATATYPEID;
            yFieldtype=FieldType.FIELDTYPETEXTBOX;
        }
    }

    public String getyAxisTitle() {
        return yAxisTitle;
    }

    public String getxAxisTitle() {
        return xAxisTitle;
    }

    public int getxMegadatatype() {
        return xMegadatatype;
    }

    public int getyMegadatatype() {
        return yMegadatatype;
    }
}
