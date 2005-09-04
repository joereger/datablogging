package reger.mega;

import reger.core.Debug;


public class FieldTypeFactory {
    /**
     * Accepts a fieldtype and returns a FieldType handler object.
     * @param fieldtype
     * @return
     */
    public static FieldType getHandlerByFieldtype(int fieldtype){

        if (fieldtype==FieldType.FIELDTYPEDROPDOWN){
            return new FieldTypeDropdown();
        } else if (fieldtype==FieldType.FIELDTYPEHORIZONTALRADIOS){
            return new FieldTypeHorizontalradios();
        } else if (fieldtype==FieldType.FIELDTYPENUMERICRANGE){
            return new FieldTypeNumericrange();
        } else if (fieldtype==FieldType.FIELDTYPETEXTBOX){
            return new FieldTypeTextbox();
        } else if (fieldtype==FieldType.FIELDTYPETIME){
            return new FieldTypeTimeperiod();
        } else if (fieldtype==FieldType.FIELDTYPEVERTICALRADIOS){
            return new FieldTypeVerticalradios();
        } else {
            Debug.logtodb("No handler found: FieldTypeFactory.getHandlerByFieldtype - incoming fieldtype=" + fieldtype, "");
            return null;
        }
    }


    public static FieldType getCopyOfField(FieldType field){

        if (field.getFieldtype()==FieldType.FIELDTYPEDROPDOWN){
            return new FieldTypeDropdown((FieldTypeDropdown)field);
        } else if (field.getFieldtype()==FieldType.FIELDTYPEHORIZONTALRADIOS){
            return new FieldTypeHorizontalradios((FieldTypeHorizontalradios)field);
        } else if (field.getFieldtype()==FieldType.FIELDTYPENUMERICRANGE){
            return new FieldTypeNumericrange((FieldTypeNumericrange)field);
        } else if (field.getFieldtype()==FieldType.FIELDTYPETEXTBOX){
            return new FieldTypeTextbox((FieldTypeTextbox)field);
        } else if (field.getFieldtype()==FieldType.FIELDTYPETIME){
            return new FieldTypeTimeperiod((FieldTypeTimeperiod)field);
        } else if (field.getFieldtype()==FieldType.FIELDTYPEVERTICALRADIOS){
            return new FieldTypeVerticalradios((FieldTypeVerticalradios)field);
        } else {
            Debug.logtodb("No handler found: FieldTypeFactory.getHandlerByFieldtype - incoming field.getFieldname()=" + field.getFieldname(), "");
            return null;
        }
    }
}


