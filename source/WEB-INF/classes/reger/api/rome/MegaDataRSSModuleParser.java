package reger.api.rome;

import com.sun.syndication.io.ModuleParser;
import com.sun.syndication.feed.module.Module;
import org.jdom.Namespace;
import org.jdom.Element;

import java.util.List;

import reger.mega.FieldType;






/**
 * ModuleParses implementation
 */
public class MegaDataRSSModuleParser implements ModuleParser{

    public String getNamespaceUri() {
        return MegaDataRSSModule.URI;
    }

    public Module parse(Element dcRoot) {
        boolean foundSomething = false;
        MegaDataRSSModule fm = new MegaDataRSSModuleImpl();


//        List eList = dcRoot.getChildren("foo", MegaDataModule.ENTRYDATA_NS);
//        if (eList.size() > 0) {
//            foundSomething = true;
//            fm.setFields(parseFoos(eList));
//        }

        return (foundSomething) ? fm : null;
    }

    private FieldType[] parseFoos(List eList) {
        FieldType[] foos = new FieldType[0];
//        for (int i = 0; i < eList.size(); i++) {
//            Element e = (Element) eList.get(i);
//            foos.add(e.getText());
//        }
        return foos;
    }

}
