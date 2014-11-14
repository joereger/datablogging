package reger.mega;

import java.util.Calendar;

/**
 * Generates preview data for mega charts.
 */
public class MegaChartPreviewSeries extends reger.mega.MegaChartSeries {


    /**
     * Constructor
     * Preview constructor
     */
    public MegaChartPreviewSeries(int xMegafieldid, int yMegafieldid){

        //Basic plan here is to create two string arrays with the correct type of dummy preview data
        int sizeofpreviewset = 10;
        String[] xPreviewdata = new String[sizeofpreviewset-1];
        String[] yPreviewdata = new String[sizeofpreviewset-1];

        //Tell this object to respect the fieldid's coming in from the constructor
        this.xMegafieldid=xMegafieldid;
        this.yMegafieldid=yMegafieldid;

        //Set title and other properties for X axis.
        setXTitleBasedOnFieldId();

        //Set title and other properties for X axis.
        setYTitleBasedOnFieldId();

        //Get our two datasets
        xPreviewdata = previewDataGet(xMegafieldid, xMegadatatype, sizeofpreviewset, false);
        yPreviewdata = previewDataGet(yMegafieldid, yMegadatatype, sizeofpreviewset, true);

        //Now combine them into raw data
        rawChartData = new String[sizeofpreviewset][3];
        for (int i = 0; i <sizeofpreviewset; i++) {
            rawChartData[i][0]=String.valueOf(i);
            rawChartData[i][1]=xPreviewdata[i];
            rawChartData[i][2]=yPreviewdata[i];
        }

        //reger.core.Util.logDoubleStringArrayToDb("rawChartData[][] Preview Data", rawChartData);

        //Clean the data
       massageData();
    }

    private String[] previewDataGet(int megafieldid, int Megadatatype, int howmanydatapoints, boolean isYaxis){
        if (megafieldid>0){
            if (Megadatatype==reger.mega.DataTypeString.DATATYPEID){
                return previewDataAlpha(howmanydatapoints);
            } else if (Megadatatype==reger.mega.DataTypeDatetime.DATATYPEID){
                return previewDataTime(howmanydatapoints);
            } else {
                return previewDataNumeric(howmanydatapoints);
            }
        } else {
            if (!isYaxis){
                //It's the X axis
                if (megafieldid==FieldType.XAXISDAYOFWEEK) {
                    return previewDataTimeExt(howmanydatapoints, megafieldid);
                } else if (megafieldid==FieldType.XAXISDAYOFMONTH) {
                    return previewDataTimeExt(howmanydatapoints, megafieldid);
                } else if (megafieldid==FieldType.XAXISTIMEOFDAY) {
                    return previewDataTimeExt(howmanydatapoints, megafieldid);
                } else if (megafieldid==FieldType.XAXISENTRYORDER) {
                    //This one's different
                    return previewDataNumeric(howmanydatapoints);
                } else if (megafieldid==FieldType.XAXISCALENDARWEEKS) {
                    return previewDataTimeExt(howmanydatapoints, megafieldid);
                } else if (megafieldid==FieldType.XAXISCALENDARMONTHS) {
                    return previewDataTimeExt(howmanydatapoints, megafieldid);
                } else if (megafieldid==FieldType.XAXISDATETIME) {
                    return previewDataTimeExt(howmanydatapoints, megafieldid);
                }
            } else {
                //It's a Y Axis
                if (megafieldid==FieldType.YAXISCOUNT) {
                    return previewDataCount(howmanydatapoints);
                }
            }
        }

       return previewDataNumeric(howmanydatapoints);
    }

    private String[] previewDataNumeric(int howmanydatapoints){
        String[] out = new String[howmanydatapoints];
        for(int i=0; i<=(howmanydatapoints-1); i++){
            out[i]=String.valueOf((Math.random()*100+1));
        }
        return out;
    }

     private String[] previewDataCount(int howmanydatapoints){
        String[] out = new String[howmanydatapoints];
        for(int i=0; i<=(howmanydatapoints-1); i++){
            out[i]=String.valueOf(1);
        }
        return out;
    }



    private String[] previewDataAlpha(int howmanydatapoints){
        String[] out = new String[howmanydatapoints];
        for(int i=0; i<=(howmanydatapoints-1); i++){
            out[i]="Data"+i;
        }
        return out;
    }

    private String[] previewDataTime(int howmanydatapoints){
        String[] out = new String[howmanydatapoints];
        Calendar cal = Calendar.getInstance();
        for(int i=0; i<=(howmanydatapoints-1); i++){
            out[i]=reger.core.TimeUtils.dateformatfordb(cal);
            cal.add(Calendar.DATE, -1);
        }
        return out;
    }

    private String[] previewDataTimeExt(int howmanydatapoints, int megafieldid){
        String[] out = new String[howmanydatapoints];

        //Need to figure out what units we're subtracting from
        int unit = Calendar.DATE;
        int max = 31;
        if (megafieldid==FieldType.XAXISDAYOFWEEK) {
            unit = Calendar.DATE;
            max = 7;
        } else if (megafieldid==FieldType.XAXISDAYOFMONTH) {
            unit = Calendar.DATE;
            max = 31;
        } else if (megafieldid==FieldType.XAXISTIMEOFDAY) {
            unit = Calendar.HOUR_OF_DAY;
            max = 23;
        } else if (megafieldid==FieldType.XAXISCALENDARWEEKS) {
            unit = Calendar.DATE;
            max = 100;
        } else if (megafieldid==FieldType.XAXISCALENDARMONTHS) {
            unit = Calendar.DATE;
            max = 365;
        } else if (megafieldid==FieldType.XAXISDATETIME) {
            unit = Calendar.DATE;
            max = 60;
        }

        for(int i=0; i<=(howmanydatapoints-1); i++){
            //Get now
            Calendar cal = Calendar.getInstance();
            //Get a random number up to the max defined above
            int random = reger.core.Util.randomInt(max);
            //Subtract that random number of units (units defined above) from the calendar
            cal.add(unit, (-1*random));
            //Convert to a string
            out[i]=reger.core.TimeUtils.dateformatfordb(cal);
        }

        return out;
    }



}
