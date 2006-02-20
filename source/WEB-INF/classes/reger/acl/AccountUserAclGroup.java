package reger.acl;

import reger.cache.providers.jboss.Cacheable;

/**
 * This class represents a single permission that an accountuser can do.
 */
@Cacheable
public class AccountUserAclGroup {

    public String aclgroupname;
    public int aclgroupid;
    public int accountid;

}
