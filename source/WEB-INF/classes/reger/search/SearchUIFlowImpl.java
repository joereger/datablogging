package reger.search;

/**
 * Advanced search flow
 */
public class SearchUIFlowImpl implements SearchUIFlow{

    SearchUIChunk[] flow;

    public SearchUIFlowImpl(){
    
    }


    public SearchUIChunk get(String currentUniqueId){
        for (int i = 0; i < flow.length; i++) {
            if (flow[i].getUniqueIdentifier().equals(currentUniqueId)){
                return flow[i];
            }
        }
        return null;
    }



    public SearchUIChunk getNext(String currentUniqueId){
        for (int i = 0; i < flow.length; i++) {
            if (flow[i].getUniqueIdentifier().equals(currentUniqueId)){
                if ((i+1)<flow.length){
                    return flow[i+1];
                }
            }
        }
        return flow[flow.length-1];
    }

    public SearchUIChunk getPrevious(String currentUniqueId){
        for (int i = (flow.length-1); i >= 0; i=i-1) {
            if (flow[i].getUniqueIdentifier().equals(currentUniqueId)){
                if ((i-1)>0){
                    return flow[i-1];
                }
            }
        }
        return flow[0];
    }

    public SearchUIChunk[] getFlow(){
        return flow;
    }

    public boolean isFirst(String currentUniqueId) {
        if (flow[0].getUniqueIdentifier().equals(currentUniqueId)){
            return true;
        }
        return false;
    }

    public boolean isLast(String currentUniqueId) {
        if (flow[flow.length-1].getUniqueIdentifier().equals(currentUniqueId)){
            return true;
        }
        return false;
    }

}
