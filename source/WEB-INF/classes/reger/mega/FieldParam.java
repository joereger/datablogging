package reger.mega;

import reger.core.db.Db;
import reger.core.db.Db;

/**
 * A FieldType can define a set of FieldParam that they use to define how they work.
 *
 */
public class FieldParam {

    //These should be configured
    public String onewordDatabaseKey = "";
    public String name = "";
    public String value = "";
    public String defaultvalue = "";
    public String description = "";
    public boolean isRequired = true;
    public int type = -1;

    //If this is a paramTypeFieldid, these two determine which fields are valid
    public int[] acceptableFieldTypesOfOtherField = new int[0];
    public int[] acceptableDataTypesOfOtherField = new int[0];

    //Once populated
    public int megafieldparamid = -1;
    public int megafieldid = -1;

    //The types of bahaviors that this param could have.
    //Use to set the type property above
    //These are left alone
    public static final int ParamTypeInteger = 1;
    public static final int ParamTypeNumber = 2;
    public static final int ParamTypeText = 3;
    public static final int ParamTypeBoolean = 4;
    public static final int ParamTypeFieldid = 5;

    /**
     * Constructor
     */
    FieldParam(int megafieldid){
        this.megafieldid = megafieldid;
    }

    public void loadValue(){

        //-----------------------------------
        //-----------------------------------
        String[][] rstParam= Db.RunSQL("SELECT value, megafieldparamid FROM megafieldparam WHERE megafieldid='"+megafieldid+"' AND oneworddatabasekey='"+reger.core.Util.cleanForSQL(onewordDatabaseKey)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstParam!=null && rstParam.length>0){
        	for(int i=0; i<rstParam.length; i++){
        	    this.value = rstParam[i][0];
                this.megafieldparamid = Integer.parseInt(rstParam[i][1]);
        	}
        }
    }

    public String saveParam(){
        //First, validate
        String errortext = validate();

        if (errortext.equals("")){

            //First, delete any existing values
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("DELETE FROM megafieldparam WHERE megafieldid='"+megafieldid+"' AND oneworddatabasekey='"+reger.core.Util.cleanForSQL(onewordDatabaseKey)+"'");
            //-----------------------------------
            //-----------------------------------

            //Next add the correct name/value pair associated with this megafieldid
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO megafieldparam(megafieldid, value, oneworddatabasekey) VALUES('"+megafieldid+"', '"+reger.core.Util.cleanForSQL(value)+"', '"+reger.core.Util.cleanForSQL(onewordDatabaseKey)+"')");
            //-----------------------------------
            //-----------------------------------

            this.megafieldparamid = identity;
        }

        return errortext;
    }

    public void deleteParam(){
        //Delete any existing values
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM megafieldparam WHERE megafieldid='"+megafieldid+"' AND oneworddatabasekey='"+reger.core.Util.cleanForSQL(onewordDatabaseKey)+"'");
        //-----------------------------------
        //-----------------------------------
    }

    public String validate(){
        String errortext = "";

        //reger.core.Util.logtodb("type=" + type + "<br>value=" + value + "<br>name=" + name + "<br>FieldParam.ParamTypeText=" + FieldParam.ParamTypeText);

        //Requiredness
        if (isRequired && value.equals("")){
            errortext = errortext + "The parameter called \""+name+"\" is required.<br>";
        }

        //Integer
        if (type==ParamTypeInteger && !reger.core.Util.isinteger(value)){
            errortext = errortext + "The parameter called \""+name+"\" must be an integer value (examples: 1, 3, 5, 45, etc).<br>";
        }

        //Number
        if (type==ParamTypeNumber && !reger.core.Util.isnumeric(value)){
            errortext = errortext + "The parameter called \""+name+"\" must be an numeric value (examples: 1, 3.45, 5.34, 45.0, etc).<br>";
        }

        //Boolean
        if (type==ParamTypeBoolean && !(value.equals("0") || value.equals("1"))){
            errortext = errortext + "The parameter called \""+name+"\" is a boolean and must be 0 or 1.<br>";
        }

        //Boolean
        if (type==ParamTypeFieldid){
            boolean isValidMegafieldid = true;
            //Must be an integer
            if (!reger.core.Util.isinteger(value)){
                isValidMegafieldid = false;
            } else {
                //@todo Somehow need to pass accountid here so that there's no chance this field can get tied to data from another account.
                //-----------------------------------
                //-----------------------------------
                String[][] rstField= Db.RunSQL("SELECT megafieldid, fieldtype, megadatatypeid FROM megafield WHERE megafieldid='"+value+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstField!=null && rstField.length>0){
                	for(int i=0; i<rstField.length; i++){
                        //Make sure it's acceptable data type and field type
                        if (!isAcceptableFieldType(Integer.parseInt(rstField[i][1])) || !isAcceptableDataType(Integer.parseInt(rstField[i][2]))){
                            isValidMegafieldid = false;
                        }
                	}
                }
            }


            if (!isValidMegafieldid){
                errortext = errortext + "The parameter called \""+name+"\" must be a valid field.<br>";
            }

        }

        return errortext;
    }

    private boolean isAcceptableFieldType(int fieldtype){
        for (int i = 0; i < acceptableFieldTypesOfOtherField.length; i++) {
            if (fieldtype == acceptableFieldTypesOfOtherField[i]){
                return true;
            }
        }
        return false;
    }

    private boolean isAcceptableDataType(int megadatatypeid){
        for (int i = 0; i < acceptableDataTypesOfOtherField.length; i++) {
            if (megadatatypeid == acceptableDataTypesOfOtherField[i]){
                return true;
            }
        }
        return false;
    }

    public void loadFromRequest(javax.servlet.http.HttpServletRequest request){
        if (request.getParameter("fieldparam-" + onewordDatabaseKey)!=null){
            //reger.core.Util.logtodb("Found a fieldparam in request: fieldparam-" + onewordDatabaseKey + "=" + request.getParameter("fieldparam-" + onewordDatabaseKey) + "<br>type=" + type);
            value = request.getParameter("fieldparam-" + onewordDatabaseKey);
        }
    }

}
