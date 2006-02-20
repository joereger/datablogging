package reger.nestednav;

import reger.Accountuser;
import reger.cache.providers.jboss.Cacheable;

import javax.servlet.http.HttpServletRequest;

/**
 * This base class is used to start off navbars.
 */
@Cacheable
public class NestedNavItemBase implements NestedNavItem{

    /**
     * The text that should appear in the navigation bar
     */
    public String getNestedNavLinkText() {
        return "";
    }

    /**
     * The url that this item should link to
     */
    public String getNestedNavLinkUrl() {
        return "";
    }

    /**
     * This type.  Either NestedNavItem.NESTEDNAVTYPEMEGALOG or NestedNavItem.NESTEDNAVTYPECONTENTPAGE
     */
    public int getThisNestedNavType() {
        return NestedNavItem.NESTEDNAVITEMBASE;
    }

    /**
     * The database unique id of this item.  This is either the logid or the contentpageid
     */
    public int getThisNestedNavId() {
        return 0;
    }

    /**
     * The type of parent that this is under.  0 if under none.  Either NestedNavItem.NESTEDNAVTYPEMEGALOG or NestedNavItem.NESTEDNAVTYPECONTENTPAGE.
     */
    public int getNestedNavParentType() {
        return 0;
    }

    /**
     * The database unique id of the parent item. 0 if under none.  This is either the logid or the contentpageid
     */
    public int getNestedNavParentId() {
        return 0;
    }

    /**
     * The numeric order of the item.  1 is first in the list.
     */
    public int getNestedNavOrder() {
        return 0;
    }

    /**
     * Move this item down one by changing its order property, increasing it one.  Keeping same parent.
     */
    public void moveNestedNavDown() {

    }

    /**
     * Move this item up one by changing its order property, decreasing it one. Keeping same parent.
     */
    public void moveNestedNavUp() {

    }

    /**
     * Move to a specified spot on the nav scheme
     */
    public void moveNestedNavTo(int parentType, int parentId, int order) {

    }

    /**
     * Whether the accountuser provided can view this item
     */
    public boolean userCanViewNavItem(Accountuser accountUser) {
        return true;
    }

    /**
     * Whether or not this nav item should be considered on/active or not
     */
    public boolean isActive(HttpServletRequest request) {
        return false;
    }

    /**
     * Whether the accountuser provided can view this item
     */
    public boolean userCanAdministerNavItem(Accountuser accountUser) {
        return true;  
    }

}
