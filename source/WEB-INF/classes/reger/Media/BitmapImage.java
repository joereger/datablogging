package reger.Media;

import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles standard images.
 */
public class BitmapImage implements MediaType {

    /**
     * Returns the proper mime type for this MediaType
     */
    public String getMimeType(){
        return "image/bmp";
    }

    /**
     * Creates a thumbnail for this media type and saves it to the thumbnail directory.
     */
    public void createThumbnail(String pathToFile, String pathToThumbnail, int imageid) {
        try{
            //Just a general thumbnail
            reger.ResizeImage.resize(pathToFile, pathToThumbnail, 100);
        } catch (Throwable e) {
            Debug.errorsave(e, "");
        }
    }

    /**
     * Parses the file, saving any additional data to the database.
     * The file must already be saved on the filesystem by the time
     * this is called.
     */
    public void saveToDatabase(String pathToFile, int imageid) {
        //Nothing special to do here.
    }

    /**
     * Returns a string array of file extensions that this media type will accept.
     */
    public String[] getAcceptableFileExtensions() {
        String[] extensions = new String[1];
        extensions[0]="bmp";
        return extensions;
    }

    /**
     * Gets the html required to display this file on the web.
     */
    public String getMediaOutHtml(HttpServletRequest request, reger.UserSession userSession) {
        String mediaouturl = "mediaout.log?imageid="+request.getParameter("imageid")+"&isProfileImage="+request.getParameter("isProfileImage")+"&entrykey="+request.getParameter("entrykey");
        return "<img src='"+mediaouturl+"' border=0 alt=''>";
    }

    /**
     * Deletes any data that goes with the file.  File is deleted elsewhere.
     */
    public void deleteData(int imageid) {

    }



}
