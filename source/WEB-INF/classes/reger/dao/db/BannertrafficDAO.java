package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'bannertraffic' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorBannertrafficDAO.java
 * Finders for this DAO: reger.dao.finders.BannertrafficFinder.java
 * 
 */

public class BannertrafficDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "bannertrafficDAO";

    protected int bannertrafficid = 0;
    protected int bannerid = 0;
    protected java.util.Calendar date = java.util.Calendar.getInstance();
    protected int impressions = 0;
    protected int clicks = 0;
    protected int plid = 0;
    protected int eventtypeid = 0;

    public BannertrafficDAO (int bannertrafficid){
        this.bannertrafficid = bannertrafficid;
        load();
    }

    public BannertrafficDAO(){


    }

    public void load(){
        if (bannertrafficid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(bannertrafficid), CACHEGROUP);
            if (obj!=null && (obj instanceof BannertrafficDAO)){
                setProperties((BannertrafficDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT bannertrafficid, bannerid, date, impressions, clicks, plid, eventtypeid  FROM bannertraffic WHERE bannertrafficid='"+bannertrafficid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        bannertrafficid = Integer.parseInt(rstData[0][0]);
                    } else {
                        bannertrafficid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        bannerid = Integer.parseInt(rstData[0][1]);
                    } else {
                        bannerid = 0;
                    }

                    date = reger.core.TimeUtils.dbstringtocalendar(rstData[0][2]);

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        impressions = Integer.parseInt(rstData[0][3]);
                    } else {
                        impressions = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][4])){
                        clicks = Integer.parseInt(rstData[0][4]);
                    } else {
                        clicks = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][5])){
                        plid = Integer.parseInt(rstData[0][5]);
                    } else {
                        plid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][6])){
                        eventtypeid = Integer.parseInt(rstData[0][6]);
                    } else {
                        eventtypeid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(bannertrafficid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT bannertrafficid FROM bannertraffic WHERE bannertrafficid='"+bannertrafficid+"' AND bannertrafficid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE bannertraffic SET bannertrafficid='"+bannertrafficid+"', bannerid='"+bannerid+"', date='"+reger.core.TimeUtils.dateformatfordb(date)+"', impressions='"+impressions+"', clicks='"+clicks+"', plid='"+plid+"', eventtypeid='"+eventtypeid+"'  WHERE bannertrafficid='"+bannertrafficid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(bannertrafficid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            bannertrafficid = Db.RunSQLInsert("INSERT INTO bannertraffic(bannerid, date, impressions, clicks, plid, eventtypeid ) VALUES('"+bannertrafficid+"', '"+bannerid+"', '"+reger.core.TimeUtils.dateformatfordb(date)+"', '"+impressions+"', '"+clicks+"', '"+plid+"', '"+eventtypeid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(bannertrafficid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM bannertraffic WHERE bannertrafficid='"+bannertrafficid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(bannertrafficid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorBannertrafficDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "bannertrafficDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return bannertrafficid;
    }

    public String getPrimaryKeyName(){
        return "bannertrafficid";
    }

    public String getTableName(){
        return "bannertraffic";
    }

    public void setProperties(BannertrafficDAO obj){
        if(obj!=null){
            this.bannertrafficid = obj.bannertrafficid;
            this.bannerid = obj.bannerid;
            this.date = obj.date;
            this.impressions = obj.impressions;
            this.clicks = obj.clicks;
            this.plid = obj.plid;
            this.eventtypeid = obj.eventtypeid;
        }
    }


    public int getBannertrafficid() {
        return bannertrafficid;
    }


    public int getBannerid() {
        return bannerid;
    }


    public void setBannerid(int bannerid) {
        this.bannerid = bannerid;
    }


    public java.util.Calendar getDate() {
        return date;
    }


    public void setDate(java.util.Calendar date) {
        this.date = date;
    }


    public int getImpressions() {
        return impressions;
    }


    public void setImpressions(int impressions) {
        this.impressions = impressions;
    }


    public int getClicks() {
        return clicks;
    }


    public void setClicks(int clicks) {
        this.clicks = clicks;
    }


    public int getPlid() {
        return plid;
    }


    public void setPlid(int plid) {
        this.plid = plid;
    }


    public int getEventtypeid() {
        return eventtypeid;
    }


    public void setEventtypeid(int eventtypeid) {
        this.eventtypeid = eventtypeid;
    }


}