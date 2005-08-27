package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.pageFramework.PageProps;

/**
 * A single tag element that users can put onto the page somewhere
 */
public interface SiteTemplateTag extends TemplateTag{


    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     * @param mb
     * @param sc
     * @param pageProps
     * @param userSession
     * @return
     */
    public String getValue(StringBuffer mb, StringBuffer sc, PageProps pageProps, UserSession userSession, javax.servlet.http.HttpServletRequest request);


}
