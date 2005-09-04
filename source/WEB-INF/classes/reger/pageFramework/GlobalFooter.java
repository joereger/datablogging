package reger.pageFramework;

import reger.UserSession;
import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;

import org.w3c.tidy.Tidy;

/**
 * Big Kahunette that outputs result of each page in the site
 */
public class GlobalFooter {

    public static void get(HttpServletRequest request, HttpServletResponse response, javax.servlet.jsp.JspWriter out, PageProps pageProps, StringBuffer mb, StringBuffer sc, UserSession userSession){
        try{

            //ServletOutputStream out = response.getOutputStream();
            //PrintWriter out = response.getWriter();

            //Call tRexPageEngine, the template page output engine.
            StringBuffer output = new StringBuffer();
            if (pageProps.siteSection==pageProps.PUBLICSITE){
                output=reger.template.SiteTemplateProcessor.getValue(mb,sc,userSession,pageProps, request);
            } else if (pageProps.siteSection==pageProps.ADMINSITE) {
                output=reger.tRexAdminPageEngine.pageout(mb,sc,userSession,pageProps, request);
            } else if (pageProps.siteSection==pageProps.GROUPSSITE) {
                output=reger.tRexGroupsPageEngine.pageout(mb,sc,userSession,pageProps, request);
            } else if (pageProps.siteSection==pageProps.MASTERADMINSITE) {
                output=reger.tRexAdminPageEngine.pageout(mb,sc,userSession,pageProps, request);
            } else if (pageProps.siteSection==pageProps.PLADMINSITE) {
                output=reger.tRexAdminPageEngine.pageout(mb,sc,userSession,pageProps, request);
            } else if (pageProps.siteSection==pageProps.HELPPOPUP) {
                output=reger.tRexHelpPopupEngine.pageout(mb,sc,userSession,pageProps);
            } else if (pageProps.siteSection==pageProps.MARKETINGSITE || pageProps.siteSection==pageProps.MARKETINGSITEWITHUSERCONTENT) {
                output=reger.template.MarketingSiteTemplateProcessor.getValue(mb, userSession, pageProps, request);
            } else if ((pageProps.siteSection==pageProps.MOBILEPUBLIC) || (pageProps.siteSection==pageProps.MOBILEPRIVATE)) {
                output=mb;
            }

            if (1==1){
                //Output the page
                out.print(output.toString());
            } else {
                //out.println(reger.debugInfo.exececutionTimeOutput(executionTime.getElapsedMillis()));
                ////Create input and output streams for Tidy to use
                java.io.ByteArrayInputStream inStr = new java.io.ByteArrayInputStream(output.toString().getBytes());
                ByteArrayOutputStream outStr = new ByteArrayOutputStream();

                //Create the Tidy object and clean the output
                Tidy tidy = new Tidy();
                tidy.setXHTML(true);
                tidy.setIndentContent(true);
                tidy.setWraplen(300);
                tidy.parse(inStr, outStr);

                //Output the page
                out.print(outStr.toString());
                //out.println(reger.debugInfo.exececutionTimeOutput(executionTime.getElapsedMillis()));
            }




            //---------------------------------------------------------------
            //Record traffic.  Use pageProps.trafficType
            boolean isSuperCookieOn = false;
            if (userSession.getAccount()!=null){
                isSuperCookieOn=reger.core.Util.isSupercookieOn(request, userSession.getAccount().getAccountid());
            }
            //Get logid
            int thisLogid = pageProps.logProps.logid;
            //Accountid
            int tmpAccountid=0;
            if (userSession.getAccount()!=null){
                tmpAccountid = userSession.getAccount().getAccountid();
            }
            //Bandwidth
            int bandwidth = output.length();
            //Put into cache
            try{
                reger.TrafficHit trafficHit = new reger.TrafficHit(request, pageProps.logProps.logid, tmpAccountid, pageProps.trafficType, userSession.getPl().getPlid(), userSession.getSiteRootUrl(), bandwidth, isSuperCookieOn);
                reger.cache.TrafficHitCache.addTrafficHit(trafficHit);
            } catch (Exception e){
                Debug.errorsave(e, "", "globalfooter.jsp");
            }
            //End record traffic
            //----------------------------------------------------------------



            if (pageProps.siteSection!=pageProps.MOBILEPUBLIC && pageProps.siteSection!=pageProps.MOBILEPRIVATE && reger.core.Util.isMastercookieOn(request)){


//                //Display core
//                out.println(reger.debugInfo.examineClass(userSession).toString());
//
//                //Display core
//                out.println(reger.debugInfo.examineClass(userSession.getAccountuser()).toString());
//
//                //Display pageProps
//                out.println(reger.debugInfo.pagePropsOut(pageProps).toString());
//
//                //Display request vars
//                out.println(reger.debugInfo.requestVars(request).toString());

            }
        } catch (Exception ex){
            Debug.errorsave(ex, "", "Error in GlobalFooter.java");
        }
    }


}
