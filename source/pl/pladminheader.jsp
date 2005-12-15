<%@ page import="reger.UserSession"%>
<%
//We must start with a plid
int plid = 0;
if (reger.core.Util.isinteger(request.getParameter("plid"))){
    plid = Integer.parseInt(request.getParameter("plid"));
}

//If there's no plid, send the user to the page where they can select one
if (plid<=0){
    response.sendRedirect("index.log");
    return;
}

//If the user can't access this plid, send them away
if (!userSession.getAccountuser().userCanAdministerPl(plid)){
    response.sendRedirect("index.log");
    return;
}

//Change title
reger.PrivateLabel pl = reger.AllPrivateLabelsInSystem.getPrivateLabel(plid);
pageProps.title = "PrivateLabel: " + pl.getPlname();

//Start PLID-choosing SQL
String plidSql = " (pl.plid='"+plid+"') ";
//End PLID-choosing SQL
%>