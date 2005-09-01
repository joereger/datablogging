package reger.systemproperties;

import reger.core.db.Db;

/**
 * Holds Robots.txt Contents
 */
public class RobotsTxt {


    public static String robotstxt = "";
    public static boolean hasBeenLoadedFromDb = false;

    public static String getRobotstxt(){
        if (!hasBeenLoadedFromDb){
            load();
        }
        return robotstxt;
    }

    public static void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstRobot= Db.RunSQL("SELECT robotstxt FROM robotstxt ORDER BY robotstxtid DESC LIMIT 0,1");
        //-----------------------------------
        //-----------------------------------
        if (rstRobot!=null && rstRobot.length>0){
            robotstxt = rstRobot[0][0];
        }
    }

    public static void save(String robotstxt){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM robotstxt");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int identity = Db.RunSQLInsert("INSERT INTO robotstxt(robotstxt) VALUES('"+reger.core.Util.cleanForSQL(robotstxt)+"')");
        //-----------------------------------
        //-----------------------------------

        load();
    }


}
