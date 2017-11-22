package com.example.administrator.android_study.model;

/**
 * Created by Administrator on 2017-11-21.
 */

public class Friend {
    private String name;
    private String phone;
    private int gender;

    public Friend(String name, String phone, int gender) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
