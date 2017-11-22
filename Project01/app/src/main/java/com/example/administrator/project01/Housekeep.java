package com.example.administrator.project01;

/**
 * Created by Administrator on 2017-11-21.
 */

public class Housekeep {
    private Integer cost;
    private Integer type;   //0 : 지출  1 : 입금

    public Housekeep(Integer cost, Integer type) {
        this.cost = cost;
        this.type = type;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}