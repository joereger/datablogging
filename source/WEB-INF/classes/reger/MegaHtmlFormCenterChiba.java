package reger;


import reger.chiba.ChiReger;
import reger.pageFramework.PageProps;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class MegaHtmlFormCenterChiba {

    public static StringBuffer getHtml(UserSession userSession, PageProps pageProps, boolean displayasadmin, HttpServletRequest request, HttpServletResponse response){
        StringBuffer mb = new StringBuffer();

        try{
            ChiReger chibaServlet = new ChiReger();
            chibaServlet.init();
            String chibaOutput = "";
            if (request.getMethod().equals("POST")){
                chibaOutput = chibaServlet.doPost(request, response);     
            } else {
                chibaOutput = chibaServlet.doGet(request, response);
            }


            mb.append(chibaOutput.toString());
        } catch (Exception e){
            reger.core.Debug.errorsave(e, "MegaHtmlFormCenterChiba.java");
        }




        return mb;
    }

}
