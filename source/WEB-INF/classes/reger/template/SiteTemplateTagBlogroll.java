package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.SideColumn;
import reger.core.db.Db;

/**
 *
 */
public class SiteTemplateTagBlogroll implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Blogroll";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "Your list of favorite sites.";
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
        //Friendly sites
        if (userSession.getAccount().isPro() && userSession.getAccount().getFavesiteon()==1) {
            out.append(SideColumn.sideColTableStart("My Favorite Sites"));
            out.append(SideColumn.sideColHeaderRow("My Favorite Sites"));

            //-----------------------------------
            //-----------------------------------
            String[][] rstFaveSite= Db.RunSQL("SELECT url, name FROM favesite WHERE accountid='"+ userSession.getAccount().getAccountid() +"' ORDER BY name ASC");
            //-----------------------------------
            //-----------------------------------
            if (rstFaveSite!=null && rstFaveSite.length>0){
                for(int i=0; i<rstFaveSite.length; i++){
                    out.append(SideColumn.sideColContentRow("<font face=arial class=smallfont size=-1><a href=' " + rstFaveSite[i][0] + "' target=_new>" + rstFaveSite[i][1] + "</a></font>"));
                }
            } else {
                out.append(SideColumn.sideColContentRow("<font face=arial class=smallfont size=-1>None.</font>"));
            }

            out.append(SideColumn.sideColTableEnd("My Favorite Sites"));
        }
        return out.toString();
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "Blogroll.";
    }

}
