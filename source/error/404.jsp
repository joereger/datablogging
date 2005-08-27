<%@ page isErrorPage="true" %>
<%@ page import="reger.core.Util,
                 reger.core.db.Db"%>

<%
try {

    try {



        String url = request.getRequestURL().toString();
        try{
            String[] split = url.split(request.getServerName());
            if (split.length>=2){
                url = split[1];
            } else if (split.length==1){
                url = split[0];
            }
        } catch (Exception e){
            reger.core.Util.errorsave(e);
            url = request.getRequestURL().toString();
        }



        if (url.indexOf("favicon.ico")<0 && url.indexOf("robots.txt")<0){

            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE pagenotfound SET count=count+1, mostrecentreferer='"+reger.core.Util.cleanForSQL(reger.core.Util.truncateString(request.getHeader("referer"), 255))+"' WHERE pagename='"+reger.core.Util.cleanForSQL(reger.core.Util.truncateString(url, 255))+"'");
            //-----------------------------------
            //-----------------------------------
            if (count<=0){
                //-----------------------------------
                //-----------------------------------
                int identity = Db.RunSQLInsert("INSERT INTO pagenotfound(pagename, count, mostrecentreferer) VALUES('"+reger.core.Util.cleanForSQL(reger.core.Util.truncateString(url, 255))+"', '1', '"+reger.core.Util.cleanForSQL(reger.core.Util.truncateString(request.getHeader("referer"), 255))+"')");
                //-----------------------------------
                //-----------------------------------
            }

        }

    } catch (Throwable e){
        //Save the error to the database, note that this isn't the 404... it's a problem saving the 404
        reger.core.Util.errorsave(e);
    }


    //Do the redirect
    //response.sendRedirect("index.log");
    //return;

} catch (Throwable e){
    e.printStackTrace();
}
%>

<html>
<head>
<title>404 Page Not Found</title>
</head>
<body bgcolor=#ffcc00>
<center>
<br><br>
<img src='/images/error-tri-large.gif' width=385 height=350>
<br>
<blockquote><blockquote>
<strong><blink><font face=arial size=+3 color=#ffffff style="font-size: 76px;">Page not found.</font></blink></strong>
<br><br>
<blockquote><blockquote>
<strong><font face=arial size=-1 color=#ffffff style="font-size: 15px;">We're sorry.  The page you are requesting was not found.  If you feel that this message is in error, please <a href='/about/feedback.log'>contact the system administrator</a>.</font></strong>
</blockquote></blockquote>
</blockquote></blockquote>
</center>
</body>
</html>

