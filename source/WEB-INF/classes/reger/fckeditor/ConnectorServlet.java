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
 * Servlet to upload and browse files.<br>
 *
 * This servlet accepts 4 commands used to retrieve and create files and folders from a server directory.
 * The allowed commands are:
 * <ul>
 * <li>GetFolders: Retrive the list of directory under the current folder
 * <li>GetFoldersAndFiles: Retrive the list of files and directory under the current folder
 * <li>CreateFolder: Create a new directory under the current folder
 * <li>FileUpload: Send a new file to the server (must be sent with a POST)
 * </ul>
 *
 * @author Simone Chiaretta (simo@users.sourceforge.net)
 */

public class ConnectorServlet extends HttpServlet {


    /**
     * Initialize the servlet.<br>
     * Retrieve from the servlet configuration the "baseDir" which is the root of the file repository:<br>
     * If not specified the value of "/UserFiles/" will be used.
     *
     */
     public void init() throws ServletException {

     }

    /**
     * Manage the Get requests (GetFolders, GetFoldersAndFiles, CreateFolder).<br>
     *
     * The servlet accepts commands sent in the following format:<br>
     * connector?Command=CommandName&Type=ResourceType&CurrentFolder=FolderPath<br><br>
     * It execute the command and then return the results to the client in XML format.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        reger.core.Debug.debug(3, "ConnectorServlet.java", "doGet called on fckeditor connector servlet.");

        response.setContentType("text/xml; charset=UTF-8");
        response.setHeader("Cache-Control","no-cache");
        PrintWriter out = response.getWriter();

        String commandStr=request.getParameter("Command");
        String typeStr=request.getParameter("Type");
        String currentFolderStr=request.getParameter("CurrentFolder");

        //String currentPath=baseDir+typeStr+currentFolderStr;
        //String currentDirPath=getServletContext().getRealPath(currentPath);
        String currentDirPath=AllSystemProperties.getProp("PATHUPLOADMEDIA");

        Document document=null;
        try {
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document=builder.newDocument();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }

        Node root=CreateCommonXml(document,commandStr,typeStr,currentFolderStr,"");

        reger.core.Debug.debug(3, "ConnectorServlet.java", "fckeditor Command = " + commandStr);

        reger.AllUserSessions allUserSessions = new reger.AllUserSessions();
        reger.UserSession userSession = allUserSessions.getUserSession(request, response);
        if (userSession.getAccountuser().isLoggedIn && userSession.getAccountuser().userCanDoAcl("ADDMEDIA", userSession.getAccount().getAccountid())){

            if(commandStr.equals("GetFolders")) {
                getFolders(userSession.getAccount().getAccountid(),root,document);
            } else if (commandStr.equals("GetFoldersAndFiles")) {
                getFolders(userSession.getAccount().getAccountid(),root,document);
                getFiles(userSession.getAccount().getAccountid(),root,document);
            } else if (commandStr.equals("CreateFolder")) {
    //            String newFolderStr=request.getParameter("NewFolderName");
    //            File newFolder=new File(currentDir,newFolderStr);
    //            String retValue="110";
    //
    //            if(newFolder.exists()){
    //                retValue="101";
    //            } else {
    //                try {
    //                    boolean dirCreated = newFolder.mkdir();
    //                    if(dirCreated)
    //                        retValue="0";
    //                    else
    //                        retValue="102";
    //                }catch(SecurityException sex) {
    //                    retValue="103";
    //                }
    //
    //            }
                String retValue = "103";
                setCreateFolderResponse(retValue,root,document);
            }
        }

        
        document.getDocumentElement().normalize();
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();

            DOMSource source = new DOMSource(document);

            StreamResult result = new StreamResult(out);
            transformer.transform(source, result);

            if (1==1) {
                //StreamResult dbgResult = new StreamResult(System.out);
                //transformer.transform(source, dbgResult);
                //reger.core.Debug.debug(3, "ConnectorServlet.java", "fckeditor output = " + source.toString());
            }
            reger.core.Debug.debug(3, "ConnectorServlet.java", "fckeditor End doGet");

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        out.flush();
        out.close();
    }


    /**
     * Manage the Post requests (FileUpload).<br>
     *
     * The servlet accepts commands sent in the following format:<br>
     * connector?Command=FileUpload&Type=ResourceType&CurrentFolder=FolderPath<br><br>
     * It store the file (renaming it in case a file with the same name exists) and then return an HTML file
     * with a javascript command in it.
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        reger.core.Debug.debug(3, "ConnectorServlet.java", "fckeditor doPost called");

        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Cache-Control","no-cache");
        PrintWriter out = response.getWriter();

        String commandStr=request.getParameter("Command");
        String typeStr=request.getParameter("Type");
        String currentFolderStr=request.getParameter("CurrentFolder");

        //String currentPath=baseDir+typeStr+currentFolderStr;
        //String currentDirPath=getServletContext().getRealPath(currentPath);
        String currentDirPath=AllSystemProperties.getProp("PATHUPLOADMEDIA");

        reger.core.Debug.debug(3, "ConnectorServlet.java", "fckeditor currentdirpath = " + currentDirPath);

        String retVal="0";
        String newName="";

        if(!commandStr.equals("FileUpload")){
            retVal="203";
        } else {
            //Reger.com work start
            reger.AllUserSessions allUserSessions = new reger.AllUserSessions();
            reger.UserSession userSession = allUserSessions.getUserSession(request, response);
            int localEventid = 0;
            if (userSession.getAccountuser().isLoggedIn && userSession.getAccountuser().userCanDoAcl("ADDMEDIA", userSession.getAccount().getAccountid())){
                reger.Upload ul = new reger.Upload(request);
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
                ul.save(localEventid, "", 0, userSession);
            } else {
                retVal = "203";
            }
            //Reger.com work end

//            DiskFileUpload upload = new DiskFileUpload();
//            try {
//                List items = upload.parseRequest(request);
//
//                Map fields=new HashMap();
//
//                Iterator iter = items.iterator();
//                while (iter.hasNext()) {
//                    FileItem item = (FileItem) iter.next();
//                    if (item.isFormField())
//                        fields.put(item.getFieldName(),item.getString());
//                    else
//                        fields.put(item.getFieldName(),item);
//                }
//                FileItem uplFile=(FileItem)fields.get("NewFile");
//                String fileNameLong=uplFile.getName();
//                fileNameLong=fileNameLong.replace('\\','/');
//                String[] pathParts=fileNameLong.split("/");
//                String fileName=pathParts[pathParts.length-1];
//
//                String nameWithoutExt=getNameWithoutExtension(fileName);
//                String ext=getExtension(fileName);
//                File pathToSave=new File(currentDirPath,fileName);
//                int counter=1;
//                while(pathToSave.exists()){
//                    newName=nameWithoutExt+"("+counter+")"+"."+ext;
//                    retVal="201";
//                    pathToSave=new File(currentDirPath,newName);
//                    counter++;
//                    }
//                uplFile.write(pathToSave);
//            }catch (Exception ex) {
//                retVal="203";
//            }

        }

        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.frames['frmUpload'].OnUploadCompleted("+retVal+",'"+newName+"');");
        out.println("</script>");
        out.flush();
        out.close();

        reger.core.Debug.debug(3, "ConnectorServlet.java", "fckeditor End doPost");

    }

    private void setCreateFolderResponse(String retValue,Node root,Document doc) {
        Element myEl=doc.createElement("Error");
        myEl.setAttribute("number",retValue);
        root.appendChild(myEl);
    }


    private void getFolders(int accountid, Node root,Document doc) {
        Element folders=doc.createElement("Folders");
        root.appendChild(folders);
//        File[] fileList=dir.listFiles();
//        for(int i=0;i<fileList.length;++i) {
//            if(fileList[i].isDirectory()){
//                Element myEl=doc.createElement("Folder");
//                myEl.setAttribute("name",fileList[i].getName());
//                folders.appendChild(myEl);
//            }
//        }
    }

    private void getFiles(int accountid,Node root,Document doc) {
        Element files = doc.createElement("Files");
        root.appendChild(files);
        //-----------------------------------
        //-----------------------------------
        String[][] rstImg= Db.RunSQL("SELECT imageid, originalfilename, sizeinbytes FROM image WHERE accountid='"+accountid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstImg!=null && rstImg.length>0){
            for(int i=0; i<rstImg.length; i++){
                Element myEl=doc.createElement("File");
                try{
                    String amp = java.net.URLEncoder.encode("&", "UTF-8");

                    String extension = reger.core.Util.getFilenameExtension(rstImg[i][1]);


                    //myEl.setAttribute("name","mediaout.log?imageid="+rstImg[i][0]+java.net.URLEncoder.encode("&", "UTF-8")+"name="+rstImg[i][1]);
                    //myEl.setAttribute("name","mediaout.log?imageid="+rstImg[i][0]);
                    myEl.setAttribute("name","mediaout.log?imageid="+rstImg[i][0]+"&file="+rstImg[i][1]);
                    myEl.setAttribute("size",""+Long.parseLong(rstImg[i][2])/1024);


                } catch (java.io.UnsupportedEncodingException ioex){
                    myEl.setAttribute("name","mediaout.log?imageid="+rstImg[i][0]);
                    myEl.setAttribute("size",""+Long.parseLong(rstImg[i][2])/1024);
                }
                files.appendChild(myEl);
            }
        }
    }

    private Node CreateCommonXml(Document doc,String commandStr, String typeStr,  String currentPath, String currentUrl ) {

        Element root=doc.createElement("Connector");
        doc.appendChild(root);
        root.setAttribute("command",commandStr);
        root.setAttribute("resourceType",typeStr);

        Element myEl=doc.createElement("CurrentFolder");
        myEl.setAttribute("path",currentPath);
        myEl.setAttribute("url",currentUrl);
        root.appendChild(myEl);

        return root;

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


}

