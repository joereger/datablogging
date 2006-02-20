<%@ page import="java.util.Calendar"%>
<%@ page import="reger.core.Debug"%>
<%
    //Update cache
    if (request.getMethod().equals("GET")){
        reger.cache.html.HtmlCache.updateCache(cachekey, refreshintervalinseconds, mb.toString());
    }
}
try{
    if (request.getMethod().equals("GET")){
        //Tell user page was cached
        mb.append("<br>");
        mb.append("<font face=arial size=-2 color=#666666>");
        mb.append("Page Last Generated: ");
        Calendar calTmp = (Calendar)reger.cache.html.HtmlCache.getLastUpdated().get(cachekey);
        mb.append(reger.core.TimeUtils.agoText(calTmp));
        mb.append(". ");
        mb.append("Page Generates Every: "+reger.cache.html.HtmlCache.getRefreshInterval().get(cachekey)+" seconds.");
        mb.append("</font>");
        mb.append("<br><br>");
    }
} catch (Exception e){
    Debug.errorsave(e, "", "Error in htmlcacheend.jsp.");
}
%>