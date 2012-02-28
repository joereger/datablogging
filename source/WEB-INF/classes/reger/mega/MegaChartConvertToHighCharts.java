package reger.mega;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import reger.core.Debug;
import reger.util.Str;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Converts data for a megachart into HighCharts
 */
public class MegaChartConvertToHighCharts {



    public static String defaultCategoryDataset(MegaChart megaChart){
        Logger logger = Logger.getLogger(MegaChartConvertToHighCharts.class);

        //Root JSON container
        Map<String, Object> rootJson = new HashMap<String, Object>();

        Map<String, Object> chartJson = new HashMap<String, Object>();
        chartJson.put("renderTo", "container");
        chartJson.put("type", "line");
        chartJson.put("marginRight", 130);
        chartJson.put("marginBottom", 25);
        rootJson.put("chart", chartJson);

        Map<String, Object> titleJson = new HashMap<String, Object>();
        titleJson.put("text", megaChart.getChartname());
        titleJson.put("x", -20);
        rootJson.put("title", titleJson);

        Map<String, Object> xaxisJson = new HashMap<String, Object>();
            Map<String, Object> xtitleJson = new HashMap<String, Object>();
            xtitleJson.put("enabled", true);
            xtitleJson.put("text", megaChart.getxAxisTitle());
            xaxisJson.put("title", xtitleJson);
        rootJson.put("xAxis", xaxisJson);

        Map<String, Object> yaxisJson = new HashMap<String, Object>();
            Map<String, Object> ytitleJson = new HashMap<String, Object>();
            ytitleJson.put("text", megaChart.getyAxisTitle());
            ytitleJson.put("x", -20);
            yaxisJson.put("title", ytitleJson);
        rootJson.put("yAxis", yaxisJson);

        //Data is added here
        rootJson.put("series", getSeriesDataAsJSON(megaChart));

        //Convert to JSON and wrap in HTML
        return getChartHtml(rootJson);




//        Logger logger = Logger.getLogger(MegaChartConvertToHighCharts.class);
//        StringBuffer out = new StringBuffer();
//        //Dataset to hold data
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        //Loop on the series of the megaChart
//        for (int j = 0; j < megaChart.getMegaChartSeries().length; j++) {
//            MegaChartSeries megaChartSeries = megaChart.getMegaChartSeries()[j];
//            if (megaChartSeries.cleanData!=null && megaChartSeries.cleanData.length>0){
//                for(int i=0; i<megaChartSeries.cleanData.length; i++){
//                    //Y data must always be numeric
//                    if (reger.core.Util.isnumeric(megaChartSeries.cleanData[i][2])) {
//                        try{
//                            //Base dataset.  Will accept any x axis value
//                            dataset.addValue(Double.parseDouble(megaChartSeries.cleanData[i][2]), megaChartSeries.getyAxisTitle(), megaChartSeries.cleanData[i][1]);
//                        } catch (Exception e) {
//                            //Do not rely on this catch to fix bugs... the reason it's here
//                            //is to help the graphs be more robust.  Instead of crashing the whole
//                            //graph, only this data point won't be added.  Solve errors caught here
//                            //in the above block.
//                            Debug.errorsave(e, "", "MegaChartConvertToHighCharts - Error Adding Data to Data Set.");
//                        }
//                    }
//                }
//            }
//        }
//        return out.toString();
    }

    public static String xySeriesCollection(MegaChart megaChart){
        Logger logger = Logger.getLogger(MegaChartConvertToHighCharts.class);

        //Root JSON container
        Map<String, Object> rootJson = new HashMap<String, Object>();

        Map<String, Object> chartJson = new HashMap<String, Object>();
        chartJson.put("renderTo", "container");
        chartJson.put("type", "line");
        chartJson.put("marginRight", 130);
        chartJson.put("marginBottom", 25);
        rootJson.put("chart", chartJson);

        Map<String, Object> titleJson = new HashMap<String, Object>();
        titleJson.put("text", megaChart.getChartname());
        titleJson.put("x", -20);
        rootJson.put("title", titleJson);

        Map<String, Object> xaxisJson = new HashMap<String, Object>();
            Map<String, Object> xtitleJson = new HashMap<String, Object>();
            xtitleJson.put("enabled", true);
            xtitleJson.put("text", megaChart.getxAxisTitle());
            xaxisJson.put("title", xtitleJson);
        rootJson.put("xAxis", xaxisJson);

        Map<String, Object> yaxisJson = new HashMap<String, Object>();
            Map<String, Object> ytitleJson = new HashMap<String, Object>();
            ytitleJson.put("text", megaChart.getyAxisTitle());
            ytitleJson.put("x", -20);
            yaxisJson.put("title", ytitleJson);
        rootJson.put("yAxis", yaxisJson);

        //Data is added here
        rootJson.put("series", getSeriesDataAsJSON(megaChart));

        //Convert to JSON and wrap in HTML
        return getChartHtml(rootJson);
    }

    public static String defaultPieDataset(MegaChart megaChart){

        Logger logger = Logger.getLogger(MegaChartConvertToHighCharts.class);

        //Root JSON container
        Map<String, Object> rootJson = new HashMap<String, Object>();

        Map<String, Object> chartJson = new HashMap<String, Object>();
        chartJson.put("renderTo", "container");
        chartJson.put("type", "pie");
        chartJson.put("marginRight", 130);
        chartJson.put("marginBottom", 25);
        rootJson.put("chart", chartJson);

        Map<String, Object> titleJson = new HashMap<String, Object>();
        titleJson.put("text", megaChart.getChartname());
        titleJson.put("x", -20);
        rootJson.put("title", titleJson);

        Map<String, Object> xaxisJson = new HashMap<String, Object>();
            Map<String, Object> xtitleJson = new HashMap<String, Object>();
            xtitleJson.put("enabled", true);
            xtitleJson.put("text", megaChart.getxAxisTitle());
            xaxisJson.put("title", xtitleJson);
        rootJson.put("xAxis", xaxisJson);

        Map<String, Object> yaxisJson = new HashMap<String, Object>();
            Map<String, Object> ytitleJson = new HashMap<String, Object>();
            ytitleJson.put("text", megaChart.getyAxisTitle());
            ytitleJson.put("x", -20);
            yaxisJson.put("title", ytitleJson);
        rootJson.put("yAxis", yaxisJson);

        //Data is added here
        rootJson.put("series", getSeriesDataAsJSON(megaChart));

        //Convert to JSON and wrap in HTML
        return getChartHtml(rootJson);




//        Logger logger = Logger.getLogger(MegaChartConvertToHighCharts.class);
//        StringBuffer out = new StringBuffer();
//        //Dataset to hold data
//        DefaultPieDataset piedata = null;
//        //Loop on the series of the megaChart
//        for (int j = 0; j < megaChart.getMegaChartSeries().length; j++) {
//            MegaChartSeries megaChartSeries = megaChart.getMegaChartSeries()[j];
//            if (megaChartSeries.cleanData!=null && megaChartSeries.cleanData.length>0){
//                piedata = new DefaultPieDataset();
//                for(int i=0; i<megaChartSeries.cleanData.length; i++){
//                    //Y data must always be numeric
//                    if (reger.core.Util.isnumeric(megaChartSeries.cleanData[i][2])) {
//                        try{
//                            //Pie data. Will accept any x axis value
//                            piedata.setValue(megaChartSeries.cleanData[i][1], Double.parseDouble(megaChartSeries.cleanData[i][2]));
//                        } catch (Exception e) {
//                            //Do not rely on this catch to fix bugs... the reason it's here
//                            //is to help the graphs be more robust.  Instead of crashing the whole
//                            //graph, only this data point won't be added.  Solve errors caught here
//                            //in the above block.
//                            Debug.errorsave(e, "", "MegaChartConvertToHighCharts - Error Adding Data to Data Set.");
//                        }
//                    }
//                }
//            }
//        }
//        return out.toString();
    }


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

    public static String defaultTableXYDataset(MegaChart megaChart){
        Logger logger = Logger.getLogger(MegaChartConvertToHighCharts.class);
        StringBuffer out = new StringBuffer();
        //Dataset to hold data
        XYSeries xydataset = null;
        DefaultTableXYDataset stackedareadata = new DefaultTableXYDataset();
        //Loop on the series of the megaChart
        for (int j = 0; j < megaChart.getMegaChartSeries().length; j++) {
            MegaChartSeries megaChartSeries = megaChart.getMegaChartSeries()[j];
            if (megaChartSeries.cleanData!=null && megaChartSeries.cleanData.length>0){
                xydataset = new XYSeries(megaChartSeries.yAxisTitle, false, false);
                for(int i=0; i<megaChartSeries.cleanData.length; i++){
                    //Y data must always be numeric
                    if (reger.core.Util.isnumeric(megaChartSeries.cleanData[i][2])) {
                        try{
                            //XY Data.  Both x,y must be numeric
                            if (reger.core.Util.isnumeric(megaChartSeries.cleanData[i][1])){
                                xydataset.add(Double.parseDouble(megaChartSeries.cleanData[i][1]), Double.parseDouble(megaChartSeries.cleanData[i][2]));
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
                stackedareadata.addSeries(xydataset);
            }
        }
        return out.toString();
    }



    private static ArrayList getSeriesDataAsJSON(MegaChart megaChart){
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

    private static String getChartHtml(Map<String, Object> rootJson){
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
