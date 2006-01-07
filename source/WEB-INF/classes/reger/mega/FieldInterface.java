package reger.mega;

import reger.Accountuser;
import org.jdom.Element;

/**
 *
 */

public interface FieldInterface {

    public Object clone();

    public void populateFromAnotherField(Field field);


    public void populateFromMegafieldid(int megafieldid);

    /**
     * Get the defined parameters for this field.
     * The FieldParam objects have everything except a value.
     * Override in FieldType when you extend Field.
     */
    public FieldAllParams getParams();

    

    /**
     * Creates a new field in the database based on the data stored in this field at the moment of calling.
     */
    public void saveField();

    //public void delete();

    public boolean isFieldOwnedByAccountuser(Accountuser au);

    /**
     * Get populated FieldQueryElements from a request.
     * Format is defined in 
     */
    public FieldQueryElement[] populateFieldQueryElements(javax.servlet.http.HttpServletRequest request, FieldQueryElement[] fieldQueryElements);

    public String fieldNamePre(int logidOrEtid);

    public int getMegafieldid();

    public int getFieldtype();

    public int getEventtypeid();

    public String getFieldname();

    public String getFieldnameForApis();

    public String getFielddescription();

    public int getMegadatatypeid();

    public int getIsrequired();

    public int getLogid();

    public void setLogid(int logid);

    public void setIsrequired(int isrequired);

    public void setFielddescription(String fielddescription);

    public void setFieldname(String fieldname);

    public void setFieldtype(int fieldtypeid);

    public void setEventtypeid(int eventtypeid);

    public void setMegadatatypeid(int megadatatypeid);

    public void setIsrequired(boolean isrequired);



    /**
     * Returns a jdom element describing the XML SCHEMA of this field type.
     */
     public Element getXmlSchemaRepresentationOfField(Element restrictions);

}
