package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'aclgroupmembershipgrants' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorAclgroupmembershipgrantsDAO.java
 * Finders for this DAO: reger.dao.finders.AclgroupmembershipgrantsFinder.java
 * 
 */

public class AclgroupmembershipgrantsDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "aclgroupmembershipgrantsDAO";

    protected int aclgroupmembershipgrantsid = 0;
    protected int aclgroupid = 0;
    protected int aclobjectid = 0;

    public AclgroupmembershipgrantsDAO (int aclgroupmembershipgrantsid){
        this.aclgroupmembershipgrantsid = aclgroupmembershipgrantsid;
        load();
    }

    public AclgroupmembershipgrantsDAO(){


    }

    public void load(){
        if (aclgroupmembershipgrantsid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(aclgroupmembershipgrantsid), CACHEGROUP);
            if (obj!=null && (obj instanceof AclgroupmembershipgrantsDAO)){
                setProperties((AclgroupmembershipgrantsDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT aclgroupmembershipgrantsid, aclgroupid, aclobjectid  FROM aclgroupmembershipgrants WHERE aclgroupmembershipgrantsid='"+aclgroupmembershipgrantsid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        aclgroupmembershipgrantsid = Integer.parseInt(rstData[0][0]);
                    } else {
                        aclgroupmembershipgrantsid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        aclgroupid = Integer.parseInt(rstData[0][1]);
                    } else {
                        aclgroupid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        aclobjectid = Integer.parseInt(rstData[0][2]);
                    } else {
                        aclobjectid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(aclgroupmembershipgrantsid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT aclgroupmembershipgrantsid FROM aclgroupmembershipgrants WHERE aclgroupmembershipgrantsid='"+aclgroupmembershipgrantsid+"' AND aclgroupmembershipgrantsid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE aclgroupmembershipgrants SET aclgroupmembershipgrantsid='"+aclgroupmembershipgrantsid+"', aclgroupid='"+aclgroupid+"', aclobjectid='"+aclobjectid+"'  WHERE aclgroupmembershipgrantsid='"+aclgroupmembershipgrantsid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(aclgroupmembershipgrantsid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            aclgroupmembershipgrantsid = Db.RunSQLInsert("INSERT INTO aclgroupmembershipgrants(aclgroupid, aclobjectid ) VALUES('"+aclgroupmembershipgrantsid+"', '"+aclgroupid+"', '"+aclobjectid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(aclgroupmembershipgrantsid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM aclgroupmembershipgrants WHERE aclgroupmembershipgrantsid='"+aclgroupmembershipgrantsid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(aclgroupmembershipgrantsid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorAclgroupmembershipgrantsDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "aclgroupmembershipgrantsDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return aclgroupmembershipgrantsid;
    }

    public String getPrimaryKeyName(){
        return "aclgroupmembershipgrantsid";
    }

    public String getTableName(){
        return "aclgroupmembershipgrants";
    }

    public void setProperties(AclgroupmembershipgrantsDAO obj){
        if(obj!=null){
            this.aclgroupmembershipgrantsid = obj.aclgroupmembershipgrantsid;
            this.aclgroupid = obj.aclgroupid;
            this.aclobjectid = obj.aclobjectid;
        }
    }


    public int getAclgroupmembershipgrantsid() {
        return aclgroupmembershipgrantsid;
    }


    public int getAclgroupid() {
        return aclgroupid;
    }


    public void setAclgroupid(int aclgroupid) {
        this.aclgroupid = aclgroupid;
    }


    public int getAclobjectid() {
        return aclobjectid;
    }


    public void setAclobjectid(int aclobjectid) {
        this.aclobjectid = aclobjectid;
    }


}