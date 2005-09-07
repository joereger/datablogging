package reger.xml;

import org.jdom.*;

import java.util.Iterator;
import java.util.List;

/**
 * Lists nodes of an XML doc
 */
public class JdomNodeLister {

    public static String listNodes(Document doc){
        return listNodes(doc, 0);
    }


    public static String listNodes(Object o, int depth) {

        StringBuffer out = new StringBuffer();

        out.append("<br>"+printSpaces(depth));

        if (o instanceof Element) {
            Element element = (Element) o;
            out.append("Element: " + element.getName());
            out.append("<font face=arial size=-2 style=\"font-size: 8px;\">");
            out.append(reger.xml.JdomElementInspector.inspect(element));
            out.append("</font>");
            List children = element.getContent();
            Iterator iterator = children.iterator();
            while (iterator.hasNext()) {
                Object child = iterator.next();
                out.append(listNodes(child, depth+1));
            }
        } else if (o instanceof Document) {
            out.append("Document");
            Document doc = (Document) o;
            List children = doc.getContent();
            Iterator iterator = children.iterator();
            while (iterator.hasNext()) {
                Object child = iterator.next();
                out.append(listNodes(child, depth+1));
            }
        } else if (o instanceof Comment) {
            out.append("Comment");
        } else if (o instanceof CDATA) {
            out.append("CDATA section");
            // CDATA is a subclass of Text so this test must come
            // before the test for Text.
        } else if (o instanceof Text) {
            out.append("Text");
        } else if (o instanceof EntityRef) {
            out.append("Entity reference");
        } else if (o instanceof ProcessingInstruction) {
            out.append("Processing Instruction");
        } else {  // This really shouldn't happen
            out.append("Unexpected type: " + o.getClass());
        }

        return out.toString();
    }

    private static String printSpaces(int n) {
        StringBuffer out = new StringBuffer();
        for (int i = 0; i < n; i++) {
            out.append("&nbsp;");
        }
        return out.toString();
    }


}
