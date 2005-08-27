package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.pageFramework.PageProps;

import java.util.Calendar;

/**
 * A single tag element that users can put onto the page somewhere
 */
public interface MarketingHpTemplateTag extends TemplateTag{


    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     */
    public String getHtml(UserSession userSession, javax.servlet.http.HttpServletRequest request, PageProps pageProps);


}
