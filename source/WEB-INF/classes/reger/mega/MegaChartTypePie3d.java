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
import reger.Vars;

import java.util.HashMap;
import java.util.Map;

/**
 * Chart Type
 */
public class MegaChartTypePie3d implements MegaChartType{

    public int getCharttypeid() {
        return Vars.CHARTTYPE3DPIE;
    }

    public JFreeChart getJFreeChart(MegaChart megaChart) {
        //Dataset to hold data
        DefaultPieDataset piedata = MegaChartConvertToJFreeDataType.defaultPieDataset(megaChart);


        //Create the chart
        return ChartFactory.createPieChart3D(megaChart.getChartname(), piedata, true, false, false);
    }

    public JFreeChart formatChart(JFreeChart chart) {
        return chart;
    }

    public String getHighChart(MegaChart megaChart) {
        MegaChartType ct = new MegaChartTypePie();
        return ct.getHighChart(megaChart);
    }

}
