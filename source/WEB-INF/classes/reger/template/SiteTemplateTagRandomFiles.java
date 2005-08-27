package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;

/**
 *
 */
public class SiteTemplateTagRandomFiles implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Random.File.Thumbnails";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "A random list of thumbnails drawn from available files that have been uploaded.";
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
     */
    public String getValue(StringBuffer mb, StringBuffer sc, PageProps pageProps, UserSession userSession, javax.servlet.http.HttpServletRequest request) {
        HpTemplateTagRandomFiles mr = new HpTemplateTagRandomFiles();
        return mr.getHtml(userSession, request, pageProps);
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "List of Random Thumbnails Here";
    }

}
