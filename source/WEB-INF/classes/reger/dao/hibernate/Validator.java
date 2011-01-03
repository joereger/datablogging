package reger.dao.hibernate;

import reger.core.ValidationException;

/**
 * Simple validator interface
 */
public interface Validator {

    public void validate(Object entity) throws ValidationException;

}
