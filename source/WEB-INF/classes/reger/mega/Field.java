package reger.mega;

import reger.*;
import reger.cache.LogCache;
import reger.core.db.Db;
import reger.core.Debug;
import org.jdom.Element;

/**
 *
 */
public class Field implements Cloneable, FieldInterface {

    public static final int FIELDTYPEDROPDOWN = 1;
    public static final int FIELDTYPEHORIZONTALRADIOS = 2;
    public static final int FIELDTYPEVERTICALRADIOS = 3;
    public static final int FIELDTYPETEXTBOX = 5;
    public static final int FIELDTYPENUMERICRANGE = 7;
    public static final int FIELDTYPETIMEPERIOD = 8;

    public static final int DIRECTIONUP = 1;
    public static final int DIRECTIONDOWN = 2;
    public static final int DIRECTIONLEFT = 3;
    public static final int DIRECTIONRIGHT = 4;

    public static final int EDITFIELDASUSER = 1;
    public static final int EDITFIELDASSYSTEM = 2;

    public static final int EDITFIELDFORLOG = 1;
    public static final int EDITFIELDFOREVENTTYPE = 2;

    //Database values for field
    public int megafieldid = 0;
    public int fieldtype = 0;
    public int eventtypeid = 0;
    public int logid = 0;
    public String fieldname = "";
    public String fielddescription = "";
    public int megadatatypeid = 0;
    public int isrequired = 0;


    public Field(){
        //Do nothing, default values for Field
    }

    public Field(int megafieldid){
        populateFromMegafieldid(megafieldid);
    }

    public Field(Field field){
        populateFromAnotherField(field);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            Debug.errorsave(e, "");
        }
        return null;
    }

    public Field(int fieldtype, int eventtypeid, int logid, String fieldname, String fielddescription, int megadatatypeid, int isrequired){
        this.fieldtype = fieldtype;
        this.eventtypeid = eventtypeid;
        this.fieldname = fieldname;
        this.fielddescription = fielddescription;
        this.megadatatypeid = megadatatypeid;
        this.isrequired = isrequired;
        this.logid = logid;
    }

    public void populateFromAnotherField(Field field){
        this.megafieldid = field.megafieldid;
        this.fieldtype = field.fieldtype;
        this.eventtypeid = field.eventtypeid;
        this.fieldname = field.fieldname;
        this.fielddescription = field.fielddescription;
        this.megadatatypeid = field.megadatatypeid;
        this.isrequired = field.isrequired;
        this.logid = field.logid;
    }


    public void populateFromMegafieldid(int megafieldid){
        Debug.debug(5, "", "Field.java - megafieldid=" + megafieldid);
        //-----------------------------------
        //-----------------------------------
        String[][] rstField= Db.RunSQL("SELECT megafieldid, fieldtype, eventtypeid, fieldname, fielddescription, megadatatypeid, isrequired, logid FROM megafield WHERE megafieldid='"+megafieldid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstField!=null && rstField.length>0){
        	for(int i=0; i<rstField.length; i++){
        	    if (reger.core.Util.isinteger(rstField[i][0])){
        	        this.megafieldid = Integer.parseInt(rstField[i][0]);
                }
        	    if (reger.core.Util.isinteger(rstField[i][1])){
                    fieldtype = Integer.parseInt(rstField[i][1]);
                }
                if (reger.core.Util.isinteger(rstField[i][2])){
                    eventtypeid = Integer.parseInt(rstField[i][2]);
                }

                fieldname = rstField[i][3];
                fielddescription = rstField[i][4];
                if (reger.core.Util.isinteger(rstField[i][5])){
                    megadatatypeid = Integer.parseInt(rstField[i][5]);
                }
                if (reger.core.Util.isinteger(rstField[i][6])){
                    isrequired = Integer.parseInt(rstField[i][6]);
                }

                if (reger.core.Util.isinteger(rstField[i][7])){
                    logid = Integer.parseInt(rstField[i][7]);
                }

                

                Debug.debug(5, "", "Field.java - found and populated field.<br>this.megafieldid=" + this.megafieldid + "<br>fieldname=" + fieldname);
        	}
        }
    }

    /**
     * Get the defined parameters for this field.
     * The FieldParam objects have everything except a value.
     * Override in FieldType when you extend Field.
     */
    public FieldAllParams getParams() {
        return new FieldAllParams(megafieldid);
    }




    /**
     * Creates a new field in the database based on the data stored in this field at the moment of calling.
     */
    public void saveField(){


        StringBuffer debug = new StringBuffer();
        debug.append("Field.java - saveField() called on: " + fieldname + "<br>");
        debug.append("this.logid=" + this.logid + "<br>");
        debug.append("this.eventtypeid=" + this.eventtypeid + "<br>");
        debug.append("logid=" + logid + "<br>");
        debug.append("eventtypeid=" + eventtypeid + "<br>");

        //Determine ownership of eventtype
//        boolean isEventTypeOwnedByUser = false;
//        MegaLogType mlt = AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(this.eventtypeid);
//        if (mlt!=null && mlt.getAccountuserid()==userSessionOfSaver.getAccountuser().getAccountuserid()){
//            isEventTypeOwnedByUser = true;
//        }
//        debug.append("isEventTypeOwnedByUser="+isEventTypeOwnedByUser+"<br>");

        //Determine ownership of field
//        boolean isFieldOwnedByUser = isFieldOwnedByAccountuser(userSessionOfSaver.getAccountuser());
//        debug.append("isFieldOwnedByUser="+isFieldOwnedByUser+"<br>");


        if (fieldname==null || fieldname.equals("")) {
            fieldname="New Field";
        }

        if (megadatatypeid<=0) {
            megadatatypeid=reger.mega.DataTypeString.DATATYPEID;
        }

        saveMegafieldid();

        //User editing
//        if (EDITFIELDAS==EDITFIELDASUSER){
//            debug.append("Field will be edited as USER.<br>");
//            //Determine whether to attach this field to a log or to an eventtype
//            if (EDITFIELDFOR==EDITFIELDFORLOG){
//                debug.append("Field will be edited for LOG.<br>");
//                this.logid=logid;
//                this.eventtypeid=0;
//                debug.append("this.logid=" + this.logid + "<br>");
//                debug.append("this.eventtypeid=" + this.eventtypeid + "<br>");
//                debug.append("logid=" + logid + "<br>");
//                debug.append("eventtypeid=" + eventtypeid + "<br>");
//                if (megafieldid==-1){
//                    //Create a new field for this user which they'll own
//                    saveMegafieldid();
//                } else if (isFieldOwnedByUser){
//                    //Even though the user owns the field, they may also own the eventtypeid and since they're editing for LOG, they should then override
//                    saveMegafieldid();
//                } else {
//                    //The user doesn't own the field so they should override it
//
//                }
//            } else if (EDITFIELDFOR==EDITFIELDFOREVENTTYPE){
//                debug.append("Field will be edited for EVENTTYPE.<br>");
//                this.logid=0;
//                this.eventtypeid=eventtypeid;
//                debug.append("this.logid=" + this.logid + "<br>");
//                debug.append("this.eventtypeid=" + this.eventtypeid + "<br>");
//                debug.append("logid=" + logid + "<br>");
//                debug.append("eventtypeid=" + eventtypeid + "<br>");
//                if (isFieldOwnedByUser || megafieldid==-1){
//                    saveMegafieldid();
//                } else {
//                    //Do nothing... shouldn't ever happen that you're editing an eventtype where the fields don't belong to you
//                }
//            }
//        //Sysadmin editing
//        } else if (EDITFIELDAS==EDITFIELDASSYSTEM){
//            debug.append("Field will be edited as SYSTEM.<br>");
//            if (EDITFIELDFOR==EDITFIELDFORLOG){
//                this.logid=logid;
//                this.eventtypeid=0;
//                //Can't happen right now
//            } else if (EDITFIELDFOR==EDITFIELDFOREVENTTYPE){
//                this.logid=0;
//                this.eventtypeid=eventtypeid;
//                saveMegafieldid();
//            }
//        }


        //Record debug
        Debug.debug(5, "", debug.toString());


    }



    private void saveMegafieldid(){
        //Try to update.
        StringBuffer debug = new StringBuffer();
        debug.append("Field.java - saveMegafieldid() trying to update megafield " + fieldname + "<br>this.logid=" + this.logid + "<br>this.eventtypeid=" + this.eventtypeid + "<br>");


        //-----------------------------------
        //-----------------------------------
        String[][] rstChk= Db.RunSQL("SELECT count(*) FROM megafield WHERE megafieldid='"+ megafieldid +"' AND logid='"+logid+"' AND eventtypeid='"+eventtypeid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstChk!=null && rstChk.length>0 && Integer.parseInt(rstChk[0][0])>0){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE megafield SET fieldname='"+ reger.core.Util.cleanForSQL(fieldname) +"', fielddescription='"+ reger.core.Util.cleanForSQL(fielddescription) +"', fieldtype='"+ fieldtype +"', eventtypeid='"+ this.eventtypeid +"',  isrequired='"+ isrequired +"', megadatatypeid='"+ megadatatypeid +"', logid='"+this.logid+"' WHERE megafieldid='"+ megafieldid +"' AND logid='"+logid+"' AND eventtypeid='"+eventtypeid+"'");
            //-----------------------------------
            //-----------------------------------
        } else {
            debug.append("Field.java - saveField() creating new record " + fieldname+ "<br>");
            //Create the new field in the database
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO megafield(fieldtype, fieldname, fielddescription, isrequired, megadatatypeid, eventtypeid, logid) VALUES('"+ fieldtype +"', '"+ reger.core.Util.cleanForSQL(fieldname) +"', '"+ reger.core.Util.cleanForSQL(fielddescription) +"', '"+ isrequired +"', '"+ megadatatypeid +"', '"+ this.eventtypeid +"', '"+this.logid+"')");
            //-----------------------------------
            //-----------------------------------

            this.megafieldid=identity;
        }


        //Refresh any logs in the system that are using this field
        //For performance only refresh those affected
        //The order of the refresh is important too
        AllFieldsInSystem.refresh(megafieldid);
        AllMegaLogTypesInSystem.refresh(eventtypeid);
        LogCache.flushByMegafieldid(megafieldid);
        LogCache.flushByEventtypeid(eventtypeid);
        LogCache.flushByLogid(logid);

        debug.append("this.megafieldid=" + this.megafieldid);

        Debug.debug(5, "Field.java", debug.toString());
    }







    /**
     * A value of -1 is a system field
     */
    public boolean isFieldOwnedByAccountuser(Accountuser au){
        StringBuffer debug = new StringBuffer();
        debug.append("Field.java - isFieldOwnedByAccountuser()<br>");


        if (eventtypeid>0){
            //This field is part of a log type so I look to log type to see if this user owns it
            MegaLogType mt = AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(eventtypeid);
            if (mt!=null){
                if (au.getAccountuserid() == mt.getAccountuserid()){
                    return true;
                }
            }
        } else if (logid>0){
            //This field is part of a log so I look to the account that the log belongs to
            Log logByLogid = LogCache.get(logid);
            if (logByLogid!=null){
                if (au.getAccountid()==logByLogid.getAccountid()){
                    if (au.userCanDoAcl("CUSTOMIZELOG", au.getAccountid())){
                        return true;
                    }
                }
            }
        } else {
            //Field isn't (yet) associated with a logid or eventtypeid
        }


        return false;
    }


    public void delete(){
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM megafield WHERE megafieldid='"+megafieldid+"'");
        //-----------------------------------
        //-----------------------------------

        //-----------------------------------
        //-----------------------------------
        int count3 = Db.RunSQLUpdate("DELETE FROM megafieldparam WHERE megafieldid='"+megafieldid+"'");
        //-----------------------------------
        //-----------------------------------

        //Refresh any logs in the system that are using this field
        //For performance only refresh those affected
        //The order of the refresh is important too
        AllFieldsInSystem.refresh(megafieldid);
        AllMegaLogTypesInSystem.refresh(eventtypeid);
        LogCache.flushByMegafieldid(megafieldid);
        LogCache.flushByLogid(logid);
    }


    /**
     * Get populated FieldQueryElements from a request.
     * Format is defined in 
     */
    public FieldQueryElement[] populateFieldQueryElements(javax.servlet.http.HttpServletRequest request, FieldQueryElement[] fieldQueryElements){
        for (int i = 0; i < fieldQueryElements.length; i++) {
            if (request.getParameter("megafieldid-"+fieldQueryElements[i].megafieldid+"-fqe-"+fieldQueryElements[i].name)!=null){
                if (!request.getParameter("megafieldid-"+fieldQueryElements[i].megafieldid+"-fqe-"+fieldQueryElements[i].name).equals("")){
                    fieldQueryElements[i].value = request.getParameter("megafieldid-"+fieldQueryElements[i].megafieldid+"-fqe-"+fieldQueryElements[i].name);
                }
            }
        }
        return fieldQueryElements;
    }

    public String fieldNamePre(int logidOrEtid){
        String out = FieldQueryElement.fqeParameterNameIdentifier() + this.megafieldid + "-logid-" + logidOrEtid + "-";
        return out;
    }

    public static int parseFieldidFromFieldName(String fieldName){
        int fieldid=-1;

        String[] split = fieldName.split("-");
        if (split.length>=3){
            if (reger.core.Util.isinteger(split[2])){
                fieldid = Integer.parseInt(split[2]);
            }
        }

        return fieldid;
    }

    public static int parseLogidFromFieldName(String fieldName){
        int logid=-1;

        String[] split = fieldName.split("-");
        if (split.length>=5){
            if (reger.core.Util.isinteger(split[4])){
                logid = Integer.parseInt(split[4]);
            }
        }

        return logid;
    }


    public int getMegafieldid() {
        return megafieldid;
    }

    public int getFieldtype() {
        return fieldtype;
    }

    public int getEventtypeid() {
        return eventtypeid;
    }


    public String getFieldname() {
        return fieldname;
    }

    /**
     * Strips spaces and any non alphanumeric chars to create a nice
     * <fieldname></fieldname> friendly name
     */
    public String getFieldnameForApis() {
        if (fieldname!=null){
            return reger.core.Util.xmlFieldNameClean(fieldname);
        }
        return "";
    }

    public String getFielddescription() {
        return fielddescription;
    }

    public int getMegadatatypeid() {
        return megadatatypeid;
    }

    public int getIsrequired() {
        return isrequired;
    }



    public void setIsrequired(int isrequired) {
        this.isrequired = isrequired;
    }

    public void setFielddescription(String fielddescription) {
        this.fielddescription = fielddescription;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }



//    public static FieldType[] getFieldsForEventTypeOrLogid(int eventtypeid, int logid){
//        FieldType[] fldsOut = null;
//        if (eventtypeid>0){
//            fldsOut = reger.AllFieldsInSystem.allMegaFieldsForEventtypeid(eventtypeid, false, false, new int[0], new int[0]);
//        }
//        if (logid>0){
//            fldsOut = reger.cache.LogCache.get(logid).getFields();
//        }
//        return fldsOut;
//
//    }

//    public static FieldType[] getFieldsForEventTypeOrLogidFromDB(int eventtypeid, int logid, boolean includeHidden){
//        FieldType[] fldsOut = null;
//        if (eventtypeid>0){
//            fldsOut = reger.AllFieldsInSystem.allMegaFieldsForEventtypeid(eventtypeid, includeHidden, false);
//        }
//        if (logid>0){
//            fldsOut = reger.AllFieldsInSystem.allMegaFieldsForLog(logid, eventtypeid, includeHidden);
//        }
//        return fldsOut;
//
//
//    }








    public void setIsrequired(boolean isrequired) {
        if (isrequired){
            this.isrequired = 1;
        } else {
            this.isrequired = 0;
        }
    }

    public void setMegadatatypeid(int megadatatypeid) {
        this.megadatatypeid = megadatatypeid;
    }

    public void setEventtypeid(int eventtypeid) {
        this.eventtypeid = eventtypeid;
    }

    public void setFieldtype(int fieldtype) {
        this.fieldtype = fieldtype;
    }

    public int getLogid() {
        return logid;
    }

    public void setLogid(int logid) {
        this.logid = logid;
    }


    public void setMegafieldid(int megafieldid) {
        this.megafieldid = megafieldid;
    }

    public Element getXmlSchemaRepresentationOfField(Element fieldTypeSpecific) {
        Element elField = new Element("element", reger.MegaLogTypeXmlSchemaRenderer.xsNs);
        elField.setAttribute("name", getFieldnameForApis());
        //Fieldtype/ui-display-type
        //@todo Create a text list of field types (i.e. dropdown, checkboxes, radios, etc.)
        Element attr = new Element("attribute", reger.MegaLogTypeXmlSchemaRenderer.xsNs);
        attr.setAttribute("name","ui-display-type");
        attr.setAttribute("use","optional");
        elField.addContent(attr);
            Element st = new Element("simpleType", reger.MegaLogTypeXmlSchemaRenderer.xsNs);
            attr.addContent(st);
                Element rest = new Element("restriction", reger.MegaLogTypeXmlSchemaRenderer.xsNs);
                rest.setAttribute("base","xs:string");
                st.addContent(rest);
                    Element enum1 = new Element("enumeration", reger.MegaLogTypeXmlSchemaRenderer.xsNs);
                    enum1.setAttribute("name", "dropdown");
                    rest.addContent(enum1);
                    Element enum2 = new Element("enumeration", reger.MegaLogTypeXmlSchemaRenderer.xsNs);
                    enum2.setAttribute("name", "textbox");
                    rest.addContent(enum2);
                    Element enum3 = new Element("enumeration", reger.MegaLogTypeXmlSchemaRenderer.xsNs);
                    enum3.setAttribute("name", "radiobuttons");
                    rest.addContent(enum3);

        //Requiredness
        Element attr2 = new Element("attribute", reger.MegaLogTypeXmlSchemaRenderer.xsNs);
        attr2.setAttribute("name","required");
        attr2.setAttribute("use","optional");
        elField.addContent(attr2);
            Element st2 = new Element("simpleType", reger.MegaLogTypeXmlSchemaRenderer.xsNs);
            attr2.addContent(st2);
                Element rest2 = new Element("restriction", reger.MegaLogTypeXmlSchemaRenderer.xsNs);
                rest2.setAttribute("base","xs:boolean");
                st2.addContent(rest2);

        //Restrictions/datatype, created in FieldType
        elField.addContent(fieldTypeSpecific);


        return elField;
    }

}
