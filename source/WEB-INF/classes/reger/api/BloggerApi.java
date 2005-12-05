package reger.api;

import reger.core.db.Db;
import reger.Accountuser;
import reger.Account;

import java.util.Vector;
import java.util.Hashtable;
import java.util.Calendar;

public class BloggerApi {


    public BloggerApi(){

    }

    /**
     * getUserBlogs returns a list of logs for this account.
     */
    public Vector getUsersBlogs(String appkey, String username, String password) {

        //Try to log the user in
        Accountuser au = new reger.Accountuser(username, password);

        //Get the account
        Account account = new reger.Account(au.getAccountid());

        //Get this user's data
        int accountid = au.getAccountid();

        //Create the array to hold the log structs
        Vector logArray=new Vector();

        if (au.isLoggedIn){
            //-----------------------------------
            //-----------------------------------
            String[][] rstGetLogList= Db.RunSQL("SELECT logid, name, account.accountid FROM megalog, account WHERE account.accountid='"+ account.getAccountid() +"' AND megalog.accountid=account.accountid AND "+au.LogsUserCanAdministerQueryend(account.getAccountid())+"");
            //-----------------------------------
            //-----------------------------------
            if (rstGetLogList!=null && rstGetLogList.length>0){
                for(int i=0; i<rstGetLogList.length; i++){
                    //The struct that holds info on one web log
                    Hashtable ublogs = new Hashtable();

                    ublogs.put(String.valueOf("url"), "" + account.getSiteRootUrl() + "/");
                    ublogs.put(String.valueOf("blogid"), rstGetLogList[i][0]);
                    ublogs.put(String.valueOf("blogname"), rstGetLogList[i][1]);

                    //Add the usersblogs structure to the array
                    logArray.add(i, ublogs);
                }
            }
        }

        //Return the array of web logs
        return logArray;

    }

    /**
     * Get Recent Posts -  Simply a call to metaWebLogApi
     */
    public Vector getRecentPosts(String appkey, String blogid, String username, String password, int numberOfPosts){
        reger.api.MetaWebLogApi mw = new reger.api.MetaWebLogApi();
        return mw.getRecentPosts(blogid, username, password, numberOfPosts);
    }

    /**
     * New post -  Simply a call to metaWebLogApi
     */
    public String newPost(String appkey, String blogid, String username, String password, Hashtable content, boolean publish){
        reger.api.MetaWebLogApi mw = new reger.api.MetaWebLogApi();
        return mw.newPost(blogid, username, password, content, publish);
    }

    /**
     * Edit post -  Simply a call to metaWebLogApi
     */
    public boolean editPost(String appkey, String postid, String username, String password, Hashtable content, boolean publish){
        reger.api.MetaWebLogApi mw = new reger.api.MetaWebLogApi();
        return mw.editPost(postid, username, password, content, publish);
    }

    /**
     * Get post -  Simply a call to metaWebLogApi
     */
    public Hashtable getPostgetPost(String appkey, String postid, String username, String password){
        reger.api.MetaWebLogApi mw = new reger.api.MetaWebLogApi();
        return mw.getPost(postid, username, password);
    }


}
