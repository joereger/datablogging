package reger.files;

import reger.core.db.Db;

/**
 * File ACL DAO
 */
public class FileAcl {

    private int fileaclid = 0;
    private int accountuserid = 0;
    private String pathandorfilename = "";
    private int accountid = 0;


    public FileAcl (int fileaclid){
        this.fileaclid = fileaclid;
        load();
    }

    public FileAcl(){

    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT fileaclid, accountuserid, pathandorfilename, accountid FROM fileacl WHERE fileaclid='"+fileaclid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            fileaclid = Integer.parseInt(rstData[0][0]);
            accountuserid = Integer.parseInt(rstData[0][1]);
            pathandorfilename = rstData[0][2];
            accountid = Integer.parseInt(rstData[0][3]);
        }
    }

    public void save(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("SELECT fileaclid FROM fileacl WHERE fileaclid='"+fileaclid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE fileacl SET accountuserid='"+accountuserid +"', pathandorfilename='"+reger.core.Util.cleanForSQL(pathandorfilename) +"', accountid='"+accountid+"' WHERE fileaclid='"+fileaclid +"'");
            //-----------------------------------
            //-----------------------------------
        } else {
            //-----------------------------------
            //-----------------------------------
            fileaclid = Db.RunSQLInsert("INSERT INTO fileacl(accountuserid, pathandorfilename, accountid) VALUES('"+accountuserid +"', '"+reger.core.Util.cleanForSQL(pathandorfilename) +"', '"+accountid+"')");
            //-----------------------------------
            //-----------------------------------
        }
    }

    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM fileacl WHERE fileaclid='"+fileaclid +"'");
        //-----------------------------------
        //-----------------------------------
    }

    public int getFileaclid() {
        return fileaclid;
    }

    public int getAccountuserid() {
        return accountuserid;
    }

    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }

    public String getPathandorfilename() {
        return pathandorfilename;
    }

    public void setPathandorfilename(String pathandorfilename) {
        this.pathandorfilename = pathandorfilename;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }


}
