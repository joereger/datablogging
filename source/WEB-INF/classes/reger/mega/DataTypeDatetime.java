package reger.mega;

import org.jdom.Element;
import reger.MegaLogTypeXmlSchemaRenderer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * A Data Type.
 */
public class DataTypeDatetime implements DataType{

    public static int DATATYPEID = 5;

    public String getName() {
        return "Datetime";
    }

    public int getDataTypeId() {
        return DATATYPEID;
    }

    public boolean validataData(String in) throws reger.core.ValidationException{
        try{
			DateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			cal.setTime(myDateFormat.parse(in));
			return true;
		} catch(Exception e) {
            reger.core.ValidationException ex = new reger.core.ValidationException();
            ex.addValidationError("Not a date of the form yyyy-MM-dd HH:mm:ss.");
            throw ex;
		}

    }

    public Element getXmlSchemaRepresentationOfType() {
        Element stAuth = new Element("simpleType", MegaLogTypeXmlSchemaRenderer.xsNs);

            Element restAuth = new Element("restriction", MegaLogTypeXmlSchemaRenderer.xsNs);
            restAuth.setAttribute("base","xs:string");
            stAuth.addContent(restAuth);

        return stAuth;
    }

 


}
