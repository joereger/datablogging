package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'contentpage' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorContentpageDAO.java
 * Finders for this DAO: reger.dao.finders.ContentpageFinder.java
 * 
 */

public class ContentpageDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "contentpageDAO";

    protected int contentpageid = 0;
    protected int accountid = 0;
    protected String name = "";
    protected String content = "";
    protected int nestednavparenttype = 0;
    protected int nestednavparentid = 0;
    protected int nestednavorder = 0;
    protected int sizeinbytes = 0;

    public ContentpageDAO (int contentpageid){
        this.contentpageid = contentpageid;
        load();
    }

    public ContentpageDAO(){


    }

    public void load(){
        if (contentpageid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(contentpageid), CACHEGROUP);
            if (obj!=null && (obj instanceof ContentpageDAO)){
                setProperties((ContentpageDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT contentpageid, accountid, name, content, nestednavparenttype, nestednavparentid, nestednavorder, sizeinbytes  FROM contentpage WHERE contentpageid='"+contentpageid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        contentpageid = Integer.parseInt(rstData[0][0]);
                    } else {
                        contentpageid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        accountid = Integer.parseInt(rstData[0][1]);
                    } else {
                        accountid = 0;
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

                    if (reger.core.Util.isinteger(rstData[0][7])){
                        sizeinbytes = Integer.parseInt(rstData[0][7]);
                    } else {
                        sizeinbytes = 0;
                    }
                }
                CacheFactory.getCacheProvider().put(String.valueOf(contentpageid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT contentpageid FROM contentpage WHERE contentpageid='"+contentpageid+"' AND contentpageid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE contentpage SET contentpageid='"+contentpageid+"', accountid='"+accountid+"', name='"+reger.core.Util.cleanForSQL(name)+"', content='"+reger.core.Util.cleanForSQL(content)+"', nestednavparenttype='"+nestednavparenttype+"', nestednavparentid='"+nestednavparentid+"', nestednavorder='"+nestednavorder+"', sizeinbytes='"+sizeinbytes+"'  WHERE contentpageid='"+contentpageid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(contentpageid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            contentpageid = Db.RunSQLInsert("INSERT INTO contentpage(accountid, name, content, nestednavparenttype, nestednavparentid, nestednavorder, sizeinbytes ) VALUES('"+contentpageid+"', '"+accountid+"', '"+reger.core.Util.cleanForSQL(name)+"', '"+reger.core.Util.cleanForSQL(content)+"', '"+nestednavparenttype+"', '"+nestednavparentid+"', '"+nestednavorder+"', '"+sizeinbytes+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(contentpageid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM contentpage WHERE contentpageid='"+contentpageid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(contentpageid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorContentpageDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "contentpageDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return contentpageid;
    }

    public String getPrimaryKeyName(){
        return "contentpageid";
    }

    public String getTableName(){
        return "contentpage";
    }

    public void setProperties(ContentpageDAO obj){
        if(obj!=null){
            this.contentpageid = obj.contentpageid;
            this.accountid = obj.accountid;
            this.name = obj.name;
            this.content = obj.content;
            this.nestednavparenttype = obj.nestednavparenttype;
            this.nestednavparentid = obj.nestednavparentid;
            this.nestednavorder = obj.nestednavorder;
            this.sizeinbytes = obj.sizeinbytes;
        }
    }


    public int getContentpageid() {
        return contentpageid;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
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


    public int getSizeinbytes() {
        return sizeinbytes;
    }


    public void setSizeinbytes(int sizeinbytes) {
        this.sizeinbytes = sizeinbytes;
    }


}