
package reger;

public class logProps{

	//Log and event-specific vars
	public int logid=-1;
	public String megalogname;
	public int megalogaccess;
	public String megalogtypeicon;
	public int showlocation;
	public int eventtypeid=-1;

    /**
     *
     */
    public void populate(int accountid, javax.servlet.http.HttpServletRequest request) {

    }

	/**
	*	Accepts a logid and an account id.  Populates the logProps object
	*   with some log specific data like log name, etc.
	*/
	public void populateLogidData(int incominglogid, int accountid){
		//-----------------------------------
		//-----------------------------------
		String[][] rsLogid= reger.core.db.Db.RunSQL("SELECT logid, name, logaccess, icon, showlocation, megalog.eventtypeid FROM megalog, megalogtype WHERE megalog.logid='"+ incominglogid +"' AND megalog.eventtypeid=megalogtype.eventtypeid AND megalog.accountid='"+ accountid +"'");
		//-----------------------------------
		//-----------------------------------
		if (rsLogid!=null && rsLogid.length>0){
			logid=Integer.parseInt(rsLogid[0][0]);
			megalogname=rsLogid[0][1];
		 	megalogaccess=Integer.parseInt(rsLogid[0][2]);
			megalogtypeicon=rsLogid[0][3];
			showlocation=Integer.parseInt(rsLogid[0][4]);
			eventtypeid=Integer.parseInt(rsLogid[0][5]);
		}
	}

	/**
	*	Accepts a logid and an account id.  Populates the pageProps object
	*   with some log specific data like log name, etc.
	*/
	public void populateEventidData(int incomingeventid, int accountid){
		//-----------------------------------
		//-----------------------------------
		String[][] rsLogid= reger.core.db.Db.RunSQL("SELECT event.logid, eventid FROM event, megalog, megalogtype WHERE event.eventid='"+ incomingeventid +"' AND event.accountid='"+ accountid +"' AND megalog.logid=event.logid AND megalog.eventtypeid=megalogtype.eventtypeid AND megalog.accountid='"+ accountid +"'");
		//-----------------------------------
		//-----------------------------------
		if (rsLogid!=null && rsLogid.length>0){
			//Now populate the logProps object with log-specific data
			populateLogidData( Integer.parseInt(rsLogid[0][0]), accountid);
		}
	}


    /**
	*	Preview
	*/
	public void populateWithEventtypeidForPreview(int eventtypeid){
		//-----------------------------------
		//-----------------------------------
		String[][] rsLogid= reger.core.db.Db.RunSQL("SELECT megalogname, icon, showlocation FROM megalogtype WHERE eventtypeid='"+eventtypeid+"'");
		//-----------------------------------
		//-----------------------------------
		if (rsLogid!=null && rsLogid.length>0){
			this.logid=-1;
			this.megalogname=rsLogid[0][0];
		 	this.megalogaccess=reger.Vars.LOGACCESSPUBLIC;
			this.megalogtypeicon=rsLogid[0][1];
			this.showlocation=Integer.parseInt(rsLogid[0][2]);
			this.eventtypeid=eventtypeid;
		}
	}

}


