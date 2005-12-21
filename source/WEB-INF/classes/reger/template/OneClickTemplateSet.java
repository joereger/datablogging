package reger.template;

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
