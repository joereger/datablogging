package reger.api;

import reger.core.db.Db;
import reger.PrivateLabel;
import reger.core.db.Db;

import java.util.Vector;
import java.util.Hashtable;
import java.util.Calendar;
import java.util.Enumeration;

public class weblogGroupApi {



    /**
     * Constructor.
     */
    public weblogGroupApi(){
        //reger.core.Util.logtodb("Made it to weblogGroupApi constructor.");
    }

    /**
     * Returns the url where users can sign up for an account that is allowed to add groups.
     * @return The url.
     */
    public String urlToSignupForAccount(){
        String url = "";
        PrivateLabel pl = new PrivateLabel(reger.Vars.PLIDDEFAULT);
        url = "" + reger.Vars.getHttpUrlPrefix() + pl.getPlBaseUrl() + "/about/index.log";
        return url;
    }

    /**
     * Returns the endpoint api url.
     * @return The url.
     */
    public String apiEndpointUrl(){
        String url = "";
        PrivateLabel pl = new PrivateLabel(reger.Vars.PLIDDEFAULT);
        url = "http://" + pl.getPlBaseUrl() + "/api.log";
        return url;
    }



    /**
     * Returns details of a group.
     * @param groupid - The groupid that you want to see details for.
     * @return A vector of hashtables.  The hashtables contain groupid, groupname, groupdescription, feedurlofgroup, weburlofgroup.
     */
    public Hashtable getGroupDetails(int groupid){

        Hashtable uGroup = new Hashtable();

        //-----------------------------------
        //-----------------------------------
        String[][] rstGroups= Db.RunSQL("SELECT groupid, groupname, groupdescription, viewingentriesrequiresgroupkey, addingentriesrequiresgroupkey, (SELECT count(*) FROM groupentry WHERE groupentry.groupid=groups.groupid) as totalentries FROM groups WHERE groupid='"+groupid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstGroups!=null && rstGroups.length>0){
        	for(int i=0; i<rstGroups.length; i++){
                boolean viewingentriesrequiresgroupkey = false;
                if (rstGroups[i][3].equals("1")){
                    viewingentriesrequiresgroupkey = true;
                }
                boolean addingentriesrequiresgroupkey = false;
                if (rstGroups[i][4].equals("1")){
                    addingentriesrequiresgroupkey = true;
                }
                PrivateLabel pl = new PrivateLabel(reger.Vars.PLIDDEFAULT);
                //The Hashtable that holds one group
                uGroup.put(String.valueOf("groupid"), new Integer(Integer.parseInt(rstGroups[i][0])));
                uGroup.put(String.valueOf("groupName"), rstGroups[i][1]);
                uGroup.put(String.valueOf("groupDescription"), rstGroups[i][2]);
                uGroup.put(String.valueOf("totalEntries"), new Integer(Integer.parseInt(rstGroups[i][5])));
                uGroup.put(String.valueOf("viewingEntriesRequiresGroupKey"), new Boolean(viewingentriesrequiresgroupkey));
                uGroup.put(String.valueOf("addingEntriesRequiresGroupKey"), new Boolean(addingentriesrequiresgroupkey));
                uGroup.put(String.valueOf("feedUrlOfGroup"), ""+reger.Vars.getHttpUrlPrefix()+pl.getPlBaseUrl()+"/groups/group"+rstGroups[i][0]+".xml");
                uGroup.put(String.valueOf("webUrlOfGroup"), ""+reger.Vars.getHttpUrlPrefix()+pl.getPlBaseUrl()+"/groups/group"+rstGroups[i][0]+".log");
        	    return uGroup;
        	}
        }
        return returnError("Group not found.");
    }

    /**
     * Searches the list of groups.
     * @param searchterms
     * @return A vector of hashtables.  The hashtables contain groupid, groupname, groupdescription, feedurlofgroup, weburlofgroup.
     */
    public Vector searchGroups(String searchterms){

        //reger.core.Util.logtodb("Made it to weblogGroupApi.searchGroups.");

        Vector groupArray = new Vector();

        //-----------------------------------
        //-----------------------------------
        String[][] rstGroups= Db.RunSQL("SELECT groupid, groupname, groupdescription, viewingentriesrequiresgroupkey, addingentriesrequiresgroupkey, (SELECT count(*) FROM groupentry WHERE groupentry.groupid=groups.groupid) as totalentries FROM groups WHERE groupname like '%"+reger.core.Util.cleanForSQL(searchterms)+"%' OR groupdescription like '%"+reger.core.Util.cleanForSQL(searchterms)+"%' ORDER BY totalentries DESC");
        //-----------------------------------
        //-----------------------------------
        if (rstGroups!=null && rstGroups.length>0){
        	for(int i=0; i<rstGroups.length; i++){
        	    //reger.core.Util.logtodb("Adding group:" + rstGroups[i][1]);
                groupArray.add(i, getGroupDetails(Integer.parseInt(rstGroups[i][0])));
        	}
        }

        return groupArray;
    }

    /**
     * Create a new group. A valid account on the groups server is required to create a new group.
     * @param groupName
     * @param groupDescription
     * @return The groupid of the new group or -1 if authentication fails.
     */
    public Hashtable createGroup(String serverKey, String groupName, String groupDescription, boolean viewingEntriesRequiresGroupKey, boolean addingEntriesRequiresGroupKey){
        if (serverKey.equals(reger.api.weblogGroupApiServerUtils.getServerKey())){
            //-----------------------------------
            //-----------------------------------
            String[][] rstExistingGroup= Db.RunSQL("SELECT groupid FROM groups WHERE groupname='"+reger.core.Util.cleanForSQL(groupName)+"'");
            //-----------------------------------
            //-----------------------------------
            if (rstExistingGroup!=null && rstExistingGroup.length>0){
            	return returnError("A group with that name already exists.");
            } else {
                String tmpViewBoolean = "0";
                if (viewingEntriesRequiresGroupKey){
                    tmpViewBoolean = "1";
                }
                String tmpAddBoolean = "0";
                if (addingEntriesRequiresGroupKey){
                    tmpAddBoolean = "1";
                }
                String groupKey = reger.core.RandomString.randomAlphanumeric(10);
                String groupAdminKey = reger.core.RandomString.randomAlphanumeric(10);
                //-----------------------------------
                //-----------------------------------
                int groupid = Db.RunSQLInsert("INSERT INTO groups(groupname, groupdescription, groupkey, groupadminkey, viewingentriesrequiresgroupkey, addingentriesrequiresgroupkey) VALUES('"+reger.core.Util.cleanForSQL(groupName)+"', '"+reger.core.Util.cleanForSQL(groupDescription)+"', '"+reger.core.Util.cleanForSQL(groupKey)+"', '"+reger.core.Util.cleanForSQL(groupAdminKey)+"', '"+tmpViewBoolean+"', '"+tmpAddBoolean+"')");
                //-----------------------------------
                //-----------------------------------
                Hashtable out = getGroupDetails(groupid);
                out.put(String.valueOf("groupKey"), groupKey);
                out.put(String.valueOf("groupAdminKey"), groupAdminKey);
                return out;
            }
        }
        return returnError("The serverKey was invalid.");
    }

    /**
     * Edits the details of the group.  To do this you need the valid groupAdminKey.  If newGroupKey or newGroupAdminKey is blank, the keys are not changed.
     * @param groupAdminKey
     * @param groupid
     * @param groupName
     * @param groupDescription
     * @param viewingEntriesRequiresGroupKey
     * @param addingEntriesRequiresGroupKey
     * @param newGroupKey
     * @param newGroupAdminKey
     * @return
     */
    public Hashtable editGroupDetails(String groupAdminKey, int groupid, String groupName, String groupDescription, boolean viewingEntriesRequiresGroupKey, boolean addingEntriesRequiresGroupKey, String newGroupKey, String newGroupAdminKey){

        //-----------------------------------
        //-----------------------------------
        String[][] rstExistingGroup= Db.RunSQL("SELECT groupid, groupKey, groupAdminKey FROM groups WHERE groupid='"+groupid+"' AND groupadminkey='"+reger.core.Util.cleanForSQL(groupAdminKey)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstExistingGroup!=null && rstExistingGroup.length>0){
            if (isValidDataForGroup(groupName, groupDescription)){
                String tmpViewBoolean = "0";
                if (viewingEntriesRequiresGroupKey){
                    tmpViewBoolean = "1";
                }
                String tmpAddBoolean = "0";
                if (addingEntriesRequiresGroupKey){
                    tmpAddBoolean = "1";
                }
                String tmpGroupKey = rstExistingGroup[0][1];
                if (!newGroupKey.equals("")){
                    tmpGroupKey = newGroupKey;
                }
                String tmpGroupAdminKey = rstExistingGroup[0][2];
                if (!newGroupAdminKey.equals("")){
                    tmpGroupAdminKey = newGroupAdminKey;
                }
                //-----------------------------------
                //-----------------------------------
                int count = Db.RunSQLUpdate("UPDATE groups SET groupname='"+reger.core.Util.cleanForSQL(groupName)+"', groupdescription='"+reger.core.Util.cleanForSQL(groupDescription)+"', viewingentriesrequiresgroupkey='"+tmpViewBoolean+"', addingentriesrequiresgroupkey='"+tmpAddBoolean+"', groupkey='"+tmpGroupKey+"', groupadminkey='"+tmpGroupAdminKey+"'  WHERE groupid='"+groupid+"'");
                //-----------------------------------
                //-----------------------------------
                Hashtable out = getGroupDetails(groupid);
                out.put(String.valueOf("groupKey"), newGroupKey);
                out.put(String.valueOf("groupAdminKey"), newGroupAdminKey);
                return out;
            } else {
                return returnError("Invalid information to create a group.");
            }
        } else {
            return returnError("A group with that groupAdminKey was not found.");
        }

    }

    private static boolean isValidDataForGroup(String groupName, String groupDescription){
        boolean isValid = true;
        if (groupName.equals("")){
            isValid = false;
        }
        return isValid;
    }

    /**
     * Adds an entry to the group specified.
     * @param groupKey - Set to blank if you don't have a groupKey
     * @param entryUrl
     * @param groupid
     * @param entryTitle
     * @param entryExtract
     * @return A random string that is used as a key to remove this entry from the group.  Only the person who added the entry should have access to the key.
     */
    public Hashtable addEntryToGroup(String groupKey, String entryUrl, String entryTitle, String entryExtract, String author, String authorUrl, int groupid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstGroup= Db.RunSQL("SELECT groupkey, addingentriesrequiresgroupkey FROM groups WHERE groupid='"+groupid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstGroup!=null && rstGroup.length>0){
            if (rstGroup[0][1].equals("1") && !groupKey.equals(rstGroup[0][0])){
                //Fail groupkey check
                Hashtable uGroup = new Hashtable();
                uGroup.put(String.valueOf("entryUrl"), entryUrl);
                uGroup.put(String.valueOf("groupid"), new Integer(groupid));
                uGroup.put(String.valueOf("error"), "This group requires a groupKey to post entries and the groupKey sent was invalid.");
                return uGroup;
            } else {
                String controlkey = reger.core.RandomString.randomAlphanumeric(10);
                if (entryTitle.equals("")){
                    entryTitle.equals(reger.core.Util.truncateString(entryExtract, 255));
                }
                if (entryTitle.equals("")){
                    entryTitle.equals(reger.core.Util.truncateString(entryUrl, 255));
                }
                //-----------------------------------
                //-----------------------------------
                int identity = Db.RunSQLInsert("INSERT INTO groupentry(entryurl, groupid, datetime, entrytitle, entryextract, controlkey, author, authorurl) VALUES('"+reger.core.Util.truncateString(reger.core.Util.cleanForSQL(entryUrl), 255)+"', '"+groupid+"', '"+reger.core.TimeUtils.nowInGmtString()+"', '"+reger.core.Util.truncateString(reger.core.Util.cleanForSQL(entryTitle), 255)+"', '"+reger.core.Util.truncateString(reger.core.Util.cleanForSQL(entryExtract), 255)+"', '"+reger.core.Util.cleanForSQL(controlkey)+"', '"+reger.core.Util.truncateString(reger.core.Util.cleanForSQL(author), 255)+"', '"+reger.core.Util.truncateString(reger.core.Util.cleanForSQL(authorUrl), 255)+"')");
                //-----------------------------------
                //-----------------------------------

                Hashtable uGroup = new Hashtable();
                uGroup.put(String.valueOf("entryUrl"), entryUrl);
                uGroup.put(String.valueOf("groupid"), new Integer(groupid));
                uGroup.put(String.valueOf("controlkey"), controlkey);
                return uGroup;
            }
        }
        Hashtable uGroup = new Hashtable();
        uGroup.put(String.valueOf("entryUrl"), entryUrl);
        uGroup.put(String.valueOf("groupid"), new Integer(groupid));
        uGroup.put(String.valueOf("error"), "The group with groupid='"+groupid+"' was not found.");
        return uGroup;

    }

    public boolean testGroupKey(String groupKey, int groupid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstGroup= Db.RunSQL("SELECT groupid FROM groups WHERE groupid='"+groupid+"' AND groupKey='"+reger.core.Util.cleanForSQL(groupKey)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstGroup!=null && rstGroup.length>0){
        	return true;
        }
        return false;
    }

    public boolean testGroupAdminKey(String groupAdminKey, int groupid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstGroup= Db.RunSQL("SELECT groupid FROM groups WHERE groupid='"+groupid+"' AND groupAdminKey='"+reger.core.Util.cleanForSQL(groupAdminKey)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstGroup!=null && rstGroup.length>0){
        	return true;
        }
        return false;
    }


    /**
     * Removes an entry from the group.  The controlKey or the groupAdminKey is required to do this.
     * @param entryUrl
     * @param groupid
     * @param controlKey
     * @param groupAdminKey
     * @return Boolean indicating whether the entry was removed.
     */
    public boolean removeEntryFromGroup(String controlKey, String groupAdminKey, String entryUrl, int groupid){

        reger.core.Util.debug(5, "weblogGroupApi.removeEntryFromGroup()<br>entryurl=" + entryUrl + "<br>controlkey=" + controlKey + "<br>groupadminkey=" + groupAdminKey + "<br>groupid=" + groupid);

        boolean groupAdminKeyIsCorrect = false;
        //-----------------------------------
        //-----------------------------------
        String[][] rstGroup= Db.RunSQL("SELECT groupadminkey FROM groups WHERE groupid='"+groupid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstGroup!=null && rstGroup.length>0){
            if (groupAdminKey.equals(rstGroup[0][0])){
                groupAdminKeyIsCorrect = true;
            }
        }

        boolean controlKeyIsCorrect = false;
        //-----------------------------------
        //-----------------------------------
        String[][] rstEntry= Db.RunSQL("SELECT controlkey FROM groupentry WHERE entryurl='"+reger.core.Util.cleanForSQL(entryUrl)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstEntry!=null && rstEntry.length>0){
            if (controlKey.equals(rstEntry[0][0])){
                controlKeyIsCorrect = true;
            }
        }


        if (controlKeyIsCorrect || groupAdminKeyIsCorrect){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("DELETE FROM groupentry WHERE entryurl='"+reger.core.Util.cleanForSQL(entryUrl)+"' AND groupid='"+groupid+"'");
            //-----------------------------------
            //-----------------------------------
            if (count>0){
                reger.core.Util.debug(5, "returning true, deleted.");
                return true;
            } else {
                reger.core.Util.debug(5, "returning false, sql called but none deleted.");
                return false;
            }
        }
        reger.core.Util.debug(5, "returning false, default return... no action.");
        return false;
    }



    private Hashtable returnError(String errorDescription){
        Hashtable err = new Hashtable();
        err.put(String.valueOf("error"), errorDescription);
        return err;
    }



}
