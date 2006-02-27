package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'megadefault' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorMegadefaultDAO.java
 * Finders for this DAO: reger.dao.finders.MegadefaultFinder.java
 * 
 */

public class MegadefaultDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "megadefaultDAO";

    protected int megadefaultid = 0;
    protected int logid = 0;
    protected int megafieldid = 0;
    protected String megadefault = "";
    protected String megadefaultextended = "";

    public MegadefaultDAO (int megadefaultid){
        this.megadefaultid = megadefaultid;
        load();
    }

    public MegadefaultDAO(){


    }

    public void load(){
        if (megadefaultid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(megadefaultid), CACHEGROUP);
            if (obj!=null && (obj instanceof MegadefaultDAO)){
                setProperties((MegadefaultDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT megadefaultid, logid, megafieldid, megadefault, megadefaultextended  FROM megadefault WHERE megadefaultid='"+megadefaultid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        megadefaultid = Integer.parseInt(rstData[0][0]);
                    } else {
                        megadefaultid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        logid = Integer.parseInt(rstData[0][1]);
                    } else {
                        logid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        megafieldid = Integer.parseInt(rstData[0][2]);
                    } else {
                        megafieldid = 0;
                    }

                    megadefault = rstData[0][3];

                    megadefaultextended = rstData[0][4];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(megadefaultid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT megadefaultid FROM megadefault WHERE megadefaultid='"+megadefaultid+"' AND megadefaultid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE megadefault SET megadefaultid='"+megadefaultid+"', logid='"+logid+"', megafieldid='"+megafieldid+"', megadefault='"+reger.core.Util.cleanForSQL(megadefault)+"', megadefaultextended='"+reger.core.Util.cleanForSQL(megadefaultextended)+"'  WHERE megadefaultid='"+megadefaultid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(megadefaultid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            megadefaultid = Db.RunSQLInsert("INSERT INTO megadefault(logid, megafieldid, megadefault, megadefaultextended ) VALUES('"+megadefaultid+"', '"+logid+"', '"+megafieldid+"', '"+reger.core.Util.cleanForSQL(megadefault)+"', '"+reger.core.Util.cleanForSQL(megadefaultextended)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(megadefaultid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM megadefault WHERE megadefaultid='"+megadefaultid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(megadefaultid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorMegadefaultDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "megadefaultDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return megadefaultid;
    }

    public String getPrimaryKeyName(){
        return "megadefaultid";
    }

    public String getTableName(){
        return "megadefault";
    }

    public void setProperties(MegadefaultDAO obj){
        if(obj!=null){
            this.megadefaultid = obj.megadefaultid;
            this.logid = obj.logid;
            this.megafieldid = obj.megafieldid;
            this.megadefault = obj.megadefault;
            this.megadefaultextended = obj.megadefaultextended;
        }
    }


    public int getMegadefaultid() {
        return megadefaultid;
    }


    public int getLogid() {
        return logid;
    }


    public void setLogid(int logid) {
        this.logid = logid;
    }


    public int getMegafieldid() {
        return megafieldid;
    }


    public void setMegafieldid(int megafieldid) {
        this.megafieldid = megafieldid;
    }


    public String getMegadefault() {
        return megadefault;
    }


    public void setMegadefault(String megadefault) {
        this.megadefault = megadefault;
    }


    public String getMegadefaultextended() {
        return megadefaultextended;
    }


    public void setMegadefaultextended(String megadefaultextended) {
        this.megadefaultextended = megadefaultextended;
    }


}