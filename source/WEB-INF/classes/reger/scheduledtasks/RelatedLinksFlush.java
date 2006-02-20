package reger.scheduledtasks;

import reger.core.scheduler.ScheduledTask;

/**
 * Expires user sessions
 */
public class RelatedLinksFlush implements ScheduledTask {

    private String result = "";

    public String getTaskName() {
        return "Related Links Flush";
    }

    public int getRunEveryXMinutes() {
        return 720;
    }

    public boolean getOnlyRunOnceAtStartup() {
        return false;
    }

    public String getResult() {
        return result;
    }

    public void doTask(){
        reger.cache.RelatedLinksCache.flush();
        result = "Related links flushed";
    }


}
