package reger.acl;

import reger.cache.jboss.Cacheable;

/**
 * This class represents a single permission that an accountuser can do.
 */
@Cacheable
public class AccountUserAcl implements java.io.Serializable {

    public int aclobjectid;
    public String aclobjectname;
    public int accountid;

}
