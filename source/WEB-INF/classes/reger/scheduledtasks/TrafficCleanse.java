package reger.scheduledtasks;

import reger.core.db.Db;
import reger.core.scheduler.ScheduledTask;
import reger.core.Debug;


/**
 * Cleans up traffic table by collapsing it
 */
public class TrafficCleanse implements ScheduledTask{


    private String result = "";

    public String getTaskName() {
        return "Traffic Cleanse";
    }

    public int getRunEveryXMinutes() {
        return 60;
    }

    public boolean getOnlyRunOnceAtStartup() {
        return false;
    }

    public String getResult() {
        return result;
    }



    public void doTask() {
        try{

            //@todo Write all traffic records older than 7 days to an xml flatfile or to an archive table in the database.  Or not.  I just know that losing people's data, while my legal right, will really piss them off.

            //Get the cutoff time to collapse traffic
            java.util.Calendar now = java.util.Calendar.getInstance();
            String sixtyDaysAgo=reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xDaysAgoStart(now, 8));

            //How many records should the database return each time?
            int numberperbatch = 1000;

            //Just so that we get into the loop at least once
            int numberofrecords=9999;

            //Counter
            int myCount = 0;
            int myLapper = 0;

            //Because users will be adding traffic records while this thread is cleaning them up, we loop on the counter until we're at less than 1000 records.  They'll get caught in the next batch.
            //I don't set this to 0 because in a production site it may be infeasible to actually get the numberofrecords to zero with users hitting it all the time.
            //The other advantage of doing it this way is that I don't hit the memory limits of Java by loading the entire contents of the traffic table into a big array (which would be ugly).
            while(numberofrecords>1000){

                //This finds the number of traffic records ready for collapse
                //-----------------------------------
                //-----------------------------------
                String[][] rstCounter= Db.RunSQL("SELECT count(*) FROM traffic WHERE datetime<'"+ sixtyDaysAgo +"' AND iscollapsed='0'");
                //-----------------------------------
                //-----------------------------------
                if (rstCounter!=null && rstCounter.length>0 && reger.core.Util.isinteger(rstCounter[0][0])){
                    numberofrecords=Integer.parseInt(rstCounter[0][0]);
                } else {
                    numberofrecords=1;
                }

                //Select records older than 8 days but only some
                //-----------------------------------
                //-----------------------------------
                String[][] rstMd= Db.RunSQL("SELECT datetime, traffictypeid, plid, accountid, logid, eventid, imageid, trafficid, count FROM traffic WHERE datetime<'"+ sixtyDaysAgo +"' AND iscollapsed='0' LIMIT 0,"+numberperbatch);
                //-----------------------------------
                //-----------------------------------
                if (rstMd!=null && rstMd.length>0){
                    for(int i=0; i<rstMd.length; i++){

                        //Updater
                        myCount = myCount + 1;
                        myLapper = myLapper + 1;
                        if (myLapper>=1000){
                            myLapper = 0;
                            reger.core.scheduler.MasterThread.updateTask("Traffic Cleanse Manual", "<font face=arial size=-1>Processing Traffic Records</font><br><font face=arial size=-2>"+myCount+" processed.<br>"+numberofrecords+" remaining.</font>", 9999);
                        }

                        //Get the count for the current record
                        int count = 1;
                        try {
                            count = Integer.parseInt(rstMd[i][8]);
                        } catch (Exception e){
                            //Do nothing
                        }

                        //Put the dbstring into a calendar
                        //java.Util.Calendar tmpCal =reger.core.TimeUtils.dbstringtocalendar(rstMd[i][0]);
                        //Set the calendar time to 00:00:00
                        //tmpCal=reger.core.TimeUtils.minTime(tmpCal);
                        //Convert back to a string
                        //String collapseddatetime=reger.core.TimeUtils.dateformatfordb(tmpCal);

                        //Hard-code all traffic older than 8 days to 1/1/2000
                        String collapseddatetime = "2000-01-01 00:00:00";

                        //Attempt to update a proper record
                        //-----------------------------------
                        //-----------------------------------
                        int countUpdate = Db.RunSQLUpdate("UPDATE traffic SET count=count+"+count+" WHERE trafficid<>'"+rstMd[i][7]+"' AND traffictypeid='"+ rstMd[i][1] +"' AND datetime='"+ collapseddatetime +"' AND plid='"+ rstMd[i][2] +"' AND accountid='"+ rstMd[i][3] +"' AND logid='"+ rstMd[i][4] +"' AND eventid='"+ rstMd[i][5] +"' AND imageid='"+ rstMd[i][6] +"' AND iscollapsed='1'");
                        //-----------------------------------
                        //-----------------------------------

                        if (countUpdate==0) {
                            //If no record exists with that uniqueness, create one
                            //-----------------------------------
                            //-----------------------------------
                            int identity = Db.RunSQLInsert("INSERT INTO traffic(count, traffictypeid, datetime, plid, accountid, logid, eventid, imageid, referrer, browser, remotehost, iscollapsed) VALUES('"+count+"', '"+ rstMd[i][1] +"', '"+ collapseddatetime +"', '"+ rstMd[i][2] +"', '"+ rstMd[i][3] +"', '"+ rstMd[i][4] +"', '"+ rstMd[i][5] +"', '"+ rstMd[i][6] +"', '', '', '', '1')");
                            //-----------------------------------
                            //-----------------------------------
                        }

                        //Now delete the record that was just processed
                        //-----------------------------------
                        //-----------------------------------
                        int countDeleted = Db.RunSQLUpdate("DELETE FROM traffic WHERE trafficid='"+ rstMd[i][7] +"'");
                        //-----------------------------------
                        //-----------------------------------

                    }
                }
            }

        } catch (Exception e){
            Debug.errorsave(e, "");
            result = "Error.  See event log for details.";
        }

        result = "Done.";
    }


}
