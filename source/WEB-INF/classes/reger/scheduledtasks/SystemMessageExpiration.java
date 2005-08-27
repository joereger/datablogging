package reger.scheduledtasks;

import reger.core.db.Db;
import reger.core.scheduler.ScheduledTask;

/**
 * Expires system messages
 */
public class SystemMessageExpiration implements ScheduledTask{

    private String result = "";

    public String getTaskName() {
        return "System Message Expiration";
    }

    public int getRunEveryXMinutes() {
        return 0;
    }

    public boolean getOnlyRunOnceAtStartup() {
        return true;
    }

    public String getResult() {
        return result;
    }


    public void doTask(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE systemmessage SET islive='0' WHERE autooldonrestart='1'");
        //-----------------------------------
        //-----------------------------------
        //Refresh the memory object
        reger.AllLiveSystemMessagesInSystem.refresh();
        result = count + " system messages expired.";
    }


}
