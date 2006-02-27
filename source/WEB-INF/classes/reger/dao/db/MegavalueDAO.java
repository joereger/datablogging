package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'megavalue' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorMegavalueDAO.java
 * Finders for this DAO: reger.dao.finders.MegavalueFinder.java
 * 
 */

public class MegavalueDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "megavalueDAO";

    protected int megavalueid = 0;
    protected int megafieldid = 0;
    protected int eventid = 0;
    protected String megavalue = "";
    protected String megavalueextended = "";

    public MegavalueDAO (int megavalueid){
        this.megavalueid = megavalueid;
        load();
    }

    public MegavalueDAO(){


    }

    public void load(){
        if (megavalueid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(megavalueid), CACHEGROUP);
            if (obj!=null && (obj instanceof MegavalueDAO)){
                setProperties((MegavalueDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT megavalueid, megafieldid, eventid, megavalue, megavalueextended  FROM megavalue WHERE megavalueid='"+megavalueid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        megavalueid = Integer.parseInt(rstData[0][0]);
                    } else {
                        megavalueid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        megafieldid = Integer.parseInt(rstData[0][1]);
                    } else {
                        megafieldid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        eventid = Integer.parseInt(rstData[0][2]);
                    } else {
                        eventid = 0;
                    }

                    megavalue = rstData[0][3];

                    megavalueextended = rstData[0][4];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(megavalueid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT megavalueid FROM megavalue WHERE megavalueid='"+megavalueid+"' AND megavalueid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE megavalue SET megavalueid='"+megavalueid+"', megafieldid='"+megafieldid+"', eventid='"+eventid+"', megavalue='"+reger.core.Util.cleanForSQL(megavalue)+"', megavalueextended='"+reger.core.Util.cleanForSQL(megavalueextended)+"'  WHERE megavalueid='"+megavalueid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(megavalueid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            megavalueid = Db.RunSQLInsert("INSERT INTO megavalue(megafieldid, eventid, megavalue, megavalueextended ) VALUES('"+megavalueid+"', '"+megafieldid+"', '"+eventid+"', '"+reger.core.Util.cleanForSQL(megavalue)+"', '"+reger.core.Util.cleanForSQL(megavalueextended)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(megavalueid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM megavalue WHERE megavalueid='"+megavalueid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(megavalueid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorMegavalueDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "megavalueDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return megavalueid;
    }

    public String getPrimaryKeyName(){
        return "megavalueid";
    }

    public String getTableName(){
        return "megavalue";
    }

    public void setProperties(MegavalueDAO obj){
        if(obj!=null){
            this.megavalueid = obj.megavalueid;
            this.megafieldid = obj.megafieldid;
            this.eventid = obj.eventid;
            this.megavalue = obj.megavalue;
            this.megavalueextended = obj.megavalueextended;
        }
    }


    public int getMegavalueid() {
        return megavalueid;
    }


    public int getMegafieldid() {
        return megafieldid;
    }


    public void setMegafieldid(int megafieldid) {
        this.megafieldid = megafieldid;
    }


    public int getEventid() {
        return eventid;
    }


    public void setEventid(int eventid) {
        this.eventid = eventid;
    }


    public String getMegavalue() {
        return megavalue;
    }


    public void setMegavalue(String megavalue) {
        this.megavalue = megavalue;
    }


    public String getMegavalueextended() {
        return megavalueextended;
    }


    public void setMegavalueextended(String megavalueextended) {
        this.megavalueextended = megavalueextended;
    }


}