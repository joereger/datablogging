package reger.mega;

import reger.cache.providers.jboss.Cacheable;

/**
 * Represents data for a single field in name/value form.
 */
@Cacheable
public class FieldData {

    private String name;
    private String value;

    public FieldData(){
        
    }

    public FieldData(String name, String value){
        this.name=name;
        this.value=value;
    }

    public FieldData(FieldData fldData){
        this.name=fldData.name;
        this.value=fldData.value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
