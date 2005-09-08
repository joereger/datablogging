package reger.xml;

import org.jdom.Namespace;
import org.jdom.Element;
import org.jdom.Attribute;

import java.util.List;
import java.util.Iterator;

/**
 * Reports on an Element
 */
public class JdomElementInspector {

    public static String inspect(Element element) {
        return inspect(element, "");
    }

    public static String inspect(Element element, String lineDivider) {
        StringBuffer out = new StringBuffer();


        String qualifiedName = element.getQualifiedName();
        out.append(lineDivider+"element.getQualifiedName():"+qualifiedName);

        Namespace namespace = element.getNamespace();
        if (namespace != Namespace.NO_NAMESPACE) {
            String localName = element.getName();
            String uri = element.getNamespaceURI();
            String prefix = element.getNamespacePrefix();
            out.append(lineDivider+"element.getName(): " + localName);
            out.append(lineDivider+"element.getNamespaceURI(): " + uri);
            out.append(lineDivider+"element.getNamespacePrefix(): " + prefix);
        }
        List attributes = element.getAttributes();
        if (!attributes.isEmpty()) {
            Iterator iterator = attributes.iterator();
            while (iterator.hasNext()) {
                Attribute attribute = (Attribute) iterator.next();
                String name = attribute.getName();
                String value = attribute.getValue();
                Namespace attributeNamespace = attribute.getNamespace();
                if (attributeNamespace == Namespace.NO_NAMESPACE) {
                    out.append(lineDivider+ name + "=\"" + value + "\"");
                } else {
                    String prefix = attributeNamespace.getPrefix();
                    out.append(lineDivider+"  " + prefix + ":" + name + "=\"" + value + "\"");
                }
            }
        }

        List namespaces = element.getAdditionalNamespaces();
        if (!namespaces.isEmpty()) {
            Iterator iterator = namespaces.iterator();
            while (iterator.hasNext()) {
                Namespace additional = (Namespace) iterator.next();
                String uri = additional.getURI();
                String prefix = additional.getPrefix();
                out.append(lineDivider+"  .getPrefix():" + prefix + "=\"" + uri + "\"");
            }
        }

        return out.toString();
    }



}
