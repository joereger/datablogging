package reger.search;

import reger.core.Debug;


public class SearchUIChunkFactory {
    /**
     * Accepts a fieldtype and returns a FieldType handler object.
     */
    public static SearchUIChunk getHandlerByUniqueIdentifier(String id){
        Debug.debug(5, "", "SearchUIChunkFactory.java - looking for: " + id);
        if (id!=null){
            //This is essentially a registry of all MediaType handlers
            SearchUIChunk[] chunkTypes = new SearchUIChunk[7];
            chunkTypes[0]=new SearchUIChunkChooseLogs();
            chunkTypes[1]=new SearchUIChunkChooseAccounts();
            chunkTypes[2]=new SearchUIChunkDaterange();
            chunkTypes[3]=new SearchUIChunkKeywords();
            chunkTypes[4]=new SearchUIChunkLocations();
            chunkTypes[5]=new SearchUIChunkMegadata();
            chunkTypes[6]=new SearchUIChunkResults();

            //Iterate the mediaType objects
            for (int i = 0; i < chunkTypes.length; i++) {
                if(chunkTypes[i].getUniqueIdentifier().equalsIgnoreCase(id)){
                    //This one's a match
                    Debug.debug(5, "", "SearchUIChunkFactory.java - found it... returning valid one.");
                    return chunkTypes[i];
                }
            }
        }

        //If you still haven't it, return keywords as a good starting point.
        Debug.debug(5, "", "SearchUIChunkFactory.java - couldn't find it.");
        return new SearchUIChunkKeywords();
    }
}


