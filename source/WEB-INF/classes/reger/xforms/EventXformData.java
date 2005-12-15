package reger.xforms;

import reger.core.db.Db;
import reger.cache.EntryCache;
import reger.cache.LogCache;
import reger.Entry;
import reger.Log;
import reger.MegaLogType;
import reger.AllMegaLogTypesInSystem;

/**
 * represents the xform data instance as stored in the database
 */
public class EventXformData {

    private int eventxformdataid;
    private int eventid;
    private String xformdata;

    public EventXformData(){

    }


    public void loadByEventid(int eventid, int logid){
        this.eventxformdataid = 0;
        this.eventid=0;
        this.xformdata = "";

        try{
            //Go get the logid
            Log log = LogCache.get(logid);

            //Go get the event type
            MegaLogType logType = AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(log.getEventtypeid());

            //Get the Xform source
            //String xformsource = logType.getLogtypexform().getXform();

            //-----------------------------------
            //-----------------------------------
            String[][] rstXform= Db.RunSQL("SELECT eventxformdataid, eventid, xformdata FROM eventxformdata WHERE eventid='"+eventid+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstXform!=null && rstXform.length>0){
                for(int i=0; i<rstXform.length; i++){
                    this.eventxformdataid = Integer.parseInt(rstXform[i][0]);
                    this.eventid = Integer.parseInt(rstXform[i][1]);
                    //@todo Possibly make this an array to hold multiple xforms per event.  As is it'll use the last one if there are multiple.
                    this.xformdata = rstXform[i][2];
                }
            }
        } catch (Exception e){
            reger.core.Debug.errorsave(e, "EventXformData.java");
        }

        //Now I have the source and the data... I need to compare the two and make sure they're on the same page

    }
    

    public void loadByEventXformDataid(int eventxformdataid){
        this.eventxformdataid = 0;
        this.eventid=0;
        this.xformdata = "";

        //-----------------------------------
        //-----------------------------------
        String[][] rstXform= Db.RunSQL("SELECT eventxformdataid, eventid, xformdata FROM eventxformdata WHERE eventxformdataid='"+eventxformdataid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstXform!=null && rstXform.length>0){
            for(int i=0; i<rstXform.length; i++){
                this.eventxformdataid = Integer.parseInt(rstXform[i][0]);
                this.eventid = Integer.parseInt(rstXform[i][1]);
                //@todo Possibly make this an array to hold multiple xforms per event.  As is it'll use the last one if there are multiple.
                this.xformdata = rstXform[i][2];
            }
        }
    }

    public void save(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstXform= Db.RunSQL("SELECT eventxformdataid FROM eventxformdata WHERE eventxformdataid='"+eventxformdataid+"' AND eventxformdataid>'0' AND eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstXform!=null && rstXform.length>0){
            //Update
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE eventxformdata SET eventid='"+eventid+"', xformdata='"+reger.core.Util.cleanForSQL(xformdata)+"' WHERE eventxformdataid='"+eventxformdataid+"'");
            //-----------------------------------
            //-----------------------------------
        } else {
            //Insert
            //-----------------------------------
            //-----------------------------------
            eventxformdataid = Db.RunSQLInsert("INSERT INTO eventxformdata(eventid, xformdata) VALUES('"+eventid+"', '"+reger.core.Util.cleanForSQL(xformdata)+"')");
            //-----------------------------------
            //-----------------------------------
        }
    }

    public int getEventxformdataid() {
        return eventxformdataid;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public String getXformdata() {
        return xformdata;
    }

    public void setXformdata(String xformdata) {
        this.xformdata = xformdata;
    }
}
