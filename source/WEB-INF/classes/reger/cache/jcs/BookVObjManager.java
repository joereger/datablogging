package reger.cache.jcs;

import org.apache.jcs.JCS;

public class BookVObjManager {

    private static BookVObjManager instance;
    private static int checkedOut = 0;
    private static JCS bookCache;

    private BookVObjManager(){
        try{
            bookCache = JCS.getInstance("bookCache");
        } catch (Exception e){
            // Handle cache region initialization failure
        }

        // Do other initialization that may be necessary, such as getting
        // references to any data access classes we may need to populate
        // value objects later
    }

    /**
     * Singleton access point to the manager.
     */
    public static BookVObjManager getInstance()
    {
        synchronized (BookVObjManager.class)
        {
            if (instance == null)
            {
                instance = new BookVObjManager();
            }
        }

        synchronized (instance)
        {
            instance.checkedOut++;
        }

        return instance;
    }


    /**
         * Retrieves a BookVObj.  Default to look in the cache.
         */
        public BookVObj getBookVObj(int id)
        {
            return getBookVObj(id, true);
        }

        /**
         * Retrieves a BookVObj. Second argument decides whether to look
         * in the cache. Returns a new value object if one can't be
         * loaded from the database. Database cache synchronization is
         * handled by removing cache elements upon modification.
         */
        public BookVObj getBookVObj(int id, boolean fromCache)
        {
            BookVObj vObj = null;

            // First, if requested, attempt to load from cache

            if (fromCache){
                vObj = (BookVObj) bookCache.get("BookVObj" + id);
            }

            // Either fromCache was false or the object was not found, so
            // call loadBookVObj to create it

            if (vObj == null){
                vObj = loadBookVObj(id);
                reger.core.Debug.debug(3, "BookVObjManager.java", "Item not found in cache.");
            } else {
                reger.core.Debug.debug(3, "BookVObjManager.java", "Found item in cache.");
            }

            return  vObj;
        }

        /**
         * Creates a BookVObj based on the id of the BOOK table.  Data
         * access could be direct JDBC, some or mapping tool, or an EJB.
         */
        public BookVObj loadBookVObj(int id)
        {
            BookVObj vObj = new BookVObj();

            vObj.bookId = id;

            try{
                boolean found = false;

                // load the data and set the rest of the fields
                // set found to true if it was found

                found = true;

                // cache the value object if found

                if (found){
                    // could use the defaults like this
                    // bookCache.put( "BookVObj" + id, vObj );
                    // or specify special characteristics

                    // put to cache

                    bookCache.put("BookVObj" + id, vObj);
                }

            }catch (Exception e){
                // Handle failure putting object to cache
            }

            return vObj;
        }

        /**
     * Stores BookVObj's in database.  Clears old items and caches
     * new.
     */
    public int storeBookVObj(BookVObj vObj)
    {
        try
        {
            // since any cached data is no longer valid, we should
            // remove the item from the cache if it an update.

            if (vObj.bookId != 0)
            {
                bookCache.remove("BookVObj" + vObj.bookId);
            }

            // put the new object in the cache

            bookCache.put("BookVObj" + vObj.bookId, vObj);
        }
        catch (Exception e)
        {
            // Handle failure removing object or putting object to cache.
        }

        return 0;
    }




}
