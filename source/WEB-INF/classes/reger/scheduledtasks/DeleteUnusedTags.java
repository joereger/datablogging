package reger.scheduledtasks;

import reger.core.db.Db;
import reger.core.scheduler.ScheduledTask;
import reger.core.Debug;

/**
 * Gets the filesize and entry size and updates them.
 */
public class DeleteUnusedTags implements ScheduledTask{

    private String result = "";

    public String getTaskName() {
        return "Delete Unused Tags";
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

            //This is where the task is done




        } catch (Exception e){
            Debug.errorsave(e, "");
            result = "Error.  Check event log.";
        }
        result = recordsupdated + " tags deleted.";
    }






}
