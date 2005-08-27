package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version22ToVersion23 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE accountuseracl ADD accountid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE accountuseraclgroup ADD accountid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //Populate accountuseracl.accountid and accountuseraclgroup.accountid
            //-----------------------------------
            //-----------------------------------
            String[][] rstAccountuser= Db.RunSQL("SELECT accountuserid, accountid FROM accountuser");
            //-----------------------------------
            //-----------------------------------
            if (rstAccountuser!=null && rstAccountuser.length>0){
                for(int i=0; i<rstAccountuser.length; i++){
                    //-----------------------------------
                    //-----------------------------------
                    int count3 = Db.RunSQLUpdate("UPDATE accountuseracl SET accountid='"+rstAccountuser[i][1]+"' WHERE accountuserid='"+rstAccountuser[i][0]+"'");
                    //-----------------------------------
                    //-----------------------------------

                    //-----------------------------------
                    //-----------------------------------
                    int count4 = Db.RunSQLUpdate("UPDATE accountuseraclgroup SET accountid='"+rstAccountuser[i][1]+"' WHERE accountuserid='"+rstAccountuser[i][0]+"'");
                    //-----------------------------------
                    //-----------------------------------
                }
            }




    }


}
