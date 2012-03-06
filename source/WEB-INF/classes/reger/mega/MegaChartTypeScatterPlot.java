package reger.mega;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
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
public class MegaChartTypeScatterPlot implements MegaChartType{

    public int getCharttypeid() {
        return Vars.CHARTTYPESCATTERPLOT;
    }


    public JFreeChart getJFreeChart(MegaChart megaChart) {
        //Dataset to hold data
        XYSeriesCollection xyseries = MegaChartConvertToJFreeDataType.xySeriesCollection(megaChart);

        //Create the chart
        return ChartFactory.createScatterPlot(megaChart.getChartname(), megaChart.getxAxisTitle(), megaChart.getyAxisTitle(), xyseries,PlotOrientation.VERTICAL, true, false, false);
    }

    public JFreeChart formatChart(JFreeChart chart) {


        return chart;
    }

    public String getHighChart(MegaChart megaChart) {
        //Root JSON container
        Map<String, Object> rootJson = new HashMap<String, Object>();

        Map<String, Object> chartJson = new HashMap<String, Object>();
        chartJson.put("renderTo", "container");
        chartJson.put("type", "scatter");
        rootJson.put("chart", chartJson);

        Map<String, Object> titleJson = new HashMap<String, Object>();
        titleJson.put("text", megaChart.getChartname());
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
            yaxisJson.put("title", ytitleJson);
        rootJson.put("yAxis", yaxisJson);

        //Data is added here
        rootJson.put("series", MegaChartConvertToHighCharts.getSeriesDataDefaultXY(megaChart));

        //Convert to JSON and wrap in HTML
        String out = MegaChartConvertToHighCharts.getChartHtml(rootJson);

        return out;
    }

}
