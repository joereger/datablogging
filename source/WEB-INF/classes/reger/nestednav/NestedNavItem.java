package reger.nestednav;

import reger.Accountuser;

/**
 * An item that wants to appear on the nested navigation scheme must fulfill this interface.
 */
public interface NestedNavItem {

    public static final int NESTEDNAVITEMBASE = 0;
    public static final int NESTEDNAVTYPEMEGALOG = 1;
    public static final int NESTEDNAVTYPECONTENTPAGE = 2;


    /**
     * The text that should appear in the navigation bar
     */
    public String getNestedNavLinkText();

    /**
     * The url that this item should link to
     */
    public String getNestedNavLinkUrl();

    /**
     * This type.  Either NestedNavItem.NESTEDNAVTYPEMEGALOG or NestedNavItem.NESTEDNAVTYPECONTENTPAGE
     */
    public int getThisNestedNavType();

    /**
     * The database unique id of this item.  This is either the logid or the contentpageid
     */
    public int getThisNestedNavId();

    /**
     * The type of parent that this is under.  0 if under none.  Either NestedNavItem.NESTEDNAVTYPEMEGALOG or NestedNavItem.NESTEDNAVTYPECONTENTPAGE.
     */
    public int getNestedNavParentType();

    /**
     * The database unique id of the parent item. 0 if under none.  This is either the logid or the contentpageid
     */
    public int getNestedNavParentId();

    /**
     * The numeric order of the item.  1 is first in the list.
     */
    public int getNestedNavOrder();

    /**
     * Move this item down one by changing its order property, increasing it one.  Keeping same parent.
     */
    public void moveNestedNavDown();

    /**
     * Move this item up one by changing its order property, decreasing it one. Keeping same parent.
     */
    public void moveNestedNavUp();

    /**
     * Move to a specified spot on the nav scheme
     */
    public void moveNestedNavTo(int parentType, int parentId, int order);

    /**
     * Whether the accountuser provided can view this item
     */
    public boolean userCanViewNavItem(Accountuser accountUser);

    /**
     * Whether the accountuser provided can view this item
     */
    public boolean userCanAdministerNavItem(Accountuser accountUser);

    /**
     * Whether or not this nav item should be considered on/active or not
     */
    public boolean isActive(javax.servlet.http.HttpServletRequest request);

}
