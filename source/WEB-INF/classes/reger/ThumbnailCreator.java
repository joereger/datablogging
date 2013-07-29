package reger;

import reger.Media.MediaType;
import reger.Media.MediaTypeFactory;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

/**
 * Accepts a filename and creates a thumbnail in the proper directory
 */
public class ThumbnailCreator {


    public static void createThumbnail(File file){
        String filename = FilenameUtils.normalize(file.getAbsolutePath());
        String path = FilenameUtils.getPrefix(filename)+FilenameUtils.getPath(filename);
        String name = FilenameUtils.getName(filename);
        String extension = FilenameUtils.getExtension(filename);
        String thumbnailPath = path+".thumbnails/";

        reger.core.Debug.debug(5, "ThumbnailCreator.java", "createThumbnail("+filename+") called<br>name="+name+"<br>thumbnailpath:"+thumbnailPath+"<br>extension:"+extension);

        File dir = new File(thumbnailPath);
        dir.mkdirs();

        File thumbnail = new File(thumbnailPath+name);
        try{
            thumbnail.createNewFile();
        } catch (Exception e){
            reger.core.Debug.debug(3, "ThumbnailCreator.java", e);
        }
        if (thumbnail.canWrite()){
            reger.core.Debug.debug(3, "ThumbnailCreator.java", "thumbnail.canWrite("+filename+") true");
            //Get a MediaType handler
            MediaType mt = MediaTypeFactory.getHandlerByFileExtension(extension);
            //Generate a thumbnail
            mt.createThumbnail(file.getAbsolutePath(), thumbnail.getAbsolutePath());
        } else {
            reger.core.Debug.debug(3, "ThumbnailCreator.java", "thumbnail.canWrite("+filename+") false");
        }
    }


}
