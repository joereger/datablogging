package reger.xforms.chiba;

import org.chiba.adapter.ChibaAdapter;
import org.chiba.xml.xforms.exception.XFormsException;
import org.xml.sax.InputSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.net.URISyntaxException;

import reger.core.WebAppRootDir;
import reger.systemprops.PathUploadMedia;
import reger.Entry;
import reger.Log;
import reger.AllMegaLogTypesInSystem;
import reger.cache.providers.jboss.Cacheable;

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
 */
@Cacheable
public class ChibaServletReger {

    private static final String XSL_PARAM_NAME = "xslt";
    private static final String CSS_PARAM_NAME = "css";
    private static final String ACTIONURL_PARAM_NAME = "action_url";
    private static final String JAVASCRIPT_PARAM_NAME = "JavaScript";

    private Entry entry;
    private Log log;

    public ChibaServletReger(Entry entry, Log log){
        reger.core.Debug.debug(5, "ChibaServletReger.java", "--------------- creating instance of ChibaServletReger... ---------------");
        this.entry = entry;
        this.log = log;
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
     * @see org.chiba.xml.xforms.connector.context.ContextResolver
     * @see org.chiba.xml.xforms.connector.ConnectorFactory
     */
    public String doGet(HttpServletRequest request, HttpServletResponse response){

        reger.core.Debug.debug(5, "ChibaServletReger.java", "ChibaServletReger.doGet(request, response) called.");

        ServletAdapterReger servletAdapter = null;
        HttpSession session = request.getSession(true);

        reger.core.Debug.debug(5, "ChibaServletReger.java", "--------------- new XForms session ---------------");
        try {
            // build actionURL where forms are submitted to
            String actionURL = getActionURL(request, response);
            String requestURI = getRequestURI(request) + request.getServletPath();
            servletAdapter = setupServletAdapter(actionURL, session, requestURI);
            updateContext(servletAdapter, request, session);

            //Set context params
            servletAdapter.setContextProperty("eventid", String.valueOf(entry.eventid));
            servletAdapter.setContextProperty("logid", String.valueOf(log.getLogid()));

            //add all request params that are not used by this servlet to the context map in ChibaBean
            storeContextParams(request, servletAdapter);
            servletAdapter.init();
            servletAdapter.dispatch(null);
            StringWriter out = new StringWriter();
            servletAdapter.buildUI(out);
            session.setAttribute("chiba.adapter", servletAdapter);
            String returnValue = out.toString();

            out.close();

            return returnValue;
        } catch (Exception e) {
            reger.core.Debug.errorsave(e, "ChibaServletReger.java");
            shutdown(servletAdapter, session, e, response, request);
        }
        return "";
    }


    /**
     * this method is responsible for passing all context information needed by the Adapter and Processor from
     * ServletRequest to ChibaContext.
     *
     * @param servletAdapter the ChibaAdapter to use
     * @param request        the ServletRequest
     * @param session        the ServletSession
     */
    protected void updateContext(ServletAdapterReger servletAdapter, HttpServletRequest request, HttpSession session) {
        servletAdapter.setContextProperty(ServletAdapterReger.USERAGENT, request.getHeader("User-Agent"));
        servletAdapter.setContextProperty(ServletAdapterReger.HTTP_SERVLET_REQUEST, request);
        servletAdapter.setContextProperty(ServletAdapterReger.HTTP_SESSION_OBJECT, session);
    }


    /**
     * handles all interaction with the user during a form-session.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        reger.core.Debug.debug(5, "ChibaServletReger.java", "ChibaServletReger.doPost(request, response) called.");

        HttpSession session = request.getSession(true);
        ServletAdapterReger servletAdapter = null;

        try {

            //@todo Put in userSession, not session
            servletAdapter = (ServletAdapterReger) session.getAttribute("chiba.adapter");
            if (servletAdapter == null) {
                reger.core.Debug.debug(5, "ChibaServletReger.java", "Invalid session in doPost()");
                return "";
            }
            updateContext(servletAdapter, request, session);
            servletAdapter.dispatch(null);

            //Set context params
            servletAdapter.setContextProperty("eventid", String.valueOf(entry.eventid));
            servletAdapter.setContextProperty("logid", String.valueOf(log.getLogid()));

            // handle setRedirect <xforms:load show='replace'/>
            // and redirect from submission as well
            // NOTE - this needs to be checked *before* the this.getForwardMap()
            // as a submission handler may force a redirect
            if (servletAdapter.getRedirectUri() != null) {

                reger.core.Debug.debug(5, "ChibaServletReger.java", "servletAdapter.getRedirectUri() is NOT null = " + servletAdapter.getRedirectUri());

                String redirectTo = servletAdapter.getRedirectUri();

                // shutdown processor
                servletAdapter.getChibaBean().shutdown();

                // send redirect (after encoding session id if required)
                response.sendRedirect(response.encodeRedirectURL(redirectTo));

                // remove redirect uri and terminate
                servletAdapter.setRedirect(null);
                return "";
            }

            // handle forward <xforms:submission replace='all'/>
            Map forwardMap = servletAdapter.getForwardMap();
            InputStream forwardStream = (InputStream) forwardMap.get(ChibaAdapter.SUBMISSION_RESPONSE_STREAM);
            if (forwardStream != null) {

                reger.core.Debug.debug(5, "ChibaServletReger.java", "forwardStream is NOT null");

                // shutdown processor
                servletAdapter.getChibaBean().shutdown();

                // forward submission response
                forwardResponse(forwardMap, response);

                // remove forward response and terminate
                servletAdapter.forward(null);
                return "";
            }

            reger.core.Debug.debug(5, "ChibaServletReger.java", "Did not redirect and did not forward to stream... returning response myself.");

            // render result to output
            StringWriter out = new StringWriter();
            String returnValue = "";
            servletAdapter.buildUI(out);
            returnValue = out.toString();
            return returnValue;
        } catch (Exception e) {
            shutdown(servletAdapter, session, e, response, request);
        }
        return "";
    }

    /**
     * creates and configures the ServletAdapter which does the actual request processing.
     *
     * it is then stored in the user's session
     *
     * @param actionURL - the URL to submit to
     * @param session   - the Servlet session
     * @return ServletAdapter
     */
    private ServletAdapterReger setupServletAdapter(String actionURL, HttpSession session, String requestURI) throws XFormsException, URISyntaxException {

        ServletAdapterReger aAdapter = new ServletAdapterReger();

        try{
            aAdapter.setContextRoot(WebAppRootDir.getWebAppRootPath());
            aAdapter.setConfigPath(reger.core.WebAppRootDir.getWebAppRootPath() + "WEB-INF"+java.io.File.separator+"chibaConfig.xml");
            aAdapter.setActionUrl(actionURL);
            PathUploadMedia pathUploadMedia = new PathUploadMedia();
            aAdapter.setUploadDir(reger.systemprops.AllSystemProperties.getProp(pathUploadMedia.getPropertyName()));
            aAdapter.setBaseURI(requestURI);
            aAdapter.setStylesheetPath(reger.core.WebAppRootDir.getWebAppRootPath() + "css" + java.io.File.separator + "chibaXslt");

            //XForm from file
            //String xFormPath = reger.core.WebAppRootDir.getWebAppRootPath() + "forms"+java.io.File.separator+"address-db.xhtml";
            //InputSource xForm = new InputSource(new FileInputStream(xFormPath));

            //Xform from log/db
            reger.core.Debug.debug(5, "ChibaServletReger.java", "loading xform from log for logid=" + log.getLogid() + " AND eventtypeid="+log.getEventtypeid());
            String xform = AllMegaLogTypesInSystem.getMegaLogTypeByEventtypeid(log.getEventtypeid()).getLogtypexform().getXform();
            InputSource xFormFromDb = new InputSource(new StringReader(xform));

            //Set XForm on adapter
            aAdapter.setXForms(xFormFromDb);
        } catch (Exception e){
            reger.core.Debug.errorsave(e, "ChibaServletReger.java");
        }

        Map servletMap = new HashMap();
        servletMap.put(ChibaAdapter.SESSION_ID, session.getId());
        aAdapter.setContextProperty(ChibaAdapter.SUBMISSION_RESPONSE, servletMap);

        return aAdapter;
    }

    private void storeContextParams(HttpServletRequest request, ServletAdapterReger servletAdapter) {
        Enumeration params = request.getParameterNames();
        String s;
        while (params.hasMoreElements()) {
            s = (String) params.nextElement();
            //store all request-params we don't use in the context map of ChibaBean
            if (!(s.equals(XSL_PARAM_NAME) || s.equals(CSS_PARAM_NAME) || s.equals(ACTIONURL_PARAM_NAME))) {
                String value = request.getParameter(s);
                servletAdapter.setContextProperty(s, value);
                reger.core.Debug.debug(5, "ChibaServletReger.java", "added request param '" + s + "' added to context");
            }
        }
    }

    private String getActionURL(HttpServletRequest request, HttpServletResponse response) {

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

        reger.core.Debug.debug(5, "ChibaServletReger.java", "getActionURL actionURL: " + actionURL);
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

    private void shutdown(ServletAdapterReger servletAdapter, HttpSession session, Exception e, HttpServletResponse response, HttpServletRequest request) {
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

        try{
            // redirect to error page (after encoding session id if required)
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/" +
            request.getSession().getServletContext().getInitParameter("error.page")));
            return;
        } catch (Exception ex){
            reger.core.Debug.errorsave(ex, "ChibaServletReger.java");
        }
    }
}

