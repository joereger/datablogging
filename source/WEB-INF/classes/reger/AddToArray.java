package reger;

import reger.acl.AclObject;
import reger.acl.AclGroup;
import reger.nestednav.NestedNavItem;
import reger.mega.FieldQueryElement;
import reger.mega.MegaChartSeries;
import reger.nav.NavButton;
import reger.demos.DemoCategory;
import reger.versioninfo.Version;
import org.apache.commons.fileupload.FileItem;

/**
 * A class used to add elements to arrays of various types.
 * This will go away when I migrate to Java 1.5 and its generic types
 */
public class AddToArray {


    /*
	 * Adds a row to the Object array src with the value of String str
	 */
	public static AclObject[] addToAclObjectArray(AclObject[] src, AclObject str){
		if (src==null){
            src=new AclObject[0];
        }

		AclObject[] outArr = new AclObject[src.length+1];
		for(int i=0; i < src.length; i++) {
			outArr[i]=src[i];
		}
		outArr[src.length]=str;
		return outArr;
	}

	public static FileItem[] addToFileItemArray(FileItem[] src, FileItem str){
		if (src==null){
            src=new FileItem[0];
        }

		FileItem[] outArr = new FileItem[src.length+1];
		for(int i=0; i < src.length; i++) {
			outArr[i]=src[i];
		}
		outArr[src.length]=str;
		return outArr;
	}

    /*
	 * Adds a row to the Object array src with the value of String str
	 */
	public static AclGroup[] addToAclGroupArray(AclGroup[] src, AclGroup str){
		if (src==null){
            src=new AclGroup[0];
        }

		AclGroup[] outArr = new AclGroup[src.length+1];
		for(int i=0; i < src.length; i++) {
			outArr[i]=src[i];
		}
		outArr[src.length]=str;
		return outArr;
	}

	

    /*
	 * Adds a row to the Object array src with the value of String str
	 */
	public static NestedNavItem[] addToNestedNavItemArray(NestedNavItem[] src, NestedNavItem str){
		if (src==null){
            src=new NestedNavItem[0];
        }

		NestedNavItem[] outArr = new NestedNavItem[src.length+1];
		for(int i=0; i < src.length; i++) {
			outArr[i]=src[i];
		}
		outArr[src.length]=str;
		return outArr;
	}

    /*
	 * Adds a row to the Object array src with the value of String str
	 */
	public static FieldQueryElement[] addFieldQueryElementArray(FieldQueryElement[] src, FieldQueryElement str){
		if (src==null){
            src=new FieldQueryElement[0];
        }

		FieldQueryElement[] outArr = new FieldQueryElement[src.length+1];
		for(int i=0; i < src.length; i++) {
			outArr[i]=src[i];
		}
		outArr[src.length]=str;
		return outArr;
	}

    /*
	 * Adds a row to the Object array src with the value of String str
	 */
	public static NavButton[] addToNavButtonArray(NavButton[] src, NavButton str){
		if (src==null){
            src=new NavButton[0];
        }

		NavButton[] outArr = new NavButton[src.length+1];
		for(int i=0; i < src.length; i++) {
			outArr[i]=src[i];
		}
		outArr[src.length]=str;
		return outArr;
	}

    public static MegaChartSeries[] addToMegaChartSeriesArray(MegaChartSeries[] src, MegaChartSeries str){
		//If the source isn't null
		if (src!=null){
            MegaChartSeries[] outArr = new MegaChartSeries[src.length+1];
            for(int i=0; i < src.length; i++) {
                outArr[i]=src[i];
            }
            outArr[src.length]=str;
            return outArr;
        //If the source is null, create an array, append str and return
        } else {
            MegaChartSeries[] outArr = new MegaChartSeries[1];
            outArr[0]=str;
            return outArr;
        }
	}

    public static reger.demos.Demo[] addToDemoArray(reger.demos.Demo[] src, reger.demos.Demo str){
		//If the source isn't null
		if (src!=null){
            reger.demos.Demo[] outArr = new reger.demos.Demo[src.length+1];
            for(int i=0; i < src.length; i++) {
                outArr[i]=src[i];
            }
            outArr[src.length]=str;
            return outArr;
        //If the source is null, create an array, append str and return
        } else {
            reger.demos.Demo[] outArr = new reger.demos.Demo[1];
            outArr[0]=str;
            return outArr;
        }
	}

    public static DemoCategory[] addToDemoCategoryArray(DemoCategory[] src, DemoCategory str){
		//If the source isn't null
		if (src!=null){
            DemoCategory[] outArr = new DemoCategory[src.length+1];
            for(int i=0; i < src.length; i++) {
                outArr[i]=src[i];
            }
            outArr[src.length]=str;
            return outArr;
        //If the source is null, create an array, append str and return
        } else {
            DemoCategory[] outArr = new DemoCategory[1];
            outArr[0]=str;
            return outArr;
        }
	}

    /*
	 * Adds a row to the String array src with the value of String str
	 */
	public static Version[] addToVersionArray(Version[] src, Version str){
		//If the source isn't null
		if (src!=null){
            Version[] outArr = new Version[src.length+1];
            for(int i=0; i < src.length; i++) {
                outArr[i]=src[i];
            }
            outArr[src.length]=str;
            return outArr;
        //If the source is null, create an array, append str and return
        } else {
            Version[] outArr = new Version[1];
            outArr[0]=str;
            return outArr;
        }
	}

    public static Location[] addToLocationArray(Location[] src, Location str){
		//If the source isn't null
		if (src!=null){
            Location[] outArr = new Location[src.length+1];
            for(int i=0; i < src.length; i++) {
                outArr[i]=src[i];
            }
            outArr[src.length]=str;
            return outArr;
        //If the source is null, create an array, append str and return
        } else {
            Location[] outArr = new Location[1];
            outArr[0]=str;
            return outArr;
        }
	}

	public static String[] addToStringArray(String[] src, String str){
		//If the source isn't null
		if (src!=null){
            String[] outArr = new String[src.length+1];
            for(int i=0; i < src.length; i++) {
                outArr[i]=src[i];
            }
            outArr[src.length]=str;
            return outArr;
        //If the source is null, create an array, append str and return
        } else {
            String[] outArr = new String[1];
            outArr[0]=str;
            return outArr;
        }
	}

    /*
	 * Adds a row to the String array src with the value of String str
	 */
	public static Entry[] addToEntryArray(Entry[] src, Entry str){
		//If the source isn't null
		if (src!=null){
            Entry[] outArr = new Entry[src.length+1];
            for(int i=0; i < src.length; i++) {
                outArr[i]=src[i];
            }
            outArr[src.length]=str;
            return outArr;
        //If the source is null, create an array, append str and return
        } else {
            Entry[] outArr = new Entry[1];
            outArr[0]=str;
            return outArr;
        }
	}

    public static PrivateLabelPeerRelationship[] addToPeerRelationshipArray(PrivateLabelPeerRelationship[] src, PrivateLabelPeerRelationship str){
		//If the source isn't null
		if (src!=null){
            PrivateLabelPeerRelationship[] outArr = new PrivateLabelPeerRelationship[src.length+1];
            for(int i=0; i < src.length; i++) {
                outArr[i]=src[i];
            }
            outArr[src.length]=str;
            return outArr;
        //If the source is null, create an array, append str and return
        } else {
            PrivateLabelPeerRelationship[] outArr = new PrivateLabelPeerRelationship[1];
            outArr[0]=str;
            return outArr;
        }
	}

    public static PrivateLabel[] addToPrivateLabelArray(PrivateLabel[] src, PrivateLabel str){
		//If the source isn't null
		if (src!=null){
            PrivateLabel[] outArr = new PrivateLabel[src.length+1];
            for(int i=0; i < src.length; i++) {
                outArr[i]=src[i];
            }
            outArr[src.length]=str;
            return outArr;
        //If the source is null, create an array, append str and return
        } else {
            PrivateLabel[] outArr = new PrivateLabel[1];
            outArr[0]=str;
            return outArr;
        }
	}

    public static SystemMessage[] addToSystemMessageArray(SystemMessage[] src, SystemMessage str){
		//If the source isn't null
		if (src!=null){
            SystemMessage[] outArr = new SystemMessage[src.length+1];
            for(int i=0; i < src.length; i++) {
                outArr[i]=src[i];
            }
            outArr[src.length]=str;
            return outArr;
        //If the source is null, create an array, append str and return
        } else {
            SystemMessage[] outArr = new SystemMessage[1];
            outArr[0]=str;
            return outArr;
        }
	}

    /*
	 * Adds a row to the Object array src with the value of String str
	 */
	public static MegaLogType[] addToMegaLogTypeArray(MegaLogType[] src, MegaLogType str){
		if (src==null){
            src=new MegaLogType[0];
        }

		MegaLogType[] outArr = new MegaLogType[src.length+1];
		for(int i=0; i < src.length; i++) {
			outArr[i]=src[i];
		}
		outArr[src.length]=str;
		return outArr;
	}

    public static reger.template.Template[] addToTemplateArray(reger.template.Template[] src, reger.template.Template str){
		if (src==null){
            src=new reger.template.Template[0];
        }

		reger.template.Template[] outArr = new reger.template.Template[src.length+1];
		for(int i=0; i < src.length; i++) {
			outArr[i]=src[i];
		}
		outArr[src.length]=str;
		return outArr;
	}

	public static reger.template.TemplateTag[] addToTemplateTagArray(reger.template.TemplateTag[] src, reger.template.TemplateTag str){
		if (src==null){
            src=new reger.template.TemplateTag[0];
        }

		reger.template.TemplateTag[] outArr = new reger.template.TemplateTag[src.length+1];
		for(int i=0; i < src.length; i++) {
			outArr[i]=src[i];
		}
		outArr[src.length]=str;
		return outArr;
	}



    /*
    * Adds a row to the Object array src with the value of String str
    */
    public static reger.search.SearchResult[] addToSearchResultArray(reger.search.SearchResult[] src, reger.search.SearchResult str){
        if (src==null){
            src=new reger.search.SearchResult[0];
        }

        reger.search.SearchResult[] outArr = new reger.search.SearchResult[src.length+1];
        for(int i=0; i < src.length; i++) {
            outArr[i]=src[i];
        }
        outArr[src.length]=str;
        return outArr;
    }
}
