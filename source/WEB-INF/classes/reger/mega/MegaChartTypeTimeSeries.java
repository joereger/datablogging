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

/**
 * Chart Type
 */
public class MegaChartTypeTimeSeries implements MegaChartType{

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
        //Dataset to hold data
        TimeSeriesCollection timedataseries = MegaChartConvertToJFreeDataType.timeSeriesCollection(megaChart);

        return "";
    }

}
