package reger.systemprops;

import reger.core.SystemProperty;

public class EmailListenerIp extends SystemProperty{

    public EmailListenerIp(){
        setPropertyName("EMAILLISTENERIP");
        setPropertyDefault("127.0.0.1");
        setPropertyDescription("This is the IP address that the blog server should bind to on port 25 to listen for incoming email messages.  This allows users to post to their blogs by email.  Note that the IP address chosen must be accessible by the Java JVM and that nothing may be bound to port 25.  Also note that this email listener can be turned off with the EMAILLISTENERISON system variable.");
        load();
    }

}
