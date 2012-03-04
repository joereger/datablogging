package reger.template;

import reger.UserSession;
import reger.pageFramework.PageProps;

/**
 *
 */
public class SiteTemplateTagAboutThisBlog implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "About";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "About this blog.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     *
     * @param mb
     * @param sc
     * @param pageProps
     * @param userSession
     * @return
     */
    public String getValue(StringBuffer mb, StringBuffer sc, PageProps pageProps, UserSession userSession, javax.servlet.http.HttpServletRequest request) {
        StringBuffer out = new StringBuffer();

        boolean a = false;

        if (userSession.getAccount().getAboutthisblogtitle()!=null && !userSession.getAccount().getAboutthisblogtitle().equals("")){
            a=true;
            out.append("<h2>"+userSession.getAccount().getAboutthisblogtitle()+"</h2>");
        }


        if (userSession.getAccount().getAboutthisbloghtml()!=null && !userSession.getAccount().getAboutthisbloghtml().equals("")){
            a=true;
            out.append("<div id=\"aboutthisblog\">");
            out.append(userSession.getAccount().getAboutthisbloghtml());
            out.append("</div>");
        }




        if (a){
            out.append("<br/><br/>");
        }




        return out.toString();

    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return "";
    }

}
