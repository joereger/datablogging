package reger.api;

import org.apache.xmlrpc.XmlRpcClientLite;

import java.util.Vector;

import reger.core.Debug;

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

                reger.Account acctTmp = reger.cache.AccountCache.get(accountid);

                urlhost="" + acctTmp.getSiteRootUrl() + "/";

                //Set the name
                String name;
                if ( !rstUserData[i][3].equals("") ) {
                    name=rstUserData[i][3];
                } else {
                    name=urlhost;
                }

                try {
                    //XmlRpcClientLite xmlrpc = new XmlRpcClientLite ("http://rpc.weblogs.com/RPC2");

                    XmlRpcClientLite xmlrpc = new XmlRpcClientLite ("http://rpc.pingomatic.com/");
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
                } catch (Exception e) {
                    Debug.errorsave(e, "");
                }
            }
        }

    }

}
