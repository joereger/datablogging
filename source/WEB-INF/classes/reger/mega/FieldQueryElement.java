package reger.mega;

import reger.core.db.Db;
import reger.core.Debug;
import reger.AddToArray;

import java.util.Enumeration;
import java.io.Serializable;

/**
 * Defines a single element used to build a query against a Field
 */
public class FieldQueryElement implements Serializable {

    public int megafieldid;
    public String name;  //For example, greaterthan
    public String value; //For example, 12
    public int datatype; //For example, reger.mega.DataTypeInteger.DATATYPEID

    final static long serialVersionUID = 1L;

    public FieldQueryElement(){

    }

    public FieldQueryElement(int savedsearchfqeid){
        loadFromDB(savedsearchfqeid);
    }

    /**
     * Static utility function to find the value of a named fieldqueryelement from an array of them
     */
//    public static String getValue(FieldQueryElement[] fieldQueryElements, String name){
//        reger.core.Util.debug(5, "FieldQueryElement.java getValue()<br>name=" + name);
//        if (fieldQueryElements!=null){
//            for (int i = 0; i < fieldQueryElements.length; i++) {
//                if (fieldQueryElements[i].name.equals(name)){
//                    return fieldQueryElements[i].value;
//                }
//            }
//        }
//        return "";
//    }

    /**
     * Static utility function to find the value of a named fieldqueryelement from an array of them
     */
    public static String[] getValues(FieldQueryElement[] fieldQueryElements, String name){
        Debug.debug(5, "", "FieldQueryElement.java getValue()<br>name=" + name);
        String[] out = new String[0];
        if (fieldQueryElements!=null){
            for (int i = 0; i < fieldQueryElements.length; i++) {
                if (fieldQueryElements[i].name.equals(name)){
                    out = reger.core.Util.addToStringArray(out, fieldQueryElements[i].value);
                }
            }
        }
        if (out.length==0){
            out = new String[1];
            out[0] = "";
        }
        return out;
    }

    public static boolean doesNameValuePairExist(FieldQueryElement[] fieldQueryElements, String name, String value){
        if (fieldQueryElements!=null){
            for (int i = 0; i < fieldQueryElements.length; i++) {
                if (fieldQueryElements[i].name.equals(name) && fieldQueryElements[i].value.equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Note that this is indescriminate... it converts the request to a Treemap and
     * then puts all name/value parameters into FieldQueryElements.
     */
    public static FieldQueryElement[] getElementsFromRequest(javax.servlet.http.HttpServletRequest request){
        FieldQueryElement[] out = new FieldQueryElement[0];

        Enumeration names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            String[] values = request.getParameterValues(name);

            if (name.length()>=fqeParameterNameIdentifier().length() && name.substring(0,fqeParameterNameIdentifier().length()).equals(fqeParameterNameIdentifier())){
                for (int i = 0; i < values.length; i++) {
                    String value = values[i];
                    //Create a FQE
                    FieldQueryElement fqe = new FieldQueryElement();
                    fqe.name = name;
                    fqe.value = value;
                    fqe.megafieldid = Field.parseFieldidFromFieldName(name);
                    //Add to the array of FieldQueryElements
                    try{
                        out = AddToArray.addFieldQueryElementArray(out, fqe);
                        Debug.debug(5, "", "FieldQueryElement.java adding<br>fqe.name=" + fqe.name + "<br>fqe.value=" + fqe.value);
                    } catch (Exception ex){
                        Debug.errorsave(ex, "");
                    }
                }
            }


        }

        return out;
    }

    public static String fqeParameterNameIdentifier(){
        return "fieldqueryelement-fieldid-";
    }

    public void saveToDB(int savedSearchId){
        Debug.debug(5, "", "FieldQueryElement.java: <br>savedSearchId=" + savedSearchId + "<br>megafieldid=" + megafieldid + "<br>name=" + name + "<br>value=" + value);
        //Delete any saved now
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM savedsearchfqe WHERE savedsearchid='"+savedSearchId+"' AND megafieldid='"+megafieldid+"' AND paramname='"+reger.core.Util.cleanForSQL(name)+"'");
        //-----------------------------------
        //-----------------------------------
        //And add them back as long as we have a megafieldid, name and value
        if (megafieldid>0 && !name.equals("") && !value.equals("")) {
            Debug.debug(5, "", "FieldQueryElement.java: <br>savedSearchId=" + savedSearchId + "<br>megafieldid=" + megafieldid + "<br>name=" + name + "<br>value=" + value + "<br>INSERTING");
            //-----------------------------------
            //-----------------------------------
            int identity = Db.RunSQLInsert("INSERT INTO savedsearchfqe(savedsearchid, megafieldid, paramname, paramvalue) VALUES('"+savedSearchId+"', '"+megafieldid+"', '"+reger.core.Util.cleanForSQL(name)+"', '"+reger.core.Util.cleanForSQL(value)+"')");
            //-----------------------------------
            //-----------------------------------
        }
    }

    public void loadFromDB(int savedsearchfqeid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstSearch= Db.RunSQL("SELECT megafieldid, paramname, paramvalue FROM savedsearchfqe WHERE savedsearchfqeid='"+savedsearchfqeid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstSearch!=null && rstSearch.length>0){
        	megafieldid = Integer.parseInt(rstSearch[0][0]);
        	name = rstSearch[0][1];
        	value = rstSearch[0][2];
        }
    }

    
}
