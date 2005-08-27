package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version13ToVersion14 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE account ADD accounturl varchar(255) default NULL");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            String[][] rstAcc= Db.RunSQL("SELECT accountid, servername FROM account");
            //-----------------------------------
            //-----------------------------------
            if (rstAcc!=null && rstAcc.length>0){
            	for(int i=0; i<rstAcc.length; i++){
                    String incomingServername = rstAcc[i][1];
                    String accounturl = "";
                    String[] splitSn = incomingServername.split("\\.");
                    if (splitSn.length>0){
                        accounturl = splitSn[0];
                    }

                    //-----------------------------------
                    //-----------------------------------
                    int count2 = Db.RunSQLUpdate("UPDATE account SET accounturl='"+reger.core.Util.cleanForSQL(accounturl)+"' WHERE accountid='"+rstAcc[i][0]+"'");
                    //-----------------------------------
                    //-----------------------------------

            	}
            }



            //-----------------------------------
            //-----------------------------------
            int count4 = Db.RunSQLUpdate("ALTER TABLE account DROP servername");
            //-----------------------------------
            //-----------------------------------


    }


}
