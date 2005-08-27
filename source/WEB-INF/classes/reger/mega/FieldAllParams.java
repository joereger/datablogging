package reger.mega;

import reger.core.db.Db;

import java.util.Vector;
import java.util.ListIterator;

/**
 * Holds all parameters for a class and provides get/put capability
 */
public class FieldAllParams {

    private Vector params = new Vector();
    int megafieldid = -1;

    /**
     * Constructor
     */
    FieldAllParams(int megafieldid){
        this.megafieldid=megafieldid;
    }

    /**
     * Goes to the database for a single megafieldid and populates params with FieldParam objects
     */
    public void loadData(){

        for (int i = 0; i < params.size(); i++) {
            FieldParam fieldParam = (FieldParam) params.elementAt(i);

            fieldParam.loadValue();
        }

    }

    public String getParamValue(String name){
        for (int i = 0; i < params.size(); i++) {
            FieldParam fieldParam = (FieldParam) params.elementAt(i);

            if (fieldParam.name.equals(name)){
                //It's a match... return value
                return fieldParam.value;
            }

        }
        return "";
    }

    public String getParamValueByOneworddatabasekey(String key){
        for (int i = 0; i < params.size(); i++) {
            FieldParam fieldParam = (FieldParam) params.elementAt(i);

            if (fieldParam.onewordDatabaseKey.equals(key)){
                //It's a match... return value
                return fieldParam.value;
            }

        }
        return "";
    }

    public FieldParam getFieldParamByName(String name){
        for (int i = 0; i < params.size(); i++) {
            FieldParam fieldParam = (FieldParam) params.elementAt(i);

            if (fieldParam.name.equals(name)){
                //It's a match... return it
                return fieldParam;
            }

        }
        return null;
    }

    public void addParam(FieldParam fieldParam){
        if (params==null){
            params=new Vector();
        }
        params.add(fieldParam);
    }

    public Vector getParams(){
        return this.params;
    }

    public void loadFromRequest(javax.servlet.http.HttpServletRequest request){
        for (int i = 0; i < params.size(); i++) {
            FieldParam fieldParam = (FieldParam) params.elementAt(i);
            fieldParam.loadFromRequest(request);
        }
    }

    public void deleteAllParams(){
        for (int i = 0; i < params.size(); i++) {
            FieldParam fieldParam = (FieldParam) params.elementAt(i);
            fieldParam.deleteParam();
        }
    }

    public String validateAllParams(){
        String errortext = "";
        for (int i = 0; i < params.size(); i++) {
            FieldParam fieldParam = (FieldParam) params.elementAt(i);
            errortext = errortext + fieldParam.validate();
        }
        return errortext;
    }

    public String saveParams(){
        String errortext = "";

        errortext = errortext + validateAllParams();

        if (errortext.equals("")){
            for (int i = 0; i < params.size(); i++) {
                FieldParam fieldParam = (FieldParam) params.elementAt(i);
                fieldParam.saveParam();
            }
        }

        return errortext;
    }

    public void setMegafieldidOnAll(int megafieldid){
        for (int i = 0; i < params.size(); i++) {
            FieldParam fieldParam = (FieldParam) params.elementAt(i);
            fieldParam.megafieldid=megafieldid;
        }
    }


}
