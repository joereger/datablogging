package reger.core;

import com.thoughtworks.xstream.XStream;
import reger.core.Util;

/**
 * Wrapper class for xml serializing services
 */
public class XmlSerializer {


    public static String serializeToXML(Object obj){
        String str = "";
        try{
            XStream xstream = new XStream();
            str = xstream.toXML(obj);
        } catch (Exception e){
            Util.errorsave(e);
        }
        return str;
    }

    public static Object deSerializeFromXML(String str){
        try{
            XStream xstream = new XStream();
            return xstream.fromXML(str);
        } catch (Exception e){
            Util.errorsave(e);
        }
        return null;
    }
}
