package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'episode' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorEpisodeDAO.java
 * Finders for this DAO: reger.dao.finders.EpisodeFinder.java
 * 
 */

public class EpisodeDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "episodeDAO";

    protected int episodeid = 0;
    protected String name = "";
    protected int accountid = 0;
    protected String description = "";
    protected boolean isprivate = true;

    public EpisodeDAO (int episodeid){
        this.episodeid = episodeid;
        load();
    }

    public EpisodeDAO(){


    }

    public void load(){
        if (episodeid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(episodeid), CACHEGROUP);
            if (obj!=null && (obj instanceof EpisodeDAO)){
                setProperties((EpisodeDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT episodeid, name, accountid, description, isprivate  FROM episode WHERE episodeid='"+episodeid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        episodeid = Integer.parseInt(rstData[0][0]);
                    } else {
                        episodeid = 0;
                    }

                    name = rstData[0][1];

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        accountid = Integer.parseInt(rstData[0][2]);
                    } else {
                        accountid = 0;
                    }

                    description = rstData[0][3];

                    isprivate = reger.core.Util.booleanFromSQLText(rstData[0][4]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(episodeid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT episodeid FROM episode WHERE episodeid='"+episodeid+"' AND episodeid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE episode SET episodeid='"+episodeid+"', name='"+reger.core.Util.cleanForSQL(name)+"', accountid='"+accountid+"', description='"+reger.core.Util.cleanForSQL(description)+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"'  WHERE episodeid='"+episodeid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(episodeid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            episodeid = Db.RunSQLInsert("INSERT INTO episode(name, accountid, description, isprivate ) VALUES('"+episodeid+"', '"+reger.core.Util.cleanForSQL(name)+"', '"+accountid+"', '"+reger.core.Util.cleanForSQL(description)+"', '"+reger.core.Util.booleanAsSQLText(isprivate)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(episodeid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM episode WHERE episodeid='"+episodeid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(episodeid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorEpisodeDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "episodeDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return episodeid;
    }

    public String getPrimaryKeyName(){
        return "episodeid";
    }

    public String getTableName(){
        return "episode";
    }

    public void setProperties(EpisodeDAO obj){
        if(obj!=null){
            this.episodeid = obj.episodeid;
            this.name = obj.name;
            this.accountid = obj.accountid;
            this.description = obj.description;
            this.isprivate = obj.isprivate;
        }
    }


    public int getEpisodeid() {
        return episodeid;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public boolean getIsprivate() {
        return isprivate;
    }


    public void setIsprivate(boolean isprivate) {
        this.isprivate = isprivate;
    }


}