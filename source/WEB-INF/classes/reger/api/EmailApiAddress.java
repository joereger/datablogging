package reger.api;

import reger.core.db.Db;

/**
 * This class represents a single unique emailApi address
 */
public class EmailApiAddress {

    private int emailapiaddressid = 0;
    private String uniquekey;
    private int accountuserid;
    private int accountid;
    private int logid;
    private int emailtype;

    public EmailApiAddress(int emailapiaddressid){
        this.emailapiaddressid = emailapiaddressid;
        refresh();
    }

    public EmailApiAddress(String uniquekey, int accountuserid, int accountid, int logid, int emailtype){
        this.uniquekey = uniquekey;
        this.accountuserid = accountuserid;
        this.accountid = accountid;
        this.logid = logid;
        this.emailtype = emailtype;
    }

    public EmailApiAddress(EmailApiAddress e){
        this.emailapiaddressid = e.emailapiaddressid;
        this.uniquekey = e.uniquekey;
        this.accountuserid = e.accountuserid;
        this.accountid = e.accountid;
        this.logid = e.logid;
        this.emailtype = e.emailtype;
    }

    public EmailApiAddress(String uniquekey){
        //-----------------------------------
        //-----------------------------------
        String[][] rstEm= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE uniquekey='"+reger.core.Util.cleanForSQL(uniquekey)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstEm!=null && rstEm.length>0){
            for(int i=0; i<rstEm.length; i++){
                this.emailapiaddressid = Integer.parseInt(rstEm[i][0]);
                refresh();
            }
        }
    }

    public EmailApiAddress(int accountuserid, int accountid, int logid, int emailtype){
        this.accountuserid = accountuserid;
        this.accountid = accountid;
        this.logid = logid;
        this.emailtype = emailtype;
        //-----------------------------------
        //-----------------------------------
        String[][] rstEm= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE accountuserid='"+accountuserid+"' AND accountid='"+accountid+"' AND logid='"+logid+"' AND emailtype='"+emailtype+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstEm!=null && rstEm.length>0){
            for(int i=0; i<rstEm.length; i++){
                this.emailapiaddressid = Integer.parseInt(rstEm[i][0]);
                refresh();
            }
        } else {
            //Generate a key
            this.uniquekey = generateUniqueKey();
            save();
        }
    }


    public void refresh(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstEm= Db.RunSQL("SELECT emailapiaddressid, uniquekey, accountuserid, accountid, logid, emailtype FROM emailapiaddress WHERE emailapiaddressid='"+emailapiaddressid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstEm!=null && rstEm.length>0){
            for(int i=0; i<rstEm.length; i++){
                this.emailapiaddressid = Integer.parseInt(rstEm[i][0]);
                this.uniquekey = rstEm[i][1];
                this.accountuserid = Integer.parseInt(rstEm[i][2]);
                this.accountid = Integer.parseInt(rstEm[i][3]);
                this.logid = Integer.parseInt(rstEm[i][4]);
                this.emailtype = Integer.parseInt(rstEm[i][5]);
            }
        }
    }

    public void save(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstEm= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE accountuserid='"+accountuserid+"' AND accountid='"+accountid+"' AND logid='"+logid+"' AND emailtype='"+emailtype+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstEm!=null && rstEm.length>0){
            for(int i=0; i<rstEm.length; i++){
                //-----------------------------------
                //-----------------------------------
                int count = Db.RunSQLUpdate("UPDATE emailapiaddress SET uniquekey='"+reger.core.Util.cleanForSQL(uniquekey)+"' WHERE emailapiaddressid='"+rstEm[i][0]+"'");
                //-----------------------------------
                //-----------------------------------
            }
        } else {
            //-----------------------------------
            //-----------------------------------
            emailapiaddressid = Db.RunSQLInsert("INSERT INTO emailapiaddress(uniquekey, accountuserid, accountid, logid, emailtype) VALUES('"+reger.core.Util.cleanForSQL(uniquekey)+"', '"+accountuserid+"', '"+accountid+"', '"+logid+"', '"+emailtype+"')");
            //-----------------------------------
            //-----------------------------------


        }
    }

    public int getEmailapiaddressid() {
        return emailapiaddressid;
    }


    public String getUniquekey() {
        return uniquekey;
    }


    public int getAccountuserid() {
        return accountuserid;
    }


    public int getAccountid() {
        return accountid;
    }



    public int getLogid() {
        return logid;
    }



    public int getEmailtype() {
        return emailtype;
    }


    private String generateUniqueKey(){
        String uniqueKey = "";
        boolean foundUniqueKey = false;
        while (!foundUniqueKey){
            //Generate a possible unique key
            uniqueKey = reger.core.RandomString.randomAlphanumeric(7).toLowerCase();
            //See if it exists in the database
            //-----------------------------------
            //-----------------------------------
            String[][] rstKey= Db.RunSQL("SELECT emailapiaddressid FROM emailapiaddress WHERE uniquekey='"+reger.core.Util.cleanForSQL(uniqueKey)+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstKey!=null && rstKey.length>0){
                //We don't have a unique key
            } else {
                //We do have a unique one
                foundUniqueKey = true;
            }
        }
        return uniqueKey;
    }

}
