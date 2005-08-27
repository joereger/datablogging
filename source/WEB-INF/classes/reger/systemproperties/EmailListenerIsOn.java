package reger.systemproperties;

import reger.core.SystemProperty;

public class EmailListenerIsOn extends SystemProperty{

    public EmailListenerIsOn(){
        setPropertyName("EMAILLISTENERISON");
        setPropertyDefault("1");
        setPropertyDescription("This is a 0 for off or a 1 for on.  It determines whether the blogging server should attempt to bind to port 25 to listen for incoming emails that should be posted to blogs.  It will ignore any email that does not authenticate properly via a key system.");
        load();
    }



}
