package reger;

import reger.core.db.Db;
import reger.core.Debug;
import reger.core.ValidationException;
import reger.groups.Group;
import reger.groups.GroupMembership;

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
                String[][] rstGroups= Db.RunSQL("SELECT groupid FROM friendinvitationgroup WHERE friendinvitationid='"+friendinvitationid+"'");
                //-----------------------------------
                //-----------------------------------
                if (rstGroups!=null && rstGroups.length>0){
                    mb.append("<br><br>You have been invited to the following groups, which you can find by clicking the <a href='groups.log'>Groups tab</a>:<br><br>");
                    for(int i=0; i<rstGroups.length; i++){
                        Group group = new Group(Integer.parseInt(rstGroups[i][0]));
                        mb.append("> "+group.getName()+"<br>");
                        GroupMembership groupMembership = new GroupMembership();
                        groupMembership.setAccountuserid(au.getAccountuserid());
                        groupMembership.setGroupid(group.getGroupid());
                        if (group.getMembershipismoderated()){
                            if (group.getAccountuserid()==invitationSender.getAccountuserid()){
                                groupMembership.setIsapproved(true);
                            } else {
                                groupMembership.setIsapproved(false);
                            }
                        } else {
                            groupMembership.setIsapproved(true);
                        }
                        groupMembership.setIsmoderator(false);
                        groupMembership.setSharemembershippublicly(true);
                        try{
                            groupMembership.save();
                        } catch (ValidationException vex){
                            reger.core.Debug.logtodb(vex.getErrorsAsSingleString(), "InvitationProcessor.java");
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
