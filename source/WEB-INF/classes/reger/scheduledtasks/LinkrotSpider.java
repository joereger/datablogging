package reger.scheduledtasks;

import reger.core.db.Db;
import reger.core.scheduler.ScheduledTask;
import reger.core.Debug;
import reger.linkrot.Util;
import reger.threadpool.ThreadPool;

import java.util.Calendar;

/**
 *
 */
public class LinkrotSpider implements ScheduledTask{


    private String result = "";

    public String getTaskName() {
        return "Linkrot Spider";
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


    public void doTask(){
        if (reger.systemproperties.AllSystemProperties.getProp("ISLINKROTFIXERON").equals("1")){
            //Record number of processed URLs
            int urlsProcessed = 0;

            //Number of records to get at a time
            int numbertoget = 5000;

            //Starting point
            int startrecord = 0;

            //AgoSql
            int daysAgo = 30;
            int hoursAgo = daysAgo * 24;
            int minutesAgo = hoursAgo * 60;
            Calendar tmpDate = reger.core.TimeUtils.nowInGmtCalendar();
            tmpDate = reger.core.TimeUtils.xMinutesAgoStart(tmpDate, minutesAgo);
            String agoSql = " lastcheckeddate<'"+reger.core.TimeUtils.dateformatfordb(tmpDate)+"' ";

            //Get count of entries
            int count = 0;
            //-----------------------------------
            //-----------------------------------
            String[][] rstCount= Db.RunSQL("SELECT count(*) FROM linkrot WHERE " + agoSql);
            //-----------------------------------
            //-----------------------------------
            if (rstCount!=null && rstCount.length>0){
                count = Integer.parseInt(rstCount[0][0]);
            }

            //Counting int
            int i = 0;

            //Create the ThreadPool
            ThreadPool pool = new ThreadPool(20);

            //Have to process events in chunks to avoid overwhelming memory
            while((i*numbertoget)<=(count)){
                //Set the starting record to get
                startrecord = i*numbertoget;

                Debug.debug(5, "", "Starting new batch of linkrot searches: i=" + i + "<br>count=" + count + "<br>numbertoget=" + numbertoget);

                //Now increment the counting int
                i=i+1;

                //Parse entries and store links in the database
                //-----------------------------------
                //-----------------------------------
                String[][] rstEvent= Db.RunSQL("SELECT url FROM linkrot WHERE "+agoSql+" ORDER BY url ASC LIMIT "+startrecord+", "+numbertoget+"", numbertoget);
                //-----------------------------------
                //-----------------------------------
                if (rstEvent!=null && rstEvent.length>0){
                    for(int j=0; j<rstEvent.length; j++){

                        Debug.debug(5, "", "++++++++++++++++<br>++++++++++++++++<br>++++++++++++++++<br>Start url:" + rstEvent[j][0]);
                        pool.assign(new reger.linkrot.LinkrotProcessRequests(rstEvent[j][0]));
                        urlsProcessed = urlsProcessed + 1;
                        Debug.debug(5, "", "End url:" + rstEvent[j][0] + "<br>++++++++++++++++<br>++++++++++++++++<br>++++++++++++++++<br>");
                    }
                }
            }

            //Wait for the pool to complete
            if (urlsProcessed>0){
                pool.complete();
            }


            //Finds and deletes linkrot entries that are no longer tied to an event.
            Util.deleteOrphanLinkrotids();

            result = urlsProcessed + " urls processed.";
        } else {
            result = "Linkrot Fixer is turned off now.";
        }
    }





}
