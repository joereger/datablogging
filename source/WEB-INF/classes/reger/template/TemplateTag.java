package reger.template;

/**
 * The base requirements for a template tag
 */
public interface TemplateTag {


    /**
     *  The syntax required to put this tag into the page.
     *  Note: this is "Page.Title", not <$Page.Title$>
     */
    public String getSyntax();

    /**
     * Description of what this tag does when in a template.
     */
    public String getDescription();

    /**
     * Description of what this tag does when in a template.
     */
    public boolean isRequired();

    /**
     * Whether or not the tag will accept the current syntax
     */
    public boolean acceptsParticularSyntax(String tagExample);

    /**
     * Content used for previews of templates.
     */
    public String getPreview();

}
