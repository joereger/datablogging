<%@ page import="reger.nav.NavPanel,
                 reger.nav.NavButton,
                 reger.Log,
                 reger.AddToArray"%>
<%@ page import="reger.cache.LogCache"%>
<%
NavPanel navPanel=null;

//Logid
if (pageProps.logProps.logid>0){

    Log logForHeader = LogCache.get(pageProps.logProps.logid);

    if (logForHeader!=null){
        pageProps.title = "Log: " + logForHeader.getName();
        pageProps.navButtonName = "logsyourlogs";

        NavButton[] logNavButtons = new NavButton[0];
        logNavButtons = AddToArray.addToNavButtonArray(logNavButtons, new NavButton("logs-log-properties", "", "PROPERTIES", "myhome/logs-log-properties.log?logid="+pageProps.logProps.logid, false, "", null));
        logNavButtons = AddToArray.addToNavButtonArray(logNavButtons, new NavButton("logs-fieldlayout", "", "DATABLOGGING FIELDS", "myhome/logs-log-fieldlayout.log?logid="+pageProps.logProps.logid, false, "", null));
        logNavButtons = AddToArray.addToNavButtonArray(logNavButtons, new NavButton("logs-log-templates", "", "LOG LOOK & FEEL TEMPLATES", "myhome/logs-log-templates.log?logid="+pageProps.logProps.logid, false, "", null));
        logNavButtons = AddToArray.addToNavButtonArray(logNavButtons, new NavButton("logs-log-permissions", "", "PERMISSIONS", "myhome/logs-log-permissions.log?logid="+pageProps.logProps.logid, false, "", null));
        logNavButtons = AddToArray.addToNavButtonArray(logNavButtons, new NavButton("logs-log-move", "", "MOVE LOG", "myhome/logs-log-move.log?logid="+pageProps.logProps.logid+"&action=movestart&nestednavtype="+logForHeader.getThisNestedNavType()+"&nestednavid="+logForHeader.getThisNestedNavId()+"", false, "", null));
        logNavButtons = AddToArray.addToNavButtonArray(logNavButtons, new NavButton("logs-log-delete", "", "DELETE LOG", "myhome/logs-log-delete.log?logid="+pageProps.logProps.logid, false, "", null));

        navPanel = new NavPanel("", currentNavButtonName, logNavButtons, 2);
        mb.append(navPanel.getHtmlStart(pageProps.pathToAppRoot, userSession, request));
    }

    mb.append("<br><br>");

//Eventtypeid
} else if (request.getParameter("eventtypeid")!=null && reger.core.Util.isinteger(request.getParameter("eventtypeid"))){
    int tmpEventtypeid = Integer.parseInt(request.getParameter("eventtypeid"));

    reger.MegaLogType mlt = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(tmpEventtypeid);

    if (mlt!=null){
        pageProps.title = "Log Type: " + mlt.getMegalogname();
        pageProps.navButtonName = "logslogtypes";

        NavButton[] logNavButtons = new NavButton[0];
        logNavButtons = AddToArray.addToNavButtonArray(logNavButtons, new NavButton("logs-type-properties", "", "PROPERTIES", "myhome/logs-type-properties.log?eventtypeid="+request.getParameter("eventtypeid"), false, "", null));
        logNavButtons = AddToArray.addToNavButtonArray(logNavButtons, new NavButton("logs-fieldlayout", "", "DATABLOGGING FIELDS", "myhome/logs-type-fieldlayout.log?eventtypeid="+request.getParameter("eventtypeid"), false, "", null));
        logNavButtons = AddToArray.addToNavButtonArray(logNavButtons, new NavButton("logs-type-summary", "", "LOG TYPE SUMMARY/USERS", "myhome/logs-type-detail.log?eventtypeid="+request.getParameter("eventtypeid"), false, "", null));
        logNavButtons = AddToArray.addToNavButtonArray(logNavButtons, new NavButton("logs-type-msgusers", "", "SEND MESSAGE TO LOG TYPE USERS", "myhome/logs-type-msgusers.log?eventtypeid="+request.getParameter("eventtypeid"), false, "", null));
        logNavButtons = AddToArray.addToNavButtonArray(logNavButtons, new NavButton("logs-type-delete", "", "DELETE LOG TYPE", "myhome/logs-type-delete.log?eventtypeid="+request.getParameter("eventtypeid"), false, "", null));

        navPanel = new NavPanel("", currentNavButtonName, logNavButtons, 2);
        mb.append(navPanel.getHtmlStart(pageProps.pathToAppRoot, userSession, request));
    }

    mb.append("<br><br>");

}




%>