package reger.nestednav;

import reger.Log;
import reger.ContentPage;
import reger.plcontentmanagement.PlContentPage;
import reger.plcontentmanagement.PlJspPage;

/**
 * Creates an item based on type
 */
public class NestedNavItemFactory {

    public static NestedNavItem getItem(int nestednavtype, int nestednavid){
        if (nestednavtype==NestedNavItem.NESTEDNAVTYPEMEGALOG){
            return (NestedNavItem)new Log(nestednavid);
        } else if (nestednavtype==NestedNavItem.NESTEDNAVTYPECONTENTPAGE){
            return (NestedNavItem)new ContentPage(nestednavid);
        } else if (nestednavtype==NestedNavItem.NESTEDNAVTYPEPLCONTENTPAGE){
            return (NestedNavItem)new PlContentPage(nestednavid);
        } else if (nestednavtype==NestedNavItem.NESTEDNAVTYPEPLJSPPAGE){
            return (NestedNavItem)new PlJspPage(nestednavid);
        } else if (nestednavtype==NestedNavItem.NESTEDNAVITEMBASE){
            return new NestedNavItemBase();
        }
        return null;
    }



}
