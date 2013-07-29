package reger;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import reger.Media.MediaType;
import reger.Media.MediaTypeFactory;
import reger.core.Debug;
import reger.core.RandomString;
import reger.core.Util;
import reger.core.db.Db;
import reger.util.Str;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * Handles multipart uploads via http.
 * Also manages to put all incoming request vars into a TreeMap called requestParams.
 * This way I can leverage the same TreeMap whether this is a multipart or not.
 */
public class UploadAjax extends HttpServlet {



    public boolean hasenoughfreespace = true;
    public TreeMap requestParams = new TreeMap();
    public int imageid = 0;
    public String filenameandpath = "";
    public String incomingname = "";
    public boolean issuccess=false;
    public int eventid = 0;


    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        //Loggers
        Logger logger = Logger.getLogger(this.getClass().getName());
        Debug.debug(5, "", "reger.UploadAjax - object created." + request.getRequestURL());

        //Pull up the userSession
        reger.AllUserSessions allUserSessions = new reger.AllUserSessions();
        reger.UserSession userSession = allUserSessions.getUserSession(request, response);

        try {

            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart){
                logger.debug("isMultipart=true");
            } else {
                throw new IllegalArgumentException("Request is not multipart, please 'multipart/form-data' enctype for your form.");
            }

            requestParams = reger.core.Util.requestToTreeMap(request);

            ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory());
            PrintWriter writer = response.getWriter();
            response.setContentType("application/json");
            JSONArray json = new JSONArray();
            try {
                List<FileItem> items = uploadHandler.parseRequest(request);
                for (FileItem item : items) {
                    if (!item.isFormField()) {

                            //Update the object's free image space measurement
                            userSession.getAccount().updateSpaceused();

                            //Now check to see if there's enough space to add this one
                            hasenoughfreespace = true;
                            if (userSession.getAccount().getMaxspaceinbytes()>0 && (item.getSize() + userSession.getAccount().getSpaceused()) > userSession.getAccount().getMaxspaceinbytes()){
                                hasenoughfreespace=false;
                            }

                            if (hasenoughfreespace) {

                                incomingname = item.getName();
                                //incomingname = incomingname.replaceAll("%2E", ".");
                                String path = "";
                                String incomingnamebase = reger.core.Util.getFilenameBase(incomingname);
                                String incomingnameext = reger.core.Util.getFilenameExtension(incomingname);
                                Debug.debug(4, "UploadAjax.java", "reger.UploadAjax.save() - incomingname=" + incomingname);

                                //Eventid
                                if (request.getParameter("eventid")!=null && Util.isinteger(request.getParameter("eventid"))){
                                    eventid=Integer.parseInt(request.getParameter("eventid"));
                                } else {
                                    eventid=0;
                                }

                                //Calculate the new dated directory name
                                Calendar cal = Calendar.getInstance();
                                int year = cal.get(Calendar.YEAR);
                                int month = cal.get(Calendar.MONTH)+1;
                                String monthStr = String.valueOf(month);
                                if (monthStr.length()==1){
                                    monthStr = "0"+monthStr;
                                }
                                String datedDirectoryName = year+ File.separator+monthStr;
                                path = datedDirectoryName;

                                path = FilenameUtils.normalize(path);
                                if (path==null || path.equals(File.separator)){
                                    path = "";
                                }

                                //Create directory
                                String filesdirectory = userSession.getAccount().getPathToAccountFiles() + path + File.separator;
                                File dir = new File(filesdirectory);
                                dir.mkdirs();
                                File dirThumbs = new File(filesdirectory+".thumbnails"+ File.separator);
                                dirThumbs.mkdirs();

                                //Test for file existence... if it exists does, add an incrementer
                                String finalfilename = incomingname;
                                File savedFile  = new File(filesdirectory, finalfilename);
                                int incrementer = 0;
                                while (savedFile.exists()){
                                    incrementer=incrementer+1;
                                    finalfilename = incomingnamebase+"-"+incrementer;
                                    if (!incomingnameext.equals("")){
                                        finalfilename = finalfilename + "." + incomingnameext;
                                    }
                                    savedFile  = new File(filesdirectory, finalfilename);
                                }



                                //Save to disk
                                item.write(savedFile);



                                //Create a thumbnail
                                ThumbnailCreator.createThumbnail(savedFile);
                                filenameandpath = path + File.separator+finalfilename;

                                //Resize to 1600
                                ResizeImage.resizeInPlace(savedFile.getAbsolutePath(), 1600);

                                //@todo Exif data extraction from image with http://www.drewnoakes.com/code/exif/ ???

                                int accountuserid = 0;
                                if (userSession!=null && userSession.getAccountuser()!=null){
                                    accountuserid = userSession.getAccountuser().getAccountuserid();
                                }

                                if(eventid>0){
                                    //-----------------------------------
                                    //-----------------------------------
                                    int identity = Db.RunSQLInsert("INSERT INTO image(eventid, image, sizeinbytes, imageorder, accountuserid, originalfilename, accountid, filename) VALUES('"+eventid+"', '"+reger.core.Util.cleanForSQL(path+ File.separator+finalfilename)+"', '"+item.getSize()+"', '"+ ImageOrder.getOrderForNewImage(eventid)+"', '"+accountuserid+"', '"+reger.core.Util.cleanForSQL(incomingname)+"', '"+userSession.getAccount().getAccountid()+"', '"+reger.core.Util.cleanForSQL(path+ File.separator+finalfilename)+"')");
                                    //-----------------------------------
                                    //-----------------------------------

                                    imageid = identity;

                                    Debug.debug(4, "UploadAjax.java", "reger.UploadAjax.save() - file written to database.");

                                    //Get a MediaType handler
                                    MediaType mt = MediaTypeFactory.getHandlerByFileExtension(incomingnameext);
                                    //Handle any parsing required
                                    mt.saveToDatabase(filesdirectory+finalfilename, imageid);

                                    reger.cache.EntryCache.flush(imageid);
                                }

                                //Update the AccountCounts cache
                                reger.cache.AccountCountCache.flushByAccountid(userSession.getAccount().getAccountid());


                                //Craft a witty response
                                JSONObject jsono = new JSONObject();
                                jsono.put("success", true);
                                jsono.put("name", finalfilename);
                                jsono.put("size", item.getSize());
                                //jsono.put("url", userSession.getAccount().getSiteRootUrl(userSession)+"/mediaout.log?imageid=" + imageid);
                                jsono.put("filelink", userSession.getAccount().getSiteRootUrl(userSession)+"/imageid/" + imageid);
                                jsono.put("thumbnail_url", userSession.getAccount().getSiteRootUrl(userSession)+"/mediaout.log?imageid=" + imageid+"&isthumbnail=yes");
                                json.add(jsono);
                                System.out.println(json.toString());


                            }

                    }
                }
            } catch (FileUploadException e) {
                    throw new RuntimeException(e);
            } catch (Exception e) {
                    throw new RuntimeException(e);
            } finally {
                if (request.getParameter("fineupload")!=null && request.getParameter("fineupload").equals("1")){
                    writer.write("{\"success\": true}");
                    writer.close();
                } else {
                    writer.write(json.toString());
                    writer.close();
                }
            }
        } catch (Exception e) {
            Debug.errorsave(e, "");
        }






    }

    private String getMimeType(File file) {
        String mimetype = "";
        if (file.exists()) {
            if (getSuffix(file.getName()).equalsIgnoreCase("png")) {
                mimetype = "image/png";
            }else if(getSuffix(file.getName()).equalsIgnoreCase("jpg")){
                mimetype = "image/jpg";
            }else if(getSuffix(file.getName()).equalsIgnoreCase("jpeg")){
                mimetype = "image/jpeg";
            }else if(getSuffix(file.getName()).equalsIgnoreCase("gif")){
                mimetype = "image/gif";
            }else {
                javax.activation.MimetypesFileTypeMap mtMap = new javax.activation.MimetypesFileTypeMap();
                mimetype  = mtMap.getContentType(file);
            }
        }
        return mimetype;
    }



    private String getSuffix(String filename) {
        String suffix = "";
        int pos = filename.lastIndexOf('.');
        if (pos > 0 && pos < filename.length() - 1) {
            suffix = filename.substring(pos + 1);
        }
        return suffix;
    }













}
