<%@ page import="reger.core.Debug"%>
<%
//executionTime Object Creation for Performance Analysis
reger.executionTime executionTime = new reger.executionTime();

//This is the main session holder
reger.AllUserSessions allUserSessions = new reger.AllUserSessions();
reger.UserSession userSession = allUserSessions.getUserSession(request, response);

//If it's an upload page, parse the request early
reger.Upload ul = null;
if (pageProps.isUploadPage){
    ul = new reger.Upload(request);
}

//Call Header to kick everything off
reger.pageFramework.GlobalHeader.get(request, response, out, pageProps, userSession);

//If the response has been committed, return, there's nothing else that can be done
if (response.isCommitted()){
    Debug.debug(5, "", "If/then on isCommitted in globalheader.jsp - response.isCommitted()=" + response.isCommitted());
    return;
}
%>