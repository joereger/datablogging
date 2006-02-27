package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'megachart' database table
 * 
 * DO NOT EDIT MANUALLY
 * 
 *   ______             ____  _____         _     ________        __   _   _   
 *  |_   _ `.          |_   \|_   _|       / |_  |_   __  |      |  ] (_) / |_ 
 *    | | `. \  .--.     |   \ | |   .--. `| |-'   | |_ \_|  .--.| |  __ `| |-'
 *    | |  | |/ .'`\ \   | |\ \| | / .'`\ \| |     |  _| _ / /'`\' | [  | | |  
 *   _| |_.' /| \__. |  _| |_\   |_| \__. || |,   _| |__/ || \__/  |  | | | |, 
 *  |______.'  '.__.'  |_____|\____|'.__.' \__/  |________| '.__.;__][___]\__/
 * 
 * Validator for this DAO: reger.dao.validators.ValidatorMegachartDAO.java
 * Finders for this DAO: reger.dao.finders.MegachartFinder.java
 * 
 */

public class MegachartDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "megachartDAO";

    protected int megachartid = 0;
    protected String chartname = "";
    protected int xeventtypeid = 0;
    protected int xlogid = 0;
    protected int xmegafieldid = 0;
    protected int yaxiswhattodo = 0;
    protected int chartsize = 0;
    protected int charttype = 0;
    protected int daterange = 0;
    protected int lastxdays = 0;
    protected int lastxweeks = 0;
    protected int lastxmonths = 0;
    protected int lastxyears = 0;
    protected int daterangefromyyyy = 0;
    protected int daterangefrommm = 0;
    protected int daterangefromdd = 0;
    protected int daterangetoyyyy = 0;
    protected int daterangetomm = 0;
    protected int daterangetodd = 0;
    protected int daterangesavedsearchid = 0;
    protected int accountid = 0;

    public MegachartDAO (int megachartid){
        this.megachartid = megachartid;
        load();
    }

    public MegachartDAO(){


    }

    public void load(){
        if (megachartid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(megachartid), CACHEGROUP);
            if (obj!=null && (obj instanceof MegachartDAO)){
                setProperties((MegachartDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT megachartid, chartname, xeventtypeid, xlogid, xmegafieldid, yaxiswhattodo, chartsize, charttype, daterange, lastxdays, lastxweeks, lastxmonths, lastxyears, daterangefromyyyy, daterangefrommm, daterangefromdd, daterangetoyyyy, daterangetomm, daterangetodd, daterangesavedsearchid, accountid  FROM megachart WHERE megachartid='"+megachartid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        megachartid = Integer.parseInt(rstData[0][0]);
                    } else {
                        megachartid = 0;
                    }

                    chartname = rstData[0][1];

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        xeventtypeid = Integer.parseInt(rstData[0][2]);
                    } else {
                        xeventtypeid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        xlogid = Integer.parseInt(rstData[0][3]);
                    } else {
                        xlogid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][4])){
                        xmegafieldid = Integer.parseInt(rstData[0][4]);
                    } else {
                        xmegafieldid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][5])){
                        yaxiswhattodo = Integer.parseInt(rstData[0][5]);
                    } else {
                        yaxiswhattodo = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][6])){
                        chartsize = Integer.parseInt(rstData[0][6]);
                    } else {
                        chartsize = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][7])){
                        charttype = Integer.parseInt(rstData[0][7]);
                    } else {
                        charttype = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][8])){
                        daterange = Integer.parseInt(rstData[0][8]);
                    } else {
                        daterange = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][9])){
                        lastxdays = Integer.parseInt(rstData[0][9]);
                    } else {
                        lastxdays = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][10])){
                        lastxweeks = Integer.parseInt(rstData[0][10]);
                    } else {
                        lastxweeks = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][11])){
                        lastxmonths = Integer.parseInt(rstData[0][11]);
                    } else {
                        lastxmonths = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][12])){
                        lastxyears = Integer.parseInt(rstData[0][12]);
                    } else {
                        lastxyears = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][13])){
                        daterangefromyyyy = Integer.parseInt(rstData[0][13]);
                    } else {
                        daterangefromyyyy = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][14])){
                        daterangefrommm = Integer.parseInt(rstData[0][14]);
                    } else {
                        daterangefrommm = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][15])){
                        daterangefromdd = Integer.parseInt(rstData[0][15]);
                    } else {
                        daterangefromdd = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][16])){
                        daterangetoyyyy = Integer.parseInt(rstData[0][16]);
                    } else {
                        daterangetoyyyy = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][17])){
                        daterangetomm = Integer.parseInt(rstData[0][17]);
                    } else {
                        daterangetomm = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][18])){
                        daterangetodd = Integer.parseInt(rstData[0][18]);
                    } else {
                        daterangetodd = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][19])){
                        daterangesavedsearchid = Integer.parseInt(rstData[0][19]);
                    } else {
                        daterangesavedsearchid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][20])){
                        accountid = Integer.parseInt(rstData[0][20]);
                    } else {
                        accountid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(megachartid), CACHEGROUP, this);
            }
        }
    }

    public void save() throws reger.core.ValidationException{
        try{
            validate();
        } catch (reger.core.ValidationException vex){
            throw vex;
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT megachartid FROM megachart WHERE megachartid='"+megachartid+"' AND megachartid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE megachart SET megachartid='"+megachartid+"', chartname='"+reger.core.Util.cleanForSQL(chartname)+"', xeventtypeid='"+xeventtypeid+"', xlogid='"+xlogid+"', xmegafieldid='"+xmegafieldid+"', yaxiswhattodo='"+yaxiswhattodo+"', chartsize='"+chartsize+"', charttype='"+charttype+"', daterange='"+daterange+"', lastxdays='"+lastxdays+"', lastxweeks='"+lastxweeks+"', lastxmonths='"+lastxmonths+"', lastxyears='"+lastxyears+"', daterangefromyyyy='"+daterangefromyyyy+"', daterangefrommm='"+daterangefrommm+"', daterangefromdd='"+daterangefromdd+"', daterangetoyyyy='"+daterangetoyyyy+"', daterangetomm='"+daterangetomm+"', daterangetodd='"+daterangetodd+"', daterangesavedsearchid='"+daterangesavedsearchid+"', accountid='"+accountid+"'  WHERE megachartid='"+megachartid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(megachartid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            megachartid = Db.RunSQLInsert("INSERT INTO megachart(chartname, xeventtypeid, xlogid, xmegafieldid, yaxiswhattodo, chartsize, charttype, daterange, lastxdays, lastxweeks, lastxmonths, lastxyears, daterangefromyyyy, daterangefrommm, daterangefromdd, daterangetoyyyy, daterangetomm, daterangetodd, daterangesavedsearchid, accountid ) VALUES('"+megachartid+"', '"+reger.core.Util.cleanForSQL(chartname)+"', '"+xeventtypeid+"', '"+xlogid+"', '"+xmegafieldid+"', '"+yaxiswhattodo+"', '"+chartsize+"', '"+charttype+"', '"+daterange+"', '"+lastxdays+"', '"+lastxweeks+"', '"+lastxmonths+"', '"+lastxyears+"', '"+daterangefromyyyy+"', '"+daterangefrommm+"', '"+daterangefromdd+"', '"+daterangetoyyyy+"', '"+daterangetomm+"', '"+daterangetodd+"', '"+daterangesavedsearchid+"', '"+accountid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(megachartid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM megachart WHERE megachartid='"+megachartid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(megachartid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorMegachartDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "megachartDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return megachartid;
    }

    public String getPrimaryKeyName(){
        return "megachartid";
    }

    public String getTableName(){
        return "megachart";
    }

    public void setProperties(MegachartDAO obj){
        if(obj!=null){
            this.megachartid = obj.megachartid;
            this.chartname = obj.chartname;
            this.xeventtypeid = obj.xeventtypeid;
            this.xlogid = obj.xlogid;
            this.xmegafieldid = obj.xmegafieldid;
            this.yaxiswhattodo = obj.yaxiswhattodo;
            this.chartsize = obj.chartsize;
            this.charttype = obj.charttype;
            this.daterange = obj.daterange;
            this.lastxdays = obj.lastxdays;
            this.lastxweeks = obj.lastxweeks;
            this.lastxmonths = obj.lastxmonths;
            this.lastxyears = obj.lastxyears;
            this.daterangefromyyyy = obj.daterangefromyyyy;
            this.daterangefrommm = obj.daterangefrommm;
            this.daterangefromdd = obj.daterangefromdd;
            this.daterangetoyyyy = obj.daterangetoyyyy;
            this.daterangetomm = obj.daterangetomm;
            this.daterangetodd = obj.daterangetodd;
            this.daterangesavedsearchid = obj.daterangesavedsearchid;
            this.accountid = obj.accountid;
        }
    }


    public int getMegachartid() {
        return megachartid;
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


    public int getXlogid() {
        return xlogid;
    }


    public void setXlogid(int xlogid) {
        this.xlogid = xlogid;
    }


    public int getXmegafieldid() {
        return xmegafieldid;
    }


    public void setXmegafieldid(int xmegafieldid) {
        this.xmegafieldid = xmegafieldid;
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


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


}