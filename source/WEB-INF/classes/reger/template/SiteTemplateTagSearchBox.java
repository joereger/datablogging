package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.SideColumn;

/**
 *
 */
public class SiteTemplateTagSearchBox implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Search.Box";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "A search box allowing keyword searches.  Also leads in to advanced search.";
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
        //Search My Site
        if (userSession.getAccount().isPro() && userSession.getAccount().getIssearchmysiteon()==1) {
            out.append(SideColumn.sideColTableStart("Search My Site"));
            out.append(SideColumn.sideColHeaderRow("Search My Site"));
            StringBuffer searchBox = new StringBuffer();
            searchBox.append("<form action=search-simplesearch.log method=post>");
            searchBox.append("<input type=hidden name=nextchunktodisplay value=chunk-searchresults>");
            searchBox.append("<input type=hidden name=thischunkuniqueidentifier value=chunk-keywords>");
            searchBox.append("<input type=text name=searchterms value='' size=10 maxlength=49>");
            searchBox.append("<br><input type='submit' value='Search'>");
            searchBox.append("</form>");
            out.append(SideColumn.sideColContentRow(searchBox.toString()));
            out.append(SideColumn.sideColTableEnd("Search My Site"));
        }
        return out.toString();
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "Search box.";
    }

}
