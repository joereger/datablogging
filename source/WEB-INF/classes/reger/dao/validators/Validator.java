package reger.dao.validators;

import reger.core.ValidationException;
import reger.dao.DAO;

/**
 * Validation class for a DAO
 */
public interface Validator {

    public void validate(DAO obj) throws ValidationException;

}
