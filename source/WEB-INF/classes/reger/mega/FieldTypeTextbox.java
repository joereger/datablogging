package reger.mega;

import reger.AddToArray;
import reger.cache.providers.jboss.Cacheable;
import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Iterator;

import org.jdom.Element;

/**
 * A dropdown field
 */
@Cacheable
public class FieldTypeTextbox extends Field implements FieldType, ChartField{


    //Field data - These properties define the data type for this field

    //This is the name that's used in the name/value pair.  This is specific to this FieldType and is not part of the interface.
    String NAMEOFDATAVALUE = "";

    private ArrayList<FieldData> fieldData = new ArrayList<FieldData>();

    public FieldTypeTextbox(){
        fieldData.add(0, new FieldData(NAMEOFDATAVALUE, ""));
    }

    public FieldTypeTextbox(FieldTypeTextbox field){
        this.fieldData = new ArrayList<FieldData>();
        for (Iterator it = field.getDataForField().iterator(); it.hasNext(); ) {
            FieldData fldDataTmp = (FieldData)it.next();
            this.fieldData.add(0, new FieldData(fldDataTmp));
        }
        populateFromAnotherField(field);
    }

    /**
     * Called to load possible values and do any other startup work.
     */
    public void initialize() {

    }

    /**
     * Friendly name
     */
    public String getBackEndFriendlyName() {
        return "Text Input Box";
    }

    /**
     * Description of this field type
     */
    public String getBackEndDescription() {
        return "A standard text box that accepts keyboard entry.";
    }

    /**
     * Field name
     */
//    public String getFieldname() {
//        return this.fieldname;
//    }

    /**
     * Description of this field
     */
//    public String getFielddescription() {
//        return this.fielddescription;
//    }

    /**
     * Get the megadatatypeid
     */
//    public int getMegadatatypeid() {
//        return this.megadatatypeid;
//    }

    /**
     * An integer array of the acceptable data types for this field.
     * The integer keys to data type are stored at reger.Vars.DATATYPE*
     */
    public int[] getAcceptableDataTypes() {
        int[] acceptableTypes = new int[3];
        acceptableTypes[0] = reger.mega.DataTypeString.DATATYPEID;
        acceptableTypes[1] = reger.mega.DataTypeInteger.DATATYPEID;
        acceptableTypes[2] = reger.mega.DataTypeDecimal.DATATYPEID;
        return acceptableTypes;
    }

    public int getDefaultDataType(){
        return reger.mega.DataTypeString.DATATYPEID;
    }


    /**
     * Returns an array of FieldData objects which represent the data held in this field.
     */
    public ArrayList<FieldData> getDataForField() {
        return fieldData;
    }

    /**
     * Returns an array of empty FieldData objects that demonstrate the name/value pairs that this field generates/accepts/works with
     */
    public ArrayList<FieldData> getEmptyDataFields() {
        ArrayList<FieldData> fd = new ArrayList<FieldData>();
        fd.add(new FieldData(NAMEOFDATAVALUE, ""));
        return fd;
    }


    /**
     * Displays html for add/edit capability.
     */
    public String getHtmlAdmin(int logid, boolean isFormActive) {
        StringBuffer outstring = new StringBuffer();

        //isFormActive determines whether the form is turned on or off
        String disabledFormText = "";
        if (!isFormActive){
            disabledFormText = "disabled=\"true\"";
        }

	    outstring.append("<input type=text name=megafieldid-"+megafieldid+" value=\""+reger.core.Util.cleanForHtml(this.fieldData.get(0).getValue())+"\" size=10 maxlength=255 "+disabledFormText+">");

		return outstring.toString();
    }

    /**
     * Displays SAMPLE html for add/edit capability.
     */
    public String getHtmlAdminSample() {
        return getHtmlAdmin(-1, true);
    }

    /**
     * Displays html for public.
     */
    public String getHtmlPublic(int logid) {
        StringBuffer mb = new StringBuffer();
        mb.append("<font face=arial size=-1>");
        if (this.fieldData.get(0).getValue().equals("")){
            mb.append("&nbsp;");
        } else {
            mb.append(this.fieldData.get(0).getValue());
        }
        mb.append("</font>");
        return mb.toString();
    }

    /**
     * Displays SAMPLE html for public display.
     */
    public String getHtmlPublicSample() {
        return "The Value Entered";
    }


    /**
     * Accepts an array of eventid's and returns a set of values for this field
     * corresponding to those eventid's.
     */
    public java.util.TreeMap getChartDataForField(int[] eventids) {
        FieldDAOSimple sm = new FieldDAOSimple();
        return sm.loadDataForMultipleEvents(eventids, this);
    }



    /**
     * Accept an http request and populate the data of this object
     */
     public void populateFromRequest(HttpServletRequest request){

        //Find the value
        if (request.getParameter("megafieldid-" + this.megafieldid)!=null){
            this.fieldData.get(0).setValue(request.getParameter("megafieldid-" + this.megafieldid));
        } else {
            this.fieldData.get(0).setValue("");
        }

        //Look for new values, which will override old ones
        if (request.getParameter("megafieldid-new-" + this.megafieldid)!=null && !request.getParameter("megafieldid-new-" + this.megafieldid).equals("")){
            this.fieldData.get(0).setValue(request.getParameter("megafieldid-new-" + this.megafieldid));
        }

     }

     /**
     * Populate the data for this field for a particular eventid.
     * Use a FieldDAO object to do this.
     */
     public void loadDataForEventid(int eventid, int logid){
        FieldDAOSimple sm = new FieldDAOSimple();
        sm.loadData(this.megafieldid, eventid, logid);
        this.fieldData.get(0).setValue(sm.value);
     }

     /**
     * Populate the default data for this field for a particular eventid.
     * Use a FieldDAO object to do this.
     */
     public void loadDefaultData(int logid){
        FieldDAOSimple sm = new FieldDAOSimple();
        sm.loadDefaultData(this.megafieldid, logid);
        this.fieldData.get(0).setValue(sm.value);
     }

     /**
     * Validate the currently stored value in the field.
     */
     public String validateCurrentData(){
        String errortext = "";

        //Check requiredness
        if (isrequired==1){
            if (fieldData.get(0).getValue().equals("")){
                errortext = errortext + ">> " + this.fieldname + " is a required field.<br>";
            }
        }

        //Check data type
        if (!fieldData.get(0).getValue().equals("")){
            DataType dt = reger.mega.DataTypeFactory.get(this.megadatatypeid);
            try{
                dt.validataData(this.fieldData.get(0).getValue());
            } catch (reger.core.ValidationException ex){
                errortext = errortext +  ">> " + this.fieldname + ": " + ex.getErrorsAsSingleString() + "<br>";
            } catch (Exception e){
                Debug.errorsave(e, "");
            }
        }

        return errortext;
     }

    /**
     * Save current value to database using a FieldDAO object
     */
    public void saveToDb(int eventid, int logid) {
        FieldDAOSimple sm = new FieldDAOSimple();
        sm.setValue(this.fieldData.get(0).getValue());
        sm.saveData(this.megafieldid, eventid, logid);
    }

    /**
     * Save current value to database as default  using a FieldDAO object
     */
    public void saveDefaultToDb(int logid) {
        FieldDAOSimple sm = new FieldDAOSimple();
        sm.setValue(this.fieldData.get(0).getValue());
        sm.saveDefaultData(this.megafieldid, logid);
    }

    /**
     * Set timezoneid of display.   If this fieldtype doesn't use timezoneid then the body of this method can be empty.
     */
    public void setTimezoneid(String timezoneid) {

    }

    /**
     * Get timezoneid of display. If this fieldtype doesn't use timezoneid then this can return "".
     */
    public String getTimezoneid() {
        return "";
    }

    /**
     * Returns the Field object that this field is based on.
     * The Field object is the core requirement of a fieldtype.
     * Generally FieldType implementations extend Field.
     */
//    public Field getField() {
//        return this;
//    }

    /**
     * Add empty xAxis values to fill out set.
     * In the case of something like DaysOfTheWeek, often
     * the data will only have data on Mon, Fri.  But
     * the final data set should represent explicitly that
     * Sun, Tue, Wed, Thu and Sat have a value of 0.
     * Incoming is a treemap with
     * (xAxis, yAxis)
     * (xAxis, yAxis)
     * (xAxis, yAxis)
     * If FieldType doesn't need to do this, simply return data unchanged.
     */
    public TreeMap fillEmptyXAxis(TreeMap data) {
        return data;
    }

    /**
     * Delete the data for this field from the database.
     * Typically a FieldDAO object is used so that actual database
     * code is not needed here.
     */
    public void deleteData(int eventid) {
        FieldDAOSimple sm = new FieldDAOSimple();
        sm.deleteData(this.megafieldid, eventid);
    }

    /**
     * Move field data to another logid.
     * With some fieldtypes there is nothing to do as
     * the data is simply tied to eventid.
     * In other cases, like megaoption, the logid is part of the options and must be moved.
     */
    public void moveDataToAnotherLog(int eventid, int oldlogid, int newlogid) {
        FieldDAOSimple sm = new FieldDAOSimple();
        sm.moveDataToNewLogid(this.megafieldid, eventid, oldlogid, newlogid);
    }

    /**
     * Move to new eventid.  All data will be moved.
     */
    public void moveDataToNewEventid(int sourceeventid, int desteventid) {
        FieldDAOSimple sm = new FieldDAOSimple();
        sm.moveDataToNewEventid(this.megafieldid, sourceeventid, desteventid);
    }

    /**
     * Copy to new eventid.  All data will be copied.  Sourceeventid will still have the data.
     */
    public void copyDataToNewEventid(int sourceeventid, int desteventid) {
        FieldDAOSimple sm = new FieldDAOSimple();
        sm.copyDataToNewEventid(this.megafieldid, sourceeventid, desteventid);
    }

    /**
     * Deletes a field, including all data.
     * First, call the DAO's deleteAllDataForAFieldAcrossAllLogsAndEntries method.
     * Next, call the Field object's delete() object.
     * There isn't much logic in this method for FieldType... it's just a caller back to the core and ahead to the DAO.
     */
    public void deleteField() {
        FieldDAOSimple sm = new FieldDAOSimple();
        //Delete extended data
        sm.deleteAllDataForAFieldAcrossAllLogsAndEntries(megafieldid);
        //Delete the field itself
        delete();
    }

    /**
     * Fields can have default system values and options (data) that stay with
     * them for all users.  This data is setup with the logtype (not log) on
     * logs-field.log.  The type of data that can be stored is dependent
     * on the FieldDAO that is used for the FieldType.
     * So, this method in FieldType is little more than a way to pass the request to FieldDAO
     * which will send back a string of HTML to pass to the screen.  All
     * configurations must be done with a simple request form back and forth.
     * Form elements will ne named "systemconfig-*" to avoid collission. Only
     * one FieldType's similar method will be called and displayed on a form at
     * any given time.
     */
    public String processSystemDefaultDataConfig(HttpServletRequest request) {
        FieldDAOSimple sm = new FieldDAOSimple();
        return sm.processSystemDefaultDataConfig(request, megafieldid);
    }

    /**
     * Return the data of this field in the form of a string for the
     * purposes of offensive content validation.
     */
    public String getValuesAsStringForOffensiveContentValidation() {
        return fieldData.get(0).getValue();
    }

    /**
     * Determines whether or not this field fulfills the query
     */
    public boolean fulfillsQuery(FieldQueryElement[] fieldQueryElements, int logidOrEtid) {

        Debug.debug(5, "", "FieldTypeTextbox.java<br>fieldNamePre(logidOrEtid)+\"equalto\"="+fieldNamePre(logidOrEtid)+"equalto"+"<br>equalto=" + FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equalto")[0] + "<br>this.value=" + this.fieldData.get(0).getValue());


        if (this.megadatatypeid==reger.mega.DataTypeString.DATATYPEID){
            //Get the values
            String equalto = FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equalto")[0];
            //Do the evaluation.  If no value for equalto, return true, this is because if nobody's
            //set an explicit value to search for then this data must fulfill it.
            if (equalto.equals("") || equalto.equals(this.fieldData.get(0).getValue())){
                return true;
            }
        } else {
            //Get the values
            Float equalto = null;
            if (reger.core.Util.isnumeric(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equalto")[0])){
                equalto = new Float(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equalto")[0]);
            }
            Float greaterthan = null;
            if (reger.core.Util.isnumeric(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"greaterthan")[0])){
                greaterthan = new Float(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"greaterthan")[0]);
            }
            Float lessthan = null;
            if (reger.core.Util.isnumeric(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"lessthan")[0])){
                lessthan = new Float(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"lessthan")[0]);
            }

            //Get the current value of this field
            Float thisvalue = null;
            if (reger.core.Util.isnumeric(this.fieldData.get(0).getValue())){
                thisvalue = new Float(this.fieldData.get(0).getValue());
            }

            //Do the evaluation
            if (equalto==null && greaterthan==null && lessthan==null){
                return true;
            }
            if (thisvalue!=null){
                if (equalto!=null && equalto.equals(thisvalue)){
                    return true;
                }
                if (greaterthan!=null && lessthan!=null){
                    if (thisvalue.floatValue()>greaterthan.floatValue() && thisvalue.floatValue()<lessthan.floatValue()){
                        return true;
                    }
                } else if (greaterthan!=null && lessthan==null){
                    if (thisvalue.floatValue()>greaterthan.floatValue()){
                        return true;
                    }
                } else if (greaterthan==null && lessthan!=null){
                    if (thisvalue.floatValue()<lessthan.floatValue()){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * A list of FieldQueryElements that can be filled out to search this field type
     */
    public FieldQueryElement[] listOfQueryElementsAccepted(int logidOrEtid) {
        FieldQueryElement[] out = new FieldQueryElement[0];

        if (this.megadatatypeid==reger.mega.DataTypeString.DATATYPEID){
            //Equalto
            FieldQueryElement fq1 = new FieldQueryElement();
            fq1.name = fieldNamePre(logidOrEtid)+"equalto";
            fq1.value = "";
            fq1.datatype = reger.mega.DataTypeString.DATATYPEID;
            fq1.megafieldid = this.megafieldid;
            out = AddToArray.addFieldQueryElementArray(out, fq1);
        } else {
            //Greater Than
            FieldQueryElement fq1 = new FieldQueryElement();
            fq1.name = fieldNamePre(logidOrEtid)+"greaterthan";
            fq1.value = "";
            fq1.datatype = reger.mega.DataTypeDecimal.DATATYPEID;
            fq1.megafieldid = this.megafieldid;
            out = AddToArray.addFieldQueryElementArray(out, fq1);
            //Less Than
            FieldQueryElement fq2 = new FieldQueryElement();
            fq2.name = fieldNamePre(logidOrEtid)+"lessthan";
            fq2.value = "";
            fq2.datatype = reger.mega.DataTypeDecimal.DATATYPEID;
            fq2.megafieldid = this.megafieldid;
            out = AddToArray.addFieldQueryElementArray(out, fq2);
            //Equalto
            FieldQueryElement fq3 = new FieldQueryElement();
            fq3.name = fieldNamePre(logidOrEtid)+"equalto";
            fq3.value = "";
            fq3.datatype = reger.mega.DataTypeDecimal.DATATYPEID;
            fq3.megafieldid = this.megafieldid;
            out = AddToArray.addFieldQueryElementArray(out, fq3);
        }


        return out;
    }


    /**
     * The html used to display a query form.  Note that it must populate itself once submitted.
     */
    public String queryDisplayHtml(FieldQueryElement[] fieldQueryElements, int logidOrEtid) {
        StringBuffer mb = new StringBuffer();

        if (this.megadatatypeid==reger.mega.DataTypeString.DATATYPEID){
            mb.append("<font face=arial size=-2>");
            mb.append("Equals ");
            mb.append("<input type=text name="+fieldNamePre(logidOrEtid)+"equalto value=\""+reger.core.Util.cleanForHtml(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equalto")[0])+"\" size=10 maxlength=255>");
            mb.append("</font>");
        } else {
            mb.append("<font face=arial size=-2>");
            mb.append("Greater Than ");
            mb.append("<input type=text name="+fieldNamePre(logidOrEtid)+"greaterthan value=\""+reger.core.Util.cleanForHtml(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"greaterthan")[0])+"\" size=5 maxlength=255>");
            mb.append("<br>");
            mb.append("Less Than ");
            mb.append("<input type=text name="+fieldNamePre(logidOrEtid)+"lessthan value=\""+reger.core.Util.cleanForHtml(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"lessthan")[0])+"\" size=5 maxlength=255>");
            mb.append("<br>");
            mb.append("Equal To ");
            mb.append("<input type=text name="+fieldNamePre(logidOrEtid)+"equalto value=\""+reger.core.Util.cleanForHtml(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equalto")[0])+"\" size=5 maxlength=255>");
            mb.append("</font>");
        }
        return mb.toString();
    }


    /**
     * The html used to display a summary form of the query.  No input boxes.
     * If there is no user-specified value for this field, return ""
     * Keep this html as short as possible.
     * It's displayed as part of the search flow.
     */
    public String queryDisplayHtmlSummary(FieldQueryElement[] fieldQueryElements, int logidOrEtid) {
        StringBuffer mb = new StringBuffer();

        if (this.megadatatypeid==reger.mega.DataTypeString.DATATYPEID){
            String[] equalto = FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equalto");
            for (int i = 0; i < equalto.length; i++) {
                if (!equalto[i].equals("")){
                    mb.append("Equals: " + equalto[i] + "<br>");
                }
            }
        } else {

            String greaterthan = FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"greaterthan")[0];
            String lessthan = FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"lessthan")[0];
            String equalto = FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equalto")[0];

            if (!greaterthan.equals("")){
                mb.append("Greater Than: ");
                mb.append(greaterthan);
                mb.append("<br>");
            }

            if (!lessthan.equals("")){
                mb.append("Less Than: ");
                mb.append(lessthan);
                mb.append("<br>");
            }

            if (!equalto.equals("")){
                mb.append("Equal To: ");
                mb.append(equalto);
                mb.append("<br>");
            }
        }

        return mb.toString();
    }

    /**
     * Whether or not any data exists in the database for this megafieldid.
     * This is a precursor to either deletion or hiding
     */
    public boolean isThereDataForFieldInDB() {
        FieldDAOSimple sm = new FieldDAOSimple();
        return sm.isThereDataForFieldInDB(megafieldid);
    }

    /**
     * Returns a jdom element describing the XML SCHEMA of this field type.
     */
    public Element getXmlSchemaRepresentationOfFieldType() {
        //Add field stuff that's field-specific which generally boils down to the list of possible values
        reger.mega.DataType dt = reger.mega.DataTypeFactory.get(getMegadatatypeid());
        Element dataType = dt.getXmlSchemaRepresentationOfType();
        //Call back to the generic field to provide most of the field definition
        return getXmlSchemaRepresentationOfField(dataType);
    }

    /**
     * Returns a jdom element with the actual data of the field represented.
     */
    public Element getXmlForFieldData() {
        Element elField = new Element(getFieldnameForApis());
        elField.addContent(fieldData.get(0).getValue());
        return elField;
    }

}
