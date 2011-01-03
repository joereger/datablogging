package reger.dao.validators;

import reger.dao.hibernate.Validator;
import reger.dao.hibernate.HibValEx;

/**
 * Validation
 */
public class Groups implements Validator {

    public void validate(Object entity) throws HibValEx {
        HibValEx vex = new HibValEx("");
        if (entity instanceof reger.dao.Groups){
            reger.dao.Groups group = (reger.dao.Groups)entity;
            reger.core.Debug.debug(5, "reger.dao.validators.Groups.java", "custom validator called: " + entity.getClass().getName());
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
