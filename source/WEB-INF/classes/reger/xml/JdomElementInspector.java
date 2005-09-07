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
        StringBuffer out = new StringBuffer();


        String qualifiedName = element.getQualifiedName();
        out.append(qualifiedName + ":");

        Namespace namespace = element.getNamespace();
        if (namespace != Namespace.NO_NAMESPACE) {
            String localName = element.getName();
            String uri = element.getNamespaceURI();
            String prefix = element.getNamespacePrefix();
            out.append("  Local name: " + localName);
            out.append("  Namespace URI: " + uri);
            if (!"".equals(prefix)) {
                out.append("  Namespace prefix: " + prefix);
            }
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
                    out.append("  " + name + "=\"" + value + "\"");
                } else {
                    String prefix = attributeNamespace.getPrefix();
                    out.append("  " + prefix + ":" + name + "=\"" + value + "\"");
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
                out.append("  xmlns:" + prefix + "=\"" + uri + "\"");
            }
        }

        return out.toString();
    }



}
