package reger.scheduledtasks;

import reger.core.db.Db;
import reger.core.scheduler.ScheduledTask;
import reger.core.Debug;
import reger.template.AllTemplatesInSystem;

import java.util.Calendar;


/**
 * Sends automated email subscription emails
 */
public class RefreshTemplateCache implements ScheduledTask{


    private String result = "";

    public String getTaskName() {
        return "Refresh Template Cache";
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
			AllTemplatesInSystem.refresh();
        } catch (Exception e) {
			Debug.errorsave(e, "");
			result = "Error.  See event log for details.";
        }

        result = "Templates reloaded successfully.";
    }

}
