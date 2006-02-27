package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'pagenotfound' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorPagenotfoundDAO.java
 * Finders for this DAO: reger.dao.finders.PagenotfoundFinder.java
 * 
 */

public class PagenotfoundDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "pagenotfoundDAO";

    protected int pagenotfoundid = 0;
    protected String pagename = "";
    protected int count = 0;
    protected String mostrecentreferer = "";

    public PagenotfoundDAO (int pagenotfoundid){
        this.pagenotfoundid = pagenotfoundid;
        load();
    }

    public PagenotfoundDAO(){


    }

    public void load(){
        if (pagenotfoundid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(pagenotfoundid), CACHEGROUP);
            if (obj!=null && (obj instanceof PagenotfoundDAO)){
                setProperties((PagenotfoundDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT pagenotfoundid, pagename, count, mostrecentreferer  FROM pagenotfound WHERE pagenotfoundid='"+pagenotfoundid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        pagenotfoundid = Integer.parseInt(rstData[0][0]);
                    } else {
                        pagenotfoundid = 0;
                    }

                    pagename = rstData[0][1];

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        count = Integer.parseInt(rstData[0][2]);
                    } else {
                        count = 0;
                    }

                    mostrecentreferer = rstData[0][3];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(pagenotfoundid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT pagenotfoundid FROM pagenotfound WHERE pagenotfoundid='"+pagenotfoundid+"' AND pagenotfoundid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE pagenotfound SET pagenotfoundid='"+pagenotfoundid+"', pagename='"+reger.core.Util.cleanForSQL(pagename)+"', count='"+count+"', mostrecentreferer='"+reger.core.Util.cleanForSQL(mostrecentreferer)+"'  WHERE pagenotfoundid='"+pagenotfoundid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(pagenotfoundid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            pagenotfoundid = Db.RunSQLInsert("INSERT INTO pagenotfound(pagename, count, mostrecentreferer ) VALUES('"+pagenotfoundid+"', '"+reger.core.Util.cleanForSQL(pagename)+"', '"+count+"', '"+reger.core.Util.cleanForSQL(mostrecentreferer)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(pagenotfoundid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM pagenotfound WHERE pagenotfoundid='"+pagenotfoundid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(pagenotfoundid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorPagenotfoundDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "pagenotfoundDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return pagenotfoundid;
    }

    public String getPrimaryKeyName(){
        return "pagenotfoundid";
    }

    public String getTableName(){
        return "pagenotfound";
    }

    public void setProperties(PagenotfoundDAO obj){
        if(obj!=null){
            this.pagenotfoundid = obj.pagenotfoundid;
            this.pagename = obj.pagename;
            this.count = obj.count;
            this.mostrecentreferer = obj.mostrecentreferer;
        }
    }


    public int getPagenotfoundid() {
        return pagenotfoundid;
    }


    public String getPagename() {
        return pagename;
    }


    public void setPagename(String pagename) {
        this.pagename = pagename;
    }


    public int getCount() {
        return count;
    }


    public void setCount(int count) {
        this.count = count;
    }


    public String getMostrecentreferer() {
        return mostrecentreferer;
    }


    public void setMostrecentreferer(String mostrecentreferer) {
        this.mostrecentreferer = mostrecentreferer;
    }


}