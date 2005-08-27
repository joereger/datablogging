package reger.core;

import javax.servlet.ServletConfig;

/**
 * Holds this context's installation point
 */
public class WebAppRootDir {

    private static String root;

    public WebAppRootDir(javax.servlet.http.HttpServletRequest request){
         root = request.getSession().getServletContext().getRealPath("/");
    }

    public WebAppRootDir(ServletConfig config){
         root = config.getServletContext().getRealPath("/");
    }

    public static String getWebAppRootPath(){
        return root;
    }

}
