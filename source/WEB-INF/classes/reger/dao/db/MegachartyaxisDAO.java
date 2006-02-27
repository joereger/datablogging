package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'megachartyaxis' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorMegachartyaxisDAO.java
 * Finders for this DAO: reger.dao.finders.MegachartyaxisFinder.java
 * 
 */

public class MegachartyaxisDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "megachartyaxisDAO";

    protected int megachartyaxisid = 0;
    protected int megachartid = 0;
    protected int ymegafieldid = 0;
    protected int ylogid = 0;
    protected int yeventtypeid = 0;

    public MegachartyaxisDAO (int megachartyaxisid){
        this.megachartyaxisid = megachartyaxisid;
        load();
    }

    public MegachartyaxisDAO(){


    }

    public void load(){
        if (megachartyaxisid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(megachartyaxisid), CACHEGROUP);
            if (obj!=null && (obj instanceof MegachartyaxisDAO)){
                setProperties((MegachartyaxisDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT megachartyaxisid, megachartid, ymegafieldid, ylogid, yeventtypeid  FROM megachartyaxis WHERE megachartyaxisid='"+megachartyaxisid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        megachartyaxisid = Integer.parseInt(rstData[0][0]);
                    } else {
                        megachartyaxisid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        megachartid = Integer.parseInt(rstData[0][1]);
                    } else {
                        megachartid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        ymegafieldid = Integer.parseInt(rstData[0][2]);
                    } else {
                        ymegafieldid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][3])){
                        ylogid = Integer.parseInt(rstData[0][3]);
                    } else {
                        ylogid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][4])){
                        yeventtypeid = Integer.parseInt(rstData[0][4]);
                    } else {
                        yeventtypeid = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(megachartyaxisid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT megachartyaxisid FROM megachartyaxis WHERE megachartyaxisid='"+megachartyaxisid+"' AND megachartyaxisid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE megachartyaxis SET megachartyaxisid='"+megachartyaxisid+"', megachartid='"+megachartid+"', ymegafieldid='"+ymegafieldid+"', ylogid='"+ylogid+"', yeventtypeid='"+yeventtypeid+"'  WHERE megachartyaxisid='"+megachartyaxisid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(megachartyaxisid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            megachartyaxisid = Db.RunSQLInsert("INSERT INTO megachartyaxis(megachartid, ymegafieldid, ylogid, yeventtypeid ) VALUES('"+megachartyaxisid+"', '"+megachartid+"', '"+ymegafieldid+"', '"+ylogid+"', '"+yeventtypeid+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(megachartyaxisid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM megachartyaxis WHERE megachartyaxisid='"+megachartyaxisid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(megachartyaxisid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorMegachartyaxisDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "megachartyaxisDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return megachartyaxisid;
    }

    public String getPrimaryKeyName(){
        return "megachartyaxisid";
    }

    public String getTableName(){
        return "megachartyaxis";
    }

    public void setProperties(MegachartyaxisDAO obj){
        if(obj!=null){
            this.megachartyaxisid = obj.megachartyaxisid;
            this.megachartid = obj.megachartid;
            this.ymegafieldid = obj.ymegafieldid;
            this.ylogid = obj.ylogid;
            this.yeventtypeid = obj.yeventtypeid;
        }
    }


    public int getMegachartyaxisid() {
        return megachartyaxisid;
    }


    public int getMegachartid() {
        return megachartid;
    }


    public void setMegachartid(int megachartid) {
        this.megachartid = megachartid;
    }


    public int getYmegafieldid() {
        return ymegafieldid;
    }


    public void setYmegafieldid(int ymegafieldid) {
        this.ymegafieldid = ymegafieldid;
    }


    public int getYlogid() {
        return ylogid;
    }


    public void setYlogid(int ylogid) {
        this.ylogid = ylogid;
    }


    public int getYeventtypeid() {
        return yeventtypeid;
    }


    public void setYeventtypeid(int yeventtypeid) {
        this.yeventtypeid = yeventtypeid;
    }


}