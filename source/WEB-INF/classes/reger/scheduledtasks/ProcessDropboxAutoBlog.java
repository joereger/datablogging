package reger.scheduledtasks;

import reger.Log;
import reger.core.Debug;
import reger.core.db.Db;
import reger.core.scheduler.ScheduledTask;
import reger.dropbox.Dropbox;
import reger.util.Num;

/**
 * Gets the filesize and entry size and updates them.
 */
public class ProcessDropboxAutoBlog implements ScheduledTask{

    private String result = "";

    public String getTaskName() {
        return "Process Dropbox AutoBlog";
    }

    public int getRunEveryXMinutes() {
        return 5;
    }

    public boolean getOnlyRunOnceAtStartup() {
        return false;
    }

    public String getResult() {
        return result;
    }

    public void doTask(){
        Debug.debug(3, "Running doTask()", "ProcessDropboxAutoBlog");
        int accountsProcessed = 0;
        try {
            //-----------------------------------
            //-----------------------------------
            String[][] rstCheck = Db.RunSQL("SELECT accountid FROM dropbox");
            //-----------------------------------
            //-----------------------------------
            if (rstCheck!=null && rstCheck.length>0){
                String accountidStr = rstCheck[0][0];
                if (Num.isinteger(accountidStr)){
                    if (Integer.parseInt(rstCheck[0][0])>0){
                        try{
                            Dropbox.processAutoBlogPath(Integer.parseInt(rstCheck[0][0]), false);
                            accountsProcessed++;
                        } catch (Exception ex){Debug.errorsave(ex, "ProcessDropboxAutoBlog");}
                    }
                }
            }

        } catch (Exception e){
            Debug.errorsave(e, "");
            result = "Error.  Check event log.";
        }
        result = accountsProcessed + " accounts processed.";
    }






}
