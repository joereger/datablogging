package reger;

import reger.core.db.Db;

/**
 * Tracks bandwidth usage
 */
public class Bandwidth {


    public Bandwidth(){

    }

    public static void addActivity(reger.UserSession userSession, int bytes){
        if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0){
            addActivity(userSession.getAccount().getAccountid(), bytes);
        } else {
            addActivity(0, bytes);
        }
    }

    public static void addActivity(int accountid, int bytes){

        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE bandwidth SET bytes=bytes+"+bytes+" WHERE accountid='"+accountid+"' AND month=Month(Now()) AND year=Year(Now())");
        //-----------------------------------
        //-----------------------------------

        if (count<1){
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO bandwidth(accountid, month, year, bytes) VALUES('"+accountid+"', Month(Now()), Year(Now()), '"+bytes+"')");
            //-----------------------------------
            //-----------------------------------
        }

    }

    public static int getBytesUsed(int accountid, int month, int year){

        //-----------------------------------
        //-----------------------------------
        String[][] rstBytes= Db.RunSQL("SELECT bytes FROM bandwidth WHERE accountid='"+accountid+"' AND month='"+month+"' AND year='"+year+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstBytes!=null && rstBytes.length>0){
        	return Integer.parseInt(rstBytes[0][0]);
        }

        return 0;
    }

    public static long getBytesUsedThisMonth(int accountid){

        //-----------------------------------
        //-----------------------------------
        String[][] rstBytes= Db.RunSQL("SELECT bytes FROM bandwidth WHERE accountid='"+accountid+"' AND month=Month(Now()) AND year=Year(Now())");
        //-----------------------------------
        //-----------------------------------
        if (rstBytes!=null && rstBytes.length>0){
        	return Long.parseLong(rstBytes[0][0]);
        }

        return 0;
    }


}
