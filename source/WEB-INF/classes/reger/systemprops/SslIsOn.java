package reger.systemprops;

import reger.core.SystemProperty;

public class SslIsOn extends SystemProperty{

    public SslIsOn(){
        setPropertyName("SSLISON");
        setPropertyDefault("0");
        setPropertyDescription("Use this to force all requests to be made on the secure ssl http port.  In addition to this setting you must configure the server overall to accept https communications.  Be careful with this one.  Keep the default of 0.  Get the https ports working and verify that you can accecss the application via ssl.  Only then should you set this to 1.");
        load();
    }



}
