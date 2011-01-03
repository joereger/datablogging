package reger.dao.validators;


import reger.dao.hibernate.Validator;
import reger.dao.hibernate.HibValEx;

/**
 * Validator for the megalog dao
 */
public class Megalog implements Validator {

    public void validate(Object entity) throws HibValEx {
        HibValEx vex = new HibValEx("");
        if (entity instanceof reger.dao.Megalog){
            reger.dao.Megalog megalog = (reger.dao.Megalog)entity;
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
