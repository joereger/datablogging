package reger.plcontentmanagement;

import reger.nestednav.NestedNavItem;
import reger.nestednav.NestedNavCollection;
import reger.AddToArray;
import reger.core.Debug;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;

/**
 * Builds a list of static jsp pages that appear in the plmarketing site
 */
public class AllPlJspPages {

    private static ArrayList<NestedNavItem> nestedNavItems;
    private static int timesloaded = 0;

    private static void load(){
        Debug.debug(1, "AllPlJspPages", "load() called.  timesloaded="+timesloaded);
        nestedNavItems = new ArrayList<NestedNavItem>();
        synchronized(nestedNavItems){
            if (timesloaded==0){
                timesloaded = timesloaded+1;
                nestedNavItems = new ArrayList<NestedNavItem>();

               //NOTE: DO NOT EVER CHANGE THE PLPID HERE... YOU CAN DELETE LINES, BUT NEVER CHANGE... UNLESS YOU KNOW WHAT YOU'RE DOING

                //Top Level
                add(new PlJspPage(-1, "Home", "index.log", NestedNavItem.NESTEDNAVITEMBASE, 0, 1));
                add(new PlJspPage(-2, "Sign Up", "signup.log", NestedNavItem.NESTEDNAVITEMBASE, 0, 2));
                add(new PlJspPage(-46, "Tell a Friend!", "community-tellfriend.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -2, 1));
                add(new PlJspPage(-3, "See Our Community", "community.log", NestedNavItem.NESTEDNAVITEMBASE, 0, 3));
                add(new PlJspPage(-4, "Want to Learn More?", "moreinfo.log", NestedNavItem.NESTEDNAVITEMBASE, 0, 4));


                //Community
                add(new PlJspPage(-40, "Datablog Sites", "community-sites.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -3, 1));
                add(new PlJspPage(-41, "Log Entries", "community-entries.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -3, 2));
                add(new PlJspPage(-42, "Entries by Log Type", "community-entries-logtypes.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -3, 3));
                add(new PlJspPage(-53, "User Data Tags", "community-tags.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -3, 4));
                add(new PlJspPage(-43, "Find a Datablog Site", "community-findsite.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -3, 5));
                add(new PlJspPage(-44, "Complex Search", "community-search.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -3, 6));
                add(new PlJspPage(-55, "Locate a User Group", "community-groups.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -3, 7));
                add(new PlJspPage(-47, "Discussion Forum", "http://www.reger.com/jforum", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -3, 8));







                //More Info
                add(new PlJspPage(-20, "Take A Tour", "tour.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 1));
                add(new PlJspPage(-27, "Blogging Overview", "tour-overview-01.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 2));
                add(new PlJspPage(-22, "What is datablogging?", "what-is-datablogging.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 3));
                add(new PlJspPage(-21, "Our Features", "features.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 4));
                add(new PlJspPage(-23, "Personal Use", "datablogging-people.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 5));
                add(new PlJspPage(-24, "Business Use", "datablogging-business.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 6));
                add(new PlJspPage(-26, "Enterprise Edition", "download.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 7));
                add(new PlJspPage(-25, "Platform Versions", "versions.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 8));
                add(new PlJspPage(-28, "About Us", "what-is-reger.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 9));


                //What is datablogging?
                add(new PlJspPage(-45, "Log Types", "community-logtypes.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 1));
                add(new PlJspPage(-10, "Custom Data Graphs", "what-is-datablogging-graphs.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 2));
                add(new PlJspPage(-11, "Advanced Queries", "what-is-datablogging-graphandsearch.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 3));
                add(new PlJspPage(-12, "Custom Log Types", "what-is-datablogging-newfield.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 4));
                add(new PlJspPage(-14, "RSS Support", "what-is-datablogging-rss.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 5));
                add(new PlJspPage(-15, "RSS Embedding", "what-is-datablogging-rss-in-html.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 6));
                add(new PlJspPage(-16, "Data Mining", "what-is-datablogging-search.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 7));
                add(new PlJspPage(-17, "Data Porting", "what-is-datablogging-statement-on-data-portability.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 8));
                add(new PlJspPage(-18, "XML Schema", "what-is-datablogging-xml-schema.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 9));
                    add(new PlJspPage(-13, "Structured Blogging", "what-is-datablogging-preliminary-structured-blogging-support.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 10));



                //Business Use
                add(new PlJspPage(-30, "Overview", "biz-index.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -24, 1));
                add(new PlJspPage(-31, "Industries", "biz-industries.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -24, 2));
                add(new PlJspPage(-32, "Knowledge Mgt", "biz-knowledge-management.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -24, 3));
                add(new PlJspPage(-33, "Rollout Process", "biz-knowledge-management-launching.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -24, 4));
                add(new PlJspPage(-34, "ROI", "biz-knowledge-management-roi.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -24, 5));
                add(new PlJspPage(-35, "Products", "biz-products.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -24, 6));


                //About Us
                add(new PlJspPage(-60, "Our Team", "biz-management.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -28, 1));
                add(new PlJspPage(-61, "Our Values", "biz-core-values.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -28, 2));
                add(new PlJspPage(-63, "Our Mission", "biz-mission.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -28, 3));
                add(new PlJspPage(-62, "Our Partners", "biz-partners.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -28, 4));
                add(new PlJspPage(-64, "Our Technology", "biz-technology.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -28, 5));
                add(new PlJspPage(-50, "Contact Us", "biz-contactus.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -28, 6));
                add(new PlJspPage(-51, "Press", "biz-pr-overview.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -28, 7));
                add(new PlJspPage(-52, "Investors", "biz-investors.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -28, 8));
            }
        }

    }

    private static void add(PlJspPage plJspPage){
        if (plJspPage!=null){
            if (nestedNavItems!=null){
                boolean alreadyInCollection = false;
                for (Iterator<NestedNavItem> iterator = nestedNavItems.iterator(); iterator.hasNext();) {
                    NestedNavItem nestedNavItem = iterator.next();
                    PlJspPage p = (PlJspPage)nestedNavItem;
                    if (p.getThisNestedNavId()==plJspPage.getThisNestedNavId()){
                        alreadyInCollection = true;   
                    }
                }
                if (!alreadyInCollection){
                    nestedNavItems.add((NestedNavItem)plJspPage);
                }
            }
        }
    }

    public static ArrayList<NestedNavItem> getNestedNavItems(){
        if (nestedNavItems==null && timesloaded==0){
            load();
        }
        if (nestedNavItems==null){
            Debug.debug(1, "AllPlJspPages", "getNestedNavItems() returned null which likely means that a) it was called multiple times on startup or b) java dropped the memory space and it now can't re-load because of the timesloaded=0 thing.");     
        }
        return nestedNavItems;
    }


}
