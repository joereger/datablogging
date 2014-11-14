package reger.nestednav;

import reger.Accountuser;
import reger.UserSession;
import reger.cache.providers.jboss.Cacheable;
import reger.core.Debug;

import java.util.*;

/**
 * This class starts with a collection of navItems and gives utility functions for dealing with them
 */
@Cacheable
public class NestedNavCollection  {

    private ArrayList<NestedNavItem> allNestedNavItems;

    public NestedNavCollection(ArrayList<NestedNavItem> allNestedNavItems){
        this.allNestedNavItems = orderNavItems(allNestedNavItems);
        Debug.debug(5, "NestedNavCollection", "NestedNavCollection.getChildrenUserCanView() - this.allNestedNavItems.length=" + this.allNestedNavItems.size());
    }

    public NestedNavItem getNestedNavItemById(int id){
        for (Iterator it = allNestedNavItems.iterator(); it.hasNext(); ) {
            NestedNavItem navItem = (NestedNavItem)it.next();
            if (navItem.getThisNestedNavId()==id){
                return navItem;   
            }
        }
        return null;
    }

    public static ArrayList<NestedNavItem> getNavItemsUserCanView(ArrayList<NestedNavItem> inNestedNavItems, Accountuser accountuser){
        ArrayList<NestedNavItem> outItems = new ArrayList<NestedNavItem>();
        //Find those that the user can view
        for (Iterator it = inNestedNavItems.iterator(); it.hasNext(); ) {
            NestedNavItem navItem = (NestedNavItem)it.next();
            //Check permission
            if (navItem!=null && navItem.userCanViewNavItem(accountuser)){
                outItems.add(navItem);
            }
        }
        return outItems;
    }

    public ArrayList<NestedNavItem> getAllChildrenApplyNoPermissions(NestedNavItem parent){
        return getAllChildrenApplyNoPermissions(allNestedNavItems, parent);
    }

    public ArrayList<NestedNavItem> getChildrenUserCanView(NestedNavItem parent, Accountuser accountuser){
        ArrayList<NestedNavItem> itemsUserCanView = getNavItemsUserCanView(allNestedNavItems, accountuser);
        return getAllChildrenApplyNoPermissions(itemsUserCanView, parent);
    }

    public static ArrayList<NestedNavItem> getAllChildrenApplyNoPermissions(ArrayList<NestedNavItem> inItems, NestedNavItem parent){
        ArrayList<NestedNavItem> children = new ArrayList<NestedNavItem>();
        if (inItems!=null && parent!=null){
            for (Iterator it = inItems.iterator(); it.hasNext(); ) {
                NestedNavItem navItem = (NestedNavItem)it.next();
                if (navItem.getNestedNavParentType()==parent.getThisNestedNavType()){
                    if (navItem.getNestedNavParentId()==parent.getThisNestedNavId()){
                        children.add(navItem);
                    }
                }
            }
        }
        return children;
    }

    private static NestedNavItem getNavItem(int nestednavtype, int nestednavid, ArrayList<NestedNavItem> inItems){
        if (nestednavtype==NestedNavItem.NESTEDNAVITEMBASE && nestednavid==0){
            return new NestedNavItemBase();
        }
        if (inItems!=null){
            for (Iterator it = inItems.iterator(); it.hasNext(); ) {
                NestedNavItem navItem = (NestedNavItem)it.next();
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
    private static ArrayList<NestedNavItem> orderNavItems(ArrayList<NestedNavItem> inNavItems){
        ArrayList<NestedNavItem> orderedNavItems = new ArrayList<NestedNavItem>();
        //Iterate from minOrder to maxOrder
        int minOrder = getMinOrder(inNavItems);
        int maxOrder = getMaxOrder(inNavItems);
        for(int currentOrder=minOrder; currentOrder<=maxOrder; currentOrder++){
            //Iterate all items
            List itemList = new ArrayList();
            for (Iterator it = inNavItems.iterator(); it.hasNext(); ) {
                NestedNavItem navItem = (NestedNavItem)it.next();
                //Put all items with this currentOrder into a treemap
                if (navItem.getNestedNavOrder()==currentOrder){
                    itemList.add(navItem);
                }
            }
            //Alphabetize using the NavItemComparator
            Debug.debug(5, "", "NestedNavCollection.java - About to sort itemList.");
            Collections.sort(itemList, new NavItemComparator());
            //And add the alphabetized items to the orderedNavItems array
            for (Iterator iterator = itemList.iterator(); iterator.hasNext();) {
                NestedNavItem navItem = (NestedNavItem) iterator.next();
                orderedNavItems.add(navItem);
            }
        }

        return orderedNavItems;
    }

    public static int getMaxOrder(ArrayList<NestedNavItem> inNavItems){
        int outOrder = 0;
        if (inNavItems!=null){
            for (Iterator it = inNavItems.iterator(); it.hasNext(); ) {
                NestedNavItem navItem = (NestedNavItem)it.next();

                if (navItem.getNestedNavOrder()>outOrder){
                    outOrder = navItem.getNestedNavOrder();
                }
            }
        }
        return outOrder;
    }

    public static int getMinOrder(ArrayList<NestedNavItem> inNavItems){
        int outOrder = Integer.MAX_VALUE;
        if (inNavItems!=null){
            for (Iterator it = inNavItems.iterator(); it.hasNext(); ) {
                NestedNavItem navItem = (NestedNavItem)it.next();
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
            for (Iterator it = allNestedNavItems.iterator(); it.hasNext(); ) {
                NestedNavItem navItem = (NestedNavItem)it.next();
                navItem.moveNestedNavTo(0,0,0);
            }
            //Order the collection
            this.allNestedNavItems = orderNavItems(this.allNestedNavItems);
            //Set the order accordingly
            int i = 0;
            for (Iterator it = allNestedNavItems.iterator(); it.hasNext(); ) {
                NestedNavItem navItem = (NestedNavItem)it.next();
                navItem.moveNestedNavTo(0,0, i+1);
                i++;
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
        ArrayList<NestedNavItem> oldChildren = NestedNavCollection.getAllChildrenApplyNoPermissions(allNestedNavItems, oldParentOfNavItemBeingMoved);
        //Find any peers that have an order equal to or higher than the newOrder... the spot the navItemBeingMoved will occupy
        for (Iterator it = oldChildren.iterator(); it.hasNext(); ) {
            NestedNavItem childNavItem = (NestedNavItem)it.next();
            if (childNavItem.getNestedNavOrder()>navItemBeingMoved.getNestedNavOrder()){
                childNavItem.moveNestedNavUp();
            }
        }

        //-----------------------------------------------------------
        //Make room for the navItem in its new location, shifting down when necessary
        //Get the new parent of the item being moved
        NestedNavItem newParentOfNavItemBeingMoved = getNavItem(newParentType, newParentId, allNestedNavItems);
        //Get the children of the parent... these will be the peers of the navItemBeingMoved... once it's moved, of course
        ArrayList<NestedNavItem> newChildren = NestedNavCollection.getAllChildrenApplyNoPermissions(allNestedNavItems, newParentOfNavItemBeingMoved);
        //Find any peers that have an order equal to or higher than the newOrder... the spot the navItemBeingMoved will occupy
        for (Iterator it = newChildren.iterator(); it.hasNext(); ) {
            NestedNavItem childNavItem = (NestedNavItem)it.next();
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
            ArrayList<NestedNavItem> oldChildren = NestedNavCollection.getAllChildrenApplyNoPermissions(allNestedNavItems, oldParentOfNavItemBeingMoved);
            //Find any peers that have an order equal to or higher than the newOrder... the spot the navItemBeingMoved will occupy
            for (Iterator it = oldChildren.iterator(); it.hasNext(); ) {
                NestedNavItem childNavItem = (NestedNavItem)it.next();
                if (childNavItem.getNestedNavOrder()>navItemBeingMoved.getNestedNavOrder()){
                    childNavItem.moveNestedNavUp();
                }
            }
        }
    }

    public static boolean isAnyChildActive(NestedNavItem parent, NestedNavCollection collection, UserSession userSession, javax.servlet.http.HttpServletRequest request){
        Debug.debug(5, "", "NestedNavCollection.java isAnyChildActive() called<br>parent=" + parent.getNestedNavLinkText());
        if (collection!=null){
            ArrayList<NestedNavItem> inItems = collection.getAllNestedNavItems();
            if (inItems!=null){
                ArrayList<NestedNavItem> children = NestedNavCollection.getAllChildrenApplyNoPermissions(inItems, parent);
                for (Iterator it = children.iterator(); it.hasNext(); ) {
                    NestedNavItem navItem = (NestedNavItem)it.next();
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

    private ArrayList<NestedNavItem> getAllNestedNavItems() {
        return allNestedNavItems;
    }



}