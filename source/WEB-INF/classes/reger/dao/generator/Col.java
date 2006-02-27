package reger.dao.generator;

/**
 * Simple column class
 */
public class Col {

    private String colname = "";
    private String coltype = "";

    public Col(String colname, String coltype){
        this.colname = colname;
        this.coltype = coltype;   
    }

    public String getColname() {
        return colname;
    }

    public void setColname(String colname) {
        this.colname = colname;
    }

    public String getColtype() {
        return coltype;
    }

    public void setColtype(String coltype) {
        this.coltype = coltype;
    }
}
