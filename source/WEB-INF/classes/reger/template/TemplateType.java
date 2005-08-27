package reger.template;

/**
 * A type of template like SiteTemplate or EntryTemplate
 */
public interface TemplateType {

    public String getTemplateTypeName();
    public String getDescription();

    /**
     * An array of those tags that are required to fulfill this template's requirements.
     */
    public SiteTemplateTag[] getRequiredTags();

    

}
