package reger.mega;

import org.jdom.Element;
import reger.MegaLogTypeXmlSchemaRenderer;

/**
 * A Data Type.
 */
public class DataTypeString implements DataType{

    public static int DATATYPEID = 3;

    public String getName() {
        return "Alphanumeric String";
    }


    public int getDataTypeId() {
        return DATATYPEID;
    }

    public boolean validataData (String in) throws reger.core.ValidationException{
        return true;
    }

    public Element getXmlSchemaRepresentationOfType() {
        Element stAuth = new Element("simpleType", MegaLogTypeXmlSchemaRenderer.xsNs);

            Element restAuth = new Element("restriction", MegaLogTypeXmlSchemaRenderer.xsNs);
            restAuth.setAttribute("base","xs:string");
            stAuth.addContent(restAuth);

        return stAuth;
    }




}
