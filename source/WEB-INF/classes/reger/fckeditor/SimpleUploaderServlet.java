package reger.fckeditor;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


import org.apache.commons.fileupload.*;


import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import reger.systemproperties.AllSystemProperties;
import reger.core.db.Db;


/**
 * Servlet to upload files.<br>
 *
 * This servlet accepts just file uploads, eventually with a parameter specifying file type
 *
 * @author Simone Chiaretta (simo@users.sourceforge.net)
 */

public class SimpleUploaderServlet extends HttpServlet {

    /**
     * Initialize the servlet.<br>
     * Retrieve from the servlet configuration the "baseDir" which is the root of the file repository:<br>
     * If not specified the value of "/UserFiles/" will be used.<br>
     * Also it retrieve all allowed and denied extensions to be handled.
     *
     */
     public void init() throws ServletException {



         reger.core.Debug.debug(5, "SimpleUploaderServlet.java", "initialize.");

    }


    /**
     * Manage the Upload requests.<br>
     *
     * The servlet accepts commands sent in the following format:<br>
     * simpleUploader?Type=ResourceType<br><br>
     * It store the file (renaming it in case a file with the same name exists) and then return an HTML file
     * with a javascript command in it.
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        reger.core.Debug.debug(5, "SimpleUploaderServlet.java", "doGet called on fckeditor simpleuploader servlet.");

        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Cache-Control","no-cache");
        PrintWriter out = response.getWriter();


        String typeStr=request.getParameter("Type");

        //String currentPath=baseDir+typeStr;
        //String currentDirPath=getServletContext().getRealPath(currentPath);
        //currentPath=request.getContextPath()+currentPath;
        String currentPath= AllSystemProperties.getProp("PATHUPLOADMEDIA");

        reger.core.Debug.debug(5, "SimpleUploaderServlet.java", "currentpath="+currentPath);

        String retVal="0";
        String newName="";
        String fileUrl="";
        String errorMessage="";
        //retVal = 203 -> error
        //retVal = 201 -> ok

        //Reger.com work start
        reger.AllUserSessions allUserSessions = new reger.AllUserSessions();
        reger.UserSession userSession = allUserSessions.getUserSession(request, response);
        if (userSession.getAccountuser().isLoggedIn && userSession.getAccountuser().userCanDoAcl("ADDMEDIA", userSession.getAccount().getAccountid())){
            reger.Upload ul = new reger.Upload(request);
            reger.core.Debug.debug(5, "SimpleUploaderServlet.java", "userSession.getAccount().getAccountid()="+userSession.getAccount().getAccountid());
            int localEventid = 0;
            if (userSession.getAttribute("eventidForFckEditor")!=null && reger.core.Util.isinteger(String.valueOf(userSession.getAttribute("eventidForFckEditor")))){
                //@todo Actually set the userSession eventidForFckEditor attribute
                localEventid = Integer.parseInt(String.valueOf(userSession.getAttribute("eventidForFckEditor")));
            } else {
                //Go find the highest eventid for this account
                //-----------------------------------
                //-----------------------------------
                String[][] rstHighEvent= Db.RunSQL("SELECT eventid FROM event WHERE accountid='"+userSession.getAccount().getAccountid()+"' ORDER BY eventid DESC LIMIT 0,1");
                //-----------------------------------
                //-----------------------------------
                if (rstHighEvent!=null && rstHighEvent.length>0){
                     localEventid = Integer.parseInt(rstHighEvent[0][0]);
                }
            }
            ul.save(localEventid, "", userSession.getAccountuser().getAccountuserid(), userSession);
        }
        //Reger.com work end



        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.OnUploadCompleted("+retVal+",'"+fileUrl+"','"+newName+"','"+errorMessage+"');");
        out.println("</script>");
        out.flush();
        out.close();

        reger.core.Debug.debug(5, "SimpleUploaderServlet.java", "End doPost");

    }


    /*
      * This method was fixed after Kris Barnhoorn (kurioskronic) submitted SF bug #991489
      */
      private static String getNameWithoutExtension(String fileName) {
            return fileName.substring(0, fileName.lastIndexOf("."));
        }

    /*
      * This method was fixed after Kris Barnhoorn (kurioskronic) submitted SF bug #991489
      */
    private String getExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".")+1);
    }



    /**
     * Helper function to convert the configuration string to an ArrayList.
     */

     private ArrayList stringToArrayList(String str) {

     reger.core.Debug.debug(5, "SimpleUploaderServlet.java", str);
     String[] strArr=str.split("\\|");

     ArrayList tmp=new ArrayList();
     if(str.length()>0) {
         for(int i=0;i<strArr.length;++i) {
                 reger.core.Debug.debug(5, "SimpleUploaderServlet.java", i +" - "+strArr[i]);
                 tmp.add(strArr[i].toLowerCase());
            }
        }
        return tmp;
     }




}
