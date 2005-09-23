package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.Entry;
import reger.core.Debug;

/**
 *
 */
public class SiteTemplateTagComments implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Comments";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "Recent comments for this log or the entire site.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     *
     */
    public String getValue(StringBuffer mb, StringBuffer sc, PageProps pageProps, UserSession userSession, javax.servlet.http.HttpServletRequest request) {
        StringBuffer out = new StringBuffer();
        //Messages for this log
        out.append(reger.SideColumn.messages(pageProps.logProps.logid, pageProps.logProps.megalogname));
        return out.toString();
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "List of comments.";
    }

}
