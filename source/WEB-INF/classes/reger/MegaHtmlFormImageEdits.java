package reger;

import reger.Media.MediaType;
import reger.Media.MediaTypeFactory;
import reger.core.Debug;


public class MegaHtmlFormImageEdits {

    public static boolean saveEdits(reger.UserSession userSession, reger.pageFramework.PageProps pageProps, javax.servlet.http.HttpServletRequest request){
        if (pageProps.action.equals("editsubmit")) {

            //reger.core.Util.logtodb("Made it to edit image: pageProps.action=" + pageProps.action);

            //Do Updates to the images first
            //-----------------------------------
            //-----------------------------------
            String[][] rstImagelistUpdate= reger.core.db.Db.RunSQL("SELECT imageid, description, image FROM image WHERE eventid='"+ pageProps.entry.eventid +"'");
            //-----------------------------------
            //-----------------------------------
            if (rstImagelistUpdate!=null){
                for(int i=0; i<rstImagelistUpdate.length; i++){
                    //reger.core.Util.logtodb("MegaHtmlFormImageEdits - imageid=" + rstImagelistUpdate[i][0]);
                    //Get the imagetags
                    String imagetag = "";
                    if (request.getParameter("imagetag-" + rstImagelistUpdate[i][0])!=null && !request.getParameter("imagetag-" + rstImagelistUpdate[i][0]).equals("")) {
                        imagetag= request.getParameter("imagetag-" + rstImagelistUpdate[i][0]);
                    }
                    //Save the tags
                    reger.Tag.addMultipleTagsToImage(imagetag, Integer.parseInt(rstImagelistUpdate[i][0]));

//                    //Add new imagecategories if we have them
//                    if (request.getParameter("newimagecategory-" + rstImagelistUpdate[i][0])!=null && !request.getParameter("newimagecategory-" + rstImagelistUpdate[i][0]).equals("")) {
//
//                        //Try to get from DB in case it already exists
//                        //-----------------------------------
//                        //-----------------------------------
//                        String[][] rstCheckIC= reger.core.Db.Db.RunSQL("SELECT imagecategoryid FROM imagecategory WHERE accountid='"+ userSession.getAccount().getAccountid() +"' AND imagecategory='"+ request.getParameter("newimagecategory-" + rstImagelistUpdate[i][0]) +"'");
//                        //-----------------------------------
//                        //-----------------------------------
//                        if (rstCheckIC!=null && rstCheckIC.length>0){
//                            imagecategoryidforscreen=Integer.parseInt(rstCheckIC[0][0]);
//                        } else {
//                            //Create the new imagecategory
//                            //-----------------------------------
//                            //-----------------------------------
//                            int identity = reger.core.Db.Db.RunSQLInsert("INSERT INTO imagecategory(imagecategory, accountid) VALUES('"+ reger.core.Util.cleanForSQL(request.getParameter("newimagecategory-" + rstImagelistUpdate[i][0])) +"', '"+ userSession.getAccount().getAccountid() +"')");
//                            //-----------------------------------
//                            //-----------------------------------
//
//                            //Make sure this is updated
//                            imagecategoryidforscreen=identity;
//                        }
//                    }
//
//                    //reger.core.Util.logtodb("<br>imageid:" + rstImagelistUpdate[i][0] + "<br>imagecategoryid:" + rstImagelistUpdate[i][2] + "<br>imagecategoryidforscreen:" + imagecategoryidforscreen);


                    //If we have edits, save them
                    if ( (request.getParameter("imagedescription-" + rstImagelistUpdate[i][0])!=null && !request.getParameter("imagedescription-" + rstImagelistUpdate[i][0]).equals(rstImagelistUpdate[i][1]))  && (request.getParameter("action")!=null && request.getParameter("action").equals("editsubmit")) ) {

                        //Make the updates to the description and the imagecategory
                        //-----------------------------------
                        //-----------------------------------
                        int count = reger.core.db.Db.RunSQLUpdate("UPDATE image SET description='"+ reger.core.Util.cleanForSQL(request.getParameter("imagedescription-" + rstImagelistUpdate[i][0])) +"' WHERE imageid='"+ rstImagelistUpdate[i][0] +"'");
                        //-----------------------------------
                        //-----------------------------------

                    }

                    //If we have deletes, let's delete them
                    if (request.getParameter("delete-" + rstImagelistUpdate[i][0])!=null && request.getParameter("delete-" + rstImagelistUpdate[i][0]).equals("yes")) {
                        

                        //-----------------------------------
                        //-----------------------------------
                        int count = reger.core.db.Db.RunSQLUpdate("DELETE FROM image WHERE imageid='"+ rstImagelistUpdate[i][0] +"'");
                        //-----------------------------------
                        //-----------------------------------

                        //Get a MediaType handler and call its deleteData() method
                        String incomingnameext = reger.core.Util.getFilenameExtension(rstImagelistUpdate[i][2]);
                        MediaType mt = MediaTypeFactory.getHandlerByFileExtension(incomingnameext);
                        mt.deleteData(Integer.parseInt(rstImagelistUpdate[i][0]));

                        //Update the AccountCounts cache
                        reger.cache.AccountCountCache.flushByAccountid(userSession.getAccount().getAccountid());

                        //reger.core.Util.logtodb("DELETE FROM image WHERE imageid='"+ rstImagelistUpdate[i][0] +"'");

                    } else {//End deleting
                        //Move this image up or down if we have to
                        if (request.getParameter("imageid-" + rstImagelistUpdate[i][0] + "-move")!=null && request.getParameter("imageid-" + rstImagelistUpdate[i][0] + "-move").equals("up")) {
                            reger.ImageOrder.moveImageidUp(Integer.parseInt(rstImagelistUpdate[i][0]), pageProps.entry.eventid);
                        } else if (request.getParameter("imageid-" + rstImagelistUpdate[i][0] + "-move")!=null && request.getParameter("imageid-" + rstImagelistUpdate[i][0] + "-move").equals("down")) {
                            reger.ImageOrder.moveImageidDown(Integer.parseInt(rstImagelistUpdate[i][0]), pageProps.entry.eventid);
                        }
                    }

                }
            } //End update of images
        }
        return true;
    }


}
