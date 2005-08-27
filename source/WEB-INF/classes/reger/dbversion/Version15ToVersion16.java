package reger.dbversion;

import reger.core.db.Db;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version15ToVersion16 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE pl ADD plhost varchar(255) default NULL");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            String[][] rstAcc= Db.RunSQL("SELECT plid, servername FROM pl");
            //-----------------------------------
            //-----------------------------------
            if (rstAcc!=null && rstAcc.length>0){
            	for(int i=0; i<rstAcc.length; i++){
                    String servername = rstAcc[i][1];
                    String plhost = "";

                    if (!servername.equals("")){
                        String[] splitSn = servername.split("\\.");
                        if (splitSn.length>0){
                            plhost = splitSn[0];
                        }
                    }
                    

                    //-----------------------------------
                    //-----------------------------------
                    int count2 = Db.RunSQLUpdate("UPDATE pl SET plhost='"+reger.core.Util.cleanForSQL(plhost)+"' WHERE plid='"+rstAcc[i][0]+"'");
                    //-----------------------------------
                    //-----------------------------------

            	}
            }

            //-----------------------------------
            //-----------------------------------
            int count3 = Db.RunSQLUpdate("ALTER TABLE pl DROP servername");
            //-----------------------------------
            //-----------------------------------


    }


}
