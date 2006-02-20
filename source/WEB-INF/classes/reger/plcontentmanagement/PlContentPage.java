package reger.plcontentmanagement;

import reger.nestednav.NestedNavItem;
import reger.core.db.Db;
import reger.PrivateLabel;
import reger.Accountuser;
import reger.cache.providers.jboss.Cacheable;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * This class models a content page.
 */
@Cacheable
public class PlContentPage implements NestedNavItem{

    private int plcontentpageid =0;
    private int plid=0;
    private String name="";
    private String content="";
    private int nestednavparenttype=NestedNavItem.NESTEDNAVITEMBASE;
    private int nestednavparentid=0;
    private int nestednavorder=0;

    public PlContentPage(int plcontentpageid){
        this.plcontentpageid = plcontentpageid;
        load();
    }

    public PlContentPage(int plid, String name, String content, int nestednavparenttype, int nestednavparentid, int nestednavorder){
        this.plid=plid;
        this.name=name;
        this.content=content;
        this.nestednavparenttype=nestednavparenttype;
        this.nestednavparentid=nestednavparentid;
        this.nestednavorder=nestednavorder;
    }

    public PlContentPage(){

    }

    public void load(){
        //-----------------------------------
        //-----------------------------------
        String[][] rstCp= Db.RunSQL("SELECT plcontentpageid, plid, name, content, nestednavparenttype, nestednavparentid, nestednavorder FROM plcontentpage WHERE plcontentpageid='"+this.plcontentpageid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstCp!=null && rstCp.length>0){
            for(int i=0; i<rstCp.length; i++){
                this.plid=Integer.parseInt(rstCp[i][1]);
                this.name=rstCp[i][2];
                this.content=rstCp[i][3];
                this.nestednavparenttype=Integer.parseInt(rstCp[i][4]);
                this.nestednavparentid=Integer.parseInt(rstCp[i][5]);
                this.nestednavorder=Integer.parseInt(rstCp[i][6]);
            }
        }
    }


    public void save(){
        if (name.equals("")){
            name="Content Page";
        }

        //-----------------------------------
        //-----------------------------------
        String[][] rstPlCont= Db.RunSQL("SELECT plcontentpageid FROM plcontentpage WHERE plcontentpageid='"+plcontentpageid +"'");
        //-----------------------------------
        //-----------------------------------
        if (rstPlCont!=null && rstPlCont.length>0){
            //-----------------------------------
            //-----------------------------------
            int count = Db.RunSQLUpdate("UPDATE plcontentpage SET plid='"+plid+"', name='"+reger.core.Util.cleanForSQL(name)+"', content='"+reger.core.Util.cleanForSQL(content)+"', nestednavparenttype='"+nestednavparenttype+"', nestednavparentid='"+nestednavparentid+"', nestednavorder='"+nestednavorder+"' WHERE plcontentpageid='"+plcontentpageid +"'");
            //-----------------------------------
            //-----------------------------------
        } else {
            //Set ordering info by finding all on first level and getting highest
            PrivateLabel pl = new PrivateLabel(plid);
            reger.nestednav.NestedNavCollection collection = pl.getNestedNavCollection();
            ArrayList<NestedNavItem> topLevelNavItems = collection.getAllChildrenApplyNoPermissions(new reger.nestednav.NestedNavItemBase());
            int currentMaxOrder = reger.nestednav.NestedNavCollection.getMaxOrder(topLevelNavItems);
            this.nestednavorder = currentMaxOrder + 1;

            //-----------------------------------
            //-----------------------------------
            plcontentpageid = Db.RunSQLInsert("INSERT INTO plcontentpage(plid, name, content, nestednavparenttype, nestednavparentid, nestednavorder) VALUES('"+plid+"', '"+reger.core.Util.cleanForSQL(name)+"', '"+reger.core.Util.cleanForSQL(content)+"', '"+nestednavparenttype+"', '"+nestednavparentid+"', '"+nestednavorder+"')");
            //-----------------------------------
            //-----------------------------------

        }


    }


    public void delete(){
        //Shift order of nav items appropriately
        PrivateLabel pl = new PrivateLabel(plid);
        pl.getNestedNavCollection().adjustAfterRemovalOfItem(NESTEDNAVTYPEPLCONTENTPAGE, plcontentpageid);

        //Delete the record
        //-----------------------------------
        //-----------------------------------
        int count = Db.RunSQLUpdate("DELETE FROM plcontentpage WHERE plcontentpageid='"+plcontentpageid +"'");
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
        return "plcontentpage.log?plcontentpageid="+plcontentpageid;
    }

    /**
     * This type.  Either NestedNavItem.NESTEDNAVTYPEMEGALOG or NestedNavItem.NESTEDNAVTYPECONTENTPAGE
     */
    public int getThisNestedNavType() {
        return NestedNavItem.NESTEDNAVTYPEPLCONTENTPAGE;
    }

    /**
     * The database unique id of this item.  This is either the logid or the plcontentpageid
     */
    public int getThisNestedNavId() {
        return plcontentpageid;
    }

    /**
     * The type of parent that this is under.  0 if under none.  Either NestedNavItem.NESTEDNAVTYPEMEGALOG or NestedNavItem.NESTEDNAVTYPECONTENTPAGE.
     */
    public int getNestedNavParentType() {
        return nestednavparenttype;
    }

    /**
     * The database unique id of the parent item. 0 if under none.  This is either the logid or the plcontentpageid
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
        if (request.getParameter("plcontentpageid")!=null && reger.core.Util.isinteger(request.getParameter("plcontentpageid"))){
            if (Integer.parseInt(request.getParameter("plcontentpageid"))==plcontentpageid){
                return true;
            }
        }
        return false;
    }

    /**
     * Whether the accountuser provided can view this item
     */
    public boolean userCanAdministerNavItem(Accountuser accountUser){

        return true;
    }


    public int getPlcontentpageid() {
        return plcontentpageid;
    }

    public void setPlcontentpageid(int plcontentpageid) {
        this.plcontentpageid = plcontentpageid;
    }

    public int getPlid() {
        return plid;
    }

    public void setPlid(int plid) {
        this.plid = plid;
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



}
