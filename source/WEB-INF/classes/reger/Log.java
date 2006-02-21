package reger;

import reger.mega.FieldType;
import reger.mega.FieldOrderCollection;
import reger.nestednav.NestedNavItem;
import reger.core.db.Db;
import reger.core.Util;
import reger.core.Debug;
import reger.cache.LogCache;
import reger.cache.providers.jboss.Cacheable;

import java.util.Calendar;
import java.util.ArrayList;
import java.util.Iterator;

@Cacheable
public class Log implements NestedNavItem {

    private int logid;
    private int accountid;
    private int eventtypeid;
    private String name;
    private int logaccess;
    private String message="";
    private boolean showonhomepage;
    private ArrayList<FieldType> fields = new ArrayList<FieldType>();
    private ArrayList<FieldType> fieldshidden = new ArrayList<FieldType>();
    private String password;
    private int maintemplateid;
    private int entlisttemplateid;
    private String fieldorder = "";
    private ArrayList<Integer> hiddenfields = new ArrayList<Integer>();
    private FieldOrderCollection fieldOrderCollection;
    private int numberOfLiveEntriesInLog = -1;
    private Calendar mostRecentEntryDateGMT;
    private int nestednavparenttype=NestedNavItem.NESTEDNAVITEMBASE;
    private int nestednavparentid=0;
    private int nestednavorder=0;

    public Log(int logid){
        load(logid);
    }

    public void load(int logid){
        reger.core.Debug.debug(5, "Log.java", "Load() called for logid="+logid);
        //-----------------------------------
        //-----------------------------------
        String[][] rstLog= Db.RunSQL("SELECT logid, accountid, eventtypeid, name, logaccess, password, message, showonhomepage, maintemplateid, entlisttemplateid, nestednavparenttype, nestednavparentid, nestednavorder, fieldorder, hiddenfields FROM megalog WHERE logid='"+logid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstLog!=null && rstLog.length>0){
            for(int i=0; i<rstLog.length; i++){
                this.logid=Integer.parseInt(rstLog[i][0]);
                accountid=Integer.parseInt(rstLog[i][1]);
                eventtypeid=Integer.parseInt(rstLog[i][2]);
                name=rstLog[i][3];
                logaccess=Integer.parseInt(rstLog[i][4]);
                reger.core.Debug.debug(5, "Log.java", "logaccess="+logaccess);
                password=rstLog[i][5];
                message=rstLog[i][6];
                if (rstLog[i][7].equals("0")){
                    showonhomepage=false;
                } else {
                    showonhomepage=true;
                }
                maintemplateid=Integer.parseInt(rstLog[i][8]);
                entlisttemplateid=Integer.parseInt(rstLog[i][9]);
                nestednavparenttype=Integer.parseInt(rstLog[i][10]);
                nestednavparentid=Integer.parseInt(rstLog[i][11]);
                nestednavorder=Integer.parseInt(rstLog[i][12]);

                fieldorder=rstLog[i][13];

                if (!rstLog[i][14].equals("")){
                    try{
                        String[] hf = rstLog[i][14].split("\\|");
                        hiddenfields = new ArrayList<Integer>();
                        for (int j = 0; j < hf.length; j++) {
                            if (reger.core.Util.isinteger(hf[j])){
                                hiddenfields.add(Integer.parseInt(hf[j]));
                            }
                        }
                    } catch (Exception e){
                        Debug.errorsave(e, "");
                    }
                }

                //Get fieldOrderCollection
                if (!fieldorder.equals("")){
                    fieldOrderCollection = new FieldOrderCollection(fieldorder);
                } else {
                    fieldorder = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).getFieldorder();
                    fieldOrderCollection = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).getFieldOrderCollection();
                }

                //Get fields for this log
                loadFields();

                //Debug
                StringBuffer tmp2 = new StringBuffer();
                if (fields!=null){
                    for (Iterator it = fields.iterator(); it.hasNext(); ) {
                        FieldType ft = (FieldType)it.next();
                        tmp2.append(ft.getMegafieldid() + "<br>fieldname=" + ft.getFieldname() + "<br>");
                    }
                }
                Debug.debug(5, "", "Log.java - logid="+this.logid+" - fields After Assignment<br>" + tmp2.toString());

            }
        }
    }

    private void loadFields(){
        //Get the system fields for this megalogtype
        ArrayList<FieldType> systemFields = AllFieldsInSystem.allMegaFieldsForEventtypeid(eventtypeid, true);
        fields = systemFields;

        //Debug
        StringBuffer tmp0 = new StringBuffer();
        if (fields!=null){
            for (Iterator it = fields.iterator(); it.hasNext(); ) {
               FieldType ftC = (FieldType)it.next();
               ftC.loadDefaultData(logid);
               tmp0.append(ftC.getMegafieldid() + "<br>fieldname=" + ftC.getFieldname() + "<br>");
            }
        }
        Debug.debug(5, "", "Log.java - logid="+logid+" fields Before Assignment<br>" + tmp0.toString());

        //Order the fields
        orderFieldsAndSeparateHidden(fields);
    }

    private void orderFieldsAndSeparateHidden(ArrayList<FieldType> inFields){
        //Reset field values
        ArrayList<FieldType> fields = new ArrayList<FieldType>();
        ArrayList<FieldType> fieldshidden = new ArrayList<FieldType>();

        for (Iterator it = inFields.iterator(); it.hasNext(); ) {
            FieldType ft = (FieldType)it.next();
                //Check visibility
                if (!hiddenfields.contains(ft.getMegafieldid())){
                    fields.add(ft);
                } else {
                    fieldshidden.add(ft);
                }
        }

        this.fields = fields;
        this.fieldshidden = fieldshidden;
    }



    public void refreshMostRecentEntryDateGMTFromDB(){
        //Load the expensive most recent entry and number of entries for this log
        //-----------------------------------
        //-----------------------------------
        String[][] rstLastEntry= Db.RunSQL("SELECT max(date) FROM event WHERE event.logid='"+logid+"' AND "+reger.Entry.sqlOfLiveEntry+"");
        //-----------------------------------
        //-----------------------------------
        if (rstLastEntry!=null && rstLastEntry.length>0){
            mostRecentEntryDateGMT=reger.core.TimeUtils.dbstringtocalendar(rstLastEntry[0][0]);
        }
    }

    public void refreshNumberOfLiveEntriesInLogFromDB(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstEntryCount= Db.RunSQL("SELECT count(*) FROM event WHERE event.logid='"+logid+"' AND "+reger.Entry.sqlOfLiveEntry+"");
        //-----------------------------------
        //-----------------------------------
        if (rstEntryCount!=null && rstEntryCount.length>0){
            numberOfLiveEntriesInLog = Integer.parseInt(rstEntryCount[0][0]);
        }
    }

    public void save(){
        if (name.equals("")){
            name="Log";
        }

        String showonhomepageTxt = "1";
        if (!showonhomepage){
            showonhomepageTxt = "0";
        }



        StringBuffer hiddenfieldsForSql = new StringBuffer();
        int i = 0;
        for (Iterator it = hiddenfields.iterator(); it.hasNext(); ) {
            Integer tmpFieldid = (Integer)it.next();
            hiddenfieldsForSql.append(tmpFieldid);
            if (i<(hiddenfields.size()-1)){
                hiddenfieldsForSql.append("|");
            }
            i++;
        }

        //-----------------------------------
        //-----------------------------------
        int countLogUpdate = Db.RunSQLUpdate("UPDATE megalog SET name='"+ Util.cleanForSQL(name) +"', message='"+ Util.cleanForSQL(message) +"', showonhomepage='"+ showonhomepageTxt +"', logaccess='"+ logaccess +"', password='"+ Util.cleanForSQL(password) +"', maintemplateid='"+maintemplateid+"', entlisttemplateid='"+entlisttemplateid+"', nestednavparenttype='"+nestednavparenttype+"', nestednavparentid='"+nestednavparentid+"', nestednavorder='"+nestednavorder+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' , hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfieldsForSql.toString())+"' WHERE logid='"+ logid +"'");
        //-----------------------------------
        //-----------------------------------

        LogCache.flushByLogid(logid);
    }

    public void delete(int movetologid){
        Debug.debug(5, "", "Log.java delete() called<br>logid=" + logid + " movetologid=" + movetologid);

        //If the user wants to move the entries to a new log
        //Make sure the user can administer the movetologid as well
        //Now convert all entries for this log from old to new logid
        //-----------------------------------
        //-----------------------------------
        String[][] rstEntries= Db.RunSQL("SELECT eventid, accountid FROM event WHERE logid='"+logid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstEntries!=null && rstEntries.length>0){
            for(int i=0; i<rstEntries.length; i++){
                reger.Entry ent = new reger.Entry(Integer.parseInt(rstEntries[i][0]));
                if (movetologid>0){
                    //Move the entry
                    ent.moveEntryToLogId(logid, movetologid);
                } else {
                    //Delete the entry and everything with it
                    ent.deleteEntryAll();
                }
            }
        }
        Debug.debug(5, "", "Log.java delete() done moving entries, if necessary.<br>logid=" + logid + " movetologid=" + movetologid);


        //Shift log orders appropriately
        Account acct = new reger.Account(accountid);
        acct.getNestedNavCollection().adjustAfterRemovalOfItem(NESTEDNAVTYPEMEGALOG, logid);
        Debug.debug(5, "", "Log.java delete() done reordering other nav items.<br>logid=" + logid + " movetologid=" + movetologid);

        //Now delete the log itself
        //-----------------------------------
        //-----------------------------------
        int logsdeleted = Db.RunSQLUpdate("DELETE FROM megalog WHERE logid='"+logid+"'");
        //-----------------------------------
        //-----------------------------------
        Debug.debug(5, "", "Log.java delete() done deleting log from Db<br>logid=" + logid + " movetologid=" + movetologid);

        //Important to refresh the LogCache object after megalog changes
        LogCache.flushByLogid(logid);
        if (movetologid>0){
            LogCache.flushByLogid(movetologid);
        }
        Debug.debug(5, "", "Log.java delete() done refreshing LogCache.<br>logid=" + logid + " movetologid=" + movetologid);
    }



    public int getLogid() {
        return logid;
    }

    public int getAccountid() {
        return accountid;
    }

    public int getEventtypeid() {
        return eventtypeid;
    }

    public String getName() {
        return name;
    }

    public int getLogaccess() {
        return logaccess;
    }

    public String getMessage() {
        return message;
    }

    public boolean getShowonhomepage() {
        return showonhomepage;
    }

    public ArrayList<FieldType> getFields() {
        return fields;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogaccess(int logaccess) {
        this.logaccess = logaccess;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setShowonhomepage(boolean showonhomepage) {
        this.showonhomepage = showonhomepage;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumberOfLiveEntriesInLog() {
        if (numberOfLiveEntriesInLog==-1){
            refreshNumberOfLiveEntriesInLogFromDB();
        }
        return numberOfLiveEntriesInLog;
    }

    public Calendar getMostRecentEntryDateGMT() {
        if (mostRecentEntryDateGMT==null){
            refreshMostRecentEntryDateGMTFromDB();
        }
        return mostRecentEntryDateGMT;
    }

    public int getMaintemplateid() {
        return maintemplateid;
    }

    public void setMaintemplateid(int maintemplateid) {
        this.maintemplateid = maintemplateid;
    }

    public int getEntlisttemplateid() {
        return entlisttemplateid;
    }

    public void setEntlisttemplateid(int entlisttemplateid) {
        this.entlisttemplateid = entlisttemplateid;
    }



    /**
     * Begin code to implement the NestedNavItem interface
     * ---------------------------------------------------
     * ---------------------------------------------------
     */



    /**
     * The text that should appear in the navigation bar
     */
    public String getNestedNavLinkText() {
        return getName();
    }

    /**
     * The url that this item should link to
     */
    public String getNestedNavLinkUrl() {
        return "logmain"+getLogid()+".log";
    }

    /**
     * This type.  Either NestedNavItem.NESTEDNAVTYPEMEGALOG or NestedNavItem.NESTEDNAVTYPECONTENTPAGE
     */
    public int getThisNestedNavType() {
        return NestedNavItem.NESTEDNAVTYPEMEGALOG;
    }

    /**
     * The database unique id of this item.  This is either the logid or the contentpageid
     */
    public int getThisNestedNavId() {
        return getLogid();
    }

    /**
     * The type of parent that this is under.  0 if under none.  Either NestedNavItem.NESTEDNAVTYPEMEGALOG or NestedNavItem.NESTEDNAVTYPECONTENTPAGE.
     */
    public int getNestedNavParentType() {
        return nestednavparenttype;
    }

    /**
     * The database unique id of the parent item. 0 if under none.  This is either the logid or the contentpageid
     */
    public int getNestedNavParentId() {
        return nestednavparentid;
    }

    /**
     * The numeric order of the item.  1 is first in the list.
     */
    public int getNestedNavOrder() {
        return nestednavorder;
    }

    /**
     * Move this item down one by changing its order property, increasing it one.  Keeping same parent.
     */
    public void moveNestedNavDown() {
        nestednavorder = nestednavorder + 1;
        save();
    }

    /**
     * Move this item up one by changing its order property, decreasing it one. Keeping same parent.
     */
    public void moveNestedNavUp() {
        nestednavorder = nestednavorder - 1;
        save();
    }

    /**
     * Move to a specified spot on the nav scheme
     */
    public void moveNestedNavTo(int parentType, int parentId, int order) {
        Debug.debug(5, "", "Log.java - moveNestedNavTo()<br>nestednavlinktext="+getNestedNavLinkText()+"<br>parentType=" + parentType + "<br>parentId=" + parentId + "<br>order="+order);
        nestednavparenttype = parentType;
        nestednavparentid = parentId;
        nestednavorder = order;
        save();
    }

    /**
     * Whether the accountuser provided can view this item.  This is used to determine whether the
     * item should be displayed on the screen in the navbar.
     */
    public boolean userCanViewNavItem(Accountuser accountUser){
        if (logaccess==reger.Vars.LOGACCESSPUBLIC){
            return true;
        }
        if (accountUser!=null){
            if (accountUser.userCanViewLog(logid)){
                return true;
            }
        }
        return false;
    }



    /**
     * Whether the accountuser provided can view this item
     */
    public boolean userCanAdministerNavItem(Accountuser accountUser){

        if (accountUser!=null){
            if (accountUser.userCanViewLog(logid) && accountUser.userCanDoAcl("CUSTOMIZELOG", accountid)){
                return true;
            }
        }
        return false;
    }

    /**
     * Whether or not this nav item should be considered on/active or not
     */
    public boolean isActive(javax.servlet.http.HttpServletRequest request){
        if (request.getParameter("logid")!=null && reger.core.Util.isinteger(request.getParameter("logid"))){
            if (Integer.parseInt(request.getParameter("logid"))==logid){
                return true;
            }
        }
        return false;
    }

    /**
     * ---------------------------------------------------
     * ---------------------------------------------------
     * End code to implement the NestedNavItem interface
     */

     public void removeField(int megafieldid){
        FieldType tmpFt = reger.AllFieldsInSystem.getMegaFieldByMegafieldid(megafieldid);
        if (tmpFt.isThereDataForFieldInDB()){
            //Hide it
            if (!hiddenfields.contains(megafieldid)){
                hiddenfields.add(megafieldid);
                save();
            }
        } else {
            //Delete it
            tmpFt.deleteField();
        }
    }

    public void unhideField(int megafieldid){
        //Remove from hiddenfields
        Debug.debug(5, "", "Field.java - Unhide called on megafieldid=" + megafieldid);
        ArrayList<Integer> out = new ArrayList<Integer>();
        for (Iterator it = hiddenfields.iterator(); it.hasNext(); ) {
            Integer tmpfieldid = (Integer)it.next();
            if(tmpfieldid!=megafieldid){
                out.add(tmpfieldid);
            }
        }
        hiddenfields = out;
        save();
    }

    public ArrayList<Integer> getHiddenfields() {
        return hiddenfields;
    }

    public String getFieldorder() {
        return fieldorder;
    }

    public ArrayList<FieldType> getFieldshidden() {
        return fieldshidden;
    }

    public void setFieldshidden(ArrayList<FieldType> fieldshidden) {
        this.fieldshidden = fieldshidden;
    }

    public void setFieldorder(String fieldorder) {
        this.fieldorder = fieldorder;
    }

    public void setHiddenfields(ArrayList<Integer> hiddenfields) {
        this.hiddenfields = hiddenfields;
    }

    public FieldOrderCollection getFieldOrderCollection() {
        return fieldOrderCollection;
    }


}
