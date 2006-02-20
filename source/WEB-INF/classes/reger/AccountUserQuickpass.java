package reger;

import reger.cache.providers.jboss.Cacheable;

/**
 * This class represents a single permission that an accountuser can do.
 */
@Cacheable
public class AccountUserQuickpass {

    public String quickpass;
    public int accountid;

}
