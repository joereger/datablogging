package reger.dbversion;

import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version125ToVersion126 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){



            //-----------------------------------
            //-----------------------------------
            String[][] rstLogType= Db.RunSQL("SELECT eventtypeid FROM megalogtype");
            //-----------------------------------
            //-----------------------------------
            if (rstLogType!=null && rstLogType.length>0){
                for(int i=0; i<rstLogType.length; i++){

                    //Build the hiddenfields string
                    StringBuffer hiddenfields = new StringBuffer();
                    //-----------------------------------
                    //-----------------------------------
                    String[][] rstField= Db.RunSQL("SELECT megafieldid FROM megafield WHERE eventtypeid='"+rstLogType[i][0]+"' AND isvisible='0'");
                    //-----------------------------------
                    //-----------------------------------
                    if (rstField!=null && rstField.length>0){
                        for(int j=0; j<rstField.length; j++){
                            hiddenfields.append(rstField[j][0]);
                            if (i<(rstField.length-1)){
                                hiddenfields.append("|");
                            }
                        }
                    }

                    //Save the hiddenfields string with the megalogtype
                    if (!hiddenfields.toString().equals("")){
                        //-----------------------------------
                        //-----------------------------------
                        int count = Db.RunSQLUpdate("UPDATE megalogtype SET hiddenfields='"+hiddenfields.toString()+"' WHERE eventtypeid='"+rstLogType[i][0]+"'");
                        //-----------------------------------
                        //-----------------------------------
                    }

                }
            }

            




    }


}
