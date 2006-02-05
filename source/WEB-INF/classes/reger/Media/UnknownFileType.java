package reger.Media;

import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles standard images.
 */
public class UnknownFileType implements MediaType {

    /**
     * Returns the proper mime type for this MediaType
     */
    public String getMimeType(){
        return "application/x-download";
    }

    /**
     * Creates a thumbnail for this media type and saves it to the thumbnail directory.
     */
    public void createThumbnail(String pathToFile, String pathToThumbnail) {
        try{
            //Copy a generic thumbnail over
            reger.core.Util.copyFile(reger.Vars.THUMBNAILGENERIC + "", pathToThumbnail);

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
        extensions[0]="*";
        return extensions;
    }

    /**
     * Gets the html required to display this file on the web.
     */
    public String getMediaOutHtml(HttpServletRequest request, reger.UserSession userSession) {
        return "<a href=\"mediaout.log?imageid="+request.getParameter("imageid")+"&isProfileImage="+request.getParameter("isProfileImage")+"\">Please Click Here.</a>";
    }

    /**
     * Deletes any data that goes with the file.  File is deleted elsewhere.
     */
    public void deleteData(int imageid) {

    }

}
