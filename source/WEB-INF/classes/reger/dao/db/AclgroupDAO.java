package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'aclgroup' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorAclgroupDAO.java
 * Finders for this DAO: reger.dao.finders.AclgroupFinder.java
 * 
 */

public class AclgroupDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "aclgroupDAO";

    protected int aclgroupid = 0;
    protected String aclgroupname = "";

    public AclgroupDAO (int aclgroupid){
        this.aclgroupid = aclgroupid;
        load();
    }

    public AclgroupDAO(){


    }

    public void load(){
        if (aclgroupid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(aclgroupid), CACHEGROUP);
            if (obj!=null && (obj instanceof AclgroupDAO)){
                setProperties((AclgroupDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT aclgroupid, aclgroupname  FROM aclgroup WHERE aclgroupid='"+aclgroupid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        aclgroupid = Integer.parseInt(rstData[0][0]);
                    } else {
                        aclgroupid = 0;
                    }

                    aclgroupname = rstData[0][1];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(aclgroupid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT aclgroupid FROM aclgroup WHERE aclgroupid='"+aclgroupid+"' AND aclgroupid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE aclgroup SET aclgroupid='"+aclgroupid+"', aclgroupname='"+reger.core.Util.cleanForSQL(aclgroupname)+"'  WHERE aclgroupid='"+aclgroupid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(aclgroupid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            aclgroupid = Db.RunSQLInsert("INSERT INTO aclgroup(aclgroupname ) VALUES('"+aclgroupid+"', '"+reger.core.Util.cleanForSQL(aclgroupname)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(aclgroupid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM aclgroup WHERE aclgroupid='"+aclgroupid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(aclgroupid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorAclgroupDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "aclgroupDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return aclgroupid;
    }

    public String getPrimaryKeyName(){
        return "aclgroupid";
    }

    public String getTableName(){
        return "aclgroup";
    }

    public void setProperties(AclgroupDAO obj){
        if(obj!=null){
            this.aclgroupid = obj.aclgroupid;
            this.aclgroupname = obj.aclgroupname;
        }
    }


    public int getAclgroupid() {
        return aclgroupid;
    }


    public String getAclgroupname() {
        return aclgroupname;
    }


    public void setAclgroupname(String aclgroupname) {
        this.aclgroupname = aclgroupname;
    }


}