package reger.mega;

import org.apache.log4j.Logger;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.ContourPlot;
import org.jfree.chart.axis.DateAxis;


/**
 * Gets you a jFreechart object
 */
public class MegaChartFactory {

    public static JFreeChart get(MegaChart megaChart){
        //Default Type
        MegaChartType ct = new MegaChartTypeLine();

        //Figure out which type the user wants
        if (megaChart.getxMegadatatype()==reger.mega.DataTypeString.DATATYPEID || megaChart.getCharttype()==reger.Vars.CHARTTYPE3DBAR || megaChart.getCharttype()==reger.Vars.CHARTTYPEHORIZONTALBAR || megaChart.getCharttype()==reger.Vars.CHARTTYPEHORIZONTAL3DBAR || megaChart.getCharttype()==reger.Vars.CHARTTYPEBAR  || megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART  || megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART3D || megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHARTHORIZONTAL || megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART3DHORIZONTAL) {
            if (megaChart.getCharttype()==reger.Vars.CHARTTYPE3DBAR) {
                ct = new MegaChartType3DBar();
            } else if (megaChart.getCharttype()==reger.Vars.CHARTTYPEHORIZONTALBAR) {
                ct = new MegaChartTypeHorizontalBar();
            } else if (megaChart.getCharttype()==reger.Vars.CHARTTYPEHORIZONTAL3DBAR) {
                ct = new MegaChartTypeHorizontal3dBar();
            } else if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART) {
                ct = new MegaChartTypeStackedBar();
            } else if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART3D) {
                ct = new MegaChartTypeStackedBar3d();
            } else if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHARTHORIZONTAL) {
                ct = new MegaChartTypeStackedBarHorizontal();
            } else if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART3DHORIZONTAL) {
                ct = new MegaChartTypeStackedBar3dHorizontal();
            } else {
                ct = new MegaChartTypeBar();
            }
        }
        if (megaChart.getCharttype()==reger.Vars.CHARTTYPEPIE){
           ct = new MegaChartTypePie();
        }
        if (megaChart.getCharttype()==reger.Vars.CHARTTYPE3DPIE){
           ct = new MegaChartTypePie3d();
        }
        if (megaChart.getCharttype()==reger.Vars.CHARTTYPESCATTERPLOT){
           ct = new MegaChartTypeScatterPlot();
        }
        if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTEPCHART){
           ct = new MegaChartTypeStepChart();
        }
        if (megaChart.getCharttype()==reger.Vars.CHARTTYPEAREACHART){
           ct = new MegaChartTypeAreaChart();
        }
        if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDAREA){
           ct = new MegaChartTypeStackedAreaChart();
        }
        if (megaChart.getCharttype()==reger.Vars.CHARTTYPELINE){
           ct = new MegaChartTypeLine();
        }
        if (megaChart.getxMegafieldid()==FieldType.XAXISDATETIME) {
            ct = new MegaChartTypeTimeSeries();
        }

        //Truncate the data for performance
        megaChart.truncateDataToCertainNumberOfPoints(750);
        //Create the chart
        JFreeChart chart = ct.getJFreeChart(megaChart);
        //Format the chart
        chart = ct.formatChart(chart);
        //Format yAxis date
        formatYAxisAsDate(chart, megaChart);
        //Return
        return chart;
    }


    public static String getHighChart(MegaChart megaChart){
        Logger logger = Logger.getLogger(MegaChartFactory.class);

        logger.debug("getHighChart() megaChart.getCharttype()="+megaChart.getCharttype());

        //Default Type
        MegaChartType ct = new MegaChartTypeLine();

        //Figure out which type the user wants
        if (megaChart.getxMegadatatype()==reger.mega.DataTypeString.DATATYPEID || megaChart.getCharttype()==reger.Vars.CHARTTYPE3DBAR || megaChart.getCharttype()==reger.Vars.CHARTTYPEHORIZONTALBAR || megaChart.getCharttype()==reger.Vars.CHARTTYPEHORIZONTAL3DBAR || megaChart.getCharttype()==reger.Vars.CHARTTYPEBAR  || megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART  || megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART3D || megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHARTHORIZONTAL || megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART3DHORIZONTAL) {
            if (megaChart.getCharttype()==reger.Vars.CHARTTYPE3DBAR) {
                ct = new MegaChartType3DBar();
            } else if (megaChart.getCharttype()==reger.Vars.CHARTTYPEHORIZONTALBAR) {
                ct = new MegaChartTypeHorizontalBar();
            } else if (megaChart.getCharttype()==reger.Vars.CHARTTYPEHORIZONTAL3DBAR) {
                ct = new MegaChartTypeHorizontal3dBar();
            } else if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART) {
                ct = new MegaChartTypeStackedBar();
            } else if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART3D) {
                ct = new MegaChartTypeStackedBar3d();
            } else if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHARTHORIZONTAL) {
                ct = new MegaChartTypeStackedBarHorizontal();
            } else if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDBARCHART3DHORIZONTAL) {
                ct = new MegaChartTypeStackedBar3dHorizontal();
            } else {
                ct = new MegaChartTypeBar();
            }
        }
        if (megaChart.getCharttype()==reger.Vars.CHARTTYPEPIE){
           ct = new MegaChartTypePie();
        }
        if (megaChart.getCharttype()==reger.Vars.CHARTTYPE3DPIE){
           ct = new MegaChartTypePie3d();
        }
        if (megaChart.getCharttype()==reger.Vars.CHARTTYPESCATTERPLOT){
           ct = new MegaChartTypeScatterPlot();
        }
        if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTEPCHART){
           ct = new MegaChartTypeStepChart();
        }
        if (megaChart.getCharttype()==reger.Vars.CHARTTYPEAREACHART){
           ct = new MegaChartTypeAreaChart();
        }
        if (megaChart.getCharttype()==reger.Vars.CHARTTYPESTACKEDAREA){
           ct = new MegaChartTypeStackedAreaChart();
        }
        if (megaChart.getCharttype()==reger.Vars.CHARTTYPELINE){
           ct = new MegaChartTypeLine();
        }
        if (megaChart.getxMegafieldid()==FieldType.XAXISDATETIME) {
            ct = new MegaChartTypeTimeSeries();
        }

        logger.debug("getHighChart() chosen ct="+ct.getClass().getName());

        //Truncate the data for performance
        megaChart.truncateDataToCertainNumberOfPoints(10000);
        //Create the chart
        String cStr = ct.getHighChart(megaChart);
        //Return
        return cStr.toString();
    }


    public static JFreeChart formatYAxisAsDate(JFreeChart chart, MegaChart megaChart){
         if (megaChart.getMegaChartSeries().length>0){
            if (megaChart.getMegaChartSeries()[0].yFieldtype==FieldType.FIELDTYPETIME){
                //First, create the rangeAxis
                DateAxis rangeAxis = new DateAxis("");
                java.text.DateFormat formatter = (java.text.DateFormat)new java.text.SimpleDateFormat("HH:mm:ss");
                formatter.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
                rangeAxis.setDateFormatOverride(formatter);

                //Next, apply that rangeAxis to as many types of plots as possible

                //XYPlot
                if (chart.getPlot() instanceof XYPlot){
                    XYPlot plot = chart.getXYPlot();
                    plot.setRangeAxis(rangeAxis);
                }
                //CategoryPlot
                if (chart.getPlot() instanceof CategoryPlot){
                    CategoryPlot plot = chart.getCategoryPlot();
                    plot.setRangeAxis(rangeAxis);
                }
                //Contour Plot
                if (chart.getPlot() instanceof ContourPlot){
                    ContourPlot plot = (ContourPlot)chart.getPlot();
                    plot.setRangeAxis(rangeAxis);
                }
            }
         }
         return chart;
    }



}
