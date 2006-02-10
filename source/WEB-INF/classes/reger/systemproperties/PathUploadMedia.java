package reger.systemproperties;

import reger.core.SystemProperty;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PathUploadMedia extends SystemProperty{

    public PathUploadMedia(){
        setPropertyName("PATHUPLOADMEDIA");
        setPropertyDefault("");
        setPropertyValue("");
        setPropertyDescription("This is the directory where the files that users upload to their blog entries are stored.  Choose a directory that is off of the web root so that files aren't deleted when upgrades are deployed. Note: be sure to include the trailing slash.  Example: 'c:/blogserver-userdata/'");
        load();
        if (getPropertyValue().equals("")){
            setPropertyValue(chooseDefaultPathByExaminingSystemDefault());
            setPropertyDefault(chooseDefaultPathByExaminingSystemDefault());
        }
        checkPath();
        save();
        load();
    }

    private String chooseDefaultPathByExaminingSystemDefault(){
        //Find default dir
        File chosenFile = new File("", "blogserver-data" + File.separator);
        String defPath = chosenFile.getAbsolutePath();
        chosenFile = null;
        reger.core.Debug.debug(5, "PathUploadMedia.java", "Default value chosen by going to system root:" + defPath);
        return defPath;
    }

    public void save(){
        reger.core.Debug.debug(5, "PathUploadMedia.java", "save() overload called.");

        String tmpOut = propertyValue;
        reger.core.Debug.debug(5, "PathUploadMedia.java", "tmpOut=" + tmpOut);


        //Clean up the path
        tmpOut = reger.core.Util.cleanDirectorySlashesUseSystemFileSeparator(tmpOut);
        reger.core.Debug.debug(5, "PathUploadMedia.java", "tmpOut after cleanup=" + tmpOut);

        //Make sure there's a slash on it
        reger.core.Debug.debug(5, "PathUploadMedia.java", "tmpOut.substring(tmpOut.length()-1, tmpOut.length())=" + tmpOut.substring(tmpOut.length()-1, tmpOut.length()));
        if (!tmpOut.substring(tmpOut.length()-1, tmpOut.length()).equals(File.separator)){
            tmpOut=tmpOut + File.separator;
            reger.core.Debug.debug(5, "PathUploadMedia.java", "tmpOut after putting a slash at end=" + tmpOut);
        } else {
            reger.core.Debug.debug(5, "PathUploadMedia.java", "tmpOut did not need a slash added:" + tmpOut);
        }

        //Set the value
        propertyValue=tmpOut;

        //Now call the original save()
        super.save();
    }

    private void checkPath(){
        try{
            File testDir = new File(getPropertyValue(), "");
            if (testDir !=null && testDir.exists() && testDir.canRead() && testDir.isDirectory() && testDir.canWrite()){
                //Do nothing, the directory is good
                reger.core.Debug.debug(5, "PathUploadMedia.java", "Directory exists:" + getPropertyValue());
            } else {
                //Try to create it
                reger.core.Debug.debug(5, "PathUploadMedia.java", "Directory does not exist:" + getPropertyValue() + "<br>Will try to create.");
                if (!createDir(getPropertyValue())){
                    //Choose a default value from the system root
                    reger.core.Debug.debug(5, "PathUploadMedia.java", "Unable to create:" + getPropertyValue());
                } else {
                    //Successfully created dir
                    reger.core.Debug.debug(5, "PathUploadMedia.java", "Successfully created:" + getPropertyValue());
                }
            }

            //Now check on on the thumbnails path
            //checkThumbnailsPath();
        } catch (Exception e){
            e.printStackTrace();
        }
        reger.core.Debug.debug(5, "PathUploadMedia.java", "PathUploadMedia.getPropertyValue()=" + getPropertyValue());
    }

//    private void checkThumbnailsPath(){
//        try{
//            File testDir = new File(getPropertyValue()+File.separator+"thumbnails", "");
//            if (testDir !=null && testDir.exists() && testDir.canRead() && testDir.isDirectory() && testDir.canWrite()){
//                //Do nothing, the directory is good
//                reger.core.Debug.debug(5, "PathUploadMedia.java", "Thumbnails directory is OK.");
//            } else {
//                //Try to create it
//                if (!createDir(getPropertyValue()+File.separator+"thumbnails")){
//                    //Nothing to do... couldn't create
//                    reger.core.Debug.debug(5, "PathUploadMedia.java", "Could not create thumbnails directory:" + getPropertyValue()+File.separator+"thumbnails");
//                } else {
//                    reger.core.Debug.debug(5, "PathUploadMedia.java", "Created thumbnails directory:" + getPropertyValue()+File.separator+"thumbnails");
//                }
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    private boolean createDir(String path){
        try{
            reger.core.Debug.debug(5, "PathUploadMedia.java", "createDir("+path+") called.");
            return (new File(path)).mkdirs();
        } catch (Exception e){
            return false;
        }
    }

}
