package reger;

import reger.core.db.Db;
import reger.core.Debug;

/**
 * Processes accepted invitations
 */
public class InvitationProcessor {

    public static void process(reger.Accountuser au, int friendinvitationid, String friendinvitationkey){
        StringBuffer mb = new StringBuffer();

        reger.Accountuser invitationSender = new reger.Accountuser(-1);

        //Pull up the details of the invitation
        //-----------------------------------
        //-----------------------------------
        String[][] rstInvitation= Db.RunSQL("SELECT accountuseridsource, friendinvitationkey FROM friendinvitation WHERE friendinvitationid='"+friendinvitationid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstInvitation!=null && rstInvitation.length>0){
            //The friendinvitationkey must be valid
            if (friendinvitationkey.equals(rstInvitation[0][1])){

                //Congrats
                mb.append("(This is an automated message.)<br><br>");
                mb.append("Congratulations on accepting the weblogging invitation!<br><br>");

                //Create the friend relationship from the new user to the inviter
                au.addFriend(Integer.parseInt(rstInvitation[0][0]));
                mb.append("A friend link has been made between us.  You can see your list of friends in the People tab of the My Home section.<br><br>");

                //Create the friend relationship from the inviter to the new user
                invitationSender = new reger.Accountuser(Integer.parseInt(rstInvitation[0][0]), true);
                invitationSender.addFriend(au.getAccountuserid());

                //Update the status of the invitation
                //-----------------------------------
                //-----------------------------------
                int count = Db.RunSQLUpdate("UPDATE friendinvitation SET status='"+reger.Vars.INVITATIONSTATUSACCEPTED+"', accountuseridtarget='"+au.getAccountuserid()+"' WHERE friendinvitationid='"+friendinvitationid+"'");
                //-----------------------------------
                //-----------------------------------

                //Grant special log access
                //-----------------------------------
                //-----------------------------------
                String[][] rstLogs= Db.RunSQL("SELECT megalog.logid, megalog.name, friendinvitationlogid.canread, friendinvitationlogid.canwrite FROM friendinvitationlogid, megalog WHERE friendinvitationlogid.logid=megalog.logid AND friendinvitationid='"+friendinvitationid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstLogs!=null && rstLogs.length>0){
                    mb.append("You have been given permission to the following logs which you can find by clicking the My Privileges link at the top of the screen:<br><br>");
                    for(int i=0; i<rstLogs.length; i++){
                        //Read access
                        if (rstLogs[i][2].equals("1")){
                            au.grantLogAccess(Integer.parseInt(rstLogs[i][0]));
                        }
                        //Write access
                        if (rstLogs[i][3].equals("1")){
                            au.grantLogAuthoring(Integer.parseInt(rstLogs[i][0]));
                        }
                        //User messaging
                        mb.append("> " + rstLogs[i][1] + "<br>");
                    }
                }

                //Handle Log Types
                //-----------------------------------
                //-----------------------------------
                String[][] rstLogTypes= Db.RunSQL("SELECT megalogtype.eventtypeid, megalogtype.megalogname FROM friendinvitationeventtypeid, megalogtype WHERE friendinvitationeventtypeid.eventtypeid=megalogtype.eventtypeid AND friendinvitationid='"+friendinvitationid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstLogTypes!=null && rstLogTypes.length>0){
                    mb.append("You have been invited to the following log types:<br><br>");
                    for(int i=0; i<rstLogTypes.length; i++){

                         mb.append("> <a href='logs-newlog-detail.log?eventtypeid="+rstLogTypes[i][0]+"'>" + rstLogTypes[i][1] + "</a><br>");
                    }
                }

                //Grant special group access
                //-----------------------------------
                //-----------------------------------
                String[][] rstGroups= Db.RunSQL("SELECT groupsubscriptionid FROM friendinvitationgroupsubscriptionid WHERE friendinvitationid='"+friendinvitationid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstGroups!=null && rstGroups.length>0){

                    mb.append("<br><br>You have been given read permission to the following groups, which you can find by clicking the Groups tab at the top of the page:<br><br>");

                    for(int i=0; i<rstGroups.length; i++){
                        //Select the details of the server for this groupsubscription
                        //-----------------------------------
                        //-----------------------------------
                        String[][] rstGpSub= Db.RunSQL("SELECT serverurl, serverkey, groupid, groupname, groupdescription, feedurlofgroup, weburlofgroup, groupkey, viewingentriesrequiresgroupkey, addingentriesrequiresgroupkey FROM groupsubscription, groupserversubscription WHERE groupsubscriptionid='"+rstGroups[i][0]+"' AND groupsubscription.groupserversubscriptionid=groupserversubscription.groupserversubscriptionid");
                        //-----------------------------------
                        //-----------------------------------
                        if (rstGpSub!=null && rstGpSub.length>0){
                            int groupserversubscriptionid = -1;
                            Debug.debug(5, "", "InvitationProcessor.java - Seeing if user has a proper groupserversubscription.");
                            //See if the user has this server and set the groupserversubscriptionid
                            //-----------------------------------
                            //-----------------------------------
                            String[][] rstChkSrvr= Db.RunSQL("SELECT groupserversubscriptionid FROM groupserversubscription WHERE accountuserid='"+au.getAccountuserid()+"' AND serverurl='"+reger.core.Util.cleanForSQL(rstGpSub[0][0])+"'");
                            //-----------------------------------
                            //-----------------------------------
                            if (rstChkSrvr!=null && rstChkSrvr.length>0){
                                //They do have this server already, so set the value
                                groupserversubscriptionid = Integer.parseInt(rstChkSrvr[0][0]);
                                Debug.debug(5, "", "InvitationProcessor.java - They have this groupserversubscriptionid already.");
                            } else {
                                //Got to create a new groupserversubscription
                                //-----------------------------------
                                //-----------------------------------
                                groupserversubscriptionid = Db.RunSQLInsert("INSERT INTO groupserversubscription(accountuserid, serverurl, serverkey) VALUES('"+au.getAccountuserid()+"', '"+reger.core.Util.cleanForSQL(rstGpSub[0][0])+"', '"+reger.core.Util.cleanForSQL(rstGpSub[0][1])+"')");
                                //-----------------------------------
                                //-----------------------------------
                                Debug.debug(5, "", "InvitationProcessor.java - They did not have this groupserversubscription yet.  Created it.");
                            }

                            //See if this user has the groupsubscription with this serverurl
                            //-----------------------------------
                            //-----------------------------------
                            String[][] rstChkGpSub= Db.RunSQL("SELECT groupsubscriptionid FROM groupsubscription, groupserversubscription WHERE groupsubscription.groupserversubscriptionid=groupserversubscription.groupserversubscriptionid AND groupserversubscription.groupserversubscriptionid='"+groupserversubscriptionid+"' AND groupsubscription.groupid='"+rstGpSub[0][2]+"'");
                            //-----------------------------------
                            //-----------------------------------
                            if (rstChkGpSub!=null && rstChkGpSub.length>0){
                                //The user already has this groupsubscription so we need to see if we should update the groupkey by passing an xml call to the server
                                if (reger.GroupsClient.testGroupKey(Integer.parseInt(rstGpSub[0][2]), rstGpSub[0][7], rstGpSub[0][0])){
                                    //The groupkey is good, update it
                                    //-----------------------------------
                                    //-----------------------------------
                                    int count2 = Db.RunSQLUpdate("UPDATE groupsubscription SET groupkey='"+rstGpSub[0][7]+"' WHERE groupsubscriptionid='"+rstChkGpSub[0][0]+"'");
                                    //-----------------------------------
                                    //-----------------------------------
                                    mb.append("> " + rstGpSub[0][3]+"<br>");
                                    Debug.debug(5, "", "InvitationProcessor.java - Added group by updating keys. groupsubscriptionid=" + rstChkGpSub[0][0]);
                                } else {
                                    //The groupkey is no good so do nothing
                                }
                            } else {
                                //Now, create the groupsubscription for the user
                                //-----------------------------------
                                //-----------------------------------
                                int groupsubscriptionid = Db.RunSQLInsert("INSERT INTO groupsubscription(accountuserid, groupserversubscriptionid, groupid, groupname, groupdescription, feedurlofgroup, weburlofgroup, viewingentriesrequiresgroupkey, addingentriesrequiresgroupkey, groupkey, groupadminkey) VALUES('"+au.getAccountuserid()+"', '"+groupserversubscriptionid+"', '"+Integer.parseInt(rstGpSub[0][2])+"', '"+reger.core.Util.cleanForSQL(reger.core.Util.truncateString(rstGpSub[0][3], 255))+"', '"+reger.core.Util.cleanForSQL(reger.core.Util.truncateString(rstGpSub[0][4], 255))+"', '"+reger.core.Util.cleanForSQL(reger.core.Util.truncateString(rstGpSub[0][5], 255))+"', '"+reger.core.Util.cleanForSQL(reger.core.Util.truncateString(rstGpSub[0][6], 255))+"', '"+rstGpSub[0][8]+"', '"+rstGpSub[0][9]+"', '"+reger.core.Util.cleanForSQL(reger.core.Util.truncateString(rstGpSub[0][7], 255))+"', '')");
                                //-----------------------------------
                                //-----------------------------------
                                mb.append(">" + rstGpSub[0][3]+"<br>");
                                Debug.debug(5, "", "InvitationProcessor.java - Added group by creating groupsubscription.");
                            }


                        }
                    }
                }

                mb.append("<br><br>Enjoy!");

                //Create an inbox message
               reger.FriendMessage message = new reger.FriendMessage();
               int[] recipients = new int[1];
               recipients[0] = au.getAccountuserid();
               message.newMessage(invitationSender.getAccountuserid(), recipients, "Invitation Accepted!", mb.toString());


            }
        }


    }



}
