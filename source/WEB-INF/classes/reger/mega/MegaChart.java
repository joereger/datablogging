package reger.mega;

import reger.Log;
import reger.cache.LogCache;
import reger.core.db.Db;
import reger.UserSession;
import reger.AddToArray;
import reger.core.Debug;
import reger.util.Num;

import java.util.Calendar;
import java.util.Vector;

/**
 * Represents a chart.  Note that MegaChartSeries does the heavy lifting of data retrieval for a data series.
 */
public class MegaChart {

    private int megachartid=0;
    private String chartname="";
    private String xMegafieldChoice = "";
    private int xeventtypeid=0;
    private int xLogid=0;
    private int xMegafieldid=0;
    private int yaxiswhattodo=0;
    private int chartsize=0;
    private int charttype=reger.Vars.CHARTTYPELINE;
    private int daterange=0;
    private int lastxdays=0;
    private int lastxweeks=0;
    private int lastxmonths=0;
    private int lastxyears=0;
    private int daterangefromyyyy=0;
    private int daterangefrommm=0;
    private int daterangefromdd=0;
    private int daterangetoyyyy=0;
    private int daterangetomm=0;
    private int daterangetodd=0;
    private int daterangesavedsearchid=0;
    private String [] yMegafieldChoice = new String[0];
    private int[] yMegafieldid=new int[0];
    private int[] yLogid=new int[0];
    private int[] yEventtypeid=new int[0];
    private int accountid=0;

    private MegaChartSeries[] megaChartSeries = null;
    private reger.mega.MegaChartEntryChooser entryChooser = null;
    private String xAxisTitle = "";
    private String yAxisTitle = "";


    public MegaChart(int megachartid){
        load(megachartid);
    }

    public MegaChart(javax.servlet.http.HttpServletRequest request, UserSession userSession){
        populateFromRequest(request, userSession);
    }

    public void load(int megachartid){
        //Go to database and get the chart
        //-----------------------------------
        //-----------------------------------
        String[][] rstChartget= Db.RunSQL("SELECT chartname, xeventtypeid, xlogid, xmegafieldid, yaxiswhattodo, chartsize, charttype, daterange, lastxdays, lastxweeks, lastxmonths, lastxyears, daterangefromyyyy, daterangefrommm, daterangefromdd, daterangetoyyyy, daterangetomm, daterangetodd, daterangesavedsearchid, accountid FROM megachart WHERE megachartid='"+megachartid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstChartget!=null && rstChartget.length>0){
            this.megachartid=megachartid;
            chartname=rstChartget[0][0];
            xeventtypeid=Integer.parseInt(rstChartget[0][1]);
            xLogid=Integer.parseInt(rstChartget[0][2]);
            xMegafieldid=Integer.parseInt(rstChartget[0][3]);
            yaxiswhattodo=Integer.parseInt(rstChartget[0][4]);
            chartsize=Integer.parseInt(rstChartget[0][5]);
            charttype=Integer.parseInt(rstChartget[0][6]);
            daterange=Integer.parseInt(rstChartget[0][7]);
            lastxdays=Integer.parseInt(rstChartget[0][8]);
            lastxweeks=Integer.parseInt(rstChartget[0][9]);
            lastxmonths=Integer.parseInt(rstChartget[0][10]);
            lastxyears=Integer.parseInt(rstChartget[0][11]);
            daterangefromyyyy=Integer.parseInt(rstChartget[0][12]);
            daterangefrommm=Integer.parseInt(rstChartget[0][13]);
            daterangefromdd=Integer.parseInt(rstChartget[0][14]);
            daterangetoyyyy=Integer.parseInt(rstChartget[0][15]);
            daterangetomm=Integer.parseInt(rstChartget[0][16]);
            daterangetodd=Integer.parseInt(rstChartget[0][17]);
            if (reger.core.Util.isinteger(rstChartget[0][18])){
                daterangesavedsearchid=Integer.parseInt(rstChartget[0][18]);
            }
            accountid=Integer.parseInt(rstChartget[0][19]);

            //Go and get the yaxis
            //-----------------------------------
            //-----------------------------------
            String[][] rstGetyaxis= Db.RunSQL("SELECT ymegafieldid, yLogid, yeventtypeid FROM megachartyaxis WHERE megachartid='"+megachartid+"'");
            //-----------------------------------
            //-----------------------------------
            yMegafieldid = new int[rstGetyaxis.length];
            yLogid = new int[rstGetyaxis.length];
            yEventtypeid = new int[rstGetyaxis.length];
            if (rstGetyaxis!=null && rstGetyaxis.length>0){
                for(int i=0; i<rstGetyaxis.length; i++){
                    if (reger.core.Util.isinteger(rstGetyaxis[i][0])){
                        yMegafieldid[i]=Integer.parseInt(rstGetyaxis[i][0]);
                    }
                    if (reger.core.Util.isinteger(rstGetyaxis[i][1])){
                        yLogid[i]=Integer.parseInt(rstGetyaxis[i][1]);
                    }
                    if (reger.core.Util.isinteger(rstGetyaxis[i][2])){
                        yEventtypeid[i]=Integer.parseInt(rstGetyaxis[i][2]);
                    }
                }
            }
        }
    }


    public void populateFromRequest(javax.servlet.http.HttpServletRequest request, UserSession userSession){
        //Start with the megachartid and then overload
        if (Num.isinteger(request.getParameter("megachartid"))){
            load(Integer.parseInt(request.getParameter("megachartid")));
        }



        if (request.getParameter("chartname")!=null && !request.getParameter("chartname").equals("")){
            chartname=request.getParameter("chartname");
        } else {
            chartname = "";
        }

        //xMegafieldChoice = "";
        //xMegafieldid=FieldType.XAXISDATETIME;
        //xLogid = 0;
        //xeventtypeid = 0;
        if (request.getParameter("xMegafieldChoice")!=null){
            xMegafieldChoice=request.getParameter("xMegafieldChoice");
            //Break apart the xMegafieldChoice which is of the format <fieldid>_<logid>_<eventtypeid>
            if (reger.core.Util.isinteger(xMegafieldChoice.split("_")[0])){
                xMegafieldid = Integer.parseInt(xMegafieldChoice.split("_")[0]);
            }
            if (reger.core.Util.isinteger(xMegafieldChoice.split("_")[1])){
                xLogid = Integer.parseInt(xMegafieldChoice.split("_")[1]);
            }
            if (reger.core.Util.isinteger(xMegafieldChoice.split("_")[2])){
                xeventtypeid = Integer.parseInt(xMegafieldChoice.split("_")[2]);
            }
        }
        if (xMegafieldChoice==null || xMegafieldChoice.equals("")){
            //If there's no logid, I have to choose one.  This happens
            //when a user clicks on a system graph.  There is an eventtypeid,
            //but no logid.  So I'll choose the first logid that is of the type
            //that the system graph needs. This is kind of ugly.
            int tmpxLogid = xLogid;
            if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0){
                Vector tmpLogs = LogCache.allLogsForAccount(userSession.getAccount().getAccountid());
                if(tmpxLogid<=0 && xeventtypeid>0){
                    for (int j = 0; j < tmpLogs.size(); j++) {
                        Log log = (Log) tmpLogs.elementAt(j);
                        if (log.getEventtypeid()==xeventtypeid){
                            tmpxLogid=log.getLogid();
                        }
                    }
                }
            }
            //Set xMegaFieldChoice
            xMegafieldChoice = xMegafieldid+"_"+tmpxLogid+"_"+xeventtypeid;
        }





        //yMegafieldChoice = new String[0];
        //yMegafieldid = new int[0];
        //yLogid = new int[0];
        //yEventtypeid = new int[0];
        if (request.getParameter("yMegafieldChoice")!=null){
            yMegafieldChoice=request.getParameterValues("yMegafieldChoice");
        }
        if (yMegafieldChoice==null || yMegafieldChoice.length==0){
            yMegafieldChoice = new String[yMegafieldid.length];
            for(int i=0; i<yMegafieldid.length; i++){
                //If there's no logid, I have to choose one.  This happens
                //when a user clicks on a system graph.  There is an eventtypeid,
                //but no logid.  So I'll choose the first logid that is of the type
                //that the system graph needs. This is kind of ugly.
                int tmpyLogid = yLogid[i];
                if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0){
                    Vector tmpLogs = LogCache.allLogsForAccount(userSession.getAccount().getAccountid());
                    if(tmpyLogid<=0 && yEventtypeid[i]>0){
                        for (int j = 0; j < tmpLogs.size(); j++) {
                            Log log = (Log) tmpLogs.elementAt(j);
                            if (log.getEventtypeid()==yEventtypeid[i]){
                                tmpyLogid=log.getLogid();
                            }
                        }
                    }
                }
                //Set yMegafieldChoice
                yMegafieldChoice[i] = yMegafieldid[i]+"_"+tmpyLogid+"_"+yEventtypeid[i];
            }
        }
        if (yMegafieldChoice.length>0){
            //Break apart the yMegafieldChoice which is of the format <fieldid>_<logid>_<eventtypeid>
            //reger.core.Debug.logtodb("Starting to dissect yMegafieldChoice", "MegaChart.java");
            for (int i = 0; i < yMegafieldChoice.length; i++) {
                if (reger.core.Util.isinteger(yMegafieldChoice[i].split("_")[0]) && !reger.core.Util.arrayContainsValue(yMegafieldid, new Integer(yMegafieldChoice[i].split("_")[0]).intValue())){
                    if (reger.core.Util.isinteger(yMegafieldChoice[i].split("_")[0])){
                        yMegafieldid = reger.core.Util.addToIntArray(yMegafieldid, Integer.parseInt(yMegafieldChoice[i].split("_")[0]));
                    }
                    if (reger.core.Util.isinteger(yMegafieldChoice[i].split("_")[1])){
                        yLogid = reger.core.Util.addToIntArray(yLogid, Integer.parseInt(yMegafieldChoice[i].split("_")[1]));
                    }
                    if (reger.core.Util.isinteger(yMegafieldChoice[i].split("_")[2])){
                        yEventtypeid = reger.core.Util.addToIntArray(yEventtypeid, Integer.parseInt(yMegafieldChoice[i].split("_")[2]));
                    }
                }
                //reger.core.Debug.logIntArrayToDb("MegaChart.java - inside loop on yMegafieldChoice i="+i+" now tracking yMegafieldid", yMegafieldid);

            }
            //reger.core.Debug.logIntArrayToDb("MegaChart.java - FINAL yMegafieldid", yMegafieldid);
            //reger.core.Debug.logtodb("Done dissecting yMegafieldChoice", "MegaChart.java");
        } else {
            yMegafieldid = new int[1];
            yMegafieldid[0] = reger.mega.FieldType.YAXISCOUNT;
            yLogid = new int[1];
            yLogid[0] = 0;
            yEventtypeid = new int[1];
            yEventtypeid[0] = 0;
        }

        //daterange=reger.Vars.DATERANGEALLTIME;
        if (request.getParameter("daterange")!=null && reger.core.Util.isinteger(request.getParameter("daterange"))){
            daterange=Integer.parseInt(request.getParameter("daterange"));
        }

        //chartsize=reger.Vars.CHARTSIZEMEDIUM;
        if (request.getParameter("chartsize")!=null && reger.core.Util.isinteger(request.getParameter("chartsize"))){
            chartsize=Integer.parseInt(request.getParameter("chartsize"));
        }

        //yaxiswhattodo=reger.Vars.YAXISWHATTODOSUM;
        if (request.getParameter("yaxiswhattodo")!=null && reger.core.Util.isinteger(request.getParameter("yaxiswhattodo"))){
            yaxiswhattodo=Integer.parseInt(request.getParameter("yaxiswhattodo"));
        }


        if (request.getParameter("charttype")!=null && reger.core.Util.isinteger(request.getParameter("charttype"))){
            charttype=Integer.parseInt(request.getParameter("charttype"));
        }
        //lastxdays=1;
        if (request.getParameter("lastxdays")!=null && reger.core.Util.isinteger(request.getParameter("lastxdays"))){
            lastxdays=Integer.parseInt(request.getParameter("lastxdays"));
        }
        //lastxweeks=1;
        if (request.getParameter("lastxweeks")!=null && reger.core.Util.isinteger(request.getParameter("lastxweeks"))){
            lastxweeks=Integer.parseInt(request.getParameter("lastxweeks"));
        }
        //lastxmonths=1;
        if (request.getParameter("lastxmonths")!=null && reger.core.Util.isinteger(request.getParameter("lastxmonths"))){
            lastxmonths=Integer.parseInt(request.getParameter("lastxmonths"));
        }
        //lastxyears=1;
        if (request.getParameter("lastxyears")!=null && reger.core.Util.isinteger(request.getParameter("lastxyears"))){
            lastxyears=Integer.parseInt(request.getParameter("lastxyears"));
        }
        //daterangefromyyyy=Calendar.getInstance().get(Calendar.YEAR)-1;
        if (request.getParameter("daterangefromyyyy")!=null && reger.core.Util.isinteger(request.getParameter("daterangefromyyyy"))){
            daterangefromyyyy=Integer.parseInt(request.getParameter("daterangefromyyyy"));
        }
        //daterangefrommm=Calendar.getInstance().get(Calendar.MONTH)+1;
        if (request.getParameter("daterangefrommm")!=null && reger.core.Util.isinteger(request.getParameter("daterangefrommm"))){
            daterangefrommm=Integer.parseInt(request.getParameter("daterangefrommm"));
        }
        //daterangefromdd=Calendar.getInstance().get(Calendar.DATE);
        if (request.getParameter("daterangefromdd")!=null && reger.core.Util.isinteger(request.getParameter("daterangefromdd"))){
            daterangefromdd=Integer.parseInt(request.getParameter("daterangefromdd"));
        }
        //daterangetoyyyy=Calendar.getInstance().get(Calendar.YEAR);
        if (request.getParameter("daterangetoyyyy")!=null && reger.core.Util.isinteger(request.getParameter("daterangetoyyyy"))){
            daterangetoyyyy=Integer.parseInt(request.getParameter("daterangetoyyyy"));
        }
        //daterangetomm=Calendar.getInstance().get(Calendar.MONTH)+1;
        if (request.getParameter("daterangetomm")!=null && reger.core.Util.isinteger(request.getParameter("daterangetomm"))){
            daterangetomm=Integer.parseInt(request.getParameter("daterangetomm"));
        }
        //daterangetodd=Calendar.getInstance().get(Calendar.DATE);
        if (request.getParameter("daterangetodd")!=null && reger.core.Util.isinteger(request.getParameter("daterangetodd"))){
            daterangetodd=Integer.parseInt(request.getParameter("daterangetodd"));
        }
        //daterangesavedsearchid=0;
        if (request.getParameter("daterangesavedsearchid")!=null && reger.core.Util.isinteger(request.getParameter("daterangesavedsearchid"))){
            daterangesavedsearchid=Integer.parseInt(request.getParameter("daterangesavedsearchid"));
        }
    }

    public void loadMegaChartSeriesData(UserSession userSession){
        //Get the list of entries that this chart covers
        entryChooser = new reger.mega.MegaChartEntryChooser(userSession, this);
        entryChooser.populate();

        Debug.debug(5, "", "MegaChart.java - entryChooser.getIntListOfEventids().length="+entryChooser.getIntListOfEventids().length);
        int debugCount = 0;
        //Iterate yAxis and create a series for each
        for (int i = 0; i < yMegafieldid.length; i++) {
            int yMegaFieldidTmp = yMegafieldid[i];
            int yLogidTmp = yLogid[i];
            MegaChartSeries seriesTmp = new MegaChartSeries(yMegaFieldidTmp, yLogidTmp, this, entryChooser);
            xAxisTitle = seriesTmp.getxAxisTitle();
            yAxisTitle = seriesTmp.getyAxisTitle();
            megaChartSeries = AddToArray.addToMegaChartSeriesArray(megaChartSeries, seriesTmp);
            Debug.debug(5, "", "MegaChart.java - seriesTmp.cleanData.length="+seriesTmp.cleanData.length);
            debugCount = debugCount + seriesTmp.cleanData.length;
        }
        Debug.debug(5, "", "MegaChart.java - items graphed="+debugCount);
    }

    public MegaChartSeries[] getMegaChartSeries(){
        return megaChartSeries;
    }

    public void setMegaChartSeriesAsPreview(){
        this.megaChartSeries = new MegaChartSeries[0];
        //Iterate yAxis and create a series for each
        for (int i = 0; i < yMegafieldid.length; i++) {
            MegaChartSeries seriesTmp = new reger.mega.MegaChartPreviewSeries(xMegafieldid, yMegafieldid[i]);
            megaChartSeries = AddToArray.addToMegaChartSeriesArray(megaChartSeries, seriesTmp);
        }
    }

    public MegaChartEntryChooser getEntryChooser() {
        return entryChooser;
    }

    public void save(){


        //Try to update the chart
        boolean updateSuccessful = false;
        if (megachartid>0){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE megachart SET chartname='"+reger.core.Util.cleanForSQL(chartname)+"', xeventtypeid='"+xeventtypeid+"', xlogid='"+xLogid+"', xmegafieldid='"+xMegafieldid+"', yaxiswhattodo='"+yaxiswhattodo+"', chartsize='"+chartsize+"', charttype='"+charttype+"', daterange='"+daterange+"', lastxdays='"+lastxdays+"', lastxweeks='"+lastxweeks+"', lastxmonths='"+lastxmonths+"', lastxyears='"+lastxyears+"', daterangefromyyyy='"+daterangefromyyyy+"', daterangefrommm='"+daterangefrommm+"', daterangefromdd='"+daterangefromdd+"', daterangetoyyyy='"+daterangetoyyyy+"', daterangetomm='"+daterangetomm+"', daterangetodd='"+daterangetodd+"', daterangesavedsearchid='"+daterangesavedsearchid+"', accountid='"+accountid+"' WHERE megachartid='"+megachartid+"'");
            //-----------------------------------
            //-----------------------------------
            if (count>0){
                updateSuccessful=true;
            }
        }

        //Insert a new record, if necessary
        if (!updateSuccessful){
            //Store the main chart
            //-----------------------------------
            //-----------------------------------
            megachartid = Db.RunSQLInsert("INSERT INTO megachart(chartname, xeventtypeid, xlogid, xmegafieldid, yaxiswhattodo, chartsize, charttype, daterange, lastxdays, lastxweeks, lastxmonths, lastxyears, daterangefromyyyy, daterangefrommm, daterangefromdd, daterangetoyyyy, daterangetomm, daterangetodd, daterangesavedsearchid, accountid) VALUES('"+reger.core.Util.cleanForSQL(chartname)+"', '"+xeventtypeid+"', '"+xLogid+"', '"+xMegafieldid+"', '"+yaxiswhattodo+"', '"+chartsize+"', '"+charttype+"', '"+daterange+"', '"+lastxdays+"', '"+lastxweeks+"', '"+lastxmonths+"', '"+lastxyears+"', '"+daterangefromyyyy+"', '"+daterangefrommm+"', '"+daterangefromdd+"', '"+daterangetoyyyy+"', '"+daterangetomm+"', '"+daterangetodd+"', '"+daterangesavedsearchid+"', '"+accountid+"')");
            //-----------------------------------
            //-----------------------------------

            //Update the AccountCounts cache
            reger.cache.AccountCountCache.flushByAccountid(accountid);
        }

        //Clean out any existing yaxis values
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM megachartyaxis WHERE megachartid='"+megachartid+"'");
        //-----------------------------------
        //-----------------------------------


        //Store the yaxis values
        for(int i=0; i<yMegafieldid.length; i++){
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO megachartyaxis(megachartid, ymegafieldid, ylogid, yeventtypeid) VALUES('"+megachartid+"', '"+yMegafieldid[i]+"', '"+yLogid[i]+"', '"+yEventtypeid[i]+"')");
            //-----------------------------------
            //-----------------------------------
        }


    }

    public void delete(){
        //Delete the megachart
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM megachart WHERE megachartid='"+megachartid+"'");
        //-----------------------------------
        //-----------------------------------

        //Delete the megachart yaxis values
        //-----------------------------------
        //-----------------------------------
        int count2 = Db.RunSQLUpdate("DELETE FROM megachartyaxis WHERE megachartid='"+megachartid+"'");
        //-----------------------------------
        //-----------------------------------

        //Update the AccountCounts cache
            reger.cache.AccountCountCache.flushByAccountid(accountid);
    }

    public int getxMegadatatype(){
        if (megaChartSeries!=null && megaChartSeries.length>0){
            return megaChartSeries[0].getxMegadatatype();
        } else {
            return reger.mega.DataTypeString.DATATYPEID;
        }
    }

    public void truncateDataToCertainNumberOfPoints(int maxNumberOfPoints){
        //For each series in the chart
        for (int j = 0; j < megaChartSeries.length; j++) {
            //If the data is bigger than the maxNumberOfPoints
            if (getMegaChartSeries()[j].cleanData!=null && getMegaChartSeries()[j].cleanData.length>maxNumberOfPoints){
                String[][] tmpData = new String[maxNumberOfPoints][];
                //Dump the first maxNumberOfPoints data points into tmpData
                for(int i=0; i<maxNumberOfPoints; i++){
                    tmpData[i] = getMegaChartSeries()[j].cleanData[i];
                }
                //Set the series data to the tmpData
                getMegaChartSeries()[j].cleanData = tmpData;
            }
        }
    }


    public int getMegachartid() {
        return megachartid;
    }

    public void setMegachartid(int megachartid) {
        this.megachartid = megachartid;
    }

    public String getChartname() {
        return chartname;
    }

    public void setChartname(String chartname) {
        this.chartname = chartname;
    }

    public int getXeventtypeid() {
        return xeventtypeid;
    }

    public void setXeventtypeid(int xeventtypeid) {
        this.xeventtypeid = xeventtypeid;
    }

    public int getxLogid() {
        return xLogid;
    }

    public void setxLogid(int xLogid) {
        this.xLogid = xLogid;
    }

    public int getxMegafieldid() {
        return xMegafieldid;
    }

    public void setxMegafieldid(int xMegafieldid) {
        this.xMegafieldid = xMegafieldid;
    }

    public int getYaxiswhattodo() {
        return yaxiswhattodo;
    }

    public void setYaxiswhattodo(int yaxiswhattodo) {
        this.yaxiswhattodo = yaxiswhattodo;
    }

    public int getChartsize() {
        return chartsize;
    }

    public void setChartsize(int chartsize) {
        this.chartsize = chartsize;
    }

    public int getCharttype() {
        return charttype;
    }

    public void setCharttype(int charttype) {
        this.charttype = charttype;
    }

    public int getDaterange() {
        return daterange;
    }

    public void setDaterange(int daterange) {
        this.daterange = daterange;
    }

    public int getLastxdays() {
        return lastxdays;
    }

    public void setLastxdays(int lastxdays) {
        this.lastxdays = lastxdays;
    }

    public int getLastxweeks() {
        return lastxweeks;
    }

    public void setLastxweeks(int lastxweeks) {
        this.lastxweeks = lastxweeks;
    }

    public int getLastxmonths() {
        return lastxmonths;
    }

    public void setLastxmonths(int lastxmonths) {
        this.lastxmonths = lastxmonths;
    }

    public int getLastxyears() {
        return lastxyears;
    }

    public void setLastxyears(int lastxyears) {
        this.lastxyears = lastxyears;
    }

    public int getDaterangefromyyyy() {
        return daterangefromyyyy;
    }

    public void setDaterangefromyyyy(int daterangefromyyyy) {
        this.daterangefromyyyy = daterangefromyyyy;
    }

    public int getDaterangefrommm() {
        return daterangefrommm;
    }

    public void setDaterangefrommm(int daterangefrommm) {
        this.daterangefrommm = daterangefrommm;
    }

    public int getDaterangefromdd() {
        return daterangefromdd;
    }

    public void setDaterangefromdd(int daterangefromdd) {
        this.daterangefromdd = daterangefromdd;
    }

    public int getDaterangetoyyyy() {
        return daterangetoyyyy;
    }

    public void setDaterangetoyyyy(int daterangetoyyyy) {
        this.daterangetoyyyy = daterangetoyyyy;
    }

    public int getDaterangetomm() {
        return daterangetomm;
    }

    public void setDaterangetomm(int daterangetomm) {
        this.daterangetomm = daterangetomm;
    }

    public int getDaterangetodd() {
        return daterangetodd;
    }

    public void setDaterangetodd(int daterangetodd) {
        this.daterangetodd = daterangetodd;
    }

    public int getDaterangesavedsearchid() {
        return daterangesavedsearchid;
    }

    public void setDaterangesavedsearchid(int daterangesavedsearchid) {
        this.daterangesavedsearchid = daterangesavedsearchid;
    }

    public int[] getyMegafieldid() {
        return yMegafieldid;
    }

    public void setyMegafieldid(int[] yMegafieldid) {
        this.yMegafieldid = yMegafieldid;
    }

    public int[] getyLogid() {
        return yLogid;
    }

    public void setyLogid(int[] yLogid) {
        this.yLogid = yLogid;
    }

    public int[] getyEventtypeid() {
        return yEventtypeid;
    }

    public void setyEventtypeid(int[] yEventtypeid) {
        this.yEventtypeid = yEventtypeid;
    }

    public String getxMegafieldChoice() {
        return xMegafieldChoice;
    }

    public void setxMegafieldChoice(String xMegafieldChoice) {
        this.xMegafieldChoice = xMegafieldChoice;
    }

    public String[] getyMegafieldChoice() {
        return yMegafieldChoice;
    }

    public void setyMegafieldChoice(String[] yMegafieldChoice) {
        this.yMegafieldChoice = yMegafieldChoice;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getxAxisTitle() {
        return xAxisTitle;
    }

    public String getyAxisTitle() {
        return yAxisTitle;
    }
}
