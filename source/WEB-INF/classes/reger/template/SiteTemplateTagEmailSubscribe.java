package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.SideColumn;

/**
 *
 */
public class SiteTemplateTagEmailSubscribe implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Email.Subscribe.Box";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "A box allowing readers to subscribe to your site via email.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     */
    public String getValue(StringBuffer mb, StringBuffer sc, PageProps pageProps, UserSession userSession, javax.servlet.http.HttpServletRequest request) {
        StringBuffer out = new StringBuffer();
        //Email Subscription
        if (userSession.getAccount().isPro() && userSession.getAccount().getEmailnewsletter()==1) {
            out.append(SideColumn.sideColTableStart("Email Subscription"));
            out.append(SideColumn.sideColHeaderRow("Email Subscription"));
            out.append(SideColumn.sideColContentRow("<form action=emailsubscription.log method=post><input type=hidden name=action value=addsubscriber><font face=arial class=smallfont size=-1>Enter your email address to receive this site via email.<br><input type=text name=emailaddress size=10 maxlength=49><br><input type='submit' value='Go'></font></form>"));
            out.append(SideColumn.sideColTableEnd("Email Subscription"));
        }
        return out.toString();
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "This is a log entry.";
    }

}
