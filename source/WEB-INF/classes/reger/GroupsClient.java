package reger;

import org.apache.xmlrpc.XmlRpcClient;

import java.util.Calendar;
import java.util.Vector;
import java.util.Hashtable;

import reger.core.db.Db;

/**
 * The client side of the Groups API.
 */
public class GroupsClient {

    public static Hashtable editGroup(String serverUrl, String groupAdminKey, int groupid, String groupName, String groupDescription, boolean viewingEntriesRequiresGroupKey, boolean addingEntriesRequiresGroupKey, String newGroupKey, String newGroupAdminKey){
        try {
            XmlRpcClient xmlrpc = new XmlRpcClient (serverUrl);
            Vector params = new Vector();
            params.addElement (groupAdminKey);
            params.addElement (new Integer(groupid));
            params.addElement (groupName);
            params.addElement (groupDescription);
            params.addElement (new Boolean(viewingEntriesRequiresGroupKey));
            params.addElement (new Boolean(addingEntriesRequiresGroupKey));
            params.addElement (newGroupKey);
            params.addElement (newGroupAdminKey);
            return (Hashtable) xmlrpc.execute ("weblogGroup.editGroupDetails", params);
        } catch (Exception e){
            reger.core.Util.debug(5, e);
        }
        return new Hashtable();
    }


    public static boolean testGroupKey(int groupid, String groupKey, String serverUrl){
        //Test validity of the groupKey
        boolean groupKeyIsValid = false;
        if (!groupKey.equals("")){
            try {
                XmlRpcClient xmlrpc = new XmlRpcClient (serverUrl);
                Vector params = new Vector();
                params.addElement (groupKey);
                params.addElement (new Integer(groupid));
                groupKeyIsValid = ((Boolean) xmlrpc.execute ("weblogGroup.testGroupKey", params)).booleanValue();
            } catch (Exception e){
                reger.core.Util.debug(5, e);
            }
        }
        return groupKeyIsValid;
    }

    public static boolean testGroupAdminKey(int groupid, String groupAdminKey, String serverUrl){
        //Test validity of the groupKey
        boolean groupAdminKeyIsValid = false;
        if (!groupAdminKey.equals("")){
            try {
                XmlRpcClient xmlrpc = new XmlRpcClient (serverUrl);
                Vector params = new Vector();
                params.addElement (groupAdminKey);
                params.addElement (new Integer(groupid));
                groupAdminKeyIsValid = ((Boolean) xmlrpc.execute ("weblogGroup.testGroupAdminKey", params)).booleanValue();
            } catch (Exception e){
                reger.core.Util.debug(5, e);
            }
        }
        return groupAdminKeyIsValid;
    }

    public static void editServerInfo(){

    }


    public static void addEntryToGroups(int eventid, int[] groupsubscriptionids, int accountuserid){

        if (groupsubscriptionids==null){
            groupsubscriptionids = new int[0];
        }

        //Get a list of groupsubscriptionids that have already been sent over XML to groups server for this eventid
        int[] alreadyAdded = new int[0];
        //-----------------------------------
        //-----------------------------------
        String[][] rstGroupCalls= Db.RunSQL("SELECT groupsubscriptionid FROM eventtogroup WHERE eventid='"+eventid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstGroupCalls!=null && rstGroupCalls.length>0){
            for(int i=0; i<rstGroupCalls.length; i++){
                alreadyAdded = reger.core.Util.addToIntArray(alreadyAdded, Integer.parseInt(rstGroupCalls[i][0]));
            }
        }

        //Get a list of all groupsubscriptionids that this accountuserid subscribes to
        int[] allGroupsubscriptions = new int[0];
        //-----------------------------------
        //-----------------------------------
        String[][] rstAll= Db.RunSQL("SELECT groupsubscriptionid FROM groupsubscription WHERE accountuserid='"+accountuserid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstAll!=null && rstAll.length>0){
            for(int i=0; i<rstAll.length; i++){
                allGroupsubscriptions = reger.core.Util.addToIntArray(allGroupsubscriptions, Integer.parseInt(rstAll[i][0]));
            }
        }


        //Iterate all groupsubscriptionids and figure out which ones need to be added to xml server and Db
        for (int i = 0; i < allGroupsubscriptions.length; i++) {
            //Figure out the user's intention
            boolean userWantsAddedToGroup = false;
            for (int j = 0; j < groupsubscriptionids.length && !userWantsAddedToGroup; j++) {
                if (groupsubscriptionids[j]==allGroupsubscriptions[i]){
                    userWantsAddedToGroup = true;
                }
            }

            //Determine whether this groupsubscriptionid has been added to Db yet
            boolean isInDbAlready = false;
            for (int j = 0; j < alreadyAdded.length && !isInDbAlready; j++) {
                if (alreadyAdded[j]==allGroupsubscriptions[i]){
                    isInDbAlready = true;
                }
            }

            //Only call xml and add to Db if it hasn't been done yet
            if (userWantsAddedToGroup && !isInDbAlready){
                xmlCallGroupServerAddEntryToGroup(allGroupsubscriptions[i], eventid);
                addToEventToGroupTable(eventid, allGroupsubscriptions[i]);
            }

            //Only delete if user doesn't want entry in group but it is in Db
            if (!userWantsAddedToGroup && isInDbAlready){
                xmlCallGroupServerRemoveEntry(allGroupsubscriptions[i], eventid);
                deleteFromEventToGroupTable(eventid, allGroupsubscriptions[i]);
            }

        }

    }

    private static void deleteFromEventToGroupTable(int eventid, int groupsubscriptionid){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM eventtogroup WHERE eventid='"+eventid+"' AND groupsubscriptionid='"+groupsubscriptionid+"'");
        //-----------------------------------
        //-----------------------------------
    }

    private static void addToEventToGroupTable(int eventid, int groupsubscriptionid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstCheck= Db.RunSQL("SELECT eventtogroupid FROM eventtogroup WHERE eventid='"+eventid+"' AND groupsubscriptionid='"+groupsubscriptionid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstCheck!=null && rstCheck.length>0){
        	for(int i=0; i<rstCheck.length; i++){
        	    //Already exists, do nothing
        	}
        } else {
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO eventtogroup(eventid, groupsubscriptionid) VALUES('"+eventid+"', '"+groupsubscriptionid+"')");
            //-----------------------------------
            //-----------------------------------
        }
    }

    private static void xmlCallGroupServerAddEntryToGroup(int groupsubscriptionid, int eventid){
        //Get some details from this event
        String title = "";
        Calendar cal = Calendar.getInstance();
        String comments = "";
        int accountuserid = -1;
        int accountid = -1;
        //-----------------------------------
        //-----------------------------------
        String[][] rstEvent= Db.RunSQL("SELECT title, date, comments, accountuserid, event.accountid, logaccess, entrykey FROM event, megalog WHERE eventid='"+eventid+"' AND event.logid=megalog.logid");
        //-----------------------------------
        //-----------------------------------
        if (rstEvent!=null && rstEvent.length>0){
            title = rstEvent[0][0];
            cal = reger.core.TimeUtils.dbstringtocalendar(rstEvent[0][1]);
            comments = rstEvent[0][2];
            if (reger.core.Util.isinteger(rstEvent[0][3])){
                accountuserid = Integer.parseInt(rstEvent[0][3]);
            }
            if (reger.core.Util.isinteger(rstEvent[0][4])){
                accountid = Integer.parseInt(rstEvent[0][4]);
            }
            //Create the entryKey if needed
            reger.core.Util.debug(5, "rstEvent[0][5]=" + rstEvent[0][5]);
            if (Integer.parseInt(rstEvent[0][5])==reger.Vars.LOGACCESSPRIVATE){
                  String tmpEntryKey = reger.Entry.getEntryKeyCreateOneIfNecessary(eventid);
                  reger.core.Util.debug(5, "entrykey=" + tmpEntryKey);
            }
        }

        //Get author info
        String author = "";
        String authorurl = "";
        if (accountuserid>0){
            reger.Accountuser au = new reger.Accountuser(accountid, accountuserid);
            author = au.getFriendlyname();
            authorurl = "http://"+au.getSiteRootUrl()+"/author.log?accountuserid=" + accountuserid;  
        }

        //Get the server info
        String serverurl = "";
        int groupid = -1;
        String groupkey = "";
        //-----------------------------------
        //-----------------------------------
        String[][] rstServer= Db.RunSQL("SELECT serverurl, groupid, groupkey FROM groupserversubscription, groupsubscription WHERE groupsubscription.groupsubscriptionid='"+groupsubscriptionid+"' AND groupsubscription.groupserversubscriptionid=groupserversubscription.groupserversubscriptionid");
        //-----------------------------------
        //-----------------------------------
        if (rstServer!=null && rstServer.length>0){
        	for(int i=0; i<rstServer.length; i++){
        	    groupkey = rstServer[i][2];
                serverurl = rstServer[i][0];
                groupid = Integer.parseInt(rstServer[i][1]);
        	}
        }

        //Build the xml call
        //String entryUrl, String entryTitle, String entryExtract, int groupid
        try{
            XmlRpcClient xmlrpc = new XmlRpcClient (serverurl);
            Vector params = new Vector();
            params.addElement (groupkey);
            params.addElement (reger.Entry.entryCompleteUrl(eventid, true));
            params.addElement (title);
            params.addElement (reger.core.Util.truncateString(comments, 255));
            params.addElement (author);
            params.addElement (authorurl);
            params.addElement (new Integer(groupid));
            xmlrpc.executeAsync("weblogGroup.addEntryToGroup", params, new reger.GroupsClientCallback());
        } catch (Exception e) {
            reger.core.Util.errorsave(e, "Failed XML Groups Client call.");
        }
    }

    private static void xmlCallGroupServerRemoveEntry(int groupsubscriptionid, int eventid){

        //Get the server info
        String serverurl = "";
        int groupid = -1;
        String controlkey = "";
        String groupadminkey = "";
        //-----------------------------------
        //-----------------------------------
        String[][] rstServer= Db.RunSQL("SELECT serverurl, groupid, groupadminkey FROM groupserversubscription, groupsubscription WHERE groupsubscription.groupsubscriptionid='"+groupsubscriptionid+"' AND groupsubscription.groupserversubscriptionid=groupserversubscription.groupserversubscriptionid");
        //-----------------------------------
        //-----------------------------------
        if (rstServer!=null && rstServer.length>0){
        	for(int i=0; i<rstServer.length; i++){
        	    groupadminkey = rstServer[i][2];
                serverurl = rstServer[i][0];
                groupid = Integer.parseInt(rstServer[i][1]);
        	}
        }

        //Get the controlkey
        //-----------------------------------
        //-----------------------------------
        String[][] rstContKey= Db.RunSQL("SELECT controlkey FROM eventtogroup WHERE eventid='"+eventid+"' AND groupsubscriptionid='"+groupsubscriptionid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstContKey!=null && rstContKey.length>0){
        	for(int i=0; i<rstContKey.length; i++){
        	    controlkey = rstContKey[i][0];
        	}
        }

        //Build the xml call
        //removeEntryFromGroup(String entryUrl, int groupid, String controlKey)
        try{
            XmlRpcClient xmlrpc = new XmlRpcClient (serverurl);
            Vector params = new Vector();
            params.addElement (controlkey);
            params.addElement (groupadminkey);
            params.addElement (reger.Entry.entryCompleteUrl(eventid, true));
            params.addElement (new Integer(groupid));
            xmlrpc.executeAsync("weblogGroup.removeEntryFromGroup", params, null);
        } catch (Exception e) {
            reger.core.Util.errorsave(e, "Failed XML Groups Client call.");
        }
    }



}
