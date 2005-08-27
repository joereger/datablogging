package reger;

import reger.core.db.Db;

/**
 * Retains counts of certain things associated with the account
 */
public class AccountCounts {
    private int authorcount=0;
    private int entrycount=0;
    private int filecount=0;
    private int locationcount=0;
    private int messagecount=0;
    private int episodecount=0;
    private int graphcount=0;
    private int timeperiodcount=0;
    private int savedsearchescount=0;

    private int accountid=0;
    private int accountuserid=0;

    public AccountCounts(){

    }

    public AccountCounts(Account account, Accountuser accountuser){
        this.accountid = account.getAccountid();
        this.accountuserid = accountuser.getAccountuserid();

        //@todo Should only count authors who can write to at least one log you can see
        //-----------------------------------
        //-----------------------------------
        String[][] rstAuthorsCount= Db.RunSQL("SELECT count(*) FROM accountuser WHERE accountid='"+account.getAccountid()+"' AND isactive='1'");
        //-----------------------------------
        //-----------------------------------
        if (rstAuthorsCount!=null && rstAuthorsCount.length>0){
            authorcount = Integer.parseInt(rstAuthorsCount[0][0]);
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstEntryCount= Db.RunSQL("SELECT count(*) FROM event, megalog WHERE "+reger.Entry.sqlOfLiveEntry+" AND event.logid=megalog.logid AND megalog.accountid='" + account.getAccountid() + "' AND " + accountuser.LogsUserCanViewQueryend(account.getAccountid()) + "");
        //-----------------------------------
        //-----------------------------------
        if (rstEntryCount!=null && rstEntryCount.length>0){
            entrycount = Integer.parseInt(rstEntryCount[0][0]);
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstImageCount= Db.RunSQL("SELECT count(*) FROM image, event, megalog WHERE "+reger.Entry.sqlOfLiveEntry+" AND event.eventid=image.eventid AND megalog.accountid='" + account.getAccountid() + "' AND event.logid=megalog.logid AND " + accountuser.LogsUserCanViewQueryend(account.getAccountid()) + "");
        //-----------------------------------
        //-----------------------------------
        if (rstImageCount!=null && rstImageCount.length>0){
            filecount = Integer.parseInt(rstImageCount[0][0]);
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstLocactionCount= Db.RunSQL("SELECT count(DISTINCT location.locationid) FROM location, event, megalog WHERE "+reger.Entry.sqlOfLiveEntry+" AND event.locationid=location.locationid AND megalog.accountid='" + account.getAccountid() + "' AND event.logid=megalog.logid AND " + accountuser.LogsUserCanViewQueryend(account.getAccountid()) + "");
        //-----------------------------------
        //-----------------------------------
        if (rstLocactionCount!=null && rstLocactionCount.length>0){
            locationcount = Integer.parseInt(rstLocactionCount[0][0]);
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstMessageCount= Db.RunSQL("SELECT count(*) FROM message, event, megalog WHERE message.isapproved='1' AND "+reger.Entry.sqlOfLiveEntry+" AND event.eventid=message.eventid AND megalog.accountid='" + account.getAccountid() + "' AND event.logid=megalog.logid AND " + accountuser.LogsUserCanViewQueryend(account.getAccountid()) + "");
        //-----------------------------------
        //-----------------------------------
        if (rstMessageCount!=null && rstMessageCount.length>0){
            messagecount = Integer.parseInt(rstMessageCount[0][0]);
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstEpisodeCount= Db.RunSQL("SELECT count(DISTINCT(episode.episodeid)) FROM episode, event, megalog, eventtoepisode WHERE "+reger.Entry.sqlOfLiveEntry+" AND event.eventid=eventtoepisode.eventid AND eventtoepisode.episodeid=episode.episodeid AND megalog.accountid='" + account.getAccountid() + "' AND event.logid=megalog.logid AND " + accountuser.LogsUserCanViewQueryend(account.getAccountid()) + "");
        //-----------------------------------
        //-----------------------------------
        if (rstEpisodeCount!=null && rstEpisodeCount.length>0){
            episodecount = Integer.parseInt(rstEpisodeCount[0][0]);
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstGraph= Db.RunSQL("SELECT COUNT(DISTINCT megachart.megachartid) FROM megachart, megachartyaxis, megalog" +
        " WHERE "+
        " megachart.megachartid=megachartyaxis.megachartid "+
        " AND "+ accountuser.LogsUserCanViewQueryend(account.getAccountid()) +
        " AND "+
        " ( "+
        "    (megalog.accountid='"+account.getAccountid()+"' AND (megalog.logid=megachart.xlogid OR megalog.logid=megachartyaxis.ylogid OR megalog.eventtypeid=megachart.xeventtypeid OR megalog.eventtypeid=megachartyaxis.yeventtypeid )) "+
        " ) "+
        " ORDER BY megachart.accountid DESC, megalog.logid ASC, megachart.megachartid DESC"
        );
        //-----------------------------------
        //-----------------------------------
        if (rstGraph!=null && rstGraph.length>0){
            graphcount = Integer.parseInt(rstGraph[0][0]);
        }

        //Deal with private/public
        String privateSql = " isprivate='0' ";
        if (accountuser.userCanDoAcl("TIMEPERIODSVIEWPRIVATE", account.getAccountid())){
            privateSql = " (isprivate='0' || isprivate='1') ";
        }
        //-----------------------------------
        //-----------------------------------
        String[][] rstTimePeriods= Db.RunSQL("SELECT count(*) FROM timeperiod WHERE accountid='"+account.getAccountid()+"' AND " + privateSql);
        //-----------------------------------
        //-----------------------------------
        if (rstTimePeriods!=null && rstTimePeriods.length>0){
            timeperiodcount = Integer.parseInt(rstTimePeriods[0][0]);
        }


        //-----------------------------------
        //-----------------------------------
        String[][] rstSavedSearch= Db.RunSQL("SELECT savedsearch.savedsearchid, savedsearch.name FROM savedsearch, megalog, savedsearchlog WHERE savedsearch.savedsearchid=savedsearchlog.savedsearchid AND savedsearchlog.logid=megalog.logid AND "+accountuser.LogsUserCanViewQueryend(account.getAccountid())+" GROUP BY savedsearchid ORDER BY savedsearch.name ASC");
        //-----------------------------------
        //-----------------------------------
        int numberOfSavedSearches = 0;
        if (rstSavedSearch!=null && rstSavedSearch.length>0){
            savedsearchescount = rstSavedSearch.length;
        }


    }

    public int getAuthorcount() {
        return authorcount;
    }

    public void setAuthorcount(int authorcount) {
        this.authorcount = authorcount;
    }

    public int getEntrycount() {
        return entrycount;
    }

    public void setEntrycount(int entrycount) {
        this.entrycount = entrycount;
    }

    public int getFilecount() {
        return filecount;
    }

    public void setFilecount(int filecount) {
        this.filecount = filecount;
    }

    public int getLocationcount() {
        return locationcount;
    }

    public void setLocationcount(int locationcount) {
        this.locationcount = locationcount;
    }

    public int getMessagecount() {
        return messagecount;
    }

    public void setMessagecount(int messagecount) {
        this.messagecount = messagecount;
    }

    public int getEpisodecount() {
        return episodecount;
    }

    public void setEpisodecount(int episodecount) {
        this.episodecount = episodecount;
    }

    public int getGraphcount() {
        return graphcount;
    }

    public void setGraphcount(int graphcount) {
        this.graphcount = graphcount;
    }

    public int getTimeperiodcount() {
        return timeperiodcount;
    }

    public void setTimeperiodcount(int timeperiodcount) {
        this.timeperiodcount = timeperiodcount;
    }

    public int getSavedsearchescount() {
        return savedsearchescount;
    }

    public void setSavedsearchescount(int savedsearchescount) {
        this.savedsearchescount = savedsearchescount;
    }

}
