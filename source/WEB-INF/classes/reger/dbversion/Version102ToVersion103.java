package reger.dbversion;

import reger.core.db.Db;
import reger.core.PasswordHash;
import reger.UserSession;
import reger.core.db.Db;
import reger.mega.FieldType;
import reger.mega.Field;
import reger.mega.FieldLayout;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version102ToVersion103 implements UpgradeDatabaseOneVersion{


    public void doUpgrade(){


            //-----------------------------------
            //-----------------------------------
            String[][] rstMegachartYAxis= Db.RunSQL("SELECT megachartyaxisid, megachartid, ymegafieldid FROM megachartyaxis");
            //-----------------------------------
            //-----------------------------------
            if (rstMegachartYAxis!=null && rstMegachartYAxis.length>0){
                for(int i=0; i<rstMegachartYAxis.length; i++){
                    //-----------------------------------
                    //-----------------------------------
                    String[][] rstField= Db.RunSQL("SELECT eventtypeid, logid FROM megafield WHERE megafieldid='"+rstMegachartYAxis[i][2]+"'");
                    //-----------------------------------
                    //-----------------------------------
                    if (rstField!=null && rstField.length>0){
                        for(int j=0; j<rstField.length; j++){
                            //-----------------------------------
                            //-----------------------------------
                            int count = Db.RunSQLUpdate("UPDATE megachartyaxis SET yeventtypeid='"+rstField[j][0]+"' WHERE megachartyaxisid='"+rstMegachartYAxis[i][0]+"'");
                            //-----------------------------------
                            //-----------------------------------
                        }
                    }
                }
            }



    }




}
