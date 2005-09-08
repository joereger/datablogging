package reger.mega;

import reger.core.Debug;


public class FieldTypeFactory {
    /**
     * Accepts a fieldtype and returns a FieldType handler object.
     * @param fieldtype
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
        } else if (fieldtype==FieldType.FIELDTYPECONTAINER){
            return new FieldTypeContainer();
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
        } else if (field.getFieldtype()==FieldType.FIELDTYPECONTAINER){
            return new FieldTypeContainer((FieldTypeContainer)field);
        } else {
            Debug.logtodb("No handler found: FieldTypeFactory.getHandlerByFieldtype - incoming field.getFieldname()=" + field.getFieldname(), "");
            return null;
        }
    }


    public static FieldType[] getAllFieldTypes(){
        FieldType[] fts = new FieldType[7];
        fts[0] = new FieldTypeDropdown();
        fts[1] = new FieldTypeHorizontalradios();
        fts[2] = new FieldTypeNumericrange();
        fts[3] = new FieldTypeTextbox();
        fts[4] = new FieldTypeTimeperiod();
        fts[5] = new FieldTypeVerticalradios();
        fts[6] = new FieldTypeContainer();
        return fts;
    }

}


