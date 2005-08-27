package reger.systemproperties;

import reger.core.SystemProperty;

public class EmailServer extends SystemProperty{

    public EmailServer(){
        setPropertyName("EMAILSERVER");
        setPropertyDefault("localhost");
        setPropertyDescription("This is the outbound SMTP server that the blogging server should use to send email.  It can be a hostname or an IP address.");
        load();
    }

}
