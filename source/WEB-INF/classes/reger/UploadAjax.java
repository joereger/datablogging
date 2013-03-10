package reger;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import reger.Media.MediaType;
import reger.Media.MediaTypeFactory;
import reger.core.Debug;
import reger.core.Util;
import reger.core.db.Db;

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
public class UploadAjax {



    public boolean hasenoughfreespace = true;
    public TreeMap requestParams = new TreeMap();
    public int imageid = 0;
    public String filenameandpath = "";
    public String incomingname = "";
    public boolean issuccess=false;
    public int eventid = 0;

    public UploadAjax(){

    }

    public UploadAjax(javax.servlet.http.HttpServletRequest request, UserSession userSession){
        Logger logger = Logger.getLogger(this.getClass().getName());
        Debug.debug(5, "", "reger.UploadAjax - object created." + request.getRequestURL());

        try {

            requestParams = reger.core.Util.requestToTreeMap(request);
            incomingname = request.getHeader("X-File-Name");
            incomingname = incomingname.replaceAll("%2E", ".");
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



            Debug.debug(1, "UploadAjax.java", "reger.UploadAjax.save() - finalfilename="+finalfilename);

            Debug.debug(1, "UploadAjax.java", "reger.UploadAjax.save() - (first check)hasenoughfreespace=" + hasenoughfreespace);

            if (!incomingname.equals("") && hasenoughfreespace) {


                //Save file first then delete later if not enough free space
                InputStream is = null;
                FileOutputStream fos = null;
                try{
                    is = request.getInputStream();
                    fos = new FileOutputStream(savedFile);
                    //IOUtils.copy(is, fos);

                    try {
                        byte buf[]=new byte[1024];
                        int len;
                        while((len=is.read(buf))>0){
                            logger.debug("\nWriting.......");
                            fos.write(buf,0,len);
                        }
                        fos.close();
                        is.close();
                        logger.debug("\nFile is created.......");
                    }catch (IOException e){
                        Debug.errorsave(e, "UploadAjax.java");
                    } finally {
                        try {
                            fos.close();
                            is.close();
                        } catch (IOException ignored) {
                            Debug.errorsave(ignored, "UploadAjax.java");
                        }
                    }






                } catch (Exception ex){
                    Debug.errorsave(ex, "UploadAjax.java");
                } finally {
                    try {
                        fos.close();
                        is.close();
                    } catch (IOException ignored) {
                        Debug.errorsave(ignored, "UploadAjax.java");
                    }
                }

                Debug.debug(1, "UploadAjax.java", "reger.UploadAjax.save() - file written to filesystem");



                //Get media file size
                long mediafilesize = savedFile.length();

                //Update the object's free image space measurement
                userSession.getAccount().updateSpaceused();

                //Now check to see if there's enough space to add this one
                if (userSession.getAccount().getMaxspaceinbytes()>0 && ((long)mediafilesize + userSession.getAccount().getSpaceused()) > userSession.getAccount().getMaxspaceinbytes()){
                    hasenoughfreespace=false;
                }

                //reger.core.Util.logtodb("Just checked space.");

                Debug.debug(1, "UploadAjax.java", "reger.UploadAjax.save() - (second check)hasenoughfreespace=" + hasenoughfreespace);

                if (hasenoughfreespace) {

                    //Create a thumbnail
                    ThumbnailCreator.createThumbnail(savedFile);
                    filenameandpath = path+ File.separator+finalfilename;

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
                        int identity = Db.RunSQLInsert("INSERT INTO image(eventid, image, sizeinbytes, imageorder, accountuserid, originalfilename, accountid, filename) VALUES('"+eventid+"', '"+reger.core.Util.cleanForSQL(path+ File.separator+finalfilename)+"', '"+mediafilesize+"', '"+ ImageOrder.getOrderForNewImage(eventid)+"', '"+accountuserid+"', '"+reger.core.Util.cleanForSQL(incomingname)+"', '"+userSession.getAccount().getAccountid()+"', '"+reger.core.Util.cleanForSQL(path+ File.separator+finalfilename)+"')");
                        //-----------------------------------
                        //-----------------------------------

                        this.imageid = identity;

                        Debug.debug(4, "UploadAjax.java", "reger.UploadAjax.save() - file written to database.");

                        //Get a MediaType handler
                        MediaType mt = MediaTypeFactory.getHandlerByFileExtension(incomingnameext);
                        //Handle any parsing required
                        mt.saveToDatabase(filesdirectory+finalfilename, identity);

                        //Do the imagetags
                        //Tag.addMultipleTagsToImage(manyimagetags, identity);

                        reger.cache.EntryCache.flush(identity);
                    }

                    //Update the AccountCounts cache
                    reger.cache.AccountCountCache.flushByAccountid(userSession.getAccount().getAccountid());

                    issuccess=true;

                } else {
                    issuccess=false;
                    boolean fileDeleteSuccess = savedFile.delete();
                    if (!fileDeleteSuccess){
                        Debug.debug(1, "UploadAjax.java", "Delete FAIL, "+savedFile.getAbsolutePath());
                    }
                }

            }
        } catch (Exception e) {
            Debug.errorsave(e, "");
        }


        //One last update of image space
        userSession.getAccount().updateSpaceused();




    }


}
