package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'favesite' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorFavesiteDAO.java
 * Finders for this DAO: reger.dao.finders.FavesiteFinder.java
 * 
 */

public class FavesiteDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "favesiteDAO";

    protected int favesiteid = 0;
    protected String name = "";
    protected String url = "";
    protected int accountid = 0;

    public FavesiteDAO (int favesiteid){
        this.favesiteid = favesiteid;
        load();
    }

    public FavesiteDAO(){


    }

    public void load(){
        if (favesiteid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(favesiteid), CACHEGROUP);
            if (obj!=null && (obj instanceof FavesiteDAO)){
                setProperties((FavesiteDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT favesiteid, name, url, accountid  FROM favesite WHERE favesiteid='"+favesiteid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        favesiteid = Integer.parseInt(rstData[0][0]);
                    } else {
                        favesiteid = 0;
                    }

                    name = rstData[0][1];

                    url = rstData[0][2];

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        accountid = Integer.parseInt(rstData[0][3]);
                    } else {
                        accountid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(favesiteid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT favesiteid FROM favesite WHERE favesiteid='"+favesiteid+"' AND favesiteid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE favesite SET favesiteid='"+favesiteid+"', name='"+reger.core.Util.cleanForSQL(name)+"', url='"+reger.core.Util.cleanForSQL(url)+"', accountid='"+accountid+"'  WHERE favesiteid='"+favesiteid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(favesiteid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            favesiteid = Db.RunSQLInsert("INSERT INTO favesite(name, url, accountid ) VALUES('"+favesiteid+"', '"+reger.core.Util.cleanForSQL(name)+"', '"+reger.core.Util.cleanForSQL(url)+"', '"+accountid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(favesiteid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM favesite WHERE favesiteid='"+favesiteid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(favesiteid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorFavesiteDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "favesiteDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return favesiteid;
    }

    public String getPrimaryKeyName(){
        return "favesiteid";
    }

    public String getTableName(){
        return "favesite";
    }

    public void setProperties(FavesiteDAO obj){
        if(obj!=null){
            this.favesiteid = obj.favesiteid;
            this.name = obj.name;
            this.url = obj.url;
            this.accountid = obj.accountid;
        }
    }


    public int getFavesiteid() {
        return favesiteid;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getUrl() {
        return url;
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


}