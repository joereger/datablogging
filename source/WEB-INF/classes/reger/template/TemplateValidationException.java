package reger.template;

/**
 * Catches validation errors in template validation
 */
public class TemplateValidationException extends Throwable{

    private String validationError;

    public String getError(){
        return validationError;
    }

    public void setError(String validationError){
        this.validationError = validationError;
    }

}
