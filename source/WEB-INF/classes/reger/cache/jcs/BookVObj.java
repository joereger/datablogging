package reger.cache.jcs;

import java.util.Date;
import java.io.Serializable;


public class BookVObj implements Serializable {

    public int bookId = 0;
    public String title;
    public String author;
    public String ISBN;
    public String price;
    public Date publishDate;

    public BookVObj()
    {
    }


}
