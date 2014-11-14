package reger.acl;

import reger.AddToArray;

/**
 * Stores all AclObject objects in memory and provides access to them.
 */
public class AllAclObjects {

    private static AclObject[] allAclObjects;

    public AllAclObjects(){
        if (allAclObjects==null){
            refreshAclObjects();
        }
    }

    private static void refreshAclObjects(){

        //Setup
        allAclObjects = new AclObject[0];
        AclObject tmpAclObject;

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 1;
        tmpAclObject.aclobjectname = "ADMINHOME";
        tmpAclObject.aclfriendlyname = "My Home Admin";
        tmpAclObject.acldesc = "Log in to the main My Home Admin tool.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 3;
        tmpAclObject.aclobjectname = "CUSTOMIZELOG";
        tmpAclObject.aclfriendlyname = "Customize Log Settings";
        tmpAclObject.acldesc = "Customize a log's properties like its security, name and QuickPassword.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 4;
        tmpAclObject.aclobjectname = "CUSTOMIZE";
        tmpAclObject.aclfriendlyname = "Customize Site Settings";
        tmpAclObject.acldesc = "Customize the site's settings.  There are many to set.  From timezone to the way entries appear.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 5;
        tmpAclObject.aclobjectname = "SAVECHARTS";
        tmpAclObject.aclfriendlyname = "Save Charts";
        tmpAclObject.acldesc = "Save custom charts and graphs for future use.  Once a chart is saved, anybody who can view the log can see the pre-saved charts and graphs.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 6;
        tmpAclObject.aclobjectname = "MASTERADMIN";
        tmpAclObject.aclfriendlyname = "LOE Administration";
        tmpAclObject.acldesc = "The big kahuna.  The ability to run all of the behind-the-scenes admin for all private labels and all web logging accounts.  This user will have the ability to view all users' entries and files.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 7;
        tmpAclObject.aclobjectname = "DELETECHARTS";
        tmpAclObject.aclfriendlyname = "Delete Charts and Graphs";
        tmpAclObject.acldesc = "Delete pre-saved charts and graphs.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 8;
        tmpAclObject.aclobjectname = "ADDMEDIA";
        tmpAclObject.aclfriendlyname = "Upload Files";
        tmpAclObject.acldesc = "Add files to an entry.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 9;
        tmpAclObject.aclobjectname = "CHANGESKIN";
        tmpAclObject.aclfriendlyname = "Change Site Template";
        tmpAclObject.acldesc = "Change the site template which changes the way the entire public weblog looks.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 10;
        tmpAclObject.aclobjectname = "MANAGEACCOUNTS";
        tmpAclObject.aclfriendlyname = "Manage Accounts";
        tmpAclObject.acldesc = "Manage accounts of other authors in the weblog.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

//        tmpAclObject = new AclObject();
//        tmpAclObject.aclobjectid = 13;
//        tmpAclObject.aclobjectname = "EDITENTRIES";
//        tmpAclObject.aclfriendlyname = "Edit Entries";
//        tmpAclObject.acldesc = "Edit weblog entries.";
//        allAclObjects = reger.core.Util.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 12;
        tmpAclObject.aclobjectname = "MOBILE";
        tmpAclObject.aclfriendlyname = "Mobile Access";
        tmpAclObject.acldesc = "Access the site via the mobile WAP interface.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 11;
        tmpAclObject.aclobjectname = "NEWLOG";
        tmpAclObject.aclfriendlyname = "Create a New Log";
        tmpAclObject.acldesc = "Create a new weblog.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 14;
        tmpAclObject.aclobjectname = "PUBLISHWITHOUTAPPROVAL";
        tmpAclObject.aclfriendlyname = "Publish Entries Without Approval";
        tmpAclObject.acldesc = "Users who don't have this permission will have their entries moderated by somebody else.  This is useful if you want the user to be able to contribute but not post those contributions publicly until the entry is reviewed.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 15;
        tmpAclObject.aclobjectname = "ADDEDITENTRIES";
        tmpAclObject.aclfriendlyname = "Add and Edit Entries";
        tmpAclObject.acldesc = "Add and Edit weblog entries.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 16;
        tmpAclObject.aclobjectname = "APPROVEENTRIES";
        tmpAclObject.aclfriendlyname = "Approve Entries";
        tmpAclObject.acldesc = "Approve entries and post them publicly.  When a user does not have Publish Without Approval permission then a person with Approve Entries must approve all of their posts.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 17;
        tmpAclObject.aclobjectname = "CHANGEAUTHORSHIP";
        tmpAclObject.aclfriendlyname = "Change Authorship";
        tmpAclObject.acldesc = "Change the authorship of an entry.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 2;
        tmpAclObject.aclobjectname = "DELETELOG";
        tmpAclObject.aclfriendlyname = "Delete Logs";
        tmpAclObject.acldesc = "Delete a log including all of its entries.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 18;
        tmpAclObject.aclobjectname = "PEOPLE";
        tmpAclObject.aclfriendlyname = "People Tab";
        tmpAclObject.acldesc = "Access to the social networking tab and features of the site.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 19;
        tmpAclObject.aclobjectname = "INVITEPEOPLE";
        tmpAclObject.aclfriendlyname = "Invite People";
        tmpAclObject.acldesc = "Invite people to this weblog via email.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 20;
        tmpAclObject.aclobjectname = "ADDAUTHOR";
        tmpAclObject.aclfriendlyname = "Add Author";
        tmpAclObject.acldesc = "Add an author user to this weblog account.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 21;
        tmpAclObject.aclobjectname = "TRAFFIC";
        tmpAclObject.aclfriendlyname = "View Traffic Data";
        tmpAclObject.acldesc = "View traffic data like most read entries, number of hits per day, etc.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 22;
        tmpAclObject.aclobjectname = "CREATETIMEPERIODS";
        tmpAclObject.aclfriendlyname = "Create Time Periods";
        tmpAclObject.acldesc = "Create time periods for this weblog.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 23;
        tmpAclObject.aclobjectname = "TIMEPERIODSVIEWPRIVATE";
        tmpAclObject.aclfriendlyname = "View Private Time Periods";
        tmpAclObject.acldesc = "Time periods can be defined as private.  This grants the user the ability to see those private time periods.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 24;
        tmpAclObject.aclobjectname = "PLADMIN";
        tmpAclObject.aclfriendlyname = "Private Label Admin";
        tmpAclObject.acldesc = "Work in the Private Label Admin Section.  When the user logs in they will have a Private Label tab in their admin tool.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 25;
        tmpAclObject.aclobjectname = "MANAGEGROUPS";
        tmpAclObject.aclfriendlyname = "Manage Groups Membership";
        tmpAclObject.acldesc = "Manage which groups they belong to.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);

        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 26;
        tmpAclObject.aclobjectname = "POSTENTRYTOGROUP";
        tmpAclObject.aclfriendlyname = "Post Entry to Group";
        tmpAclObject.acldesc = "Submit an entry to a particular group.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);


        tmpAclObject = new AclObject();
        tmpAclObject.aclobjectid = 27;
        tmpAclObject.aclobjectname = "SAVESEARCHES";
        tmpAclObject.aclfriendlyname = "Save Searches";
        tmpAclObject.acldesc = "Save named searches and have them appear for users to click on.";
        allAclObjects = AddToArray.addToAclObjectArray(allAclObjects, tmpAclObject);


    }

    public static int getAclObjectIdByName(String aclobjectname){
        if (allAclObjects==null){
            refreshAclObjects();
        }
        for (int i = 0; i < allAclObjects.length; i++) {
            if (allAclObjects[i].aclobjectname.equals(aclobjectname)){
                return allAclObjects[i].aclobjectid;
            }
        }
        return -1;
    }

    public static String getAclObjectNameById(int aclobjectid){
        if (allAclObjects==null){
            refreshAclObjects();
        }
        for (int i = 0; i < allAclObjects.length; i++) {
            if (allAclObjects[i].aclobjectid==aclobjectid){
                return allAclObjects[i].aclobjectname;
            }
        }
        return "";
    }

    public static AclObject getAclObjectById(int aclobjectid){
        if (allAclObjects==null){
            refreshAclObjects();
        }
        for (int i = 0; i < allAclObjects.length; i++) {
            if (allAclObjects[i].aclobjectid==aclobjectid){
                return allAclObjects[i];
            }
        }
        return null;
    }

    public static AclObject getAclObjectByName(String aclobjectname){
        if (allAclObjects==null){
            refreshAclObjects();
        }
        for (int i = 0; i < allAclObjects.length; i++) {
            if (allAclObjects[i].aclobjectname.equals(aclobjectname)){
                return allAclObjects[i];
            }
        }
        return null;
    }

    public static AclObject[] getAllAclObjects(){
        if (allAclObjects==null){
            refreshAclObjects();
        }
        return allAclObjects;
    }

    public static String getAclFriendlyNameById(int aclobjectid){
        if (allAclObjects==null){
            refreshAclObjects();
        }
        for (int i = 0; i < allAclObjects.length; i++) {
            if (allAclObjects[i].aclobjectid==aclobjectid){
                return allAclObjects[i].aclfriendlyname;
            }
        }
        return "";
    }

    public static String getAclFriendlyNameByName(String aclobjectname){
        if (allAclObjects==null){
            refreshAclObjects();
        }
        for (int i = 0; i < allAclObjects.length; i++) {
            if (allAclObjects[i].aclobjectname.equals(aclobjectname)){
                return allAclObjects[i].aclfriendlyname;
            }
        }
        return "";
    }


}
