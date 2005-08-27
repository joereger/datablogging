package reger.mega;

import org.jdom.Element;
import reger.MegaLogTypeXmlSchemaRenderer;

/**
 * A Data Type.
 */
public class DataTypeDecimal implements DataType{

    public static int DATATYPEID = 1;

    public String getName() {
        return "Decimal";
    }

    public int getDataTypeId() {
        return DATATYPEID;
    }



    public boolean validataData(String in) throws reger.core.ValidationException{
        if (reger.core.Util.isnumeric(in)){
            return true;
        } else {
            reger.core.ValidationException ex = new reger.core.ValidationException();
            ex.addValidationError("Not a number.");
            throw ex;
        }
    }

    public Element getXmlSchemaRepresentationOfType() {
        Element stAuth = new Element("simpleType", MegaLogTypeXmlSchemaRenderer.xsNs);

            Element restAuth = new Element("restriction", MegaLogTypeXmlSchemaRenderer.xsNs);
            restAuth.setAttribute("base","xs:decimal");
            stAuth.addContent(restAuth);

        return stAuth;
    }

 


}
