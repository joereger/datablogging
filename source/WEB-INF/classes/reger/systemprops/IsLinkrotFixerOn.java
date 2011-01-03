package reger.systemprops;

import reger.core.SystemProperty;

public class IsLinkrotFixerOn extends SystemProperty{

    public IsLinkrotFixerOn(){
        setPropertyName("ISLINKROTFIXERON");
        setPropertyDefault("1");
        setPropertyDescription("The Linkrot Fixer is a feature that helps users identify broken links on their site.  It searches their blog entries for links and periodically checks to make sure that the sites they link to are valid.  If they aren't, an alert is generated and the system helps users fix the link.  The downside of this feature is that with many sites it can consume much bandwidth and CPU time.  Set to 0 for off or 1 for on.");
        load();
    }



}
