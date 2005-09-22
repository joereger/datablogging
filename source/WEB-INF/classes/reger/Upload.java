package reger;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import java.util.Iterator;
import java.util.List;
import java.util.Calendar;
import java.util.TreeMap;
import java.io.File;

import reger.Media.MediaType;
import reger.Media.MediaTypeFactory;
import reger.core.db.Db;
import reger.core.Debug;

/**
 * Handles multipart uploads via http.
 * Also manages to put all incoming request vars into a TreeMap called requestParams.
 * This way I can leverage the same TreeMap whether this is a multipart or not.
 */
public class Upload {

    public boolean isMultipart=false;
    public List items;
    public boolean hasenoughfreespace = true;
    public TreeMap requestParams = new TreeMap();

    public Upload(){

    }

    public Upload(javax.servlet.http.HttpServletRequest request){
        Debug.debug(5, "", "reger.Upload - object created." + request.getRequestURL());
        try{
            // Check that we have a file upload request
            isMultipart = FileUpload.isMultipartContent(request);
            //Only continue if we have a multipart message.
            //Multipart is the only point of this object.
            if (isMultipart) {
                Debug.debug(5, "", "reger.Upload - request determined to be multipart." + request.getRequestURL());

                //Create a diskupload object
                DiskFileUpload upload = new DiskFileUpload();
                // Parse this request by the handler.
                // This gives me a list of items from the request
                items = upload.parseRequest(request);
                Debug.debug(5, "", "reger.Upload - items.size()=" + items.size());

                //Find the non-file form fields that went with the upload
                Iterator myitr = items.iterator();
                while(myitr.hasNext()) {
                    Debug.debug(5, "", "reger.Upload - processing a file." + request.getRequestURL());
                    FileItem myitem = (FileItem) myitr.next();
                    //check if the current item is a form field
                    if(myitem.isFormField()) {
                        String fieldName = myitem.getFieldName();
                        String fieldValue = myitem.getString();
                        requestParams.put(fieldName, fieldValue);
                    }
                }
            } else {
                //Convert from request to TreeMap
                requestParams = reger.core.Util.requestToTreeMap(request);
            }

        } catch (Exception e){
            Debug.errorsave(e, "");
        }
    }

    public void save(int eventid, int accountuserid, reger.UserSession userSession){
        save(eventid, "", accountuserid, userSession);
    }

    public FileItem[] getFileItems(){
        FileItem[] out = new FileItem[0];
        try{
            if (items!=null){
                Debug.debug(5, "", "reger.Upload.save() - items!=null ");
                //Now go get the files
                Iterator itr = items.iterator();
                while(itr.hasNext()) {
                    Debug.debug(5, "", "reger.Upload.save() - found file item.");
                    FileItem item = (FileItem) itr.next();

                    //Make sure it's not a form field
                    if(!item.isFormField()) {
                        try {
                            out = reger.AddToArray.addToFileItemArray(out, item);
                        } catch (Exception e){
                            Debug.errorsave(e, "");
                        }
                    }
                }
            }
        } catch (Exception e){
            Debug.errorsave(e, "");
        }
        return out;
    }

    public void save(int eventid, String manyimagetags, int accountuserid, reger.UserSession userSession){
       Debug.debug(4, "Upload.java", "reger.Upload.save() - at top of method ");
       try{
            if (items!=null){
                Debug.debug(4, "Upload.java", "reger.Upload.save() - items!=null ");
                //Now go get the files
                Iterator itr = items.iterator();
                while(itr.hasNext()) {
                    Debug.debug(4, "Upload.java", "reger.Upload.save() - found file item.");
                    FileItem item = (FileItem) itr.next();

                    //Make sure it's not a form field
                    if(!item.isFormField()) {
                        try {

                            Debug.debug(4, "Upload.java", "reger.Upload.save() - not a form field.");

                            // The item must be an uploaded file... save it to disk. Note that there
                            // seems to be a bug in item.getName() as it returns the full path on
                            // the client's machine for the uploaded file name, instead of the file
                            // name only. To overcome that, I have used a workaround using
                            // fullFile.getName().
                            File fullFile  = new File(item.getName());
                            String incomingname = fullFile.getName();
                            String incomingnamebase = reger.core.Util.getFilenameBase(incomingname);
                            String incomingnameext = reger.core.Util.getFilenameExtension(incomingname);

                            Debug.debug(4, "Upload.java", "reger.Upload.save() - incomingname=" + incomingname);

                            //reger.core.Util.logtodb("incomingname=" + incomingname + "<br>incomingnamebase=" + incomingnamebase + "<br>incomingnameext=" + incomingnameext );

                            //Here's the file naming convention I'm using:
                            //(2003-10-23)18-43-32-accountid(76382)-eventid(6732234)-ver(incrementer)filename.ext
                            String stamp = reger.core.TimeUtils.dateformatfilestamp(Calendar.getInstance());
                            stamp=stamp+"-accountid("+userSession.getAccount().getAccountid()+")";
                            if (eventid>0){
                                stamp=stamp+"-eventid("+eventid+")";
                            }
                            if (accountuserid>0){
                                stamp=stamp+"-accountuserid("+accountuserid+")";
                            }
                            stamp=stamp+"-";
                            //Test for file existence... if it exists does, add an incrementer
                            File savedFile  = new File(reger.systemproperties.AllSystemProperties.getProp("PATHUPLOADMEDIA"), stamp+incomingname);
                            int incrementer = 0;
                            String incrementerstring="";
                            while (savedFile.exists()){
                                incrementer=incrementer+1;
                                incrementerstring="("+incrementer+")";
                                savedFile  = new File((String)reger.systemproperties.AllSystemProperties.getProp("PATHUPLOADMEDIA"), stamp+incomingnamebase+incrementerstring+"."+incomingnameext);
                            }
                            String finalfilename = stamp+incomingnamebase+incrementerstring+"."+incomingnameext;
                            Debug.debug(4, "Upload.java", "reger.Upload.save() - finalfilename="+finalfilename);

                            Debug.debug(4, "Upload.java", "reger.Upload.save() - (first check)hasenoughfreespace=" + hasenoughfreespace);

                            if (!incomingname.equals("") && hasenoughfreespace) {

                                //Get media file size
                                long mediafilesize = item.getSize();

                                //Update the object's free image space measurement
                                userSession.getAccount().updateSpaceused();

                                //Now check to see if there's enough space to add this one
                                if (userSession.getAccount().getMaxspaceinbytes()>0 && ((long)mediafilesize + userSession.getAccount().getSpaceused()) > userSession.getAccount().getMaxspaceinbytes()){
                                    hasenoughfreespace=false;
                                }

                                //reger.core.Util.logtodb("Just checked space.");

                                Debug.debug(4, "Upload.java", "reger.Upload.save() - (second check)hasenoughfreespace=" + hasenoughfreespace);

                                if (hasenoughfreespace) {

                                    //Do the actual file system write
                                    item.write(savedFile);

                                    //@todo Exif data extraction from image with http://www.drewnoakes.com/code/exif/ ???

                                    Debug.debug(4, "Upload.java", "reger.Upload.save() - file written to filesystem");

                                    //-----------------------------------
                                    //-----------------------------------
                                    int identity = Db.RunSQLInsert("INSERT INTO image(eventid, image, sizeinbytes, image.order, accountuserid, originalfilename) VALUES('"+eventid+"', '"+reger.core.Util.cleanForSQL(finalfilename)+"', '"+mediafilesize+"', '"+reger.ImageOrder.getOrderForNewImage(eventid)+"', '"+accountuserid+"', '"+reger.core.Util.cleanForSQL(incomingname)+"')");
                                    //-----------------------------------
                                    //-----------------------------------

                                    Debug.debug(4, "Upload.java", "reger.Upload.save() - file written to database.");

                                    //Get a MediaType handler
                                    MediaType mt = MediaTypeFactory.getHandlerByFileExtension(incomingnameext);
                                    //Generate a thumbnail
                                    mt.createThumbnail(reger.systemproperties.AllSystemProperties.getProp("PATHUPLOADMEDIA")+finalfilename, reger.systemproperties.AllSystemProperties.getProp("PATHUPLOADMEDIA")+"thumbnails/"+finalfilename, 100);
                                    //Handle any parsing required
                                    mt.saveToDatabase(reger.systemproperties.AllSystemProperties.getProp("PATHUPLOADMEDIA")+finalfilename, identity);

                                    //Do the imagetags
                                    reger.ImageTag.addMultipleTagsToImage(manyimagetags, identity);

                                    

                                    //Update the AccountCounts cache
                                    reger.cache.AccountCountCache.flushByAccountid(userSession.getAccount().getAccountid());

                                }


                            }
                        } catch (Exception e) {
                            Debug.errorsave(e, "");
                        }
                    }
                }

            }
            //One last update of image space
           userSession.getAccount().updateSpaceused();


        } catch (Exception e){
            Debug.errorsave(e, "");
        }

    }


}
