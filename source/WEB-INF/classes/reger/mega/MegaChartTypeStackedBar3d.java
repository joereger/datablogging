package reger.mega;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
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
public class MegaChartTypeStackedBar3d implements MegaChartType{

    public JFreeChart getJFreeChart(MegaChart megaChart) {
        //Dataset to hold data
        DefaultCategoryDataset dataset = MegaChartConvertToJFreeDataType.defaultCategoryDataset(megaChart);

        //Create the chart
        return ChartFactory.createStackedBarChart3D(megaChart.getChartname(), megaChart.getxAxisTitle(), megaChart.getyAxisTitle(), dataset, PlotOrientation.VERTICAL, true, false, false);
    }

    public JFreeChart formatChart(JFreeChart chart) {
        return chart;
    }

    public String getHighChart(MegaChart megaChart) {
        String out = MegaChartConvertToHighCharts.defaultCategoryDataset(megaChart);
        return out;
    }

}
