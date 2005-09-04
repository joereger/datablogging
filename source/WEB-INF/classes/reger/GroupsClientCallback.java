package reger;

import reger.core.db.Db;
import reger.core.Debug;

import java.net.URL;
import java.util.Hashtable;

/**
 * The callback that gets the controlkey from the xmlgroups server
 */
public class GroupsClientCallback implements org.apache.xmlrpc.AsyncCallback {

    public void handleResult(Object o, URL url, String s) {
        Debug.debug(5, "", "GroupsClientCallback.handleResult<br>o=" + o.toString() + "<br>url=" + url.toString() + "<br>s=" + s);

        //Convert the result to a hashtable
        Hashtable result = (Hashtable)o;

        Integer groupid = new Integer(-1);
        int groupsubscriptionid = -1;
        if (result.get("groupid")!=null){
            groupid = (Integer)result.get("groupid");

            //Get some serverinformation using the groupid and the url
            //-----------------------------------
            //-----------------------------------
            String[][] rstGp= Db.RunSQL("SELECT groupsubscription.groupsubscriptionid FROM groupsubscription, groupserversubscription WHERE groupsubscription.groupserversubscriptionid=groupserversubscription.groupserversubscriptionid AND groupid='"+groupid.intValue()+"' AND serverurl='"+url.toString()+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstGp!=null && rstGp.length>0){
                for(int i=0; i<rstGp.length; i++){
                    groupsubscriptionid = Integer.parseInt(rstGp[i][0]);
                    Debug.debug(5, "", "Found groupsubscriptionid=" + groupsubscriptionid);
                }
            }
        }

        String controlkey = "";
        if (result.get("controlkey")!=null){
            controlkey = (String)result.get("controlkey");
        }

        String error = "";
        if (result.get("error")!=null){
            error = (String)result.get("error");
        }

        //Parse the eventid from the url
        String tmpA = "";
        String eventid = "";
        if (result.get("entryUrl")!=null){
            tmpA =  (String)result.get("entryUrl");
            if (!tmpA.equals("")){
                String[] tmpB = tmpA.split("entry-eventid");
                if (tmpB.length>1){
                    String[] tmpC = tmpB[1].split("-");
                    if (tmpC.length>1){
                        eventid = tmpC[0];
                        Debug.debug(5, "", "Found eventid=" + eventid);
                    }
                }
            }
        }


        //Can only do something if eventid is an int
        if (reger.core.Util.isinteger(eventid)){
            //If we have no error
            if (error.equals("") && groupsubscriptionid>0){
                //Store the control key
                //-----------------------------------
                //-----------------------------------
                int count = Db.RunSQLUpdate("UPDATE eventtogroup SET controlkey='"+reger.core.Util.cleanForSQL(controlkey)+"' WHERE eventid='"+eventid+"' AND groupsubscriptionid='"+groupsubscriptionid+"'");
                //-----------------------------------
                //-----------------------------------
            } else {
                //We had an error adding it.  Let's delete the record of it.
                //-----------------------------------
                //-----------------------------------
                int count = Db.RunSQLUpdate("DELETE FROM eventtogroup WHERE eventid='"+eventid+"' AND groupsubscriptionid='"+groupsubscriptionid+"'");
                //-----------------------------------
                //-----------------------------------
            }
        }

    }

    public void handleError(Exception e, URL url, String s) {
        Debug.errorsave(e, "", "GroupsClientCallback.handleResult<br>url=" + url.toString() + "<br>s=" + s);
    }


}
