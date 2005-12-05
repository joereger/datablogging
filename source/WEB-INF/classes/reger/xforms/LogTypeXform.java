package reger.xforms;

import reger.core.db.Db;

/**
 * represents the xform data instance as stored in the database
 */
public class LogTypeXform {

    private int logtypexformid;
    private int eventtypeid;
    private String xform;

    public LogTypeXform(){
    
    }
    

    public void loadByEventtypeid(int eventtypeid){
        reger.core.Debug.debug(4, "LogTypeXForm.java", "Loading xform from database by eventtypeid="+eventtypeid);

        this.logtypexformid = 0;
        this.eventtypeid=0;
        this.xform = "";
        
        //-----------------------------------
        //-----------------------------------
        String[][] rstXform= Db.RunSQL("SELECT logtypexformid, eventtypeid, xform FROM logtypexform WHERE eventtypeid='"+eventtypeid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstXform!=null && rstXform.length>0){
            for(int i=0; i<rstXform.length; i++){
                reger.core.Debug.debug(5, "LogTypeXForm.java", "Found record for eventtypeid="+eventtypeid);
                this.logtypexformid = Integer.parseInt(rstXform[i][0]);
                this.eventtypeid = Integer.parseInt(rstXform[i][1]);
                //@todo Possibly make this an array to hold multiple xforms per log.  As is it'll use the last one if there are multiple.
                this.xform = rstXform[i][2];
            }
        } else {
            reger.core.Debug.debug(4, "LogTypeXForm.java", "No db records found for eventtypeid="+eventtypeid);
        }

        reger.core.Debug.debug(4, "LogTypeXForm.java", "xform="+this.xform.replaceAll("<", "&lt;"));

    }
    
    public void loadByLogTypeXformid(int logtypexformid){
        this.logtypexformid = 0;
        this.eventtypeid=0;
        this.xform = "";
        
        //-----------------------------------
        //-----------------------------------
        String[][] rstXform= Db.RunSQL("SELECT logtypexformid, eventtypeid, xform FROM logtypexform WHERE logtypexformid='"+logtypexformid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstXform!=null && rstXform.length>0){
            for(int i=0; i<rstXform.length; i++){
                this.logtypexformid = Integer.parseInt(rstXform[i][0]);
                this.eventtypeid = Integer.parseInt(rstXform[i][1]);
                //@todo Possibly make this an array to hold multiple xforms per log.  As is it'll use the last one if there are multiple.
                this.xform = rstXform[i][2];
            }
        }
    }
    
    public void save(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstXform= Db.RunSQL("SELECT logtypexformid FROM logtypexform WHERE logtypexformid='"+logtypexformid+"' AND logtypexformid>'0'");
        //-----------------------------------
        //-----------------------------------
        if (rstXform!=null && rstXform.length>0){
            //Update
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE logtypexform SET eventtypeid='"+eventtypeid+"', xform='"+reger.core.Util.cleanForSQL(xform)+"' WHERE logtypexformid='"+logtypexformid+"'");
            //-----------------------------------
            //-----------------------------------
        } else {
            //Insert
            //-----------------------------------
            //-----------------------------------
            logtypexformid = Db.RunSQLInsert("INSERT INTO logtypexform(eventtypeid, xform) VALUES('"+eventtypeid+"', '"+reger.core.Util.cleanForSQL(xform)+"')");
            //-----------------------------------
            //-----------------------------------
        }
    }

    public int getLogTypeXformid() {
        return logtypexformid;
    }

    public int getEventtypeid() {
        return eventtypeid;
    }

    public void setEventtypeid(int eventtypeid) {
        this.eventtypeid = eventtypeid;
    }

    public String getXform() {
        return xform;
    }

    public void setXform(String xform) {
        this.xform = xform;
    }
}
