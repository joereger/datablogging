package reger.groups;

import reger.core.db.Db;

/**
 * Represents a single event to group relationship
 */
public class EventToGroup {

    private int eventtogroupid = 0;
    private int eventid = 0;
    private int groupid = 0;



    public EventToGroup (int eventtogroupid){
        this.eventtogroupid = eventtogroupid;
        load();
    }

    public EventToGroup(){
        
    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtogroupid, eventid, groupid FROM eventtogroup WHERE eventtogroupid='"+eventtogroupid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            eventtogroupid = Integer.parseInt(rstData[0][0]);
            eventid = Integer.parseInt(rstData[0][1]);
            groupid = Integer.parseInt(rstData[0][2]);
        }
    }
    
    public void save(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT eventtogroupid FROM eventtogroup WHERE eventtogroupid='"+eventtogroupid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE eventtogroup SET eventid='"+eventid+"', groupid='"+groupid+"' WHERE eventtogroupid='"+eventtogroupid+"'");
            //-----------------------------------
            //-----------------------------------    
        } else {
            //-----------------------------------
            //-----------------------------------
            groupid = Db.RunSQLInsert("INSERT INTO eventtogroup(eventid, groupid) VALUES('"+eventid+"', '"+groupid+"')");
            //-----------------------------------
            //-----------------------------------    
        }
    }
    
    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM eventtogroup WHERE eventtogroupid='"+eventtogroupid+"'");
        //-----------------------------------
        //-----------------------------------
    }

    public int getEventtogroupid() {
        return eventtogroupid;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

}
