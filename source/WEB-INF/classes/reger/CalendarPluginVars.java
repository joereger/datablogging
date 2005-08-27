package reger;

/**
 * Holds values to be used to configure a CalendarDayPlugin
 */
public class CalendarPluginVars {
    //Static vars -----------------

    //Static types of calendars
    public static int calTypeEntriesOnDate = 0;
    public static int calTypeFieldMath = 1;
    public static int calTypeFieldEquals = 2;

    //Static math operations
    public static int mathOperationSum = 0;
    public static int mathOperationAvg = 1;
    public static int mathOperationMax = 2;
    public static int mathOperationMin = 3;

    //Static comparators
    public static int lessThan = 0;
    public static int greaterThan = 1;

    //Instance vars ---------------

    //This particular calendar
    public int calType = 0;

    //Vars for calType = 0
    public int numberOfEntries = 0;

    //Vars for calType = 1
    public int mathOperation = 0;
    public int mathopmegafieldid = 0;
    public int comparator = 0;
    public int mathopvalue = 0;

    //Vars for calType = 2
    public int fieldequalsmegafieldid = 0;
    public String fieldequals = "";

    /**
     * Constructor to populate the vars from an http request
     * @param request
     */
    public CalendarPluginVars(javax.servlet.http.HttpServletRequest request){
        if (request.getParameter("calType")!=null && reger.core.Util.isinteger(request.getParameter("calType"))){
            calType = Integer.parseInt(request.getParameter("calType"));
        }

        if (request.getParameter("numberOfEntries")!=null && reger.core.Util.isinteger(request.getParameter("numberOfEntries"))){
            numberOfEntries = Integer.parseInt(request.getParameter("numberOfEntries"));
        }

        if (request.getParameter("mathOperation")!=null && reger.core.Util.isinteger(request.getParameter("mathOperation"))){
            mathOperation = Integer.parseInt(request.getParameter("mathOperation"));
        }

        if (request.getParameter("mathopmegafieldid")!=null && reger.core.Util.isinteger(request.getParameter("mathopmegafieldid"))){
            mathopmegafieldid = Integer.parseInt(request.getParameter("mathopmegafieldid"));
        }

        if (request.getParameter("comparator")!=null && reger.core.Util.isinteger(request.getParameter("comparator"))){
            comparator = Integer.parseInt(request.getParameter("comparator"));
        }

        if (request.getParameter("mathopvalue")!=null && reger.core.Util.isinteger(request.getParameter("mathopvalue"))){
            mathopvalue = Integer.parseInt(request.getParameter("mathopvalue"));
        }

        if (request.getParameter("fieldequalsmegafieldid")!=null && reger.core.Util.isinteger(request.getParameter("fieldequalsmegafieldid"))){
            fieldequalsmegafieldid = Integer.parseInt(request.getParameter("fieldequalsmegafieldid"));
        }

        if (request.getParameter("fieldequals")!=null && !request.getParameter("fieldequals").equals("")){
            fieldequals = request.getParameter("fieldequals");
        }
    }

}
