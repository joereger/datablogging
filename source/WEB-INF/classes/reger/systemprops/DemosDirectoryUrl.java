package reger.systemprops;

import reger.core.SystemProperty;

public class DemosDirectoryUrl extends SystemProperty{

    public DemosDirectoryUrl(){
        setPropertyName("DEMOSDIRECTORYURL");
        setPropertyDefault("http://www.reger.com/demos/");
        setPropertyDescription("The demos are a large package and to conserve bandwidth they are hosted for you at the default url of http://www.reger.com/demos/  However, you may want to download them and put them behind a firewall, for example.  To do this, extract the demos to a directory and set this variable to a fully-qualified url for that directory.");
        load();
    }



}
