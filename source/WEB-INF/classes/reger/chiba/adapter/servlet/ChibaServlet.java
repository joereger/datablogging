package reger.chiba.adapter.servlet;

import org.apache.log4j.Category;
import org.chiba.adapter.ChibaAdapter;
import org.chiba.xml.xforms.config.Config;
import org.chiba.xml.xforms.exception.XFormsException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.net.URISyntaxException;

/**
 * The ChibaServlet handles all interactions between client and
 * form-processor (ChibaBean) for the whole lifetime of a form-filling session.
 * <br>
 * The Processor will be started through a Get-request from the client
 * pointing to the desired form-container. The Processor instance will
 * be stored in a Session-object.<br>
 * <br>
 * All further interaction will be handled through Post-requests.
 * Incoming request params will be mapped to data and action-handlers.
 *
 * @author Joern Turner
 * @author Ulrich Nicolas Liss&eacute;
 * @author William Boyd
 * @version $Version: $
 */
public class ChibaServlet extends HttpServlet {
    //init-params
    //private static Category cat = Category.getInstance(ChibaServlet.class);

    private static final String FORM_PARAM_NAME = "form";
    private static final String XSL_PARAM_NAME = "xslt";
    private static final String CSS_PARAM_NAME = "css";
    private static final String ACTIONURL_PARAM_NAME = "action_url";
    private static final String JAVASCRIPT_PARAM_NAME = "JavaScript";

    /*
     * It is not thread safe to modify these variables once the
     * init(ServletConfig) method has been called
     */
    // the absolute path to the Chiba config-file
    private String configPath = null;

    // the rootdir of this app; forms + documents fill be searched under this root
    private String contextRoot = null;

    // where uploaded files are stored
    private String uploadDir = null;

    private String stylesPath = null;

    /**
     * Returns a short description of the servlet.
     *
     * @return - Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Servlet Controller for Chiba XForms Processor";
    }

    /**
     * Destroys the servlet.
     */
    public void destroy() {
    }

    /**
     * Initializes the servlet.
     *
     * @param config - the ServletConfig object
     * @throws javax.servlet.ServletException
     */
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        reger.core.Debug.debug(5, "ChibaServlet.java", "--------------- initing ChibaServlet... ---------------");
        //read some params from web-inf
        contextRoot = getServletConfig().getServletContext().getRealPath("");
        if (contextRoot == null)
            contextRoot = getServletConfig().getServletContext().getRealPath(".");

        //get the relative path to the chiba config-file
        String path = getServletConfig().getInitParameter("chiba.config");

        //get the real path for the config-file
        if (path != null) {
            configPath = getServletConfig().getServletContext().getRealPath(path);
        }

        //get the path for the stylesheets
        path = getServletConfig().getServletContext().getInitParameter("chiba.xforms.stylesPath");

        //get the real path for the stylesheets and configure a new StylesheetLoader with it
        if (path != null) {
            stylesPath = getServletConfig().getServletContext().getRealPath(path);
            reger.core.Debug.debug(5, "ChibaServlet.java", "stylesPath: " + stylesPath);
        }

        //uploadDir = contextRoot	+ "/" + getServletConfig().getServletContext().getInitParameter("chiba.upload");
        uploadDir = getServletConfig().getServletContext().getInitParameter("chiba.upload");

        //Security constraint
        if (uploadDir != null) {
            if (uploadDir.toUpperCase().indexOf("WEB-INF") >= 0) {
                throw new ServletException("Chiba security constraint: uploadDir '" + uploadDir + "' not allowed");
            }
        }
    }

    /**
     * Starts a new form-editing session.<br>
     * <p/>
     * The default value of a number of settings can be overridden as follows:
     * <p/>
     * 1. The uru of the xform to be displayed can be specified by using a param name of 'form' and a param value
     * of the location of the xform file as follows, which will attempt to load the current xforms file.
     * <p/>
     * http://localhost:8080/chiba-0.9.3/XFormsServlet?form=/forms/hello.xhtml
     * <p/>
     * 2. The uru of the CSS file used to style the form can be specified using a param name of 'css' as follows:
     * <p/>
     * http://localhost:8080/chiba-0.9.3/XFormsServlet?form=/forms/hello.xhtml&css=/chiba/my.css
     * <p/>
     * 3. The uri of the XSLT file used to generate the form can be specified using a param name of 'xslt' as follows:
     * <p/>
     * http://localhost:8080/chiba-0.9.3/XFormsServlet?form=/forms/hello.xhtml&xslt=/chiba/my.xslt
     * <p/>
     * 4. Besides these special params arbitrary other params can be passed via the GET-string and will be available
     * in the context map of ChibaBean. This means they can be used as instance data (with the help of ContextResolver)
     * or to set params for URI resolution.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @see org.chiba.xml.xforms.connector.context.ContextResolver
     * @see org.chiba.xml.xforms.connector.ConnectorFactory
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        reger.core.Debug.debug(3, "ChibaServlet.java", "ChibaServlet.doGet(request, response) called.");

        ServletAdapter servletAdapter = null;
        HttpSession session = request.getSession(true);

        reger.core.Debug.debug(5, "ChibaServlet.java", "--------------- new XForms session ---------------");
        try {
            response.setContentType("text/html");
            java.io.PrintWriter out = response.getWriter();

            // determine Form to load
            String formURI = getRequestURI(request) + request.getParameter(FORM_PARAM_NAME);
            if (formURI == null) {
                throw new IOException("Resource not found: " + formURI + " not found");
            }

            String xslFile = request.getParameter(XSL_PARAM_NAME);
            String css = request.getParameter(CSS_PARAM_NAME);
            String javascriptEnabled = request.getParameter(JAVASCRIPT_PARAM_NAME);

            //---> jt: please ignore
            //user-agent detection and related Adapter creation should be handled through a separate factory later
            if (javascriptEnabled != null){
                //do AJAX
            }else{
                //do standard servlet stuff below...
            }
            //<--- jt:end ignore

            // build actionURL where forms are submitted to
            String actionURL = getActionURL(request, response);
            reger.core.Debug.debug(3, "ChibaServlet.java", "actionURL=" + actionURL);

            servletAdapter = setupServletAdapter(actionURL, session, formURI, xslFile, css);
            updateContext(servletAdapter, request, session);

            //add all request params that are not used by this servlet to the context map in ChibaBean
            storeContextParams(request, servletAdapter);
            servletAdapter.init();
            //todo: refactor to use map or event as param
            servletAdapter.dispatch(null);

            servletAdapter.buildUI(out);
            session.setAttribute("chiba.adapter", servletAdapter);
            out.close();
        } catch (Exception e) {
            reger.core.Debug.errorsave(e, "ChibaServlet.java");
            shutdown(servletAdapter, session, e, response, request);
        }
    }


    /**
     * this method is responsible for passing all context information needed by the Adapter and Processor from
     * ServletRequest to ChibaContext.
     *
     * @param servletAdapter the ChibaAdapter to use
     * @param request        the ServletRequest
     * @param session        the ServletSession
     */
    protected void updateContext(ServletAdapter servletAdapter, HttpServletRequest request, HttpSession session) {
        servletAdapter.setContextProperty(ServletAdapter.USERAGENT, request.getHeader("User-Agent"));
        servletAdapter.setContextProperty(ServletAdapter.HTTP_SERVLET_REQUEST, request);
        servletAdapter.setContextProperty(ServletAdapter.HTTP_SESSION_OBJECT, session);
    }


    /**
     * handles all interaction with the user during a form-session.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        reger.core.Debug.debug(3, "ChibaServlet.java", "ChibaServlet.doPost(request, response) called.");

        HttpSession session = request.getSession(true);
        ServletAdapter servletAdapter = null;

        try {
            servletAdapter = (ServletAdapter) session.getAttribute("chiba.adapter");
            if (servletAdapter == null) {
                throw new ServletException(Config.getInstance().getErrorMessage("session-invalid"));
            }
            updateContext(servletAdapter, request, session);
            //servletAdapter.executeHandler();
            servletAdapter.dispatch(null);

            // handle setRedirect <xforms:load show='replace'/>
            // and redirect from submission as well
            // NOTE - this needs to be checked *before* the this.getForwardMap()
            // as a submission handler may force a redirect
            if (servletAdapter.getRedirectUri() != null) {
                reger.core.Debug.debug(3, "ChibaServlet.java", "servletAdapter.getRedirectUri() is NOT null = " + servletAdapter.getRedirectUri());
                String redirectTo = servletAdapter.getRedirectUri();
                // todo: remove from session ?
                // shutdown processor
                servletAdapter.getChibaBean().shutdown();

                // send redirect (after encoding session id if required)
                response.sendRedirect(response.encodeRedirectURL(redirectTo));

                // remove redirect uri and terminate
                servletAdapter.setRedirect(null);
                return;
            }

            // handle forward <xforms:submission replace='all'/>
            Map forwardMap = servletAdapter.getForwardMap();
            InputStream forwardStream = (InputStream) forwardMap.get(ChibaAdapter.SUBMISSION_RESPONSE_STREAM);
            if (forwardStream != null) {
                reger.core.Debug.debug(3, "ChibaServlet.java", "forwardStream is NOT null");
                // todo: remove from session ?
                // shutdown processor
                servletAdapter.getChibaBean().shutdown();

                // forward submission response
                forwardResponse(forwardMap, response);

                // remove forward response and terminate
                servletAdapter.forward(null);
                return;
            }

            reger.core.Debug.debug(3, "ChibaServlet.java", "Did not redirect and did not forward to stream... returning response myself.");

            // set content type
            response.setContentType("text/html");

            // render result to output
            servletAdapter.buildUI(response.getWriter());
            response.getWriter().close();
        } catch (Exception e) {
            shutdown(servletAdapter, session, e, response, request);
        }
    }

    /**
     * creates and configures the ServletAdapter which does the actual request processing.
     *
     * @param actionURL - the URL to submit to
     * @param session   - the Servlet session
     * @param formPath  - the relative location where forms are stored
     * @param xslFile   - the xsl file to use for transform
     * @param cssFile   - the CSS file to use for styling the output
     * @return ServletAdapter
     */
    private ServletAdapter setupServletAdapter(String actionURL,
                                               HttpSession session,
                                               String formPath,
                                               String xslFile,
                                               String cssFile) throws XFormsException, URISyntaxException {
        //setup and configure the adapter
        ServletAdapter aAdapter = new ServletAdapter();
        aAdapter.setContextRoot(contextRoot);
        if ((configPath != null) && !(configPath.equals(""))) {
            aAdapter.setConfigPath(configPath);
        }
        aAdapter.setXFormsURI(formPath);
        aAdapter.setStylesheetPath(stylesPath);
        aAdapter.setActionUrl(actionURL);
        aAdapter.setUploadDir(uploadDir);

        if (xslFile != null) {
            aAdapter.setStylesheet(xslFile);
            reger.core.Debug.debug(5, "ChibaServlet.java", "using xsl stylesheet: " + xslFile);
        }
        if (cssFile != null) {
            aAdapter.setCSS(cssFile);
            reger.core.Debug.debug(5, "ChibaServlet.java", "using css stylesheet: " + cssFile);
        }

        Map servletMap = new HashMap();
        servletMap.put(ChibaAdapter.SESSION_ID, session.getId());
        aAdapter.setContextProperty(ChibaAdapter.SUBMISSION_RESPONSE, servletMap);

        return aAdapter;
    }

    private void storeContextParams(HttpServletRequest request, ServletAdapter servletAdapter) {
        Enumeration params = request.getParameterNames();
        String s;
        while (params.hasMoreElements()) {
            s = (String) params.nextElement();
            //store all request-params we don't use in the context map of ChibaBean
            if (!(s.equals(FORM_PARAM_NAME) || s.equals(XSL_PARAM_NAME) || s.equals(CSS_PARAM_NAME) || s.equals(ACTIONURL_PARAM_NAME))) {
                String value = request.getParameter(s);
                servletAdapter.setContextProperty(s, value);
                reger.core.Debug.debug(5, "ChibaServlet.java", "added request param '" + s + "' added to context");
            }
        }
    }

    private String getActionURL(HttpServletRequest request, HttpServletResponse response) {
/*
        String defaultActionURL =
                request.getScheme()
                + "://"
                + request.getServerName()
                + ":"
                + request.getServerPort()
                + request.getContextPath()
                + request.getServletPath();
*/
        String defaultActionURL = getRequestURI(request) + request.getServletPath();
        String encodedDefaultActionURL = response.encodeURL(defaultActionURL);
        int sessIdx = encodedDefaultActionURL.indexOf(";jsession");
        String sessionId = null;
        if (sessIdx > -1) {
            sessionId = encodedDefaultActionURL.substring(sessIdx);
        }
        String actionURL = request.getParameter(ACTIONURL_PARAM_NAME);
        if (null == actionURL) {
            actionURL = encodedDefaultActionURL;
        } else if (null != sessionId) {
            actionURL += sessionId;
        }

        reger.core.Debug.debug(5, "ChibaServlet.java", "actionURL: " + actionURL);
        // encode the URL to allow for session id rewriting
        actionURL = response.encodeURL(actionURL);
        return actionURL;
    }

    private String getRequestURI(HttpServletRequest request){
        StringBuffer buffer = new StringBuffer(request.getScheme());
        buffer.append("://");
        buffer.append(request.getServerName());
        buffer.append(":");
        buffer.append(request.getServerPort()) ;
        buffer.append(request.getContextPath());
        return buffer.toString();
    }

    private void forwardResponse(Map forwardMap, HttpServletResponse response) throws IOException {
        // fetch response stream
        InputStream responseStream = (InputStream) forwardMap.remove(ChibaAdapter.SUBMISSION_RESPONSE_STREAM);

        // copy header information
        Iterator iterator = forwardMap.keySet().iterator();
        while (iterator.hasNext()) {
            String name = iterator.next().toString();
            String value = forwardMap.get(name).toString();
            response.setHeader(name, value);
        }

        // copy stream content
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        for (int b = responseStream.read();
             b > -1;
             b = responseStream.read()) {
            outputStream.write(b);
        }

        // close streams
        responseStream.close();
        outputStream.close();
    }

    private void shutdown(ServletAdapter servletAdapter, HttpSession session, Exception e, HttpServletResponse response, HttpServletRequest request) throws IOException {
        // attempt to shutdown processor
        if (servletAdapter != null && servletAdapter.getChibaBean() != null) {
            try {
                servletAdapter.getChibaBean().shutdown();
            } catch (XFormsException xfe) {
                xfe.printStackTrace();
            }
        }

        // store exception
        session.setAttribute("chiba.exception", e);

        // redirect to error page (after encoding session id if required)
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/" +
                request.getSession().getServletContext().getInitParameter("error.page")));
    }
}

