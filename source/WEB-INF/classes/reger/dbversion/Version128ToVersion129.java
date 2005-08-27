package reger.dbversion;

import reger.core.db.Db;
import reger.Location;
import reger.core.db.Db;
import reger.core.dbupgrade.UpgradeDatabaseOneVersion;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * This creates the base database if none exists.
 */
public class Version128ToVersion129 implements UpgradeDatabaseOneVersion{



    public void doUpgrade(){




            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("ALTER TABLE location ADD latitude double default NULL");
            //-----------------------------------
            //-----------------------------------

            //-----------------------------------
            //-----------------------------------
            int count2 = Db.RunSQLUpdate("ALTER TABLE location ADD longitude double default NULL");
            //-----------------------------------
            //-----------------------------------

            //Convert existing locations to decimal
            //-----------------------------------
            //-----------------------------------
            String[][] rstLoc= Db.RunSQL("SELECT locationid, latdeg, latmin, latsec, londeg, lonsec, lonew FROM location");
            //-----------------------------------
            //-----------------------------------
            if (rstLoc!=null && rstLoc.length>0){
                for(int i=0; i<rstLoc.length; i++){
                    int latdeg=0;
                    if (reger.core.Util.isinteger(rstLoc[i][1])){
                        latdeg=Integer.parseInt(rstLoc[i][1]);
                    }
                    int latmin=0;
                    if (reger.core.Util.isinteger(rstLoc[i][2])){
                        latmin=Integer.parseInt(rstLoc[i][2]);
                    }
                    int latsec=0;
                    if (reger.core.Util.isinteger(rstLoc[i][3])){
                        latsec=Integer.parseInt(rstLoc[i][3]);
                    }
                    int londeg = 0;
                    if (reger.core.Util.isinteger(rstLoc[i][4])){
                        londeg=Integer.parseInt(rstLoc[i][4]);
                    }
                    int lonmin=0;
                    if (reger.core.Util.isinteger(rstLoc[i][5])){
                        lonmin=Integer.parseInt(rstLoc[i][5]);
                    }
                    int lonsec=0;
                    if (reger.core.Util.isinteger(rstLoc[i][6])){
                        lonsec=Integer.parseInt(rstLoc[i][6]);
                    }

                    if (latdeg!=0 || latmin!=0 || latsec!=0 || londeg!=0 || lonmin!=0 || lonsec!=0){
                        float latitude = convertDegMinSecToDecimal(latdeg, latmin, latsec);
                        float longitude = (-1) * convertDegMinSecToDecimal(londeg, lonmin, lonsec);
                        //-----------------------------------
                        //-----------------------------------
                        int count3 = Db.RunSQLUpdate("UPDATE location SET latitude='"+String.valueOf(latitude)+"', longitude='"+String.valueOf(longitude)+"' WHERE locationid='"+rstLoc[i][0]+"'");
                        //-----------------------------------
                        //-----------------------------------
                    }



                }
            }




    }

    private static float convertDegMinSecToDecimal(int degrees, int minutes, int seconds){
        float minasdeg = ((float)minutes)/(60);
        float secasdeg = ((float)seconds)/(60*60);
        return degrees + minasdeg + secasdeg;
    }


}
