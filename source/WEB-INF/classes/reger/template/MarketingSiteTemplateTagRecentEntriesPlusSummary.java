package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.core.db.Db;

import java.util.Calendar;

/**
 *
 */
public class MarketingSiteTemplateTagRecentEntriesPlusSummary implements MarketingSiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Recent.Entries.Plus.Summary";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "Newest entries added to the private label along with the summary of the entry.";
    }

    public boolean isRequired(){
        return false;
    }

    /**
     * The workhorse of the tag which services live requests.
     * It takes in these elements and then spits out what the
     * tag should be replaced with on the screen.
     */
    public String getHtml(StringBuffer mb, PageProps pageProps, UserSession userSession, javax.servlet.http.HttpServletRequest request){
        StringBuffer out = new StringBuffer();


        String cachekey = "MarketingSiteTemplateTagRecentEntries" + " URL:" + reger.cache.HtmlCache.getKeyFromRequest(request);
        int refreshintervalinseconds = 1200;
        if (request.getMethod().equals("GET") && !reger.cache.HtmlCache.isStale(cachekey, refreshintervalinseconds)){
            out.append(reger.cache.HtmlCache.getFromCache(cachekey));
        } else {
            //Start Most Recent Entries
            out.append("<table cellpadding=3 cellspacing=1 width=100% border=0>");
            out.append("<tr>");
            out.append("<td bgcolor=#e6e6e6>");
            out.append("<font face=arial size=-1>");
            out.append("Most Recent Entries");
            out.append("</font>");
            out.append("</td>");
            out.append("</tr>");
            out.append("<tr>");
            out.append("<td bgcolor=#ffffff>");
            out.append("<font face=arial size=-2>");
            //-----------------------------------
            //-----------------------------------
            String[][] rstEvent= Db.RunSQL("SELECT eventid, title, account.accountid, megalog.logid, event.comments FROM event, account, megalog, pl WHERE "+userSession.getPl().getPeerSql()+" AND account.plid=pl.plid AND "+reger.Entry.sqlOfLiveEntry+" AND event.accountid=account.accountid AND event.logid=megalog.logid AND megalog.logaccess='"+reger.Vars.LOGACCESSPUBLIC+"' AND account.islistedindirectory='1' AND account.isactiveaccount='1' AND account.plid='"+userSession.getPl().getPlid()+"'  ORDER BY event.date DESC LIMIT 0,100");
            //-----------------------------------
            //-----------------------------------
            if (rstEvent!=null && rstEvent.length>0){
                for(int i=0; i<rstEvent.length; i++){
                    //out.append((i+1)+") ");
                    reger.Account acctTmp = reger.cache.AccountCache.get(Integer.parseInt(rstEvent[i][2]));
                    out.append("<a href='"+acctTmp.getSiteRootUrl(userSession)+"/entry-logid"+rstEvent[i][3]+"-eventid"+rstEvent[i][0]+".log'>");
                    out.append(rstEvent[i][1]);
                    out.append("</a>");
                    out.append("<br>");
                    if (!rstEvent[i][4].equals("")){
                        out.append(reger.core.Util.truncateString(rstEvent[i][4], 500));
                        out.append("<br>");
                    }
                }
            }
            out.append("</font>");
            out.append("</td>");
            out.append("</tr>");
            out.append("</table>");
            //End Most Recent Entries

            //Update cache
            if (request.getMethod().equals("GET")){
                reger.cache.HtmlCache.updateCache(cachekey, refreshintervalinseconds, out.toString());
            }
        }
        if (request.getMethod().equals("GET")){
            //Tell user page was cached
            out.append("<font face=arial size=-2 color=#666666>");
            out.append("Last Updated: ");
            Calendar calTmp = (Calendar)reger.cache.HtmlCache.getLastUpdated().get(cachekey);
            out.append(reger.core.TimeUtils.agoText(calTmp));
            out.append(". ");
            out.append("Updates Every: "+reger.cache.HtmlCache.getRefreshInterval().get(cachekey)+" seconds.");
            out.append("</font>");
            out.append("<br>");
        }

        return out.toString();
    }

    /**
     * Content used for previews of templates.
     */
    public String getPreview(){
        return "No preview available.";
    }

}
