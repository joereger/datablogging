package reger.mega;

import org.jdom.Element;
import reger.MegaLogTypeXmlSchemaRenderer;

/**
 * A Data Type.
 */
public class DataTypeInteger implements DataType{

    public static int DATATYPEID = 2;

    public String getName() {
        return "Integer";
    }

    public int getDataTypeId() {
        return DATATYPEID;
    }



    public boolean validataData(String in) throws reger.core.ValidationException{
        if (reger.core.Util.isinteger(in)){
            return true;
        } else {
            reger.core.ValidationException ex = new reger.core.ValidationException();
            ex.addValidationError("Not an integer.");
            throw ex;
        }
    }

    public Element getXmlSchemaRepresentationOfType() {
        Element stAuth = new Element("simpleType", MegaLogTypeXmlSchemaRenderer.xsNs);

            Element restAuth = new Element("restriction", MegaLogTypeXmlSchemaRenderer.xsNs);
            restAuth.setAttribute("base","xs:integer");
            stAuth.addContent(restAuth);

        return stAuth;
    }

 


}
