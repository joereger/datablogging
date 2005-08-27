package reger;

import reger.nestednav.NestedNavItem;
import reger.core.db.Db;

import javax.servlet.http.HttpServletRequest;

/**
 * This class models a content page.
 */
public class ContentPage implements NestedNavItem{

    private int contentpageid=0;
    private int accountid=0;
    private String name="";
    private String content="";
    private int nestednavparenttype=NestedNavItem.NESTEDNAVITEMBASE;
    private int nestednavparentid=0;
    private int nestednavorder=0;
    private int sizeinbytes = 0;

    public ContentPage(int contentpageid){
        this.contentpageid = contentpageid;
        load();
    }

    public ContentPage(int accountid, String name, String content, int nestednavparenttype, int nestednavparentid, int nestednavorder){
        this.accountid=accountid;
        this.name=name;
        this.content=content;
        this.nestednavparenttype=nestednavparenttype;
        this.nestednavparentid=nestednavparentid;
        this.nestednavorder=nestednavorder;
    }

    public ContentPage(){

    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstCp= Db.RunSQL("SELECT contentpageid, accountid, name, content, nestednavparenttype, nestednavparentid, nestednavorder, sizeinbytes FROM contentpage WHERE contentpageid='"+this.contentpageid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstCp!=null && rstCp.length>0){
            for(int i=0; i<rstCp.length; i++){
                this.accountid=Integer.parseInt(rstCp[i][1]);
                this.name=rstCp[i][2];
                this.content=rstCp[i][3];
                this.nestednavparenttype=Integer.parseInt(rstCp[i][4]);
                this.nestednavparentid=Integer.parseInt(rstCp[i][5]);
                this.nestednavorder=Integer.parseInt(rstCp[i][6]);
                this.sizeinbytes=Integer.parseInt(rstCp[i][7]);
            }
        }
    }


    public void save(){
        if (name.equals("")){
            name="Content Page";
        }

        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("UPDATE contentpage SET accountid='"+accountid+"', name='"+reger.core.Util.cleanForSQL(name)+"', content='"+reger.core.Util.cleanForSQL(content)+"', nestednavparenttype='"+nestednavparenttype+"', nestednavparentid='"+nestednavparentid+"', nestednavorder='"+nestednavorder+"', sizeinbytes='"+sizeinbytes+"' WHERE contentpageid='"+contentpageid+"'");
        //-----------------------------------
        //-----------------------------------
        if (count<1){
            //Set ordering info by finding all on first level and getting highest
            reger.Account account = new Account(accountid);
            reger.nestednav.NestedNavCollection collection = account.getNestedNavCollection();
            reger.nestednav.NestedNavItem[] topLevelNavItems = collection.getAllChildrenApplyNoPermissions(new reger.nestednav.NestedNavItemBase());
            int currentMaxOrder = reger.nestednav.NestedNavCollection.getMaxOrder(topLevelNavItems);
            this.nestednavorder = currentMaxOrder + 1;

            //Measure the size in bytes
            this.sizeinbytes = reger.core.Util.sizeInBytes(content);

            //-----------------------------------
            //-----------------------------------
            contentpageid = Db.RunSQLInsert("INSERT INTO contentpage(accountid, name, content, nestednavparenttype, nestednavparentid, nestednavorder, sizeinbytes) VALUES('"+accountid+"', '"+reger.core.Util.cleanForSQL(name)+"', '"+reger.core.Util.cleanForSQL(content)+"', '"+nestednavparenttype+"', '"+nestednavparentid+"', '"+nestednavorder+"', '"+sizeinbytes+"')");
            //-----------------------------------
            //-----------------------------------
        }
    }


    public void delete(){
        //Shift order of nav items appropriately
        Account acct = new reger.Account(accountid);
        acct.getNestedNavCollection().adjustAfterRemovalOfItem(NESTEDNAVTYPECONTENTPAGE, contentpageid);

        //Delete the record
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM contentpage WHERE contentpageid='"+contentpageid+"'");
        //-----------------------------------
        //-----------------------------------
    }









    /**
     * The text that should appear in the navigation bar
     */
    public String getNestedNavLinkText() {
        return name;
    }

    /**
     * The url that this item should link to
     */
    public String getNestedNavLinkUrl() {
        return "contentpage"+contentpageid+".log";
    }

    /**
     * This type.  Either NestedNavItem.NESTEDNAVTYPEMEGALOG or NestedNavItem.NESTEDNAVTYPECONTENTPAGE
     */
    public int getThisNestedNavType() {
        return NestedNavItem.NESTEDNAVTYPECONTENTPAGE;
    }

    /**
     * The database unique id of this item.  This is either the logid or the contentpageid
     */
    public int getThisNestedNavId() {
        return contentpageid;
    }

    /**
     * The type of parent that this is under.  0 if under none.  Either NestedNavItem.NESTEDNAVTYPEMEGALOG or NestedNavItem.NESTEDNAVTYPECONTENTPAGE.
     */
    public int getNestedNavParentType() {
        return nestednavparenttype;
    }

    /**
     * The database unique id of the parent item. 0 if under none.  This is either the logid or the contentpageid
     */
    public int getNestedNavParentId() {
        return nestednavparentid;
    }

    /**
     * The numeric order of the item.  1 is first in the list.
     */
    public int getNestedNavOrder() {
        return nestednavorder;
    }

    /**
     * Move this item down one by changing its order property, increasing it one.  Keeping same parent.
     */
    public void moveNestedNavDown() {
        nestednavorder = nestednavorder + 1;
        save();
    }

    /**
     * Move this item up one by changing its order property, decreasing it one. Keeping same parent.
     */
    public void moveNestedNavUp() {
        nestednavorder = nestednavorder - 1;
        save();
    }

    /**
     * Move to a specified spot on the nav scheme
     */
    public void moveNestedNavTo(int parentType, int parentId, int order) {
        nestednavparenttype = parentType;
        nestednavparentid = parentId;
        nestednavorder = order;
        save();
    }

    /**
     * Whether the accountuser provided can view this item
     */
    public boolean userCanViewNavItem(Accountuser accountUser) {
        return true;
    }

    /**
     * Whether or not this nav item should be considered on/active or not
     */
    public boolean isActive(HttpServletRequest request) {
        if (request.getParameter("contentpageid")!=null && reger.core.Util.isinteger(request.getParameter("contentpageid"))){
            if (Integer.parseInt(request.getParameter("contentpageid"))==contentpageid){
                return true;
            }
        }
        return false;
    }

    /**
     * Whether the accountuser provided can view this item
     */
    public boolean userCanAdministerNavItem(Accountuser accountUser){
        //-----------------------------------
        //-----------------------------------
        String[][] rstGp= Db.RunSQL("SELECT accountid FROM contentpage WHERE contentpageid='"+contentpageid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstGp!=null && rstGp.length>0){
            for(int i=0; i<rstGp.length; i++){
                if (accountUser.userCanDoAcl("CUSTOMIZELOG", Integer.parseInt(rstGp[i][0]))){
                    return true;
                }
            }
        }
        return false;
    }


    public int getContentpageid() {
        return contentpageid;
    }

    public void setContentpageid(int contentpageid) {
        this.contentpageid = contentpageid;
    }

    public int getAccountid() {
        return accountid;
    }

    public void setAccountid(int accountid) {
        this.accountid = accountid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public int getSizeinbytes() {
        return sizeinbytes;
    }


}
