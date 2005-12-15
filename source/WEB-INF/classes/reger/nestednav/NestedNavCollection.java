package reger.nestednav;

import reger.Accountuser;
import reger.UserSession;
import reger.AddToArray;
import reger.core.Debug;

import java.util.*;

/**
 * This class starts with a collection of navItems and gives utility functions for dealing with them
 */
public class NestedNavCollection implements java.io.Serializable {

    private NestedNavItem[] allNestedNavItems;


    public NestedNavCollection(NestedNavItem[] allNestedNavItems){
        this.allNestedNavItems = orderNavItems(allNestedNavItems);
        Debug.debug(5, "", "NestedNavCollection.getChildrenUserCanView() - this.allNestedNavItems.length=" + this.allNestedNavItems.length);
    }

    public static NestedNavItem[] getNavItemsUserCanView(NestedNavItem[] inNestedNavItems, Accountuser accountuser){
        NestedNavItem[] outItems = new NestedNavItem[0];
        //Find those that the user can view
        for (int i = 0; i < inNestedNavItems.length; i++) {
            NestedNavItem navItem = inNestedNavItems[i];
            //Check permission
            if (navItem.userCanViewNavItem(accountuser)){
                outItems = AddToArray.addToNestedNavItemArray(outItems, navItem);
            }
        }
        return outItems;
    }

    public NestedNavItem[] getAllChildrenApplyNoPermissions(NestedNavItem parent){
        return getAllChildrenApplyNoPermissions(allNestedNavItems, parent);
    }

    public NestedNavItem[] getChildrenUserCanView(NestedNavItem parent, Accountuser accountuser){
        NestedNavItem[] itemsUserCanView = getNavItemsUserCanView(allNestedNavItems, accountuser);
        //reger.core.Util.logtodb("NestedNavCollection.getChildrenUserCanView() - allNestedNavItems.length=" + allNestedNavItems.length);
        //reger.core.Util.logtodb("NestedNavCollection.getChildrenUserCanView() - itemsUserCanView.length=" + itemsUserCanView.length);
        return getAllChildrenApplyNoPermissions(itemsUserCanView, parent);
    }

    public static NestedNavItem[] getAllChildrenApplyNoPermissions(NestedNavItem[] inItems, NestedNavItem parent){
        NestedNavItem[] children = new NestedNavItem[0];
        if (inItems!=null && parent!=null){
            for (int i = 0; i < inItems.length; i++) {
                NestedNavItem navItem = inItems[i];
                if (navItem.getNestedNavParentType()==parent.getThisNestedNavType()){
                    if (navItem.getNestedNavParentId()==parent.getThisNestedNavId()){
                        children = AddToArray.addToNestedNavItemArray(children, navItem);
                    }
                }
            }
        }
        return children;
    }

    public static NestedNavItem getNavItem(int nestednavtype, int nestednavid, NestedNavItem[] inItems){
        if (nestednavtype==NestedNavItem.NESTEDNAVITEMBASE && nestednavid==0){
            return new NestedNavItemBase();
        }
        if (inItems!=null){
            for (int i = 0; i < inItems.length; i++) {
                NestedNavItem navItem = inItems[i];
                if (navItem.getThisNestedNavType()==nestednavtype){
                    if (navItem.getThisNestedNavId()==nestednavid){
                        return navItem;
                    }
                }
            }
        }
        return null;
    }



    /**
     * Ordering is done first by nestednavorder and second alphabetically.
     */
    public static NestedNavItem[] orderNavItems(NestedNavItem[] inNavItems){
        NestedNavItem[] orderedNavItems = new NestedNavItem[0];

        //Iterate from minOrder to maxOrder
        int minOrder = getMinOrder(inNavItems);
        int maxOrder = getMaxOrder(inNavItems);
        for(int currentOrder=minOrder; currentOrder<=maxOrder; currentOrder++){
            //Iterate all items
            List itemList = new ArrayList();
            for (int i = 0; i < inNavItems.length; i++) {
                //Put all items with this currentOrder into a treemap
                if (inNavItems[i].getNestedNavOrder()==currentOrder){
                    itemList.add(inNavItems[i]);
                }
            }
            //Alphabetize using the NavItemComparator
            Debug.debug(5, "", "NestedNavCollection.java - About to sort itemList.");
            Collections.sort(itemList, new NavItemComparator());
            //And add the alphabetized items to the orderedNavItems array
            for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
                NestedNavItem navItem = (NestedNavItem) iterator.next();
                orderedNavItems = AddToArray.addToNestedNavItemArray(orderedNavItems, navItem);
            }
        }

        return orderedNavItems;
    }

    public static int getMaxOrder(NestedNavItem[] inNavItems){
        int outOrder = 0;
        if (inNavItems!=null){
            for (int i = 0; i < inNavItems.length; i++) {
                NestedNavItem navItem = inNavItems[i];
                if (navItem.getNestedNavOrder()>outOrder){
                    outOrder = navItem.getNestedNavOrder();
                }
            }
        }
        return outOrder;
    }

    public static int getMinOrder(NestedNavItem[] inNavItems){
        int outOrder = Integer.MAX_VALUE;
        if (inNavItems!=null){
            for (int i = 0; i < inNavItems.length; i++) {
                NestedNavItem navItem = inNavItems[i];
                if (navItem.getNestedNavOrder()<outOrder){
                    outOrder = navItem.getNestedNavOrder();
                }
            }
        }
        return outOrder;
    }

    /**
     * Alphabetizes and then resets the entire layout.
     */
    public void resetEntireLayout(){
        if (allNestedNavItems!=null){
            //Flatten the collection
            for (int i = 0; i < allNestedNavItems.length; i++) {
                allNestedNavItems[i].moveNestedNavTo(0,0,0);
            }
            //Order the collection
            this.allNestedNavItems = orderNavItems(this.allNestedNavItems);
            //Set the order accordingly
            for (int i = 0; i < allNestedNavItems.length; i++) {
                allNestedNavItems[i].moveNestedNavTo(0,0, i+1);
            }
        }
    }

    /**
     * Moves an item in the collection
     */
    public void moveItem(int nestednavtype, int nestednavid, int newParentType, int newParentId, int newOrder){

        //-----------------------------------------------------------
        //Get the item being moved
        NestedNavItem navItemBeingMoved = getNavItem(nestednavtype, nestednavid, allNestedNavItems);

        //-----------------------------------------------------------
        //Remove the current navItem, shifting up when necessary
        //Get the old parent of the item being moved
        NestedNavItem oldParentOfNavItemBeingMoved = getNavItem(navItemBeingMoved.getNestedNavParentType(), navItemBeingMoved.getNestedNavParentId(), allNestedNavItems);
        //Get the children of the parent... these are the old peers
        NestedNavItem[] oldChildren = NestedNavCollection.getAllChildrenApplyNoPermissions(allNestedNavItems, oldParentOfNavItemBeingMoved);
        //Find any peers that have an order equal to or higher than the newOrder... the spot the navItemBeingMoved will occupy
        for (int i = 0; i < oldChildren.length; i++) {
            NestedNavItem childNavItem = oldChildren[i];
            if (childNavItem.getNestedNavOrder()>navItemBeingMoved.getNestedNavOrder()){
                childNavItem.moveNestedNavUp();
            }
        }

        //-----------------------------------------------------------
        //Make room for the navItem in its new location, shifting down when necessary
        //Get the new parent of the item being moved
        NestedNavItem newParentOfNavItemBeingMoved = getNavItem(newParentType, newParentId, allNestedNavItems);
        //Get the children of the parent... these will be the peers of the navItemBeingMoved... once it's moved, of course
        NestedNavItem[] newChildren = NestedNavCollection.getAllChildrenApplyNoPermissions(allNestedNavItems, newParentOfNavItemBeingMoved);
        //Find any peers that have an order equal to or higher than the newOrder... the spot the navItemBeingMoved will occupy
        for (int i = 0; i < newChildren.length; i++) {
            NestedNavItem childNavItem = newChildren[i];
            if (childNavItem.getNestedNavOrder()>=newOrder){
                childNavItem.moveNestedNavDown();
            }
        }

        //-----------------------------------------------------------
        //Move the navItem itself into its slot
        navItemBeingMoved.moveNestedNavTo(newParentType, newParentId, newOrder);

    }

    public void adjustAfterRemovalOfItem(int removedNestedNavType, int removedNestedNavId){
        //-----------------------------------------------------------
        //Get the item being moved
        NestedNavItem navItemBeingMoved = getNavItem(removedNestedNavType, removedNestedNavId, allNestedNavItems);
        //-----------------------------------------------------------
        if (navItemBeingMoved!=null){
            //Remove the current navItem, shifting up when necessary
            //Get the old parent of the item being moved
            NestedNavItem oldParentOfNavItemBeingMoved = getNavItem(navItemBeingMoved.getNestedNavParentType(), navItemBeingMoved.getNestedNavParentId(), allNestedNavItems);
            //Get the children of the parent... these are the old peers
            NestedNavItem[] oldChildren = NestedNavCollection.getAllChildrenApplyNoPermissions(allNestedNavItems, oldParentOfNavItemBeingMoved);
            //Find any peers that have an order equal to or higher than the newOrder... the spot the navItemBeingMoved will occupy
            for (int i = 0; i < oldChildren.length; i++) {
                NestedNavItem childNavItem = oldChildren[i];
                if (childNavItem.getNestedNavOrder()>navItemBeingMoved.getNestedNavOrder()){
                    childNavItem.moveNestedNavUp();
                }
            }
        }
    }

    public static boolean isAnyChildActive(NestedNavItem parent, NestedNavCollection collection, UserSession userSession, javax.servlet.http.HttpServletRequest request){
        Debug.debug(5, "", "NestedNavCollection.java isAnyChildActive() called<br>parent=" + parent.getNestedNavLinkText());
        if (collection!=null){
            NestedNavItem[] inItems = collection.getAllNestedNavItems();
            if (inItems!=null){
                NestedNavItem[] children = NestedNavCollection.getAllChildrenApplyNoPermissions(inItems, parent);
                for (int i = 0; i < children.length; i++) {
                    NestedNavItem navItem = children[i];
                    if (navItem.userCanViewNavItem(userSession.getAccountuser())){
                        //If this one's active.
                        if (navItem.isActive(request)){
                            Debug.debug(5, "", "NestedNavCollection.java isAnyChildActive() returning true.<br>parent="+parent.getNestedNavLinkText());
                            return true;
                        }
                        //If a child is active.  Recurse.
                        if (isAnyChildActive(navItem, collection, userSession, request)){
                            Debug.debug(5, "", "NestedNavCollection.java isAnyChildActive() returning true.<br>parent="+parent.getNestedNavLinkText());
                            return true;
                        }
                    }
                }
            }
        }
        Debug.debug(5, "", "NestedNavCollection.java isAnyChildActive() returning false.<br>parent="+parent.getNestedNavLinkText());
        return false;
    }

    public NestedNavItem[] getAllNestedNavItems() {
        return allNestedNavItems;
    }



}