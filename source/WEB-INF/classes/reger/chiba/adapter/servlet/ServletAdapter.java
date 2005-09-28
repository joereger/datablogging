package reger.chiba.adapter.servlet;

import org.apache.log4j.Category;
import org.chiba.adapter.AbstractChibaAdapter;
import org.chiba.adapter.InteractionHandler;
import org.chiba.adapter.UIEvent;
import org.chiba.tools.xslt.StylesheetLoader;
import org.chiba.tools.xslt.UIGenerator;
import org.chiba.tools.xslt.XSLTGenerator;
import org.chiba.xml.xforms.ChibaBean;
import org.chiba.xml.xforms.config.Config;
import org.chiba.xml.xforms.exception.XFormsException;
import org.w3c.dom.Node;

import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * integrates XForms Processor into Web-applications and handles request processing. This is the default
 * implementation of ChibaAdapter and besides handling the interaction it also
 * manages a UIGenerator to build the rendered output for the browser.
 *
 * @author joern turner
 * @version $Id: ServletAdapter.java,v 1.3 2005/06/07 23:47:28 joernt Exp $
 */
public class ServletAdapter extends AbstractChibaAdapter{

    //private static final Category LOGGER = Category.getInstance(ServletAdapter.class);
    public static final String HTTP_SERVLET_REQUEST = "chiba.web.request";
    public static final String HTTP_SESSION_OBJECT = "chiba.web.session";
    public static final String HTTP_UPLOAD_DIR = "chiba.web.uploadDir";

    private ChibaBean chibaBean = null;
    private String formURI = null;
    private String actionUrl = null;
    private String CSSFile = null;
    private String stylesheet = null;
    private String contextRoot = null;
    private UIGenerator generator = null;
    private String stylesheetPath = null;
    private HashMap context = null;
    public static final String USERAGENT = "chiba.useragent";
    private InteractionHandler handler;
    private Node formNode;

    /**
     * Creates a new ServletAdapter object.
     */
    public ServletAdapter() {
        this.chibaBean = createProcessor();
        this.context = new HashMap();
        chibaBean.setContext(this.context);

    }

    /**
     * creates an instance of ChibaBean, configures it and creates a generator instance
     *
     * @throws XFormsException If an error occurs
     */
    public void init() throws XFormsException {

        if (this.formURI != null) {
            //this.chibaBean.setXMLContainer(this.formURI);
            try {
                setXForms(new URI(this.formURI));
            } catch (URISyntaxException e) {
                throw new XFormsException("URI not well-formed",e);
            }
            this.chibaBean.setBaseURI(this.formURI.toString());
        }
        else if(formNode != null){
            // todo: base uri should be set to some default - the forms dir ? or leave to the developer?
            // this.chibaBean.setBaseURI(...);
            setXForms(this.formNode);
        }

        StringBuffer debug = new StringBuffer();
        debug.append(this.toString());
        debug.append("<br>Form URI: " + formURI);
        debug.append("<br>CSS-File: " + CSSFile);
        debug.append("<br>XSLT stylesheet: " + stylesheet);
        debug.append("<br>action URL: " + actionUrl);
        reger.core.Debug.debug(3, "ServletAdapter.java", debug.toString());


        this.chibaBean.init();
        this.handler = getNewInteractionHandler();
        generator = createUIGenerator();
    }

    /**
     * uses an URI in string representation to point to the XForms document to process. This URI always comes
     * as a http Url in the context of servlet processing.
     *
     * @param uriString a http URI pointing to the requested XForms
     * @throws URISyntaxException thrown in case an invalid http Url is passed in
     * @throws XFormsException thrown in case the processor couldn't be initialized from given URI, mostly likely due
     * to a problem in the form.
     */
    public void setXFormsURI(String uriString) throws URISyntaxException, XFormsException {
        this.formURI = uriString;
    }

    /**
     * return a new InteractionHandler.
     *
     * This method returns a new HttpRequestHandler.
     *
     * @return returns a new
     */
    protected InteractionHandler getNewInteractionHandler()
	throws XFormsException
    {
	return new HttpRequestHandler(this.chibaBean);
    }


    /**
     * ServletAdapter is special in its event handling - it simply ignores the concrete UIEvent
     * and applies all request params and the triggerd action in one batch process.
     *
     * @param event ignored
     * @throws XFormsException
     */
    public void dispatch(UIEvent event) throws XFormsException {
        this.handler.execute();
    }

    /**
     * terminates the XForms processing. right place to do cleanup of resources.
     *
     * @throws org.chiba.xml.xforms.exception.XFormsException
     *
     */
    public void shutdown() throws XFormsException {
        this.chibaBean.shutdown();
    }

    /**
     * Instructs the application environment to forward the given response.
     *
     * @param response a map containing at least a response stream and optional
     *                 header information.
     */
    public void forward(Map response) {
        this.chibaBean.getContext().put(SUBMISSION_RESPONSE, response);
    }

    /**
     * returns a Map object containing a forward uri. this is used by the 'load' action
     *
     * @return a Map object containing a forward uri
     */
    public Map getForwardMap() {
        return (Map) chibaBean.getContext().get(SUBMISSION_RESPONSE);
    }

    /**
     * generates the user interface.
     *
     * This method generates the user interface.
     *
     * @throws XFormsException
     */
    public final void buildUI() throws XFormsException {
        String dataPrefix = Config.getInstance().getProperty("chiba.web.dataPrefix");
        String triggerPrefix = Config.getInstance().getProperty("chiba.web.triggerPrefix");
        String userAgent = (String) getContextProperty(ServletAdapter.USERAGENT);

        generator.setParameter("data-prefix", dataPrefix);
        generator.setParameter("trigger-prefix", triggerPrefix);
        generator.setParameter("user-agent", userAgent);
        if (CSSFile != null) {
            generator.setParameter("css-file", CSSFile);
        }

        StringBuffer debug = new StringBuffer();
        debug.append(">>> setting UI generator params...");
        debug.append("<br>data-prefix=" + dataPrefix);
        debug.append("<br>trigger-prefix=" + triggerPrefix);
        debug.append("<br>user-agent=" + userAgent);
        if (CSSFile != null) {
            debug.append("<br>css-file=" + CSSFile);
        }
        debug.append("<br>>>> setting UI generator params...end");
        reger.core.Debug.debug(3, "ServletAdapter.java", debug.toString());

        generator.setInputNode(this.chibaBean.getXMLContainer());
        generator.generate();
    }

    /**
     * generates the user interface.
     *
     * This conveniance method generates the user interface
     * using a java.io.Writer.
     *
     * @param responseWriter the Writer to use for the result stream
     * @throws XFormsException
     */
    public void buildUI(Writer responseWriter) throws XFormsException {
        generator.setOutput(responseWriter);
        this.buildUI();
    }


    /**
     * factory method for creating UIGenerator instances.
     *
     * @return the created UIGenerator instance
     * @throws XFormsException
     */
    public UIGenerator createUIGenerator() throws XFormsException {
        //create and configure StylesheetLoader
        StylesheetLoader stylesLoader = new StylesheetLoader(stylesheetPath);

        //if there's a stylesheet specified in the request
        if (stylesheet != null) {
            stylesLoader.setStylesheetFile(stylesheet);
        }

        if (generator == null) {
            generator = getNewUIGenerator(stylesLoader);
        }
        //todo: move these params to buildUI too
        generator.setParameter("action-url", actionUrl);
        generator.setParameter("debug-enabled", String.valueOf(true));
        String selectorPrefix = Config.getInstance().getProperty(HttpRequestHandler.SELECTOR_PREFIX_PROPERTY,
                                                                 HttpRequestHandler.SELECTOR_PREFIX_DEFAULT);
        generator.setParameter("selector-prefix", selectorPrefix);
        String removeUploadPrefix = Config.getInstance().getProperty(HttpRequestHandler.REMOVE_UPLOAD_PREFIX_PROPERTY,
                                                                     HttpRequestHandler.REMOVE_UPLOAD_PREFIX_DEFAULT);
        generator.setParameter("remove-upload-prefix", removeUploadPrefix);
        if (CSSFile != null) {
            generator.setParameter("css-file", CSSFile);
        }
        return generator;
    }

    /**
     * return a new UIGenerator.
     *
     * This method returns a new XSLTGenerator.
     *
     * @param stylesLoader
     * @return returns a new UIGenerator object
     */
    protected UIGenerator getNewUIGenerator(StylesheetLoader stylesLoader)
        throws XFormsException
    {
        return new XSLTGenerator(stylesLoader);
    }

    /**
     * Instructs the application environment to setRedirect to the given URI.
     *
     * @param uri an absolute URI.
     */
    public void setRedirect(String uri) {
        chibaBean.getContext().put(LOAD_URI, uri);
    }

    /**
     * returns the redirect Uri
     *
     * @return the redirect Uri
     */
    public String getRedirectUri() {
        return (String) chibaBean.getContext().get(LOAD_URI);
    }

    // ************************* ACCESSORS ********************************************

    /**
     * returns the ChibaBean instance used with this servletAdapter
     *
     * @return the ChibaBean instance used with this servletAdapter
     */
    public ChibaBean getChibaBean() {
        return chibaBean;
    }

    /**
     * sets the Url for the action target
     *
     * @param actionUrl the Url for the action target
     */
    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public String getContextRoot() {
        return contextRoot;
    }

    /**
     * sets the context root for the webapp. This is used to build the correct pathes of relative path-statements
     *
     * @param contextRoot the root of the webapp
     */
    public void setContextRoot(String contextRoot) {
        this.contextRoot = contextRoot;
    }


    /**
     * sets the path where to find XForms documents.
     *
     * @param formPath the path where to find XForms documents
     */
/*
    public void setFormPath(String formPath) {
        this.formPath = formPath;
        this.formURI = null;
        this.formNode = null;
    }
*/

/*
    public void setFormURI(URI formURI) {
        this.formURI = formURI;
    }
*/

    /**
     * sets a XForms host document for processing by directly passing a DOM Node.
     *
     * @param formNode the rootnode of the host document
     * @deprecated use setXForms(Node node) from ChibaAdapter instead
     */
    public void setFormDocument(Node formNode) {
        this.formNode = formNode;
    }

    /**
     * gets a context property from Chiba's context hashmap.
     *
     * @param key
     * @return a context property from Chiba's context hashmap.
     */
    public Object getContextProperty(String key) {
        return context.get(key);
    }

    /**
     * stores a context property into Chiba's context hashmap.
     *
     * @param key the key to associate with val
     * @param val the value object to store
     */
    public void setContextProperty(String key, Object val) {
        context.put(key, val);
    }

    public String getUploadDir() {
        return (String) getContextProperty(HTTP_UPLOAD_DIR);
    }

    /**
     * sets the directory where uploaded files are stored.
     *
     * @param uploadDir the directory where uploaded files are stored
     */
    public void setUploadDir(String uploadDir) {
        setContextProperty(HTTP_UPLOAD_DIR, uploadDir);
    }

    /**
     * sets the path where to find the xslt stylesheets
     *
     * @param stylesPath the path where to find the xslt stylesheets
     */
    public void setStylesheetPath(String stylesPath) {
        this.stylesheetPath = stylesPath;
    }

    /**
     * set the CSS file to use for styling the user interface
     *
     * @param css the CSS file to use for styling the user interface
     */
    public void setCSS(String css) {
        this.CSSFile = css;
    }

    /**
     * sets the name of the xslt stylesheet to use for building the UI
     *
     * @param stylesheetFile the name of the xslt stylesheet to use for building the UI
     */
    public void setStylesheet(String stylesheetFile) {
        this.stylesheet = stylesheetFile;
    }

    /**
     * build the absolute path to the requested file and test its
     * existence. <br><br>
     *
     * @param uri - the relative uri of the file
     * @return returns the absolute path to the file
     */
/*
    private String locateFile(String uri) throws XFormsException {
        if (uri == null) {
            throw new XFormsException("No form file specified");
        }

        //construct absolute path to file and check existence
        String filePath = contextRoot + uri;

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("requested file: " + filePath);
        }

        if (!(new File(filePath).exists())) {
            throw new XFormsException("File does not exist: " + filePath);
        }

        return filePath;
    }
*/

}
