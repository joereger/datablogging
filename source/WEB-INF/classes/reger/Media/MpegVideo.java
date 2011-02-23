package reger.Media;

import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles standard images.
 */
public class MpegVideo implements MediaType {

    /**
     * Returns the proper mime type for this MediaType
     */
    public String getMimeType(){
        return "video/mpeg";
    }

    /**
     * Creates a thumbnail for this media type and saves it to the thumbnail directory.
     */
    public void createThumbnail(String pathToFile, String pathToThumbnail) {
        try{
            //Simply copies the default thumbnail
            //@todo http://java.sun.com/developer/qow/archive/71/index.html
            //@todo http://java.sun.com/products/java-media/jmf/2.1.1/solutions/Cut.html
            //@todo http://java.sun.com/products/java-media/jmf/2.1.1/solutions/Split.java

            reger.core.Util.copyFile(reger.core.WebAppRootDir.getWebAppRootPath() + "images/mediatypeicons/icon-video.gif", pathToThumbnail);

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
        String[] extensions = new String[2];
        extensions[0]="mpg";
        extensions[1]="mpeg";
        return extensions;
    }

    /**
     * Gets the html required to display this file on the web.
     */
    public String getMediaOutHtml(HttpServletRequest request, reger.UserSession userSession) {
        String mediaouturl = "mediaout.log?imageid="+request.getParameter("imageid")+"&isProfileImage="+request.getParameter("isProfileImage")+"&entrykey="+request.getParameter("entrykey");
        StringBuffer mb = new StringBuffer();
        mb.append("<EMBED SRC=\""+mediaouturl+"\" AUTOSTART=true></EMBED>");
        return mb.toString();
    }

    /**
     * Deletes any data that goes with the file.  File is deleted elsewhere.
     */
    public void deleteData(int imageid) {

    }

    public boolean setAsDownload() {
        return true;
    }

}
