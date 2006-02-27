package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'megafieldparam' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorMegafieldparamDAO.java
 * Finders for this DAO: reger.dao.finders.MegafieldparamFinder.java
 * 
 */

public class MegafieldparamDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "megafieldparamDAO";

    protected int megafieldparamid = 0;
    protected String oneworddatabasekey = "";
    protected int megafieldid = 0;
    protected String value = "";

    public MegafieldparamDAO (int megafieldparamid){
        this.megafieldparamid = megafieldparamid;
        load();
    }

    public MegafieldparamDAO(){


    }

    public void load(){
        if (megafieldparamid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(megafieldparamid), CACHEGROUP);
            if (obj!=null && (obj instanceof MegafieldparamDAO)){
                setProperties((MegafieldparamDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT megafieldparamid, oneworddatabasekey, megafieldid, value  FROM megafieldparam WHERE megafieldparamid='"+megafieldparamid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        megafieldparamid = Integer.parseInt(rstData[0][0]);
                    } else {
                        megafieldparamid = 0;
                    }

                    oneworddatabasekey = rstData[0][1];

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        megafieldid = Integer.parseInt(rstData[0][2]);
                    } else {
                        megafieldid = 0;
                    }

                    value = rstData[0][3];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(megafieldparamid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT megafieldparamid FROM megafieldparam WHERE megafieldparamid='"+megafieldparamid+"' AND megafieldparamid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE megafieldparam SET megafieldparamid='"+megafieldparamid+"', oneworddatabasekey='"+reger.core.Util.cleanForSQL(oneworddatabasekey)+"', megafieldid='"+megafieldid+"', value='"+reger.core.Util.cleanForSQL(value)+"'  WHERE megafieldparamid='"+megafieldparamid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(megafieldparamid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            megafieldparamid = Db.RunSQLInsert("INSERT INTO megafieldparam(oneworddatabasekey, megafieldid, value ) VALUES('"+megafieldparamid+"', '"+reger.core.Util.cleanForSQL(oneworddatabasekey)+"', '"+megafieldid+"', '"+reger.core.Util.cleanForSQL(value)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(megafieldparamid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM megafieldparam WHERE megafieldparamid='"+megafieldparamid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(megafieldparamid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorMegafieldparamDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "megafieldparamDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return megafieldparamid;
    }

    public String getPrimaryKeyName(){
        return "megafieldparamid";
    }

    public String getTableName(){
        return "megafieldparam";
    }

    public void setProperties(MegafieldparamDAO obj){
        if(obj!=null){
            this.megafieldparamid = obj.megafieldparamid;
            this.oneworddatabasekey = obj.oneworddatabasekey;
            this.megafieldid = obj.megafieldid;
            this.value = obj.value;
        }
    }


    public int getMegafieldparamid() {
        return megafieldparamid;
    }


    public String getOneworddatabasekey() {
        return oneworddatabasekey;
    }


    public void setOneworddatabasekey(String oneworddatabasekey) {
        this.oneworddatabasekey = oneworddatabasekey;
    }


    public int getMegafieldid() {
        return megafieldid;
    }


    public void setMegafieldid(int megafieldid) {
        this.megafieldid = megafieldid;
    }


    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }


}