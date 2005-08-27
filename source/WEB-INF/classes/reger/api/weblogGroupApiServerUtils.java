package reger.api;

import reger.core.db.Db;
import reger.core.db.Db;

/**
 * Group server utilities.
 */
public class weblogGroupApiServerUtils {

    private static String serverKey = null;
    private static String serverAdminKey = null;

    public static String getServerKey(){
        if (serverKey==null){
            //-----------------------------------
            //-----------------------------------
            String[][] rstKey= Db.RunSQL("SELECT serverkey, serveradminkey FROM groupserverkey ORDER BY groupserverkeyid DESC LIMIT 0,1");
            //-----------------------------------
            //-----------------------------------
            if (rstKey!=null && rstKey.length>0){
                serverKey = rstKey[0][0];
                serverAdminKey = rstKey[0][1];
            } else {
                //A serverkey hasn't yet been created for this server
                String tmpKey = reger.core.RandomString.randomAlphanumeric(10);
                String tmpAdminKey = reger.core.RandomString.randomAlphanumeric(10);
                //-----------------------------------
                //-----------------------------------
                int identity = Db.RunSQLInsert("INSERT INTO groupserverkey(serverkey, serveradminkey) VALUES('"+reger.core.Util.cleanForSQL(tmpKey)+"', '"+reger.core.Util.cleanForSQL(tmpAdminKey)+"')");
                //-----------------------------------
                //-----------------------------------
                serverKey = tmpKey;
                serverAdminKey = tmpAdminKey;
            }
        }
        return serverKey;
    }

    public static String getServerAdminKey(){
        if (serverAdminKey==null){
            //-----------------------------------
            //-----------------------------------
            String[][] rstKey= Db.RunSQL("SELECT serverkey, serveradminkey FROM groupserverkey ORDER BY groupserverkeyid DESC LIMIT 0,1");
            //-----------------------------------
            //-----------------------------------
            if (rstKey!=null && rstKey.length>0){
                serverKey = rstKey[0][0];
                serverAdminKey = rstKey[0][1];
            } else {
                //A serverkey hasn't yet been created for this server
                String tmpKey = reger.core.RandomString.randomAlphanumeric(10);
                String tmpAdminKey = reger.core.RandomString.randomAlphanumeric(10);
                //-----------------------------------
                //-----------------------------------
                int identity = Db.RunSQLInsert("INSERT INTO groupserverkey(serverkey, serveradminkey) VALUES('"+reger.core.Util.cleanForSQL(tmpKey)+"', '"+reger.core.Util.cleanForSQL(tmpAdminKey)+"')");
                //-----------------------------------
                //-----------------------------------
                serverKey = tmpKey;
                serverAdminKey = tmpAdminKey;
            }
        }
        return serverAdminKey;
    }


}
