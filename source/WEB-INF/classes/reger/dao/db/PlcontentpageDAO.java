package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'plcontentpage' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorPlcontentpageDAO.java
 * Finders for this DAO: reger.dao.finders.PlcontentpageFinder.java
 * 
 */

public class PlcontentpageDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "plcontentpageDAO";

    protected int plcontentpageid = 0;
    protected int plid = 0;
    protected String name = "";
    protected String content = "";
    protected int nestednavparenttype = 0;
    protected int nestednavparentid = 0;
    protected int nestednavorder = 0;

    public PlcontentpageDAO (int plcontentpageid){
        this.plcontentpageid = plcontentpageid;
        load();
    }

    public PlcontentpageDAO(){


    }

    public void load(){
        if (plcontentpageid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(plcontentpageid), CACHEGROUP);
            if (obj!=null && (obj instanceof PlcontentpageDAO)){
                setProperties((PlcontentpageDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT plcontentpageid, plid, name, content, nestednavparenttype, nestednavparentid, nestednavorder  FROM plcontentpage WHERE plcontentpageid='"+plcontentpageid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        plcontentpageid = Integer.parseInt(rstData[0][0]);
                    } else {
                        plcontentpageid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        plid = Integer.parseInt(rstData[0][1]);
                    } else {
                        plid = 0;
                    }

                    name = rstData[0][2];

                    content = rstData[0][3];

                    if (reger.core.Util.isinteger(rstData[0][4])){
                        nestednavparenttype = Integer.parseInt(rstData[0][4]);
                    } else {
                        nestednavparenttype = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][5])){
                        nestednavparentid = Integer.parseInt(rstData[0][5]);
                    } else {
                        nestednavparentid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][6])){
                        nestednavorder = Integer.parseInt(rstData[0][6]);
                    } else {
                        nestednavorder = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(plcontentpageid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE plcontentpageid='"+plcontentpageid+"' AND plcontentpageid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE plcontentpage SET plcontentpageid='"+plcontentpageid+"', plid='"+plid+"', name='"+reger.core.Util.cleanForSQL(name)+"', content='"+reger.core.Util.cleanForSQL(content)+"', nestednavparenttype='"+nestednavparenttype+"', nestednavparentid='"+nestednavparentid+"', nestednavorder='"+nestednavorder+"'  WHERE plcontentpageid='"+plcontentpageid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(plcontentpageid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            plcontentpageid = Db.RunSQLInsert("INSERT INTO plcontentpage(plid, name, content, nestednavparenttype, nestednavparentid, nestednavorder ) VALUES('"+plcontentpageid+"', '"+plid+"', '"+reger.core.Util.cleanForSQL(name)+"', '"+reger.core.Util.cleanForSQL(content)+"', '"+nestednavparenttype+"', '"+nestednavparentid+"', '"+nestednavorder+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(plcontentpageid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM plcontentpage WHERE plcontentpageid='"+plcontentpageid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(plcontentpageid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorPlcontentpageDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "plcontentpageDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return plcontentpageid;
    }

    public String getPrimaryKeyName(){
        return "plcontentpageid";
    }

    public String getTableName(){
        return "plcontentpage";
    }

    public void setProperties(PlcontentpageDAO obj){
        if(obj!=null){
            this.plcontentpageid = obj.plcontentpageid;
            this.plid = obj.plid;
            this.name = obj.name;
            this.content = obj.content;
            this.nestednavparenttype = obj.nestednavparenttype;
            this.nestednavparentid = obj.nestednavparentid;
            this.nestednavorder = obj.nestednavorder;
        }
    }


    public int getPlcontentpageid() {
        return plcontentpageid;
    }


    public int getPlid() {
        return plid;
    }


    public void setPlid(int plid) {
        this.plid = plid;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public int getNestednavparenttype() {
        return nestednavparenttype;
    }


    public void setNestednavparenttype(int nestednavparenttype) {
        this.nestednavparenttype = nestednavparenttype;
    }


    public int getNestednavparentid() {
        return nestednavparentid;
    }


    public void setNestednavparentid(int nestednavparentid) {
        this.nestednavparentid = nestednavparentid;
    }


    public int getNestednavorder() {
        return nestednavorder;
    }


    public void setNestednavorder(int nestednavorder) {
        this.nestednavorder = nestednavorder;
    }


}