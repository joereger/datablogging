package reger.chiba.connectors;

import org.chiba.xml.util.DOMUtil;
import org.chiba.xml.xforms.connector.AbstractConnector;
import org.chiba.xml.xforms.connector.URIResolver;
import org.chiba.xml.xforms.exception.XFormsException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URI;

public class DbURIResolver extends AbstractConnector implements URIResolver {


    /**
     * Performs link traversal of the <code>file</code> URI and returns the
     * result as a DOM document.
     *
     * @return a DOM node parsed from the <code>file</code> URI.
     * @throws XFormsException if any error occurred during link traversal.
     */
    public Object resolve() throws XFormsException {
        try {
            // create uri
            URI uri = new URI(getURI());

            // use scheme specific part in order to handle UNC names
            String fileName = uri.getSchemeSpecificPart();
            reger.core.Debug.debug(3, "DbURIResolver", "loading file '" + fileName + "'");

            // create file
            File file = new File(fileName);

            // check for directory
            if (file.isDirectory()) {
                return DbURIResolver.buildDirectoryListing(file);
            }

            // parse file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setValidating(false);
            Document document = factory.newDocumentBuilder().parse(file);

            // check for fragment identifier
            if (uri.getFragment() != null) {
                return document.getElementById(uri.getFragment());
            }

            return document;
        }
        catch (Exception e) {
            throw new XFormsException(e);
        }
    }

    /**
     * Returns a plain file listing as a document.
     *
     * @param directory the directory to list.
     * @return a plain file listing as a document.
     */
    public static Document buildDirectoryListing(File directory) {
        Document dirList = DOMUtil.newDocument(false, false);
        Element root = dirList.createElement("dir");

        File[] fileList = directory.listFiles();
        File file;
        Element element;
        for (int i = 0; i < fileList.length; i++) {
            file = fileList[i];

            if (file.isDirectory()) {
                element = dirList.createElement("dir");
            }
            else {
                element = dirList.createElement("file");
            }

            element.setAttribute("name", file.getName());
            root.appendChild(element);
        }

        dirList.appendChild(root);
        return dirList;
    }

}

