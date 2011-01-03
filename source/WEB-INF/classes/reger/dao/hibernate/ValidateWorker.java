package reger.dao.hibernate;

import reger.core.ValidationException;
import org.hibernate.HibernateException;

/**
 * Does the work of validation... is called by wrapper objects
 * that are hibernate event listeners.
 */
public class ValidateWorker {

    public static void validate(Object entity) throws HibValEx{

        reger.core.Debug.debug(5, "ValidateWorker.java", "validate() called: " + entity.getClass().getName());

        if (entity!=null){
            String fq_classname = entity.getClass().getName();
            try{
                fq_classname = fq_classname.replaceAll("reger.dao.hibernate.", "reger.dao.validators.");
                reger.core.Debug.debug(5, "ValidateWorker.java", "Looking for validator here: " + fq_classname);

                reger.dao.hibernate.Validator validator = (reger.dao.hibernate.Validator)(Class.forName(fq_classname).newInstance());

                try{
                    validator.validate(entity);
                } catch (ValidationException vex){
                    HibernateException hex = new HibernateException(vex.getErrorsAsSingleString());
                    throw hex;
                }

            } catch (HibernateException h){
                throw h;
            } catch (Exception e){
                reger.core.Debug.debug(5, "ValidateWorker.java", "No validator here: " + fq_classname + " e="+e.getMessage());
            }
        }
    }


}
