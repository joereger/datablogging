package reger.nestednav;

import reger.UserSession;

/**
 * An interface for the definition of navbars.
 * This will be implemented with horizonal and vertical to start.
 * But eventually I can see a dHtml navbar and others.
 * The idea is that this presents the navigation of the site
 */
public interface NestedNavDisplay {

    public String outputNavBarHtml(NestedNavCollection nestedNavCollection, UserSession userSession, javax.servlet.http.HttpServletRequest request);

}
