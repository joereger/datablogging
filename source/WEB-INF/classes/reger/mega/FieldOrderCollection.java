package reger.mega;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A collection of fieldorder objects
 */
public class FieldOrderCollection {

    private HashMap fieldorders = new HashMap();

    public FieldOrderCollection(String fieldorder){
        reger.core.Util.debug(5, "FieldOrderCollection.java<br>fieldorder=" + fieldorder);
        if (fieldorder!=null && !fieldorder.equals("")){
            try{
                String[] fieldPart = fieldorder.split("\\|");
                for (int i = 0; i < fieldPart.length; i++) {
                    reger.core.Util.debug(5, "FieldOrderCollection.java<br>fieldpart["+i+"]=" + fieldPart[i]);
                    try{
                        String[] sp = fieldPart[i].split(",");
                        FieldOrder fo = new FieldOrder(Integer.parseInt(sp[0]), Integer.parseInt(sp[1]), Integer.parseInt(sp[2]), Integer.parseInt(sp[3]), Integer.parseInt(sp[4]));
                        fieldorders.put(new Integer(Integer.parseInt(sp[0])), fo);
                    } catch (Exception e){
                        reger.core.Util.debug(5, e);
                    }
                }
            } catch (Exception e){
                reger.core.Util.debug(5, e);
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
            out = out + fo.getMegafieldid() +","+ fo.getX() +","+ fo.getY() +","+ fo.getW() +","+ fo.getH() +"|";
        }
        return out;
    }

//    public int getWidthOfRequiredContainer(){
//        int width = 0;
//        for (Iterator i=fieldorders.entrySet().iterator(); i.hasNext(); ) {
//            Map.Entry e = (Map.Entry) i.next();
//            //e.getKey()
//            //e.getValue()
//            FieldOrder fo = (FieldOrder)e.getValue();
//            if ( (fo.getX()+fo.getW()) > width){
//                width = fo.getX()+fo.getW();
//            }
//        }
//        return width;
//    }
//
//    public int getHeightOfRequiredContainer(){
//        int height = 0;
//        for (Iterator i=fieldorders.entrySet().iterator(); i.hasNext(); ) {
//            Map.Entry e = (Map.Entry) i.next();
//            //e.getKey()
//            //e.getValue()
//            FieldOrder fo = (FieldOrder)e.getValue();
//            if ( (fo.getY()+fo.getH()) > height){
//                height = fo.getY()+fo.getH();
//            }
//        }
//        return height;
//    }


}
