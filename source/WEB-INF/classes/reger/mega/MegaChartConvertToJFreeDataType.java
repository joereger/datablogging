package reger.mega;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.Millisecond;
import reger.core.Debug;

/**
 * Converts data for a megachart into a jFree type
 */
public class MegaChartConvertToJFreeDataType {



    public static DefaultCategoryDataset defaultCategoryDataset(MegaChart megaChart){
        //Dataset to hold data
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //Loop on the series of the megaChart
        for (int j = 0; j < megaChart.getMegaChartSeries().length; j++) {
            MegaChartSeries megaChartSeries = megaChart.getMegaChartSeries()[j];
            if (megaChartSeries.cleanData!=null && megaChartSeries.cleanData.length>0){
                for(int i=0; i<megaChartSeries.cleanData.length; i++){
                    //Y data must always be numeric
                    if (reger.core.Util.isnumeric(megaChartSeries.cleanData[i][2])) {
                        try{
                            //Base dataset.  Will accept any x axis value
                            dataset.addValue(Double.parseDouble(megaChartSeries.cleanData[i][2]), megaChartSeries.getyAxisTitle(), megaChartSeries.cleanData[i][1]);
                        } catch (Exception e) {
                            //Do not rely on this catch to fix bugs... the reason it's here
                            //is to help the graphs be more robust.  Instead of crashing the whole
                            //graph, only this data point won't be added.  Solve errors caught here
                            //in the above block.
                            Debug.errorsave(e, "", "graph.log - Error Adding Data to jFreeChart Data Set.");
                        }
                    }
                }
            }
        }
        return dataset;
    }

    public static XYSeriesCollection xySeriesCollection(MegaChart megaChart){
        //Dataset to hold data
        XYSeries xydataset = null;
        XYSeriesCollection xyseries = new XYSeriesCollection();
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
                            Debug.errorsave(e, "", "graph.log - Error Adding Data to jFreeChart Data Set.");
                        }
                    }
                }
                xyseries.addSeries(xydataset);
            }
        }
        return xyseries;
    }

    public static DefaultPieDataset defaultPieDataset(MegaChart megaChart){
        //Dataset to hold data
        DefaultPieDataset piedata = null;
        //Loop on the series of the megaChart
        for (int j = 0; j < megaChart.getMegaChartSeries().length; j++) {
            MegaChartSeries megaChartSeries = megaChart.getMegaChartSeries()[j];
            if (megaChartSeries.cleanData!=null && megaChartSeries.cleanData.length>0){
                piedata = new DefaultPieDataset();
                for(int i=0; i<megaChartSeries.cleanData.length; i++){
                    //Y data must always be numeric
                    if (reger.core.Util.isnumeric(megaChartSeries.cleanData[i][2])) {
                        try{
                            //Pie data. Will accept any x axis value
                            piedata.setValue(megaChartSeries.cleanData[i][1], Double.parseDouble(megaChartSeries.cleanData[i][2]));
                        } catch (Exception e) {
                            //Do not rely on this catch to fix bugs... the reason it's here
                            //is to help the graphs be more robust.  Instead of crashing the whole
                            //graph, only this data point won't be added.  Solve errors caught here
                            //in the above block.
                            Debug.errorsave(e, "", "graph.log - Error Adding Data to jFreeChart Data Set.");
                        }
                    }
                }
            }
        }
        return piedata;
    }


    public static TimeSeriesCollection timeSeriesCollection(MegaChart megaChart){
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
                            Debug.errorsave(e, "", "graph.log - Error Adding Data to jFreeChart Data Set.");
                        }
                    }
                }
                timedataseries.addSeries(timedata);
            }
        }
        return timedataseries;
    }

    public static DefaultTableXYDataset defaultTableXYDataset(MegaChart megaChart){
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
                            Debug.errorsave(e, "", "graph.log - Error Adding Data to jFreeChart Data Set.");
                        }
                    }
                }
                stackedareadata.addSeries(xydataset);
            }
        }
        return stackedareadata;
    }
}
