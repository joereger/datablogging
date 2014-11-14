package reger;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

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
    public int imageid = 0;
    public String filenameandpath = "";

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
        save(eventid, "", accountuserid, userSession, "");
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

    public void save(int eventid, String manyimagetags, int accountuserid, reger.UserSession userSession, String path){
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

                            if (path.equals("")){
                                //Calculate the new dated directory name
                                Calendar cal = Calendar.getInstance();
                                int year = cal.get(Calendar.YEAR);
                                int month = cal.get(Calendar.MONTH)+1;
                                String monthStr = String.valueOf(month);
                                if (monthStr.length()==1){
                                    monthStr = "0"+monthStr;
                                }
                                String datedDirectoryName = year+java.io.File.separator+monthStr;
                                path = datedDirectoryName;
                            }

                            path = FilenameUtils.normalize(path);
                            if (path==null || path.equals(java.io.File.separator)){
                                path = "";
                            }


                            //Create directory
                            String filesdirectory = userSession.getAccount().getPathToAccountFiles() + path + java.io.File.separator;
                            File dir = new File(filesdirectory);
                            dir.mkdirs();
                            File dirThumbs = new File(filesdirectory+".thumbnails"+java.io.File.separator);
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


                                Debug.debug(4, "Upload.java", "reger.Upload.save() - (second check)hasenoughfreespace=" + hasenoughfreespace);

                                if (hasenoughfreespace) {

                                    //Do the actual file system write
                                    item.write(savedFile);
                                    ThumbnailCreator.createThumbnail(savedFile);
                                    filenameandpath = path+java.io.File.separator+finalfilename;

                                    //Resize to 1600
                                    if (incomingname.indexOf("gif")==-1){
                                        ResizeImage.resizeInPlace(savedFile.getAbsolutePath(), 1600);
                                    }

                                    //@todo Exif data extraction from image with http://www.drewnoakes.com/code/exif/ ???

                                    Debug.debug(4, "Upload.java", "reger.Upload.save() - file written to filesystem");

                                    if(eventid>0){
                                        //-----------------------------------
                                        //-----------------------------------
                                        int identity = Db.RunSQLInsert("INSERT INTO image(eventid, image, sizeinbytes, imageorder, accountuserid, originalfilename, accountid, filename) VALUES('"+eventid+"', '"+reger.core.Util.cleanForSQL(path+java.io.File.separator+finalfilename)+"', '"+mediafilesize+"', '"+reger.ImageOrder.getOrderForNewImage(eventid)+"', '"+accountuserid+"', '"+reger.core.Util.cleanForSQL(incomingname)+"', '"+userSession.getAccount().getAccountid()+"', '"+reger.core.Util.cleanForSQL(path+java.io.File.separator+finalfilename)+"')");
                                        //-----------------------------------
                                        //-----------------------------------

                                        this.imageid = identity;

                                        Debug.debug(4, "Upload.java", "reger.Upload.save() - file written to database.");

                                        //Get a MediaType handler
                                        MediaType mt = MediaTypeFactory.getHandlerByFileExtension(incomingnameext);
                                        //Handle any parsing required
                                        mt.saveToDatabase(filesdirectory+finalfilename, identity);

                                        //Do the imagetags
                                        reger.Tag.addMultipleTagsToImage(manyimagetags, identity);
                                    }

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
