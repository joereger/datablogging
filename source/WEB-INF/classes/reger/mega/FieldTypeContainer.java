package reger.mega;

import reger.AddToArray;
import reger.cache.jboss.Cacheable;
import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;
import java.util.TreeMap;

import org.jdom.Element;

/**
 * A container field... this holds other fields under it and acts as, well, a container.
 */
@Cacheable
public class FieldTypeContainer extends Field implements FieldType, ChartField{


    //Field data - These properties define the data type for this field

    //This is the name that's used in the name/value pair.  This is specific to this FieldType and is not part of the interface.
    String NAMEOFDATAVALUE = "";

    private FieldData[] fieldData = new FieldData[1];

    public FieldTypeContainer(){
        fieldData[0] = new FieldData(NAMEOFDATAVALUE, "");
    }

    public FieldTypeContainer(FieldTypeContainer field){
        this.fieldData = new FieldData[field.getDataForField().length];
        for (int i = 0; i < field.getDataForField().length; i++) {
            FieldData fldDataTmp = new FieldData(field.getDataForField()[i]);
            this.fieldData[i] = fldDataTmp;
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
        return "Field Container/Label";
    }

    /**
     * Description of this field type
     */
    public String getBackEndDescription() {
        return "This pseudo-field serves to hold other fields under it.";
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
        int[] acceptableTypes = new int[1];
        acceptableTypes[0] = DataTypeString.DATATYPEID;
        return acceptableTypes;
    }

    public int getDefaultDataType(){
        return DataTypeString.DATATYPEID;
    }


    /**
     * Returns an array of FieldData objects which represent the data held in this field.
     */
    public FieldData[] getDataForField() {
        return fieldData;
    }

    /**
     * Returns an array of empty FieldData objects that demonstrate the name/value pairs that this field generates/accepts/works with
     */
    public FieldData[] getEmptyDataFields() {
        FieldData[] fd = new FieldData[1];
        fd[0] = new FieldData("data", "");
        return fd;

    }


    /**
     * Displays html for add/edit capability.
     */
    public String getHtmlAdmin(int logid, boolean isFormActive) {
		return "";
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
        return "";
    }

    /**
     * Displays SAMPLE html for public display.
     */
    public String getHtmlPublicSample() {
        return "";
    }


    /**
     * Accepts an array of eventid's and returns a set of values for this field
     * corresponding to those eventid's.
     */
    public TreeMap getChartDataForField(int[] eventids) {
        return new TreeMap();
    }



    /**
     * Accept an http request and populate the data of this object
     */
     public void populateFromRequest(HttpServletRequest request){

     }

     /**
     * Populate the data for this field for a particular eventid.
     * Use a FieldDAO object to do this.
     */
     public void loadDataForEventid(int eventid, int logid){

     }

     /**
     * Populate the default data for this field for a particular eventid.
     * Use a FieldDAO object to do this.
     */
     public void loadDefaultData(int logid){

     }

     /**
     * Validate the currently stored value in the field.
     */
     public String validateCurrentData(){
        return "";
     }

    /**
     * Save current value to database using a FieldDAO object
     */
    public void saveToDb(int eventid, int logid) {

    }

    /**
     * Save current value to database as default  using a FieldDAO object
     */
    public void saveDefaultToDb(int logid) {

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

    }

    /**
     * Move field data to another logid.
     * With some fieldtypes there is nothing to do as
     * the data is simply tied to eventid.
     * In other cases, like megaoption, the logid is part of the options and must be moved.
     */
    public void moveDataToAnotherLog(int eventid, int oldlogid, int newlogid) {

    }

    /**
     * Move to new eventid.  All data will be moved.
     */
    public void moveDataToNewEventid(int sourceeventid, int desteventid) {

    }

    /**
     * Copy to new eventid.  All data will be copied.  Sourceeventid will still have the data.
     */
    public void copyDataToNewEventid(int sourceeventid, int desteventid) {

    }

    /**
     * Deletes a field, including all data.
     * First, call the DAO's deleteAllDataForAFieldAcrossAllLogsAndEntries method.
     * Next, call the Field object's delete() object.
     * There isn't much logic in this method for FieldType... it's just a caller back to the core and ahead to the DAO.
     */
    public void deleteField() {
        //Delete the field itself
        delete();
        //@todo How to deal with fields inside of this container?
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
        return "";
    }

    /**
     * Return the data of this field in the form of a string for the
     * purposes of offensive content validation.
     */
    public String getValuesAsStringForOffensiveContentValidation() {
        return "";
    }

    /**
     * Determines whether or not this field fulfills the query
     */
    public boolean fulfillsQuery(FieldQueryElement[] fieldQueryElements, int logidOrEtid) {
        return false;
    }

    /**
     * A list of FieldQueryElements that can be filled out to search this field type
     */
    public FieldQueryElement[] listOfQueryElementsAccepted(int logidOrEtid) {
        FieldQueryElement[] out = new FieldQueryElement[0];
        return out;
    }


    /**
     * The html used to display a query form.  Note that it must populate itself once submitted.
     */
    public String queryDisplayHtml(FieldQueryElement[] fieldQueryElements, int logidOrEtid) {
        return "";
    }


    /**
     * The html used to display a summary form of the query.  No input boxes.
     * If there is no user-specified value for this field, return ""
     * Keep this html as short as possible.
     * It's displayed as part of the search flow.
     */
    public String queryDisplayHtmlSummary(FieldQueryElement[] fieldQueryElements, int logidOrEtid) {
        return "";
    }

    /**
     * Whether or not any data exists in the database for this megafieldid.
     * This is a precursor to either deletion or hiding
     */
    public boolean isThereDataForFieldInDB() {
        return false;
    }

    /**
     * Returns a jdom element describing the XML SCHEMA of this field type.
     */
    public Element getXmlSchemaRepresentationOfFieldType() {
        //Add field stuff that's field-specific which generally boils down to the list of possible values
        DataType dt = DataTypeFactory.get(getMegadatatypeid());
        Element dataType = dt.getXmlSchemaRepresentationOfType();
        //Call back to the generic field to provide most of the field definition
        return getXmlSchemaRepresentationOfField(dataType);
    }

    /**
     * Returns a jdom element with the actual data of the field represented.
     */
    public Element getXmlForFieldData() {
        Element elField = new Element(getFieldnameForApis());
        elField.addContent(fieldData[0].getValue());
        return elField;
    }

}
