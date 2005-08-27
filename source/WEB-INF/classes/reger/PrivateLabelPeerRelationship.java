package reger;

import reger.core.db.Db;

/**
 * A peer is a private label that is trusted and user data is shared across.
 */
public class PrivateLabelPeerRelationship {

    private int plpeerid=0;
    private int plid=0;
    private int peerplid=0;


    public PrivateLabelPeerRelationship(int plpeerid){
        this.plpeerid=plpeerid;
        load();
    }

    public PrivateLabelPeerRelationship(int plid, int peerplid){
        this.plid=plid;
        this.peerplid=peerplid;
    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstPlPeer= Db.RunSQL("SELECT plid, peerplid FROM plpeer WHERE plpeerid='"+plpeerid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstPlPeer!=null && rstPlPeer.length>0){
            this.plid = Integer.parseInt(rstPlPeer[0][0]);
            this.peerplid = Integer.parseInt(rstPlPeer[0][1]);
        }
    }

    public void save(){

        //-----------------------------------
        //-----------------------------------
        String[][] rstPl= Db.RunSQL("SELECT plid FROM pl WHERE plid='"+peerplid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstPl==null || rstPl.length<=0){
            return;
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstPl2= Db.RunSQL("SELECT plid FROM pl WHERE plid='"+plid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstPl2==null || rstPl2.length<=0){
            return;
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstPeer= Db.RunSQL("SELECT plpeerid FROM plpeer WHERE plpeerid='"+plpeerid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstPeer!=null && rstPeer.length>0){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE plpeer SET plid='"+plid+"', peerplid='"+peerplid+"' WHERE plpeerid='"+plpeerid+"'");
            //-----------------------------------
            //-----------------------------------
        } else {
            //-----------------------------------
            //-----------------------------------
            plpeerid = Db.RunSQLInsert("INSERT INTO plpeer(plid, peerplid) VALUES('"+plid+"', '"+peerplid+"')");
            //-----------------------------------
            //-----------------------------------
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM plpeer WHERE plpeerid='"+plpeerid+"'");
        //-----------------------------------
        //-----------------------------------
    }

    public int getPlpeerid() {
        return plpeerid;
    }

    public void setPlpeerid(int plpeerid) {
        this.plpeerid = plpeerid;
    }

    public int getPlid() {
        return plid;
    }

    public void setPlid(int plid) {
        this.plid = plid;
    }

    public int getPeerplid() {
        return peerplid;
    }

    public void setPeerplid(int peerplid) {
        this.peerplid = peerplid;
    }

}
