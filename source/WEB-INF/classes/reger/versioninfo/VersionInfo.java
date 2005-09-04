package reger.versioninfo;

import reger.AddToArray;
import reger.core.Debug;


/**
 * Controls access to the list of versions.
 */
public class VersionInfo {

    //Current running version
    private static String CURRENTVERSIONNAME;
    private static int CURRENTVERSIONID=0;


    public static int getMaxVersionNumber(){
        Debug.debug(5, "", "VersionInfo.java - Trying to get maxVersionNumber.");
        //Calculate the max version that exists
        int maxVer = 0;
        while(true){
            maxVer = maxVer + 1;
            try{
                //Try to create an object
                Version ver = (Version)(Class.forName("reger.versioninfo.Version"+maxVer).newInstance());
            } catch (ClassNotFoundException ex){
                //If class isn't found, break
                Debug.debug(5, "", "VersionInfo.java - Class reger.versioninfo.Version"+maxVer+" not found.");
                Debug.debug(5, "", "VersionInfo.java - Returning maxVer=" + (maxVer-1));
                return maxVer - 1;
            } catch (Throwable e){
                Debug.debug(5, "", e);
                break;
            }

        }
        Debug.debug(5, "", "VersionInfo.java - Returning maxVer=" + (maxVer-1));
        return maxVer-1;
    }

    public static Version getVersion(int versionid){
        Debug.debug(5, "", "VersionInfo.java - Trying to get version=" + versionid);
        try{
            //Try to create an object
            Version ver = (Version)(Class.forName("reger.versioninfo.Version"+versionid).newInstance());
            Debug.debug(5, "", "VersionInfo.java - Found version=" + versionid);
            return ver;
        } catch (Throwable e){
            Debug.debug(5, "", e);
        }
        Debug.debug(5, "", "VersionInfo.java - version=" + versionid + " not found.");
        return null;
    }



    public static Version[] getAllVersions(){
        Version[] versions = new Version[0];
        int maxVer = 0;
        while(true){
            maxVer = maxVer + 1;
            try{
                //Try to create an object
                Version ver = (Version)(Class.forName("reger.versioninfo.Version"+maxVer).newInstance());
                versions = AddToArray.addToVersionArray(versions, ver);
            } catch (ClassNotFoundException ex){
                //If class isn't found, break
                break;
            } catch (Throwable e){
                Debug.debug(5, "", e);
                break;
            }
        }
        return versions;
    }


    public static String getCURRENTVERSIONNAME() {
        if (CURRENTVERSIONNAME==null || CURRENTVERSIONNAME.equals("")){
            CURRENTVERSIONNAME = getVersion(reger.versioninfo.VersionInfo.getMaxVersionNumber()).getVersionName();
        }
        return CURRENTVERSIONNAME;
    }

    public static int getCURRENTVERSIONID() {
        if (CURRENTVERSIONID==0){
            CURRENTVERSIONID = getMaxVersionNumber();
        }
        return CURRENTVERSIONID;
    }


}
