package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'polarhrm' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorPolarhrmDAO.java
 * Finders for this DAO: reger.dao.finders.PolarhrmFinder.java
 * 
 */

public class PolarhrmDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "polarhrmDAO";

    protected int polarhrmid = 0;
    protected int imageid = 0;

    public PolarhrmDAO (int polarhrmid){
        this.polarhrmid = polarhrmid;
        load();
    }

    public PolarhrmDAO(){


    }

    public void load(){
        if (polarhrmid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(polarhrmid), CACHEGROUP);
            if (obj!=null && (obj instanceof PolarhrmDAO)){
                setProperties((PolarhrmDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT polarhrmid, imageid  FROM polarhrm WHERE polarhrmid='"+polarhrmid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        polarhrmid = Integer.parseInt(rstData[0][0]);
                    } else {
                        polarhrmid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        imageid = Integer.parseInt(rstData[0][1]);
                    } else {
                        imageid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(polarhrmid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT polarhrmid FROM polarhrm WHERE polarhrmid='"+polarhrmid+"' AND polarhrmid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE polarhrm SET polarhrmid='"+polarhrmid+"', imageid='"+imageid+"'  WHERE polarhrmid='"+polarhrmid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(polarhrmid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            polarhrmid = Db.RunSQLInsert("INSERT INTO polarhrm(imageid ) VALUES('"+polarhrmid+"', '"+imageid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(polarhrmid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM polarhrm WHERE polarhrmid='"+polarhrmid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(polarhrmid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorPolarhrmDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "polarhrmDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return polarhrmid;
    }

    public String getPrimaryKeyName(){
        return "polarhrmid";
    }

    public String getTableName(){
        return "polarhrm";
    }

    public void setProperties(PolarhrmDAO obj){
        if(obj!=null){
            this.polarhrmid = obj.polarhrmid;
            this.imageid = obj.imageid;
        }
    }


    public int getPolarhrmid() {
        return polarhrmid;
    }


    public int getImageid() {
        return imageid;
    }


    public void setImageid(int imageid) {
        this.imageid = imageid;
    }


}