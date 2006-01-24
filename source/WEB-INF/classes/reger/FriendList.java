package reger;

import reger.core.db.Db;

import java.util.Calendar;

/**
 * HTML List of friends
 */
public class FriendList {

    /**
     *
     * @return
     */
    public static StringBuffer getList(reger.UserSession userSession, String pathToAppRoot, int numbertodisplay){
        StringBuffer mb = new StringBuffer();

        String limitString = "";
        if (numbertodisplay>0){
            limitString = " LIMIT 0, " + numbertodisplay;
        }

        mb.append("<table cellpadding=5 cellspacing=2 width=100% border=0>");


        mb.append("<tr>");
        mb.append("<td valign=top align=left colspan=5 bgcolor=#cccccc>");
        mb.append("<font face=arial size=-1>");
        mb.append("My Friends");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");


        mb.append("<tr>");
        mb.append("<td valign=top align=left bgcolor=#e6e6e6 colspan=2>");
        mb.append("<font face=arial size=-2>");
        mb.append("&nbsp;");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=left bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("Recent Entries");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=left bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("Last Login");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("<td valign=top align=left bgcolor=#e6e6e6>");
        mb.append("<font face=arial size=-2>");
        mb.append("&nbsp;");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");

        //-----------------------------------
        //-----------------------------------
        String[][] rstAuthors= Db.RunSQL("SELECT accountuserid, friendlyname, lastlogindate, onelinesummary, account.accountid FROM friend, accountuser, account WHERE friend.accountuseridsource='"+userSession.getAccountuser().getAccountuserid()+"' AND friend.accountuseridtarget=accountuser.accountuserid AND accountuser.accountid=account.accountid ORDER BY friendlyname ASC" + limitString);
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


                mb.append("<td valign=top align=left>");
                mb.append("<font face=arial size=-2>");
                //-----------------------------------
                //-----------------------------------
                String[][] rstRecent= Db.RunSQL("SELECT eventid, title, megalog.logid FROM event, megalog WHERE event.logid=megalog.logid AND "+reger.Entry.sqlOfLiveEntry+" AND accountuserid='"+rstAuthors[i][0]+"' ORDER BY date DESC LIMIT 0,5");
                //-----------------------------------
                //-----------------------------------
                if (rstRecent!=null && rstRecent.length>0){
                    mb.append("<table cellpadding=0 cellspacing=0 border=0>");
                    for(int j=0; j<rstRecent.length; j++){
                        //@todo This type of protecting of friend's recent entries isn't ideal because it could result in less than 5 entries being displayed.
                        if (userSession.getAccountuser().userCanViewLog(Integer.parseInt(rstRecent[j][2]))){
                            mb.append("<tr>");
                            mb.append("<td valign=top>");
                            mb.append("<img src='"+pathToAppRoot+"images/bullet-arrow.gif' border=0>");
                            mb.append("</td>");
                            mb.append("<td valign=top>");
                            mb.append("<font face=arial size=-2>");
                            mb.append("<a href='"+acctTmp.getSiteRootUrl(userSession)+"/"+"entry-eventid"+rstRecent[j][0]+".log'>");
                            mb.append(rstRecent[j][1]);
                            mb.append("</a>");
                            mb.append("</font>");
                            mb.append("</td>");
                            mb.append("</tr>");
                        }

                    }
                    mb.append("</table>");
                }
                mb.append("</td>");



                mb.append("<td valign=top align=left>");
                mb.append("<font face=arial size=-2>");
                Calendar tmpCal = reger.core.TimeUtils.dbstringtocalendar(rstAuthors[i][2]);
	            //Calendar tmpCal = reger.core.TimeUtils.convertFromOneTimeZoneToAnother(tmp1Cal, tmp1Cal.getTimeZone().getID(), "GMT");
                mb.append(reger.core.TimeUtils.agoText(tmpCal));
                mb.append("</font>");
                mb.append("</td>");

                mb.append("<td valign=top align=left>");
                mb.append("<font face=arial size=-2>");
                mb.append("<a href='people-friends.log?action=cancelfriendship&friendaccountuseridtodelete="+rstAuthors[i][0]+"'>");
                mb.append("Break Friendship");
                mb.append("</a>");
                mb.append("</font>");
                mb.append("</td>");

                mb.append("</tr>");

                mb.append("<tr>");
                mb.append("<td valign=top bgcolor=#e6e6e6 align=left colspan=5>");
                mb.append("</td>");
                mb.append("</tr>");


            }
        }



        mb.append("<tr>");
        mb.append("<td valign=top bgcolor=#e6e6e6 align=left colspan=5>");
        mb.append("<font face=arial size=-1>");
        mb.append("Add friends by <a href='people-friends-invite.log?action=newstart'>inviting</a> them or by surfing to their sites, viewing their profile and clicking \"Make Me Your Friend.\"");
        mb.append("</font>");
        mb.append("</td>");
        mb.append("</tr>");




        mb.append("</table>");

        return mb;
    }

}
