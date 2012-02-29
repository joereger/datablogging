package reger.mega;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;
import reger.core.Debug;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Converts data for a megachart into HighCharts
 */
public class MegaChartConvertToHighCharts {





    public static String timeSeriesCollection(MegaChart megaChart){
        Logger logger = Logger.getLogger(MegaChartConvertToHighCharts.class);
        StringBuffer out = new StringBuffer();
        //Dataset to hold data
        TimeSeries timedata = null;
        TimeSeriesCollection timedataseries = new TimeSeriesCollection();
        //Loop on the series of the megaChart
        for (int j = 0; j < megaChart.getMegaChartSeries().length; j++) {
            MegaChartSeries megaChartSeries = megaChart.getMegaChartSeries()[j];
            if (megaChartSeries.cleanData!=null && megaChartSeries.cleanData.length>0){
                timedata = new TimeSeries(megaChartSeries.yAxisTitle, Millisecond.class);
                for(int i=0; i<megaChartSeries.cleanData.length; i++){
                    //Y data must always be numeric
                    if (reger.core.Util.isnumeric(megaChartSeries.cleanData[i][2])) {
                        try{
                            try{
                                java.util.Date tmpDate = new java.util.Date(Long.parseLong(megaChartSeries.cleanData[i][1]));
                                timedata.add(new Millisecond(tmpDate), Double.parseDouble(megaChartSeries.cleanData[i][2]));
                            } catch (Exception e){
                                //Here's a situation where the try/catch thing works.  Otherwise
                                //I'd have to do a date comparison for every single data point.
                                //Which is a lot of overhead in Java's slow date classes.  Instead,
                                //I'm relying on the Millisecond's built-in check to see if the date is
                                //between 1900 and 9999.  Not as elegant as I'd like, but it works.
                                Debug.debug(5, "", e);
                            }
                        } catch (Exception e) {
                            //Do not rely on this catch to fix bugs... the reason it's here
                            //is to help the graphs be more robust.  Instead of crashing the whole
                            //graph, only this data point won't be added.  Solve errors caught here
                            //in the above block.
                            Debug.errorsave(e, "", "MegaChartConvertToHighCharts - Error Adding Data to Data Set.");
                        }
                    }
                }
                timedataseries.addSeries(timedata);
            }
        }
        return out.toString();
    }





    public static ArrayList getSeriesDataTimeSeries(MegaChart megaChart){
        Logger logger = Logger.getLogger(MegaChartConvertToHighCharts.class);
        ArrayList allseries = new ArrayList();

        for (int j = 0; j < megaChart.getMegaChartSeries().length; j++) {
            MegaChartSeries megaChartSeries = megaChart.getMegaChartSeries()[j];
            if (megaChartSeries.cleanData!=null && megaChartSeries.cleanData.length>0){
                ArrayList arrayofdata = new ArrayList();

                for(int i=0; i<megaChartSeries.cleanData.length; i++){
                    try{
                        ArrayList singledatapoint = new ArrayList();
                        //Add as either string or double, depending on whether they're supposed to be numeric
                        if(reger.core.Util.isnumeric(megaChartSeries.cleanData[i][1])){
                            //singledatapoint.add(Double.parseDouble(megaChartSeries.cleanData[i][1]));
                            Calendar cal = Calendar.getInstance();
                            cal.setTimeInMillis(Long.parseLong(megaChartSeries.cleanData[i][1]));
                            //Date.UTC(year, mo, day, hour, minute, second)
                            singledatapoint.add("Date.UTC("+cal.get(Calendar.YEAR)+", "+cal.get(Calendar.MONTH)+", "+cal.get(Calendar.DAY_OF_MONTH)+", "+cal.get(Calendar.HOUR)+", "+cal.get(Calendar.MINUTE)+", "+cal.get(Calendar.SECOND)+")");
                        } else {
                            continue; //In a time series X must be a milliseconds value to record the datapoint
                        }
                        if(reger.core.Util.isnumeric(megaChartSeries.cleanData[i][2])){
                            singledatapoint.add(Double.parseDouble(megaChartSeries.cleanData[i][2]));
                        } else {
                            singledatapoint.add(megaChartSeries.cleanData[i][2]);
                        }
                        arrayofdata.add(singledatapoint);
                    } catch (Exception e) {
                        Debug.errorsave(e, "", "MegaChartConvertToHighCharts - Error Adding Data to Data Set.");
                    }
                }

                Map<String, Object> singleseries = new HashMap<String, Object>();
                singleseries.put("name", megaChartSeries.yAxisTitle);
                singleseries.put("data", arrayofdata);
                allseries.add(singleseries);
            }
        }

        return allseries;
    }



    public static ArrayList getSeriesDataDefaultXY(MegaChart megaChart){
        Logger logger = Logger.getLogger(MegaChartConvertToHighCharts.class);
        ArrayList allseries = new ArrayList();

        for (int j = 0; j < megaChart.getMegaChartSeries().length; j++) {
            MegaChartSeries megaChartSeries = megaChart.getMegaChartSeries()[j];
            if (megaChartSeries.cleanData!=null && megaChartSeries.cleanData.length>0){
                ArrayList arrayofdata = new ArrayList();

                for(int i=0; i<megaChartSeries.cleanData.length; i++){
                    try{
                        ArrayList singledatapoint = new ArrayList();
                        //Add as either string or double, depending on whether they're supposed to be numeric
                        if(reger.core.Util.isnumeric(megaChartSeries.cleanData[i][1])){
                            singledatapoint.add(Double.parseDouble(megaChartSeries.cleanData[i][1]));
                        } else {
                            singledatapoint.add(megaChartSeries.cleanData[i][1]);
                        }
                        if(reger.core.Util.isnumeric(megaChartSeries.cleanData[i][2])){
                            singledatapoint.add(Double.parseDouble(megaChartSeries.cleanData[i][2]));
                        } else {
                            singledatapoint.add(megaChartSeries.cleanData[i][2]);
                        }
                        arrayofdata.add(singledatapoint);
                    } catch (Exception e) {
                        Debug.errorsave(e, "", "MegaChartConvertToHighCharts - Error Adding Data to Data Set.");
                    }
                }

                Map<String, Object> singleseries = new HashMap<String, Object>();
                singleseries.put("name", megaChartSeries.yAxisTitle);
                singleseries.put("data", arrayofdata);
                allseries.add(singleseries);
            }
        }

        return allseries;
    }

    public static String getChartHtml(Map<String, Object> rootJson){
        Logger logger = Logger.getLogger(MegaChartConvertToHighCharts.class);
        StringBuffer out = new StringBuffer();
        //Serialize chart params to JSON
        String jsonStr = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            StringWriter sw = new StringWriter();
            mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
            mapper.writeValue(sw, rootJson);
            jsonStr = sw.toString();
            logger.debug(jsonStr);
        } catch (JsonGenerationException e) {
            logger.error("", e);
        } catch (JsonMappingException e) {
            logger.error("", e);
        } catch (IOException e) {
            logger.error("", e);
        }

        out.append("<script src=\"js/Highcharts-2.2.0/js/highcharts.js\" type=\"text/javascript\"></script>\n");
        out.append("<script type=\"text/javascript\">\n" +
                "\n" +
                "(function($){ // encapsulate jQuery\n" +
                "\n" +
                "var chart;\n" +
                "$(document).ready(function() {\n" +
                "    chart = new Highcharts.Chart(\n" +
                jsonStr +
                "\n"+
                ");"+
                "});\n" +
                "\n" +
                "})(jQuery);\n" +
                "</script>");

        out.append("<div id=\"container\" style=\"width: 100%; height: 500px\"></div>");

        return out.toString();
    }



}
