package reger.ldap;

/**
 * Provides an LDAP authorization
 */
public class LdapPlugin {


//    private static final String BLOG_LDAP_AUTHORIZATION_SERVER_IP = "blog-ldap-authorization-server";
//    private static final String BLOG_LDAP_AUTHORIZATION_PORT_IP = "blog-ldap-authorization-port";
//    private static final String BLOG_LDAP_AUTHORIZATION_DN_IP = "blog-ldap-authorization-dn";
//    private static final String BLOG_LDAP_AUTHORIZATION_UID_IP = "blog-ldap-authorization-uid";
//    private static final String BLOG_LDAP_AUTHORIZATION_BINDING_USER_IP = "blog-ldap-authorization-bindinguser";
//    private static final String BLOG_LDAP_AUTHORIZATION_BINDING_PASSWORD_IP = "blog-ldap-authorization-bindingpassword";
//
//    private static final String UID_DEFAULT = "uid";
//
//    private Log _logger = LogFactory.getLog(LDAPAuthorizationProvider.class);
//    private String _ldapServer;
//    private int _ldapPort = 389;
//    private String _ldapDN;
//    private String _uidAttributeName = UID_DEFAULT;
//
//    private String _bindingUser = null;
//    private String _bindingPassword = null;
//
//    /**
//     * Default constructor
//     */
//    public LDAPAuthorizationProvider() {
//    }
//
//    /**
//     * Initialization method for the authorization provider
//     *
//     * @param servletConfig        ServletConfig for obtaining any initialization parameters
//     * @param blojsomConfiguration BlojsomConfiguration for blojsom-specific configuration information
//     * @throws org.blojsom.blog.BlojsomConfigurationException
//     *          If there is an error initializing the provider
//     */
//    public void init(ServletConfig servletConfig, BlojsomConfiguration blojsomConfiguration) throws BlojsomConfigurationException {
//        super.init(servletConfig, blojsomConfiguration);
//
//        _ldapServer = _servletConfig.getInitParameter(BLOG_LDAP_AUTHORIZATION_SERVER_IP);
//        _ldapDN = _servletConfig.getInitParameter(BLOG_LDAP_AUTHORIZATION_DN_IP);
//        String port = _servletConfig.getInitParameter(BLOG_LDAP_AUTHORIZATION_PORT_IP);
//        if (!BlojsomUtils.checkNullOrBlank(_servletConfig.getInitParameter(BLOG_LDAP_AUTHORIZATION_UID_IP))) {
//            _uidAttributeName = _servletConfig.getInitParameter(BLOG_LDAP_AUTHORIZATION_UID_IP);
//        }
//
//        // We don't setup a credentions map here, because with LDAP, you can't
//        // obtain the user's passwords, you can only check/authenticate against
//        // the LDAP server.  Instead, check each time in the authorize method.
//        if (BlojsomUtils.checkNullOrBlank(_ldapServer)) {
//            String msg = "No LDAP authorization server specified.";
//            _logger.error(msg);
//            throw new BlojsomConfigurationException(msg);
//        }
//
//        if (BlojsomUtils.checkNullOrBlank(_ldapDN)) {
//            String msg = "No LDAP authorization DN specified.";
//            _logger.error(msg);
//            throw new BlojsomConfigurationException(msg);
//        }
//
//        if (!BlojsomUtils.checkNullOrBlank(port)) {
//            try {
//                _ldapPort = Integer.valueOf(port).intValue();
//                if ((0 > _ldapPort) || (_ldapPort > 65535)) {
//                    _logger.error("LDAP port is not in valid range [0,65535].");
//                    throw new NumberFormatException();
//                }
//            } catch (NumberFormatException nfe) {
//                String msg = "Invalid LDAP port '" + port + "' specified.";
//                _logger.error(msg);
//                throw new BlojsomConfigurationException(msg);
//            }
//        }
//
//        _bindingUser = servletConfig.getInitParameter(BLOG_LDAP_AUTHORIZATION_BINDING_USER_IP);
//        _bindingPassword = servletConfig.getInitParameter(BLOG_LDAP_AUTHORIZATION_BINDING_PASSWORD_IP);
//
//        _logger.debug("LDAP Authorization Provider server: " + _ldapServer);
//        _logger.debug("LDAP Authorization Provider port: " + _ldapPort);
//        _logger.debug("LDAP Authorization Provider DN: " + _ldapDN);
//        _logger.debug("LDAP Authorization Provider UID: " + _uidAttributeName);
//        _logger.debug("LDAP Authorization Provider binding user: " + _bindingUser);
//        _logger.debug("LDAP Authorization Provider binding password: **********");
//
//        _logger.debug("Initialized LDAP authorization provider");
//    }
//
//    /**
//     * Loads/configures the authentication credentials for a given blog.
//     *
//     * @param blogUser {@link BlogUser}
//     * @throws BlojsomException If there is an error loading the user's authentication credentials
//     */
//    public void loadAuthenticationCredentials(BlogUser blogUser) throws BlojsomException {
//        // Now load the list of acceptible LDAP user ID's from the
//        // authorization properties file, if available.
//        try {
//            super.loadAuthenticationCredentials(blogUser);
//        } catch (Exception be) {
//            // Do nothing, as we don't have to use the auth file if not there,
//            // or if bad, authorize will indicate error.
//        }
//    }
//
//    /**
//     * Authorize a username and password for the given {@link BlogUser}
//     *
//     * @param blogUser             {@link BlogUser}
//     * @param authorizationContext {@link Map} to be used to provide other information for authorization. This will
//     *                             change depending on the authorization provider. This parameter is not used in this implementation.
//     * @param username             Username.  In this implementation, this value must match that of the blog user's ID.
//     * @param password             Password
//     * @throws BlojsomException If there is an error authorizing the username and password
//     */
//    public void authorize(BlogUser blogUser, Map authorizationContext, String username, String password) throws BlojsomException {
//        String dn = getDN(username);
//        Map authorizationMap = blogUser.getBlog().getAuthorization();
//
//        if (BlojsomUtils.checkNullOrBlank(_ldapServer) || BlojsomUtils.checkNullOrBlank(dn)) {
//            String msg = "Authorization failed for blog user: " + blogUser.getId() + " for username: " + username + "; " + "LDAP not properly configured";
//            _logger.error(msg);
//            throw new BlojsomException(msg);
//        }
//
//        // See if we have a list of possible user's
//        if ((authorizationMap != null) && (authorizationMap.containsKey(username))) {
//            _logger.debug("Performing looking with username: " + username);
//        } else {
//            if ((authorizationMap != null) && (!authorizationMap.containsKey(username))) {
//                String msg = "Username '" + username + "' is not an authorized user of this blog.";
//                _logger.error(msg);
//                throw new BlojsomException(msg);
//            } else if (!blogUser.getId().equals(username)) {
//                // otherwise, only the blog owner is allowed to login
//                String msg = username + " is not the owner of this blog, and only the owner (" + blogUser.getId() + ") is authorized to use this blog.";
//                _logger.error(msg);
//                throw new BlojsomException(msg);
//            }
//        }
//
//        try {
//            LDAPConnection ldapConnection = new LDAPConnection();
//
//            // Connect to the directory server
//            ldapConnection.connect(_ldapServer, _ldapPort);
//
//            if (blogUser.getBlog().getUseEncryptedPasswords().booleanValue()) {
//                password = BlojsomUtils.digestString(password, blogUser.getBlog().getDigestAlgorithm());
//            }
//
//            // Use simple authentication. The first argument
//            // specifies the version of the LDAP protocol used.
//            ldapConnection.authenticate(3, dn, password);
//
//            ldapConnection.disconnect();
//            _logger.debug("Successfully authenticated user '" + username + "' via LDAP.");
//        } catch (LDAPException e) {
//            String reason;
//            switch (e.getLDAPResultCode()) {
//                // The DN does not correspond to any existing entry
//                case LDAPException.NO_SUCH_OBJECT:
//                    reason = "The specified user does not exist: " + dn;
//                    break;
//                    // The password is incorrect
//                case LDAPException.INVALID_CREDENTIALS:
//                    reason = "Invalid password";
//                    break;
//                    // Some other error occurred
//                default:
//                    reason = "Failed to authenticate as " + dn + ", " + e;
//                    break;
//            }
//
//            String msg = "Authorization failed for blog user: " + blogUser.getId() + " for username: " + username + "; " + reason;
//            _logger.error(msg);
//            throw new BlojsomException(msg);
//        }
//    }
//
//    /**
//     * Get the DN for a given username
//     *
//     * @param username Username
//     * @return DN for a given username or <code>null</code> if there is an exception in lookup
//     */
//    protected String getDN(String username) {
//        try {
//            LDAPConnection ldapConnection = new LDAPConnection();
//
//            // Connect to the directory server
//            ldapConnection.connect(_ldapServer, _ldapPort);
//
//            // Authenticate with the server
//            if (!BlojsomUtils.checkNullOrBlank(_bindingUser) && !BlojsomUtils.checkNullOrBlank(_bindingPassword)) {
//                _logger.debug("Using LDAP authentication for LDAP connection");
//                ldapConnection.authenticate(3, _bindingUser, _bindingPassword);
//            }
//
//            // Search for the dn of the user given the username (uid).
//            String[] attrs = {};
//            LDAPSearchResults res = ldapConnection.search(_ldapDN,
//                    LDAPv2.SCOPE_SUB, "(" + _uidAttributeName + "=" + username + ")", attrs, true);
//
//            if (!res.hasMoreElements()) {
//                // No such user.
//                _logger.debug("User '" + username + "' does not exist in LDAP directory.");
//                return null;
//            }
//
//            String dn = res.next().getDN();
//            ldapConnection.disconnect();
//            _logger.debug("Successfully got user DN '" + dn + "' via LDAP.");
//
//            return dn;
//        } catch (LDAPException e) {
//            // Some exception occurred above; the search for the dn failed.
//            return null;
//        }
//    }
//
//    /**
//     * Return the LDAP server name
//     *
//     * @return LDAP server name
//     */
//    protected String getServer() {
//        return _ldapServer;
//    }
//
//    /**
//     * Return the LDAP server port
//     *
//     * @return LDAP server port
//     */
//    protected int getPort() {
//        return _ldapPort;
//    }
//
//    /**
//     * Return the LDAP base DN
//     *
//     * @return LDAP base DN
//     */
//    protected String getBaseDN() {
//        return _ldapDN;
//    }
//



}
