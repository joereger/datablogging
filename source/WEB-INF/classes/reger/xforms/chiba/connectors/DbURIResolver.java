package reger.xforms.chiba.connectors;

import org.chiba.xml.util.DOMUtil;
import org.chiba.xml.xforms.connector.AbstractConnector;
import org.chiba.xml.xforms.connector.URIResolver;
import org.chiba.xml.xforms.exception.XFormsException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.jdom.JDOMException;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.StringReader;
import java.io.IOException;
import java.net.URI;

import reger.xforms.EventXformData;

public class DbURIResolver extends AbstractConnector implements URIResolver {

    public DbURIResolver(){
        reger.core.Debug.debug(5, "DbURIResolver.java", "DbURIResolver instantiated");
    }

    /**
     * Performs link traversal of the <code>file</code> URI and returns the
     * result as a DOM document.
     *
     * @return a DOM node parsed from the <code>file</code> URI.
     * @throws XFormsException if any error occurred during link traversal.
     */
    public Object resolve() throws XFormsException {
        reger.core.Debug.debug(5, "DbURIResolver.java", "DbURIResolver.resolve() called");
        try {

            // use scheme specific part in order to handle UNC names
            URI uri = new URI(getURI());
            reger.core.Debug.debug(5, "DbURIResolver.java", "getContext().get(\"eventid\")="+getContext().get("eventid"));
            reger.core.Debug.debug(5, "DbURIResolver.java", "getContext().get(\"logid\")="+getContext().get("logid"));
            int eventid=0;
            if (getContext().get("eventid")!=null && reger.core.Util.isinteger(String.valueOf(getContext().get("eventid")))){
                eventid=Integer.parseInt(String.valueOf(getContext().get("eventid")));
            }
            int logid=0;
            if (getContext().get("logid")!=null && reger.core.Util.isinteger(String.valueOf(getContext().get("logid")))){
                logid=Integer.parseInt(String.valueOf(getContext().get("logid")));
            }

            String uriSpecificPart = uri.getSchemeSpecificPart();
            reger.core.Debug.debug(5, "DbURIResolver", "uriSpecificPart=" + uriSpecificPart);

            reger.core.Debug.debug(5, "DbURIResolver", "loading xform from database");

            //Load from the database
            eventid=1;
            EventXformData eventXformData = new EventXformData();
            eventXformData.loadByEventid(eventid, logid);

            //Build the DOM
            if (eventXformData.getXformdata()!=null && !eventXformData.getXformdata().equals("")){
                try{
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    factory.setNamespaceAware(true);
                    factory.setValidating(false);
                    Document doc = factory.newDocumentBuilder().parse(new InputSource(new StringReader(eventXformData.getXformdata())));
                    return doc;
                } catch (Exception e){
                    reger.core.Debug.debug(5, "DbURIResolver.java", e);
                }
            }


            return nothing();

        } catch (Exception e) {
            reger.core.Debug.debug(5, "DbURIResolver.java", e);
            throw new XFormsException(e);
        }
    }

    public Document createAnInstance(){
        //Take what's in the database, if anything.
        //Parse the form itself to create an instance data set.
        //Merge them into the final, letting the database win.

        return null;

    }

    public static Document nothing() {
        Document dirList = DOMUtil.newDocument(false, false);
        Element root = dirList.createElement("nothing");

        Element element;


        element = dirList.createElement("booyah");
        element.setAttribute("foo", "bar");
        root.appendChild(element);


        dirList.appendChild(root);
        return dirList;
    }

}

