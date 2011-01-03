package reger.systemprops;

import reger.core.SystemProperty;

public class LicensingServerUrl extends SystemProperty{

    public LicensingServerUrl(){
        setPropertyName("LICENSINGSERVERURL");
        setPropertyDefault("http://www.reger.com/licensing/api.jsp");
        setPropertyDescription("The URL of the licensing server.  This can be set to any URL.  However, if no valid licensing server is there then the datablogging server will not be able to validate licenses and complications may occur.  This property is generally used to prevent test installs from contacting the license server.  The default value is http://www.reger.com/licensing/api.jsp");
        load();
    }

}
