package reger.xml;

import reger.MegaLogType;
import reger.mega.Field;
import reger.core.ValidationException;
import org.jdom.*;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Creates a log type from some sort of xml document
 */
public class LogTypeCreator {

    public static MegaLogType createFromXMLSchema(Document doc, MegaLogType logType) throws ValidationException{
        try{
            validateDoc(doc);
            //MegaLogType logType = createLogType(logtypename, accountuser);
            createFields(doc, logType);
            logType.save();
            //Go to the cache to make sure all is well
            return new MegaLogType(logType.getEventtypeid());
        } catch (ValidationException e){
            throw e;
        }
    }

    private static void validateDoc(Document doc) throws ValidationException {
        //Not sure what validation needs to be done here, so this is a placeholder right now.
    }

//    private static MegaLogType createLogType(String logtypename, Accountuser accountuser) throws ValidationException{
//        MegaLogType logType = new MegaLogType(accountuser.getAccountuserid(), logtypename, "", "", true, "", true, 0, new FieldType[0], false, "", new int[0], new FieldType[0], new FieldOrderCollection(""));
//        logType.save();
//        return logType;
//    }

    private static void createFields(Document doc, MegaLogType logType) throws ValidationException{
        if (logType==null || logType.getEventtypeid()<=0){
            throw new ValidationException("Log Type was null or Eventtypeid was zero or less. This is a system error, please contact your system administrator.");
        }
        //Iterate the nodes, looking for elements and creating them
        iterateNodesReturnArrayListOfFieldTypes(doc, 0, logType);

        return;

    }

    private static void iterateNodesReturnArrayListOfFieldTypes(Object o, int depth, MegaLogType logType) {

        if (o instanceof Element) {
            Element element = (Element) o;
            createField(element, logType);
            //Look for children
            List children = element.getContent();
            Iterator iterator = children.iterator();
            while (iterator.hasNext()) {
                Object child = iterator.next();
                //This is where the iterative add of fields happens
                iterateNodesReturnArrayListOfFieldTypes(child, depth+1, logType);
            }
        } else if (o instanceof Document) {
            Document doc = (Document) o;
            List children = doc.getContent();
            Iterator iterator = children.iterator();
            while (iterator.hasNext()) {
                Object child = iterator.next();
                //This is where the iterative add of fields happens
                iterateNodesReturnArrayListOfFieldTypes(child, depth+1, logType);
            }
        } else if (o instanceof Comment) {
            //out.append("Comment");
        } else if (o instanceof CDATA) {
            //out.append("CDATA section");
            // CDATA is a subclass of Text so this test must come
            // before the test for Text.
        } else if (o instanceof Text) {
            //out.append("Text");
        } else if (o instanceof EntityRef) {
            //out.append("Entity reference");
        } else if (o instanceof ProcessingInstruction) {
            //out.append("Processing Instruction");
        } else {  // This really shouldn't happen
            //out.append("Unexpected type: " + o.getClass());
        }

        return;
    }

    private static void createField(Element e, MegaLogType logType){
        //@todo Customize field type, datatype, etc
        String fieldname = e.getAttributeValue("name");
        if (fieldname!=null && !fieldname.equals("")){
            //Debug
            reger.core.Debug.debug(5, "LogTypeCreator.java", "createField() called for fieldname="+fieldname+":<br><br>" + JdomElementInspector.inspect(e, "<br>"));

            Field field = new Field(Field.FIELDTYPETEXTBOX, logType.getEventtypeid(), fieldname, "", reger.mega.DataTypeString.DATATYPEID, 0);
            field.saveField();
        }



        return;
    }





}
