package reger.licensing;

import reger.core.licensing.License;

/**
 * Holds the static server license parameters
 */
public class ServerLicense {

    private static License serverLicense;
    private static boolean licenseAllowsCurrentApplicationVersion = false;

    public static License getLicense(){
        serverLicense = new License();
        return serverLicense;
//        if (serverLicense==null){
//            loadLicense();
//        }
//        return serverLicense;
    }


    private static void loadLicense(){
//        //-----------------------------------
//        //-----------------------------------
//        String[][] rstLic= Db.RunSQL("SELECT encryptedlicense FROM systemlicense ORDER BY systemlicenseid DESC LIMIT 0,1");
//        //-----------------------------------
//        //-----------------------------------
//        if (rstLic!=null && rstLic.length>0){
//            serverLicense = new License(null, rstLic[0][0]);
//        }
    }

    public static void setLicense(String encryptedlicense){
//        if (encryptedlicense!=null && !encryptedlicense.equals("")){
//            //-----------------------------------
//            //-----------------------------------
//            int identity = Db.RunSQLInsert("INSERT INTO systemlicense(encryptedlicense) VALUES('" + reger.core.Util.cleanForSQL(encryptedlicense) + "')");
//            //-----------------------------------
//            //-----------------------------------
//
//            //Load the new license
//            loadLicense();
//        }
    }

    public static boolean licenseAllowsCurrentApplicationVersion(){
        return true;
//        if (!licenseAllowsCurrentApplicationVersion){
//            //Make sure server license allows this version of the app.
//            //Upgrades are based on reger.versioninfo.
//            //If the user has an application that's been launched
//            //after their expiration date, they can't upgrade.
//            Version currentAppVersion = VersionInfo.getVersion(VersionInfo.getMaxVersionNumber());
//            if (getLicense()!=null){
//                try{
//                    Calendar expDate = reger.core.TimeUtils.dbstringtocalendar(getLicense().getProperty(License.PROPSTRINGEXPDATEGMT));
//                    if (expDate.before(currentAppVersion.getDeploymentDateGMT())){
//                        licenseAllowsCurrentApplicationVersion = false;
//                        return false;
//                    }
//                } catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//            licenseAllowsCurrentApplicationVersion = true;
//            return true;
//        }
//        licenseAllowsCurrentApplicationVersion = true;
//        return true;
    }

}
