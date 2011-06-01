package reger.scheduledtasks;

import reger.cache.providers.CacheFactory;
import reger.core.bandwidthtest.BandwidthTest;
import reger.systemprops.InstanceProperties;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
        //Set infinispan jgroups vars
        String jgroupstcpaddress="127.0.0.1";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            byte[] ipAddr = addr.getAddress();
            String hostname = addr.getHostName();
            String ipAddrStr = "";
            for (int i=0; i<ipAddr.length; i++) {
                if (i > 0) {
                    ipAddrStr += ".";
                }
                ipAddrStr += ipAddr[i]&0xFF;
            }
            jgroupstcpaddress=ipAddrStr;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.setProperty("jgroups.tcp.address", jgroupstcpaddress);
        System.out.println("jgroups.tcp.address="+jgroupstcpaddress);
        System.setProperty("jgroups.tcpping.initial_hosts", InstanceProperties.getJgroupstcppinginitialhosts());
        System.out.println("jgroups.tcpping.initial_hosts="+InstanceProperties.getJgroupstcppinginitialhosts());
        System.setProperty("jgroups.tcp.port", InstanceProperties.getJgroupstcpport());
        System.out.println("jgroups.tcp.port="+InstanceProperties.getJgroupstcpport());
        //Initialize object cache so it only creates one instance of itself
        CacheFactory.getCacheProvider().get("applicationstartup", "applicationstartup");
        //Make sure we have a valid db connection
        if (!InstanceProperties.haveValidConfig()){
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
        tThr.addScheduledTask(new RelatedLinksFlush());
        //@todo Allow plugin tasks here
        //Run the thread
        tThr.setPriority(Thread.MIN_PRIORITY);
        tThr.start();
    }


}

