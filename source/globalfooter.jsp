<%
//Call footer to output everything
reger.pageFramework.GlobalFooter.get(request, response, out, pageProps, mb, sc, userSession);



//Display page performance in milliseconds
if (pageProps.siteSection!=pageProps.MOBILEPUBLIC && pageProps.siteSection!=pageProps.MOBILEPRIVATE && reger.core.Util.isMastercookieOn(request)){
    out.println(reger.debugInfo.exececutionTimeOutput(executionTime.getElapsedMillis()));
}

//Close hibernate session
try{
    reger.hibernate.HibernateUtil.closeSession();
} catch (Throwable t){
    reger.core.Debug.errorsave(t, "globalfooter.jsp", "Error shutting down hibernate session");
}

reger.core.Debug.debug(4, "globalfooter.ini", "End Request:<br>"+request.getRequestURI()+"<br>++++++++++++");
%>