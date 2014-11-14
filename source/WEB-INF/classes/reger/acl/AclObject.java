package reger.acl;

import reger.cache.providers.jboss.Cacheable;

/**
 * Represents a single AclObject.  A single thing that can be done in the system.
 */
@Cacheable
public class AclObject {

    public int aclobjectid;
    public String aclobjectname;
    public String aclfriendlyname;
    public String acldesc;

    public AclObject(){

    }



}
