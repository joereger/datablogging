package reger.api;

import reger.core.db.Db;
import reger.core.ValidationException;
import reger.core.Debug;
import reger.core.TimeUtils;
import reger.Media.MediaType;
import reger.Media.MediaTypeFactory;
import reger.ThumbnailCreator;

import javax.mail.BodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.imageio.ImageReader;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.util.Calendar;
import java.util.Iterator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.image.BufferedImage;


/**
 * This EmailApi accepts a raw rfc 2822 message as text, creates javax.mail objects from it
 * and proceeds to try to apply it to a web log.
 *
 * This class also needs to deal with spam and be aware that people will try to use it
 * as a relay.
 */
public class EmailApi {
    //Utility vars
    public String rawMailMessage;
    javax.mail.internet.MimeMessage mimeMessage;
    javax.mail.internet.MimeMultipart multiPart;
    int accountuserid = -1;
    boolean isMultipart = false;

    //Actual message vars
    String[] allRecipients;
    //String to;
    String subject;
    String body;

    //Derived message vars
    //String accounturl;
    //int plid;
    //String username;
    String friendlyname;
    String emailsecret;
    String timezoneid;
    int logid;

    int accountid;
    String uniquekey;


    //Some default settings - stored for user in table emailapi
    int overridecamphonesubject = 0;
    String overridecamphonesubjecttext = "Camera Phone Picture(s) For Today";
    int ignorecamphonebody = 0;
    int consolidatecamphonetoonedailyentry = 0;
    int saveemailpostsasdraft = 0;
    int savecamphonepostsasdraft = 0;
    String camphoneimagetags = "";

    //These are the types of actions that can be taken
    public static final int CAMPHONEPOST = 0;
    public static final int EMAILPOST = 1;

    //And this is what type of incoming message this is
    int mailtype = EMAILPOST;


    /**
     * Constructor
     */
    public EmailApi(javax.mail.internet.MimeMessage mimeMessage){
        this.mimeMessage = mimeMessage;
        if (mimeMessage!=null){
            startWorking();
        }
    }

    /**
     * Constructor with ability to set debug
     * @param rawMailMessage
     */
    public EmailApi(String rawMailMessage){
        this.rawMailMessage = rawMailMessage;
        mimeMessage = turnStringIntoEmail(rawMailMessage);
        if (mimeMessage!=null){
            startWorking();
        }
    }

    private void startWorking(){
        //Set some vars
        Debug.debug(3, "EmailApi", "Starting to process mail message.");

        //Parse the message
        boolean parseIn = parseIncomingMessage();
        Debug.debug(3, "EmailApi", "Result of parsing incoming raw message:" + parseIn);

        //Iterate all recipients, looking for valid logs
        if (parseIn){
            if (allRecipients!=null && allRecipients.length>0){
                for (int i = 0; i < allRecipients.length; i++) {
                    //Parse the to address
                    boolean parseTo = parseToAddress(allRecipients[i]);
                    Debug.debug(3, "EmailApi", "Result of parsing to address:" + parseTo);

                    //If we have what appears to be good incoming data, let's try for a post
                    if (parseIn && parseTo){
                        newPost();
                    }
                }
            }
        }
    }

    public static javax.mail.internet.MimeMessage turnStringIntoEmail(String rawMailMessage){
        Debug.debug(3, "EmailApi", "rawMailMessage:<br>" + rawMailMessage);
        javax.mail.internet.MimeMessage mimeMessage = null;
        try{
            //Turn the raw message into a mimeMessage using an inputstream
            java.util.Properties properties = new java.util.Properties();
            javax.mail.Session session = javax.mail.Session.getDefaultInstance(properties);
            java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(rawMailMessage.getBytes());
            mimeMessage = new javax.mail.internet.MimeMessage(session, in);
            in.close();
        } catch (java.io.UnsupportedEncodingException e){
            //Do nothing... the user sent something like CHINESEBIG5 or BIG5
            Debug.debug(3, "EmailApi", e);
        } catch (javax.mail.MessagingException e){
            //Some sort of message formatting problem on the part of the sender
            Debug.debug(3, "EmailApi", e);
        } catch (Exception e) {
            Debug.errorsave(e, "EmailApi");
        }

        return mimeMessage;
    }

    /**
     * Parses rawMailMessage, creating the more abstracted and powerful javax.mail objects.
     * The rawMailMessage var must already be populated with the raw mail message.
     */
    private boolean parseIncomingMessage(){
        try{


            //Forward emails that should be forwarded
            try {
                //forwardIfNecessary(mimeMessage);
            } catch (Exception e){
                //Do nothing
            }

            //Figure out the content type of this message
            try{
                if (mimeMessage.getContentType().toLowerCase().indexOf("multipart")>-1){
                    isMultipart = true;
                }
            } catch (Exception e){
                //Do nothing
            }
            //Only if content type = multipart
            if (isMultipart){
                //Turn the message into a data source
                javax.mail.internet.MimePartDataSource mpds = new javax.mail.internet.MimePartDataSource(mimeMessage);
                //Turn the data source into a MimeMultipart
                multiPart = new javax.mail.internet.MimeMultipart(mpds);

                //At this point the rawMailMessage is into two much more powerful javax objects.
                //We can work with our shiny new MimeMultipart and MimeMessage.
                //MimeMessage holds the overall message while MimeMultipart holds the body, attachments, etc.

                //If in debug mode, list the parts
                if (reger.core.DegubLevel.getDebugLevel()>=3){
                    try{
                        Debug.debug(3, "EmailApi", "Number of Multiparts = " + multiPart.getCount());
                        for(int i=0; i<multiPart.getCount(); i++){
                            Debug.debug(3, "EmailApi", "Multipart #" + i + "<br>" + multiPart.getBodyPart(i).getContent() + "<br>class.getName()=" + multiPart.getBodyPart(i).getContent().getClass().getName());
                            if (multiPart.getBodyPart(i).getContent().getClass().getName().equals("com.sun.mail.Util.BASE64DecoderStream")){
                                String filename = multiPart.getBodyPart(i).getFileName();
                                String contenttype = multiPart.getBodyPart(i).getContentType();
                                Debug.debug(3, "EmailApi", "We have an attachment called: " + filename + "<br>contenttype=" + contenttype);
                            }
                        }
                    } catch (Exception e){
                        Debug.debug(3, "EmailApi", e);
                    }
                }
            }

            //Get the recipient(s)
            javax.mail.Address[] addresses = mimeMessage.getAllRecipients();
            //Only use the first recipient as the to address
            if (addresses!=null  && addresses.length>0){
                //to = addresses[0].toString();
                allRecipients = new String[addresses.length];
                for (int i = 0; i < addresses.length; i++) {
                    allRecipients[i] = addresses[i].toString();
                    Debug.debug(3, "EmailApi", "To:" + addresses[i]);
                }
            }

            //Get the subject
            subject = mimeMessage.getSubject();
            Debug.debug(3, "EmailApi", "Subject:" + subject);

            //Get the body
            getBody();


        //} catch (java.io.UnsupportedEncodingException e){
        //    //Do nothing... the user sent something like CHINESEBIG5 or BIG5
        //    reger.core.Util.debug(5, e);
        //    return false;
        } catch (javax.mail.MessagingException e){
            //Some sort of message formatting problem on the part of the sender
            Debug.debug(3, "EmailApi", e);
            return false;
        } catch (Exception e) {
            Debug.errorsave(e, "EmailApi");
            return false;
        }
        return true;
    }

    private void getBody(){
        //Get the body of the message
        body="";
        try{
            if (isMultipart){
                 tryToGetBodyOfEmailFromAPart(multiPart);

            } else {
                body = body + String.valueOf(mimeMessage.getContent());
                Debug.debug(3, "EmailApi", "Body found as non multipart message:" + body);
            }
        } catch (Exception e){
            Debug.debug(3, "EmailApi", e);
        }
        Debug.debug(3, "EmailApi", "Final Body:" + body);
    }

    private void tryToGetBodyOfEmailFromAPart(MimeMultipart bodyPart){
        try{
            //Iterate all parts of the part
            boolean foundBodyFromPlain = false;
            boolean foundBodyFromHtml = false;
            boolean foundBodyFromElse = false;
            reger.core.Debug.debug(3, "EmailApi", "Iterating all parts of a bodyPart in tryToGetBodyOfEmailFromAPart()");
            for(int i=0; i<bodyPart.getCount(); i++){
                reger.core.Debug.debug(3, "EmailApi","Starting new bodyPart.");
                if (bodyPart.getBodyPart(i).getContentType().toLowerCase().indexOf("multipart")>-1){
                    //It's a part. Send it back to this function, recursively
                    try{
                        tryToGetBodyOfEmailFromAPart((MimeMultipart)bodyPart.getBodyPart(i).getContent());
                    } catch (Exception e){
                        Debug.errorsave(e, "EmailApi");
                    }
                } else if (bodyPart.getBodyPart(i).getContentType().toLowerCase().indexOf("image")>-1){
                    //Do nothing
                } else if (bodyPart.getBodyPart(i).getContentType().toLowerCase().indexOf("message")>-1){
                    //It's a message
                    MimeMessage nestedMsg = null;
                    try{
                        nestedMsg = (MimeMessage)bodyPart.getBodyPart(i).getContent();
                    } catch (java.lang.ClassCastException ex){
                        Debug.debug(3, "EmailApi", ex);
                    }
                    if (nestedMsg!=null && nestedMsg.getContentType().toLowerCase().indexOf("multipart")>-1){
                        //Convert it from a message to a multipart
                        javax.mail.internet.MimePartDataSource mpds = new javax.mail.internet.MimePartDataSource(nestedMsg);
                        tryToGetBodyOfEmailFromAPart(new javax.mail.internet.MimeMultipart(mpds));
                    } else {
                        if (nestedMsg!=null){
                            body = body + String.valueOf(nestedMsg.getContent());
                            Debug.debug(3, "EmailApi", "Body found as nested message content:" + String.valueOf(nestedMsg.getContent()));
                        } else {
                            body = body + bodyPart.getBodyPart(i).getContent();
                        }
                    }
                } else if (bodyPart.getBodyPart(i).getContentType().toLowerCase().indexOf("text/plain")>-1){
                    if (!foundBodyFromHtml && !foundBodyFromPlain){
                        body = body + String.valueOf(bodyPart.getBodyPart(i).getContent());
                        foundBodyFromPlain = true;
                        Debug.debug(3, "EmailApi", "Body found as text/plain:" + String.valueOf(bodyPart.getBodyPart(i).getContent()));
                    } else {
                        Debug.debug(3, "EmailApi", "Body found as text/plain but not added because previous body was found:" + String.valueOf(bodyPart.getBodyPart(i).getContent()));
                    }
                } else if (bodyPart.getBodyPart(i).getContentType().toLowerCase().indexOf("text/html")>-1){
                    if (!foundBodyFromHtml && !foundBodyFromPlain){
                        body = body + String.valueOf(bodyPart.getBodyPart(i).getContent());
                        foundBodyFromHtml = true;
                        Debug.debug(3, "EmailApi", "Body found as text/html:" + String.valueOf(bodyPart.getBodyPart(i).getContent()));
                    } else {
                        Debug.debug(3, "EmailApi", "Body found as text/html but not added because previous body was found:" + String.valueOf(bodyPart.getBodyPart(i).getContent()));
                    }
                } else {
                    //body = body + String.valueOf(bodyPart.getBodyPart(i).getContent());
                    //foundBodyFromElse = true;
                    reger.core.Debug.debug(3, "EmailApi", "Body found as else");
                }
            }
        } catch (javax.mail.MessagingException e){
            Debug.debug(3, "EmailApi", e);
        } catch (Exception e){
            Debug.errorsave(e, "EmailApi", "EmailApi.java");
        }
    }

    /**
     * Here's what it looks like: T5RF8TG.pass@host.com
     *
     */
    private boolean parseToAddress(String to){
        //Split on the ampersand and take the left/right sides
        if (to==null){
            return false;
        }
        String[] emailSplitInHalf = to.split("@");
        String left="";
        String right="";
        if (emailSplitInHalf.length==2){
            //Left half has the important stuff
            left = emailSplitInHalf[0];
            //Right half has little to do with it and can generally be anything as long as it gets to the server
            right = emailSplitInHalf[1];
        } else {
            Debug.debug(3, "EmailApi", "Failed parseToAddress because emailSplitInHalf.length is not == 2.  It equals:" + emailSplitInHalf.length);
            return false;
        }


        //The left must be parsed some more
        String[] leftSplitOnDot = left.split("\\.");
        if (leftSplitOnDot.length>=2){
            uniquekey = leftSplitOnDot[0].toLowerCase();
            emailsecret = leftSplitOnDot[1].toLowerCase();

            Debug.debug(3, "EmailApi", "EmailApi.ParseTo() - uniquekey:" + uniquekey);
            Debug.debug(3, "EmailApi", "EmailApi.ParseTo() - emailsecret:" + emailsecret);
        } else {
            Debug.debug(3, "EmailApi", "Failed parseToAddress because leftSplitOnDot.length is not >= 2.  It equals:" + leftSplitOnDot.length);
            return false;
        }
        return true;
    }



//    /**
//     * Check for a valid account that has this username, emailsecret, logid and servername
//     */
//    private boolean checkForAccount(){
//
//        //-----------------------------------
//        //-----------------------------------
//        String[][] rstAccount= Db.RunSQL("SELECT accounttypeid, accountuser.accountuserid, accountuser.friendlyname FROM account, accountuser, megalog, emailapi, pl WHERE account.plid=pl.plid AND account.plid='"+plid+"' AND account.accountid=accountuser.accountid AND account.accountid=megalog.accountid AND emailapi.accountuserid=accountuser.accountuserid AND account.accounturl='"+accounturl+"' AND accountuser.username='"+username+"' AND emailapi.emailsecret='"+emailsecret+"' AND megalog.logid='"+logid+"'");
//        //-----------------------------------
//        //-----------------------------------
//        if (rstAccount!=null && rstAccount.length>0){
//            accountuserid = Integer.parseInt(rstAccount[0][1]);
//            reger.Accountuser au = new reger.Accountuser(accountuserid, true);
//            friendlyname =  au.getFriendlyname();
//            //If this is the account owner, return true
//            if (reger.core.Util.isinteger(rstAccount[0][0])){
//                if (Integer.parseInt(rstAccount[0][0])>=reger.Vars.ACCTYPETRIAL){
//                    //Now we know that this is a Pro or Trial account that can use this feature.
//                    //Need to see if this user has the right to use this log.
//                    if (au.userCanViewLog(logid)){
//                        return true;
//                    }
//                }
//            }
//        }
//
//        return false;
//    }


    /**
     * New Entry method.
     */
     private void newPost(){

        //Create an instance of the backend object
        reger.Entry entry = new reger.Entry();

        try {
            Debug.debug(3, "EmailApi", "EmailApi - newPost() - uniquekey: " + uniquekey);

            //See if we have a valid account in the hizzouse
            EmailApiAddress emaddr = new EmailApiAddress(uniquekey);
            if (emaddr.getEmailapiaddressid()>0){

                Debug.debug(3, "EmailApi", "EmailApi - newPost() - emaddr.getUniquekey(): " + emaddr.getUniquekey() + "<br>emaddr.getAccountid():" + emaddr.getAccountid() + "<br>emaddr.getAccountuserid():" + emaddr.getAccountuserid());


                //Get the emailapi settings
                //-----------------------------------
                //-----------------------------------
                String[][] rstApisettings= Db.RunSQL("SELECT overridecamphonesubject, overridecamphonesubjecttext, ignorecamphonebody, consolidatecamphonetoonedailyentry, saveemailpostsasdraft, savecamphonepostsasdraft, camphoneimagetags, emailsecret FROM emailapi WHERE emailapi.accountuserid='"+emaddr.getAccountuserid()+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstApisettings!=null && rstApisettings.length>0){

                    Debug.debug(3, "EmailApi", "EmailApi - newPost() loading emailapi settings.");

                    if (!rstApisettings[0][0].equals("") && reger.core.Util.isinteger(rstApisettings[0][0])){
                        overridecamphonesubject = Integer.parseInt(rstApisettings[0][0]);
                    }
                    if (!rstApisettings[0][1].equals("")){
                        overridecamphonesubjecttext = rstApisettings[0][1];
                    }
                    if (!rstApisettings[0][2].equals("") && reger.core.Util.isinteger(rstApisettings[0][2])){
                        ignorecamphonebody = Integer.parseInt(rstApisettings[0][2]);
                    }
                    if (!rstApisettings[0][3].equals("") && reger.core.Util.isinteger(rstApisettings[0][3])){
                        consolidatecamphonetoonedailyentry = Integer.parseInt(rstApisettings[0][3]);
                    }
                    if (!rstApisettings[0][4].equals("") && reger.core.Util.isinteger(rstApisettings[0][4])){
                        saveemailpostsasdraft = Integer.parseInt(rstApisettings[0][4]);
                    }
                    if (!rstApisettings[0][5].equals("") && reger.core.Util.isinteger(rstApisettings[0][5])){
                        savecamphonepostsasdraft = Integer.parseInt(rstApisettings[0][5]);
                    }
                    if (!rstApisettings[0][6].equals("")){
                        camphoneimagetags = rstApisettings[0][6];
                    }
                    if (!rstApisettings[0][7].equals("")){
                        emailsecret = rstApisettings[0][7];
                    }
                    Debug.debug(3, "EmailApi", "EmailApi - newPost() - found emailsecret=" + emailsecret);
                }

                //Get this user's timezone
                accountid = emaddr.getAccountid();
                timezoneid = reger.Account.getTimezoneidFromAccountid(accountid);
                reger.Account accountOfEntry = new reger.Account(accountid);
                reger.PrivateLabel plOfEntry = new reger.PrivateLabel(accountOfEntry.getPlid());
                reger.Accountuser accountuserOfPersonAccessing = new reger.Accountuser(emaddr.getAccountuserid(), false);
                friendlyname = accountuserOfPersonAccessing.getFriendlyname();
                accountuserOfPersonAccessing.userAuthenticateEmailsecret(accountuserOfPersonAccessing.getEmail(), emailsecret);
                logid = emaddr.getLogid();
                accountuserid = emaddr.getAccountuserid();
                mailtype = emaddr.getEmailtype();

                Debug.debug(3, "EmailApi", "EmailApi newPost() - accountuserOfPersonAccessing.getAccountuserid()=" + accountuserOfPersonAccessing.getAccountuserid());

                //Create the entry
                entry = new reger.Entry();
                entry.logid = logid;
                entry.accountid = accountid;

                //Set the title
                if (mailtype==CAMPHONEPOST && overridecamphonesubject==1){
                    overridecamphonesubjecttext = overridecamphonesubjecttext.replaceAll("\\<\\$Date\\$\\>", reger.core.TimeUtils.dateformatFullNoTime(reger.core.TimeUtils.nowInUserTimezone(timezoneid)));
                    entry.title=reger.core.Util.truncateString(overridecamphonesubjecttext, 255);
                } else {
                    entry.title=reger.core.Util.truncateString(subject, 255);
                }

                //If the title is blank, use the description
                if (entry.title==null || entry.title.equals("")) {
                    entry.title=reger.core.Util.truncateString(body ,255);
                }

                if (entry.title==null || entry.title.equals("")){
                    entry.title=reger.core.Util.truncateString(subject, 255);
                }

                if (entry.title==null || entry.title.equals("")){
                    entry.title="Email Post";
                }

                //Set the comments
                if (mailtype==CAMPHONEPOST && ignorecamphonebody==1){
                    entry.comments="";
                } else {
                    entry.comments=body;
                }

                //Set the draft/live status
                if (mailtype==CAMPHONEPOST && savecamphonepostsasdraft==1){
                    entry.isDraft = 1;
                } else if (mailtype==EMAILPOST && saveemailpostsasdraft==1){
                    entry.isDraft = 1;
                } else {
                    entry.isDraft = 0;
                }

                entry.isApproved=1;

                //Set the logid
                entry.logid=logid;



                //Populate the date/time vars in the event object
                entry.dateGmt = reger.core.TimeUtils.nowInGmtCalendar();

                //Set the author in the EmailApi posts.
                entry.accountuserid = accountuserid;

                //Create or find the entry
                if (mailtype==EMAILPOST || (mailtype==CAMPHONEPOST && consolidatecamphonetoonedailyentry==0)){
                    try{
                        //Save the entry to the database
                        entry.newEntryTemporary(accountOfEntry, accountuserOfPersonAccessing);
                        entry.editEntryAll(accountOfEntry, accountuserOfPersonAccessing, plOfEntry);
                    } catch (ValidationException error){
                        //@todo Handle the exception and send it back to user via email?
                        Debug.debug(3, "EmailApi", "EmailApi Error:" + error.getErrorsAsSingleString());
                    }

                } else {
                    //Do camphone consolidation of entries into one daily entry.
                    //All I need to do is find an entry today... or create one.
                    //I need to know the GMT time of the start of today in the user's timezone.
                    //I have tmpCal which is now in the user's timezone.
                    //Email comes in at servertime and must be converted usertime first.
                    //Then inside of eventGeneric.java it's converted to GMT.
                    Calendar tmpCal = Calendar.getInstance();
                    tmpCal = reger.core.TimeUtils.convertFromOneTimeZoneToAnother(tmpCal, tmpCal.getTimeZone().getID(), timezoneid);


                    //So I should set that time to 00:00:00 in their timezone.
                    Calendar startOfDay = reger.core.TimeUtils.xDaysAgoStart(tmpCal, 0);

                    //And then convert that value to GMT.
                    System.out.println("EmailApi.java +++++++=======+++++++=======");
                    System.out.println("EmailApi.java +++++++ dateformatfordb(startOfDay): " +reger.core.TimeUtils.dateformatfordb(startOfDay));
                    Calendar startOfDayGMT = reger.core.TimeUtils.usertogmttime(startOfDay, timezoneid);
                    System.out.println("EmailApi.java +++++++ dateformatfordb(startOfDayGMT): " +reger.core.TimeUtils.dateformatfordb(startOfDayGMT));

                    //And then do the same for the end of the day.
                    //Calendar endOfDay = reger.core.TimeUtils.xDaysAgoEnd(tmpCal, 0);

                    //And then convert that value to GMT.
                    //Calendar endOfDayGMT = reger.core.TimeUtils.usertogmttime(endOfDay, timezoneid);
                    Calendar endOfDayGMT = TimeUtils.AddOneDay(startOfDayGMT);

                    //Debug.debug(3, "EmailApi", "timezoneid:"+timezoneid+"<br>reger.core.TimeUtils.dateformatfordb(tmpCal): " +reger.core.TimeUtils.dateformatfordb(tmpCal)+ "<br>reger.core.TimeUtils.dateformatfordb(startOfDay): " +reger.core.TimeUtils.dateformatfordb(startOfDay)+ "<br>reger.core.TimeUtils.dateformatfordb(startOfDayGMT):" + reger.core.TimeUtils.dateformatfordb(startOfDayGMT) + "<br>reger.core.TimeUtils.dateformatfordb(endOfDay): " + reger.core.TimeUtils.dateformatfordb(endOfDay) + "<br>reger.core.TimeUtils.dateformatfordb(endOfDayGMT): " + reger.core.TimeUtils.dateformatfordb(endOfDayGMT));

                    //And then search for an eventid within this range.
                    //-----------------------------------
                    //-----------------------------------
                    String[][] rstEventToday= Db.RunSQL("SELECT eventid FROM event WHERE date>'"+reger.core.TimeUtils.dateformatfordb(startOfDayGMT)+"' AND date<'"+reger.core.TimeUtils.dateformatfordb(endOfDayGMT)+"' AND logid='"+logid+"' AND accountid='"+accountid+"' AND title='"+reger.core.Util.cleanForSQL(overridecamphonesubjecttext)+"' ORDER BY eventid DESC LIMIT 0,1");
                    //-----------------------------------
                    //-----------------------------------
                    if (rstEventToday!=null && rstEventToday.length>0){
                        //And if there is one, set entry.eventid to it.
                        if (reger.core.Util.isinteger(rstEventToday[0][0])){
                            entry.eventid = Integer.parseInt(rstEventToday[0][0]);
                        }
                    } else {
                        try{
                            //And if there isn't one, create one with a call to entry.newEntryAll();
                            entry.newEntryTemporary(accountOfEntry, accountuserOfPersonAccessing);
                            entry.editEntryAll(accountOfEntry, accountuserOfPersonAccessing, plOfEntry);
                            Debug.debug(3, "EmailApi", "EmailApi.java - New eventid:" + entry.eventid);
                        } catch (ValidationException error){
                            //@todo Handle the exception and send it back to user via email?
                            Debug.debug(3, "EmailApi", "EmailApi.java - There was an error in EmailApi.java:" + error.getErrorsAsSingleString());
                            return;
                        }
                    }

                }

                //Debug
                //for(int i=0; i<multiPart.getCount(); i++){
                    //BodyPart bodyPart = multiPart.getBodyPart(i);
                    //reger.core.Util.debug(5, "EmailApi.java<br>bodyPart.getContentType()="+bodyPart.getContentType()+"<br>(String)bodyPart.getContent()="+(String)bodyPart.getContent());
                //}

                Debug.debug(3, "EmailApi", "EmailApi.java - newPost() Ready to start processing attachments.");

                //Deal with attachments
                if (isMultipart){
                    for(int i=0; i<multiPart.getCount(); i++){
                        findAttachments(multiPart.getBodyPart(i), entry.eventid);
                    }
                }

                Debug.debug(3, "EmailApi", "EmailApi.java - newPost() Done processing attachments.");
            }

        } catch (Exception e) {
            Debug.errorsave(e, "EmailApi");
        }

    }

    private void findAttachments(BodyPart bodyPart, int eventid){
        try {
            Debug.debug(3, "EmailApi", "bodyPart.getContentType()=" + bodyPart.getContentType() + "<br>Deciding whether to treat as an attachment.");
            if (bodyPart.getFileName()!=null && !bodyPart.getFileName().equals("")){
                Debug.debug(3, "EmailApi", "Filename is not null");
                treatBodyPartAsAttachment(eventid, bodyPart);
            } else if (bodyPart.getContentType().toLowerCase().indexOf("multipart")>-1){
                Debug.debug(3, "EmailApi", "Is multipart");
                MimeMultipart nestedMultiPart = (MimeMultipart)bodyPart.getContent();
                for(int i=0; i<nestedMultiPart.getCount(); i++){
                    findAttachments(nestedMultiPart.getBodyPart(i), eventid);
                }
            } else if (bodyPart.getContentType().toLowerCase().indexOf("image")>-1){
                Debug.debug(3, "EmailApi", "Is image... will treat as a body part");
                treatBodyPartAsAttachment(eventid, bodyPart);
            } else if (bodyPart.getContentType().toLowerCase().indexOf("message")>-1){
                Debug.debug(3, "EmailApi", "Is message");
                MimeMessage nestedMsg = (MimeMessage)bodyPart.getContent();
                if (nestedMsg.getContentType().toLowerCase().indexOf("multipart")>-1){
                    Debug.debug(3, "EmailApi", "Is message with multipart");
                    javax.mail.internet.MimePartDataSource mpds = new javax.mail.internet.MimePartDataSource(nestedMsg);
                    MimeMultipart nestedMultiPart = new javax.mail.internet.MimeMultipart(mpds);
                    for(int i=0; i<nestedMultiPart.getCount(); i++){
                        findAttachments(nestedMultiPart.getBodyPart(i), eventid);
                    }
                }
            } else {
                Debug.debug(3, "EmailApi", "Not treating bodyPart as an attachment.");
            }
        } catch (Exception e){
            Debug.errorsave(e, "EmailApi");
        }
    }

    /**
     * This method attaches all attachments from a message to an event.
     * @param eventid
     */
    public boolean treatBodyPartAsAttachment(int eventid, BodyPart bodyPart) {

        try {
            //Start with the #1, not #0 (which is the main body)
            //for(int i=1; i<multiPart.getCount(); i++){
                //if (bodyPart.equals()){
                    int contentlength=0;
                    String filename="";
                    byte[] bits = new byte[0];


                    //Get the filename
                    filename = bodyPart.getFileName();

                    Debug.debug(3, "EmailApi", "About to decode multipart.bodyPart with filename=" + filename);




                    //Make sure there's enough space left for this user
                    //Get the size of the incoming file
                    contentlength=bits.length - 1;
                    reger.Account acct = new reger.Account(accountid);
                    long freespace = acct.getFreespace();
                    if ((long)contentlength>freespace) {
                        Debug.debug(3, "EmailApi", "Failed due to freeSpace limitations.<br>contentlength=" + contentlength + "<br>freeSpace=" + freespace);

                        return false;
                    }

                    //Figure out a filename
                    String incomingname = filename;
                    String incomingnamebase = reger.core.Util.getFilenameBase(incomingname);
                    String incomingnameext = reger.core.Util.getFilenameExtension(incomingname);

                    //Calculate the new dated directory name
                    Calendar cal = Calendar.getInstance();
                    int year = cal.get(Calendar.YEAR);
                    int month = cal.get(Calendar.MONTH)+1;
                    String monthStr = String.valueOf(month);
                    if (monthStr.length()==1){
                        monthStr = "0"+monthStr;
                    }
                    String datedDirectoryName = year+"/"+monthStr;

                    //Create directory
                    String filesdirectory = acct.getPathToAccountFiles() + datedDirectoryName + "/";
                    File dir = new File(filesdirectory);
                    dir.mkdirs();
                    File dirThumbs = new File(filesdirectory+".thumbnails/");
                    dirThumbs.mkdirs();

                    //Test for file existence... if it exists does, add an incrementer
                    String finalfilename = incomingname;
                    File savedFile  = new File(filesdirectory, finalfilename);
                    int incrementer = 0;
                    while (savedFile.exists()){
                        incrementer=incrementer+1;
                        finalfilename = incomingnamebase+"-"+incrementer;
                        if (!incomingnameext.equals("")){
                            finalfilename = finalfilename + "." + incomingnameext;
                        }
                        savedFile  = new File(filesdirectory, finalfilename);
                    }

                    Debug.debug(3, "EmailApi", "finalfilename="+datedDirectoryName+"/"+finalfilename);


                     //Save the file with the updated filename
                     //Turn the content into an inputstream
                     FileOutputStream fileOut = new FileOutputStream(savedFile);
                     try{
                         if (bodyPart.getContent().getClass().getName().equals("java.awt.image.BufferedImage")){
                            Debug.debug(3, "EmailApi", "bodyPart.getContent().getClass().getName().equals(\"java.awt.image.BufferedImage\") = true");
                            BufferedImage bi = (BufferedImage)bodyPart.getContent();
                            ImageIO.write(bi, getImageFormatName(bi), fileOut);

                         } else {
                             Debug.debug(3, "EmailApi", "bodyPart.getContent().getClass().getName().equals(\"java.awt.image.BufferedImage\") = false");
                             java.io.InputStream is = (java.io.InputStream)bodyPart.getContent();
                             byte[] buffer = new byte[64000];
                             int read = 0;
                             while(read != -1){
                                read = is.read(buffer,0,buffer.length);
                                if(read!=-1){
                                    fileOut.write(buffer,0,read);
                                }
                             }
                             fileOut.flush();
                             is.close();
                         }
                     } catch (java.lang.ClassCastException ccex){
                        Debug.errorsave(ccex, "Error saving file from EmailApi");
                     }
                     fileOut.close();

                    ThumbnailCreator.createThumbnail(savedFile);

                    Debug.debug(3, "EmailApi", "File should be saved to filesystem now.="+finalfilename);


                    //Get now in user's timezone
                    Calendar tmpCal = Calendar.getInstance();
                    tmpCal = reger.core.TimeUtils.convertFromOneTimeZoneToAnother(tmpCal, tmpCal.getTimeZone().getID(), timezoneid);
                    //Author and timestamp in subject
                    String timestamp = reger.core.TimeUtils.dateformatcompactwithtime(tmpCal);
                    String authtimestamp = " (" + friendlyname + " - " + timestamp + ")";

                    //Finalize the subject
                    String finalsubject = "";
                    if (subject!=null){
                            finalsubject = finalsubject + subject;
                    }
                    finalsubject=finalsubject + authtimestamp;

                    //-----------------------------------
                    //-----------------------------------
                    int imageid = Db.RunSQLInsert("INSERT INTO image(eventid, image, sizeinbytes, description, originalfilename, accountid, filename) VALUES('"+eventid+"', '"+reger.core.Util.cleanForSQL(datedDirectoryName+"/"+finalfilename)+"', '"+bits.length+"', '"+reger.core.Util.cleanForSQL(finalsubject)+"', '"+reger.core.Util.cleanForSQL(incomingname)+"', '"+accountid+"', '"+reger.core.Util.cleanForSQL(datedDirectoryName+"/"+finalfilename)+"')");
                    //-----------------------------------
                    //-----------------------------------

                    //Get a MediaType handler
                    MediaType mt = MediaTypeFactory.getHandlerByFileExtension(incomingnameext);
                    //Handle any parsing required
                    mt.saveToDatabase(filesdirectory+finalfilename, imageid);

                    //Do the imagetags
                    reger.Tag.addMultipleTagsToImage(camphoneimagetags, imageid);

                    //Refresh entry cache
                    reger.cache.EntryCache.flush(eventid);

                    Debug.debug(3, "EmailApi", "Imageid="+imageid);
                //}
            //}

        } catch (Exception e) {
            Debug.errorsave(e, "");
            return false;
        }
        return true;

    }

    private static String getImageFormatName(Object o) {
        try {
            // Create an image input stream on the image
            ImageInputStream iis = ImageIO.createImageInputStream(o);

            // Find all image readers that recognize the image format
            Iterator iter = ImageIO.getImageReaders(iis);
            if (!iter.hasNext()) {
                // No readers found
                return null;
            }

            // Use the first reader
            ImageReader reader = (ImageReader)iter.next();

            // Close stream
            iis.close();

            // Return the format name
            return reader.getFormatName();
        } catch (Exception e) {
            Debug.errorsave(e, "EmailApi");
            return "jpeg";
        }
    }


}
