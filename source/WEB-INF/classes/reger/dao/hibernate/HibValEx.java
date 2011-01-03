package reger.dao.hibernate;

import org.hibernate.HibernateException;

/**
 * A standard validation exception.
 */

public class HibValEx extends HibernateException {

    private String[] validationErrors = new String[0];

    public HibValEx(String validationError){
        super(validationError);
        addValidationError(validationError);
    }

    public String getErrorsAsSingleString(){
        StringBuffer mb = new StringBuffer();
        for (int i = 0; i < validationErrors.length; i++) {
            String validationError = validationErrors[i];
            mb.append(validationError + "<br>");
        }
        return mb.toString();
    }

    public void addErrorsFromAnotherValidationException(HibValEx errors){
        for (int i = 0; i < errors.getErrors().length; i++) {
            addValidationError(errors.getErrors()[i]);
        }
    }

    public String[] getErrors(){
        return validationErrors;
    }

    public void addValidationError(String validationError){
        if (!validationError.equals("")){
            if (validationErrors==null){
                validationErrors = new String[0];
            }
            validationErrors = reger.core.Util.addToStringArray(validationErrors, validationError);
        }
    }

}
