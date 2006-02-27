package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'megafield' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorMegafieldDAO.java
 * Finders for this DAO: reger.dao.finders.MegafieldFinder.java
 * 
 */

public class MegafieldDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "megafieldDAO";

    protected int megafieldid = 0;
    protected int fieldtype = 0;
    protected int eventtypeid = 0;
    protected String fieldname = "";
    protected String fielddescription = "";
    protected int megadatatypeid = 0;
    protected boolean isrequired = true;
    protected int logid = 0;

    public MegafieldDAO (int megafieldid){
        this.megafieldid = megafieldid;
        load();
    }

    public MegafieldDAO(){


    }

    public void load(){
        if (megafieldid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(megafieldid), CACHEGROUP);
            if (obj!=null && (obj instanceof MegafieldDAO)){
                setProperties((MegafieldDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT megafieldid, fieldtype, eventtypeid, fieldname, fielddescription, megadatatypeid, isrequired, logid  FROM megafield WHERE megafieldid='"+megafieldid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        megafieldid = Integer.parseInt(rstData[0][0]);
                    } else {
                        megafieldid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        fieldtype = Integer.parseInt(rstData[0][1]);
                    } else {
                        fieldtype = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        eventtypeid = Integer.parseInt(rstData[0][2]);
                    } else {
                        eventtypeid = 0;
                    }

                    fieldname = rstData[0][3];

                    fielddescription = rstData[0][4];

                    if (reger.core.Util.isinteger(rstData[0][5])){
                        megadatatypeid = Integer.parseInt(rstData[0][5]);
                    } else {
                        megadatatypeid = 0;
                    }

                    isrequired = reger.core.Util.booleanFromSQLText(rstData[0][6]);

                    if (reger.core.Util.isinteger(rstData[0][7])){
                        logid = Integer.parseInt(rstData[0][7]);
                    } else {
                        logid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(megafieldid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT megafieldid FROM megafield WHERE megafieldid='"+megafieldid+"' AND megafieldid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE megafield SET megafieldid='"+megafieldid+"', fieldtype='"+fieldtype+"', eventtypeid='"+eventtypeid+"', fieldname='"+reger.core.Util.cleanForSQL(fieldname)+"', fielddescription='"+reger.core.Util.cleanForSQL(fielddescription)+"', megadatatypeid='"+megadatatypeid+"', isrequired='"+reger.core.Util.booleanAsSQLText(isrequired)+"', logid='"+logid+"'  WHERE megafieldid='"+megafieldid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(megafieldid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            megafieldid = Db.RunSQLInsert("INSERT INTO megafield(fieldtype, eventtypeid, fieldname, fielddescription, megadatatypeid, isrequired, logid ) VALUES('"+megafieldid+"', '"+fieldtype+"', '"+eventtypeid+"', '"+reger.core.Util.cleanForSQL(fieldname)+"', '"+reger.core.Util.cleanForSQL(fielddescription)+"', '"+megadatatypeid+"', '"+reger.core.Util.booleanAsSQLText(isrequired)+"', '"+logid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(megafieldid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM megafield WHERE megafieldid='"+megafieldid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(megafieldid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorMegafieldDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "megafieldDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return megafieldid;
    }

    public String getPrimaryKeyName(){
        return "megafieldid";
    }

    public String getTableName(){
        return "megafield";
    }

    public void setProperties(MegafieldDAO obj){
        if(obj!=null){
            this.megafieldid = obj.megafieldid;
            this.fieldtype = obj.fieldtype;
            this.eventtypeid = obj.eventtypeid;
            this.fieldname = obj.fieldname;
            this.fielddescription = obj.fielddescription;
            this.megadatatypeid = obj.megadatatypeid;
            this.isrequired = obj.isrequired;
            this.logid = obj.logid;
        }
    }


    public int getMegafieldid() {
        return megafieldid;
    }


    public int getFieldtype() {
        return fieldtype;
    }


    public void setFieldtype(int fieldtype) {
        this.fieldtype = fieldtype;
    }


    public int getEventtypeid() {
        return eventtypeid;
    }


    public void setEventtypeid(int eventtypeid) {
        this.eventtypeid = eventtypeid;
    }


    public String getFieldname() {
        return fieldname;
    }


    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }


    public String getFielddescription() {
        return fielddescription;
    }


    public void setFielddescription(String fielddescription) {
        this.fielddescription = fielddescription;
    }


    public int getMegadatatypeid() {
        return megadatatypeid;
    }


    public void setMegadatatypeid(int megadatatypeid) {
        this.megadatatypeid = megadatatypeid;
    }


    public boolean getIsrequired() {
        return isrequired;
    }


    public void setIsrequired(boolean isrequired) {
        this.isrequired = isrequired;
    }


    public int getLogid() {
        return logid;
    }


    public void setLogid(int logid) {
        this.logid = logid;
    }


}