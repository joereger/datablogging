package reger;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import org.jdom.output.Format;
import reger.mega.FieldType;
import reger.core.Debug;

/**
 * Renders an entry to XML per XML Schema doc
 */
public class EntryXmlRenderer {

    public static String get(Entry ent){

        try{

            Document doc = new Document();

            //Whole schema doc
//            Element schema = new Element("schema", MegaLogTypeXmlSchemaRenderer.xsNs);
//            schema.setAttribute("xs","http://www.w3.org/2001/XMLSchema", Namespace.getNamespace("XXXxmlns","http://www.w3.org/2001/XMLSchema"));
//            doc.addContent(schema);

                //Entry
                Element entry = new Element("entry");
                entry.setAttribute("eventid", String.valueOf(ent.eventid));
                doc.addContent(entry);

                    try{
                        //Title
                        Element elTit = new Element("title");
                        elTit.addContent(ent.title);
                        entry.addContent(elTit);
                    } catch (org.jdom.IllegalDataException ex){
                        Debug.debug(5, "", ex);
                    }

                    try{
                        //Datetime
                        Element elDt = new Element("datetime");
                        elDt.addContent(reger.core.TimeUtils.dateformatUtc(ent.getCalendar()));
                        entry.addContent(elDt);
                    } catch (org.jdom.IllegalDataException ex){
                        Debug.debug(5, "", ex);
                    }


                    try{
                        //Description
                        Element el = new Element("description");
                        el.addContent(ent.comments);
                        el.setAttribute("type", "logentry");
                        el.setAttribute("escaped", "false");
                        entry.addContent(el);
                    } catch (org.jdom.IllegalDataException ex){
                        Debug.debug(5, "", ex);
                    }

                    try{

                        //Location
                        Element elLoc = new Element("location");
                        if (ent.location!=null){
                            elLoc.addContent(ent.location.getLocationname());
                            elLoc.setAttribute("locationid", String.valueOf(ent.location.getLocationid()));
                        }
                        entry.addContent(elLoc);
                   } catch (org.jdom.IllegalDataException ex){
                        Debug.debug(5, "", ex);
                    }


                    try{
                        //Role
                        Element elRole = new Element("role");
                        elRole.addContent("");
                        entry.addContent(elRole);
                    } catch (org.jdom.IllegalDataException ex){
                        Debug.debug(5, "", ex);
                    }


                    try{
                        //Author
                        Element elAuth = new Element("author");
                        elAuth.addContent(ent.author);
                        entry.addContent(elAuth);
                    } catch (org.jdom.IllegalDataException ex){
                        Debug.debug(5, "", ex);
                    }

                    try{
                        //Extended data
                        Element extendedData = new Element("structured-data");
                        entry.addContent(extendedData);

                            //Individual fields
                            FieldType[] fields = ent.fields;
                            if (fields!=null){
                                for (int i = 0; i < fields.length; i++) {
                                    FieldType field = fields[i];
                                    extendedData.addContent(field.getXmlForFieldData());
                                }
                            }
                    } catch (org.jdom.IllegalDataException ex){
                        Debug.debug(5, "", ex);
                    }



            XMLOutputter outp = new XMLOutputter();
            outp.setFormat(Format.getPrettyFormat());
            return outp.outputString(doc);

        } catch (Exception e){
            Debug.errorsave(e, "");
        }
        return "Fail.";
    }

    public static String getWrappedInHtmlScript(Entry ent){
        StringBuffer mb = new StringBuffer();

        mb.append(reger.Vars.LINEBREAKCHARFORHTML);
        mb.append(reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("<script type=\"application/x-subnode; charset=utf-8\">");
        mb.append(reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("<!-- The following is structured blog data for machine readers.  This is a very early and uncertified implementation of that concept that includes proposed improvements and changes to structuredblogging.org's approach. -->");
        mb.append(reger.Vars.LINEBREAKCHARFORHTML);
        mb.append(get(ent));
        mb.append(reger.Vars.LINEBREAKCHARFORHTML);
        mb.append("</script>");
        mb.append(reger.Vars.LINEBREAKCHARFORHTML);
        mb.append(reger.Vars.LINEBREAKCHARFORHTML);

        return mb.toString();
    }




}
