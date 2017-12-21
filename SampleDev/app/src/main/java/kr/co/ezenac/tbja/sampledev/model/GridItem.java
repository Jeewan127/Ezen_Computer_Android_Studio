package kr.co.ezenac.tbja.sampledev.model;

/**
 * Created by Administrator on 2017-12-14.
 */

public class GridItem {
    private String color;
    private String name;

    public GridItem(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
