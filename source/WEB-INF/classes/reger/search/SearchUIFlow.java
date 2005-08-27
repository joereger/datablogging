package reger.search;

/**
 * Defines the flow of a search process
 */
public interface SearchUIFlow {
    public SearchUIChunk get(String currentUniqueId);
    public SearchUIChunk getNext(String currentUniqueId);
    public SearchUIChunk getPrevious(String currentUniqueId);
    public SearchUIChunk[] getFlow();
    public boolean isFirst(String currentUniqueId);
    public boolean isLast(String currentUniqueId);
}
