package reger.xforms.fieldtype;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Used to get to field types
 */
public class XFormsFormControlFactory {

    private static HashMap controls;

    public static void loadControls(){
        controls = new HashMap();
        //Start Control
        XFormsFormControl xfc01 = new XFormsFormControlInput();
        controls.put(xfc01.getName(), xfc01);
        //End Control
    }

    public static XFormsFormControl getFieldTypeByName(String name){
        if (controls==null){
            loadControls();
        }

        Iterator iterator = controls.keySet().iterator();

        while (iterator.hasNext()) {
            String key = String.valueOf(iterator.next());
            XFormsFormControl value = (XFormsFormControl)controls.get(key);
            if (value != null) {
                if (value.getName().equals(name)){
                    return value;
                }
            }
        }

        return null;
    }

    public static XFormsFormControl[] getAllControls(){
        if (controls==null){
            loadControls();
        }

        XFormsFormControl[] out = new XFormsFormControl[controls.size()-1];
        int x = 0;
        Iterator iterator = controls.keySet().iterator();
        while (iterator.hasNext()) {

            String key = String.valueOf(iterator.next());
            XFormsFormControl value = (XFormsFormControl)controls.get(key);
            out[x]=value;
            x = x + 1;
        }

        return out;
    }


}
