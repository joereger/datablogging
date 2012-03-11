<%@ page import="reger.nav.NavPanel,
                 reger.nav.NavButton,
                 reger.Log,
                 reger.AddToArray"%>
<%@ page import="reger.cache.LogCache"%>
<%@ page import="reger.cache.LogCache"%>
<%
NavPanel navPanel=null;

//Logid
if (pageProps.logProps.logid>0){

    Log logForHeader = LogCache.get(pageProps.logProps.logid);

    if (logForHeader!=null){
        pageProps.title = "Log: " + logForHeader.getName();
        pageProps.navButtonName = "logsyourlogs";


        String isOn = "";

        mb.append("<br/>");
        mb.append("<ul class=\"nav nav-tabs\">\n");

        if (currentNavButtonName.equals("logs-log-properties")) {isOn=" class=\"active\"";} else {isOn="";}
        mb.append("<li "+isOn+"><a href=\"logs-log-properties.log?logid="+pageProps.logProps.logid+"\">Properties</a></li>\n");

        if (currentNavButtonName.equals("logs-log-templates")) {isOn=" class=\"active\"";} else {isOn="";}
        mb.append("<li "+isOn+"><a href=\"logs-log-templates.log?logid="+pageProps.logProps.logid+"\">Look & Feel</a></li>\n");

        if (currentNavButtonName.equals("logs-log-permissions")) {isOn=" class=\"active\"";} else {isOn="";}
        mb.append("<li "+isOn+"><a href=\"logs-log-permissions.log?logid="+pageProps.logProps.logid+"\">Permissions</a></li>\n");

        if (currentNavButtonName.equals("logs-log-move")) {isOn=" class=\"active\"";} else {isOn="";}
        mb.append("<li "+isOn+"><a href=\"logs-log-move.log?logid="+pageProps.logProps.logid+"&action=movestart&nestednavtype="+logForHeader.getThisNestedNavType()+"&nestednavid="+logForHeader.getThisNestedNavId()+"\">Move Log</a></li>\n");

        if (currentNavButtonName.equals("logs-log-delete")) {isOn=" class=\"active\"";} else {isOn="";}
        mb.append("<li "+isOn+"><a href=\"logs-log-delete.log?logid="+pageProps.logProps.logid+"\">Delete Log</a></li>\n");

        mb.append("</ul>");



    }

    mb.append("<br><br>");

//Eventtypeid
} else if (request.getParameter("eventtypeid")!=null && reger.core.Util.isinteger(request.getParameter("eventtypeid"))){
    int tmpEventtypeid = Integer.parseInt(request.getParameter("eventtypeid"));

    reger.MegaLogType mlt = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(tmpEventtypeid);

    if (mlt!=null){
        pageProps.title = "Log Type: " + mlt.getMegalogname();
        pageProps.navButtonName = "logslogtypes";


        String isOn = "";

        mb.append("<br/>");
        mb.append("<ul class=\"nav nav-tabs\">\n");

        if (currentNavButtonName.equals("logs-type-properties")) {isOn=" class=\"active\"";} else {isOn="";}
        mb.append("<li "+isOn+"><a href=\"logs-type-properties.log?eventtypeid="+request.getParameter("eventtypeid")+"\">Properties</a></li>\n");

        if (currentNavButtonName.equals("logs-fieldlayout")) {isOn=" class=\"active\"";} else {isOn="";}
        mb.append("<li "+isOn+"><a href=\"logs-type-fieldlayout.log?eventtypeid="+request.getParameter("eventtypeid")+"\">Fields</a></li>\n");

        if (currentNavButtonName.equals("logs-type-summary")) {isOn=" class=\"active\"";} else {isOn="";}
        mb.append("<li "+isOn+"><a href=\"logs-type-detail.log?eventtypeid="+request.getParameter("eventtypeid")+"\">Summary</a></li>\n");

        if (currentNavButtonName.equals("logs-type-msgusers")) {isOn=" class=\"active\"";} else {isOn="";}
        mb.append("<li "+isOn+"><a href=\"logs-type-msgusers.log?eventtypeid="+request.getParameter("eventtypeid")+"\">Send Message</a></li>\n");

        if (currentNavButtonName.equals("logs-type-delete")) {isOn=" class=\"active\"";} else {isOn="";}
        mb.append("<li "+isOn+"><a href=\"logs-type-delete.log?eventtypeid="+request.getParameter("eventtypeid")+"\">Delete Log Type</a></li>\n");

        mb.append("</ul>");

//        NavButton[] logNavButtons = new NavButton[0];
//        logNavButtons = AddToArray.addToNavButtonArray(logNavButtons, new NavButton("logs-type-properties", "", "Properties", "myhome/logs-type-properties.log?eventtypeid="+request.getParameter("eventtypeid"), false, "", null));
//        logNavButtons = AddToArray.addToNavButtonArray(logNavButtons, new NavButton("logs-fieldlayout", "", "Fields", "myhome/logs-type-fieldlayout.log?eventtypeid="+request.getParameter("eventtypeid"), false, "", null));
//        logNavButtons = AddToArray.addToNavButtonArray(logNavButtons, new NavButton("logs-type-summary", "", "Summary", "myhome/logs-type-detail.log?eventtypeid="+request.getParameter("eventtypeid"), false, "", null));
//        logNavButtons = AddToArray.addToNavButtonArray(logNavButtons, new NavButton("logs-type-msgusers", "", "Message Users of Log Type", "myhome/logs-type-msgusers.log?eventtypeid="+request.getParameter("eventtypeid"), false, "", null));
//        logNavButtons = AddToArray.addToNavButtonArray(logNavButtons, new NavButton("logs-type-delete", "", "Delete Log Type", "myhome/logs-type-delete.log?eventtypeid="+request.getParameter("eventtypeid"), false, "", null));
//
//        navPanel = new NavPanel("", currentNavButtonName, logNavButtons, 2);
//        mb.append(navPanel.getHtmlStart(pageProps.pathToAppRoot, userSession, request));
    }

    mb.append("<br><br>");

}




%>