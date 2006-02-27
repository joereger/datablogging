package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'groupmembership' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorGroupmembershipDAO.java
 * Finders for this DAO: reger.dao.finders.GroupmembershipFinder.java
 * 
 */

public class GroupmembershipDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "groupmembershipDAO";

    protected int groupmembershipid = 0;
    protected int accountuserid = 0;
    protected int groupid = 0;
    protected boolean sharemembershippublicly = true;
    protected boolean isapproved = true;
    protected boolean ismoderator = true;

    public GroupmembershipDAO (int groupmembershipid){
        this.groupmembershipid = groupmembershipid;
        load();
    }

    public GroupmembershipDAO(){


    }

    public void load(){
        if (groupmembershipid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(groupmembershipid), CACHEGROUP);
            if (obj!=null && (obj instanceof GroupmembershipDAO)){
                setProperties((GroupmembershipDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT groupmembershipid, accountuserid, groupid, sharemembershippublicly, isapproved, ismoderator  FROM groupmembership WHERE groupmembershipid='"+groupmembershipid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        groupmembershipid = Integer.parseInt(rstData[0][0]);
                    } else {
                        groupmembershipid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountuserid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountuserid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        groupid = Integer.parseInt(rstData[0][2]);
                    } else {
                        groupid = 0;
                    }

                    sharemembershippublicly = reger.core.Util.booleanFromSQLText(rstData[0][3]);

                    isapproved = reger.core.Util.booleanFromSQLText(rstData[0][4]);

                    ismoderator = reger.core.Util.booleanFromSQLText(rstData[0][5]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(groupmembershipid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT groupmembershipid FROM groupmembership WHERE groupmembershipid='"+groupmembershipid+"' AND groupmembershipid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE groupmembership SET groupmembershipid='"+groupmembershipid+"', accountuserid='"+accountuserid+"', groupid='"+groupid+"', sharemembershippublicly='"+reger.core.Util.booleanAsSQLText(sharemembershippublicly)+"', isapproved='"+reger.core.Util.booleanAsSQLText(isapproved)+"', ismoderator='"+reger.core.Util.booleanAsSQLText(ismoderator)+"'  WHERE groupmembershipid='"+groupmembershipid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(groupmembershipid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            groupmembershipid = Db.RunSQLInsert("INSERT INTO groupmembership(accountuserid, groupid, sharemembershippublicly, isapproved, ismoderator ) VALUES('"+groupmembershipid+"', '"+accountuserid+"', '"+groupid+"', '"+reger.core.Util.booleanAsSQLText(sharemembershippublicly)+"', '"+reger.core.Util.booleanAsSQLText(isapproved)+"', '"+reger.core.Util.booleanAsSQLText(ismoderator)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(groupmembershipid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM groupmembership WHERE groupmembershipid='"+groupmembershipid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(groupmembershipid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorGroupmembershipDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "groupmembershipDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return groupmembershipid;
    }

    public String getPrimaryKeyName(){
        return "groupmembershipid";
    }

    public String getTableName(){
        return "groupmembership";
    }

    public void setProperties(GroupmembershipDAO obj){
        if(obj!=null){
            this.groupmembershipid = obj.groupmembershipid;
            this.accountuserid = obj.accountuserid;
            this.groupid = obj.groupid;
            this.sharemembershippublicly = obj.sharemembershippublicly;
            this.isapproved = obj.isapproved;
            this.ismoderator = obj.ismoderator;
        }
    }


    public int getGroupmembershipid() {
        return groupmembershipid;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }


    public int getGroupid() {
        return groupid;
    }


    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }


    public boolean getSharemembershippublicly() {
        return sharemembershippublicly;
    }


    public void setSharemembershippublicly(boolean sharemembershippublicly) {
        this.sharemembershippublicly = sharemembershippublicly;
    }


    public boolean getIsapproved() {
        return isapproved;
    }


    public void setIsapproved(boolean isapproved) {
        this.isapproved = isapproved;
    }


    public boolean getIsmoderator() {
        return ismoderator;
    }


    public void setIsmoderator(boolean ismoderator) {
        this.ismoderator = ismoderator;
    }


}