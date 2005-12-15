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
    public String[] requestVarsToAppendToLink;

    public NavButton(String navButtonName, String parentNavButton, String buttonTitle, String buttonUrlFromSiteRoot, boolean isOn, String aclNameRequiredToShowButton, String[] requestVarsToAppendToLink){
        this.navButtonName = navButtonName;
        this.parentNavButton = parentNavButton;
        this.buttonTitle = buttonTitle;
        this.buttonUrlFromSiteRoot = buttonUrlFromSiteRoot;
        this.isOn = isOn;
        this.aclNameRequiredToShowButton = aclNameRequiredToShowButton;
        this.requestVarsToAppendToLink = requestVarsToAppendToLink;
    }

    public String getQueryStringIncludingRequestVars(javax.servlet.http.HttpServletRequest request){
        StringBuffer out = new StringBuffer();
        int numberOfVarsAdded = 0;
        if (requestVarsToAppendToLink!=null){
            for (int i = 0; i < requestVarsToAppendToLink.length; i++) {
                if (request.getParameter(requestVarsToAppendToLink[i])!=null){
                    if(numberOfVarsAdded>0){
                        out.append("&");
                    } else {
                        out.append("?");
                    }
                    out.append(requestVarsToAppendToLink[i]+"="+request.getParameter(requestVarsToAppendToLink[i]));
                    numberOfVarsAdded = numberOfVarsAdded + 1;
                }
            }
        }
        return out.toString();    
    }
}
