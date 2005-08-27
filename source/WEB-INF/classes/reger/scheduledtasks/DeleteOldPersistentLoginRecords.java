package reger.scheduledtasks;

import reger.core.scheduler.ScheduledTask;

/**
 * Deletes old persistent login records
 */
public class DeleteOldPersistentLoginRecords implements ScheduledTask{

    private String result = "";
    
    public String getTaskName() {
        return "Delete Old Persistent Login Records";
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
        int numberOfLoginsDeleted = reger.PersistentLogin.deleteOldPersistentLogins();
        result = numberOfLoginsDeleted + " persistent logins expired.";
    }
    

}
