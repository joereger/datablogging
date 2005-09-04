package reger.api.rome;

import org.jdom.Namespace;
import org.jdom.Element;

import java.util.*;

import com.sun.syndication.feed.module.Module;
import com.sun.syndication.io.ModuleGenerator;
import reger.mega.FieldType;
import reger.mega.FieldData;
import reger.core.Debug;

/**
 * The Generator element which outputs xml
 */
public class MegaDataRSSModuleGenerator implements ModuleGenerator {

    private static final Namespace ENTRYDATA_NS  = Namespace.getNamespace("entrydata", MegaDataRSSModule.URI);

    public String getNamespaceUri() {
        return MegaDataRSSModule.URI;
    }

    private static final Set NAMESPACES;

    static {
        Set nss = new HashSet();
        nss.add(ENTRYDATA_NS);
        NAMESPACES = Collections.unmodifiableSet(nss);
    }

    public Set getNamespaceUris() {
        HashSet uris = new HashSet();
        for (Iterator iterator = NAMESPACES.iterator(); iterator.hasNext();) {
            Namespace ns = (Namespace) iterator.next();
            uris.add(ns.getURI());
        }
        return uris;
    }

    public Set getNamespaces() {
        return NAMESPACES;
    }

    public void generate(Module module, Element element) {

        Debug.debug(5, "", "MegeDataRSSModuleGenerator.java - generate() called.");

        // this is not necessary, it is done to avoid the namespace definition in every item.
        Element root = element;
        while (root.getParent()!=null && root.getParent() instanceof Element) {
            root = (Element) element.getParent();
        }
        root.addNamespaceDeclaration(ENTRYDATA_NS);

        MegaDataRSSModule fm = (MegaDataRSSModule)module;

        FieldType[] fields = fm.getFields();
        if (fields!=null){
            for (int i = 0; i < fields.length; i++) {
                Debug.debug(5, "", "MegaDataRSSModuleGenerator.java - Found a fieldid=" + fields[i].getFieldname());
                //element.addContent(generateSimpleElement("foo",foos.get(i).toString()));
                element.addContent(generateElementFromField(fields[i]));
            }
        }


    }

    protected Element generateElementFromField(FieldType field){
        Element element = new Element ("field" , ENTRYDATA_NS);

        //Fieldname
        Element elementFieldname = new Element ("fieldname" , ENTRYDATA_NS);
        elementFieldname.addContent(field.getFieldname());
        element.addContent(elementFieldname);

        //Fieldid
        Element elementFieldid = new Element ("fieldid" , ENTRYDATA_NS);
        elementFieldid.addContent(String.valueOf(field.getMegafieldid()));
        element.addContent(elementFieldid);

        Debug.debug(5, "", "MegaDataRSSModuleGenerator.java - Generating element tag for " + field.getFieldname());

        //Collect the data
        FieldData[] fieldData = field.getDataForField();
        if (fieldData!=null){
            for (int i = 0; i < fieldData.length; i++) {
                Debug.debug(5, "", "MegaDataRSSModuleGenerator.java - Fielddata for " + field.getFieldname() + " is NOT null.  fieldData[i].getValue()=" + fieldData[i].getValue());

                //Data
                Element elementData = new Element ("data" , ENTRYDATA_NS);

                //Name
                Element elementName = new Element ("name" , ENTRYDATA_NS);
                elementName.addContent(fieldData[i].getName());
                elementData.addContent(elementName);

                //Value
                Element elementValue = new Element ("value" , ENTRYDATA_NS);
                elementValue.addContent(fieldData[i].getValue());
                elementData.addContent(elementValue);

                //Add to the field
                element.addContent(elementData);
            }
        }


        return element;
    }

//    protected Element generateSimpleElement(String name, String value)  {
//        Element element = new Element(name, ENTRYDATA_NS);
//        element.addContent(value);
//        return element;
//    }


}
