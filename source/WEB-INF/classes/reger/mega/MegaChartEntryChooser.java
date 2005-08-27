package reger.mega;

import reger.search.SearchResult;
import reger.core.db.Db;
import reger.UserSession;
import reger.core.db.Db;

import java.util.Calendar;
import java.util.TreeMap;

/**
 * So that I don't have to call the database for each series, this object
 * creates and stores those entries that may be related to the chart at hand.
 */
public class MegaChartEntryChooser {

    private int[] intListOfEventids = new int[0];

    //These are the vars required to execute the search
    private UserSession userSession;
    private MegaChart megaChart;

    //Derived
    private String dateSql = "";


    public MegaChartEntryChooser(UserSession userSession, MegaChart megaChart){
        this.userSession = userSession;
        this.megaChart = megaChart;
    }



    public int[] getIntListOfEventids(){
        return intListOfEventids;
    }




    public void populate(){
        //I need to get a list of events that make up the data for this chart.
        //I can do this one of two ways.
        //The first way is via a saved search.
        //The second way is via sql string building
        intListOfEventids = new int[0];
        if (megaChart.getDaterange()==reger.Vars.DATERANGESAVEDSEARCH){
            //Start to run a saved search
            if (megaChart.getDaterangesavedsearchid()>0){
                reger.core.Util.debug(5, "MegaChartSeries.java - Searching daterangesavedsearchid=" + megaChart.getDaterangesavedsearchid());
                reger.search.SearchParameters sp = new reger.search.SearchParameters(megaChart.getDaterangesavedsearchid());
                sp.numberOfResultsToReturn = 5000;
                reger.search.SearchEntries se = new reger.search.SearchEntries(sp);
                se.setCoreOfSearcher(userSession);
                //Execute the search
                se.doSearch();
                if (se.entrySearchResults!=null){
                    for (int i = 0; i < se.entrySearchResults.length; i++) {
                        SearchResult entrySearchResult = se.entrySearchResults[i];
                        reger.core.Util.debug(5, "MegaChartSeries.java - Found a result:<br>daterangesavedsearchid=" + megaChart.getDaterangesavedsearchid() + "<br>se.entrySearchResults[i].typeOfObjectReturned=" + se.entrySearchResults[i].typeOfObjectReturned + "<br>SearchResult.SEARCHRESULTOBJECTTYPEENTRY="+SearchResult.SEARCHRESULTOBJECTTYPEENTRY);
                        if (entrySearchResult.typeOfObjectReturned==SearchResult.SEARCHRESULTOBJECTTYPEENTRY){
                            intListOfEventids = reger.core.Util.addToIntArray(intListOfEventids, entrySearchResult.idOfObjectReturned);
                        }
                    }
                }
            }
        } else {
            //Start Build the date-limiting SQL - The goal of the next chunk is to build a SQL statement
            //that returns a three column resultset (eventid, xaxis, yaxis)
            dateSql="";
            if (megaChart.getDaterange()==reger.Vars.DATERANGETHISWEEK){
                dateSql = " AND event.date>'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xWeeksAgoStart(Calendar.getInstance(), 0)) + "' AND event.date<'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xWeeksAgoEnd(Calendar.getInstance(), 0)) + "'";
            } else if (megaChart.getDaterange()==reger.Vars.DATERANGETHISMONTH) {
                dateSql = " AND event.date>'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xMonthsAgoStart(Calendar.getInstance(), 0)) + "' AND event.date<'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xMonthsAgoEnd(Calendar.getInstance(), 0)) + "'";
            } else if (megaChart.getDaterange()==reger.Vars.DATERANGETHISYEAR) {
                dateSql = " AND event.date>'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xYearsAgoStart(Calendar.getInstance(), 0)) + "' AND event.date<'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xYearsAgoEnd(Calendar.getInstance(), 0)) + "'";
            } else if (megaChart.getDaterange()==reger.Vars.DATERANGELASTWEEK){
                dateSql = " AND event.date>'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xWeeksAgoStart(Calendar.getInstance(), 1)) + "' AND event.date<'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xWeeksAgoEnd(Calendar.getInstance(), 1)) + "'";
            } else if (megaChart.getDaterange()==reger.Vars.DATERANGELASTMONTH) {
                dateSql = " AND event.date>'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xMonthsAgoStart(Calendar.getInstance(), 1)) + "' AND event.date<'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xMonthsAgoEnd(Calendar.getInstance(), 1)) + "'";
            } else if (megaChart.getDaterange()==reger.Vars.DATERANGELASTYEAR) {
                dateSql = " AND event.date>'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xYearsAgoStart(Calendar.getInstance(), 1)) + "' AND event.date<'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xMonthsAgoEnd(Calendar.getInstance(), 1)) + "'";
            } else if (megaChart.getDaterange()==reger.Vars.DATERANGELASTXDAYS) {
                dateSql = " AND event.date>'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xDaysAgoStart(Calendar.getInstance(), megaChart.getLastxdays())) + "' AND event.date<'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.maxTime(Calendar.getInstance())) + "'";
            } else if (megaChart.getDaterange()==reger.Vars.DATERANGELASTXWEEKS) {
                dateSql = " AND event.date>'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xWeeksAgoStart(Calendar.getInstance(), megaChart.getLastxweeks())) + "' AND event.date<'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.maxTime(Calendar.getInstance())) + "'";
            } else if (megaChart.getDaterange()==reger.Vars.DATERANGELASTXMONTHS) {
                dateSql = " AND event.date>'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xMonthsAgoStart(Calendar.getInstance(), megaChart.getLastxmonths())) + "' AND event.date<'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.maxTime(Calendar.getInstance())) + "'";
            } else if (megaChart.getDaterange()==reger.Vars.DATERANGELASTXYEARS) {
                dateSql = " AND event.date>'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xYearsAgoStart(Calendar.getInstance(), megaChart.getLastxyears())) + "' AND event.date<'" + reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.maxTime(Calendar.getInstance())) + "'";
            } else if (megaChart.getDaterange()==reger.Vars.DATERANGESPECIFIED) {
                dateSql = " AND event.date>'"+megaChart.getDaterangefromyyyy()+"-"+megaChart.getDaterangefrommm() +"-"+megaChart.getDaterangefromdd()+" 00:00:00' AND event.date<'"+megaChart.getDaterangetoyyyy()+"-"+megaChart.getDaterangetomm() +"-"+megaChart.getDaterangetodd()+" 23:59:59'";
            }

            //First, make sure user can view all logs in the chart currently
            String logidSql = "(";
            if (userSession!=null && userSession.getAccountuser()!=null && userSession.getAccountuser().userCanViewLog(megaChart.getxLogid())){
                logidSql = logidSql + "event.logid='" + megaChart.getxLogid() + "'";
            } else {
                logidSql = logidSql + "event.logid='-99999'";
            }
            logidSql = logidSql + getYLogidSql() + ")";


            //This query generates a list of eventids that are relevant to this chart.  That's it.
            //@todo Wrap in multiple calls to DB to batch
            String sql = "SELECT event.eventid FROM event WHERE "+logidSql+ " " + dateSql + " AND " + reger.Entry.sqlOfLiveEntry;
            reger.core.Util.debug(3, sql);
            //-----------------------------------
            //-----------------------------------
            String [][] rawListOfEventids = Db.RunSQL(sql, 500000);
            //-----------------------------------
            //-----------------------------------

            //Convert list of eventids to int array
            if (rawListOfEventids!=null && rawListOfEventids.length>0){
                intListOfEventids = new int[rawListOfEventids.length];
                for(int i=0; i<rawListOfEventids.length; i++){
                    intListOfEventids[i] = Integer.parseInt(rawListOfEventids[i][0]);
                }
            }
        }
    }

    private String getYLogidSql(){
        String sql = "";
        if (megaChart.getyLogid()!=null){
            for(int i=0; i<megaChart.getyLogid().length; i++){
                if (megaChart.getyLogid()[i]>0){
                    if (userSession!=null && userSession.getAccountuser()!=null && userSession.getAccountuser().userCanViewLog(megaChart.getyLogid()[i])){
                        sql=sql + " OR event.logid='"+ megaChart.getyLogid()[i] +"' ";
                    }
                }
            }
        }
        return sql;
    }



}
