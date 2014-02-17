package reger.systemprops;

import reger.core.SystemProperty;

public class EmailListenerPort extends SystemProperty{

    public EmailListenerPort(){
        setPropertyName("EMAILLISTENERPORT");
        setPropertyDefault("8025");
        setPropertyDescription("port that email server should listen on.");
        load();
    }

}
