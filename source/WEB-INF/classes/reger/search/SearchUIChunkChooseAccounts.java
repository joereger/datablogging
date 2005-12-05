package reger.search;

import reger.core.Debug;

/**
 * Logid portion of searches
 */
public class SearchUIChunkChooseAccounts implements SearchUIChunk{

    public String getName(){
        return "Sites";
    }

    public String getUniqueIdentifier() {
        return "chunk-chooseaccounts";
    }

    public String getPageTitle(){
        return "Find Entries in These Weblog Sites:";
    }

    public StringBuffer getHtml(SearchEntries se, reger.UserSession userSession){
        StringBuffer mb = new StringBuffer();

        //This site box
        if (userSession.getAccount()!=null && userSession.getAccount().getAccountid()>0){
            String selectedTextThis = "";
            try{
                if (se.getSearchParameters().isAccountBeingSearched(userSession.getAccount().getAccountid()) || se.getSearchParameters().accountidsToSearch==null || se.getSearchParameters().accountidsToSearch.length<1){
                    selectedTextThis = " checked";
                }
            } catch (Exception e ){
                Debug.errorsave(e, "");
            }
            mb.append("<input type=radio name=accountids value="+userSession.getAccount().getAccountid()+" "+selectedTextThis+"> This Site Plus Any Friends' Sites Checked Below");
            mb.append("<br>");

            //Friends
            reger.Friend friend = new reger.Friend();
            int[] friendsAccountuserids = friend.getFriends(userSession.getAccountuser().getAccountuserid());
            if (friendsAccountuserids!=null){
                for (int i = 0; i < friendsAccountuserids.length; i++) {
                    reger.Accountuser tmpAccUser = new reger.Accountuser(friendsAccountuserids[i], true);
                    String selectedText = "";
                    try{
                        if (se.getSearchParameters().isAccountBeingSearched(tmpAccUser.getAccountid())){
                            selectedText = " checked";
                        }
                    } catch (Exception e ){
                        Debug.errorsave(e, "");
                    }
                    mb.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name=accountids value="+tmpAccUser.getAccountid()+" "+selectedText+"> " + tmpAccUser.getSiteRootUrlOfPrimaryAccount() );
                    mb.append("<br>");
                }
            } else {
                mb.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;No Friends defined yet.");
            }

        }



        //All sites box
        String selectedTextAll = "";
        try{
            if (se.getSearchParameters().isAccountBeingSearched(SearchParameters.ALL) || (userSession.getAccount()==null || userSession.getAccount().getAccountid()==0)){
                selectedTextAll = " checked";
            }
        } catch (Exception e ){
            Debug.errorsave(e, "");
        }
        mb.append("<br><br>");
        mb.append("<input type=radio name=accountids value="+SearchParameters.ALL+" "+selectedTextAll+"> All Sites");
        mb.append("<br><br>");
        mb.append("<br><br>");
        mb.append("<font face=arial size=-2>Note: By choosing to search this site and/or your friends' sites you will be able to choose specific logs in the next step.  If you choose to search all sites you will choose log types in the next step because it doesn't make sense to choose from a list of the thousands of possible logs on the server.</font>");



        return mb;
    }

    public SearchEntries processRequest(SearchEntries se, javax.servlet.http.HttpServletRequest request, reger.UserSession userSession){

        //Set the logs to null
        se.setAccountsToSearch(null);

        //See if the special value SearchParameters.ALL is incoming.
        //If so, simply add it alone to the array of accounts to search
        if (request.getParameterValues("accountids")!=null){
            String[] tmpVals = request.getParameterValues("accountids");
            for (int i = 0; i < tmpVals.length; i++) {
                if (reger.core.Util.isinteger(tmpVals[i])){
                    if (Integer.parseInt(tmpVals[i])==SearchParameters.ALL){
                        int[] accountids = new int[1];
                        accountids[0]=SearchParameters.ALL;
                        se.setAccountsToSearch(accountids);
                        return se;
                    }
                }
            }
        }

        //Get any new incoming accounts to search
        int[] accountids = null;
        if (request.getParameterValues("accountids")!=null && request.getParameterValues("accountids").length>0){
            for (int i = 0; i < request.getParameterValues("accountids").length; i++) {
                if (reger.core.Util.isinteger(request.getParameterValues("accountids")[i])){
                    if (Integer.parseInt(request.getParameterValues("accountids")[i])>0){
                        accountids = reger.core.Util.addToIntArray(accountids, Integer.parseInt(request.getParameterValues("accountids")[i]));
                    }
                }
            }
        }

        //Make the final assignment
        if (accountids!=null && accountids.length>0){
            se.setAccountsToSearch(accountids);
        }

        return se;
    }


}
