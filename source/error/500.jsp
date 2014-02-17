<%@ page isErrorPage="true" %>
<%@ page import="reger.core.Debug"%>


<%
exception.printStackTrace();

try {
    //out.println(reger.core.ErrorDissect.dissect(exception, request));
} catch (Exception e) {
    //out.println(reger.core.ErrorDissect.dissect(exception, request));
}
%>

<%


try {
    //Try to determine the accountid of this error
    try {
        //Setup a var to hold the accountid
        int accountid=-1;

        //Parse the heck out of that URL... yeah, yeah, yeah!
        reger.UrlSplitter urlSplitter = new reger.UrlSplitter(request);

        //Now try to save with the accountid
        Debug.errorsave(exception, "", accountid, request.getRequestURL().toString(), request);
    } catch (Throwable e){
        //Do nothing.  We failed pardner.  Nothing but a basic save now, pardner
        //Save the error to the database
        Debug.errorsave(exception, "", request.getRequestURL().toString(), request);
        e.printStackTrace();
        System.out.print(e.getMessage());
    }


    //Do the redirect
    response.sendRedirect("index.log");
    return;

} catch (Throwable e){
    e.printStackTrace();
}
%>

<html>
<head>
<title>500 Error</title>
</head>
<body bgcolor=#ffffff>
<br><br><br><br>
<blockquote><blockquote>
<strong><blink><font face=arial size=+3 color=#cccccc style="font-size: 76px;">Oops, there has been an error.</font></blink></strong>
<br><br>
<blockquote><blockquote>
<strong><font face=arial size=-1 color=#666666 style="font-size: 12px;">Terribly sorry about that.</font></strong>
</blockquote></blockquote>
</blockquote></blockquote>
</body>
</html>

