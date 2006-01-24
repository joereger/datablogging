package reger.template;

import reger.Account;

/**
 * References a number of templates into a single set that the user can one-click.
 */
public class OneClickTemplateSet {

    private int oneClickTemplateSetid;
    private int siteTemplateid;
    private int entryListTemplateid;
    private int hpTemplateid;
    private String name;
    private String thumbnail;


    public OneClickTemplateSet(int oneClickTemplateSetid, int siteTemplateid, int entryListTemplateid, int hpTemplateid, String name, String thumbnail){
        this.oneClickTemplateSetid = oneClickTemplateSetid;
        this.siteTemplateid = siteTemplateid;
        this.entryListTemplateid = entryListTemplateid;
        this.hpTemplateid = hpTemplateid;
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public void setAccountToThisSet(int accountid){
        Account acct = reger.cache.AccountCache.get(accountid);
        //if (entryListTemplateid!=0){
            acct.setEntlisttemplateid(entryListTemplateid);
        //}
        //if (hpTemplateid!=0){
            acct.setHptemplateid(hpTemplateid);
        //}
        //if (siteTemplateid!=0){
            acct.setSitetemplateid(siteTemplateid);
        //}
        try{
            acct.save();
        } catch (reger.core.ValidationException valEx){
            reger.core.Debug.debug(5, "OneClickTemplateSet.java", "Problem setting oneclicktemplate on an account.");
        }
    }

    public int getOneClickTemplateSetid() {
        return oneClickTemplateSetid;
    }

    public void setOneClickTemplateSetid(int oneClickTemplateSetid) {
        this.oneClickTemplateSetid = oneClickTemplateSetid;
    }

    public int getSiteTemplateid() {
        return siteTemplateid;
    }

    public void setSiteTemplateid(int siteTemplateid) {
        this.siteTemplateid = siteTemplateid;
    }

    public int getEntryListTemplateid() {
        return entryListTemplateid;
    }

    public void setEntryListTemplateid(int entryListTemplateid) {
        this.entryListTemplateid = entryListTemplateid;
    }

    public int getHpTemplateid() {
        return hpTemplateid;
    }

    public void setHpTemplateid(int hpTemplateid) {
        this.hpTemplateid = hpTemplateid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
