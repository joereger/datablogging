package reger.scheduledtasks;

import reger.core.db.Db;
import reger.core.scheduler.ScheduledTask;

/**
 * Gets the filesize and entry size and updates them.
 */
public class DeleteOldAutosavedEntries implements ScheduledTask{

    private String result = "";

    public String getTaskName() {
        return "Delete Autosaved Entries";
    }

    public int getRunEveryXMinutes() {
        return 3600;
    }

    public boolean getOnlyRunOnceAtStartup() {
        return false;
    }

    public String getResult() {
        return result;
    }

    public void doTask(){
        int recordsupdated = 0;
        try {

            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("DELETE FROM event WHERE istemporary='1' AND createdate < (CURDATE() - INTERVAL 8 DAY)");
            //-----------------------------------
            //-----------------------------------

            recordsupdated = count;

        } catch (Exception e){
            reger.core.Util.errorsave(e);
            result = "Error.  Check event log.";
        }
        result = recordsupdated + " records updated.";
    }






}
