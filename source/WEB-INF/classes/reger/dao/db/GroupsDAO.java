package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'groups' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorGroupsDAO.java
 * Finders for this DAO: reger.dao.finders.GroupsFinder.java
 * 
 */

public class GroupsDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "groupsDAO";

    protected int groupid = 0;
    protected String name = "";
    protected String description = "";
    protected int entriesareprivate = 0;
    protected boolean membershipismoderated = true;
    protected int plid = 0;
    protected int accountuserid = 0;

    public GroupsDAO (int groupid){
        this.groupid = groupid;
        load();
    }

    public GroupsDAO(){


    }

    public void load(){
        if (groupid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(groupid), CACHEGROUP);
            if (obj!=null && (obj instanceof GroupsDAO)){
                setProperties((GroupsDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT groupid, name, description, entriesareprivate, membershipismoderated, plid, accountuserid  FROM groups WHERE groupid='"+groupid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        groupid = Integer.parseInt(rstData[0][0]);
                    } else {
                        groupid = 0;
                    }

                    name = rstData[0][1];

                    description = rstData[0][2];

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        entriesareprivate = Integer.parseInt(rstData[0][3]);
                    } else {
                        entriesareprivate = 0;
                    }

                    membershipismoderated = reger.core.Util.booleanFromSQLText(rstData[0][4]);

                    if (reger.core.Util.isinteger(rstData[0][5])){
                        plid = Integer.parseInt(rstData[0][5]);
                    } else {
                        plid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][6])){
                        accountuserid = Integer.parseInt(rstData[0][6]);
                    } else {
                        accountuserid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(groupid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT groupid FROM groups WHERE groupid='"+groupid+"' AND groupid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE groups SET groupid='"+groupid+"', name='"+reger.core.Util.cleanForSQL(name)+"', description='"+reger.core.Util.cleanForSQL(description)+"', entriesareprivate='"+entriesareprivate+"', membershipismoderated='"+reger.core.Util.booleanAsSQLText(membershipismoderated)+"', plid='"+plid+"', accountuserid='"+accountuserid+"'  WHERE groupid='"+groupid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(groupid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            groupid = Db.RunSQLInsert("INSERT INTO groups(name, description, entriesareprivate, membershipismoderated, plid, accountuserid ) VALUES('"+groupid+"', '"+reger.core.Util.cleanForSQL(name)+"', '"+reger.core.Util.cleanForSQL(description)+"', '"+entriesareprivate+"', '"+reger.core.Util.booleanAsSQLText(membershipismoderated)+"', '"+plid+"', '"+accountuserid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(groupid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM groups WHERE groupid='"+groupid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(groupid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorGroupsDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "groupsDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return groupid;
    }

    public String getPrimaryKeyName(){
        return "groupid";
    }

    public String getTableName(){
        return "groups";
    }

    public void setProperties(GroupsDAO obj){
        if(obj!=null){
            this.groupid = obj.groupid;
            this.name = obj.name;
            this.description = obj.description;
            this.entriesareprivate = obj.entriesareprivate;
            this.membershipismoderated = obj.membershipismoderated;
            this.plid = obj.plid;
            this.accountuserid = obj.accountuserid;
        }
    }


    public int getGroupid() {
        return groupid;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public int getEntriesareprivate() {
        return entriesareprivate;
    }


    public void setEntriesareprivate(int entriesareprivate) {
        this.entriesareprivate = entriesareprivate;
    }


    public boolean getMembershipismoderated() {
        return membershipismoderated;
    }


    public void setMembershipismoderated(boolean membershipismoderated) {
        this.membershipismoderated = membershipismoderated;
    }


    public int getPlid() {
        return plid;
    }


    public void setPlid(int plid) {
        this.plid = plid;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }


}