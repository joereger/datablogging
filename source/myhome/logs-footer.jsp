<%
if (navPanel!=null){
    if (pageProps.logProps.logid>0){
        mb.append(navPanel.getHtmlEnd(pageProps.pathToAppRoot, request));
    } else if (request.getParameter("eventtypeid")!=null && reger.core.Util.isinteger(request.getParameter("eventtypeid"))){
        mb.append(navPanel.getHtmlEnd(pageProps.pathToAppRoot, request));
    }
}
%>