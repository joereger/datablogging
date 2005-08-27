package reger.mega;

import org.jdom.Element;

/**
 * Defines a DataType, not a field type.
 * Data types are things like String, Int, etc.
 */
public interface DataType {

    public String getName();

    public int getDataTypeId();

    public boolean validataData(String in) throws reger.core.ValidationException;

    public Element getXmlSchemaRepresentationOfType();

}
