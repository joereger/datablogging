package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.core.db.Db;

import java.util.Calendar;

/**
 *
 */
public class MarketingSiteTemplateTagSitesMostReadAllTime implements MarketingSiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Sites.Most.Read.All.Time";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "Sites most read over all time.";
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

        String cachekey = "MarketingSiteTemplateTagSitesMostReadAllTime" + " URL:" + reger.cache.html.HtmlCache.getKeyFromRequest(request);
        int refreshintervalinseconds = 3600;
        if (request.getMethod().equals("GET") && !reger.cache.html.HtmlCache.isStale(cachekey, refreshintervalinseconds)){
            out.append(reger.cache.html.HtmlCache.getFromCache(cachekey));
        } else {
            //Start Sites Most Read All Time
            out.append("<table cellpadding=3 cellspacing=1 width=100% border=0>");
            out.append("<tr>");
            out.append("<td bgcolor=#e6e6e6>");
            out.append("<font face=arial size=-1>");
            out.append("Sites Most Read All Time");
            out.append("</font>");
            out.append("</td>");
            out.append("</tr>");
            out.append("<tr>");
            out.append("<td bgcolor=#ffffff>");
            out.append("<font face=arial size=-2>");
            //-----------------------------------
            //-----------------------------------
            String[][] rstStsMstRdAllTime= Db.RunSQL("SELECT account.accountid, homepagetitle, account.accountid, sum(traffic.count) as cnt FROM account, traffic, pl WHERE "+userSession.getPl().getPeerSql()+" AND account.plid=pl.plid AND account.islistedindirectory='1' AND account.isactiveaccount='1' AND account.plid='"+userSession.getPl().getPlid()+"' AND traffic.accountid=account.accountid GROUP BY accountid ORDER BY cnt DESC LIMIT 0,100");
            //-----------------------------------
            //-----------------------------------
            if (rstStsMstRdAllTime!=null && rstStsMstRdAllTime.length>0){
                for(int i=0; i<rstStsMstRdAllTime.length; i++){
                    out.append((i+1)+") ");
                    reger.Account acctTmp = reger.cache.AccountCache.get(Integer.parseInt(rstStsMstRdAllTime[i][0]));
                    out.append("<a href='"+acctTmp.getSiteRootUrl(userSession)+"/'>");
                    String sitename = rstStsMstRdAllTime[i][1];
                    if (sitename.equals("")){
                        sitename=rstStsMstRdAllTime[i][2];
                    }
                    out.append(sitename);
                    out.append("</a>");
                    out.append(" ("+rstStsMstRdAllTime[i][3]+")");
                    out.append("<br>");
                }
            }
            out.append("</font>");
            out.append("</td>");
            out.append("</tr>");
            out.append("</table>");
            //End Sites Most Read All Time

            //Update cache
            if (request.getMethod().equals("GET")){
                reger.cache.html.HtmlCache.updateCache(cachekey, refreshintervalinseconds, out.toString());
            }
        }
        if (request.getMethod().equals("GET")){
            //Tell user page was cached
            out.append("<font face=arial size=-2 color=#666666>");
            out.append("Last Updated: ");
            Calendar calTmp = (Calendar)reger.cache.html.HtmlCache.getLastUpdated().get(cachekey);
            out.append(reger.core.TimeUtils.agoText(calTmp));
            out.append(". ");
            out.append("Updates Every: "+reger.cache.html.HtmlCache.getRefreshInterval().get(cachekey)+" seconds.");
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
