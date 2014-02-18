package reger.systemprops;

import reger.core.SystemProperty;

public class EmailListenerPort extends SystemProperty{

    public EmailListenerPort(){
        setPropertyName("EMAILLISTENERPORT");
        setPropertyDefault("25");
        setPropertyDescription("port that email server should listen on.  default of 25.");
        load();
    }

}
