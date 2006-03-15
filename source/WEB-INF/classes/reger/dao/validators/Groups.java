package reger.dao.validators;

import reger.hibernate.Validator;
import reger.hibernate.HibValEx;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.event.EventSource;

/**
 * Validation
 */
public class Groups implements Validator {

    public void validate(Object entity) throws HibValEx {
        HibValEx vex = new HibValEx("");
        if (entity instanceof reger.dao.hibernate.Groups){
            reger.dao.hibernate.Groups group = (reger.dao.hibernate.Groups)entity;
            reger.core.Debug.debug(3, "reger.dao.validators.Groups.java", "custom validator called: " + entity.getClass().getName());
            //Name can't be blank
            if (group.getName().equals("")){
                vex.addValidationError("Group name can not be blank.");
            }
            //Test
            vex.addValidationError("Just testing validation engine.");
        }
        if (vex.getErrors().length>0){
            throw vex;
        }
    }

}
