package reger.mega;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.ContourPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.general.DefaultPieDataset;
import reger.Vars;

import java.util.HashMap;
import java.util.Map;

/**
 * Chart Type
 */
public class MegaChartTypeTimeSeries implements MegaChartType{

    public int getCharttypeid() {
        return Vars.CHARTTYPETIMESERIES;
    }

    public JFreeChart getJFreeChart(MegaChart megaChart) {
        //Dataset to hold data
        TimeSeriesCollection timedataseries = MegaChartConvertToJFreeDataType.timeSeriesCollection(megaChart);

        //Create the chart
        return ChartFactory.createTimeSeriesChart(megaChart.getChartname(), megaChart.getxAxisTitle(), megaChart.getyAxisTitle(), timedataseries, true, false, false);
    }

    public JFreeChart formatChart(JFreeChart chart) {
        return chart;
    }

    public String getHighChart(MegaChart megaChart) {
        //Root JSON container
        Map<String, Object> rootJson = new HashMap<String, Object>();

        Map<String, Object> chartJson = new HashMap<String, Object>();
        chartJson.put("renderTo", "container");
        chartJson.put("type", "spline");
        rootJson.put("chart", chartJson);

        Map<String, Object> titleJson = new HashMap<String, Object>();
        titleJson.put("text", megaChart.getChartname());
        rootJson.put("title", titleJson);

        Map<String, Object> xaxisJson = new HashMap<String, Object>();
        xaxisJson.put("type", "datetime");
        rootJson.put("xAxis", xaxisJson);

        Map<String, Object> yaxisJson = new HashMap<String, Object>();
            Map<String, Object> ytitleJson = new HashMap<String, Object>();
            ytitleJson.put("text", megaChart.getyAxisTitle());
            yaxisJson.put("title", ytitleJson);
        rootJson.put("yAxis", yaxisJson);

        //Data is added here
        rootJson.put("series", MegaChartConvertToHighCharts.getSeriesDataTimeSeries(megaChart));

        //Convert to JSON and wrap in HTML
        String out = MegaChartConvertToHighCharts.getChartHtml(rootJson);

        return out;
    }

}
