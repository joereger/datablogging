package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'linkrot' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorLinkrotDAO.java
 * Finders for this DAO: reger.dao.finders.LinkrotFinder.java
 * 
 */

public class LinkrotDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "linkrotDAO";

    protected int linkrotid = 0;
    protected String url = "";
    protected String keywords = "";
    protected java.util.Calendar lastcheckeddate = java.util.Calendar.getInstance();
    protected boolean isbroken = true;
    protected int httpstatuscode = 0;

    public LinkrotDAO (int linkrotid){
        this.linkrotid = linkrotid;
        load();
    }

    public LinkrotDAO(){


    }

    public void load(){
        if (linkrotid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(linkrotid), CACHEGROUP);
            if (obj!=null && (obj instanceof LinkrotDAO)){
                setProperties((LinkrotDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT linkrotid, url, keywords, lastcheckeddate, isbroken, httpstatuscode  FROM linkrot WHERE linkrotid='"+linkrotid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        linkrotid = Integer.parseInt(rstData[0][0]);
                    } else {
                        linkrotid = 0;
                    }

                    url = rstData[0][1];

                    keywords = rstData[0][2];

                    lastcheckeddate = reger.core.TimeUtils.dbstringtocalendar(rstData[0][3]);

                    isbroken = reger.core.Util.booleanFromSQLText(rstData[0][4]);

                    if (reger.core.Util.isinteger(rstData[0][5])){
                        httpstatuscode = Integer.parseInt(rstData[0][5]);
                    } else {
                        httpstatuscode = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(linkrotid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT linkrotid FROM linkrot WHERE linkrotid='"+linkrotid+"' AND linkrotid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE linkrot SET linkrotid='"+linkrotid+"', url='"+reger.core.Util.cleanForSQL(url)+"', keywords='"+reger.core.Util.cleanForSQL(keywords)+"', lastcheckeddate='"+reger.core.TimeUtils.dateformatfordb(lastcheckeddate)+"', isbroken='"+reger.core.Util.booleanAsSQLText(isbroken)+"', httpstatuscode='"+httpstatuscode+"'  WHERE linkrotid='"+linkrotid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(linkrotid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            linkrotid = Db.RunSQLInsert("INSERT INTO linkrot(url, keywords, lastcheckeddate, isbroken, httpstatuscode ) VALUES('"+linkrotid+"', '"+reger.core.Util.cleanForSQL(url)+"', '"+reger.core.Util.cleanForSQL(keywords)+"', '"+reger.core.TimeUtils.dateformatfordb(lastcheckeddate)+"', '"+reger.core.Util.booleanAsSQLText(isbroken)+"', '"+httpstatuscode+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(linkrotid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM linkrot WHERE linkrotid='"+linkrotid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(linkrotid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorLinkrotDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "linkrotDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return linkrotid;
    }

    public String getPrimaryKeyName(){
        return "linkrotid";
    }

    public String getTableName(){
        return "linkrot";
    }

    public void setProperties(LinkrotDAO obj){
        if(obj!=null){
            this.linkrotid = obj.linkrotid;
            this.url = obj.url;
            this.keywords = obj.keywords;
            this.lastcheckeddate = obj.lastcheckeddate;
            this.isbroken = obj.isbroken;
            this.httpstatuscode = obj.httpstatuscode;
        }
    }


    public int getLinkrotid() {
        return linkrotid;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public String getKeywords() {
        return keywords;
    }


    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }


    public java.util.Calendar getLastcheckeddate() {
        return lastcheckeddate;
    }


    public void setLastcheckeddate(java.util.Calendar lastcheckeddate) {
        this.lastcheckeddate = lastcheckeddate;
    }


    public boolean getIsbroken() {
        return isbroken;
    }


    public void setIsbroken(boolean isbroken) {
        this.isbroken = isbroken;
    }


    public int getHttpstatuscode() {
        return httpstatuscode;
    }


    public void setHttpstatuscode(int httpstatuscode) {
        this.httpstatuscode = httpstatuscode;
    }


}