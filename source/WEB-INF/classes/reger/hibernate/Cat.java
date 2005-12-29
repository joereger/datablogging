package reger.hibernate;

/**
 * Test class for hibernate
 */
public class Cat {

    private long catid;
    private String name;
    private char sex;
    private float weight;

    public Cat() {
    }

    public long getCatid() {
        return catid;
    }

    private void setCatid(long catid) {
        this.catid = catid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

}
