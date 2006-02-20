package reger.scheduledtasks;

import reger.core.scheduler.ScheduledTask;

/**
 *
 */
public class TrafficHitCacheRecording implements ScheduledTask{

    private String result = "";
    
    public String getTaskName() {
        return "Traffic Hit Cache Recording";
    }

    public int getRunEveryXMinutes() {
        return 10;
    }

    public boolean getOnlyRunOnceAtStartup() {
        return false;
    }

    public String getResult() {
        return result;
    }
    
    public void doTask(){
        reger.cache.html.TrafficHitCache.saveAndPurge();
        result = "Done.";
    }
    

}
