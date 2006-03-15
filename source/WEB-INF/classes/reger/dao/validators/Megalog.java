package reger.dao.validators;


import reger.hibernate.Validator;
import reger.hibernate.HibValEx;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.event.EventSource;

/**
 * Validator for the megalog dao
 */
public class Megalog implements Validator {

    public void validate(Object entity) throws HibValEx {
        HibValEx vex = new HibValEx("");
        if (entity instanceof reger.dao.hibernate.Megalog){
            reger.dao.hibernate.Megalog megalog = (reger.dao.hibernate.Megalog)entity;
            //Title can't be blank
            if (megalog.getName().equals("")){
                vex.addValidationError("Log name can not be blank.");
            }
            //Get the account
            if (megalog.getAccountid()==0){
                vex.addValidationError("Log must be associated with an account.");
            }
        }
        if (vex.getErrors().length>0){
            throw vex;
        }
    }



}
