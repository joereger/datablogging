package reger;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.XMLOutputter;
import org.jdom.output.Format;
import reger.mega.FieldType;
import reger.core.TimeUtils;
import reger.core.Util;

/**
 * Renders an entry to XML per XML Schema doc
 */
public class EntryStructuredBlogginglRenderer {

    public static String get(Entry ent){

        try{

            Document doc = new Document();

            //Whole schema doc
//            Element schema = new Element("schema", MegaLogTypeXmlSchemaRenderer.xsNs);
//            schema.setAttribute("xs","http://www.w3.org/2001/XMLSchema", Namespace.getNamespace("XXXxmlns","http://www.w3.org/2001/XMLSchema"));
//            doc.addContent(schema);

                //Entry
                Element entry = new Element("xml-structured-blog-entry");
                entry.setAttribute("xmlns", "http://www.structuredblogging.org/xmlns");
                doc.addContent(entry);

                    //Title
                    Element elTit = new Element("title");
                    elTit.addContent(ent.title);
                    entry.addContent(elTit);



                    //Datetime
                    Element elDt = new Element("datetime");
                    elDt.addContent(TimeUtils.dateformatUtc(ent.getCalendar()));
                    entry.addContent(elDt);




                    //Description
                    Element el = new Element("description");
                    el.addContent(ent.comments);
                    el.setAttribute("type", "logentry");
                    el.setAttribute("escaped", "false");
                    entry.addContent(el);


                    //Location
                    Element elLoc = new Element("location");
                    elLoc.addContent(ent.location.getLocationname());
                    entry.addContent(elLoc);


                    //Role
                    Element elRole = new Element("role");
                    elRole.addContent("");
                    entry.addContent(elRole);




                    //Author
                    Element elAuth = new Element("author");
                    elAuth.addContent(ent.author);
                    entry.addContent(elAuth);



                    //Extended data
                    Element extendedData = new Element("extended-data");
                    entry.addContent(extendedData);

                        //Individual fields
                        FieldType[] fields = ent.fields;
                        for (int i = 0; i < fields.length; i++) {
                            FieldType field = fields[i];
                            extendedData.addContent(field.getXmlForFieldData());
                        }



            XMLOutputter outp = new XMLOutputter();
            outp.setFormat(Format.getPrettyFormat());
            return outp.outputString(doc);

        } catch (Exception e){
            Util.errorsave(e);
        }
        return "Fail.";
    }

    public static String getWrappedInHtmlScript(Entry ent){
        StringBuffer mb = new StringBuffer();

        mb.append(Vars.LINEBREAKCHARFORHTML);
        mb.append(Vars.LINEBREAKCHARFORHTML);
        mb.append("<script type=\"application/x-subnode; charset=utf-8\">");
        mb.append(Vars.LINEBREAKCHARFORHTML);
        mb.append("<!-- The following is structured blog data for machine readers.  See structuredblogging.org for info.  This is a very early and uncertified implementation of that concept that includes proposed improvements and changes. -->");
        mb.append(Vars.LINEBREAKCHARFORHTML);
        mb.append(get(ent));
        mb.append(Vars.LINEBREAKCHARFORHTML);
        mb.append("</script>");
        mb.append(Vars.LINEBREAKCHARFORHTML);
        mb.append(Vars.LINEBREAKCHARFORHTML);

        return mb.toString();
    }




}
