package reger.xml;

import org.jdom.input.SAXBuilder;
import org.jdom.Element;
import org.jdom.Document;
import org.jdom.JDOMException;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Lists elements in a JDOM document
 */
public class JdomElementLister {

    public static String listChildren(Element current, int depth) {
        StringBuffer out = new StringBuffer();

        out.append(printSpaces(depth));
        out.append(current.getName() + "<br>");
        List children = current.getChildren();
        Iterator iterator = children.iterator();
        while (iterator.hasNext()) {
            Element child = (Element) iterator.next();
            listChildren(child, depth+1);
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
