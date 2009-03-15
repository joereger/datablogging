package reger.Media;

import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;

/**
 * Handles standard images.
 */
public class QuicktimeMov implements MediaType {

    /**
     * Returns the proper mime type for this MediaType
     */
    public String getMimeType(){
        return "video/quicktime";
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

            reger.core.Util.copyFile(reger.core.WebAppRootDir.getWebAppRootPath() + "images\\mediatypeicons\\icon-quicktime.gif", pathToThumbnail);

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
        String[] extensions = new String[3];
        extensions[0]="mov";
        extensions[1]="qt";
        extensions[2]="m4v";
        return extensions;
    }

    /**
     * Gets the html required to display this file on the web.
     */
    public String getMediaOutHtml(HttpServletRequest request, reger.UserSession userSession) {
        String mediaouturl = "mediaout.log?imageid="+request.getParameter("imageid")+"&isProfileImage="+request.getParameter("isProfileImage")+"&entrykey="+request.getParameter("entrykey");
        StringBuffer mb = new StringBuffer();
        mb.append("<OBJECT CLASSID=\"clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B\" WIDTH=\"320\" HEIGHT=\"240\" CODEBASE=\"http://www.apple.com/qtactivex/qtplugin.cab\">");
        mb.append("<PARAM name=\"SRC\" VALUE=\""+mediaouturl+"\">");
        mb.append("<PARAM name=\"AUTOPLAY\" VALUE=\"true\">");
        mb.append("<PARAM name=\"CONTROLLER\" VALUE=\"true\">");
        mb.append("<EMBED SRC=\""+mediaouturl+"\" WIDTH=\"320\" HEIGHT=\"240\" AUTOPLAY=\"true\" CONTROLLER=\"true\" PLUGINSPAGE=\"http://www.apple.com/quicktime/download/\">");
        mb.append("</EMBED>");
        mb.append("</OBJECT>");
        return mb.toString();
    }

    /**
     * Deletes any special data that goes with the file.  File is deleted elsewhere.
     */
    public void deleteData(int imageid) {

    }

    public boolean setAsDownload() {
        return true;
    }

}
