package reger.plcontentmanagement;

import reger.nestednav.NestedNavItem;
import reger.Accountuser;
import reger.cache.providers.jboss.Cacheable;

import javax.servlet.http.HttpServletRequest;

/**
 * Represents a single jsp page in the content management scheme of the private label marketing site.
 */
@Cacheable
public class PlJspPage implements NestedNavItem {


    private int pljspid=0;
    private String name="";
    private String url="";
    private int nestednavparenttype=NestedNavItem.NESTEDNAVITEMBASE;
    private int nestednavparentid=0;
    private int nestednavorder=0;
    private int sizeinbytes = 0;

    public PlJspPage(int pljspid){
        this.pljspid = pljspid;
    }

    public PlJspPage(int pljspid, String name, String url, int nestednavparenttype, int nestednavparentid, int nestednavorder){
        this.pljspid=pljspid;
        this.name=name;
        this.url=url;
        this.nestednavparenttype=nestednavparenttype;
        this.nestednavparentid=nestednavparentid;
        this.nestednavorder=nestednavorder;
    }


    /**
     * The text that should appear in the navigation bar
     */
    public String getNestedNavLinkText() {
        return name;
    }

    /**
     * The url that this item should link to
     */
    public String getNestedNavLinkUrl() {
        return url;
    }

    /**
     * This type.  Either NestedNavItem.NESTEDNAVTYPEMEGALOG or NestedNavItem.NESTEDNAVTYPECONTENTPAGE
     */
    public int getThisNestedNavType() {
        return NESTEDNAVTYPEPLJSPPAGE;
    }

    /**
     * The database unique id of this item.  This is either the logid or the contentpageid
     */
    public int getThisNestedNavId() {
        return pljspid;
    }

    /**
     * The type of parent that this is under.  0 if under none.  Either NestedNavItem.NESTEDNAVTYPEMEGALOG or NestedNavItem.NESTEDNAVTYPECONTENTPAGE.
     */
    public int getNestedNavParentType() {
        return nestednavparenttype;
    }

    /**
     * The database unique id of the parent item. 0 if under none.  This is either the logid or the contentpageid
     */
    public int getNestedNavParentId() {
        return nestednavparentid;
    }

    /**
     * The numeric order of the item.  1 is first in the list.
     */
    public int getNestedNavOrder() {
        return nestednavorder;
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
     * Whether the accountuser provided can view this item
     */
    public boolean userCanAdministerNavItem(Accountuser accountUser) {
        return true;
    }

    /**
     * Whether or not this nav item should be considered on/active or not
     */
    public boolean isActive(HttpServletRequest request) {
        return false;
    }


}
