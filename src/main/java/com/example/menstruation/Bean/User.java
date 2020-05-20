package com.example.menstruation.Bean;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userID;
    @Column(name = "username")
    private  String userName;
    @Column(name = "password")
    private String passWord;
    @Column(name = "sustainday")
    private Integer sustainDay;
    @Column(name = "intervalday")
    private Integer intervalDay;
    @Column(name = "fsustainday")
    private Integer fsustainDay;
    @Column(name = "fintervalday")
    private Integer fintervalDay;

    public Integer getFsustainDay() {
        return fsustainDay;
    }

    public void setFsustainDay(Integer fsustainDay) {
        this.fsustainDay = fsustainDay;
    }

    public Integer getFintervalDay() {
        return fintervalDay;
    }

    public void setFintervalDay(Integer fintervalDay) {
        this.fintervalDay = fintervalDay;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getSustainDay() {
        return sustainDay;
    }

    public void setSustainDay(Integer sustainDay) {
        this.sustainDay = sustainDay;
    }

    public Integer getIntervalDay() {
        return intervalDay;
    }

    public void setIntervalDay(Integer intervalDay) {
        this.intervalDay = intervalDay;
    }

}
