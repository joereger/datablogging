package reger.api;

import org.apache.xmlrpc.XmlRpcClientLite;

import java.util.Vector;

/**
 * Pings weblogs.com
 */
public class WebLogsComPing {


    public static void ping(int accountid){

        //Get user data for weblogs.com
        //-----------------------------------
        //-----------------------------------
        String[][] rstUserData= reger.core.db.Db.RunSQL("SELECT pingweblogscom, customservername, accounturl, homepagetitle FROM account WHERE accountid='"+ accountid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstUserData!=null && rstUserData.length>0){
            for(int i=0; i<rstUserData.length; i++){

                //Get the URL
                String urlhost;
                String baseSiteUrl = reger.Account.getSiteRootUrlViaAccountid(accountid);
                urlhost="" +reger.Vars.getHttpUrlPrefix() + baseSiteUrl + "/";

                //Set the name
                String name;
                if ( !rstUserData[i][3].equals("") ) {
                    name=rstUserData[i][3];
                } else {
                    name=urlhost;
                }

                try {
                    XmlRpcClientLite xmlrpc = new XmlRpcClientLite ("http://rpc.weblogs.com/RPC2");
                    Vector params = new Vector ();
                    params.addElement (name);
                    params.addElement (urlhost);
                    //Sync call
                    //Hashtable result = (Hashtable) xmlrpc.execute("weblogUpdates.ping", params);
                    //Async Call
                    xmlrpc.executeAsync("weblogUpdates.ping", params, null);
                    //String resultStr="";
                    //for ( Enumeration e = result.keys() ; e.hasMoreElements() ; ) {
                        //String key = (String)e.nextElement();
                        //resultStr=resultStr+">>key=" + key + " - value=" + result.get(key).toString();
                    //}

                    //reger.core.Util.logtodb("weblogs.com ping result: " + resultStr);
                } catch (Exception e) {
                    reger.core.Util.errorsave(e);
                }
            }
        }

    }

}
