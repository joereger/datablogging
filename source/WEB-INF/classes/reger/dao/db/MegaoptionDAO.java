package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'megaoption' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorMegaoptionDAO.java
 * Finders for this DAO: reger.dao.finders.MegaoptionFinder.java
 * 
 */

public class MegaoptionDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "megaoptionDAO";

    protected int megaoptionid = 0;
    protected int logid = 0;
    protected int megafieldid = 0;
    protected String optiontext = "";
    protected String optiontextdisplayoverride = "";
    protected boolean isdefault = true;
    protected boolean isactive = true;

    public MegaoptionDAO (int megaoptionid){
        this.megaoptionid = megaoptionid;
        load();
    }

    public MegaoptionDAO(){


    }

    public void load(){
        if (megaoptionid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(megaoptionid), CACHEGROUP);
            if (obj!=null && (obj instanceof MegaoptionDAO)){
                setProperties((MegaoptionDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT megaoptionid, logid, megafieldid, optiontext, optiontextdisplayoverride, isdefault, isactive  FROM megaoption WHERE megaoptionid='"+megaoptionid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        megaoptionid = Integer.parseInt(rstData[0][0]);
                    } else {
                        megaoptionid = 0;
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

                    optiontext = rstData[0][3];

                    optiontextdisplayoverride = rstData[0][4];

                    isdefault = reger.core.Util.booleanFromSQLText(rstData[0][5]);

                    isactive = reger.core.Util.booleanFromSQLText(rstData[0][6]);
                }
                CacheFactory.getCacheProvider().put(String.valueOf(megaoptionid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT megaoptionid FROM megaoption WHERE megaoptionid='"+megaoptionid+"' AND megaoptionid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE megaoption SET megaoptionid='"+megaoptionid+"', logid='"+logid+"', megafieldid='"+megafieldid+"', optiontext='"+reger.core.Util.cleanForSQL(optiontext)+"', optiontextdisplayoverride='"+reger.core.Util.cleanForSQL(optiontextdisplayoverride)+"', isdefault='"+reger.core.Util.booleanAsSQLText(isdefault)+"', isactive='"+reger.core.Util.booleanAsSQLText(isactive)+"'  WHERE megaoptionid='"+megaoptionid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(megaoptionid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            megaoptionid = Db.RunSQLInsert("INSERT INTO megaoption(logid, megafieldid, optiontext, optiontextdisplayoverride, isdefault, isactive ) VALUES('"+megaoptionid+"', '"+logid+"', '"+megafieldid+"', '"+reger.core.Util.cleanForSQL(optiontext)+"', '"+reger.core.Util.cleanForSQL(optiontextdisplayoverride)+"', '"+reger.core.Util.booleanAsSQLText(isdefault)+"', '"+reger.core.Util.booleanAsSQLText(isactive)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(megaoptionid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM megaoption WHERE megaoptionid='"+megaoptionid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(megaoptionid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorMegaoptionDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "megaoptionDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return megaoptionid;
    }

    public String getPrimaryKeyName(){
        return "megaoptionid";
    }

    public String getTableName(){
        return "megaoption";
    }

    public void setProperties(MegaoptionDAO obj){
        if(obj!=null){
            this.megaoptionid = obj.megaoptionid;
            this.logid = obj.logid;
            this.megafieldid = obj.megafieldid;
            this.optiontext = obj.optiontext;
            this.optiontextdisplayoverride = obj.optiontextdisplayoverride;
            this.isdefault = obj.isdefault;
            this.isactive = obj.isactive;
        }
    }


    public int getMegaoptionid() {
        return megaoptionid;
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


    public String getOptiontext() {
        return optiontext;
    }


    public void setOptiontext(String optiontext) {
        this.optiontext = optiontext;
    }


    public String getOptiontextdisplayoverride() {
        return optiontextdisplayoverride;
    }


    public void setOptiontextdisplayoverride(String optiontextdisplayoverride) {
        this.optiontextdisplayoverride = optiontextdisplayoverride;
    }


    public boolean getIsdefault() {
        return isdefault;
    }


    public void setIsdefault(boolean isdefault) {
        this.isdefault = isdefault;
    }


    public boolean getIsactive() {
        return isactive;
    }


    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }


}