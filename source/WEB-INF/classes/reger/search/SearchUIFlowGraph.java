package reger.search;

/**
 * Advanced search flow
 */
public class SearchUIFlowGraph extends SearchUIFlowImpl implements SearchUIFlow{

    public SearchUIFlowGraph(){
        flow = new SearchUIChunk[7];
        flow[0]=new SearchUIChunkKeywords();
        flow[1]=new SearchUIChunkChooseAccounts();
        flow[2]=new SearchUIChunkChooseLogs();
        flow[3]=new SearchUIChunkMegadata();
        flow[4]=new SearchUIChunkDaterange();
        flow[5]=new SearchUIChunkLocations();
        flow[6]=new SearchUIChunkResults();
    }

}
