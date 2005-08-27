package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;


/**
 * This creates the base database if none exists.
 */
public class Version142ToVersion143 implements UpgradeDatabaseOneVersion{

    public void doUpgrade(){

        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("ALTER TABLE account ADD billingerror text");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count2 = Db.RunSQLUpdate("ALTER TABLE account ADD lastbillingcheck datetime");
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
                int count1 = Db.RunSQLUpdate("UPDATE account SET lastbillingcheck='"+reger.core.Util.cleanForSQL(reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.getRandomDateInPast(30)))+"' WHERE accountid='"+rstAcct[i][0]+"'");
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
