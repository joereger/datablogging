package reger.nav;

/**
 * Represents a single page or button on the main nav
 */
public class NavButton {
    //These two define the uniqueness of the navButton
    public String navButtonName;
    public String parentNavButton;
    //General properties
    public String buttonTitle;
    public String buttonUrlFromSiteRoot;
    //Whether it's on
    public boolean isOn;
    //Required permission to display the button.  Example: "pladmin"
    public String aclNameRequiredToShowButton;

    public NavButton(String navButtonName, String parentNavButton, String buttonTitle, String buttonUrlFromSiteRoot, boolean isOn, String aclNameRequiredToShowButton){
        this.navButtonName = navButtonName;
        this.parentNavButton = parentNavButton;
        this.buttonTitle = buttonTitle;
        this.buttonUrlFromSiteRoot = buttonUrlFromSiteRoot;
        this.isOn = isOn;
        this.aclNameRequiredToShowButton = aclNameRequiredToShowButton;
    }
}
