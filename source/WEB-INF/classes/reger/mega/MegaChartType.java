package reger.mega;

import org.jfree.chart.JFreeChart;

/**
 * A chart type is pie, xy, bar, etc.
 */
public interface MegaChartType {

    public JFreeChart getJFreeChart(MegaChart megaChart);

    public String getHighChart(MegaChart megaChart);

    public JFreeChart formatChart(JFreeChart chart);

    public int getCharttypeid();

}
