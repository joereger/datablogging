package reger.systemprops;

import reger.core.SystemProperty;

public class ForcePort extends SystemProperty{

    public ForcePort(){
        setPropertyName("FORCEPORT");
        setPropertyDefault("");
        setPropertyDescription("When run behind a firewall the port received by the servlet container may not be the port that should be used to build links. For example, an apache load balancer runs on 1.1.1.1 port 80 but forwards requests to 2.2.2.2 port 8088 where this app is running.  You'll want to FORCEPORT 80.  Leave blank to use whatever port the servlet container receives (works for most configurations.)");
        load();
    }



}