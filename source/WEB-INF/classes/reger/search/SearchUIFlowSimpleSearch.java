package reger.search;

/**
 * Advanced search flow
 */
public class SearchUIFlowSimpleSearch extends SearchUIFlowImpl implements SearchUIFlow{

    public SearchUIFlowSimpleSearch(){
        flow = new SearchUIChunk[2];
        flow[0]=new SearchUIChunkKeywords();
        flow[1]=new SearchUIChunkResults();
    }

}
