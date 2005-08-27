package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;


/**
 * This creates the base database if none exists.
 */
public class Version141ToVersion142 implements UpgradeDatabaseOneVersion{

    public void doUpgrade(){

        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("ALTER TABLE account ADD isbillingokencrypted varchar(255) NOT NULL default '0'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        String[][] rstAcct= Db.RunSQL("SELECT accountid FROM account", 500000);
        //-----------------------------------
        //-----------------------------------
        if (rstAcct!=null && rstAcct.length>0){
            for(int i=0; i<rstAcct.length; i++){
                //-----------------------------------
                //-----------------------------------
                int count1 = Db.RunSQLUpdate("UPDATE account SET isbillingokencrypted='"+reger.core.Util.cleanForSQL(reger.IsBillingOk.getIsbillingokString(true, Integer.parseInt(rstAcct[i][0])))+"' WHERE accountid='"+rstAcct[i][0]+"'");
                //-----------------------------------
                //-----------------------------------
            }
        }

    }

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
