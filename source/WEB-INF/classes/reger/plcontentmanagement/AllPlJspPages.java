package reger.plcontentmanagement;

import reger.nestednav.NestedNavItem;
import reger.nestednav.NestedNavCollection;
import reger.AddToArray;

import java.util.ArrayList;

/**
 * Builds a list of static jsp pages that appear in the plmarketing site
 */
public class AllPlJspPages {

    private static ArrayList<NestedNavItem> nestedNavItems;

    private static void load(){
        nestedNavItems = new ArrayList<NestedNavItem>();

       //NOTE: DO NOT EVER CHANGE THE PLJSPID HERE... YOU CAN DELETE LINES, BUT NEVER CHANGE... UNLESS YOU KNOW WHAT YOU'RE DOING

        //Top Level
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-1, "Home", "index.log", NestedNavItem.NESTEDNAVITEMBASE, 0, 1)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-2, "Sign Up - It's Free!", "signup.log", NestedNavItem.NESTEDNAVITEMBASE, 0, 2)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-46, "Tell a Friend!", "community-tellfriend.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -2, 1)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-3, "See Our Community", "community.log", NestedNavItem.NESTEDNAVITEMBASE, 0, 3)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-4, "Want to Learn More?", "moreinfo.log", NestedNavItem.NESTEDNAVITEMBASE, 0, 4)));





        //Community
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-40, "Datablog Sites", "community-sites.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -3, 1)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-41, "Log Entries", "community-entries.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -3, 2)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-42, "Entries by Log Type", "community-entries-logtypes.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -3, 3)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-53, "User Data Tags", "community-tags.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -3, 4)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-43, "Find a Datablog Site", "community-findsite.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -3, 5)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-44, "Complex Search", "community-search.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -3, 6)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-55, "Locate a User Group", "community-groups.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -3, 7)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-47, "Discussion Forum", "http://www.reger.com/jforum", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -3, 8)));







        //More Info
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-20, "Take A Tour", "tour.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 1)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-27, "Blogging Overview", "tour-overview-01.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 2)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-22, "What is datablogging?", "what-is-datablogging.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 3)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-21, "Our Features", "features.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 4)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-23, "Personal Use", "datablogging-people.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 5)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-24, "Business Use", "datablogging-business.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 6)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-26, "Enterprise Edition", "download.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 7)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-25, "Platform Versions", "versions.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 8)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-28, "About Us", "what-is-reger.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -4, 9)));


        //What is datablogging?
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-45, "Log Types", "community-logtypes.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 1)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-10, "Custom Data Graphs", "what-is-datablogging-graphs.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 2)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-11, "Advanced Queries", "what-is-datablogging-graphandsearch.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 3)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-12, "Custom Log Types", "what-is-datablogging-newfield.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 4)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-14, "RSS Support", "what-is-datablogging-rss.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 5)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-15, "RSS Embedding", "what-is-datablogging-rss-in-html.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 6)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-16, "Data Mining", "what-is-datablogging-search.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 7)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-17, "Data Porting", "what-is-datablogging-statement-on-data-portability.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 8)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-18, "XML Schema", "what-is-datablogging-xml-schema.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 9)));
            nestedNavItems.add((NestedNavItem)(new PlJspPage(-13, "Structured Blogging", "what-is-datablogging-preliminary-structured-blogging-support.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -22, 10)));



        //Business Use
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-30, "Overview", "biz-index.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -24, 1)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-31, "Industries", "biz-industries.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -24, 2)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-32, "Knowledge Mgt", "biz-knowledge-management.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -24, 3)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-33, "Rollout Process", "biz-knowledge-management-launching.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -24, 4)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-34, "ROI", "biz-knowledge-management-roi.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -24, 5)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-35, "Products", "biz-products.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -24, 6)));


        //About Us
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-60, "Our Team", "biz-management.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -28, 1)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-61, "Our Values", "biz-core-values.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -28, 2)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-63, "Our Mission", "biz-mission.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -28, 3)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-62, "Our Partners", "biz-partners.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -28, 4)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-64, "Our Technology", "biz-technology.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -28, 5)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-50, "Contact Us", "biz-contactus.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -28, 6)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-51, "Press", "biz-pr-overview.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -28, 7)));
        nestedNavItems.add((NestedNavItem)(new PlJspPage(-52, "Investors", "biz-investors.log", NestedNavItem.NESTEDNAVTYPEPLJSPPAGE, -28, 8)));



    }

    public static ArrayList<NestedNavItem> getNestedNavItems(){
        if (nestedNavItems==null){
            load();
        }
        return nestedNavItems;
    }


}
