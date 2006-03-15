package reger.hibernate;

import reger.core.ValidationException;
import org.hibernate.HibernateException;
import org.hibernate.event.EventSource;
import org.hibernate.persister.entity.EntityPersister;

/**
 * Does the work of validation... is called by wrapper objects
 * that are hibernate event listeners.
 */
public class ValidateWorker {

    public static void validate(Object entity) throws HibValEx{

        reger.core.Debug.debug(3, "ValidateWorker.java", "validate() called: " + entity.getClass().getName());

        if (entity!=null){
            String fq_classname = entity.getClass().getName();
            try{
                fq_classname = fq_classname.replaceAll("reger.dao.hibernate.", "reger.dao.validators.");
                reger.core.Debug.debug(3, "ValidateWorker.java", "Looking for validator here: " + fq_classname);

                reger.hibernate.Validator validator = (reger.hibernate.Validator)(Class.forName(fq_classname).newInstance());

                try{
                    validator.validate(entity);
                } catch (ValidationException vex){
                    HibernateException hex = new HibernateException(vex.getErrorsAsSingleString());
                    throw hex;
                }

            } catch (HibernateException h){
                throw h;
            } catch (Exception e){
                reger.core.Debug.debug(3, "ValidateWorker.java", "No validator here: " + fq_classname + " e="+e.getMessage());
            }
        }
    }


}
