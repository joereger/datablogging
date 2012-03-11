package reger.mega;

import reger.cache.providers.jboss.Cacheable;

/**
 * Holds field location information
 */
@Cacheable
public class FieldOrder {

    private int megafieldid = 0;
    private int col = 1;
    private int order = 1;

    public FieldOrder(int megafieldid, int col, int order){
        this.megafieldid = megafieldid;
        this.col = col;
        this.order = order;
    }

    public int getMegafieldid() {
        return megafieldid;
    }

    public void setMegafieldid(int megafieldid) {
        this.megafieldid = megafieldid;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
