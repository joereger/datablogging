package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'banner' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorBannerDAO.java
 * Finders for this DAO: reger.dao.finders.BannerFinder.java
 * 
 */

public class BannerDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "bannerDAO";

    protected int bannerid = 0;
    protected String url = "";
    protected String filename = "";
    protected int width = 0;
    protected int height = 0;
    protected boolean active = true;
    protected int impressions = 0;

    public BannerDAO (int bannerid){
        this.bannerid = bannerid;
        load();
    }

    public BannerDAO(){


    }

    public void load(){
        if (bannerid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(bannerid), CACHEGROUP);
            if (obj!=null && (obj instanceof BannerDAO)){
                setProperties((BannerDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT bannerid, url, filename, width, height, active, impressions  FROM banner WHERE bannerid='"+bannerid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        bannerid = Integer.parseInt(rstData[0][0]);
                    } else {
                        bannerid = 0;
                    }

                    url = rstData[0][1];

                    filename = rstData[0][2];

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        width = Integer.parseInt(rstData[0][3]);
                    } else {
                        width = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][4])){
                        height = Integer.parseInt(rstData[0][4]);
                    } else {
                        height = 0;
                    }

                    active = reger.core.Util.booleanFromSQLText(rstData[0][5]);

                    if (reger.core.Util.isinteger(rstData[0][6])){
                        impressions = Integer.parseInt(rstData[0][6]);
                    } else {
                        impressions = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(bannerid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT bannerid FROM banner WHERE bannerid='"+bannerid+"' AND bannerid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE banner SET bannerid='"+bannerid+"', url='"+reger.core.Util.cleanForSQL(url)+"', filename='"+reger.core.Util.cleanForSQL(filename)+"', width='"+width+"', height='"+height+"', active='"+reger.core.Util.booleanAsSQLText(active)+"', impressions='"+impressions+"'  WHERE bannerid='"+bannerid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(bannerid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            bannerid = Db.RunSQLInsert("INSERT INTO banner(url, filename, width, height, active, impressions ) VALUES('"+bannerid+"', '"+reger.core.Util.cleanForSQL(url)+"', '"+reger.core.Util.cleanForSQL(filename)+"', '"+width+"', '"+height+"', '"+reger.core.Util.booleanAsSQLText(active)+"', '"+impressions+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(bannerid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM banner WHERE bannerid='"+bannerid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(bannerid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorBannerDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "bannerDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return bannerid;
    }

    public String getPrimaryKeyName(){
        return "bannerid";
    }

    public String getTableName(){
        return "banner";
    }

    public void setProperties(BannerDAO obj){
        if(obj!=null){
            this.bannerid = obj.bannerid;
            this.url = obj.url;
            this.filename = obj.filename;
            this.width = obj.width;
            this.height = obj.height;
            this.active = obj.active;
            this.impressions = obj.impressions;
        }
    }


    public int getBannerid() {
        return bannerid;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public String getFilename() {
        return filename;
    }


    public void setFilename(String filename) {
        this.filename = filename;
    }


    public int getWidth() {
        return width;
    }


    public void setWidth(int width) {
        this.width = width;
    }


    public int getHeight() {
        return height;
    }


    public void setHeight(int height) {
        this.height = height;
    }


    public boolean getActive() {
        return active;
    }


    public void setActive(boolean active) {
        this.active = active;
    }


    public int getImpressions() {
        return impressions;
    }


    public void setImpressions(int impressions) {
        this.impressions = impressions;
    }


}