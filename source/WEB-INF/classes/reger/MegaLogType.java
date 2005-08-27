package reger;

import reger.mega.Field;
import reger.mega.FieldType;
import reger.mega.FieldTypeFactory;
import reger.mega.FieldOrderCollection;
import reger.core.db.Db;
import reger.core.Util;

import java.util.*;

/**
 * Represents a Log
 */
public class MegaLogType {

    private int eventtypeid;
    private int accountuserid;
    private String megalogname="";
    private String description="";
    private String longdescription="";
    private boolean showlocation;
    private String icon="";
    private boolean showonhomepage=true;
    private int issystemlogtype;
    private boolean isprivate=false;
    private String fieldorder = "";
    private int[] hiddenfields = new int[0];
    private FieldOrderCollection fieldOrderCollection;

    private FieldType[] megaFields;
    private FieldType[] megaFieldsHidden;

    public MegaLogType(int eventtypeid){
        this.eventtypeid = eventtypeid;
        load();
    }

    public MegaLogType(int accountuserid, String megalogname, String description, String longdescription, boolean showlocation, String icon, boolean showonhomepage, int issystemlogtype, FieldType[] megaFields, boolean isprivate, String fieldorder, int[] hiddenfields, FieldType[] megaFieldsHidden, FieldOrderCollection fieldOrderCollection){
        this.eventtypeid = -1;
        this.accountuserid = accountuserid;
        this.megalogname = megalogname;
        this.description = description;
        this.longdescription = longdescription;
        this.showlocation = showlocation;
        this.icon = icon;
        this.showonhomepage = showonhomepage;
        this.issystemlogtype = issystemlogtype;
        this.megaFields = megaFields;
        this.megaFieldsHidden = megaFieldsHidden;
        this.isprivate = isprivate;
        this.fieldorder = fieldorder;
        this.hiddenfields = hiddenfields;
        this.fieldOrderCollection = fieldOrderCollection;
    }

    public MegaLogType(MegaLogType mlt){
        this.eventtypeid = mlt.getEventtypeid();
        this.accountuserid = mlt.getAccountuserid();
        this.megalogname = mlt.getMegalogname();
        this.description = mlt.getDescription();
        this.longdescription = mlt.getLongdescription();
        this.showlocation = mlt.getShowlocation();
        this.icon = mlt.getIcon();
        this.showonhomepage = mlt.getShowonhomepage();
        this.issystemlogtype = mlt.getIssystemlogtype();
        this.megaFields = mlt.getMegaFields();
        this.megaFieldsHidden = mlt.getMegaFieldsHidden();
        this.isprivate = mlt.getIsprivate();
        this.fieldorder = mlt.getFieldorder();
        this.hiddenfields = mlt.getHiddenfields();
        this.fieldOrderCollection = mlt.getFieldOrderCollection();
    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstLog= Db.RunSQL("SELECT eventtypeid, accountuserid, megalogname, description, longdescription, showlocation, icon, showonhomepage, issystemlogtype, isprivate, fieldorder, hiddenfields FROM megalogtype WHERE eventtypeid='"+eventtypeid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstLog!=null && rstLog.length>0){
        	for(int i=0; i<rstLog.length; i++){
                this.eventtypeid=Integer.parseInt(rstLog[i][0]);
                accountuserid=Integer.parseInt(rstLog[i][1]);
                megalogname=rstLog[i][2];
                description=rstLog[i][3];
                longdescription=rstLog[i][4];
                if (rstLog[i][5].equals("0")){
                    showlocation=false;
                } else {
                    showlocation=true;
                }

                icon=rstLog[i][6];
                if (rstLog[i][7].equals("0")){
                    showonhomepage=false;
                } else {
                    showonhomepage=true;
                }
                issystemlogtype = Integer.parseInt(rstLog[i][8]);
                isprivate = reger.core.Util.booleanFromSQLText(rstLog[i][9]);

                fieldorder = rstLog[i][10];

                if (!rstLog[i][11].equals("")){
                    try{
                        String[] hf = rstLog[i][11].split("\\|");
                        hiddenfields = new int[hf.length];
                        for (int j = 0; j < hf.length; j++) {
                            if (reger.core.Util.isinteger(hf[j])){
                                hiddenfields[j] = Integer.parseInt(hf[j]);
                            }
                        }
                    } catch (Exception e){
                        reger.core.Util.errorsave(e);
                    }
                }

                //Create fieldOrderCollection
                fieldOrderCollection = new FieldOrderCollection(fieldorder);

                //Load the fields
                loadFields();
        	}
        }
    }

    private void loadFields(){
        reger.core.Util.debug(5, "MegaLogType.loadFields() - calling AllFieldsInSystem.allMegaFieldsForEventtypeid for eventtypeid=" + this.eventtypeid);
        megaFields = reger.AllFieldsInSystem.allMegaFieldsForEventtypeid(this.eventtypeid, false);

        //Hide fields, order fields
        orderFieldsAndSeparateHidden(megaFields);
    }

    private void orderFieldsAndSeparateHidden(FieldType[] inFields){
        //Reset field values
        FieldType[] megaFields = new FieldType[0];
        FieldType[] megaFieldsHidden = new FieldType[0];

        for (int j = 0; j < inFields.length; j++) {
            //Check visibility
            if (!reger.core.Util.isIntInIntArray(inFields[j].getMegafieldid(), hiddenfields)){
                megaFields = AddToArray.addToFieldTypeArray(megaFields, inFields[j]);
            } else {
                megaFieldsHidden = AddToArray.addToFieldTypeArray(megaFieldsHidden, inFields[j]);
            }
        }

        this.megaFields = megaFields;
        this.megaFieldsHidden = megaFieldsHidden;
    }



    public void save(){
        //Make sure we have a log name
        if (megalogname==null || megalogname.equals("")){
            megalogname = "New Log Type";
        }

        String showOnHomePageTxt = "1";
        if (!showonhomepage){
            showOnHomePageTxt = "0";
        }

        String showLocationTxt = "1";
        if (!showlocation){
            showLocationTxt = "0";
        }


        StringBuffer hiddenfieldsForSql = new StringBuffer();
        for (int i = 0; i < hiddenfields.length; i++) {
            hiddenfieldsForSql.append(hiddenfields[i]);
            if (i<(hiddenfields.length-1)){
                hiddenfieldsForSql.append("|");
            }
        }

        //Update the log-type stuff
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE megalogtype SET accountuserid='"+accountuserid+"', megalogname='"+ reger.core.Util.cleanForSQL(megalogname) +"', description='"+ reger.core.Util.cleanForSQL(description) +"', showlocation='"+ showLocationTxt +"', showonhomepage='"+showOnHomePageTxt+"', issystemlogtype='"+issystemlogtype+"', isprivate='"+reger.core.Util.booleanAsSQLText(isprivate)+"', fieldorder='"+reger.core.Util.cleanForSQL(fieldorder)+"' , hiddenfields='"+reger.core.Util.cleanForSQL(hiddenfieldsForSql.toString())+"' WHERE eventtypeid='"+ eventtypeid +"'");
        //-----------------------------------
        //-----------------------------------

        if (count<1){
            //Create a new one
            newMegaLogType();
        }

        //Refresh the in-memory object
        reger.AllMegaLogTypesInSystem.refresh(eventtypeid);
    }

    public void newMegaLogType(){
        //Make sure we have a log name
        if (megalogname==null || megalogname.equals("")){
            megalogname = "New Custom Log Type";
        }

        String showOnHomePageTxt = "1";
        if (!showonhomepage){
            showOnHomePageTxt = "0";
        }

        String showLocationTxt = "1";
        if (!showlocation){
            showLocationTxt = "0";
        }

        //-----------------------------------
        //-----------------------------------
        eventtypeid = Db.RunSQLInsert("INSERT INTO megalogtype(accountuserid, megalogname, description, showlocation, showonhomepage, isprivate) VALUES('"+accountuserid+"', '"+Util.cleanForSQL(megalogname)+"', '"+Util.cleanForSQL(description)+"', '"+Util.cleanForSQL(showLocationTxt)+"', '"+showOnHomePageTxt+"', '"+reger.core.Util.booleanAsSQLText(isprivate)+"')");
        //-----------------------------------
        //-----------------------------------

        //Refresh the in-memory object
        reger.AllMegaLogTypesInSystem.refresh(eventtypeid);
    }

    public void delete(){
        if (AllLogsInSystem.doLogsOfThisTypeExist(eventtypeid)){
            //There are logs of this type in the system
            accountuserid = 0;
            issystemlogtype = 0;
            save();
        } else {
            //There are no logs of this type, just delete it
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("DELETE FROM megalogtype WHERE eventtypeid='"+eventtypeid+"'");
            //-----------------------------------
            //-----------------------------------
        }
    }


    public void removeField(int megafieldid){
        FieldType tmpFt = reger.AllFieldsInSystem.getMegaFieldByMegafieldid(megafieldid);
        if (tmpFt.isThereDataForFieldInDB()){
            //Hide it
            if (!reger.core.Util.isIntInIntArray(megafieldid, hiddenfields)){
                hiddenfields = reger.core.Util.addToIntArray(hiddenfields, megafieldid);
                save();
            }
        } else {
            //Delete it
            tmpFt.deleteField();
        }
    }

    public void unhideField(int megafieldid){
        //Remove from hiddenfields
        reger.core.Util.debug(5, "Field.java - Unhide called on megafieldid=" + megafieldid);
        int[] out = new int[0];
        for (int i = 0; i < hiddenfields.length; i++) {
            if(hiddenfields[i]!=megafieldid){
                out = reger.core.Util.addToIntArray(out, hiddenfields[i]);
            }
        }
        hiddenfields = out;
        save();
    }


    public int getEventtypeid() {
        return eventtypeid;
    }

    public int getAccountuserid() {
        return accountuserid;
    }

    public String getMegalogname() {
        return megalogname;
    }

    public String getDescription() {
        if (description==null){
            return "";
        }
        return description;
    }

    public String getLongdescription() {
        return longdescription;
    }

    public boolean getShowlocation() {
        return showlocation;
    }

    public boolean getIsuserdefined() {
        if (accountuserid>0){
            return true;
        } else {
            return false;
        }
    }

    public String getIcon() {
        return icon;
    }



    public boolean getShowonhomepage() {
        return showonhomepage;
    }

    public FieldType[] getMegaFields() {
        FieldType[] out = new FieldType[0];
        if (megaFields!=null){
            for (int i = 0; i < megaFields.length; i++) {
                out = AddToArray.addToFieldTypeArray(out, (FieldType)megaFields[i].clone());
            }
        }
        return out;
    }

    public int getIssystemlogtype() {
        return issystemlogtype;
    }

    public void setIssystemlogtype(int issystemlogtype) {
        this.issystemlogtype = issystemlogtype;
    }

    public void setEventtypeid(int eventtypeid) {
        this.eventtypeid = eventtypeid;
    }

    public void setAccountuserid(int accountuserid) {
        this.accountuserid = accountuserid;
    }

    public void setMegalogname(String megalogname) {
        this.megalogname = megalogname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLongdescription(String longdescription) {
        this.longdescription = longdescription;
    }

    public void setShowlocation(boolean showlocation) {
        this.showlocation = showlocation;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }



    public void setShowonhomepage(boolean showonhomepage) {
        this.showonhomepage = showonhomepage;
    }

    public void setMegaFields(FieldType[] megaFields) {
        this.megaFields = megaFields;
    }

    public boolean getIsprivate() {
        return isprivate;
    }

    public void setIsprivate(boolean isprivate) {
        this.isprivate = isprivate;
    }

    public String getFieldorder() {
        return fieldorder;
    }

    public int[] getHiddenfields() {
        return hiddenfields;
    }

    public FieldType[] getMegaFieldsHidden() {
        return megaFieldsHidden;
    }

    public void setFieldorder(String fieldorder) {
        this.fieldorder = fieldorder;
    }

    public void setHiddenfields(int[] hiddenfields) {
        this.hiddenfields = hiddenfields;
    }

    public void setMegaFieldsHidden(FieldType[] megaFieldsHidden) {
        this.megaFieldsHidden = megaFieldsHidden;
    }

    public FieldOrderCollection getFieldOrderCollection() {
        return fieldOrderCollection;
    }
}
