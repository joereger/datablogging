package reger.mega;

import reger.AddToArray;
import reger.cache.providers.jboss.Cacheable;
import reger.core.Debug;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

import org.jdom.Element;

/**
 * A time period
 */
@Cacheable
public class FieldTypeTimeperiod extends Field implements FieldType, ChartField{


    //Field data - These properties define the data type for this field

    //This is the name that's used in the name/value pair.  This is specific to this FieldType and is not part of the interface.
    String NAMEOFDATAVALUE = "";

    private ArrayList<FieldData> fieldData = new ArrayList<FieldData>();

    public FieldTypeTimeperiod(){
        fieldData.add(0, new FieldData(NAMEOFDATAVALUE, ""));
    }

    public FieldTypeTimeperiod(FieldTypeTimeperiod field){
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
        return "HH:MM:SS Time Period";
    }

    /**
     * Description of this field type
     */
    public String getBackEndDescription() {
        return "This measures a time period or duration... not a particular time of day.";
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
//        return reger.mega.DataTypeInteger.DATATYPEID;
//    }

    /**
     * An integer array of the acceptable data types for this field.
     * The integer keys to data type are stored at reger.Vars.DATATYPE*
     */
    public int[] getAcceptableDataTypes() {
        int[] acceptableTypes = new int[1];
        acceptableTypes[0] = reger.mega.DataTypeInteger.DATATYPEID;
        return acceptableTypes;
    }

    public int getDefaultDataType(){
        return reger.mega.DataTypeInteger.DATATYPEID;
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

        reger.core.Debug.debug(5, "FieldTypeTimeperiod.java", "Into getHtmlAdmin()<br>fieldData.get(0).getValue()=" + fieldData.get(0).getValue());

        //isFormActive determines whether the form is turned on or off
        String disabledFormText = "";
        if (!isFormActive){
            disabledFormText = "disabled=\"true\"";
        }

	    //Need to break the currentrequestvalue into Hours, Minutes, Seconds
		reger.core.HoursMinutesSeconds hms = new reger.core.HoursMinutesSeconds(0);


		//Populate the hms object with the correct number of baseSeconds
		if (reger.core.Util.isinteger(fieldData.get(0).getValue())){
            hms = new reger.core.HoursMinutesSeconds(Integer.parseInt(fieldData.get(0).getValue()));
            reger.core.Debug.debug(5, "FieldTypeTimeperiod.java", "Into getHtmlAdmin()<br>fieldData.get(0).getValue() determined to be integer");
        }

        outstring.append("<table><tr><td nowrap>");
        outstring.append("<font face=arial size=-2>");
        outstring.append("<input class=\"span1\" type=text size=2 maxlength=5 name=megafieldid-"+ megafieldid + "-hours value=\""+ hms.getHours() +"\" "+disabledFormText+">");
        outstring.append("hrs &nbsp;:&nbsp; ");
        outstring.append("<input class=\"span1\" type=text size=2 maxlength=5 name=megafieldid-"+ megafieldid + "-minutes value=\""+ hms.getMinutes() +"\" "+disabledFormText+">");
        outstring.append("min &nbsp;:&nbsp; ");
        outstring.append("<input class=\"span1\" type=text size=2 maxlength=5 name=megafieldid-"+ megafieldid + "-seconds value=\""+ hms.getSeconds() +"\" "+disabledFormText+">");
        outstring.append("sec");
        outstring.append("</font>");
        outstring.append("</td></tr></table>");

        reger.core.Debug.debug(5, "FieldTypeTimeperiod.java", "Into getHtmlAdmin() - output<br>"+outstring.toString());



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
        StringBuffer outstring = new StringBuffer();

	    //Need to break the currentrequestvalue into Hours, Minutes, Seconds
		reger.core.HoursMinutesSeconds hms = new reger.core.HoursMinutesSeconds(0);


		//Populate the hms object with the correct number of baseSeconds
		if (reger.core.Util.isinteger(fieldData.get(0).getValue())){
            hms = new reger.core.HoursMinutesSeconds(Integer.parseInt(fieldData.get(0).getValue()));
        }


        outstring.append("<table><tr><td nowrap>");
        outstring.append( hms.getHours() );
        outstring.append("hrs &nbsp;:&nbsp; ");
        outstring.append( hms.getMinutes() );
        outstring.append("min &nbsp;:&nbsp; ");
        outstring.append( hms.getSeconds() );
        outstring.append("sec");
        outstring.append("</td></tr></table>");


		return outstring.toString();
    }

    /**
     * Displays SAMPLE html for public display.
     */
    public String getHtmlPublicSample() {
        return "12hrs:34min:54sec";
    }


    /**
     * Accepts an array of eventid's and returns a set of values for this field
     * corresponding to those eventid's.
     */
    public java.util.TreeMap getChartDataForField(int[] eventids) {
        FieldDAOSimple sm = new FieldDAOSimple();
        java.util.TreeMap data = sm.loadDataForMultipleEvents(eventids, this);
        java.util.TreeMap newTmap = new java.util.TreeMap();
        //Convert to milliseconds
        double newvalue;
        for (Iterator i=data.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry e = (Map.Entry) i.next();
            //out.println(e.getKey() + ": " + e.getValue());
            //Convert to millis by multiplying by 1000
            newvalue = 1000 * Double.parseDouble(e.getValue().toString());
            //Add to newTmap
            newTmap.put(e.getKey(), new Double(newvalue));
        }
        return newTmap;
    }



    /**
     * Accept an http request and populate the data of this object
     */
     public void populateFromRequest(HttpServletRequest request){
        //reger.core.Util.logtodb("Populating from request object.");

        //Conversion from time needed
        int h=0;
        int m=0;
        int s=0;
        //Now go grab each value individually and directly from the
        if (request.getParameter("megafieldid-" + megafieldid + "-hours")!=null && reger.core.Util.isinteger(request.getParameter("megafieldid-" + megafieldid + "-hours"))){
            h = Integer.parseInt(request.getParameter("megafieldid-" + megafieldid + "-hours"));
        }
        if (request.getParameter("megafieldid-" + megafieldid + "-minutes")!=null && reger.core.Util.isinteger(request.getParameter("megafieldid-" + megafieldid + "-minutes"))){
            m = Integer.parseInt(request.getParameter("megafieldid-" + megafieldid + "-minutes"));
        }
        if (request.getParameter("megafieldid-" + megafieldid + "-seconds")!=null && reger.core.Util.isinteger(request.getParameter("megafieldid-" + megafieldid + "-seconds"))){
            s = Integer.parseInt(request.getParameter("megafieldid-" + megafieldid + "-seconds"));
        }
        //Finally, set the value
        this.fieldData.get(0).setValue(String.valueOf((h*3600)+(m*60)+(s)));

        //reger.core.Util.logtodb("Value is set from request object to: " + value);
     }

     /**
     * Populate the data for this field for a particular eventid.
     * Use a FieldDAO object to do this.
     */
     public void loadDataForEventid(int eventid, int logid){
        reger.core.Debug.debug(5, "FieldTypeTimeperiod.java", "Getting data for<br>megafieldid: " +this.megafieldid+ "<br>eventid: " + eventid + "<br>logid: " + logid);
        FieldDAOSimple sm = new FieldDAOSimple();
        sm.loadData(this.megafieldid, eventid, logid);
        this.fieldData.get(0).setValue(sm.value);
        reger.core.Debug.debug(5, "FieldTypeTimeperiod.java", "Getting data for<br>megafieldid: " +this.megafieldid+ "<br>eventid: " + eventid + "<br>logid: " + logid + "<br>this.fieldData.get(0).getValue()=" + this.fieldData.get(0).getValue());
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
        //reger.core.Util.logtodb("Validating data.  this.value=" + this.value);
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
        //reger.core.Util.logtodb("In FieldTypeDropdown.saveToDb.  About to call sm.saveData<br>this.value: " +this.value+ "<br>eventid: " + eventid + "<br>logid: " + logid);
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


        Debug.debug(5, "", "FieldTypeTimeperiod.java<br>fieldNamePre(logidOrEtid)+\"equalto\"="+fieldNamePre(logidOrEtid)+"equalto"+"<br>equalto=" + FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equalto")[0] + "<br>this.value=" + this.fieldData.get(0).getValue());


        //Get the values
        Float equaltohours = null;
        if (reger.core.Util.isnumeric(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equaltohours")[0])){
            equaltohours = new Float(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equaltohours")[0]);
        }
        Float equaltominutes = null;
        if (reger.core.Util.isnumeric(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equaltominutes")[0])){
            equaltominutes = new Float(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equaltominutes")[0]);
        }
        Float equaltoseconds = null;
        if (reger.core.Util.isnumeric(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equaltoseconds")[0])){
            equaltoseconds = new Float(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equaltoseconds")[0]);
        }

        Float greaterthanhours = null;
        if (reger.core.Util.isnumeric(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"greaterthanhours")[0])){
            greaterthanhours = new Float(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"greaterthanhours")[0]);
        }
        Float greaterthanminutes = null;
        if (reger.core.Util.isnumeric(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"greaterthanminutes")[0])){
            greaterthanminutes = new Float(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"greaterthanminutes")[0]);
        }
        Float greaterthanseconds = null;
        if (reger.core.Util.isnumeric(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"greaterthanseconds")[0])){
            greaterthanseconds = new Float(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"greaterthanseconds")[0]);
        }

        Float lessthanhours = null;
        if (reger.core.Util.isnumeric(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"lessthanhours")[0])){
            lessthanhours = new Float(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"lessthanhours")[0]);
        }
        Float lessthanminutes = null;
        if (reger.core.Util.isnumeric(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"lessthanminutes")[0])){
            lessthanminutes = new Float(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"lessthanminutes")[0]);
        }
        Float lessthanseconds = null;
        if (reger.core.Util.isnumeric(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"lessthanseconds")[0])){
            lessthanseconds = new Float(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"lessthanseconds")[0]);
        }

        //Now, coagulate the h:m:s into one seconds-based value
        Float equalto = null;
        try{
            equalto = new Float((equaltohours.floatValue()*3600)+(equaltominutes.floatValue()*60)+(equaltoseconds.floatValue()));
        } catch (Exception e){
            Debug.debug(5, "", e);
        }
        Float greaterthan = null;
        try{
            greaterthan = new Float((greaterthanhours.floatValue()*3600)+(greaterthanminutes.floatValue()*60)+(greaterthanseconds.floatValue()));
        } catch (Exception e){
            Debug.debug(5, "", e);
        }
        Float lessthan = null;
        try{
            lessthan = new Float((lessthanhours.floatValue()*3600)+(lessthanminutes.floatValue()*60)+(lessthanseconds.floatValue()));
        } catch (Exception e){
            Debug.debug(5, "", e);
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

        return false;
    }

    /**
     * A list of FieldQueryElements that can be filled out to search this field type
     */
    public FieldQueryElement[] listOfQueryElementsAccepted(int logidOrEtid) {
        FieldQueryElement[] out = new FieldQueryElement[0];

        //Greater Than Hours
        FieldQueryElement fq1 = new FieldQueryElement();
        fq1.name = fieldNamePre(logidOrEtid)+"greaterthanhours";
        fq1.value = "";
        fq1.datatype = reger.mega.DataTypeDecimal.DATATYPEID;
        fq1.megafieldid = this.megafieldid;
        out = AddToArray.addFieldQueryElementArray(out, fq1);
        //Greater Than Minutes
        FieldQueryElement fq2 = new FieldQueryElement();
        fq2.name = fieldNamePre(logidOrEtid)+"greaterthanminutes";
        fq2.value = "";
        fq2.datatype = reger.mega.DataTypeDecimal.DATATYPEID;
        fq2.megafieldid = this.megafieldid;
        out = AddToArray.addFieldQueryElementArray(out, fq2);
        //Greater Than Seconds
        FieldQueryElement fq3 = new FieldQueryElement();
        fq3.name = fieldNamePre(logidOrEtid)+"greaterthanseconds";
        fq3.value = "";
        fq3.datatype = reger.mega.DataTypeDecimal.DATATYPEID;
        fq3.megafieldid = this.megafieldid;
        out = AddToArray.addFieldQueryElementArray(out, fq3);
        //Less Than Hours
        FieldQueryElement fq4 = new FieldQueryElement();
        fq4.name = fieldNamePre(logidOrEtid)+"lessthanhours";
        fq4.value = "";
        fq4.datatype = reger.mega.DataTypeDecimal.DATATYPEID;
        fq4.megafieldid = this.megafieldid;
        out = AddToArray.addFieldQueryElementArray(out, fq4);
        //Less Than Minutes
        FieldQueryElement fq5 = new FieldQueryElement();
        fq5.name = fieldNamePre(logidOrEtid)+"lessthanminutes";
        fq5.value = "";
        fq5.datatype = reger.mega.DataTypeDecimal.DATATYPEID;
        fq5.megafieldid = this.megafieldid;
        out = AddToArray.addFieldQueryElementArray(out, fq5);
        //Less Than Seconds
        FieldQueryElement fq6 = new FieldQueryElement();
        fq6.name = fieldNamePre(logidOrEtid)+"lessthanseconds";
        fq6.value = "";
        fq6.datatype = reger.mega.DataTypeDecimal.DATATYPEID;
        fq6.megafieldid = this.megafieldid;
        out = AddToArray.addFieldQueryElementArray(out, fq6);
        //Equal To Hours
        FieldQueryElement fq7 = new FieldQueryElement();
        fq7.name = fieldNamePre(logidOrEtid)+"equaltohours";
        fq7.value = "";
        fq7.datatype = reger.mega.DataTypeDecimal.DATATYPEID;
        fq7.megafieldid = this.megafieldid;
        out = AddToArray.addFieldQueryElementArray(out, fq7);
        //Equal To Minutes
        FieldQueryElement fq8 = new FieldQueryElement();
        fq8.name = fieldNamePre(logidOrEtid)+"equaltominutes";
        fq8.value = "";
        fq8.datatype = reger.mega.DataTypeDecimal.DATATYPEID;
        fq8.megafieldid = this.megafieldid;
        out = AddToArray.addFieldQueryElementArray(out, fq8);
        //Equal To Seconds
        FieldQueryElement fq9 = new FieldQueryElement();
        fq9.name = fieldNamePre(logidOrEtid)+"equaltoseconds";
        fq9.value = "";
        fq9.datatype = reger.mega.DataTypeDecimal.DATATYPEID;
        fq9.megafieldid = this.megafieldid;
        out = AddToArray.addFieldQueryElementArray(out, fq9);



        return out;
    }


    /**
     * The html used to display a query form.  Note that it must populate itself once submitted.
     */
    public String queryDisplayHtml(FieldQueryElement[] fieldQueryElements, int logidOrEtid) {
        StringBuffer mb = new StringBuffer();


        mb.append("<font face=arial size=-2>");
        mb.append("Greater Than ");
        mb.append("<input type=text name="+fieldNamePre(logidOrEtid)+"greaterthanhours value=\""+reger.core.Util.cleanForHtml(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"greaterthanhours")[0])+"\" size=2 maxlength=10>");
        mb.append("hrs ");
        mb.append("<input type=text name="+fieldNamePre(logidOrEtid)+"greaterthanminutes value=\""+reger.core.Util.cleanForHtml(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"greaterthanminutes")[0])+"\" size=2 maxlength=10>");
        mb.append("min ");
        mb.append("<input type=text name="+fieldNamePre(logidOrEtid)+"greaterthanseconds value=\""+reger.core.Util.cleanForHtml(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"greaterthanseconds")[0])+"\" size=2 maxlength=10>");
        mb.append("sec");
        mb.append("<br>");
        mb.append("Less Than ");
        mb.append("<input type=text name="+fieldNamePre(logidOrEtid)+"lessthanhours value=\""+reger.core.Util.cleanForHtml(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"lessthanhours")[0])+"\" size=2 maxlength=10>");
        mb.append("hrs ");
        mb.append("<input type=text name="+fieldNamePre(logidOrEtid)+"lessthanminutes value=\""+reger.core.Util.cleanForHtml(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"lessthanminutes")[0])+"\" size=2 maxlength=10>");
        mb.append("min ");
        mb.append("<input type=text name="+fieldNamePre(logidOrEtid)+"lessthanseconds value=\""+reger.core.Util.cleanForHtml(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"lessthanseconds")[0])+"\" size=2 maxlength=10>");
        mb.append("sec");
        mb.append("<br>");
        mb.append("Equal To ");
        mb.append("<input type=text name="+fieldNamePre(logidOrEtid)+"equaltohours value=\""+reger.core.Util.cleanForHtml(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equaltohours")[0])+"\" size=2 maxlength=10>");
        mb.append("hrs ");
        mb.append("<input type=text name="+fieldNamePre(logidOrEtid)+"equaltominutes value=\""+reger.core.Util.cleanForHtml(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equaltominutes")[0])+"\" size=2 maxlength=10>");
        mb.append("min ");
        mb.append("<input type=text name="+fieldNamePre(logidOrEtid)+"equaltoseconds value=\""+reger.core.Util.cleanForHtml(FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equaltoseconds")[0])+"\" size=2 maxlength=10>");
        mb.append("sec");
        mb.append("</font>");

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


        String greaterthanhours = FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"greaterthanhours")[0];
        String greaterthanminutes = FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"greaterthanminutes")[0];
        String greaterthanseconds = FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"greaterthanseconds")[0];
        String lessthanhours = FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"lessthanhours")[0];
        String lessthanminutes = FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"lessthanminutes")[0];
        String lessthanseconds = FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"lessthanseconds")[0];
        String equaltohours = FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equaltohours")[0];
        String equaltominutes = FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equaltominutes")[0];
        String equaltoseconds = FieldQueryElement.getValues(fieldQueryElements, fieldNamePre(logidOrEtid)+"equaltoseconds")[0];


        if (!greaterthanhours.equals("") || !greaterthanminutes.equals("") || !greaterthanseconds.equals("")){
            mb.append("Greater Than: ");
            if (!greaterthanhours.equals("")){
                mb.append(greaterthanhours);
            } else {
                mb.append("0");
            }
            mb.append("hrs ");
            if (!greaterthanminutes.equals("")){
                mb.append(greaterthanminutes);
            } else {
                mb.append("0");
            }
            mb.append("min ");
            if (!greaterthanseconds.equals("")){
                mb.append(greaterthanseconds);
            } else {
                mb.append("0");
            }
            mb.append("sec ");
            mb.append("<br>");
        }

        if (!lessthanhours.equals("") || !lessthanminutes.equals("") || !lessthanseconds.equals("")){
            mb.append("Less Than: ");
            if (!lessthanhours.equals("")){
                mb.append(lessthanhours);
            } else {
                mb.append("0");
            }
            mb.append("hrs ");
            if (!lessthanminutes.equals("")){
                mb.append(lessthanminutes);
            } else {
                mb.append("0");
            }
            mb.append("min ");
            if (!lessthanseconds.equals("")){
                mb.append(lessthanseconds);
            } else {
                mb.append("0");
            }
            mb.append("sec ");
            mb.append("<br>");
        }

        if (!equaltohours.equals("") || !equaltominutes.equals("") || !equaltoseconds.equals("")){
            mb.append("Equal To: ");
            if (!equaltohours.equals("")){
                mb.append(equaltohours);
            } else {
                mb.append("0");
            }
            mb.append("hrs ");
            if (!equaltominutes.equals("")){
                mb.append(equaltominutes);
            } else {
                mb.append("0");
            }
            mb.append("min ");
            if (!equaltoseconds.equals("")){
                mb.append(equaltoseconds);
            } else {
                mb.append("0");
            }
            mb.append("sec ");
            mb.append("<br>");
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
