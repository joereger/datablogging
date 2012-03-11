package reger.mega;

import reger.core.Debug;
import reger.cache.providers.jboss.Cacheable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A collection of fieldorder objects
 */
@Cacheable
public class FieldOrderCollection {

    private HashMap fieldorders = new HashMap();

    public FieldOrderCollection(String fieldorder){
        Debug.debug(5, "", "FieldOrderCollection.java<br>fieldorder=" + fieldorder);
        if (fieldorder!=null && !fieldorder.equals("")){
            try{
                String[] fieldPart = fieldorder.split("\\|");
                for (int i = 0; i < fieldPart.length; i++) {
                    Debug.debug(5, "", "FieldOrderCollection.java<br>fieldpart["+i+"]=" + fieldPart[i]);
                    try{
                        String[] sp = fieldPart[i].split(",");
                        int col = 1;
                        int order = 1;
                        FieldOrder fo = new FieldOrder(Integer.parseInt(sp[0]),col, order);
                        fieldorders.put(new Integer(Integer.parseInt(sp[0])), fo);
                    } catch (Exception e){
                        Debug.debug(5, "", e);
                    }
                }
            } catch (Exception e){
                Debug.debug(5, "", e);
            }
        }
    }

    public FieldOrder getFieldOrderForMegafieldid(int megafieldid){
         return (FieldOrder)fieldorders.get(new Integer(megafieldid));
    }

    public String getFieldOrderAsString(){
        String out = "";
        for (Iterator i=fieldorders.entrySet().iterator(); i.hasNext(); ) {
            Map.Entry e = (Map.Entry) i.next();
            //e.getKey()
            //e.getValue()
            FieldOrder fo = (FieldOrder)e.getValue();
            //out = out + fo.getMegafieldid() +","+ fo.getX() +","+ fo.getY() +","+ fo.getW() +","+ fo.getH() +"|";
        }
        return out;
    }



}
