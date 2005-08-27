package reger.demos;

import reger.AddToArray;

/**
 * A category of demo.
 */
public class DemoCategory {

    private String categoryName = "";
    private Demo[] demos;

    public DemoCategory(String categoryName){
        this.categoryName = categoryName;
    }

    public void addDemo(Demo demo){
        demos = AddToArray.addToDemoArray(demos, demo);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Demo[] getDemos() {
        return demos;
    }

    public void setDemos(Demo[] demos) {
        this.demos = demos;
    }

}
