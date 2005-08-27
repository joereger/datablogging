package reger.dbversion;

import reger.core.db.Db;
import reger.core.PasswordHash;
import reger.UserSession;
import reger.mega.FieldType;
import reger.mega.Field;
import reger.mega.FieldLayout;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version99ToVersion100 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE megachart ADD accountid int(11) NOT NULL default '0'");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            String[][] rstMegachart= Db.RunSQL("SELECT megachartid, xlogid FROM megachart WHERE xlogid>'0'");
            //-----------------------------------
            //-----------------------------------
            if (rstMegachart!=null && rstMegachart.length>0){
                for(int i=0; i<rstMegachart.length; i++){
                    //-----------------------------------
                    //-----------------------------------
                    String[][] rstLog= Db.RunSQL("SELECT accountid FROM megalog WHERE logid='"+rstMegachart[i][1]+"'");
                    //-----------------------------------
                    //-----------------------------------
                    if (rstLog!=null && rstLog.length>0){
                        for(int j=0; j<rstLog.length; j++){
                            //-----------------------------------
                            //-----------------------------------
                            int count4 = Db.RunSQLUpdate("UPDATE megachart SET accountid='"+rstLog[j][0]+"' WHERE megachartid='"+rstMegachart[i][0]+"'");
                            //-----------------------------------
                            //-----------------------------------
                        }
                    }
                }
            }



    }




}
