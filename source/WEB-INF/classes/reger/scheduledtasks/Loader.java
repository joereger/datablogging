package reger.scheduledtasks;

import reger.core.WebAppRootDir;
import reger.core.bandwidthtest.BandwidthTest;
import reger.core.db.DbConfig;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * This servlet is started at application start and loads email threads and other threads that need to run.
 */

public class Loader extends HttpServlet {

    public static reger.core.scheduler.MasterThread tThr;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Must be here so that Tomcat considers this to be a servlet and will load it at Tomcat startup
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Must be here so that Tomcat considers this to be a servlet and will load it at Tomcat startup
    }

    public void init(ServletConfig config){
        reger.core.WebAppRootDir ward = new reger.core.WebAppRootDir(config);
        reger.core.ContextName ctname = new reger.core.ContextName(config);
        //Make sure we have a valid db connection
        if (!DbConfig.haveValidConfig()){
            return;
        }
        startAMasterThread();
    }

    public static void startAMasterThread(){
        if (reger.scheduledtasks.Loader.tThr!=null){
            reger.scheduledtasks.Loader.tThr = null;
        }
        //Master thread
        //The master thread is created
        tThr = new reger.core.scheduler.MasterThread();
        //Add scheduled tasks
        //tThr.addScheduledTask(new ExpireUserSessions());
        tThr.addScheduledTask(new TrafficHitCacheRecording());
        tThr.addScheduledTask(new PurgeHtmlCacheOfStaleContent());
        tThr.addScheduledTask(new SystemMessageExpiration());
        tThr.addScheduledTask(new StartSmtpListener());
        tThr.addScheduledTask(new EmailSubscription());
        tThr.addScheduledTask(new StorageSpaceUpdate());
        tThr.addScheduledTask(new DeleteOldAutosavedEntries());
        tThr.addScheduledTask(new DeleteOrphanedAccountUserLogAccessAndAcl());
        tThr.addScheduledTask(new DoBilling());
        tThr.addScheduledTask(new TrafficCleanse());
        tThr.addScheduledTask(new LinkrotSpider());
        tThr.addScheduledTask(new DeleteOldPersistentLoginRecords());
        tThr.addScheduledTask(new RefreshTemplateCache());
        tThr.addScheduledTask(new BandwidthTest());
        tThr.addScheduledTask(new DeleteUnusedTags());
        //@todo Allow plugin tasks here
        //Run the thread
        tThr.setPriority(Thread.MIN_PRIORITY);
        tThr.start();
    }


}

