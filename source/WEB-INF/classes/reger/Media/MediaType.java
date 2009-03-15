package reger.Media;

/**
 * An interface to represent processing of things like .jpg, .mov, .hrm, etc.
 */
public interface MediaType {

    /**
     * Creates a thumbnail for this media type and saves it to the thumbnail directory.
     */
    public void createThumbnail(String pathToFile, String pathToThumbnail);

    /**
     * Parses the file, saving any additional data to the database.
     * The file must already be saved on the filesystem by the time
     * this is called.
     */
    public void saveToDatabase(String pathToFile, int imageid);

    /**
     * Returns a string array of file extensions that this media type will accept.
     */
    public String[] getAcceptableFileExtensions();

    /**
     * Gets the html required to display this file on the web.
     */
    public String getMediaOutHtml(javax.servlet.http.HttpServletRequest request, reger.UserSession userSession);

    /**
     * Deletes any data that goes with the file.  File is deleted elsewhere.
     */
    public void deleteData(int imageid);

    /**
     * Returns the proper mime type for this MediaType
     */
    public String getMimeType();

    public boolean setAsDownload();

}
