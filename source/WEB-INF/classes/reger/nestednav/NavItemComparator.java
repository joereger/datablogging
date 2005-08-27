package reger.nestednav;

import reger.Log;

import java.util.Comparator;

/**
 * Compares link text of NestedNavItems.
 */
public class NavItemComparator implements Comparator{

    public int compare( Object item1, Object item2 )    {
        NestedNavItem item1in = (NestedNavItem) item1;
        NestedNavItem item2in = (NestedNavItem) item2;
        int out = item1in.getNestedNavLinkText().compareTo(item2in.getNestedNavLinkText());
        return out;
    }

}
