package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version119ToVersion120 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){


            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE megalogtype ADD accountuserid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            String[][] rstLogType= Db.RunSQL("SELECT eventtypeid, accountid FROM megalogtype WHERE accountid>'0'");
            //-----------------------------------
            //-----------------------------------
            if (rstLogType!=null && rstLogType.length>0){
                for(int i=0; i<rstLogType.length; i++){
                    //-----------------------------------
                    //-----------------------------------
                    String[][] rstAcct= Db.RunSQL("SELECT accountuserid FROM accountuser WHERE accountid='"+rstLogType[i][1]+"'");
                    //-----------------------------------
                    //-----------------------------------
                    if (rstAcct!=null && rstAcct.length>0){
                        for(int j=0; j<rstAcct.length; j++){
                            //-----------------------------------
                            //-----------------------------------
                            int count2 = Db.RunSQLUpdate("UPDATE megalogtype SET accountuserid='"+rstAcct[j][0]+"' WHERE eventtypeid='"+rstLogType[i][0]+"'");
                            //-----------------------------------
                            //-----------------------------------
                        }
                    }
                }
            }
            //Drop the accountid
            //-----------------------------------
            //-----------------------------------
            int count3 = Db.RunSQLUpdate("ALTER TABLE megalogtype DROP accountid");
            //-----------------------------------
            //-----------------------------------



    }


}
