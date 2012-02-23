package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.AccountCounts;

/**
 *
 */
public class SiteTemplateTagQuickStats implements SiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Quick.Stats";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "A quick summary of the number of entries, logs, comments, files, etc on the site.";
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

        //Quick Stats
        out.append(reger.SideColumn.sideColTableStart("Quick Stats"));
        out.append(reger.SideColumn.sideColHeaderRow(""));
        //-
        StringBuffer qs = new StringBuffer();
        qs.append("<a href='authorlist.log'><img src=images/icon-author.gif border=0 align=middle></a> <font face=arial size=-2 class=smallfont> <a href='authorlist.log'>" + acctCounts.getAuthorcount() + " Author");
        if (acctCounts.getAuthorcount()==1) {
            qs.append("");
        } else {
            qs.append("s");
        }
        qs.append("</font></a>");
        out.append(reger.SideColumn.sideColContentRow(qs.toString()));
        //-
        qs.delete(0,qs.length());
        qs.append("<a href='index.log'><img src=images/icon-entry.gif border=0 align=middle></a> <font face=arial size=-2 class=smallfont> <a href='index.log'>" + acctCounts.getEntrycount() + " Log ");
        if (acctCounts.getEntrycount()==1) {
            qs.append("Entry");
        } else {
            qs.append("Entries");
        }
        qs.append("</font></a>");
        out.append(reger.SideColumn.sideColContentRow(qs.toString()));
        //-
        qs.delete(0,qs.length());
        qs.append("<a href='files.log'><img src=images/imageavailable2.gif border=0 align=middle></a> <font face=arial size=-2 class=smallfont> <a href='files.log'>" + acctCounts.getFilecount() + " File");
        if (acctCounts.getFilecount()==1) {
            qs.append("");
        } else {
            qs.append("s");
        }
        qs.append("</font>");
        out.append(reger.SideColumn.sideColContentRow(qs.toString()));
        //-
        qs.delete(0,qs.length());
        qs.append("<a href='locations.log'><img src=images/imageavailable2.gif border=0 align=middle></a> <font face=arial size=-2 class=smallfont> <a href='locations.log'>" + acctCounts.getLocationcount() + " Location");
        if (acctCounts.getLocationcount()==1) {
            qs.append("");
        } else {
            qs.append("s");
        }
        qs.append("</font>");
        out.append(reger.SideColumn.sideColContentRow(qs.toString()));
        //-
        if (userSession.getAccount().getMessagesstatus()==1){
            qs.delete(0,qs.length());
            qs.append("<a href='messages.log'><img src=images/messageavailable.gif border=0 align=middle></a> <font face=arial size=-2 class=smallfont> <a href='messages.log'>" + acctCounts.getMessagecount() + " Comment");
            if (acctCounts.getMessagecount()==1) {
                qs.append("");
            } else {
                qs.append("s");
            }
            qs.append("</font>");
            out.append(reger.SideColumn.sideColContentRow(qs.toString()));
        }
        //-
        qs.delete(0,qs.length());
        qs.append("<a href='episodes.log'><img src=images/icon-episode.gif border=0 align=middle></a> <font face=arial size=-2 class=smallfont> <a href='episodes.log'>" + acctCounts.getEpisodecount() + " ");
        if (acctCounts.getEpisodecount()==1) {
            qs.append("Episode");
        } else {
            qs.append("Episodes");
        }
        qs.append("</font></a>");
        out.append(reger.SideColumn.sideColContentRow(qs.toString()));
        //-
        qs.delete(0,qs.length());
        qs.append("<a href='graphs.log'><img src=images/imageavailable2.gif border=0 align=middle></a> <font face=arial size=-2 class=smallfont> <a href='graphs.log'>" + acctCounts.getGraphcount() + " Graph");
        if (acctCounts.getGraphcount()==1) {
            qs.append("");
        } else {
            qs.append("s");
        }
        qs.append("</font>");
        out.append(reger.SideColumn.sideColContentRow(qs.toString()));
        //-
        if (userSession.getAccount().getIstimeperiodon()){
            qs.delete(0,qs.length());
            qs.append("<a href='timeperiods.log'><img src=images/timeperiod/tpicon.gif border=0 align=middle></a> <font face=arial size=-2 class=smallfont> <a href='timeperiods.log'>" + acctCounts.getTimeperiodcount() + " Time Period");
            if (acctCounts.getTimeperiodcount()==1) {
                qs.append("");
            } else {
                qs.append("s");
            }
            qs.append("</font>");
            out.append(reger.SideColumn.sideColContentRow(qs.toString()));
        }
        //-
        if (userSession.getAccount().isPro() && userSession.getAccount().getIssearchmysiteon()==1) {
            qs.delete(0,qs.length());
            qs.append("<a href='savedsearches.log'><img src=images/imageavailable2.gif border=0 align=middle></a> <font face=arial size=-2 class=smallfont> <a href='savedsearches.log'>" + acctCounts.getSavedsearchescount() + " Saved Search");
            if (acctCounts.getSavedsearchescount()==1) {
                qs.append("");
            } else {
                qs.append("es");
            }
            qs.append("</font>");
            out.append(reger.SideColumn.sideColContentRow(qs.toString()));
        }


        //if (userSession.getAccount().isPro() && userSession.getAccount().getIssearchmysiteon()==1) {
            qs.delete(0,qs.length());
            qs.append("<a href='tags.log'><img src=images/imageavailable2.gif border=0 align=middle></a> <font face=arial size=-2 class=smallfont> <a href='tags.log'>" + acctCounts.getTagCount() + " Smart Tag");
            if (acctCounts.getTagCount() == 1) {
                qs.append("");
            } else {
                qs.append("s");
            }
            qs.append("</font>");
            out.append(reger.SideColumn.sideColContentRow(qs.toString()));
        //}

        qs.delete(0,qs.length());
        qs.append("<a href='polls.log'><img src=images/imageavailable2.gif border=0 align=middle></a> <font face=arial size=-2 class=smallfont> <a href='polls.log'>" + acctCounts.getPollscount() + " Poll");
        if (acctCounts.getPollscount() == 1) {
            qs.append("");
        } else {
            qs.append("s");
        }
        qs.append("</font>");
        out.append(reger.SideColumn.sideColContentRow(qs.toString()));


        out.append(reger.SideColumn.sideColTableEnd("Quick Stats"));


        return out.toString();
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
       return "This is a log entry.";
    }

}
