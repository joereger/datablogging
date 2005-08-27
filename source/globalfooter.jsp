<%
//Call footer to output everything
reger.pageFramework.GlobalFooter.get(request, response, out, pageProps, mb, sc, userSession);

//Display page performance in milliseconds
if (pageProps.siteSection!=pageProps.MOBILEPUBLIC && pageProps.siteSection!=pageProps.MOBILEPRIVATE && reger.core.Util.isMastercookieOn(request)){
    out.println(reger.debugInfo.exececutionTimeOutput(executionTime.getElapsedMillis()));
}
%>