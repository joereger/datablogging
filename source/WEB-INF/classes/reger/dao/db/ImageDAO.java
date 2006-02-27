package reger.dao.db;

import reger.core.db.Db;
import reger.cache.providers.CacheFactory;

/**
 * DAO for the 'image' database table
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
 * Validator for this DAO: reger.dao.validators.ValidatorImageDAO.java
 * Finders for this DAO: reger.dao.finders.ImageFinder.java
 * 
 */

public class ImageDAO implements reger.dao.DAO {

    private static String CACHEGROUP = "imageDAO";

    protected int imageid = 0;
    protected int eventid = 0;
    protected int accountuserid = 0;
    protected String image = "";
    protected String description = "";
    protected int sizeinbytes = 0;
    protected int order = 0;
    protected String originalfilename = "";
    protected int accountid = 0;
    protected String filename = "";

    public ImageDAO (int imageid){
        this.imageid = imageid;
        load();
    }

    public ImageDAO(){


    }

    public void load(){
        if (imageid>0){
            Object obj = CacheFactory.getCacheProvider().get(String.valueOf(imageid), CACHEGROUP);
            if (obj!=null && (obj instanceof ImageDAO)){
                setProperties((ImageDAO)obj);
            } else {
                //-----------------------------------
                //-----------------------------------
                String[][] rstData= Db.RunSQL("SELECT imageid, eventid, accountuserid, image, description, sizeinbytes, order, originalfilename, accountid, filename  FROM image WHERE imageid='"+imageid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstData!=null && rstData.length>0){
                
                    if (reger.core.Util.isinteger(rstData[0][0])){
                        imageid = Integer.parseInt(rstData[0][0]);
                    } else {
                        imageid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][1])){
                        eventid = Integer.parseInt(rstData[0][1]);
                    } else {
                        eventid = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][2])){
                        accountuserid = Integer.parseInt(rstData[0][2]);
                    } else {
                        accountuserid = 0;
                    }

                    image = rstData[0][3];

                    description = rstData[0][4];

                    if (reger.core.Util.isinteger(rstData[0][5])){
                        sizeinbytes = Integer.parseInt(rstData[0][5]);
                    } else {
                        sizeinbytes = 0;
                    }

                    if (reger.core.Util.isinteger(rstData[0][6])){
                        order = Integer.parseInt(rstData[0][6]);
                    } else {
                        order = 0;
                    }

                    originalfilename = rstData[0][7];

                    if (reger.core.Util.isinteger(rstData[0][8])){
                        accountid = Integer.parseInt(rstData[0][8]);
                    } else {
                        accountid = 0;
                    }

                    filename = rstData[0][9];
                }
                CacheFactory.getCacheProvider().put(String.valueOf(imageid), CACHEGROUP, this);
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
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE imageid='"+imageid+"' AND imageid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int fsdfsdf = Db.RunSQLUpdate("UPDATE image SET imageid='"+imageid+"', eventid='"+eventid+"', accountuserid='"+accountuserid+"', image='"+reger.core.Util.cleanForSQL(image)+"', description='"+reger.core.Util.cleanForSQL(description)+"', sizeinbytes='"+sizeinbytes+"', order='"+order+"', originalfilename='"+reger.core.Util.cleanForSQL(originalfilename)+"', accountid='"+accountid+"', filename='"+reger.core.Util.cleanForSQL(filename)+"'  WHERE imageid='"+imageid+"'");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().flush(String.valueOf(imageid), CACHEGROUP);
        } else {
            //-----------------------------------
            //-----------------------------------
            imageid = Db.RunSQLInsert("INSERT INTO image(eventid, accountuserid, image, description, sizeinbytes, order, originalfilename, accountid, filename ) VALUES('"+imageid+"', '"+eventid+"', '"+accountuserid+"', '"+reger.core.Util.cleanForSQL(image)+"', '"+reger.core.Util.cleanForSQL(description)+"', '"+sizeinbytes+"', '"+order+"', '"+reger.core.Util.cleanForSQL(originalfilename)+"', '"+accountid+"', '"+reger.core.Util.cleanForSQL(filename)+"' )");
            //-----------------------------------
            //-----------------------------------
            CacheFactory.getCacheProvider().put(String.valueOf(imageid), CACHEGROUP, this);
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM image WHERE imageid='"+imageid+"'");
        //-----------------------------------
        //-----------------------------------
        CacheFactory.getCacheProvider().flush(String.valueOf(imageid), CACHEGROUP);
    }

    public void validate() throws reger.core.ValidationException{
        try{
            reger.dao.validators.Validator validator = (reger.dao.validators.Validator)(Class.forName("reger.dao.validators.ValidatorImageDAO").newInstance());
            try{
                validator.validate(this);
            } catch (reger.core.ValidationException vex){
                throw vex;
            }
        } catch (ClassNotFoundException ex){
            
        } catch (Throwable e){
            reger.core.Debug.errorsave(e, "imageDAO.java");
        }
    }

    public int getPrimaryKeyValue(){
        return imageid;
    }

    public String getPrimaryKeyName(){
        return "imageid";
    }

    public String getTableName(){
        return "image";
    }

    public void setProperties(ImageDAO obj){
        if(obj!=null){
            this.imageid = obj.imageid;
            this.eventid = obj.eventid;
            this.accountuserid = obj.accountuserid;
            this.image = obj.image;
            this.description = obj.description;
            this.sizeinbytes = obj.sizeinbytes;
            this.order = obj.order;
            this.originalfilename = obj.originalfilename;
            this.accountid = obj.accountid;
            this.filename = obj.filename;
        }
    }


    public int getImageid() {
        return imageid;
    }


    public int getEventid() {
        return eventid;
    }


    public void setEventid(int eventid) {
        this.eventid = eventid;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }


    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public int getSizeinbytes() {
        return sizeinbytes;
    }


    public void setSizeinbytes(int sizeinbytes) {
        this.sizeinbytes = sizeinbytes;
    }


    public int getOrder() {
        return order;
    }


    public void setOrder(int order) {
        this.order = order;
    }


    public String getOriginalfilename() {
        return originalfilename;
    }


    public void setOriginalfilename(String originalfilename) {
        this.originalfilename = originalfilename;
    }


    public int getAccountid() {
        return accountid;
    }


    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


    public String getFilename() {
        return filename;
    }


    public void setFilename(String filename) {
        this.filename = filename;
    }


}