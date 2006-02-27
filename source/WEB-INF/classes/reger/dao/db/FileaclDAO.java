package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'fileacl' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorFileaclDAO.java
 * Finders for this DAO: reger.dao.finders.FileaclFinder.java
 * 
 */

public class FileaclDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "fileaclDAO";

    protected int fileaclid = 0;
    protected int accountid = 0;
    protected int accountuserid = 0;
    protected String pathandorfilename = "";

    public FileaclDAO (int fileaclid){
        this.fileaclid = fileaclid;
        load();
    }

    public FileaclDAO(){


    }

    public void load(){
        if (fileaclid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(fileaclid), CACHEGROUP);
            if (obj!=null && (obj instanceof FileaclDAO)){
                setProperties((FileaclDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT fileaclid, accountid, accountuserid, pathandorfilename  FROM fileacl WHERE fileaclid='"+fileaclid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        fileaclid = Integer.parseInt(rstData[0][0]);
                    } else {
                        fileaclid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        accountuserid = Integer.parseInt(rstData[0][2]);
                    } else {
                        accountuserid = 0;
                    }

                    pathandorfilename = rstData[0][3];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(fileaclid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT fileaclid FROM fileacl WHERE fileaclid='"+fileaclid+"' AND fileaclid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE fileacl SET fileaclid='"+fileaclid+"', accountid='"+accountid+"', accountuserid='"+accountuserid+"', pathandorfilename='"+reger.core.Util.cleanForSQL(pathandorfilename)+"'  WHERE fileaclid='"+fileaclid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(fileaclid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            fileaclid = Db.RunSQLInsert("INSERT INTO fileacl(accountid, accountuserid, pathandorfilename ) VALUES('"+fileaclid+"', '"+accountid+"', '"+accountuserid+"', '"+reger.core.Util.cleanForSQL(pathandorfilename)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(fileaclid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM fileacl WHERE fileaclid='"+fileaclid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(fileaclid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorFileaclDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "fileaclDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return fileaclid;
    }

    public String getPrimaryKeyName(){
        return "fileaclid";
    }

    public String getTableName(){
        return "fileacl";
    }

    public void setProperties(FileaclDAO obj){
        if(obj!=null){
            this.fileaclid = obj.fileaclid;
            this.accountid = obj.accountid;
            this.accountuserid = obj.accountuserid;
            this.pathandorfilename = obj.pathandorfilename;
        }
    }


    public int getFileaclid() {
        return fileaclid;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }


    public String getPathandorfilename() {
        return pathandorfilename;
    }


    public void setPathandorfilename(String pathandorfilename) {
        this.pathandorfilename = pathandorfilename;
    }


}