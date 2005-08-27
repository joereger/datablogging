package reger.acl;

import reger.core.db.Db;
import reger.AddToArray;

/**
 * A group.
 */
public class AclGroup {

    private int aclgroupid;
    private String aclgroupname;
    private AclObject[] aclObjectsThisGroupCanDo;

    public AclGroup(int aclgroupid){
        loadGroupInfo(aclgroupid);
        loadAclObjects();
    }

    public AclGroup(String aclgroupname){
        int aclgroupid = -1;
        //-----------------------------------
        //-----------------------------------
        String[][] rstId= Db.RunSQL("SELECT aclgroupid FROM aclgroup WHERE aclgroupname='"+reger.core.Util.cleanForSQL(aclgroupname)+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstId!=null && rstId.length>0){
        	for(int i=0; i<rstId.length; i++){
        	    aclgroupid = Integer.parseInt(rstId[i][0]);
        	}
        }
        loadGroupInfo(aclgroupid);
        loadAclObjects();
    }

    private void loadGroupInfo(int aclgroupid){
        //-----------------------------------
        //-----------------------------------
        String[][] rstGroup= Db.RunSQL("SELECT aclgroupid, aclgroupname FROM aclgroup WHERE aclgroupid='"+aclgroupid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstGroup!=null && rstGroup.length>0){
        	for(int i=0; i<rstGroup.length; i++){
                this.aclgroupid = Integer.parseInt(rstGroup[i][0]);
                this.aclgroupname = rstGroup[i][1];
        	}
        }
    }

    private void loadAclObjects(){
        aclObjectsThisGroupCanDo = new AclObject[0];
        //-----------------------------------
        //-----------------------------------
        String[][] rstAcls= Db.RunSQL("SELECT aclobjectid FROM aclgroupmembershipgrants WHERE aclgroupid='"+this.aclgroupid+"'");
        //-----------------------------------
        //-----------------------------------
        if (rstAcls!=null && rstAcls.length>0){
        	for(int i=0; i<rstAcls.length; i++){
        	    AclObject tmpAclObject = reger.acl.AllAclObjects.getAclObjectById(Integer.parseInt(rstAcls[i][0]));
                aclObjectsThisGroupCanDo = AddToArray.addToAclObjectArray(aclObjectsThisGroupCanDo, tmpAclObject);
        	    //reger.core.Util.logtodb("--Done adding aclobjectid=" + rstAcls[i][0] + " to aclObjectsThisGroupCanDo.length=" + aclObjectsThisGroupCanDo.length);
        	}
        }
    }

    public AclObject[] getAclObjectsThisGroupCanDo(){
        return aclObjectsThisGroupCanDo;
    }

    public int getAclgroupid() {
        return aclgroupid;
    }

    public String getAclgroupname() {
        return aclgroupname;
    }

}
