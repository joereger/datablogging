package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'aclobject' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorAclobjectDAO.java
 * Finders for this DAO: reger.dao.finders.AclobjectFinder.java
 * 
 */

public class AclobjectDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "aclobjectDAO";

    protected int aclobjectid = 0;
    protected String aclobjectname = "";
    protected String aclfriendlyname = "";
    protected String acldesc = "";

    public AclobjectDAO (int aclobjectid){
        this.aclobjectid = aclobjectid;
        load();
    }

    public AclobjectDAO(){


    }

    public void load(){
        if (aclobjectid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(aclobjectid), CACHEGROUP);
            if (obj!=null && (obj instanceof AclobjectDAO)){
                setProperties((AclobjectDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT aclobjectid, aclobjectname, aclfriendlyname, acldesc  FROM aclobject WHERE aclobjectid='"+aclobjectid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        aclobjectid = Integer.parseInt(rstData[0][0]);
                    } else {
                        aclobjectid = 0;
                    }

                    aclobjectname = rstData[0][1];

                    aclfriendlyname = rstData[0][2];

                    acldesc = rstData[0][3];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(aclobjectid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT aclobjectid FROM aclobject WHERE aclobjectid='"+aclobjectid+"' AND aclobjectid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE aclobject SET aclobjectid='"+aclobjectid+"', aclobjectname='"+reger.core.Util.cleanForSQL(aclobjectname)+"', aclfriendlyname='"+reger.core.Util.cleanForSQL(aclfriendlyname)+"', acldesc='"+reger.core.Util.cleanForSQL(acldesc)+"'  WHERE aclobjectid='"+aclobjectid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(aclobjectid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            aclobjectid = Db.RunSQLInsert("INSERT INTO aclobject(aclobjectname, aclfriendlyname, acldesc ) VALUES('"+aclobjectid+"', '"+reger.core.Util.cleanForSQL(aclobjectname)+"', '"+reger.core.Util.cleanForSQL(aclfriendlyname)+"', '"+reger.core.Util.cleanForSQL(acldesc)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(aclobjectid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM aclobject WHERE aclobjectid='"+aclobjectid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(aclobjectid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorAclobjectDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "aclobjectDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return aclobjectid;
    }

    public String getPrimaryKeyName(){
        return "aclobjectid";
    }

    public String getTableName(){
        return "aclobject";
    }

    public void setProperties(AclobjectDAO obj){
        if(obj!=null){
            this.aclobjectid = obj.aclobjectid;
            this.aclobjectname = obj.aclobjectname;
            this.aclfriendlyname = obj.aclfriendlyname;
            this.acldesc = obj.acldesc;
        }
    }


    public int getAclobjectid() {
        return aclobjectid;
    }


    public String getAclobjectname() {
        return aclobjectname;
    }


    public void setAclobjectname(String aclobjectname) {
        this.aclobjectname = aclobjectname;
    }


    public String getAclfriendlyname() {
        return aclfriendlyname;
    }


    public void setAclfriendlyname(String aclfriendlyname) {
        this.aclfriendlyname = aclfriendlyname;
    }


    public String getAcldesc() {
        return acldesc;
    }


    public void setAcldesc(String acldesc) {
        this.acldesc = acldesc;
    }


}