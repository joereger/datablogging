package reger.scheduledtasks;

import reger.core.scheduler.ScheduledTask;

/**
 * 
 */
public class PurgeHtmlCacheOfStaleContent implements ScheduledTask{

    private String result = "";
    
    public String getTaskName() {
        return "Purge Html Cache";
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
        reger.cache.HtmlCache.purgeStaleItems();
        result = "Done.";
    }
    

}
