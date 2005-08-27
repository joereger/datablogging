package reger;

import reger.core.db.Db;

/**
 * This object represents a field that an accountuser adds to their profile
 */
public class Accountuserfield {

    public int accountuserfieldid=-1;
    public String fieldtitle="";
    public String fielddata="";
    public int order = 0;
    public int accountuserid=-1;

    public Accountuserfield(int accountuserfieldid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstAcUField= Db.RunSQL("SELECT fieldtitle, fielddata, accountuserfield.order, accountuserid FROM accountuserfield WHERE accountuserfieldid='"+accountuserfieldid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstAcUField!=null && rstAcUField.length>0){
        	this.fieldtitle = rstAcUField[0][0];
        	this.fielddata = rstAcUField[0][1];
        	this.accountuserfieldid=accountuserfieldid;
        	this.order = Integer.parseInt(rstAcUField[0][2]);
        	this.accountuserid = Integer.parseInt(rstAcUField[0][3]);
        }
    }

    public Accountuserfield(int accountuserfieldid, String fieldtitle, String fielddata, int order){
        this.fieldtitle = fieldtitle;
        this.fielddata = fielddata;
        this.accountuserfieldid=accountuserfieldid;
        this.order = order;
    }

    public Accountuserfield(int accountuserfieldid, String fieldtitle, String fielddata, int order, int accountuserid){
        this.fieldtitle = fieldtitle;
        this.fielddata = fielddata;
        this.accountuserfieldid=accountuserfieldid;
        this.order = order;
        this.accountuserid=accountuserid;
    }

    public boolean saveFieldToDatabase(int accountuserid){
        if (!fieldtitle.equals("") && accountuserfieldid==-1){
            //@todo Get correct order for field.
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO accountuserfield(accountuserid, fieldtitle, fielddata, accountuserfield.order) VALUES('"+accountuserid+"', '"+reger.core.Util.cleanForSQL(fieldtitle)+"', '"+reger.core.Util.cleanForSQL(fielddata)+"', '"+order+"')");
            //-----------------------------------
            //-----------------------------------
            this.accountuserfieldid = identity;
            return true;
        } else {
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE accountuserfield SET accountuserid='"+accountuserid+"', fieldtitle='"+reger.core.Util.cleanForSQL(fieldtitle)+"', fielddata='"+reger.core.Util.cleanForSQL(fielddata)+"', accountuserfield.order='"+order+"' WHERE accountuserfieldid='"+accountuserfieldid+"'");
            //-----------------------------------
            //-----------------------------------
        }
        return false;
    }

    public void deleteThisField(reger.UserSession userSession){
        //Only the user themselves can delete a field
        if (userSession.getAccountuser().getAccountuserid()==accountuserid){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("DELETE FROM accountuserfield WHERE accountuserfieldid='"+accountuserfieldid+"'");
            //-----------------------------------
            //-----------------------------------
        }   
    }

}
