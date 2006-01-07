package reger.acl;

import reger.core.db.Db;
import reger.cache.jboss.Cacheable;

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

//    public AclObject(int aclobjectid){
//        AclObject tmpAclObject = AllAclObjects.getAclObjectById(aclobjectid);
//        if (tmpAclObject!=null){
//            this.aclobjectid = tmpAclObject.aclobjectid;
//            this.aclobjectname = tmpAclObject.aclobjectname;
//            this.aclfriendlyname = tmpAclObject.aclfriendlyname;
//            this.acldesc = tmpAclObject.acldesc;
//        } else {
//            reger.core.Util.logtodb("AclObject.java - Null AclObject returned on aclobjectid=" + aclobjectid);
//        }
//    }

}
