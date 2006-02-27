package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'trackback' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorTrackbackDAO.java
 * Finders for this DAO: reger.dao.finders.TrackbackFinder.java
 * 
 */

public class TrackbackDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "trackbackDAO";

    protected int trackbackid = 0;
    protected int eventid = 0;
    protected boolean isoutbound = true;
    protected boolean ispingedalready = true;
    protected String url = "";
    protected String blogname = "";
    protected String posttitle = "";
    protected String excerpt = "";
    protected java.util.Calendar datetime = java.util.Calendar.getInstance();
    protected boolean isapproved = true;

    public TrackbackDAO (int trackbackid){
        this.trackbackid = trackbackid;
        load();
    }

    public TrackbackDAO(){


    }

    public void load(){
        if (trackbackid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(trackbackid), CACHEGROUP);
            if (obj!=null && (obj instanceof TrackbackDAO)){
                setProperties((TrackbackDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT trackbackid, eventid, isoutbound, ispingedalready, url, blogname, posttitle, excerpt, datetime, isapproved  FROM trackback WHERE trackbackid='"+trackbackid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        trackbackid = Integer.parseInt(rstData[0][0]);
                    } else {
                        trackbackid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        eventid = Integer.parseInt(rstData[0][1]);
                    } else {
                        eventid = 0;
                    }

                    isoutbound = reger.core.Util.booleanFromSQLText(rstData[0][2]);

                    ispingedalready = reger.core.Util.booleanFromSQLText(rstData[0][3]);

                    url = rstData[0][4];

                    blogname = rstData[0][5];

                    posttitle = rstData[0][6];

                    excerpt = rstData[0][7];

                    datetime = reger.core.TimeUtils.dbstringtocalendar(rstData[0][8]);

                    isapproved = reger.core.Util.booleanFromSQLText(rstData[0][9]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(trackbackid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT trackbackid FROM trackback WHERE trackbackid='"+trackbackid+"' AND trackbackid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE trackback SET trackbackid='"+trackbackid+"', eventid='"+eventid+"', isoutbound='"+reger.core.Util.booleanAsSQLText(isoutbound)+"', ispingedalready='"+reger.core.Util.booleanAsSQLText(ispingedalready)+"', url='"+reger.core.Util.cleanForSQL(url)+"', blogname='"+reger.core.Util.cleanForSQL(blogname)+"', posttitle='"+reger.core.Util.cleanForSQL(posttitle)+"', excerpt='"+reger.core.Util.cleanForSQL(excerpt)+"', datetime='"+reger.core.TimeUtils.dateformatfordb(datetime)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"'  WHERE trackbackid='"+trackbackid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(trackbackid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            trackbackid = Db.RunSQLInsert("INSERT INTO trackback(eventid, isoutbound, ispingedalready, url, blogname, posttitle, excerpt, datetime, isapproved ) VALUES('"+trackbackid+"', '"+eventid+"', '"+reger.core.Util.booleanAsSQLText(isoutbound)+"', '"+reger.core.Util.booleanAsSQLText(ispingedalready)+"', '"+reger.core.Util.cleanForSQL(url)+"', '"+reger.core.Util.cleanForSQL(blogname)+"', '"+reger.core.Util.cleanForSQL(posttitle)+"', '"+reger.core.Util.cleanForSQL(excerpt)+"', '"+reger.core.TimeUtils.dateformatfordb(datetime)+"', '"+reger.core.Util.booleanAsSQLText(isapproved)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(trackbackid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM trackback WHERE trackbackid='"+trackbackid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(trackbackid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorTrackbackDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "trackbackDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return trackbackid;
    }

    public String getPrimaryKeyName(){
        return "trackbackid";
    }

    public String getTableName(){
        return "trackback";
    }

    public void setProperties(TrackbackDAO obj){
        if(obj!=null){
            this.trackbackid = obj.trackbackid;
            this.eventid = obj.eventid;
            this.isoutbound = obj.isoutbound;
            this.ispingedalready = obj.ispingedalready;
            this.url = obj.url;
            this.blogname = obj.blogname;
            this.posttitle = obj.posttitle;
            this.excerpt = obj.excerpt;
            this.datetime = obj.datetime;
            this.isapproved = obj.isapproved;
        }
    }


    public int getTrackbackid() {
        return trackbackid;
    }


    public int getEventid() {
        return eventid;
    }


    public void setEventid(int eventid) {
        this.eventid = eventid;
    }


    public boolean getIsoutbound() {
        return isoutbound;
    }


    public void setIsoutbound(boolean isoutbound) {
        this.isoutbound = isoutbound;
    }


    public boolean getIspingedalready() {
        return ispingedalready;
    }


    public void setIspingedalready(boolean ispingedalready) {
        this.ispingedalready = ispingedalready;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public String getBlogname() {
        return blogname;
    }


    public void setBlogname(String blogname) {
        this.blogname = blogname;
    }


    public String getPosttitle() {
        return posttitle;
    }


    public void setPosttitle(String posttitle) {
        this.posttitle = posttitle;
    }


    public String getExcerpt() {
        return excerpt;
    }


    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }


    public java.util.Calendar getDatetime() {
        return datetime;
    }


    public void setDatetime(java.util.Calendar datetime) {
        this.datetime = datetime;
    }


    public boolean getIsapproved() {
        return isapproved;
    }


    public void setIsapproved(boolean isapproved) {
        this.isapproved = isapproved;
    }


}