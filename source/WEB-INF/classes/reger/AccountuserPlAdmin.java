package reger;

import reger.core.db.Db;

import java.util.Calendar;

/**
 * A system message appears to all users at once.  It is
 * memory-based and will dissappear the next time the server is restarted.
 */
public class AccountuserPlAdmin {

    private int accountuserpladminid = 0;
    private int plid = 0;
    private int accountuserid = 0;


    public AccountuserPlAdmin(int accountuserpladminid){
        this.accountuserpladminid = accountuserpladminid;
        load();
    }

    public AccountuserPlAdmin(int plid, int accountuserid){
        this.plid = plid;
        this.accountuserid = accountuserid;
    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData = Db.RunSQL("SELECT accountuserpladminid, plid, accountuserid FROM accountuserpladmin WHERE accountuserpladminid='"+accountuserpladminid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData !=null && rstData.length>0){
            this.accountuserpladminid = Integer.parseInt(rstData[0][0]);
            this.plid = Integer.parseInt(rstData[0][1]);
            this.accountuserid = Integer.parseInt(rstData[0][2]);
        }
    }

    public void save(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstMessage= Db.RunSQL("SELECT accountuserpladminid FROM accountuserpladmin WHERE accountuserpladminid='"+accountuserpladminid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstMessage!=null && rstMessage.length>0){
            //Update
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE accountuserpladmin SET plid='"+plid+"', accountuserid='"+accountuserid+"' WHERE accountuserpladminid='"+accountuserpladminid+"'");
            //-----------------------------------
            //-----------------------------------
        } else {
            //Insert
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO accountuserpladmin(plid, accountuserid) VALUES('"+plid+"', '"+accountuserid+"')");
            //-----------------------------------
            //-----------------------------------
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM accountuserpladmin WHERE accountuserpladminid='"+accountuserpladminid+"'");
        //-----------------------------------
        //-----------------------------------
    }

    public int getAccountuserpladminid() {
        return accountuserpladminid;
    }

    public int getPlid() {
        return plid;
    }

    public void setPlid(int plid) {
        this.plid = plid;
    }

    public int getAccountuserid() {
        return accountuserid;
    }

    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }

}
