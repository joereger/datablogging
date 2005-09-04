package reger.episodes;

import reger.core.Debug;
import reger.Account;

/**
 * Renders an episode to html
 */
public class EpisodeRender {

    public static String getHtml(Episode episode, Account account, boolean displayasadmin, String saveEpisodeUrl){
        StringBuffer mb = new StringBuffer();

        int totalWidth = 95;

        mb.append("<!-- Start Episode -->");
        if (displayasadmin){
            mb.append("<form action='"+saveEpisodeUrl+"' method=post>");
            mb.append("<input type=hidden name=episodeid value="+episode.getEpisodeid()+">");
            mb.append("<input type=hidden name=action value=editepisode>");
        }
        mb.append("<div class=episodewrapper>");
        mb.append("<table cellpadding=0 cellspacing=0 width=100% border=0>");
        mb.append("<tr>");
        mb.append("<td valign=bottom align=left class=episodetitle>");
        if (displayasadmin){
            mb.append("<input type=text name=episodename value=\""+reger.core.Util.cleanForHtml(episode.getName())+"\" size=35 maxlength=254 style=\"font-size: 10px;\">");
            mb.append("<input type=submit value='Save this Episode'>");
        } else {
            mb.append(episode.getName());
        }
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("<tr>");
        mb.append("<td valign=bottom align=left class=episodedesc>");
        if (displayasadmin){
            mb.append("<textarea rows=3 cols=45 name=episodedescription style=\"font-size: 10px;\">");
            mb.append(episode.getDescription());
            mb.append("</textarea>");
            mb.append("<br>");
            mb.append("<font face=arial size=-2>");
            mb.append("<a href='"+saveEpisodeUrl+"?action=deleteepisode&episodeid="+episode.getEpisodeid()+"' >");
            mb.append("Delete this Episode");
            mb.append("</a>");
            //mb.append("<br>");
            mb.append(", will not delete any entries.");
        } else {
            mb.append(episode.getDescription());
        }
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");

        if (displayasadmin){
            mb.append("</form>");
        }





        mb.append("<div class=episodeinnerwrapper>");
        mb.append("<table cellpadding=0 cellspacing=0 width="+totalWidth+"% border=0>");
        mb.append("<tr>");

        //Calculate the width by percentage
        int width=0;
        try{
            width = 100/episode.getNumberOfDefaultScalePeriodsInEpisode();
        } catch (java.lang.ArithmeticException e){
            Debug.debug(5, "", e);
        }


        //Loop on number of time periods in episode
        for(int i=0; i<episode.getNumberOfDefaultScalePeriodsInEpisode(); i++){
            mb.append("<!-- Start time unit -->");
            mb.append("<td valign=bottom width="+width+"% align=center>");
            //Put the episodes in there
            reger.Entry[] eventsInThisPeriod = (reger.Entry[])episode.getEpisodeTimePeriodBuckets().get(i);
            for (int j = 0; j < eventsInThisPeriod.length; j++) {
                mb.append("<div class=episodeicon onmouseover=\"style.backgroundColor='#e6e6e6';\" onmouseout=\"style.backgroundColor='#ffffff'\">");
                //mb.append("<img src=images/clear.gif width=10 height=5>");
                if (displayasadmin){
                    mb.append("<a href='entry.log?eventid="+eventsInThisPeriod[j].eventid+"&action=edit'>");
                    mb.append(reger.core.Util.truncateString(eventsInThisPeriod[j].title, 30));
                    mb.append("</a>");
                    mb.append("<a href='"+saveEpisodeUrl+"?eventid="+eventsInThisPeriod[j].eventid+"&action=removeentry&episodeid="+episode.getEpisodeid()+"'>");
                    mb.append("<font face=arial size=-2 color=#0000ff>");
                    mb.append("(remove)");
                    mb.append("</font>");
                    mb.append("</a>");
                } else {
                    mb.append("<a href='entry-eventid"+eventsInThisPeriod[j].eventid+".log'>");
                    mb.append(reger.core.Util.truncateString(eventsInThisPeriod[j].title, 30));
                    mb.append("</a>");
                }
                mb.append("</div>");
            }
            mb.append("</td>");
            mb.append("<!-- End time unit -->");
        }
        mb.append("</tr>");


        mb.append("<tr>");
        //Loop on number of time periods in episode
        for(int i=0; i<episode.getNumberOfDefaultScalePeriodsInEpisode(); i++){
            mb.append("<!-- Start time unit footer -->");
            mb.append("<td valign=top>");
            mb.append("<div class=episodefooter><img src=images/clear.gif width=25 height=5></div>");
            mb.append("</td>");
            mb.append("<!-- End time unit footer -->");
        }
        mb.append("</tr>");


        mb.append("</table>");


        mb.append("<table cellpadding=0 cellspacing=0 width="+totalWidth+"% border=0>");
        mb.append("<tr>");
        mb.append("<td valign=top align=left class=episodedate>");
        if (episode.getStartDateGMT()!=null){
            //mb.append(reger.core.TimeUtils.dateformatdate(episode.getStartDateGMT()));
            mb.append(reger.core.TimeUtils.dateformatcompactwithtime(reger.core.TimeUtils.gmttousertime(episode.getStartDateGMT(), account.getTimezoneid())));
            mb.append("<br>");
            mb.append(account.getTimezoneid());
        }
//        mb.append("<br>");
//        if (episode.getStartDateGMT()!=null){
//            mb.append(reger.core.TimeUtils.dateformattime(episode.getStartDateGMT()));
//        }
        mb.append("</td>");
        mb.append("<td valign=top align=center class=episodedate>");
        mb.append("( "+episode.getNameOfScale()+" )");
        mb.append("</td>");
        mb.append("<td valign=top align=right class=episodedate>");
        if (episode.getEndDateGMT()!=null){
            //mb.append(reger.core.TimeUtils.dateformatdate(episode.getEndDateGMT()));
            mb.append(reger.core.TimeUtils.dateformatcompactwithtime(reger.core.TimeUtils.gmttousertime(episode.getEndDateGMT(), account.getTimezoneid())));
            mb.append("<br>");
            mb.append(account.getTimezoneid());
        }
//        mb.append("<br>");
//        if (episode.getEndDateGMT()!=null){
//            mb.append(reger.core.TimeUtils.dateformattime(episode.getEndDateGMT()));
//        }
        mb.append("</td>");
        mb.append("</tr>");
        mb.append("</table>");


        mb.append("</div>");

        mb.append("</div>");
        mb.append("<!-- End Episode -->");

        return mb.toString();
    }


}
