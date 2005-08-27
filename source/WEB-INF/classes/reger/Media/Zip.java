package reger.Media;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles standard images.
 */
public class Zip implements MediaType {

    /**
     * Returns the proper mime type for this MediaType
     */
    public String getMimeType(){
        return "application/zip";
    }

    /**
     * Creates a thumbnail for this media type and saves it to the thumbnail directory.
     */
    public void createThumbnail(String pathToFile, String pathToThumbnail, int imageid) {
        try{
            reger.core.Util.copyFile(reger.core.WebAppRootDir.getWebAppRootPath() + "images\\mediatypeicons\\icon-zip.gif", pathToThumbnail);
        } catch (Throwable e) {
            reger.core.Util.errorsave(e);
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
        extensions[0]="zip";
        return extensions;
    }

    /**
     * Gets the html required to display this file on the web.
     */
    public String getMediaOutHtml(HttpServletRequest request, reger.UserSession userSession) {
        StringBuffer out = new StringBuffer();

        out.append("<a href=\"mediaout.log?imageid="+request.getParameter("imageid")+"&isProfileImage="+request.getParameter("isProfileImage")+"&entrykey="+request.getParameter("entrykey")+"\">Please Click Here.</a>");

        return out.toString();
    }

    /**
     * Deletes any data that goes with the file.  File is deleted elsewhere.
     */
    public void deleteData(int imageid) {

    }

}
