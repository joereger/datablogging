package reger.systemproperties;

import reger.core.SystemProperty;

public class PathUploadMedia extends SystemProperty{

    public PathUploadMedia(){
        setPropertyName("PATHUPLOADMEDIA");
        setPropertyDefault("c:/blogserver-userdata/");
        setPropertyDescription("This is the directory where the files that users upload to their blog entries are stored.  Choose a directory that is off of the web root so that files aren't deleted when upgrades are deployed. Note: be sure to include the trailing slash.  Example: 'c:/blogserver-userdata/'");
        load();
    }

}
