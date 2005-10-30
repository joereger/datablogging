package reger;


import reger.chiba.ChibaServletReger;
import reger.pageFramework.PageProps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class MegaHtmlFormCenterChiba {

    public static StringBuffer getHtml(UserSession userSession, PageProps pageProps, boolean displayasadmin, HttpServletRequest request, HttpServletResponse response){
        StringBuffer mb = new StringBuffer();

        boolean editLayout = false;
        String disabledFormText = "";
        if (request.getParameter("mode")!=null && request.getParameter("mode").equals("editlayout")){
            editLayout = true;
            disabledFormText = "disabled=\"true\"";
        }

        mb.append("<tr>");
        mb.append("<td bgcolor=#ffffff colspan=6 align=left valign=top>");


        try{
            ChibaServletReger chibaServlet = new ChibaServletReger(pageProps.entry, reger.cache.LogCache.get(pageProps.logProps.logid));
            String chibaOutput = "";
            if (request.getMethod().equals("POST")){
                chibaOutput = chibaServlet.doPost(request, response);     
            } else {
                chibaOutput = chibaServlet.doGet(request, response);
            }

            //Output result to the screen
            mb.append(chibaOutput.toString());


            //Check some state on the chibabean




        } catch (Exception e){
            reger.core.Debug.errorsave(e, "MegaHtmlFormCenterChiba.java");
        }

        mb.append("</td>");
        mb.append("</tr>");


        return mb;
    }

}
