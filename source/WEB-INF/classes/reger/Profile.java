package reger;

import reger.core.db.Db;

/**
 * A user profile
 */
public class Profile {

    /**
     *
     * @param accountuser -  The profile of the user who is being displayed
     */
    public static StringBuffer getHtmlProfile(reger.Accountuser accountuser, reger.UserSession userSession, boolean iseditable, String pathToAppRoot){
        StringBuffer mb = new StringBuffer();
        mb.append(reger.core.Util.popup());

        //Form start
        if (iseditable && userSession.getAccountuser().getAccountuserid()==accountuser.getAccountuserid()){
            mb.append("<form action=settings-profile.log method=post>");
            mb.append("<input type=hidden name=action value=edit>");
            mb.append("<input type=hidden name=iseditable value="+iseditable+">");
        }

        mb.append("<table cellpadding=0 cellspacing=10 width=100% bgcolor=#ffffff border=0>");


        mb.append("<tr>");
        mb.append("<td valign=top colspan=2 bgcolor=#ffffff>");
        mb.append("<font face=arial size=+2 color=#666666>");
        if (iseditable && userSession.getAccountuser().getAccountuserid()==accountuser.getAccountuserid()){
            mb.append("<input type=text name=friendlyname size=45 maxlength=255 value=\""+reger.core.Util.cleanForHtml(accountuser.getFriendlyname())+"\">");
        } else {
            mb.append(accountuser.getFriendlyname());
        }
        mb.append("</font>");
        if (userSession.getAccountuser().getAccountuserid()==accountuser.getAccountuserid()){
            mb.append("<font face=arial size=-1 color=#0000ff>");
            if (!iseditable && userSession.getAccountuser().getAccountuserid()==accountuser.getAccountuserid()){
                // Following if condition is added to avoid displaying edit profile link, if coming from Author.log
                boolean fromAuthorLog =  ((Boolean) userSession.getAttribute("fromauthor")).booleanValue();
                if (!fromAuthorLog) {
                    mb.append(" (<a href='"+pathToAppRoot+"myhome/settings-profile.log?iseditable=1'>");
                    mb.append("Edit Profile");
                    mb.append("</a>)");
                }
            } else {
                mb.append(" (<a href='"+pathToAppRoot+"myhome/settings-profile.log?iseditable=0'>");
                mb.append("View Profile");
                mb.append("</a>)");
            }
        }
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        //Line
        mb.append("<tr>");
        mb.append("<td valign=top colspan=2 bgcolor=#666666>");
        mb.append("<img src='images/clear.gif' width=1 height=6 border=0>");
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("<tr>");
        mb.append("<td valign=top>");

        //Start main image table


        mb.append("<table cellpadding=5 cellspacing=2 width=100% border=0>");
        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#cccccc>");
        mb.append("<font face=arial size=-1>");
        mb.append("<strong>");
        //mb.append("My Pictures");
        if (iseditable && userSession.getAccountuser().getAccountuserid()==accountuser.getAccountuserid()){
            mb.append(" (<a href='"+pathToAppRoot+"myhome/settings-addprofileimage.log'>");
            mb.append("Add Photo");
            mb.append("</a>)");
        }
        mb.append("</strong>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");



        String profileImageUrl = accountuser.primaryImage(userSession, true);
        mb.append("<table cellpadding=10 cellspacing=2 width=100% border=0>");
        mb.append("<tr>");
        mb.append("<td valign=top align=center bgcolor=#cccccc>");
        if (accountuser.getProfileimageid()>0){
            mb.append("<a href='"+pathToAppRoot + "mediaouthtml.log?imageid=" + accountuser.getProfileimageid() + "&isProfileImage=true' onclick=\"javascript:NewWindow(this.href,'name','0','0','yes');return false;\">");
        }
        mb.append("<img src='"+profileImageUrl+"' width=100 border=0>");
        if (accountuser.getProfileimageid()>0){
            mb.append("</a>");
        }
        if (iseditable && userSession.getAccountuser().getAccountuserid()==accountuser.getAccountuserid() && userSession.getAccountuser().getProfileimageid()>0){
            mb.append("<br>");
            mb.append("<font face=arial size=-2>");
            mb.append("<a href='settings-profile.log?action=deleteprofileimage'>");
            mb.append("Delete");
            mb.append("</a>");
            mb.append("</font>");
        }
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");


        //End main image table




        //Start friends list

        mb.append("<table cellpadding=5 cellspacing=2 width=100% border=0>");
        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#cccccc colspan=2>");
        mb.append("<font face=arial size=-1>");
        mb.append("<strong>");
        mb.append("My Friends");
        if (iseditable && userSession.getAccountuser().getAccountuserid()==accountuser.getAccountuserid()){
            mb.append(" (<a href='people-friends-invite.log'>");
            mb.append("Invite Friends");
            mb.append("</a>)");
        }
        mb.append("</strong>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");



        //-----------------------------------
        //-----------------------------------
        String[][] rstAuthors= Db.RunSQL("SELECT accountuserid, friendlyname, lastlogindate, onelinesummary, account.accountid FROM friend, accountuser, account WHERE friend.accountuseridsource='"+accountuser.getAccountuserid()+"' AND friend.accountuseridtarget=accountuser.accountuserid AND accountuser.accountid=account.accountid ORDER BY friendlyname ASC");
        //-----------------------------------
        //-----------------------------------
        if (rstAuthors!=null && rstAuthors.length>0){
            for(int i=0; i<rstAuthors.length; i++){

                reger.Accountuser ac = new reger.Accountuser(userSession.getAccount().getAccountid(), Integer.parseInt(rstAuthors[i][0]));

                reger.Account acctTmp = reger.cache.AccountCache.get(Integer.parseInt(rstAuthors[i][4]));

                mb.append("<tr>");
                mb.append("<td valign=top align=left>");
                mb.append("<a href='"+acctTmp.getSiteRootUrl(userSession)+"/"+"author.log?accountuserid="+rstAuthors[i][0]+"'>");
                mb.append("<img src='"+ac.primaryImage(userSession, true)+"' width=35 border=0 align=top>");
                mb.append("</a>");
                mb.append("</td>");

                mb.append("<td valign=top align=left>");
                mb.append("<font face=arial size=-1>");
                mb.append("<a href='"+acctTmp.getSiteRootUrl(userSession)+"/"+"author.log?accountuserid="+rstAuthors[i][0]+"'>");
                mb.append(rstAuthors[i][1]);
                mb.append("</a>");
                mb.append("</font>");
                mb.append("<br>");
                mb.append("<font face=arial size=-2>");
                mb.append(rstAuthors[i][3]);
                mb.append("</font>");
                mb.append("</td>");


            }
        } else {
            mb.append("<td valign=top align=left colspan=2>");
            mb.append("<font face=arial size=-2>");
            mb.append("No friends found.");
            mb.append("</font>");
            mb.append("</td>");
        }



        mb.append("</table>");


        //End friends list




        mb.append("</td>");


        mb.append("<td valign=top>");
        //Start right table
        mb.append(getMySummary(accountuser, userSession, iseditable));
        mb.append(getActions(accountuser, userSession, pathToAppRoot));
        mb.append(getMySite(accountuser, userSession));
        mb.append(getMyStats(accountuser, userSession));
        mb.append(getAccountuserfieldsHtml(accountuser, userSession, iseditable));
        if (iseditable && userSession.getAccountuser().getAccountuserid()==accountuser.getAccountuserid()){
            mb.append("<br>");
            mb.append("<input type=submit value='Save My Profile'>");
            mb.append("</form>");
        }
        //End right table
        mb.append("</td>");

        mb.append("</tr>");



        //Line
        mb.append("<tr>");
        mb.append("<td valign=top colspan=2 bgcolor=#666666>");
        mb.append("<img src='images/clear.gif' width=1 height=6 border=0>");
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("</table>");
        // To avoid displaying edit profile link, if coming from Author.log
       userSession.setAttribute("fromauthor", false);
        return mb;
    }


    public static StringBuffer getAccountuserfieldsHtml(reger.Accountuser accountuser, reger.UserSession userSession, boolean iseditable){
        StringBuffer mb = new StringBuffer();
        if(accountuser.getAccountuserfields().size()>0 || (iseditable && userSession.getAccountuser().getAccountuserid()==accountuser.getAccountuserid())){
            mb.append("<table cellpadding=5 cellspacing=2 width=100% border=0>");
            mb.append("<tr>");
            mb.append("<td valign=top bgcolor=#cccccc>");
            mb.append("<font face=arial size=-1>");
            mb.append("<strong>");
            mb.append("About Me");
            if (iseditable && userSession.getAccountuser().getAccountuserid()==accountuser.getAccountuserid()){
                mb.append(" (<a href='settings-addaccountuserfield.log'>");
                mb.append("Add Information to My Profile");
                mb.append("</a>)");
            }
            mb.append("</strong>");
            mb.append("</font>");
            mb.append("</td>");
            mb.append("</tr>");
            //Iterate the accountuserfields
            for (int i = 0; i < accountuser.getAccountuserfields().size(); i++) {
                //Get the field
                reger.Accountuserfield field = (reger.Accountuserfield) accountuser.getAccountuserfields().get(i);
                mb.append("<tr>");
                mb.append("<td valign=top bgcolor=#e6e6e6>");
                if (iseditable && userSession.getAccountuser().getAccountuserid()==accountuser.getAccountuserid()){
                    mb.append("<font face=arial size=-2>");
                    mb.append("<a href='settings-profile.log?action=deleteaccountuserfield&accountuserfieldid="+field.accountuserfieldid+"'>");
                    mb.append("Delete");
                    mb.append("</a>");
                    mb.append("</font>");
                    mb.append("<br>");
                    mb.append("<input type=text name=title-accountuserfieldid-"+field.accountuserfieldid+" size=35 maxlength=255 value=\""+reger.core.Util.cleanForHtml(field.fieldtitle)+"\">");
                } else {
                    mb.append("<font face=arial size=-2>");
                    mb.append("<strong>");
                    mb.append(field.fieldtitle);
                    mb.append("</strong>");
                    mb.append("</font>");
                }
                mb.append("</td>");
                mb.append("</tr>");
                mb.append("<tr>");
                mb.append("<td valign=top>");
                if (iseditable && userSession.getAccountuser().getAccountuserid()==accountuser.getAccountuserid()){
                    mb.append("<textarea name=fielddata-accountuserfieldid-"+field.accountuserfieldid+" cols=45 rows=3 style=\"font-size: 11px;font-family: arial;\">");
                    mb.append(field.fielddata);
                    mb.append("</textarea>");

                } else {
                    mb.append("<font face=arial size=-2>");
                    mb.append(field.fielddata);
                    mb.append("</font>");
                }
                mb.append("</td>");
                mb.append("</tr>");
            }
            mb.append("</table>");
        }
        return mb;
    }

    public static StringBuffer getMyStats(reger.Accountuser accountuser, reger.UserSession userSession){
        StringBuffer mb = new StringBuffer();
        mb.append("<table cellpadding=5 cellspacing=2 width=100% border=0>");
        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#cccccc colspan=2>");
        mb.append("<font face=arial size=-1>");
        mb.append("<strong>");
        mb.append("My Stats");
        mb.append("</strong>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        //Convert account created to site timezone
        java.util.Calendar ac = reger.core.TimeUtils.gmttousertime(accountuser.getCreatedate(), userSession.getAccount().getTimezoneid());

        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("<strong>");
        mb.append("Account Created: ");
        mb.append("</strong>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#ffffff>");
        mb.append("<font face=arial size=-2>");
        mb.append(reger.core.TimeUtils.dateformatcompactwithtime(ac));
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");


        //Convert account created to site timezone
        java.util.Calendar ll = reger.core.TimeUtils.gmttousertime(accountuser.getLastlogindate(), userSession.getAccount().getTimezoneid());

        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("<strong>");
        mb.append("Last Login: ");
        mb.append("</strong>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#ffffff>");
        mb.append("<font face=arial size=-2>");
        mb.append(reger.core.TimeUtils.dateformatcompactwithtime(ll));
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        //Number of Posts
        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("<strong>");
        mb.append("Number of Entries: ");
        mb.append("</strong>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top bgcolor=#ffffff>");
        mb.append("<font face=arial size=-2>");
        //-----------------------------------
        //-----------------------------------
        String[][] rstPosts= Db.RunSQL("SELECT count(*) as cnt, megalog.logid, name FROM event, megalog WHERE event.logid=megalog.logid AND "+userSession.getAccountuser().LogsUserCanViewQueryend(userSession.getAccount().getAccountid())+" AND event.accountuserid='"+accountuser.getAccountuserid()+"' AND "+reger.Entry.sqlOfLiveEntry+" GROUP BY megalog.logid ORDER BY cnt DESC");
        //-----------------------------------
        //-----------------------------------
        int totalposts = 0;
        if (rstPosts!=null && rstPosts.length>0){
            for(int i=0; i<rstPosts.length; i++){
                totalposts = totalposts + Integer.parseInt(rstPosts[i][0]);
            }
        }
        mb.append("<strong>");
        mb.append(totalposts + " Total Entries");
        mb.append("</strong>");
        mb.append("<br>");
        int numberofposts = 0;
        String logname = "";
        if (rstPosts!=null && rstPosts.length>0){
            for(int i=0; i<rstPosts.length; i++){
                numberofposts = Integer.parseInt(rstPosts[i][0]);
                logname = rstPosts[i][2];
                mb.append(""+numberofposts+" " + logname);
                mb.append("<br>");
            }
        }
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");




        mb.append("</table>");
        return mb;
    }

    public static StringBuffer getMySummary(reger.Accountuser accountuser, reger.UserSession userSession, boolean iseditable){
        StringBuffer mb = new StringBuffer();
        mb.append("<table cellpadding=5 cellspacing=2 width=100% border=0>");
        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#cccccc>");
        mb.append("<font face=arial size=-1>");
        mb.append("<strong>");
        mb.append("My Summary");
        mb.append("</strong>");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("<tr>");
        mb.append("<td valign=top>");
        if (iseditable && userSession.getAccountuser().getAccountuserid()==accountuser.getAccountuserid()){
            mb.append("<input type=text name=onelinesummary size=45 maxlength=255 value=\""+reger.core.Util.cleanForHtml(accountuser.getOnelinesummary())+"\">");
        } else {
            mb.append("<font face=arial size=-2>");
            mb.append(accountuser.getOnelinesummary());
            mb.append("</font>");
        }
        mb.append("</td>");
        mb.append("</tr>");

        mb.append("</table>");
        return mb;
    }


    public static StringBuffer getMySite(reger.Accountuser accountuser, reger.UserSession userSession){
        StringBuffer mb = new StringBuffer();
        mb.append("<table cellpadding=5 cellspacing=2 width=100% border=0>");
        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#cccccc>");
        mb.append("<font face=arial size=-1>");
        mb.append("<strong>");
        mb.append("My Site: ");
        mb.append("</strong>");
        mb.append("</font>");
        mb.append("<a href='"+accountuser.getSiteRootUrlOfPrimaryAccount(userSession)+"/'>");
        mb.append("<font face=arial size=-2>");
        mb.append(""+accountuser.getSiteRootUrlOfPrimaryAccount(userSession) + "/");
        mb.append("</font>");
        mb.append("</a>");
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");
        return mb;
    }


    public static StringBuffer getActions(reger.Accountuser accountuser, reger.UserSession userSession, String pathToAppRoot){
        StringBuffer mb = new StringBuffer();
            mb.append("<table cellpadding=5 cellspacing=2 width=100% border=0>");
            if (userSession.getAccountuser().getAccountuserid()!=accountuser.getAccountuserid()){
                if (!userSession.getAccountuser().isFriend(accountuser.getAccountuserid())){
                    //Put stuff that you should see on people who are NOT your friends here
                    mb.append("<tr>");
                    mb.append("<td valign=top align=left bgcolor=#e6e6e6 colspan=2>");
                    mb.append("<a href='"+pathToAppRoot+"about/login.log?accountuseridtarget="+accountuser.getAccountuserid()+"'>");
                    mb.append("<font face=arial size=-2>");
                    mb.append("Make Me Your Friend");
                    mb.append("</font>");
                    mb.append("</a>");
                    mb.append("</td>");
                    mb.append("</tr>");
                } else {
                    //Put stuff that you should see on people who are your friends here
                }
            }
            mb.append("</table>");
        return mb;
    }
}
