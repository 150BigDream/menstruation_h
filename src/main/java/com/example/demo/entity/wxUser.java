package com.example.demo.entity;

public class wxUser {
    public String openID;
    public int intervalDay;//间隔多少天来一次
    public int sustainDay;//一次来多少天

    public String getOpenID() {
        return openID;
    }

    public void setOpenID(String openID) {
        this.openID = openID;
    }

    public int getIntervalDay() {
        return intervalDay;
    }

    public void setIntervalDay(int intervalDay) {
        this.intervalDay = intervalDay;
    }

    public int getSustainDay() {
        return sustainDay;
    }

    public void setSustainDay(int sustainDay) {
        this.sustainDay = sustainDay;
    }
}
