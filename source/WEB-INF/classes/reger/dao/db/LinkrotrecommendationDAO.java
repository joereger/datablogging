package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'linkrotrecommendation' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorLinkrotrecommendationDAO.java
 * Finders for this DAO: reger.dao.finders.LinkrotrecommendationFinder.java
 * 
 */

public class LinkrotrecommendationDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "linkrotrecommendationDAO";

    protected int linkrotrecommendationid = 0;
    protected int linkrotid = 0;
    protected String url = "";
    protected String source = "";

    public LinkrotrecommendationDAO (int linkrotrecommendationid){
        this.linkrotrecommendationid = linkrotrecommendationid;
        load();
    }

    public LinkrotrecommendationDAO(){


    }

    public void load(){
        if (linkrotrecommendationid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(linkrotrecommendationid), CACHEGROUP);
            if (obj!=null && (obj instanceof LinkrotrecommendationDAO)){
                setProperties((LinkrotrecommendationDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT linkrotrecommendationid, linkrotid, url, source  FROM linkrotrecommendation WHERE linkrotrecommendationid='"+linkrotrecommendationid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        linkrotrecommendationid = Integer.parseInt(rstData[0][0]);
                    } else {
                        linkrotrecommendationid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        linkrotid = Integer.parseInt(rstData[0][1]);
                    } else {
                        linkrotid = 0;
                    }

                    url = rstData[0][2];

                    source = rstData[0][3];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(linkrotrecommendationid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT linkrotrecommendationid FROM linkrotrecommendation WHERE linkrotrecommendationid='"+linkrotrecommendationid+"' AND linkrotrecommendationid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE linkrotrecommendation SET linkrotrecommendationid='"+linkrotrecommendationid+"', linkrotid='"+linkrotid+"', url='"+reger.core.Util.cleanForSQL(url)+"', source='"+reger.core.Util.cleanForSQL(source)+"'  WHERE linkrotrecommendationid='"+linkrotrecommendationid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(linkrotrecommendationid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            linkrotrecommendationid = Db.RunSQLInsert("INSERT INTO linkrotrecommendation(linkrotid, url, source ) VALUES('"+linkrotrecommendationid+"', '"+linkrotid+"', '"+reger.core.Util.cleanForSQL(url)+"', '"+reger.core.Util.cleanForSQL(source)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(linkrotrecommendationid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM linkrotrecommendation WHERE linkrotrecommendationid='"+linkrotrecommendationid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(linkrotrecommendationid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorLinkrotrecommendationDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "linkrotrecommendationDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return linkrotrecommendationid;
    }

    public String getPrimaryKeyName(){
        return "linkrotrecommendationid";
    }

    public String getTableName(){
        return "linkrotrecommendation";
    }

    public void setProperties(LinkrotrecommendationDAO obj){
        if(obj!=null){
            this.linkrotrecommendationid = obj.linkrotrecommendationid;
            this.linkrotid = obj.linkrotid;
            this.url = obj.url;
            this.source = obj.source;
        }
    }


    public int getLinkrotrecommendationid() {
        return linkrotrecommendationid;
    }


    public int getLinkrotid() {
        return linkrotid;
    }


    public void setLinkrotid(int linkrotid) {
        this.linkrotid = linkrotid;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public String getSource() {
        return source;
    }


    public void setSource(String source) {
        this.source = source;
    }


}