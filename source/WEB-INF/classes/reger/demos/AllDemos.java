package reger.demos;

import reger.AddToArray;

import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

/**
 * Holds the names and descriptions of all demos
 */
public class AllDemos {

    private static DemoCategory[] allDemoCategories;

    public static void populateDemos(){
        allDemoCategories = new DemoCategory[0];
        synchronized(allDemoCategories){

            DemoCategory cat01 = new DemoCategory("Getting Started");
            cat01.addDemo(new Demo("Unique Elements of Reger.com", "uniqueelementsofregercom", "Reger.com has all of the standard blogging features.  But it also has a number of unique concepts.  Datablogging, episodes, time periods, group and social networking.  This demo gives a high level overview."));
            cat01.addDemo(new Demo("How to Sign Up/Get Started", "signup", "This demo shows you how to create an account and start blogging immediately."));
            cat01.addDemo(new Demo("How to Log In", "login", "There are three ways to log in once you have your account created."));
            cat01.addDemo(new Demo("Your First Blog Entry", "firstentry", "Creating your first blog entry."));
            allDemoCategories = AddToArray.addToDemoCategoryArray(allDemoCategories, cat01);

            DemoCategory cat02 = new DemoCategory("datablogging");
            cat02.addDemo(new Demo("What is datablogging?", "datablogging", "The basics of datablogging.  How to collect extended data via blog entries and what you can do with it once it's collected."));
            cat02.addDemo(new Demo("Log vs. Log Type", "logsvslogtypes", "There's a difference between a Log and a Log Type."));
            cat02.addDemo(new Demo("Creating a Custom Log Type", "createcustomlogtype", "Sometimes you can't find a log type that allows you to track what you want to track... so you create your own."));
            cat02.addDemo(new Demo("Add Custom Field to Log", "addcustomfieldtolog", "Adding a custom field to a log allows you to extend system logs to fit your own needs."));
            allDemoCategories = AddToArray.addToDemoCategoryArray(allDemoCategories, cat02);

            DemoCategory cat03 = new DemoCategory("General Usage");
            cat03.addDemo(new Demo("Add Images/Files to an Entry", "addfilestoentry", "Each blog entry can have many images/files attached to it.  This demo shows you how to upload them and organize them."));
            cat03.addDemo(new Demo("Making a Log Private", "makingalogprivate", "Logs can be defined as private, meaning that only you, or people you grant permission to, can see it."));
            cat03.addDemo(new Demo("Hidden/Visible on Homepage", "hiddenonhomepage", "Beat homepage clutter with this unique feature."));
            cat03.addDemo(new Demo("Admin Tool vs. Public Blog", "marketingvsadminvspublic", "In addition to your blog, there are two other sections of the site that you should be familiar with."));
            cat03.addDemo(new Demo("Time Periods", "timeperiods", "Time periods are a way to give context to your entries."));
            cat03.addDemo(new Demo("Reader Comments", "usercomments", "How to manage user comments, turn on comment moderation, turn off comments."));
            allDemoCategories = AddToArray.addToDemoCategoryArray(allDemoCategories, cat03);

        }

    }


    public static DemoCategory[] getAllDemoCategories(){
        if (allDemoCategories==null){
            populateDemos();
        }
        return allDemoCategories;
    }

    public static Demo getDemoByFilename(String filename){
        if (allDemoCategories==null){
            populateDemos();
        }
        if (allDemoCategories!=null){
            for (int j = 0; j < allDemoCategories.length; j++) {
                reger.demos.Demo[] demos = allDemoCategories[j].getDemos();
                if (demos!=null && demos.length>0){
                    for (int i = 0; i < demos.length; i++) {
                        if (demos[i].getDemoFilename().equals(filename)){
                            return demos[i];
                        }
                    }
                }
            }
        }
        return null;
    }








}
