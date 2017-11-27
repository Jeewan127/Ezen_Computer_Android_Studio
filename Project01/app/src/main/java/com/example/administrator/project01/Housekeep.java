package com.example.administrator.project01;

/**
 * Created by Administrator on 2017-11-21.
 */

public class Housekeep {
    private Integer id;
    private Integer cost;
    private Integer type;   //0 : 지출  1 : 입금
    private Integer year;
    private Integer month;
    private Integer day;

    public Housekeep(Integer id, Integer type, Integer cost, Integer year, Integer month, Integer day) {
        this.id = id;
        this.cost = cost;
        this.type = type;
        this.year = year;
        this.month = month;
        this.day = day;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}