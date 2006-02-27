package reger.dao.ext;

import reger.dao.db.MegalogDAO;
import reger.nestednav.NestedNavItem;
import reger.mega.FieldOrderCollection;
import reger.mega.FieldType;
import reger.core.Debug;
import reger.core.ValidationException;
import reger.core.db.Db;
import reger.AllFieldsInSystem;
import reger.Account;
import reger.Accountuser;
import reger.cache.LogCache;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Main class for a log
 */
public class Megalog extends MegalogDAO implements NestedNavItem {

    private FieldOrderCollection fieldOrderCollection;
    private ArrayList<FieldType> fields = new ArrayList<FieldType>();
    private ArrayList<FieldType> fieldshidden = new ArrayList<FieldType>();
    private ArrayList<Integer> hiddenfieldInts = new ArrayList<Integer>();
    private Calendar mostRecentEntryDateGMT;
    private int numberOfLiveEntriesInLog = -1;

    public Megalog(int logid){
        this.logid = logid;
        load();
    }


    public void load(){
        super.load();

        //Put hiddenfields into ArrayList
        if (hiddenfields!=null && !hiddenfields.equals("")){
            try{
                String[] hf = hiddenfields.split("\\|");
                hiddenfieldInts = new ArrayList<Integer>();
                for (int j = 0; j < hf.length; j++) {
                    if (reger.core.Util.isinteger(hf[j])){
                        hiddenfieldInts.add(Integer.parseInt(hf[j]));
                    }
                }
            } catch (Exception e){
                Debug.errorsave(e, "Megalog.java");
            }
        }

        //Get fieldOrderCollection
        if (!fieldorder.equals("")){
            fieldOrderCollection = new FieldOrderCollection(fieldorder);
        } else {
            fieldorder = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).getFieldorder();
            fieldOrderCollection = reger.AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid).getFieldOrderCollection();
        }

        //Get the system fields for this megalogtype
        loadFields();

        //Order the fields
        orderFieldsAndSeparateHidden();

        //Debug
        StringBuffer tmp2 = new StringBuffer();
        if (fields!=null){
            for (Iterator it = fields.iterator(); it.hasNext(); ) {
                FieldType ft = (FieldType)it.next();
                tmp2.append(ft.getMegafieldid() + "<br>fieldname=" + ft.getFieldname() + "<br>");
            }
        }
        Debug.debug(5, "", "Megalog.java - logid="+this.logid+" - fields After Assignment<br>" + tmp2.toString());
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
        orderFieldsAndSeparateHidden();
    }

    private void orderFieldsAndSeparateHidden(){
        ArrayList<FieldType> fieldsTmp = new ArrayList<FieldType>();
        ArrayList<FieldType> fieldshiddenTmp = new ArrayList<FieldType>();

        for (Iterator it = fields.iterator(); it.hasNext(); ) {
            FieldType ft = (FieldType)it.next();
            if (!hiddenfieldInts.contains(ft.getMegafieldid())){
                fieldsTmp.add(ft);
            } else {
                fieldshiddenTmp.add(ft);
            }
        }

        this.fields = fieldsTmp;
        this.fieldshidden = fieldshiddenTmp;
    }

    public void save() throws ValidationException {
        ValidationException vex = new ValidationException();

        //Convert hiddenfieldInts back into a string
        StringBuffer hiddenfieldsTmp = new StringBuffer();
        int i = 0;
        for (Iterator it = hiddenfieldInts.iterator(); it.hasNext(); ) {
            Integer tmpFieldid = (Integer)it.next();
            hiddenfieldsTmp.append(tmpFieldid);
            if (i<(hiddenfieldInts.size()-1)){
                hiddenfieldsTmp.append("|");
            }
            i++;
        }
        hiddenfields = hiddenfieldsTmp.toString();

        //Validate
        try{
            validate();
        } catch (ValidationException vexloc){
            vex.addErrorsFromAnotherValidationException(vexloc);
        }
        if (vex.getErrors().length>0){
            throw vex;
        }


        //Save main object
        try{
            super.save();
        } catch (ValidationException vextmp){
            vex.addErrorsFromAnotherValidationException(vextmp);
        }

        //Throw 'em if you've got 'em
        if (vex.getErrors().length>0){
            throw vex;
        }

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


    public FieldOrderCollection getFieldOrderCollection() {
        return fieldOrderCollection;
    }

    public void setFieldOrderCollection(FieldOrderCollection fieldOrderCollection) {
        this.fieldOrderCollection = fieldOrderCollection;
    }

    public ArrayList<FieldType> getFields() {
        return fields;
    }

    public void setFields(ArrayList<FieldType> fields) {
        this.fields = fields;
    }

    public ArrayList<FieldType> getFieldshidden() {
        return fieldshidden;
    }

    public void setFieldshidden(ArrayList<FieldType> fieldshidden) {
        this.fieldshidden = fieldshidden;
    }

    public Calendar getMostRecentEntryDateGMT() {
        if (mostRecentEntryDateGMT==null){
            refreshMostRecentEntryDateGMTFromDB();
        }
        return mostRecentEntryDateGMT;
    }

    public void setMostRecentEntryDateGMT(Calendar mostRecentEntryDateGMT) {
        this.mostRecentEntryDateGMT = mostRecentEntryDateGMT;
    }

    public int getNumberOfLiveEntriesInLog() {
        if (numberOfLiveEntriesInLog==-1){
            refreshNumberOfLiveEntriesInLogFromDB();
        }
        return numberOfLiveEntriesInLog;
    }

    public void setNumberOfLiveEntriesInLog(int numberOfLiveEntriesInLog) {
        this.numberOfLiveEntriesInLog = numberOfLiveEntriesInLog;
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
        try{
            save();
        } catch (ValidationException vex){
            reger.core.Debug.errorsave(vex, "Megalog.java", vex.getErrorsAsSingleString());
        }
    }

    /**
     * Move this item up one by changing its order property, decreasing it one. Keeping same parent.
     */
    public void moveNestedNavUp() {
        nestednavorder = nestednavorder - 1;
        try{
            save();
        } catch (ValidationException vex){
            reger.core.Debug.errorsave(vex, "Megalog.java", vex.getErrorsAsSingleString());
        }
    }

    /**
     * Move to a specified spot on the nav scheme
     */
    public void moveNestedNavTo(int parentType, int parentId, int order) {
        Debug.debug(5, "Megalog.java", "moveNestedNavTo()<br>nestednavlinktext="+getNestedNavLinkText()+"<br>parentType=" + parentType + "<br>parentId=" + parentId + "<br>order="+order);
        nestednavparenttype = parentType;
        nestednavparentid = parentId;
        nestednavorder = order;
        try{
            save();
        } catch (ValidationException vex){
            reger.core.Debug.errorsave(vex, "Megalog.java", vex.getErrorsAsSingleString());
        }
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
            if (!hiddenfieldInts.contains(megafieldid)){
                hiddenfieldInts.add(megafieldid);
                try{
                    save();
                } catch (ValidationException vex){
                    reger.core.Debug.errorsave(vex, "Megalog.java", vex.getErrorsAsSingleString());
                }
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
        for (Iterator it = hiddenfieldInts.iterator(); it.hasNext(); ) {
            Integer tmpfieldid = (Integer)it.next();
            if(tmpfieldid!=megafieldid){
                out.add(tmpfieldid);
            }
        }
        hiddenfieldInts = out;
        try{
            save();
        } catch (ValidationException vex){
            reger.core.Debug.errorsave(vex, "Megalog.java", vex.getErrorsAsSingleString());
        }
    }

}
