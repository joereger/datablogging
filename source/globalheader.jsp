<%@ page import="reger.core.Debug"%>
<%@ page import="org.apache.log4j.Logger" %><%

Logger logger = Logger.getLogger(this.getClass().getName());

//executionTime Object Creation for Performance Analysis
reger.executionTime executionTime = new reger.executionTime();

Debug.debug(4, "globalheader.ini", "++++++++++++<br>Start Request:<br>"+request.getRequestURI());

//This code holds sessions in an application variable.
//This must be done because Tomcat's session cookie has a scope set to the current host.
//Tomcat's session cookie won't transcend subdomains, so I have to set my own cookie(s).
//Scalability of sessions is an issue with something like round-robin DNS.
//I'd like to avoid forcing sticky sessions as they require complex/expensive hardward/software.
//So I'll replicate session data with JbossCacheAOP, which is an efficient mechanism.
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