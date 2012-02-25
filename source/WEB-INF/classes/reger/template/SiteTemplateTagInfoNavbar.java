package reger.template;

import reger.AccountCounts;
import reger.UserSession;
import reger.pageFramework.PageProps;

/**
 *
 */
public class SiteTemplateTagInfoNavbar implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Nav.Info";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "quick links about the site.";
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

        //Get the accountcounts variable
        AccountCounts acctCounts = reger.cache.AccountCountCache.get(userSession.getAccount(), userSession.getAccountuser());

        
        //-
//        out.append("<li><a href=\"authorlist.log\">"+ acctCounts.getAuthorcount() + " Author");
//        if (acctCounts.getAuthorcount()==1) {
//            out.append("");
//        } else {
//            out.append("s");
//        }
//        out.append("</a></li>");
        
        //-
        out.append("<li><a href=\"index.log\">"+ acctCounts.getEntrycount() + " Post");
        if (acctCounts.getEntrycount()==1) {
            out.append("");
        } else {
            out.append("s");
        }
        out.append("</a></li>");
                
        //-
        out.append("<li><a href=\"files.log\">"+ acctCounts.getFilecount() + " Image");
        if (acctCounts.getFilecount()==1) {
            out.append("");
        } else {
            out.append("s");
        }
        out.append("</a></li>");

        //-
        out.append("<li><a href=\"tags.log\">"+ acctCounts.getTagCount() + " Tag");
        if (acctCounts.getTagCount() == 1) {
            out.append("");
        } else {
            out.append("s");
        }
        out.append("</a></li>");
                
        //-
        out.append("<li><a href=\"locations.log\">"+ acctCounts.getLocationcount() + " Location");
        if (acctCounts.getLocationcount()==1) {
            out.append("");
        } else {
            out.append("s");
        }
        out.append("</a></li>");
                

        
        //-
        out.append("<li><a href=\"graphs.log\">"+ acctCounts.getGraphcount() + " Graph");
        if (acctCounts.getGraphcount()==1) {
            out.append("");
        } else {
            out.append("s");
        }
        out.append("</a></li>");
                
        



        return out.toString();
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return ".";
    }

}
