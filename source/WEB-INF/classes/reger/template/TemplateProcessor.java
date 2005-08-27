package reger.template;

/**
 *  Interface that defines the minimum requirement to be a template processor
 */
public interface TemplateProcessor {

    public TemplateTag[] getTagsThisProcessorCanHandle();

    public boolean validateTemplate(String template) throws TemplateValidationException;

    public int getType();

    public String getNameOfTypeOfTemplatesThisHandles();

    public String getDescriptionOfTypeOfTemplatesThisHandles();

    public String preview(Template template);

    public String getDefaultTemplate();

    public String getNameOfIconShowingHowTemplateWorks();

}
