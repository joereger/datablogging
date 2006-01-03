package reger.template;

import reger.pageFramework.PageProps;
import reger.UserSession;
import reger.core.db.Db;

import java.util.Calendar;

/**
 *
 */
public class MarketingSiteTemplateTagSitesMostRead implements MarketingSiteTemplateTag{

    /**
     * The syntax required to put this tag into the page.
     * Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax() {
        return "Sites.Most.Read";
    }

    public boolean acceptsParticularSyntax(String tagExample){
        if (tagExample.equalsIgnoreCase("<$"+getSyntax()+"$>")){
            return true;
        }
        return false;
    }

    public String getDescription() {
        return "Sites most read recently.";
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

        String cachekey = "MarketingSiteTemplateTagSitesMostRead" + " URL:" + reger.cache.HtmlCache.getKeyFromRequest(request);
        int refreshintervalinseconds = 3600;
        if (request.getMethod().equals("GET") && !reger.cache.HtmlCache.isStale(cachekey, refreshintervalinseconds)){
            out.append(reger.cache.HtmlCache.getFromCache(cachekey));
        } else {
            //Start Sites Most Read In Last 7 Days
            out.append("<table cellpadding=3 cellspacing=1 width=100% border=0>");
            out.append("<tr>");
            out.append("<td bgcolor=#e6e6e6>");
            out.append("<font face=arial size=-1>");
            out.append("Sites Most Read In Last 7 Days");
            out.append("</font>");
            out.append("</td>");
            out.append("</tr>");
            out.append("<tr>");
            out.append("<td bgcolor=#ffffff>");
            out.append("<font face=arial size=-2>");
            //-----------------------------------
            //-----------------------------------
            String[][] rstStsMstRd= Db.RunSQL("SELECT account.accountid, homepagetitle, account.accountid, sum(traffic.count) as cnt FROM account, traffic, pl WHERE "+userSession.getPl().getPeerSql()+" AND account.plid=pl.plid AND account.islistedindirectory='1' AND account.isactiveaccount='1' AND account.plid='"+userSession.getPl().getPlid()+"' AND traffic.accountid=account.accountid AND traffic.datetime>'"+reger.core.TimeUtils.dateformatfordb(reger.core.TimeUtils.xDaysAgoStart(java.util.Calendar.getInstance(), 8))+"' GROUP BY accountid ORDER BY cnt DESC LIMIT 0,100");
            //-----------------------------------
            //-----------------------------------
            if (rstStsMstRd!=null && rstStsMstRd.length>0){
                for(int i=0; i<rstStsMstRd.length; i++){
                    out.append((i+1)+") ");
                    reger.Account acctTmp = reger.cache.AccountCache.get(Integer.parseInt(rstStsMstRd[i][0]));
                    out.append("<a href='"+acctTmp.getSiteRootUrl(userSession)+"/'>");
                    String sitename = rstStsMstRd[i][1];
                    if (sitename.equals("")){
                        sitename=rstStsMstRd[i][2];
                    }
                    out.append(sitename);
                    out.append("</a>");
                    out.append(" ("+rstStsMstRd[i][3]+")");
                    out.append("<br>");
                }
            }
            out.append("</font>");
            out.append("</td>");
            out.append("</tr>");
            out.append("</table>");
            //End Sites Most Read In Last 7 Days

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
