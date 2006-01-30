package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;
import reger.core.Debug;
import reger.Log;

/**
 * This creates the base database if none exists.
 */
public class Version181ToVersion182 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){


        //This is an attempt to conserve the work of those who have customized (and used) fields on their logs

        //We're removing the capability to customize at the log level, for now at least

        //Will upgrade the log custom fields to eventtype fields
        //All customized fields in last 30 days
        //select megafield.megafieldid, megafield.fieldname, event.date, event.title, account.accounturl from megafield, megavalue, event, account, accountuser where megafield.megafieldid=megavalue.megafieldid AND megavalue.eventid=event.eventid AND megafield.logid>'0' AND event.accountid=account.accountid AND account.accountid=accountuser.accountid AND accountuser.lastlogindate>'2006-01-01 12:00:00' ORDER BY event.date DESC;
        //All those we'll keep
        //select DISTINCT megafield.megafieldid, megalog.logid from megafield, megavalue, event, account, accountuser, megalog where event.logid=megalog.logid AND megafield.megafieldid=megavalue.megafieldid AND megavalue.eventid=event.eventid AND megafield.logid>'0' AND event.accountid=account.accountid AND account.accountid=accountuser.accountid AND accountuser.lastlogindate>'2006-01-01 12:00:00' AND (accounturl='particleman' OR accounturl='hunter' OR accounturl='brentifer' OR accounturl='joelsef' OR accounturl='cannabisbratt' OR accounturl='misterp' or accounturl='anju') ORDER BY event.date DESC;

        StringBuffer debug = new StringBuffer();
        debug.append("<b>Converting Log-specific Fields to Log Type Fields</b><br>");

        //-----------------------------------
        //-----------------------------------
        String[][] rstData= Db.RunSQL("select DISTINCT megafield.megafieldid, megalog.logid FROM megafield, megavalue, event, account, accountuser, megalog where event.logid=megalog.logid AND megafield.megafieldid=megavalue.megafieldid AND megavalue.eventid=event.eventid AND megafield.logid>'0' AND event.accountid=account.accountid AND account.accountid=accountuser.accountid AND accountuser.lastlogindate>'2006-01-01 12:00:00' AND (accounturl='particleman' OR accounturl='hunter' OR accounturl='brentifer' OR accounturl='joelsef' OR accounturl='cannabisbratt' OR accounturl='misterp' or accounturl='anju') ORDER BY event.date DESC;");
        //-----------------------------------
        //-----------------------------------
        if (rstData!=null && rstData.length>0){
            for(int i=0; i<rstData.length; i++){
                int megafieldid = Integer.parseInt(rstData[i][0]);
                int logid = Integer.parseInt(rstData[i][1]);
                int eventtypeid = 0;

                //-----------------------------------
                //-----------------------------------
                String[][] rstType= Db.RunSQL("SELECT eventtypeid FROM megalog WHERE logid='"+logid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstType!=null && rstType.length>0){
                    eventtypeid = Integer.parseInt(rstType[0][0]);
                }

                //-----------------------------------
                //-----------------------------------
                int count = Db.RunSQLUpdate("UPDATE megafield SET eventtypeid='"+eventtypeid+"' WHERE megafieldid='"+megafieldid+"'");
                //-----------------------------------
                //-----------------------------------

                debug.append("<br>UPDATE megafield SET eventtypeid='"+eventtypeid+"' WHERE megafieldid='"+megafieldid+"'");

            }
        }

        //Save a record of what happened
        reger.core.Debug.logtodb(debug.toString(), "Version181ToVersion182.java");

    }

    //Sample sql statements

    //-----------------------------------
    //-----------------------------------
    //int count = Db.RunSQLUpdate("CREATE TABLE `pltemplate` (`pltemplateid` int(11) NOT NULL auto_increment, logid int(11), plid int(11), type int(11), templateid int(11), PRIMARY KEY  (`pltemplateid`)) ENGINE=MyISAM DEFAULT CHARSET=latin1;");
    //-----------------------------------
    //-----------------------------------

    //-----------------------------------
    //-----------------------------------
    //int count = Db.RunSQLUpdate("ALTER TABLE megachart CHANGE daterangesavedsearchid daterangesavedsearchid int(11) NOT NULL default '0'");
    //-----------------------------------
    //-----------------------------------

    //-----------------------------------
    //-----------------------------------
    //int count = Db.RunSQLUpdate("ALTER TABLE account DROP gps");
    //-----------------------------------
    //-----------------------------------

    //-----------------------------------
    //-----------------------------------
    //int count = Db.RunSQLUpdate("ALTER TABLE megalogtype ADD isprivate int(11) NOT NULL default '0'");
    //-----------------------------------
    //-----------------------------------

    //-----------------------------------
    //-----------------------------------
    //int count = Db.RunSQLUpdate("DROP TABLE megafielduser");
    //-----------------------------------
    //-----------------------------------

    //-----------------------------------
    //-----------------------------------
    //int count = Db.RunSQLUpdate("CREATE INDEX name_of_index ON table (field1, field2)");
    //-----------------------------------
    //-----------------------------------


}
