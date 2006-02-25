package reger.mega;

import reger.core.db.Db;

/**
 * Entry File DAO
 */
public class EntryFileDAO {

    protected int imageid = 0;
    protected int eventid = 0;
    protected int accountid = 0;
    protected int accountuserid = 0;
    protected String filename = "";
    protected String description = "";
    protected int sizeinbytes = 0;
    protected int order = 0;


    public EntryFileDAO (int imageid){
        this.imageid = imageid;
        load();
    }

    public EntryFileDAO(){


    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid, eventid, accountid, accountuserid, filename, description, sizeinbytes, order FROM image WHERE imageid='"+imageid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            imageid = Integer.parseInt(rstData[0][0]);
            eventid = Integer.parseInt(rstData[0][1]);
            accountid = Integer.parseInt(rstData[0][2]);
            accountuserid = Integer.parseInt(rstData[0][3]);
            filename = rstData[0][4];
            description = rstData[0][5];
            sizeinbytes = Integer.parseInt(rstData[0][6]);
            order = Integer.parseInt(rstData[0][7]);
        }
    }

    public void save(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT imageid FROM image WHERE imageid='"+imageid +"' AND imageid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE image SET eventid='"+eventid+"', accountid='"+accountid+"', accountuserid='"+accountuserid+"', filename='"+reger.core.Util.cleanForSQL(filename)+"', description='"+reger.core.Util.cleanForSQL(description)+"', sizeinbytes='"+sizeinbytes+"', order='"+order+"' WHERE imageid='"+imageid +"'");
            //-----------------------------------
            //-----------------------------------
        } else {
            //-----------------------------------
            //-----------------------------------
            imageid = Db.RunSQLInsert("INSERT INTO poll(eventid, accountid, accountuserid, filename, description, sizeinbytes, order) VALUES('"+eventid+"', '"+accountid +"', '"+accountuserid+"', '"+reger.core.Util.cleanForSQL(filename)+"', '"+reger.core.Util.cleanForSQL(description)+"', '"+sizeinbytes+"', '"+order+"')");
            //-----------------------------------
            //-----------------------------------
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM image WHERE imageid='"+imageid +"'");
        //-----------------------------------
        //-----------------------------------
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

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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
}
