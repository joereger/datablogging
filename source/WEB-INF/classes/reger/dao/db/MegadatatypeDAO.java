package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'megadatatype' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorMegadatatypeDAO.java
 * Finders for this DAO: reger.dao.finders.MegadatatypeFinder.java
 * 
 */

public class MegadatatypeDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "megadatatypeDAO";

    protected int megadatatypeid = 0;
    protected String megadatatypename = "";
    protected String megadatatypedescription = "";

    public MegadatatypeDAO (int megadatatypeid){
        this.megadatatypeid = megadatatypeid;
        load();
    }

    public MegadatatypeDAO(){


    }

    public void load(){
        if (megadatatypeid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(megadatatypeid), CACHEGROUP);
            if (obj!=null && (obj instanceof MegadatatypeDAO)){
                setProperties((MegadatatypeDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT megadatatypeid, megadatatypename, megadatatypedescription  FROM megadatatype WHERE megadatatypeid='"+megadatatypeid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        megadatatypeid = Integer.parseInt(rstData[0][0]);
                    } else {
                        megadatatypeid = 0;
                    }

                    megadatatypename = rstData[0][1];

                    megadatatypedescription = rstData[0][2];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(megadatatypeid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT megadatatypeid FROM megadatatype WHERE megadatatypeid='"+megadatatypeid+"' AND megadatatypeid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE megadatatype SET megadatatypeid='"+megadatatypeid+"', megadatatypename='"+reger.core.Util.cleanForSQL(megadatatypename)+"', megadatatypedescription='"+reger.core.Util.cleanForSQL(megadatatypedescription)+"'  WHERE megadatatypeid='"+megadatatypeid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(megadatatypeid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            megadatatypeid = Db.RunSQLInsert("INSERT INTO megadatatype(megadatatypename, megadatatypedescription ) VALUES('"+megadatatypeid+"', '"+reger.core.Util.cleanForSQL(megadatatypename)+"', '"+reger.core.Util.cleanForSQL(megadatatypedescription)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(megadatatypeid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM megadatatype WHERE megadatatypeid='"+megadatatypeid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(megadatatypeid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorMegadatatypeDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "megadatatypeDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return megadatatypeid;
    }

    public String getPrimaryKeyName(){
        return "megadatatypeid";
    }

    public String getTableName(){
        return "megadatatype";
    }

    public void setProperties(MegadatatypeDAO obj){
        if(obj!=null){
            this.megadatatypeid = obj.megadatatypeid;
            this.megadatatypename = obj.megadatatypename;
            this.megadatatypedescription = obj.megadatatypedescription;
        }
    }


    public int getMegadatatypeid() {
        return megadatatypeid;
    }


    public String getMegadatatypename() {
        return megadatatypename;
    }


    public void setMegadatatypename(String megadatatypename) {
        this.megadatatypename = megadatatypename;
    }


    public String getMegadatatypedescription() {
        return megadatatypedescription;
    }


    public void setMegadatatypedescription(String megadatatypedescription) {
        this.megadatatypedescription = megadatatypedescription;
    }


}